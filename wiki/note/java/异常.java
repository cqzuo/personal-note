异常
了解异常的定义
了解异常的分类
掌握 try、catch 和 finally 语句的用法
掌握throw、throws子句的用法
掌握如何定义自己的异常
了解 Java 的垃圾收集机制
1.什么是异常
   运行时发生的错误称为异常。处理这些异常就称为异常处理。 
  一旦引发异常，程序将突然中止，且控制将返回操作系统。发生异常后此前分配的所有资源都将保留在相同的状态，这将导致资源漏洞
  public class exec 
{
        public static void main(String args[])
        {
                try
                {
                        String str=javax.swing.JOptionPane.showInputDialog("Please input the size:");
                        int size=Integer.parseInt(str);
                        int x[]=new int[size];
                }
                catch(NumberFormatException e)
                {
                        javax.swing.JOptionPane.showMessageDialog(null,"Not Integer!");  
                }
                catch(NegativeArraySizeException e)
                {
                        javax.swing.JOptionPane.showMessageDialog(null,"Not Positive!");  
                }
                System.exit(0);
        }
}
2.java异常处理基础
   Java异常处理机制采用一个统一和相对简单的抛出和处理错误的机制。如果一个方法本身能引发异常，当所调用的方法出现异常时，调用者可以捕获异常使之得到处理；也可以回避异常，这时异常将在调用的堆栈中向下传递，直到被处理
   Error类对象由Java虚拟机生成并抛出；Exception类对象由应用程序处理或抛出
3.常见异常
    RuntimeException 	java.lang包中多数异常的基类 
    ArithmeticException 	算术错误，如除以 0 
    IllegalArgumentException 	方法收到非法参数 
    ArrayIndexOutOfBoundsException 	数组下标出界 
    NullPointerException 	试图访问 null 对象引用 
   SecurityException 	试图违反安全性 
   ClassNotFoundException	不能加载请求的类
   AWTException 	AWT 中的异常 
  IOException 	I/O 异常的根类 
  FileNotFoundException 	不能找到文件 
  EOFException 	文件结束 
  IllegalAccessException 	对类的访问被拒绝 
  NoSuchMethodException 	请求的方法不存在 
  InterruptedException 	线程中断 
4.异常处理模型
   由五个关键字 try、catch、throw、throws 和 finally 处理。
   Java 中可用于处理异常的两种方式：
   自行处理：可能引发异常的语句封入在 try 块内，而处理异常的相应语句则封入在 catch 块内。
   回避异常：在方法声明中包含 throws 子句，通知潜在调用者，如果发生了异常，必须由调用者处理。 
例子
     public class ExceptionDemo 
     {
	 public static void main(String args[])
{
    try  {
 	   int c= calculate(9,0);
	   System.out.println(c);
	  } 
	  catch (Exception e) { 
	   System.err.println("发生异常： " + e.toString()); 
	   e.printStackTrace(); 
	  }
	}
	static int calculate(int a, int b) {
		int c = a/b; return c;
	}
 } 
5.多个catch块
    单个代码片段可能会引起多个错误
    可提供多个catch块分别处理各种异常类型
    捕获Exception的catch子句一定要放在最后
      try{ }
      catch(ArrayIndexOutOfBoundsException e){ }//数组下标越界异常类
      catch(Exception e) { }
      ArrayIndexOutOfBoundsException类为 Exception 类的子类，但是如果异常属于ArrayIndexOutOfBoundsException类将执行第一个catch块，之后控制将转向try/catch块之后的语句，所以始终不会执行第二个 catch 块。
class Catch22 {
		public static void main(String args[]) {
    try {
	   String num=args[0];//定义一个用命令行输入的字符串，可能为数字或字符
	   int numValue=Integer.parseInt(num);//将获取的数据转化为int型
		System.out.println("平方为 "+numValue*numValue);//输出平方
    }
	  catch(ArrayIndexOutOfBoundsException ne) {//两种异常：不给参数或给出字符，本别给出
		 System.out.println("未提供任何参数！");
	  }
	  catch(NumberFormatException nb)	{//数字格式异常类
		System.out.println("不是数字！");
	  }
	}
 } 
 7.嵌套的try catch 块
   有时，块的一部分引起一个错误，而整个块可能又引起另一个错误。在此情况下，需要将一个异常处理程序嵌套到另一个中。 
  在使用嵌套的try块时，将先执行内部 try 块，如果没有遇到匹配的 catch 块，则将检查外部 try 块的 catch 块。
 8.finally块
   确保了在出现异常时所有清除工作都将得到处理与 try 块一起使用，无论是否出现异常，finally块都将运行
   class FinallyDemo {
  int no1,no2;
  FinallyDemo(String args[])	{
    try {
      no1 = Integer.parseInt(args[0]);
      no2 = Integer.parseInt(args[1]);
      System.out.println("相除结果为 "+no1/no2);
    }
    catch(ArithmeticException i) {
	 System.out.println("不能除以 0");
    }	
    finally {
      System.out.println("Finally 已执行");	
    } 	
  }
 public static void main(String args[]) {
   new FinallyDemo(args); 
  } 
} 
8.throw
   异常是通过关键字throw抛出，程序可以用throw语句引发明确的异常：
    try {
		if(flag<0)	{
		  throw new NullPointerException();
		}
        }
   throw语句的操作数一定是Throwable类类型或Throwable子类类型的一个对象。
   如果一个方法可能导致一个异常但不处理它，此时要求在方法声明中包含 throws 子句，通知潜在调用者，如果发生了异常，由调用者处理。
  一个throws子句列举了一个方法可能引发的所有异常类型。
  这对于除Error或RuntimeException及它们子类以外类型的所有异常是必要的
   class ThrowsDemo{    
 static void throwOne() throws IllegalAccessException{//自己定义要抛出的异常
   System.out.println("在throwOne中.");
   throw new IllegalAccessException("非法访问异常");//抛出异常 IlleaglAccessException
 }
 public static void main(String args[]){
   try{
    throwOne();//抛出异常
   }
   catch(IllegalAccessException e){//捕获异常并打印
     System.out.println("捕获"+e);
   }
 }
} 
8.用户自定义的异常
      内置异常不可能始终足以捕获所有错误，因此需要用户自定义的异常类
      用户自定义的异常类应为 Exception 类（或者Exception 类的子类）的子类
      创建的任何用户自定义的异常类都可以获得 Throwable类定义的方法
   例子   
   class ArraySizeException extends NegativeArraySizeException{//自定义一个异常，继承自NegativeArraySizeException;
   ArraySizeException() {
      super(“您传递的是非法的数组大小”);//该异常作用
  }
}
class UserExceptionDemo {//一个测试自定义异常的类
	int size, array[];//类的数据域测试数据大小的size和输入数据类型array[];
	UserExceptionDemo(int s) {//构造函数的作用，检测大小是否合法，否则捕获并输出异常
		size = s;
		try {checkSize();	}
		catch(ArraySizeException e) {System.out.println(e);}
	}
	void checkSize() throws ArraySizeException {//检测数据大小合法性的方法
		if(size < 0) 	throw new ArraySizeException();
		array = new int[size];
		for(int i = 0; i < size; i++) {
		   array[i] = i+1;
          System.out.print(array[i]+" ");
       }
	}
	public static void main(String arg[]) { 
	    new UserExceptionDemo(Integer.parseInt(arg[0])); }
} 
