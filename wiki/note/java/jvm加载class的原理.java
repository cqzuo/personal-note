Java ������һ�־��ж�̬�ԵĽ����ͱ�����ԣ���ָ���������е�ʱ�� Java ������ͽ��������ɵ� . class �ļ����������һ���Ĺ�����ؽ��ڴ棬����֯��Ϊһ�������� Java Ӧ�ó��� Java ���԰�ÿ���������� Class �ͽӿ� Implements ����ɵ�����һ�� . class �ļ�����Щ�ļ����� Java ���л�����˵����һ�������Զ�̬���صĵ�Ԫ��������Ϊ Java ���������ԣ����ǿ����ڲ����±����������������£�ֻ������Ҫ�޸ĵĵ�Ԫ�������޸��ļ������� . class �ļ��ŵ� Java ��·�����У� �ȵ��´θ� Java ����������¼���ʱ������߼��ϵ� Java Ӧ�ó���ͻ���Ϊ���������޸ĵ� .class �ļ����Լ��Ĺ���Ҳ���˸��£������ Java �Ķ�̬�ԡ�

������һ���򵥵������ô�Ҷ� Java �Ķ�̬������һ����������ʶ��

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

������������ java -verbose:class ClassLoaderTest ��ִ���ļ���

����ṹ��ͼ (1)


ͼ�� 1 ��

�����н�����ǿ��Կ����� JRE �� JavaRuntime Environment �����ȼ��� ClassLoaderTest �ļ���Ȼ���ټ��� TestClassA �ļ����Ӷ�ʵ���˶�̬���ء�

   

1�� Ԥ�ȼ��������������

Java ���л���Ϊ���Ż�ϵͳ����߳����ִ���ٶȣ��� JRE ���еĿ�ʼ�Ὣ Java ��������Ҫ�Ļ��������Ԥ�ȼ��أ� pre-loading ���ķ���ȫ������Ҫ�ڴ浱�У���Ϊ��Щ��Ԫ�� Java �������еĹ��̵��о���Ҫʹ�õģ���Ҫ���� JRE �� rt.jar �ļ��������е� .class �ļ���

�� java.exe �������ʼ�����Ժ������ҵ���װ�ڻ����ϵ� JRE ������Ȼ��ѿ���Ȩ���� JRE �� JRE ����������Ὣ lib Ŀ¼�µ� rt.jar ��������ļ�����ؽ��ڴ棬��Щ�ļ��� Java ����ִ��������ģ�����ϵͳ�ڿ�ʼ�ͽ���Щ�ļ����أ������Ժ�Ķ�� IO �������Ӷ���߳���ִ��Ч�ʡ�

ͼ�� 2 �����ǿ��Կ�����������౻���أ� java.lang.Object,java.io.Serializable �ȵȡ�


ͼ�� 2 ��

�����Ԥ�ȼ��أ������ڳ�������Ҫʹ���Լ���������ʱ���Ҫʹ����������ط����� load-on-demand ���������� Java ������Ҫ�õ���ʱ���ټ��أ��Լ����ڴ�����ģ���Ϊ Java ���Ե���Ƴ��Ծ�������Ƕ��ʽ����ġ�

�����ﻹ��һ����Ҫ˵�����ǣ� JRE ����������ؾ�������ʲôʱ�������ؽ����ڲ����أ�

�����ڶ���һ����ʵ����ʱ�򣬱��� TestClassA testClassA �����ʱ�� testClassA ��ֵΪ null ��Ҳ����˵��û�г�ʼ����û�е��� TestClassA �Ĺ��캯����ֻ�е�ִ�� testClassA = new TestClassA() �Ժ� JRE ������� TestClassA ���ؽ�����

   

2�� ��ʽ���غ���ʾ����

Java �ļ��ط�ʽ��Ϊ��ʽ���أ� implicit ������ʾ���أ� explicit ��������������о����õ���ʽ���صķ�ʽ����ν��ʽ���ؾ��������ڳ������� new �ؼ���������һ��ʵ�������� JRE ��ִ�е� new �ؼ��ֵ�ʱ��ͻ�Ѷ�Ӧ��ʵ������ؽ����ڴ档��ʽ���صķ����ܳ������õ�Ҳ�ܶ࣬ JRE ϵͳ�ں�̨�Զ��İ����û����أ��������û��Ĺ�������Ҳ������ϵͳ�İ�ȫ�Ժͳ���Ŀɶ��ԡ�

�������ʽ���صľ������ǲ������õ�����ʾ���ء���ν��ʾ���ؾ����г���Ա�Լ�д�������Ҫ������ص��ڴ浱�У��������ǿ�һ�γ���

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

����ͨ�� Class ��� forName (String s) �������Զ����� TestClass ���ؽ�������ͨ�� newInstance ����������ʵ����ʼ������ʵ�� Class �໹�ܶ�Ĺ��ܣ�����Ͳ�ϸ���ˣ�����Ȥ�Ŀ��Բο� JDK �ĵ���

Class �� forName() ������������һ����ʽ�� Class forName(String s, boolean flag, ClassLoader classloader) �� s ��ʾ��Ҫ����������ƣ� flag ��ʾ�ڵ��øú����������ʱ���Ƿ��ʼ����̬���� classloader ��ʾ���ظ�������ļ�������

forName (String s) ��Ĭ��ͨ�� ClassLoader.getCallerClassLoader() ������������ģ����Ǹ÷�����˽�з����������޷����ã����������ʹ�� Class forName(String s, boolean flag, ClassLoader classloader) ��������Ļ����ͱ���Ҫָ���������������ͨ�����µķ�ʽ��ʵ�֣�

Test test = new Test();//Test ��Ϊ�Զ����һ�������ࣻ

ClassLoader cl = test. getClass().getClassLoader();

  // ��ȡ test ����װ������

Class c = Class.forName("TestClass", true, cl);

��Ϊһ����Ҫ���ؾͱ���Ҫ�м�����������������ͨ����ȡ���� Test ��ļ����� cl �������� TestClass �����������ʵ�ּ��صġ�

   

3�� �Զ�������ػ���

֮ǰ���Ƕ��ǵ���ϵͳ�����������ʵ�ּ��صģ���ʵ�����ǿ����Լ�������������ġ����� Java �ṩ�� java.net.URLClassLoader ��Ϳ���ʵ�֡��������ǿ�һ�η�����

  try{

  URL url = new URL("file:/d:/test/lib/");

  URLClassLoader urlCL = new URLClassLoader(new URL[]{url});

  Class c = urlCL.loadClass("TestClassA");

  TestClassA object = (TestClassA)c.newInstance();

  object.method();

  }catch(Exception e){

  e.printStackTrace();

  }

����ͨ���Զ�����������ʵ���� TestClassA ��ļ��ز����� method ��������������һ������������ȶ��� URL ָ����������Ӻδ������࣬ URL ����ָ�����������ϵ��κ�λ�ã�Ҳ����ָ�����Ǽ��������ļ�ϵͳ ( ���� JAR �ļ� ) �����������������Ǵ� file:/d:/test/lib/ ��Ѱ���ࣻȻ���� URLClassLoader ������������࣬��󼴿�ʹ�ø�ʵ���ˡ�

   

4�� ��������Ľײ���ϵ

��������ô���Ժ󣬽�����������ϸ�о�һ�� Java ����������Ĺ���ԭ��

��ִ�� java ***.class ��ʱ�� java.exe ����������ҵ� JRE �������ҵ�λ�� JRE �ڲ��� jvm.dll ������������� Java ������� , �����ض�̬�⣬���� Java ���������������������Ժ󣬻�����һЩ��ʼ���Ķ���������˵��ȡϵͳ�����ȡ�һ����ʼ���������֮�󣬾ͻ������һ����������D�D Bootstrap Loader �� Bootstrap Loader ���� C++ ��׫д���ɣ���� Bootstrap Loader �����ĳ�ʼ�����У�����һЩ�����ĳ�ʼ������֮�⣬����Ҫ�ľ��Ǽ��� Launcher.java ֮�е� ExtClassLoader �����趨�� Parent Ϊ null �������丸������Ϊ BootstrapLoader ��Ȼ�� Bootstrap Loader ��Ҫ����� Launcher.java ֮�е� AppClassLoader �����趨�� Parent Ϊ֮ǰ������ ExtClassLoader ʵ�塣�����������������Ծ�̬�����ʽ���ڵġ�����Ҫ����ע����ǣ� Launcher$ExtClassLoader.class �� Launcher$AppClassLoader.class ������ Bootstrap Loader �����أ����� Parent �����ĸ������������û�й�ϵ��

�����ͼ�ο��Ա�ʾ����֮��Ĺ�ϵ��

����

����

����

����

BootstrapLoader

  PARENT

AppClassLoader

PARENT

ExtClassLoader

�������������͹������ǵ� Java �������ϵ�����Ƿֱ�����µ�·��Ѱ�ҳ�������Ҫ���ࣺ

BootstrapLoader �� sun.boot.class.path

ExtClassLoader: java.ext.dirs

AppClassLoader: java.class.path

������ϵͳ��������ͨ�� System.getProperty() �����õ������Ӧ��·������ҿ����Լ����ʵ�ֲ鿴�����·����

   

5�� �ܽ�

�˽� Java ������ػ��ƶ���������������� Java ���ԣ���߳��������Ч�����ŷǳ���Ҫ�����ã�֪��ȻҲҪ֪������Ȼ���������ܴ�������߳����������


�����Ǹ���Ϊ�˱�ҵҪ�����һƪ����,û��ʲô���,�����ټ�������һ�����ClassLoader��һ������:

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

���Գ���:
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

��ClassLoaderTest1,ClassLoaderTest2�ڵ�ǰĿ¼��E:/JAVA/MyProject/string/�����ڵ�ʱ�����Ϊsun.misc.Launcher$AppClassLoader@1050169
  sun.misc.Launcher$AppClassLoader@1050169
�����Ǳ�AppClassLoader���ص�, ��ʹ��E:/JAVA/MyProject/string/����Ҳ����.

��ClassLoaderTest1,ClassLoaderTest2ֻ��E:/JAVA/MyProject/string/�´��ڵ�ʱ�����Ϊ
java.net.URLClassLoader@480457
java.net.URLClassLoader@1a7bf11
�����Ǳ��Զ���ļ��������ص�,����Ҳ����Object test = tempClass.newInstance();

����һ������ؼ���,��ΪClassLoaderTest1��Ҫ�õ�ClassLoaderTest2,���ClassLoaderTest2��AppClassLoader����,��ClassLoaderTest1�Ǳ��Զ���������������,�ͻ�������´���:

java.lang.IllegalAccessError: tried to access class ClassLoaderTest2 from class ClassLoaderTest1
at ClassLoaderTest1.<init>(ClassLoaderTest1.java:6)
at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:39)
at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:27)
at java.lang.reflect.Constructor.newInstance(Constructor.java:274)
at java.lang.Class.newInstance0(Class.java:308)
at java.lang.Class.newInstance(Class.java:261)
at ClassLoaderTest.main(ClassLoaderTest.java:43)