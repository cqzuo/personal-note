所谓内部类(Inner Class)，顾名思义，就是指定义在另外一个类中的类，我们为什么要这么做呢？为什么不直接定义它而要在别的类中定义一个内部类呢？这样做主要有如下三个原因：

1．  内部类的方法可以访问它所在的外部类中的所有域，包括私有型别的；

2．  对于同一个包中的其它类它是隐藏的；

3．  匿名的内部类可以让我们很方便的定义事件响应(call back)，这在GUI编程中很常见；

一．内部类(inner class)如何访问外部类(outer class)中的域

因为安全机制的原因，内部类通常声明为private类别，因此，只有在内部类所在的外部中才能够创建内部类的对象，对其它类而言它是隐藏的。另外，只有内部类才会用到private修饰符，一般的类如果用private修饰符则会报错。

下面看如下的代码：

package cn.edu.hust.cm.test;

 

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import javax.swing.Timer;

public class InnerClassTest {

       public InnerClassTest() {

              super();

              // TODO Auto-generated constructor stub

       }

       public static void main(String[] args) {

        Court court=new Court(10000,true);

        court.start();

        JOptionPane.showMessageDialog(null,"停止么，CMTobby?");

        System.exit(0);

       }

}

 

class Court{

       public Court(int interval,boolean beep){

              this.interval=interval;

              this.beep=beep;

       }

       public void start(){

              TimerPrinter action=new TimerPrinter();

              Timer t=new Timer(interval,action);

              t.start();

       }

       private int interval;

       private boolean beep;

 

       private class TimerPrinter implements ActionListener{

              public void actionPerformed(ActionEvent e){

                     System.out.println("Cindyelf,would you be my mm?");

                     if(beep) Toolkit.getDefaultToolkit().beep();

              }

       }

}

注意上面红色加粗部分的代码，如你所见beep这个变量在内部类TimerPrinter中我们并没有声明，那么它引用自何处呢？显然是来自于外部类。一般来说，一个方法可直接refer to调用它的对象中的所有域，而一个内部类的方法则可以直接refer to它所在类以及创建它的外部类中的所有域，如上例所示。

事实上，在每一个内部类中都存在一个默认的隐式的reference，它指向创建了这个内部类的实例的那个对象，我们假设它叫outer，这样上面红色加粗部分就相当于：

if(outer.beep) Toolkit.getDefaultToolkit().beep();。Ok，既然存在这样一个reference，那么outer的值又是如何设置的？实际上编译器会合成一个构造方法来设置它，如下面代码所示：

public TimePrinter(Court court) {

          outer = clock;
}

    这段代码是编译时自动产生的，就像前面我们讨论的自动拆箱装箱中一样，编译器自

己会添加一些代码。然后当我们在Court类的start()方法中创建TimerPrinter实例的时

候，编译器会自动把this作为参数传递过去，效果如下面代码所示：

    public void start(){

              TimerPrinter action=new TimerPrinter(this);//编译器自动加上的

              Timer t=new Timer (interval,action);

              t.start ();

       }

    参数是编译器自动给加上的，不用我们来管。

二．内部类的一些特殊语法规则

    前面我们说在每一个内部类中都存在一个默认的隐式的reference，它指向创建了这个内

部类的实例的那个对象，并且我们以outer来带指它，如果我们想显式的指明该按照如下的

语法，OuterClass.this，例如if(Court.this.beep) Toolkit.getDefaultToolkit().beep();。

    此外，因为我们定义的内部类通常是private，所以它通常是通过外部类的方法创建，如

本例中的start()方法，这样那个隐式的reference就指向调用了start()方法的对象，就是this。

如果内部类声明为public，那么我们就可以在任何地方实例化一个内部类，如下面代码：

    Court court=new Court(10000,true);

    Court.TimerPrinter test=court.new TimerPrinter();

    上述代码在InnerClassTest的main方法中，这时候那个隐式的reference就直接指向了

court对象。注意语法是：OuterClassName.InnerClassName

