Java�﷨�ܽ� - �߳�

һ�ᵽ�̺߳����Ǽ����鷳�ܸ��ӵ��£���ʵ��ȷʵ��ˣ��漰���̵߳ı���Ǻܽ������ɵġ������Ҫ���Ǳ任˼ά��ʽ���˽��̻߳��ƵıȽ�ͨ�õļ��ɣ�д����Ч�ġ���������ĳ��JVMʵ�ֵĳ��������Ͼ�������Java���ԣ������������ʵ���ǲ�ͬ�ġ�ѧϰ�߳�ʱ��������ӡ����̵ľ������ֲ�ȷ���ԡ�û�б����ԣ������̵߳�������ȫ���Բ���Ԥ�ϵķ�ʽ���ٶ��ƽ����е�һ������������N�Σ����������Ժܴ�


1��ʲô���̣߳��߳��Ǳ˴˻�������ġ��ܶ������е������񣬲���ÿ���̶߳����Լ��ĵ���ջ����ν�Ķ�������ͨ�������Եؽ�CPUʱ��Ƭ�л�����ͬ����������Ȼ��΢���Ͽ��������˵�CPU��ͬʱֻ����һ�������񣬵��ǴӺ��������ÿ���������ƺ���ͬʱ�������еġ�������JAVA���̲߳��ǰ�ʱ��Ƭ����ģ��ڱ��ĵ����������һ�����ѷ����JAVAԭ���ж��̵߳���⡣��

2����java�У��߳�ָ������ͬ�����ݣ�һ��java.lang.Thread���һ����������Ҳ����ָ�̵߳�ִ�С��̶߳���������Ķ���һ�����ڶ��ϴ��������С�����������֮ͬ�����̵߳�ִ����һ���������Ľ��̣������Լ��ĵ���ջ��
���������룬ÿ������ջ����Ӧһ���̣߳�ÿ���߳��ֶ�Ӧһ������ջ��
��������java����ʱ��һ����ں���main()����������Ӧ���̱߳���Ϊ���̡߳�һ�����߳�һ�����������Ͳ���һ���µ���ջ����ԭ���߳������룬Ҳ���������̲߳���ִ�С�


4�����ᵽ�߳�ʱ���������б��ϵġ����Ǳ����˽⵽ʲô���б��ϵĲ�����ʲô���ޱ��ϵĲ������Ա���Ƶĳ����ڸ���jvm�϶��ܺܺõع��������磬��ĳЩjvmʵ���У���java�߳�ӳ��Ϊ���ز���ϵͳ���̡߳�����java���ĵ�һ���֡�

5���̵߳Ĵ�����
�����߳������ַ�ʽ��
A���̳�java.lang.Thread�ࡣ
    class ThreadTest extends Thread{
        public void run() {
            System.out.println ("someting run here��");
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

����Ľ���Ƚ���Ȥ��
string in run is it won't auto run!
someting run here��
ע�������˳�򣺺��������������˳���෴�ˣ�Ϊʲô�أ�
һ������start()�����������JVM��ʱ�䣬�������ý��̡��������������֮ǰ�����ص�run(String s)�����������ˣ��������������ˡ�string in run is it won't auto run!������ʱtt�߳���������ã�����ˡ�someting run here������
��������ǱȽ�������֤�ģ�
�޸�����ĳ�����tt.start();����������for (int i = 0; i<10000; i++); �������߳̿�ʼִ���������Ƚϴ��forѭ���ˣ�ֻ��ִ����forѭ���������к����tt.run("it won't auto run!");��䡣��ʱ��tt�̺߳����̲߳���ִ���ˣ��Ѿ����㹻��ʱ������̵߳����ã�����ȵ�һ�����޸ĺ�ĳ������н�����£�
someting run here��
string in run is it won't auto run!
ע�⣺������������˳����û�б��ϵģ���Ҫ�������ֽ��ۣ�

û�в�����run()�������Զ������õģ�����������run()�Ǳ����صģ�������ʽ���á�
���ַ�ʽ�������ǣ����ַ�ʽ�ܼ򵥣������Ǹ��õķ���������̳���Thread�࣬��ô�Ͳ��ܼ̳����������ˣ�java�ǵ��̳нṹ�ģ�Ӧ�ðѼ̳еĻ�����������ࡣ������Ϊ�����߳����еĸ���Ĳ�����
Thread�������������̵߳ķ�����������������������ͣ���ǡ����еĲ������Ǵ�run()������ʼ��������run()�����ڱ�д��Ҫ�ڶ����߳���ִ�еĴ��롣run()�������Ե�����������������ִ�е��߳�����ͨ������run()��

B��ʵ��java.lang.Runnable�ӿڡ�
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

�ȵ�һ�ַ�������һ�㣬Ϊ��ʹ���뱻�������߳����У�����Ҫһ��Thread���������Ͱ��߳���صĴ�����߳�Ҫִ�еĴ�����뿪����

��һ�ַ�ʽ�ǣ�������ʽ�������ڲ��ഴ����ʽ��Ҳ�ǱȽϳ����ġ�
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
�����Դ˷�ʽ����������ð����ο������ܽ���ڲ��ࡣ

��һ�ַ�ʽʹ���޲ι��캯�������̣߳����߳̿�ʼ����ʱ�����������Լ���run()������
�ڶ��ַ�ʽʹ�ô������Ĺ��캯�������̣߳���Ϊ��Ҫ����������߳�ʹ�����run()���������������Լ��ġ�
�����������԰�һ��Ŀ�긳������̣߳�����ζ�ż���ִ���߳̽�������ȫ��ͬ����ҵ��

6��ʲôʱ���߳��ǻ�ģ�
�ڵ���start()������ʼִ���߳�֮ǰ���̵߳�״̬�����ǻ�ġ����Գ������£�
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

��������
false
true
isAlive������ȷ��һ���߳��Ƿ��Ѿ����������һ�û���run()�����ڴ������÷�����

7���������̡߳�
�̵߳�����Ҫ����start()������ֻ���������ܴ����µĵ���ջ����ֱ�ӵ���run()�����Ļ����Ͳ��ᴴ���µĵ���ջ��Ҳ�Ͳ��ᴴ���µ��̣߳�run()����������ͨ�ķ���ûʲô�����ˣ�

8�����߳��������������֡�
û�и��߳������Ļ����̻߳���һ��Ĭ�ϵ����֣���ʽ�ǣ���Thread-�������̵߳���ţ��磺Thread-0
�⿴�����ɶ��Բ��ã����ܴ����ֱַ�����߳̾���ʲô���ܡ������Ǹ��߳������ķ�ʽ��
��һ�֣���setName()����
�ڶ��֣�ѡ�ô��߳������Ĺ�����
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

9����û�б��ϡ��Ķ��̵߳����С�����Ĵ����������ӡ����̡�
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
���ҵĵ��������еĽ���ǣ�
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
����ÿ�����еĽ�����ǲ�ͬ�ģ���������ǰ��Ļ���һ���漰���̣߳������ж����û�б��ϡ����������ָ�̵߳�������ȫ���ɵ��ȳ�����Ƶģ�����û����������ִ��˳�򣬳���ʱ��Ҳû�б��ϣ����Ų���Ԥ�ϵĽ����


10���̵߳�״̬��
A����״̬��
ʵ����Thread���󣬵�û�е���start()����ʱ��״̬��
ThreadTest tt = new ThreadTest();     
����Thread t = new Thread (tt);
��ʱ��Ȼ������Thread������ǰ�������������ǲ��ǻ�ģ�����ͨ��isAlive()���ԡ�

B������״̬��
�߳����ʸ����У������ȳ���û�а���ѡΪ�����߳�������״̬��Ҳ���Ǿ߱������е�������һ����ѡ�����Ͼ������С�
Ҳ�ǵ���start()������û���е�״̬����ʱ��Ȼû�����У����Ǳ���Ϊ�ǻ�ģ���ͨ��isAlive()���ԡ��������߳�����֮�󡢻��߱��������ȴ�����˯��״̬����֮���߳����Ƚ������״̬��

C������״̬��
�Ӿ���״̬�أ�ע�ⲻ�Ƕ��У��ǳأ���ѡ��һ��Ϊ��ǰִ�н���ʱ�����߳�������״̬��

D���ȴ���������˯��״̬��
������״̬��һ����ͬ�㣺�߳���Ȼ�ǻ�ģ�����ȱ�����е�������һ���߱������;Ϳ���תΪ����״̬������ֱ��תΪ����״̬�������⣬suspend()��stop()�����Ѿ��������ˣ��Ƚ�Σ�գ���Ҫ�����ˡ�

E������״̬��
һ���̵߳�run()�������н�������ô���߳��������ʷʹ��������ջ�ṹ����ɢ��Ҳ���������ˡ���������Ȼ��һ��Thread���������Կ�����������������������һ������Ҳ���ᱻ���������������ˣ���Ϊ�Ըö����������Ȼ���ڡ�
���˵������ʹrun()�������н����߳�Ҳû����������ʵ�ǣ�һ���߳���ȥ��������Զ�������������ˣ�Ҳ����˵����������start()���������������������ǿ���Ļ����׳�IllegalThreadStateException�쳣���磺
t.start();
t.start();
�����ɣ��˹��������������������޼����¡����߳�Ҳ����һ������Ʒ��

11����ֹ�߳����С�
A��˯�ߡ�sleep()����
���߳�˯�ߵ����ɺܶ࣬���磺��Ϊ���߳����е�̫�죬��Ҫ����һ�£��Ա�������߳�Э������ѯ��ʱ�Ĺ�Ʊ�۸�ÿ˯5���Ӳ�ѯһ�Σ����Խ�ʡ�������Ҽ�ʱ��Ҫ��Ҳ����ô�ߡ�
��Thread�ľ�̬��������ʵ��Thread.sleep(5*60*1000); ˯��5���Ӱɡ�sleep�Ĳ����Ǻ��롣����Ҫע��sleep()�������׳�����쳣InterruptedException�����ڼ���쳣������Ҫô������Ҫôʹ�ô������
    try {
        Thread.sleep(20000);
    }
    catch (InterruptedException ie) {
        ie.printStackTrace();
    }
��Ȼ����sleep()�����������ǲ��ǿ��Կ����̵߳�ִ��˳���ˣ�ÿ���߳�ִ����϶�˯��һ�����������ܿ����̵߳�����˳���ˣ����������ϵ�һ�����ӣ�
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

���Ҹ����˽����
Thread 0
Thread 1
Thread 2
Thread 0
Thread 1
Thread 2
Thread 0
Thread 1
Thread 2
Ҳ����Thread 0  Thread 1 Thread 2 �������˳������֣�����ָ����Ȼ���������Ԥ�ϵ��ƺ���ͬ�������������ǲ��ɿ��ġ���Ȼ���ҵ�˫�˵�����֤�ˣ�
Thread 0
Thread 1
Thread 2
Thread 2
Thread 0
Thread 1
Thread 1
Thread 0
Thread 2
�����߳���ĺܲ��ɿ��������Ǿ�����ˣ�sleep()������Ȼ�Ǳ�֤�����̶߳������л������÷�������������֤��һ���߳̽�������֮�󲻻�һֱ��������λ�á�

ʱ��ľ�ȷ�ԡ���ǿ��һ�£��߳�����֮�󲻻��������״̬�����ǽ������״̬�����sleep()��ָ����ʱ�䲻���̲߳����еľ�ȷʱ�䣡�������� sleep()�����ṩʮ�־�ȷ�Ķ�ʱ�����ǿ��Կ����ܶ�Ӧ�ó�����sleep()��Ϊ��ʱ��������ûʲô���õģ�ȷʵ��ˣ���������һ��Ҫ֪�� sleep()���ܱ�֤�߳������������Ͻ�������״̬���ǲ���ȷ�ġ�

sleep()������һ����̬�ķ���������ָ���ǵ�ǰ����ִ�е��߳�����һ��������������ĳЩ���ϵ� Thread.currentThread().sleep(1000); ����ʵ�ǲ���Ҫ�ġ�Thread.sleep(1000);�Ϳ����ˡ�������getName()�������Ǿ�̬��������������Ծ���ĳ���̶߳�����ʱ��ȡ�õ�ǰ�̵߳ķ���Thread.currentThread().getName();

B���߳����ȼ����ò���
�̵߳����ȼ����ڴ����jvmʵ���е��ȳ���ʹ�û����߳����ȼ������ȵ��Ȼ��ơ����һ���߳̽��������״̬���������ȳ��е��κ������̺߳͵�ǰ���еĽ��̵ľ��и��ߵ����ȼ��������ȼ��ϵ͵��߳̽��������״̬��������ȼ����̱߳�ѡ��ȥִ�С�

���Ǿ����������Ľ��ۣ���ǰ�����̵߳����ȼ�ͨ������ȳ����κ��̵߳����ȼ��͡����ǲ��������е�jvm�ĵ��ȶ����������һ�������������߳����ȼ�����֤�������ȷ����������Ȼ��û�б��ϵģ�Ҫ���߳����ȼ�����һ����߳���Ч�ʵķ������������ַ���Ҳ�����������ȼ��Ĳ�����

����һ��û�б��ϵĲ����ǣ���ǰ���е��߳�����е��̣߳����߳��е��߳̾�����ͬ�����ȼ�ʱ��JVM�ĵ���ʵ�ֻ�ѡ����ϲ�����̡߳�Ҳ����ѡ��һ��ȥ���У�ֱ������ɣ������÷���ʱ��Ƭ�ķ�ʽ��Ϊÿ���߳��ṩ���ȵĻ��ᡣ

���ȼ������������ã�ͨ��Ϊ1-10��JVM�Ӳ���ı�һ���̵߳����ȼ���Ĭ������£����ȼ���5��Thread��������������߳����ȼ���Χ�ľ�̬���ճ�����Thread.MIN_PRIORITY ��Ϊ1�� Thread.NORM_PRIORITY ��Ϊ5�� Thread.MAX_PRIORITY ��Ϊ10��

��̬Thread.yield()������
�����������õ�ǰ���е��̻߳ص�������״̬���Ա��þ���ͬ�����ȼ��������߳����С���yield()������Ŀ������ͬ�����ȼ����߳����ʵ�����ת�����ǣ������ܱ�֤�ﵽ��Ч������Ϊ����ʹ��ǰ��ɿ�����״̬�����ǻ��п����ٴα�JVMѡ�У�Ҳ�������Ρ�

�Ǿ�̬join()������
��һ���̼߳��뵽��һ���̵߳�β������B�̼߳���A�̣߳���ζ����A�߳��������֮ǰ��B�̲߳�����������״̬��
    Thread t = new Thread();
    t.start();
    t.join;
��δ������˼��ȡ�õ�ǰ���̣߳��������뵽t�̵߳�β������t�߳��������֮��ԭ�̼߳������С����е��������ҵĵ�����Ч������⣬������ʲôЧ������Ҳ����CPU̫���ˣ�������˫�˵ģ�Ҳ����JDK1.6��ԭ��

12��û�ܽ��ꡣ�߳��ⲿ�ֺ���Ҫ������Ҳ�ܶ࣬��̫����������������żҪ����������������



���� javaԭ���ж��̵߳Ľ��͡�

e��ԭ�ģ�

Thread Scheduling

In Java technology,threads are usually preemptive,but not necessarily Time-sliced(the process of giving each thread an equal amount of CPU time).It is common mistake to believe that "preemptive" is a fancy word for "does time-slicing".

For the runtime on a Solaris Operating Environment platform,Java technology does not preempt threads of the same priority.However,the runtime on Microsoft Windows platforms uses time-slicing,so it preempts threads of the same priority and even threads of higher priority.Preemption is not guaranteed;however,most JVM implementations result in behavior that appears to be strictly preemptive.Across JVM implementations,there is no absolute guarantee of preemption or time-slicing.The only guarantees lie in the coder��s use of wait and sleep.

The model of a preemptive scheduler is that many threads might be runnable,but only one thread is actually running.This thread continues to run until it ceases to be runnable or another thread of higher priority becomes runnable.In the latter case,the lower priority thread is preempted by the thread of higher priority,which gets a chance to run instead.

A thread might cease to runnable (that is,because blocked) for a variety of reasons.The thread��s code can execute a Thread.sleep() call,deliberately asking the thread to pause for a fixed period of time.The thread might have to wait to access a resource and cannot continue until that resource become available.

All thread that are runnable are kept in pools according to priority.When a blocked thread becomes runnable,it is placed back into the appropriate runnable pool.Threads from the highest priority nonempty pool are given CPU time.

The last sentence is worded loosed because:
(1) In most JVM implementations,priorities seem to work in a preemptive manner,although there is no guarantee that priorities have any meaning at all;
(2) Microsoft Window��s values affect thread behavior so that it is possible that a Java Priority 4 thread might be running,in spite of the fact that a runnable Java Priority 5 thread is waiting for the CPU.
In reality,many JVMs implement pool as queues,but this is not guaranteed hehavior.

�������ѷ���İ汾��

��java�����У��߳�ͨ������ռʽ�Ķ�����Ҫʱ��Ƭ������̣������ÿ���߳���ȵ�cpuʱ��Ľ��̣���һ���������Ĵ�������Ϊ����ռ�����ǡ�����ʱ��Ƭ����
��Solarisƽ̨�ϵ����л����У���ͬ���ȼ����̲߳����໥��ռ�Է���cpuʱ�䡣���ǣ���ʹ��ʱ��Ƭ��windowsƽ̨���л����У�������ռ��ͬ�����������ȼ����̵߳�cpuʱ�䡣��ռ�����Ǿ��Եģ����Ǵ������JVM��ʵ�ֽ������Ϊ�ϱ��ֳ����ϸ����ռ���ݹ�JVM��ʵ�֣���û�о��Ե���ռ����ʱ��Ƭ�����������ڱ����߶�wait��sleep������������ʹ�á�
��ռʽ����ģ�;�������߳����ڿ�������״̬���ȴ�״̬������ʵ����ֻ��һ���߳������С����߳�һֱ���е�����ֹ���������״̬���ȴ�״̬��������һ�����и������ȼ����̱߳�ɿ�����״̬���ں�һ������£������ȼ����̱߳������ȼ����߳���ռ�������ȼ����̻߳�����еĻ��ᡣ
�߳̿�����Ϊ���ָ�����ԭ����ֹ�����������״̬����Ϊ�����������磬�̵߳Ĵ���������ʵ�ʱ��ִ��Thread.sleep()�������������߳���ֹ���߳̿���Ϊ�˷�����Դ�����ò��ȴ�ֱ������Դ����Ϊֹ��
���п����е��̸߳������ȼ������ڲ�ͬ�ĳ��С�һ�����������߳̽��������״̬�������ᱻ�Ż��ʵ��Ŀ����г��С��ǿ�������ȼ��ĳ��е��߳̽����cpuʱ�䡣
���һ�������ǲ���ȷ�ģ���Ϊ��
��1���ڴ������JVMʵ���У���Ȼ���ܱ�֤˵���ȼ����κ����壬�����ȼ���������������ռ��ʽ������
��2��΢��windows������Ӱ���̵߳���Ϊ����������һ�����ڿ�����״̬�����ȼ�Ϊ5��java�߳����ڵȴ�cpuʱ�䣬����һ�����ȼ�Ϊ4��java�߳�ȴ�����������С�
ʵ���ϣ����JVM�ö�����ʵ�ֳأ���û�б�֤��Ϊ��


Feedback
# re: Java�﷨�ܽ� - �߳�  �ظ�  ��������   
2007-10-26 10:06 by ����
�ȿ�һЩ �����ٿ���!
PS:��˵˵ʱ��Ƭ�ĸ��������ô,ż����ϵͳ��ѧ��...
# re: Java�﷨�ܽ� - �߳�  �ظ�  ��������   
2007-10-26 12:13 by Raylong
@����
ʱ��Ƭ��ת������һ������ϣ���򵥣��ƽ��ʹ�������㷨��ʱ��Ƭ���ȡ�ÿ�����̱�����һ��ʱ��Σ���������ʱ��Ƭ�����ý����������е�ʱ�䡣

�����ʱ��Ƭ����ʱ���̻������У���CPU�������Ტ�������һ�����̡����������ʱ��Ƭ����ǰ�������������CPU���������л������ȳ�����Ҫ���ľ���ά��һ�ž��������б�

ʱ��Ƭ��ת������Ψһ��Ȥ��һ����ʱ��Ƭ�ĳ��ȡ���һ�������л�����һ����������Ҫһ��ʱ���--�����װ��Ĵ���ֵ���ڴ�ӳ�񣬸��¸��ֱ��Ͷ��еȡ���������л�(process switch) - ��ʱ��Ϊ�������л�(context switch)����Ҫ5���룬�ټ���ʱ��Ƭ��Ϊ20���룬��������20�������õĹ���֮��CPU������5���������н����л���CPUʱ���20%���˷����˹������ϡ�

Ϊ�����CPUЧ�ʣ����ǿ��Խ�ʱ��Ƭ��Ϊ500���롣��ʱ�˷ѵ�ʱ��ֻ��1%����������һ����ʱϵͳ�У������ʮ�������û�����ͬʱ���»س�����������ʲô��������������������̶��������ǵ�ʱ��Ƭ�Ļ������һ�����ҵĽ��̲��ò��ȴ�5���ӲŻ�����л��ᡣ�����û��޷�����һ���������Ҫ5���Ӳ���������Ӧ��ͬ����������һ̨֧�ֶ������ĸ��˼������Ҳ�ᷢ����

���ۿ��Թ�����£�ʱ��Ƭ���̫�̻ᵼ�¹���Ľ����л���������CPUЧ�ʣ������̫���ֿ�������Զ̵Ľ����������Ӧ����ʱ��Ƭ��Ϊ100����ͨ����һ���ȽϺ�������ԡ�

ԭ�Ĳμ���
http://neu-nec.sy.ln.cn/ncourse/os/chapter2/section4/2.4.1.htm
# re: Java�﷨�ܽ� - �߳�  �ظ�  ��������   
2007-10-26 12:54 by Raylong
@����
��һ��ʱ��Ƭ������������һ����ԭ���������߳��ǰ�ʱ��Ƭ��ת����������ġ�Ӧ������ռʽ�ģ������е�JVMʵ�ְ��߳�ӳ��ΪOS���̡߳�����֮�Ǹ����ӵ����⡣����������ӣ�http://zhidao.baidu.com/question/27434715.html?fr=qrl3
���ҵĵ�����Ҳ���ǡ�wy_desun ��˵��Ч������֮�����Ρ���
# re: Java�﷨�ܽ� - �߳�  �ظ�  ��������   
2007-10-30 21:48 by Matthew Chen
jvm���ڵײ���osʵ��thread�ģ������߳�������java�з������׳�����ƽ̨���������java�ܲ��ܳ������˫�˵�Ӳ����Դ���ǿ���Ӧ�Ĳ���ϵͳ��ʵ�ֵġ�
��ռ��ʱ��Ƭ������ͬʱ��Ϊ���Ȳ��ԣ���ν��ռ��Ҳ��������ִ�У�����ʵ�ֲ�ͬ��������ʱ��Ƭ�ӳ����������漸�ʼӴ�
# re: Java�﷨�ܽ� - �߳�  �ظ�  ��������   
2007-10-30 22:01 by Raylong
@Matthew Chen
ԭ���������������ھ����ƽ̨������java��ƽ̨�޹��Ե�һ������ɣ�����һ�����Ǹ����������͵ľ��������ھ����оƬ��
# re: Java�﷨�ܽ� - �߳�  �ظ�  ��������   
2007-10-31 20:20 by Matthew Chen
java�ĸ����������ͼ������޾����Կ��ԣ�ֻ����Ӧ�ڽ��Ƽ��㣬�⵹��һ����оƬ�йذɣ��������������������֮����ƶԸ�����һ�����Ķ�û���ˡ�
java�߳�ʵ���ǻ���ƽ̨�ص��û����ͬ�����Ա�֤��ƽ̨���߳����׼ȷ�ɿ������У�ǰ��������Ƶöԣ����Ͼ����ģ������Ǻ͵������ƵĲ�ȷ���Ե��߳�ִ���������ȷ���Եı����Ʋ��ǻ������֮�ϵġ�
# re: Java�﷨�ܽ� - �߳�  �ظ�  ��������   
2007-10-31 20:36 by Raylong
@Matthew Chen
���ڻ������������ܽ����Ѿ�д�˸������ľ���ֻ�����ڹ��̼��������
���ڸ�������оƬ�Ƿ��йأ�����Կ���core java2���������������intel��оƬ��︡���������ڲ�ͬ˵���˸������ľ������⡣
�̲߳��֣������Ѿ����ˡ����Ǳ����˽⵽ʲô���б��ϵĲ�����ʲô���ޱ��ϵĲ������Ա���Ƶĳ����ڸ���jvm�϶��ܺܺõع�����������˵�Ŀ�ƽ̨��һ����˼����ͬƽ̨��Ӧ��ͬ��jvm��ͬ����ƽ̨Ҳ�в�ͬ��jvm��
# re: Java�﷨�ܽ� - �߳�  �ظ�  ��������   
2007-12-18 12:20 by iampurse
лл�� ��
������һЩ�й�Thread�ö���
��ҳ�ղ��� ��
# re: Java�﷨�ܽ� - �߳�  �ظ�  ��������   
2008-08-26 15:35 by ���֮��
�ֵܣ�����д�Ĳ��� ���ܺã�
# re: Java�﷨�ܽ� - �߳�[δ��¼]  �ظ�  ��������   
2008-10-12 07:34 by ����
�̵߳�����ʲôʱ���� ���� ���� �Ҷ���̫���װ� Ҫ��ô�������������˽Ⱑ 402292747 �����ҵ�qq�� ϣ���Ǹ������������Ը��ҽ��� �ڴ�
л��������
# re: Java�﷨�ܽ� - �߳�[δ��¼]  �ظ�  ��������   
2009-02-24 10:32 by ����
�����ˣ����ߡ�����һ����
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
��δ�����Runnable��һ���ӿڣ��ӿ���ô������new Runnable()����ʵ�����أ�
���Ǻ���⣡
