�쳣
 �����ڳ��ֵĴ���
1.java�쳣�ĸ���
    java�ṩ�����ڴ�������д����һ�ֻ��ƣ�����ʱ���ֵ��쳣ʱ�䣩
    �׳��쳣��java������ִ�й����г����쳣�¼�����������һ���쳣����󣬸ö����װ���쳣�¼�����Ϣ���ύ��Java����ʱϵͳ��������̽��׳��쳣
    �����쳣��java����ʱϵͳ���ܵ��쳣����ʱ����Ѱ���ܴ�������쳣�Ĵ��벢�ѵ�ǰ�쳣���󽻸��䴦��������̽в����쳣
    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3 //����һ��ArrayIndexOutOfBoundsException�쳣
    catch(Exception e){e.printStackTrace();}
    ����catch������try
2.java�쳣�ķ���
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
		//�������
	}
	Throwable 
	       Error//ϵͳ���󣬴����˵Ĵ���
	       Exception 
	             ClassNotFoundException InterruptedException//����ò����쳣
			 RuntimeException//���Բ������쳣
	                   ArithmeticException
	                   NullPointException
	                  IndexOutOfBoundsException
	                       ArrayIndexOutOfBoundsException
	                       StringIndexOutOfBoundsException
3.�쳣�Ĳ���ʹ���
    ������ʱ�쳣����ò����쳣
	try
	{}//���ܻ�����쳣�����
	catch(SomeExcepton1)//���ܳ��ֵ��쳣���񼰴���
		{}
	catch(SomeExcepton2)
		{}                      //����ʹ�ò��񵽵Ķ���ķ�����getMessage() printStackTrace()
	finally{}//������������ִ�е����,Ϊ�쳣��ͳһ���ڣ�Ϊ��Դ��������  �رտ��򿪵��ļ���ɾ����ʱ�ļ���
����
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
			System.out.print("������");
		}
		*/
		FileInputStream in = null;
		try
		{
			in = new FileInputStream("myfile.txt");//FileInputStream��������׳�IOException�쳣���󣬱��벶���쳣
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
    		throw new ArithmeticException("������Ϊ0");
    	}
    }
    */
	void f1() throws FileNotFoundException,IOException//�������쳣 ���׳��쳣
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
    void f2() //����ֱ�� throws Exception 
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
�������дtry catch��������ڷ�������д throws  SomeExcepton ����򵥵�Exception
�ڷ����������throws ���ڷ������� �����Ҫ�׳��쳣 �����throw SomeExcepton
void m(int i) throws ArithmeticException
{
	if(i==0) throw ArithmeticException("������Ϊ0");
	}
����벶�����쳣������С��exception������ǰ�沶��.�����exception���ں���
4.�Զ�����쳣
  �̳�java.lang.Exception�������Լ����쳣��
   �ڷ���������������throws�׳����ܳ��ֵ��쳣
  ���ڷ������п��Գ����쳣��λ����throw�׳��쳣������ʵ������
	��д����Ҫ�׳���ԭ��һ�����쳣���׳��쳣

------------------------------------------------------
���ڴ���
���ӣ������ݿ����ó�һ�����ڲ���ʽ����ʾ	
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
		 System.out.println(rs.getString(1)+"��������"+rs.getString(2)+"��");
	 }
	 rs.close();
	 stmt.close();
	 cnn.close();
    }
}
    �����ݿ�Ĳ���
    ��ȡ���ݿ����Ľ����rs
    ����getString(int i) ������ȡ�ֶ�
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
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		 System.out.println(sdf.format(d));
	 }
	 rs.close();
	 stmt.close();
	 cnn.close();
    }
}
��rs���ص���һ��date��������rs��getDate()������ȡһ��Date����
�����ָ�����Date�ĸ�ʽ�����ȶ���һ��SimpleDateFormat ����ͬʱ�涨����Ϊ"yyyy��mm��dd��"�ȸ�ʽ�����ʱ�Ĳ���ΪSimpleDateFormat�����format()����������Ϊdate���͵Ķ���
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
������ȡdate ��int���·ݣ����ȶ���һ��Calendar����(���췽��ΪCalendar.getInstance()),���øö����setTime()����������Ϊdate���Ͷ�������µ�Int��ΪCalendarObjectName.get(Calendar.MONTH)
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
��Ҫ������ݿ��е������Ͷ�����ʾ��ʱ���������һ��Timestamp������ResultSet�����getTimestamp()������ã�����ΪResultSet���󣻶������Time����ĸ�ʽ��Ȼ�� SimpleDateFormatObjectName.format(TimestampObjectName)
-------------------------------------------------------------------
ʲô��utc/ut/gmt
      �����׼ʱ��
��λ�ȡ��ǰʱ�䲢��ʽ��
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
��ν�һ���ַ��Ͷ���ת��Ϊdate��time����
����һ��Timestamp ���󣬵���valueOf()����������Ϊ��string����
��δ������ݿ��е�date/time����
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
	  SimpleDateFormat s = new SimpleDateFormat("yyyy��mm��dd��");
	  String st = "1970-12-24 12:23:34.0";
	  Timestamp ts = Timestamp.valueOf(st);
	  System.out.println(st);
	  
	  Calendar cJapan = new GregorianCalendar(TimeZone.getTimeZone("Japan"));
	  System.out.println(cJapan.get(Calendar.HOUR_OF_DAY));
  }
}

---------------------------------------------
String��

  �ַ��������(String StringBuffer)
        java.lang.String�����ɱ���ַ�����
        ���췽��
             String(String original) //����һ��String����Ϊoriginal�����copy
             String(char[] value)//��һ���ַ����鴴��String����
             String(char[] value,int offset,int count)//��һ���ַ������offset��ʼ��count���ַ����д���String����
public class Test
{
     public static void main(String[] args)
     {
	     String s1 = "hello";
	     String s2= "hello";
	     String s3= "world";
	     System.out.println(s1==s2); //true,��date������ַ���������hello�� s1,s3�ֱ�ָ�������������õĶ�����ͬ*/
	     System.out.println(s1.equals(s2));
	     System.out.println(s1==s3);
	     String s4 = new String("hello");
	     String s5= new String("hello");
	     String s6= new String("world");
	     System.out.println(s4==s5); //false,Ϊs4 s5�ֱ𻮷������ռ���ָ��
	     System.out.println(s4.equals(s5));//�Ƚ�����ֵ�Ƿ���� ����object�ķ��� equals()
	     System.out.println(s4==s6);
	     
	     char c[] = {'s','u','n',' ','j','a','v','a'};
	     String s7 = new String(c);
	     String s8 = new String(c,4,4);
	     System.out.println(s7);
	     System.out.println(s8);
	}	     
}
String��ĳ��÷���
   charAt(int index)
   length()
   indexOf(String str)
   indexOf(String str,int fromIndex)
   boolean equalsIgnorceCase(String another)
   replace(char oldChar,char newChar)
   boolean startsWith(String prefix)//�Ƿ���ָ���ַ���ͷ
   boolean endsWith(String suffix)//�Ƿ���ָ���ַ���β
   toUpper(String str)
   toLower(String str)
   substring(int beginIndex)
   substring(int startIndex,int endIndex)//ȡ��ָ��λ�ý�ȡ���ַ��Ӵ�
   trim() //ȥ���ո�
   valueOf()//���Խ���������ת��Ϊ�ַ�������,java��̬��
   String[] split(String regex)//���ַ�����ָ���ķָ����ָ������ش������ַ�������
/*
�㷨�����⣺   
          �ù�˾�������1����Ҫ����10���������ꡣ   
          ��Ŀ���£���1��2��2��3��4��5���������֣���javaдһ��main��������ӡ�����в�ͬ�����У��磺512234��412345�ȣ�Ҫ��"4"�����ڵ���λ��"3"��"5"���������� 
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
  �����������Ͱ�װ��
  Math��
  File��
  ö����
StringBuffer��
    �ɱ���ַ�����
    StringBuffer���Զ����ַ������и�д
    ���ù��췽����
            StringBuffer()
		StringBuffer(String str)
     ���÷�����
            append(Object object)//��Ӹ��ֶ���
		insert(Object object)//��ָ��λ������ַ�����
		delete(int start,int end)//ɾ��ָ��λ�õ��ַ�����
		��String��ͬ�ķ���
		       indexOf()
			 substring()
			 length()
		reverse()//���Խ��ַ�������ת
-------------------------------------------
�����������Ͱ�װ��
java.lang.Integer
     Integer(int value)
     Integer(String s)
����
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
		double r = Double.valueOf("2.0").doubleValue();//�����ַ�������ת��ΪDouble����,��ת��Ϊ����double��������
		double s = pi*r*r;
		System.out.println(s);
	}
}
��������ת��ΪInt���� 	Integer i = new Integer(100);
��������ת��ΪDouble���� 	Integer i = new Integer("110.0");
Integer����ת���ɻ����������ͣ�   int j = i.intValue(); float f  = i.floatValue();
Double����ת���ɻ������ͣ�   double  d = i.intValue(); float f = d.floatValue();
��������ת����double���ͣ�double d = Double.parseDouble("3.1415");  double d = Double.valueOf("301415").doubleValue();
----------------------------------
Math��
  abs() sqrt() pow(double a,double b) log exp max(double a,double b) min(double a,double b)  long round() random()
---------------------------------
File��
 java.io.File����ϵͳ�ļ���
     �������췽����
         public File(String pathname)  //��pathnameΪ·������file�������pathname�����·������Ĭ�ϵĵ�ǰ·����ϵͳ����user.dir�д洢
         public File(String parent,String child) //��pathname��parentΪ��·��,childΪ��·������file����
         File�ľ�̬����String separator�洢�˵���ϵͳ��·���ָ���
      ͨ��File������Է����ļ�������
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
	ͨ��file���󴴽��ļ���Ŀ¼
	     boolean createNewFile() throws IOException
	     boolean delete()
	     boolean mkdir()
	     boolean mkdirs()
����
import java.io.*;
public class TestFile
{
	public static void main(String[] args)
	{
		String separator = File.separator;//���巴б��
		String filename = "myfile.txt";//�ļ���
		String directory = "mydir1"+separator+"mydir2";//�ļ���·��
		File f = new File(directory,filename);//�����ļ�������Ϊ�ļ�·�����ļ���
		if(f.exists())
		{
			System.out.println("�ļ�����"+f.getAbsolutePath());
			System.out.println("�ļ���С��"+f.length());
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
��ȡĿ¼ ��
import java.io.*;
public class FileList
{
	public static void main(String[] args)
	{
		File  f = new File("D:");
		System.out.println(f.getName());
		tree(f,1);
	}
	private static void tree(File f,int level)//�г�File�ļ���level��Ŀ¼
		{
			String preStr="";
			for(int i = 0;i<level;i++)
			{
				preStr +=" ";
			}
			File[] childs = f.listFiles();//����һ������·�������飬��Щ·������ʾ�˳���·��������ʾĿ¼�е��ļ�
			for(int i = 0 ;i<childs.length;i++)
			{
				System.out.println(preStr+childs[i].getName());
				if(childs[i].isDirectory())//���Ը��ļ��Ƿ�һ��Ŀ¼��������ת����һѭ��
				{
					tree(childs[i],level+1);
				}
			}
		}
}
	
-------------------------------
����
   �����ĸ���
   ����API java.util.*;
	Collection //��ȡһ�����ķ���
	       Set //���ݶ���û��˳�򲻿��ظ�
			HashSet
		 List//���ݶ�����˳����ظ�
	            LinkedList
	            ArrayList
      Map   //�洢"key--value"��ӳ��Եķ���
	      HashMap
   Collection�ӿ�
      ������
	int size(); //Ԫ�ظ���
	boolean isEmpty();//�Ƿ��
	void clear();//���
      boolean contains(Object element);//�Ƿ������һ������
	boolean add(Object element);//�Ƿ����һ������
	boolean remove(Object element);//ɾ��һ������
	Iterator iterator();
	boolean containsAll(Collection c);//�Ƿ�������еĶ���
	boolean addAll(Collection c);
	boolean removeAll(Collection c);
	boolean retainAll(Collection c);
	Object[] toArray();
���ӣ�
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
���������ڵ���remove contains�ȷ���ʱ��Ҫ�Ƚ϶����Ƿ���ȣ�����漰���������͵�equals hashCode�����������Զ�������ͣ���Ҫ��дequals ��hashCode������ʵ���Զ���Ķ�����ȹ���
��ȵĶ���Ӧ�þ����൱��hash codes
public boolean equals(Object object)
{
	return super.equals(object);
}
public int hashCode()//��������ʱ�������hashCode
{
	return super.hashCode();
}

   Iterator�ӿ�
	����ʵ����Collection�ӿڵ������඼��һ��iterator�����Է���һ��ʵ����Iterator�ӿڵĶ���
      Iterator��������������������ʵ�ֶ�������Ԫ�صı�������
      ���÷�����
             boolean hasNext();//�ж��α��ұ��Ƿ���Ԫ��
             Object next();//���ز��ƶ�����һ���α�λ��
             void remove();//ɾ����ߵ�Ԫ��
//���һ�������ڵ���������
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
ɾ��һ��Ԫ��
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

   ��ǿ��forѭ��(�򵥱�������)
	����һ������Array������Collection
      ���ܷ�������±�
	��Iterator��ȣ�����ɾ�������е�Ԫ�أ����ڲ�Ҳ�ǵ���Iterator
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
    Set�ӿ�
           Collection���ӽӿڣ�Ԫ��û��˳�򣬲����ظ��ģ��൱����ѧ�еļ���
           Set�������� HashSet TreeSet
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
    List�ӿں� Comparable�ӿ�
       List�ӿ���Collection���ӽӿڣ�ʵ��List�ӿڵ��������Ԫ����������ظ���
	 List������Ԫ�ض���Ӧһ�������͵���ż������������е�λ�ã����Ը�����Ŵ�ȡ�����е�Ԫ��
	 List��������ArrayList LinkedList
       ���÷�����
		Object get(int index);
		Object set(int index ,Object element);
            void add(int index,Object element);
		Object remove(int index);
		int indexOf(Object o);
		int lastIndexOf(Object o);
����
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
 Lista�����㷨
      java.util.*Collections�ṩ�˾�̬����ʵ�ֻ���List�����ĳ����㷨
      void sort(List)//��Ԫ������
      void shuffle(List)//�������
      void fill(List,object)//���ض��Ķ�����дList����
	void reverse(List)//����
      void copy(List dest,List src)//��һ�����������ݿ�������һ��������
	int binarySearch(List,Object)//���Ҷ���
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
    Comparable�ӿ�
        ���п���������඼ʵ����java.lang.Comparable�ӿ�
		public int compareTo(Object obj)
        ʵ�ָýӿڵ���ͨ��compareTo()��������������
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
	���ѡ�����ݽṹ
	   Array�������
	   Linked�Ŀ����
	   Hash����֮��
    Map�ӿ�
	ʵ��Map�ӿڵ��������洢һ�Լ�-ֵ
	ʵ������HashMap��TreeMap
	ͨ����ֵ����ʵ�ֱ�ʶ�������ظ�
	Object put(Object key,Object value);
	Object get(Object key);
	Object remove(Object key);
	boolean containsKey(Object key);
	boolean containValue(Object value);
	int size();
	boolean isEmpty();
	void putAll(Map t);
	void clear(); 
   �Զ����/���
	��Jdk5.0��map�ӿڵ�get() put()����������ʹ��ֵ�����Բ��ö�������
	Map hm = new HashMap();
	hm.put("1",1);//ֱ��ʹ����ֵ�����������ݣ�������ת��Ϊ����
	�Զ�����������ת��Ϊ�����Զ�������ת��Ϊ��������

import java.util.*;
public class ArgTest {
  private static final Integer ONE = new Integer(1);
  public static void main(String[] args)
  {
	  Map m = new HashMap();//����һ��hashmap����
	  for(int i = 0;i<args.length;i++)
	  {
		  Integer freq = (Integer) m.get(args[i]);//��������������Ĳ���������hashmap��key����ȡvalue,�����õ���valueǿ��ת��ΪInteger����
		  m.put(args[i],(freq==null?ONE:new Integer(freq.intValue()+1)));//������Ĳ�����Ϊkey,��ѯfreq�Ƿ��Null������Ϊ1�������ۼ�1�����õ�����ֵ����value;
	  }
	  System.out.println(m.size()+"distinct words detected:");
	  System.out.println(m);
  }
}
   ����
     jdk1.4֮ǰװ�뼯�ϵĶ��󶼱�����Object��ʧȥ���Լ���ʵ�����ͣ�
     �Ӽ�����ȡ��ʱ��Ҫת�ͣ�Ч�ʵ�
     ����취�� �ڶ��弯��ʱͬʱ���弯���ж��������
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
		public class MyName implements Comparable<MyName>//�涨ֻ�����MyName����Ƚϣ���������ᱨ��
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
��
    java��ʽ�������ԭ��
             java���������ݵ������������stream��ʽ���У�������ͨ����׼�ķ����������������
    ����
             java.io
             ���ݣ�����/����� InputStream/OutputStream(�������������ڳ�����Ե�)
             ���ݵ�Ԫ���ֽ�/�ַ���Reader/Writer
             ���ܣ��ڵ�/������  
                 �ڵ�����������Դ��д����
			���������������Ѿ����ڵ���֮��
    ���������
            InputStream
                 ������������������ݣ�8bit��
                 ����
                        int read() throws IOException //��ȡһ���ֽ���Int�ͷ���
				int read(byte[] buffer) throws IOException//��ȡһϵ���ֽڴ洢��buffer���飬����ʵ�ʶ�ȡ���ֽ���
                        int read(byte[] buffer,int offset,int length) throws IOException//��Offsetλ�ÿ�ʼ��ȡlength���ֽڵ�buffer[]�У�����ʵ�ʶ�ȡ�ֽ���
                        void close() throws IOException//�ر���
                        void skip(long n) throws IOException//����n���ֽ�
            OutputStream
			���ڴӳ������������
			       void write(int b) throws IOException//����������д��һ���ֽ�����
				 void write(byte[] b) throws IOException //��һ��byte[]д��������
				 void write(byte[] b,int off,int len) throws IOException//��byte[]��ָ��λ��off��ʼLen���ֽڵ�������
				 void close() throws IOException //�ر���Դ
				 void flush() throws IOException//��������л��������ȫ��д����Ŀ�ĵ�
		Reader
			��������������ݣ��ַ�16bit��
				int read() throws IOException//��ȡ�ַ�����int�ͷ���
				int read(char[] cbuff) throws IOException//��ȡһϵ���ַ��洢��char[]�У�����ʵ�ʶ�ȡ���ַ���
				int read(char[] cbuff,int offset,int length)throws IOException//��ȡlength���ַ�����offset��ʼ��char[]��
				void close() throws IOException//�ر����ͷ��ڴ���Դ
				long skip(long n ) throws IOException//����n���ַ�����
		Writer
		       ��������������
			       void write(char c) throws IOException//�������������һ���ַ�����
				void write(char[] cbuff) throws IOException//��һ��char[]д�뵽�����
				void write(char[] cbuff,int offset,int length) throws IOException//��char[] length���ַ���offset��ʼд�뵽�������
				void write(String string) throws IOException throws IOException//��һ��Stringд�뵽�������
				void write(String string,int offset,int length) throws IOException//��String��offsetλ�ÿ�ʼ length���ַ�д�������
				void close() throws IOException//�ر������
				void flush() throws IOException//�����������ַ���д����Ŀ�ĵ�
�����Ľڵ����ʹ�����
    �ڵ���(���Է���file memory pipe����)
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
		int b = 0;//�Ƚ���ȡ�����ַ�ת��Ϊint��
		FileInputStream in = null;
		try
		{
		in  = new FileInputStream("C:\\Documents and Settings\\Administrator\\����\\java-notes.java");//��ָ��λ�õ��ļ�����������������
		}
		catch(FileNotFoundException e)
		{
			System.out.println("�Ҳ����ļ�");
			System.exit(-1);
		}
		try
		{
		while((b=in.read())!=-1)//��ȡ���������ַ���
		{
			System.out.print((char)b);//��Int�͵����ݻ�ԭΪchar�����
			num++;
		}
		in.close();
	    }catch(IOException e1)
	    {
		    System.out.println("�ļ���ȡ����");
		    System.exit(-1);
	    }
		System.out.println();
		System.out.println("��¼��"+num+"���ַ�");
		
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
			fi = new FileInputStream("C:\\Documents and Settings\\Administrator\\����\\java-notes.java");//��ָ���ļ������ݶ�ȡ�������� fi��
			fo = new FileOutputStream("C:\\Documents and Settings\\Administrator\\����\\test.txt");//�����������ָ�����ļ���
			while((b=fi.read())!=-1)
			{
				fo.write(b);//�����������ȡ���ַ���д���������
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
����������
    Buffering               BufferedReader BufferedWriter                      BufferedInputStream  BufferedOutputStream
    Filtering                 FilteredReader  FilterWriter                          FilteredInputStream   FilterOutputStream
    Convert                 InputStreamReader  OutputStreamWriter
    Object                                                                                ObjectInputStream ObjectOutputStream
     Date                                                                                  DateInputStream    DateOutStream
    Counting               LinkNumberReader                                       LinkNumberWriter
    Peeking ahead        PusbackReader                                           PusbackInputStream
    Printing                  PrintWriter                                                PrintStream
    ������ 
        ������Ҫ�׽�����Ӧ�Ľڵ���֮�ϣ��Զ�д�����ݻ��������Ч��
       ���ֻ������Ĺ��췽����
      BufferedReader(Reader in)
      BufferedReader(Reader in,int sz)
      BufferedWriter(Writer out)
      BufferedWriter(Writer out,int sz)
	BufferedInputStream(InputStream in)
      BufferedInputStream(InputStream in,int sz)
      BufferedOutputStream(OutputStream in)
      BufferedOutputStream(OutputStream in,int sz) 
      ������֧���丸���mark��reset����
	BufferedReader�ṩ��readLine�������ڶ�ȡһ���ַ�����\r\n��
	BufferedWriter�ṩ��newLine����д��һ���зָ���
	�������������������ʹ��flush���ڴ��е���������д��
import java.io.*;
class BufferedTest
{
	public static void main(String[] args) throws IOException
	{
		//��DEMO.JAVA�ļ���ȡ���ݣ�����һ�������ļ����������ڴ˻����Ͻ���һ�����뻺����br
		BufferedReader br = new BufferedReader(new FileReader("C:\\Documents and Settings\\Administrator\\����\\Demo.java"));
		//����һ���ļ���������ļ�demo1.java���ڴ˻����Ͻ���һ�����������bw
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Documents and Settings\\Administrator\\����\\Demo1.java"));
		String s = null;
		for(int i=0;i<100;i++)
		{
			Double j = Math.random()*100;
			int m = j.intValue();
			s=String.valueOf((char)m);
			//���ַ�sд��д����bw�У�ͨ��FileWriter������д���ļ�Demo1.java�ļ���
			bw.write(s);
			//��һ�����з�д���ļ�
			bw.newLine();
		}
		//�������bwȫ��д���ļ���
		bw.flush();
		//����һ���������������������ļ�demo.java������
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
		}
		bw.close();
		br.close();
	}
}
    ת����
	InputStreamReader��OutputStreamWriter�����ֽ����ݵ��ַ�����֮���ת��
      InputStreamReader InputStream֮����׽�
      OutputStreamWriter OutputStream֮����׽�
      ָ�����뼯��
         InputStream ist = new InputStreamReader(System.ip,"ISO8859-1");
import java.io.*;
public class TransformDemo01
{
	public static void main(String[] args) throws IOException
	{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Documents and Settings\\Administrator\\My Documents\\jocks1.txt"));//����һ���������ת��Ϊ�ַ��������
		osw.write("laopozaiganshenmene~~");//�����д������
		System.out.println(osw.getEncoding());
		osw.close();
		//true���������Ƿ����Ѿ����ڵ��ļ�����ӵ�����
		osw = new OutputStreamWriter(new FileOutputStream("C:\\Documents and Settings\\Administrator\\My Documents\\jocks1.txt",true),"gb2312");
		osw.write("oh my lord�ϵۣ�");
		osw.close();
	}
}
import java.io.*;
public class TransformDemo02
{
	public static void main(String[] args) throws IOException
	{
		//System.in��һ����׼��������󣬴������г�������
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
    ������
       DataInputStream��DataOutputStream�ֱ�̳��� InputStream��OutputStream���׽�����������ȥ��Java������������
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
//��������Ƚ��ȳ�ԭ�򣬴˴���Boolean��Double���ܲ����Ⱥ�		
    }
}
    print��
	PrintWriter ��PrintStream�����������������ַ����ֽ�
       Println���ڶ����������͵����
      �������쳣�����Զ�flush����
//��unicode�ַ�д��һ���ļ���
package cn.java.IO.org;
import java.io.*;
public class PrintStream01 {
	public static void main(String[] args) throws FileNotFoundException 
	{
		FileOutputStream fos = new FileOutputStream("d:\\bak.txt");
        PrintStream  ps = null;
        ps = new PrintStream(fos);//��һ��FileOutputStream����һ��PrintStream����
        if(ps!=null)
        {
        	System.setOut(ps);//����ָ���ַ�����Ķ�����һ��PrintStream����
        }
        for(int i=0;i<65536;i++)
        {
        	char c = (char)i;
        	System.out.print(c+" ");//��System��out�����print������ʵ�ֽ�ָ�����ַ�д��ָ����λ��(һ��ָ���ļ���PrintStream����)
        	if(c%100==0){System.out.println();}
        }
	}
//
}
//��ָ���ļ����������̨��ʾ
package cn.java.IO.org;
import java.io.*;
public class PrintStream02 {
	public static void main(String[] args) throws IOException 
	{
		String filename = args[0];//��ȡ��console������ַ���filename
		if(filename!=null)
		{
			list(filename,System.out);//����list����
		}
	}
	//
	public static void list(String f,PrintStream ps) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(f));//ͨ��FileReader������һ��BufferedReader����
		String s1 = null;
		while((s1=br.readLine())!=null){ps.println(s1);}//���ӻ�����BufferedReader��ȡ���ַ���д��PrintStream������
		ps.close();
		br.close();
	}

}

//дһ����־
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//����һ����console���������InputStreamReader����BufferedReader���׽�������
            FileWriter fw = new FileWriter("d://log.txt",true);//����һ��д���ļ�log.txt��FileWriter������fw
            PrintWriter pw = new PrintWriter(fw);//ͨ��FileWriter������һ��PrintWriter����������ָ�����ַ�д�뵽������
            while((s=br.readLine())!=null)
            {
        	   if(s.equalsIgnoreCase("exit")) break;
        	   System.out.println(s.toUpperCase());//����BufferedWriter�������ַ���д��System.out����Ҳ����Console��������
               pw.print("------------------");
		   pw.println();
               pw.println(s.toUpperCase());//����BufferedWriter�������ַ���д��PrintWriter�����У�Ҳ����д���ļ���
               pw.write("===="+new Date()+"=====");
               pw.println();
            }
            pw.close();
	}

}

    Object��
	ֱ�ӽ�objectд������   
import java.io.*;
public class ObjectStream01
{
	public static void main(String[] args) throws Exception
	{
		T t = new T();
		t.name="lord";
		t.age=1;
		t.sex="��";
		FileOutputStream fos = new FileOutputStream("D:/FileOutputStream.text");//����һ��FileOutputStream�������ļ���������
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
