Java语法总结 - 线程

一提到线程好像是件很麻烦很复杂的事，事实上确实如此，涉及到线程的编程是很讲究技巧的。这就需要我们变换思维方式，了解线程机制的比较通用的技巧，写出高效的、不依赖于某个JVM实现的程序来。毕竟仅仅就Java而言，各个虚拟机的实现是不同的。学习线程时，最令我印象深刻的就是那种不确定性、没有保障性，各个线程的运行完全是以不可预料的方式和速度推进，有的一个程序运行了N次，其结果差异性很大。


1、什么是线程？线程是彼此互相独立的、能独立运行的子任务，并且每个线程都有自己的调用栈。所谓的多任务是通过周期性地将CPU时间片切换到不同的子任务，虽然从微观上看来，单核的CPU上同时只运行一个子任务，但是从宏观来看，每个子任务似乎是同时连续运行的。（但是JAVA的线程不是按时间片分配的，在本文的最后引用了一段网友翻译的JAVA原著中对线程的理解。）

2、在java中，线程指两个不同的内容：一是java.lang.Thread类的一个对象；另外也可以指线程的执行。线程对象和其他的对象一样，在堆上创建、运行、死亡。但不同之处是线程的执行是一个轻量级的进程，有它自己的调用栈。
可以这样想，每个调用栈都对应一个线程，每个线程又对应一个调用栈。
我们运行java程序时有一个入口函数main()函数，它对应的线程被称为主线程。一个新线程一旦被创建，就产生一个新调用栈，从原主线程中脱离，也就是与主线程并发执行。


4、当提到线程时，很少是有保障的。我们必须了解到什么是有保障的操作，什么是无保障的操作，以便设计的程序在各种jvm上都能很好地工作。比如，在某些jvm实现中，把java线程映射为本地操作系统的线程。这是java核心的一部分。

5、线程的创建。
创建线程有两种方式：
A、继承java.lang.Thread类。
    class ThreadTest extends Thread{
        public void run() {
            System.out.println ("someting run here！");
        }
        public void run(String s){
            System.out.println ("string in run is " + s);
        }
        public static void main (String[] args) {
            ThreadTest tt = new ThreadTest();
            tt.start();
            tt.run("it won't auto run!");
        }
    }

输出的结果比较有趣：
string in run is it won't auto run!
someting run here！
注意输出的顺序：好像与我们想象的顺序相反了！为什么呢？
一旦调用start()方法，必须给JVM点时间，让它配置进程。而在它配置完成之前，重载的run(String s)方法被调用了，结果反而先输出了“string in run is it won't auto run!”，这时tt线程完成了配置，输出了“someting run here！”。
这个结论是比较容易验证的：
修改上面的程序，在tt.start();后面加上语句for (int i = 0; i<10000; i++); 这样主线程开始执行运算量比较大的for循环了，只有执行完for循环才能运行后面的tt.run("it won't auto run!");语句。此时，tt线程和主线程并行执行了，已经有足够的时间完成线程的配置！因此先到一步！修改后的程序运行结果如下：
someting run here！
string in run is it won't auto run!
注意：这种输出结果的顺序是没有保障的！不要依赖这种结论！

没有参数的run()方法是自动被调用的，而带参数的run()是被重载的，必须显式调用。
这种方式的限制是：这种方式很简单，但不是个好的方案。如果继承了Thread类，那么就不能继承其他的类了，java是单继承结构的，应该把继承的机会留给别的类。除非因为你有线程特有的更多的操作。
Thread类中有许多管理线程的方法，包括创建、启动和暂停它们。所有的操作都是从run()方法开始，并且在run()方法内编写需要在独立线程内执行的代码。run()方法可以调用其他方法，但是执行的线程总是通过调用run()。

B、实现java.lang.Runnable接口。
    class ThreadTest implements Runnable {
        public void run() {
            System.out.println ("someting run here");
        }
        public static void main (String[] args) {
            ThreadTest tt = new ThreadTest();
        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);
        t1.start();
        t2.start();
            //new Thread(tt).start();
        }
    }

比第一种方法复杂一点，为了使代码被独立的线程运行，还需要一个Thread对象。这样就把线程相关的代码和线程要执行的代码分离开来。

另一种方式是：参数形式的匿名内部类创建方式，也是比较常见的。
    class ThreadTest{
        public static void main (String[] args) {
            Thread t = new Thread(new Runnable(){
                public void run(){
                    System.out.println ("anonymous thread");
                }
            });    
            
            t.start();
        }
    }
如果你对此方式的声明不感冒，请参看本人总结的内部类。

第一种方式使用无参构造函数创建线程，则当线程开始工作时，它将调用自己的run()方法。
第二种方式使用带参数的构造函数创建线程，因为你要告诉这个新线程使用你的run()方法，而不是它自己的。
如上例，可以把一个目标赋给多个线程，这意味着几个执行线程将运行完全相同的作业。

6、什么时候线程是活的？
在调用start()方法开始执行线程之前，线程的状态还不是活的。测试程序如下：
    class ThreadTest implements Runnable {
        public void run() {
            System.out.println ("someting run here");
        }
        public static void main (String[] args) {
            ThreadTest tt = new ThreadTest();
            Thread t1 = new Thread(tt);
            System.out.println (t1.isAlive());
            t1.start();
            System.out.println (t1.isAlive());
        }
    }

结果输出：
false
true
isAlive方法是确定一个线程是否已经启动，而且还没完成run()方法内代码的最好方法。

7、启动新线程。
线程的启动要调用start()方法，只有这样才能创建新的调用栈。而直接调用run()方法的话，就不会创建新的调用栈，也就不会创建新的线程，run()方法就与普通的方法没什么两样了！

8、给线程起个有意义的名字。
没有该线程命名的话，线程会有一个默认的名字，格式是：“Thread-”加上线程的序号，如：Thread-0
这看起来可读性不好，不能从名字分辨出该线程具有什么功能。下面是给线程命名的方式。
第一种：用setName()函数
第二种：选用带线程命名的构造器
    class ThreadTest implements Runnable{
        public void run(){
            System.out.println (Thread.currentThread().getName());
        }
        public static void main (String[] args) {
        ThreadTest tt = new ThreadTest();     
        //Thread t = new Thread (tt,"eat apple");
        Thread t = new Thread (tt);
        t.setName("eat apple");
        t.start();
        }
    }

9、“没有保障”的多线程的运行。下面的代码可能令人印象深刻。
    class ThreadTest implements Runnable{
        public void run(){
            System.out.println (Thread.currentThread().getName());
        }
        public static void main (String[] args) {
            ThreadTest tt = new ThreadTest();
            Thread[] ts =new Thread[10];
        
            for (int i =0; i < ts.length; i++)
                ts[i] = new Thread(tt);
                
            for (Thread t : ts)
                t.start();
        }
    }
在我的电脑上运行的结果是：
Thread-0
Thread-1
Thread-3
Thread-5
Thread-2
Thread-7
Thread-4
Thread-9
Thread-6
Thread-8
而且每次运行的结果都是不同的！继续引用前面的话，一旦涉及到线程，其运行多半是没有保障。这个保障是指线程的运行完全是由调度程序控制的，我们没法控制它的执行顺序，持续时间也没有保障，有着不可预料的结果。


10、线程的状态。
A、新状态。
实例化Thread对象，但没有调用start()方法时的状态。
ThreadTest tt = new ThreadTest();     
或者Thread t = new Thread (tt);
此时虽然创建了Thread对象，如前所述，但是它们不是活的，不能通过isAlive()测试。

B、就绪状态。
线程有资格运行，但调度程序还没有把它选为运行线程所处的状态。也就是具备了运行的条件，一旦被选中马上就能运行。
也是调用start()方法后但没运行的状态。此时虽然没在运行，但是被认为是活的，能通过isAlive()测试。而且在线程运行之后、或者被阻塞、等待或者睡眠状态回来之后，线程首先进入就绪状态。

C、运行状态。
从就绪状态池（注意不是队列，是池）中选择一个为当前执行进程时，该线程所处的状态。

D、等待、阻塞、睡眠状态。
这三种状态有一个共同点：线程依然是活的，但是缺少运行的条件，一旦具备了条就就可以转为就绪状态（不能直接转为运行状态）。另外，suspend()和stop()方法已经被废弃了，比较危险，不要再用了。

E、死亡状态。
一个线程的run()方法运行结束，那么该线程完成其历史使命，它的栈结构将解散，也就是死亡了。但是它仍然是一个Thread对象，我们仍可以引用它，就像其他对象一样！它也不会被垃圾回收器回收了，因为对该对象的引用仍然存在。
如此说来，即使run()方法运行结束线程也没有死啊！事实是，一旦线程死去，它就永远不能重新启动了，也就是说，不能再用start()方法让它运行起来！如果强来的话会抛出IllegalThreadStateException异常。如：
t.start();
t.start();
放弃吧，人工呼吸或者心脏起搏器都无济于事……线程也属于一次性用品。

11、阻止线程运行。
A、睡眠。sleep()方法
让线程睡眠的理由很多，比如：认为该线程运行得太快，需要减缓一下，以便和其他线程协调；查询当时的股票价格，每睡5分钟查询一次，可以节省带宽，而且即时性要求也不那么高。
用Thread的静态方法可以实现Thread.sleep(5*60*1000); 睡上5分钟吧。sleep的参数是毫秒。但是要注意sleep()方法会抛出检查异常InterruptedException，对于检查异常，我们要么声明，要么使用处理程序。
    try {
        Thread.sleep(20000);
    }
    catch (InterruptedException ie) {
        ie.printStackTrace();
    }
既然有了sleep()方法，我们是不是可以控制线程的执行顺序了！每个线程执行完毕都睡上一觉？这样就能控制线程的运行顺序了，下面是书上的一个例子：
    class ThreadTest implements Runnable{
        public void run(){
            for (int i = 1; i<4; i++){
                System.out.println (Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) { }
            }
        }
        public static void main (String[] args) {
            ThreadTest tt = new ThreadTest();
            Thread t0 = new Thread(tt,"Thread 0");
            Thread t1 = new Thread(tt,"Thread 1");
            Thread t2 = new Thread(tt,"Thread 2");
            t0.start();
            t1.start();
            t2.start();            
        }
    }

并且给出了结果：
Thread 0
Thread 1
Thread 2
Thread 0
Thread 1
Thread 2
Thread 0
Thread 1
Thread 2
也就是Thread 0  Thread 1 Thread 2 按照这个顺序交替出现，作者指出虽然结果和我们预料的似乎相同，但是这个结果是不可靠的。果然被我的双核电脑验证了：
Thread 0
Thread 1
Thread 2
Thread 2
Thread 0
Thread 1
Thread 1
Thread 0
Thread 2
看来线程真的很不可靠啊。但是尽管如此，sleep()方法仍然是保证所有线程都有运行机会的最好方法。至少它保证了一个线程进入运行之后不会一直到运行完位置。

时间的精确性。再强调一下，线程醒来之后不会进入运行状态，而是进入就绪状态。因此sleep()中指定的时间不是线程不运行的精确时间！不能依赖 sleep()方法提供十分精确的定时。我们可以看到很多应用程序用sleep()作为定时器，而且没什么不好的，确实如此，但是我们一定要知道 sleep()不能保证线程醒来就能马上进入运行状态，是不精确的。

sleep()方法是一个静态的方法，它所指的是当前正在执行的线程休眠一个毫秒数。看到某些书上的 Thread.currentThread().sleep(1000); ，其实是不必要的。Thread.sleep(1000);就可以了。类似于getName()方法不是静态方法，它必须针对具体某个线程对象，这时用取得当前线程的方法Thread.currentThread().getName();

B、线程优先级和让步。
线程的优先级。在大多数jvm实现中调度程序使用基于线程优先级的抢先调度机制。如果一个线程进入可运行状态，并且它比池中的任何其他线程和当前运行的进程的具有更高的优先级，则优先级较低的线程进入可运行状态，最高优先级的线程被选择去执行。

于是就有了这样的结论：当前运行线程的优先级通常不会比池中任何线程的优先级低。但是并不是所有的jvm的调度都这样，因此一定不能依赖于线程优先级来保证程序的正确操作，这仍然是没有保障的，要把线程优先级用作一种提高程序效率的方法，并且这种方法也不能依赖优先级的操作。

另外一个没有保障的操作是：当前运行的线程与池中的线程，或者池中的线程具有相同的优先级时，JVM的调度实现会选择它喜欢的线程。也许是选择一个去运行，直至其完成；或者用分配时间片的方式，为每个线程提供均等的机会。

优先级用正整数设置，通常为1-10，JVM从不会改变一个线程的优先级。默认情况下，优先级是5。Thread类具有三个定义线程优先级范围的静态最终常量：Thread.MIN_PRIORITY （为1） Thread.NORM_PRIORITY （为5） Thread.MAX_PRIORITY （为10）

静态Thread.yield()方法。
它的作用是让当前运行的线程回到可运行状态，以便让具有同等优先级的其他线程运行。用yield()方法的目的是让同等优先级的线程能适当地轮转。但是，并不能保证达到此效果！因为，即使当前变成可运行状态，可是还有可能再次被JVM选中！也就是连任。

非静态join()方法。
让一个线程加入到另一个线程的尾部。让B线程加入A线程，意味着在A线程运行完成之前，B线程不会进入可运行状态。
    Thread t = new Thread();
    t.start();
    t.join;
这段代码的意思是取得当前的线程，把它加入到t线程的尾部，等t线程运行完毕之后，原线程继续运行。书中的例子在我的电脑里效果很糟糕，看不出什么效果来。也许是CPU太快了，而且是双核的；也许是JDK1.6的原因？

12、没总结完。线程这部分很重要，内容也很多，看太快容易消化不良，偶要慢慢地消化掉……



附： java原著中对线程的解释。

e文原文：

Thread Scheduling

In Java technology,threads are usually preemptive,but not necessarily Time-sliced(the process of giving each thread an equal amount of CPU time).It is common mistake to believe that "preemptive" is a fancy word for "does time-slicing".

For the runtime on a Solaris Operating Environment platform,Java technology does not preempt threads of the same priority.However,the runtime on Microsoft Windows platforms uses time-slicing,so it preempts threads of the same priority and even threads of higher priority.Preemption is not guaranteed;however,most JVM implementations result in behavior that appears to be strictly preemptive.Across JVM implementations,there is no absolute guarantee of preemption or time-slicing.The only guarantees lie in the coder’s use of wait and sleep.

The model of a preemptive scheduler is that many threads might be runnable,but only one thread is actually running.This thread continues to run until it ceases to be runnable or another thread of higher priority becomes runnable.In the latter case,the lower priority thread is preempted by the thread of higher priority,which gets a chance to run instead.

A thread might cease to runnable (that is,because blocked) for a variety of reasons.The thread’s code can execute a Thread.sleep() call,deliberately asking the thread to pause for a fixed period of time.The thread might have to wait to access a resource and cannot continue until that resource become available.

All thread that are runnable are kept in pools according to priority.When a blocked thread becomes runnable,it is placed back into the appropriate runnable pool.Threads from the highest priority nonempty pool are given CPU time.

The last sentence is worded loosed because:
(1) In most JVM implementations,priorities seem to work in a preemptive manner,although there is no guarantee that priorities have any meaning at all;
(2) Microsoft Window’s values affect thread behavior so that it is possible that a Java Priority 4 thread might be running,in spite of the fact that a runnable Java Priority 5 thread is waiting for the CPU.
In reality,many JVMs implement pool as queues,but this is not guaranteed hehavior.

热心网友翻译的版本：

在java技术中，线程通常是抢占式的而不需要时间片分配进程（分配给每个线程相等的cpu时间的进程）。一个经常犯的错误是认为“抢占”就是“分配时间片”。
在Solaris平台上的运行环境中，相同优先级的线程不能相互抢占对方的cpu时间。但是，在使用时间片的windows平台运行环境中，可以抢占相同甚至更高优先级的线程的cpu时间。抢占并不是绝对的，可是大多数的JVM的实现结果在行为上表现出了严格的抢占。纵观JVM的实现，并没有绝对的抢占或是时间片，而是依赖于编码者对wait和sleep这两个方法的使用。
抢占式调度模型就是许多线程属于可以运行状态（等待状态），但实际上只有一个线程在运行。该线程一直运行到它终止进入可运行状态（等待状态）或是另一个具有更高优先级的线程变成可运行状态。在后一种情况下，底优先级的线程被高优先级的线程抢占，高优先级的线程获得运行的机会。
线程可以因为各种各样的原因终止并进入可运行状态（因为堵塞）。例如，线程的代码可以在适当时候执行Thread.sleep()方法，故意让线程中止；线程可能为了访问资源而不得不等待直到该资源可用为止。
所有可运行的线程根据优先级保持在不同的池中。一旦被堵塞的线程进入可运行状态，它将会被放回适当的可运行池中。非空最高优先级的池中的线程将获得cpu时间。
最后一个句子是不精确的，因为：
（1）在大多数的JVM实现中，虽然不能保证说优先级有任何意义，但优先级看起来象是用抢占方式工作。
（2）微软windows的评价影响线程的行为，以至尽管一个处于可运行状态的优先级为5的java线程正在等待cpu时间，但是一个优先级为4的java线程却可能正在运行。
实际上，许多JVM用队列来实现池，但没有保证行为。


Feedback
# re: Java语法总结 - 线程  回复  更多评论   
2007-10-26 10:06 by 翔南
先看一些 回来再看哈!
PS:能说说时间片的概念和作用么,偶操作系统米学好...
# re: Java语法总结 - 线程  回复  更多评论   
2007-10-26 12:13 by Raylong
@翔南
时间片轮转调度是一种最古老，最简单，最公平且使用最广的算法是时间片调度。每个进程被分配一个时间段，称作它的时间片，即该进程允许运行的时间。

如果在时间片结束时进程还在运行，则CPU将被剥夺并分配给另一个进程。如果进程在时间片结束前阻塞或结束，则CPU当即进行切换。调度程序所要做的就是维护一张就绪进程列表。

时间片轮转调度中唯一有趣的一点是时间片的长度。从一个进程切换到另一个进程是需要一定时间的--保存和装入寄存器值及内存映像，更新各种表格和队列等。假如进程切换(process switch) - 有时称为上下文切换(context switch)，需要5毫秒，再假设时间片设为20毫秒，则在做完20毫秒有用的工作之后，CPU将花费5毫秒来进行进程切换。CPU时间的20%被浪费在了管理开销上。

为了提高CPU效率，我们可以将时间片设为500毫秒。这时浪费的时间只有1%。但考虑在一个分时系统中，如果有十个交互用户几乎同时按下回车键，将发生什么情况？假设所有其他进程都用足它们的时间片的话，最后一个不幸的进程不得不等待5秒钟才获得运行机会。多数用户无法忍受一条简短命令要5秒钟才能做出响应。同样的问题在一台支持多道程序的个人计算机上也会发生。

结论可以归结如下：时间片设得太短会导致过多的进程切换，降低了CPU效率；而设得太长又可能引起对短的交互请求的响应变差。将时间片设为100毫秒通常是一个比较合理的折衷。

原文参见：
http://neu-nec.sy.ln.cn/ncourse/os/chapter2/section4/2.4.1.htm
# re: Java语法总结 - 线程  回复  更多评论   
2007-10-26 12:54 by Raylong
@翔南
你一提时间片，我又找资料一看，原来我理解的线程是按时间片轮转的是有问题的。应该是抢占式的，但是有的JVM实现把线程映射为OS的线程……总之是个复杂的问题。看看这个帖子：http://zhidao.baidu.com/question/27434715.html?fr=qrl3
在我的电脑上也不是“wy_desun ”说的效果，总之，很晕……
# re: Java语法总结 - 线程  回复  更多评论   
2007-10-30 21:48 by Matthew Chen
jvm是在底层用os实现thread的，所以线程问题在java中反而容易呈现因平台而异的现象，java能不能充分利用双核的硬件资源，是看对应的操作系统的实现的。
抢占和时间片，可以同时作为调度策略，所谓抢占，也不是优先执行，根据实现不同，可以是时间片加长，或者轮替几率加大。
# re: Java语法总结 - 线程  回复  更多评论   
2007-10-30 22:01 by Raylong
@Matthew Chen
原来是这样，依赖于具体的平台。这是java的平台无关性的一个例外吧，还有一处就是浮点数据类型的精度依赖于具体的芯片。
# re: Java语法总结 - 线程  回复  更多评论   
2007-10-31 20:20 by Matthew Chen
java的浮点数据类型几乎毫无精度性可言，只能适应于近似计算，这倒不一定和芯片有关吧，你可以上网看看，看过之后估计对浮点数一点信心都没有了。
java线程实现是基于平台特点的没错，但同样可以保证跨平台的线程设计准确可靠地运行（前提是你设计得对），毕竟多核模拟出的是和单核相似的不确定性的线程执行情况，而确定性的编程设计才是基于这个之上的。
# re: Java语法总结 - 线程  回复  更多评论   
2007-10-31 20:36 by Raylong
@Matthew Chen
我在基本数据类型总结中已经写了浮点数的精度只适用于工程计算等领域。
关于浮点数和芯片是否有关，你可以看看core java2里面的论述，他用intel的芯片表达浮点数的与众不同说明了浮点数的精度问题。
线程部分，上面已经有了“我们必须了解到什么是有保障的操作，什么是无保障的操作，以便设计的程序在各种jvm上都能很好地工作。”和你说的跨平台是一个意思，不同平台对应不同的jvm，同样的平台也有不同的jvm。
# re: Java语法总结 - 线程  回复  更多评论   
2007-12-18 12:20 by iampurse
谢谢了 。
正在找一些有关Thread得东西
这页收藏了 。
# re: Java语法总结 - 线程  回复  更多评论   
2008-08-26 15:35 by 天空之泪
兄弟，东西写的不错 ，很好！
# re: Java语法总结 - 线程[未登录]  回复  更多评论   
2008-10-12 07:34 by 明明
线程到底在什么时候用 或是 不用 我都不太明白啊 要怎么样才能真正的了解啊 402292747 这是我的qq好 希望那个有心人世可以给我讲解 在此
谢拉。。。
# re: Java语法总结 - 线程[未登录]  回复  更多评论   
2009-02-24 10:32 by 海浪
打扰了，作者。请问一下在
class ThreadTest{
public static void main (String[] args) {
Thread t = new Thread(new Runnable(){
public void run(){
System.out.println ("anonymous thread");
}
});

t.start();
}
}
这段代码中Runnable是一个接口，接口怎么可以用new Runnable()用于实例化呢？
不是很理解！
