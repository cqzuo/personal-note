Java的synchronized关键字：同步机制总结
http://developer.51cto.com  2009-08-12 13:37  leo_faith  Javaeye  我要评论(1)
JAVA中synchronized关键字能够作为函数的修饰符，也可作为函数内的语句，也就是平时说的同步方法和同步语句块。搞清楚synchronized锁定的是哪个对象，就能帮助我们设计更安全的多线程程式。


不久前用到了同步，现在回过头来对JAVA中的同步做个总结，以对前段时间工作的总结和自我技术的条理话。JAVA的synchronized关键字能够作为函数的修饰符，也可作为函数内的语句，也就是平时说的同步方法和同步语句块。假如再细的分类，synchronized可作用于instance变量、object reference（对象引用）、static函数和class literals(类名称字面常量)身上。 
在进一步阐述之前，我们需要明确几点： 
A．无论synchronized关键字加在方法上还是对象上，他取得的锁都是对象，而不是把一段代码或函数当作锁――而且同步方法很可能还会被其他线程的对象访问。 
B．每个对象只有一个锁（lock）和之相关联。 
C．实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。 
接着来讨论synchronized用到不同地方对代码产生的影响： 

假设P1、P2是同一个类的不同对象，这个类中定义了以下几种情况的同步块或同步方法，P1、P2就都能够调用他们。 

Java的synchronized使用方法总结

1．  把synchronized当作函数修饰符时，示例代码如下： 
Public synchronized void method(){   
//….   
}  

这也就是同步方法，那这时synchronized锁定的是哪个对象呢？他锁定的是调用这个同步方法对象。也就是说，当一个对象P1在不同的线程中执行这个同步方法时，他们之间会形成互斥，达到同步的效果。但是这个对象所属的Class所产生的另一对象P2却能够任意调用这个被加了synchronized关键字的方法。 
上边的示例代码等同于如下代码： 
public void method()   
{   
synchronized (this)      //  (1)   
{   
       //…..   
}   
}   

(1)处的this指的是什么呢？他指的就是调用这个方法的对象，如P1。可见同步方法实质是将synchronized作用于object reference。――那个拿到了P1对象锁的线程，才能够调用P1的同步方法，而对P2而言，P1这个锁和他毫不相干，程式也可能在这种情形下摆脱同步机制的控制，造成数据混乱。

2．同步块，示例代码如下： 
public void method(SomeObject so) {   
synchronized(so)   
{   
       //…..   
}   
}   

这时，锁就是so这个对象，谁拿到这个锁谁就能够运行他所控制的那段代码。当有一个明确的对象作为锁时，就能够这样写程式，但当没有明确的对象作为锁，只是想让一段代码同步时，能够创建一个特别的instance变量（他得是个对象）来充当锁： 
class Foo implements Runnable   
{   
       private byte[] lock = new byte[0];  // 特别的instance变量   
    Public void method()   
{   
       synchronized(lock) { //… }   
}   
//…..   
}   

注：零长度的byte数组对象创建起来将比任何对象都经济――查看编译后的字节码：生成零长度的byte[]对象只需3条操作码，而Object lock = new Object()则需要7行操作码。 

3．将synchronized作用于static 函数，示例代码如下：
      Class Foo   
{   
public synchronized static void method1()   // 同步的static 函数   
{   
//….   
}   
public void method2()   
{   
       synchronized(Foo.class)   //  class literal(类名称字面常量)   
}   
       }   


代码中的method2()方法是把class literal作为锁的情况，他和同步的static函数产生的效果是相同的，取得的锁很特别，是当前调用这个方法的对象所属的类（Class，而不再是由这个Class产生的某个具体对象了）。 
记得在《Effective Java》一书中看到过将 Foo.class和 P1.getClass()用于作同步锁还不相同，不能用P1.getClass()来达到锁这个Class的目的。P1指的是由Foo类产生的对象。 
能够推断：假如一个类中定义了一个synchronized的static函数A，也定义了一个synchronized 的instance函数B，那么这个类的同一对象Obj在多线程中分别访问A和B两个方法时，不会构成同步，因为他们的锁都不相同。A方法的锁是Obj所属的那个Class，而B的锁是Obj所属的这个对象。 

Java的synchronized使用方法小结如下：

搞清楚synchronized锁定的是哪个对象，就能帮助我们设计更安全的多线程程式。 

更有一些技巧能够让我们对共享资源的同步访问更加安全： 
1．  定义private 的instance变量+他的 get方法，而不要定义public/protected的instance变量。假如将变量定义为public，对象在外界能够绕过同步方法的控制而直接取得他，并改变他。这也是JavaBean的标准实现方式之一。 
2．  假如instance变量是个对象，如数组或ArrayList什么的，那上述方法仍然不安全，因为当外界对象通过get方法拿到这个instance对象的引用后，又将其指向另一个对象，那么这个private变量也就变了，岂不是很危险。 这个时候就需要将get方法也加上synchronized同步，并且，只返回这个private对象的clone()――这样，调用端得到的就是对象副本的引用了。