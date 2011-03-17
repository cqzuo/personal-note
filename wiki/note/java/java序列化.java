1 Java 序列化技术概述
Java 序列化技术可以使你将一个对象的状态写入一个Byte 流里，并且可以从其它地方把该Byte 流里的数据读出来。重新构造一个相同对象。这种机制允许你将对象通过网络进行传播，并可以随时把对象持久化到数据库、文件等系统里。Java的序列化机制是RMI、EJB、JNNI等技术的技术基础。
/*
 * 什么是java序列化
 * */
1.1 序列化技术基础
并非所有的Java 类都可以序列化，为了使你指定的类可以实现序列化，你必须使该类实现如下接口：java.io.Serializable。需要注意的是，该接口什么方法也没有。实现该类只是简单的标记你的类准备支持序列化功能。我们来看如下的代码：
/**
 * 抽象基本类，完成一些基本的定义
 */
public abstract class Humanoid
{
	protected int noOfHeads;
	private static int totalHeads;
	public Humanoid()
	{
		this(1);
	}
	public Humanoid(int noOfHeads)
	{
		if (noOfHeads > 10)
			throw new Error("Be serious. More than 10 heads?!");
		this.noOfHeads = noOfHeads;
		synchronized (Humanoid.class)
		{
			totalHeads += noOfHeads;
		}
	}
	public int getHeadCount()
	{
		return totalHeads;
	}
}
该类的一个子类如下：
/**
 * Humanoid的实现类，实现了序列化接口
 */
import java.io.*;
public class Person extends Humanoid implements java.io.Serializable
{
	private String lastName;
	private String firstName;
	//transient关键字用来标识不想用来序列化的变量 Thread writeObject
	private transient Thread workerThread;
	private static int population;
	public Person(String lastName, String firstName)
	{
		this.lastName = lastName;
		this.firstName = firstName;
		synchronized (Person.class)
		{
			population++;
		}
	}
	public String toString()
	{
		return "Person " + firstName + " " + lastName;
	}
	static synchronized public int getPopulation()
	{
		return population;
	}
}
1.2 对象的序列化及反序列化
上面的类Person 类实现了Serializable 接口，因此是可以序列化的。我们如果要把一个可以序列化的对象序列化到文件里或者数据库里，需要下面的类的支持：java.io.ObjectOutputStream如何正确的使用Java序列化技术 技术研究系列
下面的代码负责完成Person类的序列化操作：
/**
 * Person的序列化类，通过该类把Person写入文件系统里。
 */
import java.io.*;
public class WriteInstance
{
	public static void main(String [] args) throws Exception
	{
		if (args.length != 1)
		{
			System.out.println("usage: java WriteInstance file");
			System.exit(-1);
		}
		FileOutputStream fos = new FileOutputStream(args[0]);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Person p = new Person("gaoyanbing", "haiger");
		//通过ObjectOutputStream类对象的writeObject()方法来将一个对象写入文件中，写入之前必须implements Serializable接口来序列化
		oos.writeObject(p);
	}
}
如果我们要序列化的类其实是不能序列化的，则对其进行序列化时会抛出下面的异常：
java.io.NotSerializableException
当我们把Person 序列化到一个文件里以后，如果需要从文件中恢复Person 这个对象，
我们需要借助如下的类：
java.io.ObjectInputStream
从文件里把Person类反序列化的代码实现如下：
/**
 * Person的反序列化类，通过该类从文件系统中读出序列化的数据，并构造一个
 * Person对象。
 */
import java.io.*;
public class ReadInstance
{
	public static void main(String [] args) throws Exception
	{
		if (args.length != 1)
		{
			System.out.println("usage: java ReadInstance filename");
			System.exit(-1);
		}
		FileInputStream fis = new FileInputStream(args[0]);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		如何正确的使用Java序列化技术 技术研究系列
			System.out.println("read object " + o);
	}
}
1.3 序列化对类的处理原则
并不是一个实现了序列化接口的类的所有字段及属性都是可以序列化的。我们分为以下几个部分来说明：
    如果该类有父类，则分两种情况来考虑，如果该父类已经实现了可序列化接口。则其父类的相应字段及属性的处理和该类相同；如果该类的父类没有实现可序列化接口，则该类的父类所有的字段属性将不会序列化。
  如果该类的某个属性标识为static类型的，则该属性不能序列化；
  如果该类的某个属性采用transient关键字标识，则该属性不能序列化；
需要注意的是，在我们标注一个类可以序列化的时候，其以下属性应该设置为transient
来避免序列化：
u 线程相关的属性；
u 需要访问IO、本地资源、网络资源等的属性；
u 没有实现可序列化接口的属性；（注：如果一个属性没有实现可序列化，而我们又
没有将其用transient 标识， 则在对象序列化的时候， 会抛出
java.io.NotSerializableException 异常）。
//static transient修饰的属性 线程 访问网络  io 不能序列化
1.4 构造函数和序列化
对于父类的处理，如果父类没有实现序列化接口，则其必须有默认的构造函数（即没有
参数的构造函数）。为什么要这样规定呢？我们来看实际的例子。仍然采用上面的Humanoid
和Person 类。我们在其构造函数里分别加上输出语句：
/**
 * 抽象基本类，完成一些基本的定义
 */
public abstract class Humanoid
{
	protected int noOfHeads;
	private static int totalHeads;
	public Humanoid()
	{
		this(1);
		System.out.println("Human's default constructor is invoked");
	}
	public Humanoid(int noOfHeads)
	{
		if (noOfHeads > 10)
			throw new Error("Be serious. More than 10 heads?!");
		如何正确的使用Java序列化技术 技术研究系列
			this.noOfHeads = noOfHeads;
		synchronized (Humanoid.class)
		{
			totalHeads += noOfHeads;
		}
	}
	public int getHeadCount()
	{
		return totalHeads;
	}
}
/**
 * Humanoid的实现类，实现了序列化接口
 */
import java.io.*;
public class Person extends Humanoid
	implements java.io.Serializable
{
	private String lastName;
	private String firstName;
	private transient Thread workerThread;
	private static int population;
	public Person(String lastName, String firstName)
	{
		this.lastName = lastName;
		this.firstName = firstName;
		synchronized (Person.class)
		{
			population++;
		}
		System.out.println("Person's constructor is invoked");
	}
	public String toString()
	{
		return "Person " + firstName + " " + lastName;
	}
	static synchronized public int getPopulation()
	{
		return population;
	}
}
在命令行运行其序列化程序和反序列化程序的结果为：
如何正确的使用Java序列化技术 技术研究系列
可以看到，在从流中读出数据构造Person对象的时候，Person 的父类Humanoid的默认
构造函数被调用了。当然，这点完全不用担心，如果你没有给父类一个默认构造函数，则编
译的时候就会报错。
这里，我们把父类Humanoid做如下的修改：
/**
 * 抽象基本类，完成一些基本的定义
 */
public class Humanoid implements java.io.Serializable
{
	protected int noOfHeads;
	private static int totalHeads;
	public Humanoid()
	{
		this(1);
		System.out.println("Human's default constructor is invoked");
	}
	public Humanoid(int noOfHeads)
	{
		if (noOfHeads > 10)
			throw new Error("Be serious. More than 10 heads?!");
		this.noOfHeads = noOfHeads;
		synchronized (Humanoid.class)
		{
			totalHeads += noOfHeads;
		}
	}
	public int getHeadCount()
	{
		return totalHeads;
	}
}
我们把父类标记为可以序列化， 再来看运行的结果：
如何正确的使用Java序列化技术 技术研究系列
可以看到，在反序列化的时候，如果父类也是可序列化的话，则其默认构造函数也不会
调用。这是为什么呢？
这是因为Java 对序列化的对象进行反序列化的时候，直接从流里获取其对象数据来生
成一个对象实例，而不是通过其构造函数来完成，毕竟我们的可序列化的类可能有多个构造
函数，如果我们的可序列化的类没有默认的构造函数，反序列化机制并不知道要调用哪个构
造函数才是正确的。
1.5 序列化带来的问题
我们可以看到上面的例子，在Person 类里，其字段population 很明显是想跟踪在一个
JVM里Person类有多少实例，这个字段在其构造函数里完成赋值，当我们在同一个JVM 里
序列化Person 并反序列化时，因为反序列化的时候Person 的构造函数并没有被调用，所以
这种机制并不能保证正确获取Person在一个JVM的实例个数，在后面的部分我们将要详细
探讨这个问题及给出比较好的解决方案。
2 控制序列化技术
2.1 使用readObject 和writeObject方法
由于我们对于对象的序列化是采用如下的类来实现具体的序列化过程：
java.io.ObjectOutputStream
而该类主要是通过其writeObject 方法来实现对象的序列化过程，改类同时也提供了一
种机制来实现用户自定义writeObject 的功能。方法就是在我们的需要序列化的类里实现一
如何正确的使用Java序列化技术 技术研究系列
个writeObject方法，这个方法在ObjectOutputStream序列化该对象的时候就会自动的回调它。
从而完成我们自定义的序列化功能。
同样的，反序列化的类也实现了同样的回调机制，我们通过扩展其readObject来实现自
定义的反序列化机制。
通过这种灵活的回调机制就解决了上面提出的序列化带来的问题，针对上面的Person
	的问题，我们编写如下的readObject方法就可以彻底避免population计数不准确的问题：
private void readObject(ObjectInputStream ois)
	throws IOException, ClassNotFoundException
{
	ois.defaultReadObject();
	synchronized (Person.class)
	{
		population++;
	}
	System.out.println("Adjusting population in readObject");
}
2.2 序列化过程的类版本控制
本节讨论以下问题：
u 在对象反序列化过程中如何寻找对象的类；
u 如果序列化和反序列化两边的类不是同一个版本，如何控制；
2.2.1 序列化类的寻找机制
在对象的反序列化过程中，是一定需要被反序列化的类能被ClassLoader 找到的，否则
在反序列化过程中就会抛出java.lang.ClassNotFoundException 异常。关于ClassLoader 如何
寻找类，这里就不多说了，可以参考我的另一篇讨论ClassLoader 的文章《在非管理环境下
如何实现热部署》。我们这里只是关心该序列化对象对应的类是被哪个ClassLoader 给Load
的。为此，我们修改上面的
/**
 * 修改后的反序列化类
 */
import java.io.*;
public class ReadInstance
{
	public void readPerson(String filename)
	{
		如何正确的使用Java序列化技术 技术研究系列
			try{
				FileInputStream fis = new FileInputStream(filename);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object o = ois.readObject();
				System.out.println("read object " + o);
				System.out.println(this.getClass().getClassLoader());
				Person person = (Person)o;
				System.out.println(person.getClass().getClassLoader());
			}catch(java.io.IOException ie)
		{
			ie.printStackTrace();
		}catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
	}
	public static void main(String [] args) throws Exception
	{
		if (args.length != 1)
		{
			System.out.println("usage: java ReadInstance filename");
			System.exit(-1);
		}
		ReadInstance readInstance = new ReadInstance();
		readInstance.readPerson(args[0]);
	}
	我们主要通过背景为黄色的两行代码查看其类加载器，运行结果如下：
		由此可以看出，序列化类的类加载器正式其反序列化实现类的类加载器。这样的话我们
		就可以通过使最新的Person 类的版本发布为只有该反序列化器的ClassLoader可见。而较旧
		的版本则不为该ClassLoader 可见的方法来避免在反序列化过程中类的多重版本的问题。当
		然，下面就类的版本问题我们还要做专门的探讨。
		如何正确的使用Java序列化技术 技术研究系列
		2.2.2 序列化类多重版本的控制
		如果在反序列化的JVM 里出现了该类的不同时期的版本，那么反序列化机制是如何处
		理的呢？
		为了避免这种问题，Java的序列化机制提供了一种指纹技术，不同的类带有不同版本的
		指纹信息，通过其指纹就可以辨别出当前JVM 里的类是不是和将要反序列化后的对象对应
		的类是相同的版本。该指纹实现为一个64bit的long 类型。通过安全的Hash算法（SHA-1）
		来将序列化的类的基本信息（包括类名称、类的编辑者、类的父接口及各种属性等信息）处
		理为该64bit的指纹。我们可以通过JDK自带的命令serialver来打印某个可序列化类的指纹
		信息。如下：
		当我们的两边的类版本不一致的时候，反序列化就会报错：
		如何正确的使用Java序列化技术 技术研究系列
		解决之道：从上面的输出可以看出，该指纹是通过如下的内部变量来提供的：
		private static final long serialVersionUID;
	如果我们在类里提供对该属性的控制，就可以实现对类的序列化指纹的自定义控制。为
		此，我们在Person 类里定义该变量：
		private static final long serialVersionUID= 6921661392987334380L;
	则当我们修改了Person 类，发布不同的版本到反序列化端的JVM，也不会有版本冲突
		的问题了。需要注意的是，serialVersionUID 的值是需要通过serialver 命令来取得。而不能
		自己随便设置，否则可能有重合的。
		需要注意的是，手动设置serialVersionUID 有时候会带来一些问题，比如我们可能对类
		做了关键性的更改。引起两边类的版本产生实质性的不兼容。为了避免这种失败，我们需要
		知道什么样的更改会引起实质性的不兼容，下面的表格列出了会引起实质性不兼容和可以忽
		略（兼容）的更改：
		更改类型 例子
		兼容的更改
		u 添加属性（Adding fields）
		u 添加/删除类（adding/removing classes）
		u 添加/删除writeObject/readObject方法（adding/removing
		writeObject/readObject）
		u 添加序列化标志（adding Serializable）
		u 改变访问修改者(changing access modifier)
		u 删除静态/不可序列化属性（removing static/transient from
		a field）
		不兼容的更改
		u 删除属性（Deleting fields）
		u 在一个继承或者实现层次里删除类（removing classes in a
		hierarchy）
		u 添加静态/不可序列化字段（adding static/transient to a
		field）
		u 修改简单变量类型（changing type of a primitive）
		u switching between Serializable oｒ Externalizable
		u 删除序列化标志（removing Serializable/Externalizable）
		u 改变readObject/writeObject对默认属性值的控制（changing
		whether readObject/writeObject handles default field
		data）
		u adding writeReplace oｒ readResolve that produces
		objects incompatible with older versions
		另外，从Java 的序列化规范里并没有指出当我们对类做了实质性的不兼容修改后反序
		列化会有什么后果。并不是所有的不兼容修改都会引起反序列化的失败。比如，如果我们删
		除了一个属性，则在反序列化的时候，反序列化机制只是简单的将该属性的数据丢弃。从
		JDK 的参考里，我们可以得到一些不兼容的修改引起的后果如下表：
		如何正确的使用Java序列化技术 技术研究系列
		不兼容的修改 引起的反序列化结果
		删除属性
		（Deleting a field） Silently ignored
		在一个继承或者实现层次里删除类
		（Moving classes in inheritance
		hierarchy）
		Exception
		添加静态/不可序列化属性
		（Adding static/transient）
		Silently ignored
		修改基本属性类型
		（Changing primitive type）
		Exception
		改变对默认属性值的使用
		（Changing use of default field data）
		Exception
		在序列化和非序列化及内外部类之间切换
		（Switching Serializable and
		Externalizable）
		Exception
		删除Serializable或者Externalizable标志
		（Removing Serializable or
		Externalizable）
		Exception
		返回不兼容的类
		（Returning incompatible class）
		Depends on incompatibility
		2.3 显示的控制对属性的序列化过程
		在默认的Java 序列化机制里，有关对象属性到byte 流里的属性的对应映射关系都是自
		动而透明的完成的。在序列化的时候，对象的属性的名称默认作为byte 流里的名称。当该
		对象反序列化的时候，就是根据byte 流里的名称来对应映射到新生成的对象的属性里去的。
		举个例子来说。在我们的一个Person对象序列化的时候，Person的一个属性firstName就作
		为byte 流里该属性默认的名称。当该Person 对象反序列化的时候，序列化机制就把从byte
		流里得到的firstName 的值赋值给新的Person 实例里的名叫firstName的属性。
		Java的序列化机制提供了相关的钩子函数给我们使用，通过这些钩子函数我们可以精确
		的控制上述的序列化及反序列化过程。ObjectInputStream的内部类GetField提供了对把属性
		数据从流中取出来的控制，而ObjectOutputStream的内部类PutField则提供了把属性数据放
		入流中的控制机制。就ObjectInputStream来讲，我们需要在readObject方法里来完成从流中
		读取相应的属性数据。比如我们现在把Person 类的版本从下面的表一更新到表二：
		/**
		 * 修改前的老版本Person类，为了简化，我们删除了所有无关的代码
		 */
		import java.io.*;
	public class Person extends Humanoid
			implements java.io.Serializable
		{
			private String lastName;
			如何正确的使用Java序列化技术 技术研究系列
				private String firstName;
			private static final long serialVersionUID =6921661392987334380L;
			private Person()
			{
			}
			public Person(String lastName, String firstName)
			{
				this.lastName = lastName;
				this.firstName = firstName;
			}
			public String toString()
			{
				return "Person " + firstName + " " + lastName;
			}
		}
	修改后的Person为：
		/**
		 * 修改后的Person类，我们将firstName和lastName变成了fullName
		 */
		import java.io.*;
	public class Person extends Humanoid
			implements java.io.Serializable
		{
			private String fullName;
			private static final long serialVersionUID =6921661392987334380L;
			private Person()
			{
			}
			public Person(String fullName)
			{
				this.lastName = fullName;
			}
			public String toString()
			{
				return "Person " + fullName;
			}
		}
	为此，我们需要编写Person类的readObject方法如下：
		private void readObject(ObjectInputStream ois)
		throws IOException,ClassNotFoundException
	{
		ObjectInputStream.GetField gf = ois.readFields();
		fullName = (String) gf.get("fullName", null);
		if (fullName == null)
		{
			String lastName = (String) gf.get("lastName", null);
			如何正确的使用Java序列化技术 技术研究系列
				String firstName = (String) gf.get("firstName", null);
			if ( (lastName == null) || (firstName == null))
			{
				throw new InvalidClassException("invalid Person");
			}
			fullName = firstName + " " + lastName;
		}
	}
	我们的执行顺序是：
		1) 编译老的Person及所有类；
		2) 将老的Person序列化到文件里；
		3) 修改为新版本的Person类；
		4) 编译新的Person类；
		5) 反序列化Person；
		执行结果非常顺利，修改后的反序列化机制仍然正确的从流中获取了旧版本Person 的
		属性信息并完成对新版本的Person的属性赋值。
		使用ObjectInputStream的readObject 来处理反序列化的属性时，有两点需要注意：
		u 一旦采用自己控制属性的反序列化，则必须完成所有属性的反序列化（即要给所有
		属性赋值）；
		u 在使用内部类GetField 的get 方法的时候需要注意，如果get 的是一个既不在老版
		本出现的属性，有没有在新版本出现的属性，则该方法会抛出异常：
		IllegalArgumentException: no such field，所以我们应该在一个try块里
		来使用该方法。
		同理，我们可以通过writeObject 方法来控制对象属性的序列化过程。这里就不再一一
		举例了，如果你有兴趣的话，可以自己实现Person 类的writeObject 方法，并且使用
		ObjectOutputStream的内部类PutField来完成属性的手动序列化操作。
		3 总结
		Java 序列化机制提供了强大的处理能力。一般来讲，为了尽量利用Java 提供的自动化
		机制，我们不需要对序列化的过程做任何的干扰。但是在某些时候我们需要实现一些特殊的
		功能，比如类的多版本的控制，特殊字段的序列化控制等。我们可以通过多种方式来实现这
		些功能：
		u 利用序列化机制提供的钩子函数readObject和writeObject；
		u 覆盖序列化类的metaData 信息；
		如何正确的使用Java序列化技术 技术研究系列
		u 使类实现Externalizable 接口而不是实现Serializable接口。
		关于Externalizable 接口更多的介绍，可以参考JDK 的帮助提供的详细文档，同时也可


