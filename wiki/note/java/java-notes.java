异常
 运行期出现的错误
1.java异常的概念
    java提供的用于处理程序中错误的一种机制（运行时出现的异常时间）
    抛出异常：java程序在执行过程中出现异常事件，可以生成一个异常类对象，该对象封装了异常事件的信息并提交给Java运行时系统，这个过程叫抛出异常
    捕获异常：java运行时系统接受到异常对象时，会寻找能处理这个异常的代码并把当前异常对象交给其处理，这个过程叫捕获异常
    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3 //返回一个ArrayIndexOutOfBoundsException异常
    catch(Exception e){e.printStackTrace();}
    想用catch必须有try
2.java异常的分类
    public void method() throws SomeExcepton
    {
	    if(SomeCondition)
	    {
		    throw SomeExcepton;
		}
	}
	try
	{
	method()	
	}catch(SomeExcepton e)
	{
		//处理代码
	}
	Throwable 
	       Error//系统错误，处理不了的错误
	       Exception 
	             ClassNotFoundException InterruptedException//必须得捕获异常
			 RuntimeException//可以不捕获异常
	                   ArithmeticException
	                   NullPointException
	                  IndexOutOfBoundsException
	                       ArrayIndexOutOfBoundsException
	                       StringIndexOutOfBoundsException
3.异常的捕获和处理
    非运行时异常必须得捕获异常
	try
	{}//可能会出现异常的语句
	catch(SomeExcepton1)//可能出现的异常捕获及处理
		{}
	catch(SomeExcepton2)
		{}                      //可以使用捕获到的对象的方法　getMessage() printStackTrace()
	finally{}//无论怎样都会执行的语句,为异常的统一出口，为资源的清理工作  关闭开打开的文件，删除临时文件等
例子
package cn.java.exception.org;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Arithmetic_exception
{
	public static void main(String[] args)
	{
		/*Arithmetic_exception a = new Arithmetic_exception();
		a.m(0);
		
		try
		{
			new Arithmetic_exception().m(0);
		}catch(ArithmeticException e)
		{
			System.out.print("出错了");
		}
		*/
		FileInputStream in = null;
		try
		{
			in = new FileInputStream("myfile.txt");//FileInputStream对象可以抛出IOException异常对象，必须捕获异常
			int b ;
			b = in.read();
			while(b!=-1)
			{
				System.out.print((char)b);
				b = in.read();
			}
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)          
		{
			System.out.print(e.getMessage());
		}
		finally 
		{
			try{
			in.close();}
			catch(IOException e)
			{e.printStackTrace();}
		}
	}
    /*void m(int i) throws ArithmeticException
    {
    	if(i==0)
    	{
    		throw new ArithmeticException("被除数为0");
    	}
    }
    */
	void f1() throws FileNotFoundException,IOException//处理不了异常 先抛出异常
    {
    	FileInputStream in = new FileInputStream("myfile.txt");
    	int b;
    	b = in.read();
    	while(b!=-1)
		{
			System.out.print((char)b);
			b = in.read();
		}
    }
    void f2() //或者直接 throws Exception 
    {
    	try
    	{
    	f1();
    	}
    	catch(FileNotFoundException e)
    	{e.printStackTrace();}
    	catch(IOException e)
    	{e.printStackTrace();}
    	finally
    	{
    		
    	}
    }
}
如果不想写try catch　则可以在方法后面写 throws  SomeExcepton ，最简单的Exception
在方法后跟的是throws 而在方法体中 如果想要抛出异常 则必须throw SomeExcepton
void m(int i) throws ArithmeticException
{
	if(i==0) throw ArithmeticException("被除数为0");
	}
如果想捕获多个异常，则将最小的exception放在最前面捕获.父类的exception放在后面
4.自定义的异常
  继承java.lang.Exception类声明自己的异常类
   在方法的声明部分用throws抛出可能出现的异常
  　在方法体中可以出现异常的位置用throw抛出异常并生成实例对象
	重写方法要抛出跟原来一样的异常或不抛出异常

------------------------------------------------------
日期处理
例子：从数据库中拿出一个日期并格式化显示	
package cn.java.date.org;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestDate {
 public static void main(String[] args) throws Exception
   {
	 String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	 String DBURL = "jdbc:oracle:thin:@192.168.1.3:1521:laopo";
	 String USERNAME = "scott";
	 String PASSWORD = "tiger";
	 Class.forName(DBDRIVER);
	 Connection cnn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
	 Statement stmt = cnn.createStatement();
	 ResultSet rs = stmt.executeQuery("select * from test");
	 while(rs.next())
	 {
		 System.out.println(rs.getString(1)+"的年龄是"+rs.getString(2)+"岁");
	 }
	 rs.close();
	 stmt.close();
	 cnn.close();
    }
}
    对数据库的操作
    获取数据库对象的结果集rs
    调用getString(int i) 方法获取字段
----------------------------------------------------------------------
package cn.java.date.org;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.text.*;
public class TestDate {
 public static void main(String[] args) throws Exception
   {
	 String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	 String DBURL = "jdbc:oracle:thin:@192.168.1.3:1521:laopo";
	 String USERNAME = "scott";
	 String PASSWORD = "tiger";
	 Class.forName(DBDRIVER);
	 Connection cnn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
	 Statement stmt = cnn.createStatement();
	 ResultSet rs = stmt.executeQuery("select pdate from test");
	 while(rs.next())
	 {
		 Date d = rs.getDate("pdate");
		 System.out.println(rs.getDate("pdate"));
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		 System.out.println(sdf.format(d));
	 }
	 rs.close();
	 stmt.close();
	 cnn.close();
    }
}
如rs返回的是一个date类型则用rs的getDate()方法获取一个Date对象
如果想指定输出Date的格式，则先定义一个SimpleDateFormat 对象，同时规定参数为"yyyy年mm月dd日"等格式，输出时的参数为SimpleDateFormat对象的format()方法，参数为date类型的对象
----------------------------------------------------------------------
package cn.java.date.org;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.text.*;
import java.util.Calendar;
public class TestDate {
 public static void main(String[] args) throws Exception
   {
	 String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	 String DBURL = "jdbc:oracle:thin:@192.168.1.3:1521:laopo";
	 String USERNAME = "scott";
	 String PASSWORD = "tiger";
	 Class.forName(DBDRIVER);
	 Connection cnn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
	 Statement stmt = cnn.createStatement();
	 ResultSet rs = stmt.executeQuery("select pdate from test");
	 while(rs.next())
	 {
		 Date d = rs.getDate("pdate");
		 Calendar c = Calendar.getInstance();
		 c.setTime(d);
		 System.out.println(c.get(Calendar.MONTH));
	 }
	 rs.close();
	 stmt.close();
	 cnn.close();
    }
}
如果想获取date 的int型月份，则先定义一个Calendar对象(构造方法为Calendar.getInstance()),调用该对象的setTime()方法，参数为date类型对象，则该月的Int型为CalendarObjectName.get(Calendar.MONTH)
----------------------------------------------------------------------------
package cn.java.date.org;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.*;
import java.util.Calendar;
public class TestDate {
 public static void main(String[] args) throws Exception
   {
	 String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	 String DBURL = "jdbc:oracle:thin:@192.168.1.3:1521:laopo";
	 String USERNAME = "scott";
	 String PASSWORD = "tiger";
	 Class.forName(DBDRIVER);
	 Connection cnn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
	 Statement stmt = cnn.createStatement();
	 ResultSet rs = stmt.executeQuery("select sysdate from emp");
	 while(rs.next())
	 {
		 Timestamp ts = rs.getTimestamp("sysdate");
		 SimpleDateFormat s = new SimpleDateFormat("HH:MM:SS");
		 System.out.println(s.format(ts));
	 }
	 rs.close();
	 stmt.close();
	 cnn.close();
    }
}
想要获得数据库中的日期型对象并显示其时间对象，则定义一个Timestamp对象，由ResultSet对象的getTimestamp()方法获得，参数为ResultSet对象；定义输出Time对象的格式，然后 SimpleDateFormatObjectName.format(TimestampObjectName)
-------------------------------------------------------------------
什么是utc/ut/gmt
      世界标准时间
如何获取当前时间并格式化
	java.lang.System
	java.util.TimeZone
         java.util.Calendar
            java.util.GregorianCalendar
	   java.text.DateFormat
            java.text.SimpleDateFormat
         java.util.Date
		java.sql.Date //sql
            java.sql.Time
            java.sql.Timestamp
如何将一个字符型对象转换为date和time对象
定义一个Timestamp 对象，调用valueOf()方法，参数为该string对象
如何处理数据库中的date/time对象
package cn.java.date.org;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TestTimeDateDemo {
  public static void main(String[] args)
  {
	  System.out.println(System.currentTimeMillis());
	  Date d = new Date();
	  Calendar c = Calendar.getInstance();
	  SimpleDateFormat s = new SimpleDateFormat("yyyy年mm月dd日");
	  String st = "1970-12-24 12:23:34.0";
	  Timestamp ts = Timestamp.valueOf(st);
	  System.out.println(st);
	  
	  Calendar cJapan = new GregorianCalendar(TimeZone.getTimeZone("Japan"));
	  System.out.println(cJapan.get(Calendar.HOUR_OF_DAY));
  }
}

---------------------------------------------
String类

  字符串相关类(String StringBuffer)
        java.lang.String代表不可变的字符序列
        构造方法
             String(String original) //创建一个String对象为original对象的copy
             String(char[] value)//用一个字符数组创建String对象
             String(char[] value,int offset,int count)//用一个字符数组从offset开始到count个字符序列创建String对象
public class Test
{
     public static void main(String[] args)
     {
	     String s1 = "hello";
	     String s2= "hello";
	     String s3= "world";
	     System.out.println(s1==s2); //true,将date区域的字符串常量“hello” s1,s3分别指向它，即所引用的对象相同*/
	     System.out.println(s1.equals(s2));
	     System.out.println(s1==s3);
	     String s4 = new String("hello");
	     String s5= new String("hello");
	     String s6= new String("world");
	     System.out.println(s4==s5); //false,为s4 s5分别划分两个空间来指向
	     System.out.println(s4.equals(s5));//比较两个值是否相等 所有object的方法 equals()
	     System.out.println(s4==s6);
	     
	     char c[] = {'s','u','n',' ','j','a','v','a'};
	     String s7 = new String(c);
	     String s8 = new String(c,4,4);
	     System.out.println(s7);
	     System.out.println(s8);
	}	     
}
String类的常用方法
   charAt(int index)
   length()
   indexOf(String str)
   indexOf(String str,int fromIndex)
   boolean equalsIgnorceCase(String another)
   replace(char oldChar,char newChar)
   boolean startsWith(String prefix)//是否以指定字符开头
   boolean endsWith(String suffix)//是否以指定字符结尾
   toUpper(String str)
   toLower(String str)
   substring(int beginIndex)
   substring(int startIndex,int endIndex)//取从指定位置截取的字符子串
   trim() //去除空格
   valueOf()//可以将基本类型转换为字符串类型,java多态性
   String[] split(String regex)//将字符串以指定的分隔符分隔并返回处理后的字符串数组
/*
算法程序题：   
          该公司笔试题就1个，要求在10分钟内作完。   
          题目如下：用1、2、2、3、4、5这六个数字，用java写一个main函数，打印出所有不同的排列，如：512234、412345等，要求："4"不能在第三位，"3"与"5"不能相连。 
*/
public class Demo
{
	static int num = 0;	
	public static void main(String[] args)
	{
           for(int i1=0;i1<10;i1++) 
		{
		     if(i1 == 0) continue;
                 for(int i2=0;i2<10;i2++) 
		          {
		              if(i2==0) continue;
                         for(int i3=0;i3<10;i3++)
		                  {
		                      if(i2==0) continue;
                                  for(int i4=0;i4<10;i4++) 
		                            {
		                                  if(i2==0) continue;
							    if(i2==4) continue;
                                              for(int i5=0;i5<10;i5++) 
                                                     { 
									     StringBuffer sb=new StringBuffer();
			                                         if(i2==0) continue;  
									     sb = sb.append(i1).append(i2).append(i3).append(i4).append(i5);
									     if(sb.toString().indexOf("35")>=0) continue;
									     System.out.println(sb); 
									     num++;  
                                                      }
		                             }
	                       }
                       }
            }
	     System.out.println(num);
     }
}
  基本数据类型包装类
  Math类
  File类
  枚举类
StringBuffer类
    可变的字符序列
    StringBuffer可以对其字符串进行改写
    常用构造方法：
            StringBuffer()
		StringBuffer(String str)
     常用方法：
            append(Object object)//添加各种对象
		insert(Object object)//在指定位置添加字符序列
		delete(int start,int end)//删除指定位置的字符序列
		与String相同的方法
		       indexOf()
			 substring()
			 length()
		reverse()//可以将字符序列逆转
-------------------------------------------
基本数据类型包装类
java.lang.Integer
     Integer(int value)
     Integer(String s)
例子
public class Test
{
    public static void main(String[] args)
	{
		Integer i = new Integer(100);
		Double d = new Double("123.45");
		int j = i.intValue()+d.intValue();
		float f = i.floatValue()+d.floatValue();
		System.out.println(j);
		System.out.println(f);
		double pi = Double.parseDouble("3.1415926535");//
		double r = Double.valueOf("2.0").doubleValue();//任意字符串对象转换为Double对象,并转换为基本double数据类型
		double s = pi*r*r;
		System.out.println(s);
	}
}
任意类型转化为Int对象： 	Integer i = new Integer(100);
任意类型转化为Double对象： 	Integer i = new Integer("110.0");
Integer对象转换成基本数据类型：   int j = i.intValue(); float f  = i.floatValue();
Double对象转换成基本类型：   double  d = i.intValue(); float f = d.floatValue();
任意类型转换成double类型：double d = Double.parseDouble("3.1415");  double d = Double.valueOf("301415").doubleValue();
----------------------------------
Math类
  abs() sqrt() pow(double a,double b) log exp max(double a,double b) min(double a,double b)  long round() random()
---------------------------------
File类
 java.io.File代表系统文件名
     常见构造方法：
         public File(String pathname)  //以pathname为路径创建file对象，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储
         public File(String parent,String child) //以pathname的parent为父路径,child为子路径创建file对象
         File的静态属性String separator存储了当期系统的路径分隔符
      通过File对象可以访问文件的属性
             boolean canRead()
             boolean canWrite()
             boolean exists()
		boolean isDirectory()
            boolean isFile()
		boolean isHidden()
	      long lastModified()
		long length()
		String getName()
		String getPath()
	通过file对象创建文件或目录
	     boolean createNewFile() throws IOException
	     boolean delete()
	     boolean mkdir()
	     boolean mkdirs()
例子
import java.io.*;
public class TestFile
{
	public static void main(String[] args)
	{
		String separator = File.separator;//定义反斜杠
		String filename = "myfile.txt";//文件名
		String directory = "mydir1"+separator+"mydir2";//文件的路径
		File f = new File(directory,filename);//创建文件，参数为文件路径和文件名
		if(f.exists())
		{
			System.out.println("文件名："+f.getAbsolutePath());
			System.out.println("文件大小："+f.length());
			}else
			{
				f.getParentFile().mkdirs();
				try
				{
					f.createNewFile();
					}catch(IOException e)
					{
						e.printStackTrace();
						}
				}
		}
	}
获取目录 树
import java.io.*;
public class FileList
{
	public static void main(String[] args)
	{
		File  f = new File("D:");
		System.out.println(f.getName());
		tree(f,1);
	}
	private static void tree(File f,int level)//列出File文件下level级目录
		{
			String preStr="";
			for(int i = 0;i<level;i++)
			{
				preStr +=" ";
			}
			File[] childs = f.listFiles();//返回一个抽象路径名数组，这些路径名表示此抽象路径名所表示目录中的文件
			for(int i = 0 ;i<childs.length;i++)
			{
				System.out.println(preStr+childs[i].getName());
				if(childs[i].isDirectory())//测试该文件是否一个目录，如是则转入下一循环
				{
					tree(childs[i],level+1);
				}
			}
		}
}
	
-------------------------------
容器
   容器的概念
   容器API java.util.*;
	Collection //存取一组对象的方法
	       Set //数据对象没有顺序不可重复
			HashSet
		 List//数据对象有顺序可重复
	            LinkedList
	            ArrayList
      Map   //存储"key--value"的映射对的方法
	      HashMap
   Collection接口
      方法：
	int size(); //元素个数
	boolean isEmpty();//是否空
	void clear();//清空
      boolean contains(Object element);//是否包含了一个对象
	boolean add(Object element);//是否包含一个对象
	boolean remove(Object element);//删除一个对象
	Iterator iterator();
	boolean containsAll(Collection c);//是否包含所有的对象
	boolean addAll(Collection c);
	boolean removeAll(Collection c);
	boolean retainAll(Collection c);
	Object[] toArray();
例子：
import java.util.*;
class CollectionTest
{
	public static void main(String[] args)
	{
		Collection c = new ArrayList();
		c.add("hellow");
		c.add(new Integer(100));
		c.add(new Double(200));
		c.add(new Float(2.014));
		System.out.println(c.size());
		System.out.println(c);
	}
}
容器对象在调用remove contains等方法时需要比较对象是否相等，这会涉及到对象类型的equals hashCode方法，对于自定义的类型，需要重写equals 和hashCode方法以实现自定义的对象相等规则
相等的对象应该具有相当的hash codes
public boolean equals(Object object)
{
	return super.equals(object);
}
public int hashCode()//做索引的时候必须用hashCode
{
	return super.hashCode();
}

   Iterator接口
	所有实现了Collection接口的容器类都有一个iterator方法以返回一个实现了Iterator接口的对象
      Iterator类对象称作迭代器，用以实现对容器内元素的遍历操作
      常用方法：
             boolean hasNext();//判断游标右边是否还有元素
             Object next();//返回并移动到下一个游标位置
             void remove();//删除左边的元素
//输出一个容器内的所有内容
import java.util.*;
class CollectionTest
{
	public static void main(String[] args)
	{
		Collection c = new HashSet();
		c.add(new Name("1","2"));
		c.add(new Name("2","3"));
		c.add(new Name("3","4"));
		c.add(new Name("5","6"));
		System.out.println(c.size());
		Iterator i = c.iterator();
		while(i.hasNext())
		{
			Name n = (Name)i.next();
			System.out.println(n.getString());
		}
	}
}
	class Name
	{
		private String firstName;
		private String lastName;
		public Name(String s1,String s2)
		{
			this.firstName = s1;
			this.lastName = s2;
		}
		public String  getString()
		{
			return firstName+" "+lastName;
		}
		public String getFirstName()
		{
			return firstName;
		}
	}
删除一个元素
import java.util.*;
class CollectionTest
{
	public static void main(String[] args)
	{
		Collection c = new HashSet();
		c.add(new Name("1","2"));
		c.add(new Name("2","3"));
		c.add(new Name("3","4"));
		c.add(new Name("5","6"));
		System.out.println(c.size());
		for(Iterator i = c.iterator();i.hasNext();)
		{
			Name n = (Name)i.next();
			if(n.getFirstName()=="5")
			{
				i.remove();
			}
		}
		Iterator i = c.iterator();
		while(i.hasNext())
		{
			Name n = (Name)i.next();
			System.out.println(n.getString());
		}
	}
}
	class Name
	{
		private String firstName;
		private String lastName;
		public Name(String s1,String s2)
		{
			this.firstName = s1;
			this.lastName = s2;
		}
		public String  getString()
		{
			return firstName+" "+lastName;
		}
		public String getFirstName()
		{
			return firstName;
		}
	}

   增强的for循环(简单遍历内容)
	遍历一个数组Array和容器Collection
      不能方便访问下标
	与Iterator相比，不能删除集合中的元素，在内部也是调用Iterator
import java.util.*;
class ForExTest
{
	public static void main(String[] args)
	{
		int[] pr = {1,23,45,67,8,9};
		for(int i:pr)
		{
			System.out.println(i);
		}
		Collection c = new ArrayList();
		c.add(new String("lord"));
		c.add(new String("king"));
		for(Object o:c)
		{
			System.out.println(o);
		}
	}
}
    Set接口
           Collection的子接口，元素没有顺序，不可重复的；相当与数学中的集合
           Set容器内有 HashSet TreeSet
import java.util.*;
class HashSetTest
{
	public static void main(String[] args)
	{
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		s1.add("a");s1.add("b");
		s2.add("3");s2.add("f");
		Set sn = new HashSet(s1);
		sn.addAll(s2);
		System.out.println(sn);
	}
}
    List接口和 Comparable接口
       List接口是Collection的子接口，实现List接口的容器类的元素是有序可重复的
	 List容器的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素
	 List容器类有ArrayList LinkedList
       常用方法：
		Object get(int index);
		Object set(int index ,Object element);
            void add(int index,Object element);
		Object remove(int index);
		int indexOf(Object o);
		int lastIndexOf(Object o);
例子
import java.util.*;
class LinkListTest
{
	public static void main(String[] args)
	{
		List l1 = new LinkedList();
		for(int i=1;i<100;i++)
		{
			l1.add("a"+i);
		}
		System.out.println(l1);
		l1.add(3,"lord");
		System.out.println(l1);
	}
}
 Lista常用算法
      java.util.*Collections提供了静态方法实现基于List容器的常用算法
      void sort(List)//对元素排序
      void shuffle(List)//随机排序
      void fill(List,object)//用特定的对象重写List容器
	void reverse(List)//逆序
      void copy(List dest,List src)//将一个容器的内容拷贝到另一个容器内
	int binarySearch(List,Object)//查找对象
import java.util.*;
class LinkListTestDemo
{
   public static void main(String[] args)
	{
		List l1 = new LinkedList();
		List l2 = new LinkedList();
		for(int i = 0;i<10;i++)
		{
			l1.add("a"+i);
		}
		System.out.println(l1);
		/*
		Collections.shuffle(l1);
		System.out.println(l1);
		Collections.reverse(l1);
		System.out.println(l1);
		*/
		System.out.println(Collections.binarySearch(l1,"a1")+1);
	}
}
    Comparable接口
        所有可以排序的类都实现了java.lang.Comparable接口
		public int compareTo(Object obj)
        实现该接口的类通过compareTo()方法来进行排序
import java.util.*;
class CompareableTest 
{
	public static void main(String[] args)
	{
		Collection c = new HashSet();
		c.add(new Name("lord","king"));
		c.add(new Name("lifeng","wang"));
		c.add(new Name("hongwei","cao"));
		Collections.sort(c);
	}
}
	class Name implements Comparable
	{
		private String firstName;
		private String lastName;
		public Name(String s1,String s2)
		{
			this.firstName = s1;
			this.lastName = s2;
		}
		public String  getString()
		{
			return firstName+" "+lastName;
		}
		public String getFirstName()
		{
			return firstName;
		}
		public int compareTo(Object o)
		{
			Name n = (Name)o;
			int fn = firstName.compareTo(n.firstName);
			int ln = lastName.compareTo(n.lastName);
			if(fn!=0)
				{
					return fn;
				}
			else return ln;
		}
	}
	如何选择数据结构
	   Array读快改慢
	   Linked改快读慢
	   Hash两者之间
    Map接口
	实现Map接口的类用来存储一对键-值
	实现类有HashMap和TreeMap
	通过键值对来实现标识，不能重复
	Object put(Object key,Object value);
	Object get(Object key);
	Object remove(Object key);
	boolean containsKey(Object key);
	boolean containValue(Object value);
	int size();
	boolean isEmpty();
	void putAll(Map t);
	void clear(); 
   自动打包/解包
	在Jdk5.0后，map接口的get() put()方法都允许使用值，可以不用对象例如
	Map hm = new HashMap();
	hm.put("1",1);//直接使用数值基本类型数据，不用先转化为对象
	自动将基础类型转换为对象，自动将对象转换为基本类型

import java.util.*;
public class ArgTest {
  private static final Integer ONE = new Integer(1);
  public static void main(String[] args)
  {
	  Map m = new HashMap();//建立一个hashmap对象
	  for(int i = 0;i<args.length;i++)
	  {
		  Integer freq = (Integer) m.get(args[i]);//捕获命令行输入的参数，左右hashmap的key来获取value,并将得到的value强制转换为Integer对象
		  m.put(args[i],(freq==null?ONE:new Integer(freq.intValue()+1)));//将输入的参数作为key,查询freq是否空Null，是则为1，否则累加1，所得到的数值左右value;
	  }
	  System.out.println(m.size()+"distinct words detected:");
	  System.out.println(m);
  }
}
   泛型
     jdk1.4之前装入集合的对象都被当作Object，失去了自己的实际类型；
     从集合中取出时需要转型，效率低
     解决办法： 在定义集合时同时定义集合中对象的类型
import java.util.*;
class fanxing
{
	public static void main(String[] args)
	{
		List<String> c = new ArrayList<String>();
		c.add("aaa");
		c.add("bbb");
		c.add("vvv");
		c.add("zzz");
		for(int i  =0;i<c.size();i++)
		{
			String s = c.get(i);
			System.out.println(s);
		}
		Collection<String> c1 = new HashSet<String>();
		c1.add("aaa");
		c1.add("bbb");
		c1.add("vvv");
		c1.add("zzz");
		for(Iterator<String> it = c1.iterator();it.hasNext();)
		{
			String s = it.next();
			System.out.println(s);
		}
		public class MyName implements Comparable<MyName>//规定只允许跟MyName对象比较，其他对象会报错
		{
			private int age;
			public int compareTo(MyName mn)
			{
				if(this.age>mn.age) return 1;
				else if(this.age=mn.age) return 0;
				else return -1;
			}
		}
	}
}

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	public static void main(String[] args)
	{
	    Map<String,Integer> hm = new HashMap<String,Integer>(); 
	    Map<String,Integer> tm = new TreeMap<String,Integer>();
	    hm.put("one",1);
	    hm.put("two", 2);
	    System.out.println(hm);
	    System.out.println(hm.containsKey("two"));
	    System.out.println(hm.containsValue(3));
	    if(hm.containsKey("one"))
	    {
	    	 int i = hm.get("two");
	    	 System.out.println(i);
	    }
	    tm.put("a", 1);
	    tm.put("b",2);
	    System.out.println(tm);
	}

}
流
    java流式输入输出原理
             java程序中数据的输入输出操作stream方式进行；程序中通过标准的方法来输入输出数据
    分类
             java.io
             数据：输入/输出流 InputStream/OutputStream(输入输出是相对于程序而言的)
             数据单元：字节/字符流Reader/Writer
             功能：节点/处理流  
                 节点流：从数据源读写数据
			处理流：连接在已经存在的流之上
    输入输出类
            InputStream
                 用于向程序中输入数据（8bit）
                 方法
                        int read() throws IOException //读取一个字节以Int型返回
				int read(byte[] buffer) throws IOException//读取一系列字节存储到buffer数组，返回实际读取的字节数
                        int read(byte[] buffer,int offset,int length) throws IOException//从Offset位置开始读取length个字节到buffer[]中，返回实际读取字节数
                        void close() throws IOException//关闭流
                        void skip(long n) throws IOException//跳过n个字节
            OutputStream
			用于从程序中输出数据
			       void write(int b) throws IOException//向输入流中写入一个字节数据
				 void write(byte[] b) throws IOException //将一个byte[]写入输入流
				 void write(byte[] b,int off,int len) throws IOException//将byte[]从指定位置off开始Len个字节到输入流
				 void close() throws IOException //关闭资源
				 void flush() throws IOException//将输出流中缓冲的数据全部写出到目的地
		Reader
			向程序中输入数据（字符16bit）
				int read() throws IOException//读取字符并以int型返回
				int read(char[] cbuff) throws IOException//读取一系列字符存储到char[]中，返回实际读取的字符数
				int read(char[] cbuff,int offset,int length)throws IOException//读取length个字符，从offset开始到char[]中
				void close() throws IOException//关闭流释放内存资源
				long skip(long n ) throws IOException//跳过n个字符不读
		Writer
		       程序中输入数据
			       void write(char c) throws IOException//向输出流中输入一个字符数据
				void write(char[] cbuff) throws IOException//将一个char[]写入到输出流
				void write(char[] cbuff,int offset,int length) throws IOException//将char[] length个字符从offset开始写入到输出流中
				void write(String string) throws IOException throws IOException//将一个String写入到输出流中
				void write(String string,int offset,int length) throws IOException//将String从offset位置开始 length个字符写入输出流
				void close() throws IOException//关闭输出流
				void flush() throws IOException//将缓冲区的字符串写出到目的地
常见的节点流和处理流
    节点流(可以访问file memory pipe的流)
	      File                FileReader   FileWriter                            FileInputStream     FileOutputStream
	      Memory Array  CharArrayReader   CharArrayWriter          ByteArrayInputStream   ByteArrayOutputStream	
	      Memory  String StringReader     StringWriter
		Pipe                PipedReader  PipedWriter                         PipedInputStream  PipedOutputStream
import java.io.*;
class FileInputStreamTest
{
	public static void main(String[] args)
	{
		long num = 0;
		int b = 0;//先将读取来到字符转换为int型
		FileInputStream in = null;
		try
		{
		in  = new FileInputStream("C:\\Documents and Settings\\Administrator\\桌面\\java-notes.java");//将指定位置的文件读到输入流对象中
		}
		catch(FileNotFoundException e)
		{
			System.out.println("找不到文件");
			System.exit(-1);
		}
		try
		{
		while((b=in.read())!=-1)//读取输入流中字符串
		{
			System.out.print((char)b);//将Int型的数据还原为char型输出
			num++;
		}
		in.close();
	    }catch(IOException e1)
	    {
		    System.out.println("文件读取错误");
		    System.exit(-1);
	    }
		System.out.println();
		System.out.println("共录入"+num+"个字符");
		
	}
}

import java.io.*;
public class FileInputTest 
{
	public static void main(String[] args) 
	{
		int b =0;
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			fi = new FileInputStream("C:\\Documents and Settings\\Administrator\\桌面\\java-notes.java");//将指定文件的内容读取到输入流 fi中
			fo = new FileOutputStream("C:\\Documents and Settings\\Administrator\\桌面\\test.txt");//将输出流读入指定的文件中
			while((b=fi.read())!=-1)
			{
				fo.write(b);//将从输出流读取的字符串写入输出流中
			}
			fi.close();
			fo.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}catch (IOException e1)
				{
			       e1.printStackTrace();
				}

	}
  }
处理流类型
    Buffering               BufferedReader BufferedWriter                      BufferedInputStream  BufferedOutputStream
    Filtering                 FilteredReader  FilterWriter                          FilteredInputStream   FilterOutputStream
    Convert                 InputStreamReader  OutputStreamWriter
    Object                                                                                ObjectInputStream ObjectOutputStream
     Date                                                                                  DateInputStream    DateOutStream
    Counting               LinkNumberReader                                       LinkNumberWriter
    Peeking ahead        PusbackReader                                           PusbackInputStream
    Printing                  PrintWriter                                                PrintStream
    缓冲流 
        缓冲流要套接在相应的节点流之上，对读写的数据缓冲来提高效率
       四种缓冲流的构造方法：
      BufferedReader(Reader in)
      BufferedReader(Reader in,int sz)
      BufferedWriter(Writer out)
      BufferedWriter(Writer out,int sz)
	BufferedInputStream(InputStream in)
      BufferedInputStream(InputStream in,int sz)
      BufferedOutputStream(OutputStream in)
      BufferedOutputStream(OutputStream in,int sz) 
      缓冲流支持其父类的mark和reset方法
	BufferedReader提供了readLine方法用于读取一行字符串（\r\n）
	BufferedWriter提供了newLine方法写入一个行分隔符
	对于输出流动缓冲区，使用flush将内存中的数据立刻写出
import java.io.*;
class BufferedTest
{
	public static void main(String[] args) throws IOException
	{
		//从DEMO.JAVA文件读取数据，建立一个匿名文件输入流，在此基础上建立一个输入缓冲流br
		BufferedReader br = new BufferedReader(new FileReader("C:\\Documents and Settings\\Administrator\\桌面\\Demo.java"));
		//建立一个文件输出流到文件demo1.java，在此基础上建立一个输出缓冲流bw
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Documents and Settings\\Administrator\\桌面\\Demo1.java"));
		String s = null;
		for(int i=0;i<100;i++)
		{
			Double j = Math.random()*100;
			int m = j.intValue();
			s=String.valueOf((char)m);
			//将字符s写入写缓冲bw中，通过FileWriter输入流写入文件Demo1.java文件中
			bw.write(s);
			//将一个换行符写入文件
			bw.newLine();
		}
		//将缓冲的bw全部写入文件中
		bw.flush();
		//建立一个缓冲输出流，整行输出文件demo.java的内容
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
		}
		bw.close();
		br.close();
	}
}
    转换流
	InputStreamReader和OutputStreamWriter用与字节数据到字符数据之间的转换
      InputStreamReader InputStream之间的套接
      OutputStreamWriter OutputStream之间的套接
      指定编码集合
         InputStream ist = new InputStreamReader(System.ip,"ISO8859-1");
import java.io.*;
public class TransformDemo01
{
	public static void main(String[] args) throws IOException
	{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Documents and Settings\\Administrator\\My Documents\\jocks1.txt"));//建立一个输出流，转换为字符型输出流
		osw.write("laopozaiganshenmene~~");//输出流写入数据
		System.out.println(osw.getEncoding());
		osw.close();
		//true是来决定是否在已经存在的文件后添加到符号
		osw = new OutputStreamWriter(new FileOutputStream("C:\\Documents and Settings\\Administrator\\My Documents\\jocks1.txt",true),"gb2312");
		osw.write("oh my lord上帝？");
		osw.close();
	}
}
import java.io.*;
public class TransformDemo02
{
	public static void main(String[] args) throws IOException
	{
		//System.in是一个标准的输入对象，从命令行出入数据
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		s=br.readLine();
		while(s!=null)
		{
			if(s.equalsIgnoreCase("exit")) break;
			System.out.println(s);
			s = br.readLine();
		}
		br.close();
	}
}
    数据流
       DataInputStream和DataOutputStream分别继承自 InputStream和OutputStream，套接在两个流上去存Java基本类型数据
package cn.java.IO.org;

import java.io.*;

public class TestDataStream 
{
    public static void main(String[] args)
    {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
    	DataOutputStream dos = new DataOutputStream(bos);
    	try {
			dos.writeDouble(Math.random());
			dos.writeBoolean(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		DataInputStream dis = new DataInputStream(bis);
		try {
			System.out.print(dis.readBoolean());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(dis.readDouble());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//流输出是先进先出原则，此处的Boolean和Double不能不分先后		
    }
}
    print流
	PrintWriter 和PrintStream都属于输出流，针对字符和字节
       Println用于多种数据类型的输出
      不会抛异常，有自动flush功能
//向unicode字符写入一个文件中
package cn.java.IO.org;
import java.io.*;
public class PrintStream01 {
	public static void main(String[] args) throws FileNotFoundException 
	{
		FileOutputStream fos = new FileOutputStream("d:\\bak.txt");
        PrintStream  ps = null;
        ps = new PrintStream(fos);//用一个FileOutputStream构造一个PrintStream对象
        if(ps!=null)
        {
        	System.setOut(ps);//设置指定字符输出的对象是一个PrintStream对象
        }
        for(int i=0;i<65536;i++)
        {
        	char c = (char)i;
        	System.out.print(c+" ");//用System的out对象的print方法来实现将指定的字符写入指定的位置(一个指向文件的PrintStream对象)
        	if(c%100==0){System.out.println();}
        }
	}
//
}
//将指定文件输出到控制台显示
package cn.java.IO.org;
import java.io.*;
public class PrintStream02 {
	public static void main(String[] args) throws IOException 
	{
		String filename = args[0];//获取从console输入的字符串filename
		if(filename!=null)
		{
			list(filename,System.out);//调用list方法
		}
	}
	//
	public static void list(String f,PrintStream ps) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(f));//通过FileReader对象构造一个BufferedReader对象
		String s1 = null;
		while((s1=br.readLine())!=null){ps.println(s1);}//将从缓冲流BufferedReader获取的字符串写入PrintStream对象中
		ps.close();
		br.close();
	}

}

//写一个日志
package cn.java.IO.org;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
public class PrintStream03 {
	public static void main(String[] args) throws IOException
	{
		String s = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//设置一个从console输入参数的InputStreamReader，用BufferedReader来套接在其上
            FileWriter fw = new FileWriter("d://log.txt",true);//构造一个写入文件log.txt的FileWriter流对象fw
            PrintWriter pw = new PrintWriter(fw);//通过FileWriter对象构造一个PrintWriter对象，用来将指定的字符写入到此流上
            while((s=br.readLine())!=null)
            {
        	   if(s.equalsIgnoreCase("exit")) break;
        	   System.out.println(s.toUpperCase());//将从BufferedWriter读来的字符串写入System.out对象也就是Console命令行中
               pw.print("------------------");
		   pw.println();
               pw.println(s.toUpperCase());//将从BufferedWriter读来的字符串写入PrintWriter对象中，也就是写入文件中
               pw.write("===="+new Date()+"=====");
               pw.println();
            }
            pw.close();
	}

}

    Object流
	直接将object写入或输出   
import java.io.*;
public class ObjectStream01
{
	public static void main(String[] args) throws Exception
	{
		T t = new T();
		t.name="lord";
		t.age=1;
		t.sex="男";
		FileOutputStream fos = new FileOutputStream("D:/FileOutputStream.text");//建立一个FileOutputStream对象，向文件输入内容
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		FileInputStream fis = new FileInputStream("D:/FileOutputStream.text");
	      ObjectInputStream ois = new ObjectInputStream(fis);
		oos.writeObject(t);
		oos.flush();
		oos.close();
		T tOb = (T)ois.readObject();
		System.out.println(tOb.name+"  "+tOb.age+"  "+tOb.sex);
	}
}
class T implements Serializable 
{
	String name;
	int age;
	String sex;
}
