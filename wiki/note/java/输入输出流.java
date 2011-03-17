在这四个抽象类中，InputStream和Reader定义了完全相同的接口：

int read()
int read(char cbuf[])
int read(char cbuf[], int offset, int length) 

而OutputStream和Writer也是如此：

int write(int c) 
int write(char cbuf[])
int write(char cbuf[], int offset, int length) 

这六个方法都是最基本的，read()和write()通过方法的重载来读写一个字节，或者一个字节数组。

更多灵活多变的功能是由它们的子类来扩充完成的。知道了Java输入输出的基本层次结构以后，本文在这里想给大家一些以后可以反复应用例子，对于所有子类的细节及其功能并不详细讨论。

import java.io.*;

public class IOStreamDemo {

      public void samples() throws IOException {

           //1. 这是从键盘读入一行数据,返回的是一个字符串
           BufferedReader stdin =new BufferedReader(new InputStreamReader(System.in)); 
           System.out.print("Enter a line:");
           System.out.println(stdin.readLine());

           //2. 这是从文件中逐行读入数据 

           BufferedReader in = new BufferedReader(new FileReader("IOStreamDemo.java"));
           String s, s2 = new String();
           while((s = in.readLine())!= null)
                       s2 += s + "\n";
            in.close();


           //3. 这是从一个字符串中逐个读入字节 
           StringReader in1 = new StringReader(s2);
           int c;
           while((c = in1.read()) != -1)
                      System.out.print((char)c);


           //4. 这是将一个字符串写入文件 
           try {
                      BufferedReader in2 = new BufferedReader(new StringReader(s2));
                      PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("IODemo.out")));
                      int lineCount = 1;
                      while((s = in2.readLine()) != null )
                                  out1.println(lineCount++ + ": " + s);
                       out1.close();
            } catch(EOFException e) {
                      System.err.println("End of stream");
            }
       } 

}
 

对于上面的例子，需要说明的有以下几点：

1. BufferedReader是Reader的一个子类，它具有缓冲的作用，避免了频繁的从物理设备中读取信息。它有以下两个构造函数：

BufferedReader(Reader in) 
BufferedReader(Reader in, int sz)  

这里的sz是指定缓冲区的大小。

它的基本方法：

void close() //关闭流 

           void mark(int readAheadLimit) //标记当前位置

           boolean markSupported() //是否支持标记

           int read() //继承自Reader的基本方法

           int read(char[] cbuf, int off, int len) //继承自Reader的基本方法

           String readLine() //读取一行内容并以字符串形式返回

           boolean ready() //判断流是否已经做好读入的准备

           void reset() //重设到最近的一个标记

           long skip(long n) //跳过指定个数的字符读取 

2. InputStreamReader是InputStream和Reader之间的桥梁，由于System.in是字节流，需要用它来包装之后变为字符流供给             BufferedReader使用。


3. PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("IODemo.out")));

这句话体现了Java输入输出系统的一个特点，为了达到某个目的，需要包装好几层。首先，输出目的地是文件IODemo.out，所以最内层包装的是FileWriter，建立一个输出文件流，接下来，我们希望这个流是缓冲的，所以用BufferedWriter来包装它以达到目的，最后，我们需要格式化输出结果，于是将PrintWriter包在最外层。


Java提供了这样一个功能，将标准的输入输出流转向，也就是说，我们可以将某个其他的流设为标准输入或输出流，看下面这个例子：

import java.io.*;

public class Redirecting {

        public static void main(String[] args) throws IOException {
              PrintStream console = System.out;
              BufferedInputStream in = new BufferedInputStream( new FileInputStream( "Redirecting.java"));
              PrintStream out = new PrintStream( new BufferedOutputStream( new FileOutputStream("test.out")));
               System.setIn(in);
               System.setOut(out);

              BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
              String s;
              while((s = br.readLine()) != null)
                      System.out.println(s);
               out.close(); 
               System.setOut(console);
       } 
}
 

在这里java.lang.System的静态方法

static void setIn(InputStream in) 
static void setOut(PrintStream out)  

提供了重新定义标准输入输出流的方法，这样做是很方便的，比如一个程序的结果有很多，有时候甚至要翻页显示，这样不便于观看结果，这是你就可以将标准输出流定义为一个文件流，程序运行完之后打开相应的文件观看结果，就直观了许多。

Java流有着另一个重要的用途，那就是利用对象流对对象进行序列化。下面将开始介绍这方面的问题。

在一个程序运行的时候，其中的变量数据是保存在内存中的，一旦程序结束这些数据将不会被保存，一种解决的办法是将数据写入文件，而Java中提供了一种机制，它可以将程序中的对象写入文件，之后再从文件中把对象读出来重新建立。这就是所谓的对象序列化Java中引入它主要是为了RMI（Remote Method Invocation）和Java Bean所用，不过在平时应用中，它也是很有用的一种技术。

所有需要实现对象序列化的对象必须首先实现Serializable接口。下面看一个例子：

import java.io.*;
import java.util.*;

public class Logon implements Serializable {

       private Date date = new Date();
       private String username;
       private transient String password;


        Logon(String name, String pwd) {
               username = name;
               password = pwd;
        }


       public String toString() {
              String pwd = (password == null) ? "(n/a)" : password;
               return "logon info: \n " + "username: " + username + "\n date: " + date + "\n password: " + pwd;
        }


        public static void main(String[] args) throws IOException, ClassNotFoundException {
              Logon a = new Logon("Morgan", "morgan83");
              System.out.println( "logon a = " + a);
              ObjectOutputStream o = new ObjectOutputStream( new FileOutputStream("Logon.out"));
               o.writeObject(a);
               o.close();

              int seconds = 5;
              long t = System.currentTimeMillis() + seconds * 1000;
              while(System.currentTimeMillis() < t) ;

              ObjectInputStream in = new ObjectInputStream( new FileInputStream("Logon.out"));
              System.out.println( "Recovering object at " + new Date());
               a = (Logon)in.readObject();
              System.out.println("logon a = " + a); 
        }
}
 

类Logon是一个记录登录信息的类，包括用户名和密码。首先它实现了接口Serializable，这就标志着它可以被序列化。之后再main方法里ObjectOutputStream o = new ObjectOutputStream( new FileOutputStream("Logon.out"));新建一个对象输出流包装一个文件流，表示对象序列化的目的地是文件Logon.out。然后用方法writeObject开始写入。想要还原的时候也很简单ObjectInputStream in = new ObjectInputStream( new FileInputStream("Logon.out"));新建一个对象输入流以文件流Logon.out为参数，之后调用readObject方法就可以了。

需要说明一点，对象序列化有一个神奇之处就是，它建立了一张对象网，将当前要序列化的对象中所持有的引用指向的对象都包含起来一起写入到文件，更为奇妙的是，如果你一次序列化了好几个对象，它们中相同的内容将会被共享写入。这的确是一个非常好的机制。它可以用来实现深层拷贝，有关深层拷贝的问题在JavaWorld上有一篇文章做了几种实现方法的介绍和比较，有兴趣者可以去看看。

关键字transient在这里表示当前内容将不被序列化，比如例子中的密码，需要保密，所以没有被写入文件。


