Java 语言是一种具有动态性的解释型编程语言，当指定程序运行的时候， Java 虚拟机就将编译生成的 . class 文件按照需求和一定的规则加载进内存，并组织成为一个完整的 Java 应用程序。 Java 语言把每个单独的类 Class 和接口 Implements 编译成单独的一个 . class 文件，这些文件对于 Java 运行环境来说就是一个个可以动态加载的单元。正是因为 Java 的这种特性，我们可以在不重新编译其它代码的情况下，只编译需要修改的单元，并把修改文件编译后的 . class 文件放到 Java 的路径当中， 等到下次该 Java 虚拟机器重新激活时，这个逻辑上的 Java 应用程序就会因为加载了新修改的 .class 文件，自己的功能也做了更新，这就是 Java 的动态性。

下面用一个简单的例子让大家对 Java 的动态加载有一个基本的认识：

class TestClassA{

public void method(){

  System.out.println("Loading ClassA");

}

}

public class ClassLoaderTest {

public static void main(String args[]){

  TestClassA testClassA = new TestClassA();

  testClassA.method();

}

}

编译后输入命令： java -verbose:class ClassLoaderTest ，执行文件。

输出结构如图 (1)


图（ 1 ）

从运行结果我们可以看到， JRE （ JavaRuntime Environment ）首先加载 ClassLoaderTest 文件，然后再加载 TestClassA 文件，从而实现了动态加载。

   

1． 预先加载与依需求加载

Java 运行环境为了优化系统，提高程序的执行速度，在 JRE 运行的开始会将 Java 运行所需要的基本类采用预先加载（ pre-loading ）的方法全部加载要内存当中，因为这些单元在 Java 程序运行的过程当中经常要使用的，主要包括 JRE 的 rt.jar 文件里面所有的 .class 文件。

当 java.exe 虚拟机开始运行以后，它会找到安装在机器上的 JRE 环境，然后把控制权交给 JRE ， JRE 的类加载器会将 lib 目录下的 rt.jar 基础类别文件库加载进内存，这些文件是 Java 程序执行所必须的，所以系统在开始就将这些文件加载，避免以后的多次 IO 操作，从而提高程序执行效率。

图（ 2 ）我们可以看到多个基础类被加载， java.lang.Object,java.io.Serializable 等等。


图（ 2 ）

相对于预先加载，我们在程序中需要使用自己定义的类的时候就要使用依需求加载方法（ load-on-demand ），就是在 Java 程序需要用到的时候再加载，以减少内存的消耗，因为 Java 语言的设计初衷就是面向嵌入式领域的。

在这里还有一点需要说明的是， JRE 的依需求加载究竟是在什么时候把类加载进入内部的呢？

我们在定义一个类实例的时候，比如 TestClassA testClassA ，这个时候 testClassA 的值为 null ，也就是说还没有初始化，没有调用 TestClassA 的构造函数，只有当执行 testClassA = new TestClassA() 以后， JRE 才正真把 TestClassA 加载进来。

   

2． 隐式加载和显示加载

Java 的加载方式分为隐式加载（ implicit ）和显示加载（ explicit ），上面的例子中就是用的隐式加载的方式。所谓隐式加载就是我们在程序中用 new 关键字来定义一个实例变量， JRE 在执行到 new 关键字的时候就会把对应的实例类加载进入内存。隐式加载的方法很常见，用的也很多， JRE 系统在后台自动的帮助用户加载，减少了用户的工作量，也增加了系统的安全性和程序的可读性。

相对于隐式加载的就是我们不经常用到的显示加载。所谓显示加载就是有程序员自己写程序把需要的类加载到内存当中，下面我们看一段程序：

class TestClass{

public void method(){

  System.out.println("TestClass-method");

}

}

   

public class CLTest {

public static void main(String args[]) {

  try{

  Class c = Class.forName("TestClass");

  TestClass object = (TestClass)c.newInstance();

  object.method();

  }catch(Exception e){

  e.printStackTrace();

  }

}

}

我们通过 Class 类的 forName (String s) 方法把自定义类 TestClass 加载进来，并通过 newInstance （）方法把实例初始化。事实上 Class 类还很多的功能，这里就不细讲了，有兴趣的可以参考 JDK 文档。

Class 的 forName() 方法还有另外一种形式： Class forName(String s, boolean flag, ClassLoader classloader) ， s 表示需要加载类的名称， flag 表示在调用该函数加载类的时候是否初始化静态区， classloader 表示加载该类所需的加载器。

forName (String s) 是默认通过 ClassLoader.getCallerClassLoader() 调用类加载器的，但是该方法是私有方法，我们无法调用，如果我们想使用 Class forName(String s, boolean flag, ClassLoader classloader) 来加载类的话，就必须要指定类加载器，可以通过如下的方式来实现：

Test test = new Test();//Test 类为自定义的一个测试类；

ClassLoader cl = test. getClass().getClassLoader();

  // 获取 test 的类装载器；

Class c = Class.forName("TestClass", true, cl);

因为一个类要加载就必需要有加载器，这里我们是通过获取加载 Test 类的加载器 cl 当作加载 TestClass 的类加载器来实现加载的。

   

3． 自定义类加载机制

之前我们都是调用系统的类加载器来实现加载的，其实我们是可以自己定义类加载器的。利用 Java 提供的 java.net.URLClassLoader 类就可以实现。下面我们看一段范例：

  try{

  URL url = new URL("file:/d:/test/lib/");

  URLClassLoader urlCL = new URLClassLoader(new URL[]{url});

  Class c = urlCL.loadClass("TestClassA");

  TestClassA object = (TestClassA)c.newInstance();

  object.method();

  }catch(Exception e){

  e.printStackTrace();

  }

我们通过自定义的类加载器实现了 TestClassA 类的加载并调用 method （）方法。分析一下这个程序：首先定义 URL 指定类加载器从何处加载类， URL 可以指向网际网络上的任何位置，也可以指向我们计算机里的文件系统 ( 包含 JAR 文件 ) 。上述范例当中我们从 file:/d:/test/lib/ 处寻找类；然后定义 URLClassLoader 来加载所需的类，最后即可使用该实例了。

   

4． 类加载器的阶层体系

讨论了这么多以后，接下来我们仔细研究一下 Java 的类加载器的工作原理：

当执行 java ***.class 的时候， java.exe 会帮助我们找到 JRE ，接着找到位于 JRE 内部的 jvm.dll ，这才是真正的 Java 虚拟机器 , 最后加载动态库，激活 Java 虚拟机器。虚拟机器激活以后，会先做一些初始化的动作，比如说读取系统参数等。一旦初始化动作完成之后，就会产生第一个类加载器―― Bootstrap Loader ， Bootstrap Loader 是由 C++ 所撰写而成，这个 Bootstrap Loader 所做的初始工作中，除了一些基本的初始化动作之外，最重要的就是加载 Launcher.java 之中的 ExtClassLoader ，并设定其 Parent 为 null ，代表其父加载器为 BootstrapLoader 。然后 Bootstrap Loader 再要求加载 Launcher.java 之中的 AppClassLoader ，并设定其 Parent 为之前产生的 ExtClassLoader 实体。这两个加载器都是以静态类的形式存在的。这里要请大家注意的是， Launcher$ExtClassLoader.class 与 Launcher$AppClassLoader.class 都是由 Bootstrap Loader 所加载，所以 Parent 和由哪个类加载器加载没有关系。

下面的图形可以表示三者之间的关系：

父类

父类

载入

载入

BootstrapLoader

  PARENT

AppClassLoader

PARENT

ExtClassLoader

这三个加载器就构成我们的 Java 类加载体系。他们分别从以下的路径寻找程序所需要的类：

BootstrapLoader ： sun.boot.class.path

ExtClassLoader: java.ext.dirs

AppClassLoader: java.class.path

这三个系统参量可以通过 System.getProperty() 函数得到具体对应的路径。大家可以自己编程实现查看具体的路径。

   

5． 总结

了解 Java 的类加载机制对我们熟练灵活运用 Java 语言，提高程序的运行效率有着非常重要的作用，知其然也要知其所以然，这样才能从整体提高程序的质量。


以上是个人为了毕业要发表的一篇论文,没有什么深度,下面再继续讨论一点关于ClassLoader的一定东东:

public class ClassLoaderTest1{
private ClassLoaderTest2 test = null;
public ClassLoaderTest1(){
  test = new ClassLoaderTest2();
}
public void method(){
  System.out.println("Loading ClassA");
}
}


class ClassLoaderTest2{
public ClassLoaderTest2(){
   
}
public void method(){
  System.out.println("Loading ClassA");
}
}

测试程序:
URL url = null;
try {
  url = new URL("file:/E:/JAVA/MyProject/string/");
  } catch (MalformedURLException e) {
  e.printStackTrace();
  }
  URLClassLoader cl = new URLClassLoader(new URL[]{url});
  URLClassLoader cl1 = new URLClassLoader(new URL[]{url});
  try {
  Class tempClass = cl.loadClass("ClassLoaderTest1");
  Class tempClass2 = cl.loadClass("ClassLoaderTest2");
  Object test = tempClass.newInstance();
  System.out.println(tempClass.getClassLoader());
  System.out.println(tempClass2.getClassLoader());
  } catch (Exception e) {
  e.printStackTrace();
  }

当ClassLoaderTest1,ClassLoaderTest2在当前目录和E:/JAVA/MyProject/string/都存在的时候输出为sun.misc.Launcher$AppClassLoader@1050169
  sun.misc.Launcher$AppClassLoader@1050169
即都是被AppClassLoader加载的, 即使在E:/JAVA/MyProject/string/下面也存在.

当ClassLoaderTest1,ClassLoaderTest2只在E:/JAVA/MyProject/string/下存在的时候输出为
java.net.URLClassLoader@480457
java.net.URLClassLoader@1a7bf11
即都是被自定义的加载器加载的,并且也可以Object test = tempClass.newInstance();

下面一的是最关键的,因为ClassLoaderTest1需要用到ClassLoaderTest2,如果ClassLoaderTest2被AppClassLoader加载,而ClassLoaderTest1是被自定义的类加载器加载,就会出现如下错误:

java.lang.IllegalAccessError: tried to access class ClassLoaderTest2 from class ClassLoaderTest1
at ClassLoaderTest1.<init>(ClassLoaderTest1.java:6)
at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:39)
at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:27)
at java.lang.reflect.Constructor.newInstance(Constructor.java:274)
at java.lang.Class.newInstance0(Class.java:308)
at java.lang.Class.newInstance(Class.java:261)
at ClassLoaderTest.main(ClassLoaderTest.java:43)