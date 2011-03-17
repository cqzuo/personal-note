spring概括
    spring是一个J2ee框架，对j2ee各个方面都有所帮助
    spring是一个可以集成很多框架的一个平台,最大的功能是作集成，粘合其他应用框架
  控制反转容器
    控制反转(ioc)spring来控制外部的程序资源
  优点 实现组件间耦合的松散
    依赖注入(di) 应用程序依赖于spring框架注入需要的外部资源
  ioc和di的区别 从不同角度描述的同一个事物
----------------------------------------------------------------------------------------------------
开发环境的构建
  1.下载springframework包
  2.导入需要的Jar文件(spring.jar,lib包)
  3.applicationContext.xml文件配置
  4.spring ioc容器的实例化
  5.代码中使用spring提供的外部资源
方法一：
Applicati＝onContext appContext=new FileSystemXmlApplicationContext("/src/applicationContext.xml");
   HuMan huMan=null;
   huMan= (HuMan) appContext.getBean("china");
   huMan.eat();
   huMan.walk();

方法二：
ClassPathXmlApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");

方法三：
Resource resource = new FileSystemResource("applicationContext.xml");
BeanFactory factory = new XmlBeanFactory(resource);

方法四：
    ApplicationContext ctx = new  ClassPathXmlApplicationContext(new String[]{"bean.xml"});
    BeanFactory factory = (BeanFactory)ctx.getBean("testBean");
BeanFactory      延迟载入所有Bean,直到getBean()被调用才创建Bean
ApplicationContext 启动后加载所有Bean
例子1 面向对象编程
A.java
public class A
{
	public static void main(String args[])
	{
		B b = new B();
		b.print();
	}
}
B.java
public class B
{
	public void print()
	{
               System.out.println("Hellow , the world!");
	}
}
bean.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
	        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.0.xsd">
    <bean id="test" class="spring.B">
    </bean>
</beans>
用spring来实现对B的注入
A.java
public class A
{
	public	static void main(String args[])
	{
	    //根据xml文件得到ApplicationContext，此时就生成了bean实例
	    ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"bean.xml"});
		//以前旧的版本用BeanFactory,ApplicationContext新增加了对web层的支持
	    B b = (B)ctx.getBean(test);
	    b.print();
	}
}
运行时如果出现包的兼容性问题，则先移除所有包，再逐个添加需要的包(防止包的冲突)
容器的功能 提供组件运行的环境，控制组件运行周期

例子2 面向接口编程
同面向对象
Api.java
public interface Api
{
    public String print();
}
B.java
public class B implements Api
{
    public String print()
	{
	    System.out.println("haha ,this is B~");
	}
}
C.java
public class C implements Api
{
    public String print()
    {
	    System.out.println("haha ,this is C~");
    }
}
A.java
public class A
  {
      public static void main(String[] args)
      {
	  ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"bean.xml"});
	  Api api = (Api)ctx.getBean(test);
      }
}
bean.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
	        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.0.xsd">
    <bean id="test" class="spring.B">
    </bean>
    </beans>
bean.xml文件功能 选择实现
如果想要调用C实现类,则只需要将bean的class改为spring.C即可
---------------------------------------------------------------------------------------
IOC原理
容器和bean的基本原理
  容器
  	org.springframework.beans.factory.BeanFactory是ioc容器的实际代表者
	BeanFactory是ioc容器的核心,职责是实例化,定位,配置应用程序的对象及家里这些对象间的依赖
     配置元数据
     	spring的三种元数据格式:java.xml.spring 公共API编程实现
	元数据的基本结构
		<beans>
			<bean id="" class=""/>
		</beans>
  实例化容器
  	ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"bean.xml"});
	BeanFactory factory = (BeanFactory)context.getBean(beanId);
    组成基于xml的
    <beans>
    	<import resource="/source/a.xml"/>
	<import resource="/source/b.xml"/>
	<bean id="" class=""/>
	<bean id="" class=""/>
    </beans>
  多种bean
  	命名bean
	   一个bean可以有多个别名(id),但一个别名只能有一个bean(id)
		bean的别名
	            通过id属性来定义别名
		    alias属性
		    	<alias name="beanName" alias="aliasName"/>
	实例化bean
		用构造器实例化
			<bean id="" class="" />
			<bean name="" class=""/>
		用静态工厂方法实例化
			<bean id="" class="" factory-method="StatciMethodName"/>
		用实例化工厂方法实例化
		    用来进行实例化的工厂方法位于一个已经存在的bean中,用来产生一个新的bean
  使用容器
BeanFactory
  提供了配置框架及基本功能，是ioc容器的核心接口
  实例化,定位,配置应用程序中的对象,建立对象间的依赖关系
ApplicationContext提供了更多的企业核心内容功能
bean就是被ioc容器初始化,管理,装配的对象
bean定义就是描述创建一个或多个bean对象的内容
如果要注入的bean需要参数，则可以在xml文件中配置参数传入
xml配置文件可以分拆为多个部分
  将文件路径作为字符串传递给ApplicationContext构造器
  在xml中import其他的部分
  <beans>
    <import resource="bean_login.xml"/>
    <import resource="bean_register.xml"/>
  </beans>
容器内部,bean由BeanDefinition对象表示,包含以下信息
    定义bean全路径类名;id class
    定义bean的行为;prototype singleton  type(scope="singleton";singleton="true")
        singleton 多个访问,只初始化一个实例对象
	prototype 每个访问都有一个实例对象
    定义bean的参数属性值;
    定义bean的关系
bean的命名 遵循java变量名的命名规则
    <bean id="testAction" class="spring.Test">
    </bean>
别名定义
    <alias name="testAction" alias="ABC"/>//别名的定义,name必须和前面已经的id同
实例化bean
    用构造器来实例化
      <bean id="testAction" class="spring.Action" scope="prototype"/>//相当于无参构造函数
    用静态工厂方法实例化
      在要注入的bean中定义一个静态方法
C.java
public class C implements Api
{
	public String print()
	{
		System.out.println("haha ,this is C~");
	}
	public static Api getInstance()
	{
		return new C();
	}
}
在xml文件中配置
<bean id="Test" class="spring.C" scope="prototype" factory-method="getInstance"/>
用实例工厂方法实例化,和以前就有的已存factory bean进行兼容
<bean id="myFactoryBean" class="spring.MyFactoryBean" scope="singleton"/>
<bean factory-bean="myFactoryBean" factory-method="getApi"/>
---------------------------------------------
	依赖注入的两种方式//不是直接注入对象，间接注入一个依赖于注入对象的对象
    setter注入
DAOImpl.java
package spring;
    public class DAOImpl implements DAO
{
	public boolean create(String str)
	{
		System.out.println("now in create ,str="+str);
		return true;
	}
}
DAO.java
package spring;
public interface DAO
{
	public boolean create(String str);
}
BEbo.java
package spring;
public class BEbo implements MyFactory
{
	private DAO dao = null;

	public void setDao(DAO dao) {
		this.dao=dao;
	}
	public String test()
	{
		dao.create("b invoke");
		System.out.println("haha , now in B");
		return "this is B";
	}
}
MyFactory.java
public class MyFactory
{
	public Api getApi()
	{
		return new C();
	}
}
bean.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
	        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.0.xsd">
    <bean id="test" class="spring.BEbo">
    <property name="dao" ref="dao"/>//依赖注入采用property标签的name ref属性
    </bean>
    <bean id="dao" class="spring.DAOImpl">//注入依赖的对象
    </bean>
</beans>
MyAction.java
public class MyAction
{
	public static void main(String[] args)
	{
	    ApplicationContext ctx = ClassPathXmlApplicationContext(new String[]{"bean.xml"});
		BEbo b = (BEbo)ctx.getBean(test);
		b.test();
	}
}
    构造器注入
public class BEbo implements MyFactory
{
	private DAO dao = null;
	private int i;
        pri
    public void BEbo(DAO dao,int i) //在spring注入的对象的构造函数中配置参数来得
	{
		this.dao = dao;
		this.i = i;
	}

	public String test()
	{
		dao.create("b invoke");
		System.out.println("haha now id B");
		return "this is B";
       	}
}
bean.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
	        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.0.xsd">
		<bean id="test" class="spring.BEbo">
		//index明确指明参数的顺序
	<constructor-arg index="0" ref="dao"/>//构造器注入使用constructor-arg标签的index和ref属性
		  //数值参数的注入
	<constructor-arg index="1" type="int" value="445"/>//在构造器中注入其他属性使用constructor-arg的type和value属性
		</bean>
	<bean id="dao" class="spring.DAOImpl">//注入依赖对象
		</bean>
</beans>
bean属性及构造器
  常量值 <value/>
 <bean id="MyDataSource" class="org.apache.commons.dhcp.BasicDataSource">
    <property name="driverClassName">
       <value>com.mysql.jdbc.driver</value>
    </property>
 </bean>
  idref
 <bean id="test" class="spring.Test"/>
 <bean id="show" class="spring.Show">
    <property name="myBean">
    //按id注入该bean,并验证bean是否存在
       <idref="testName" bean="test">
    //等同于 <value>testName</value>
    //注入的bean在同一个xml文件中
    <idref local="test"/>
    </property>
 
</bean>
 ref idref的区别
	ref取得的是该bean,而idref只是传递该字符串而已,相当于value标签
 引用其他bean
	<ref bean="testBean"/> 注入bean对象
	<ref local="testBean"/>注入本文件已经定义的bean,且bean的id和name相同
内部bean(匿名bean) 此时bean作为一个无名的bean注入到外部的bean中
<bean id="out" class="....">
	<property name="target">
	   <bean class="com.orm.mycode.Person">//内部bean的配置不需要name和id值
	<property name="name" value="caohongwei"/>
	<property name="age" value="234"/>
	</property>
</bean>
集合
	props方法//prop key注入一个属性集合
<bean id="test" class="spring.Test">
  <property name="testBean">
    <props>
       <prop key="adminstrator">adminstrator</prop>
       <prop key="wife">老婆</prop>
    </props>
   </property>
</bean>
	list方法//用list注入的可以是任何一个对象，string和bean对象也可
<bean id="test" class="spring.Test">
	<property name="testList">
	<list>
	<value>this is a test String ~</value>//字符串
        	<ref bean="testBean"/>
	</list>
	</property>
</bean>
map方法
<property name="test">
	<map>
	   <entry>
	      <key>
         	   <value>this is a test<value>
	      <key>
              <value>a test string</value>
	   </entry>
	</map>
	<map>
           <entry>
                 <key>
	            <value>a ref test</value>
                 </key>
	         <bean ref="testBean"/>
           </entry>
	</map>
</property>
set方法
<property name="setTest">
	<set>
	          <value>test</value>
	          <bean ref＝"testBean"/>
	</set>
</property>
集合合并(父bean与子bean的合并)
    子集合的值从其父集合继承和覆盖而来
例子:
 <beans>
 	<bean id="parent" abstract="true" class="exemple.ComlexObject">
 		<property name="adminEails">
 			<props>
 				<prop key="adminstrator">adminstrator@163.com</prop>
 				<prop key="support">support@163.com</prop>
 			</props>
 		</property>
	</bean>
	
	<bean id="child" parent="parent">
		<property name="adminEails">
			<props merge="true">
				<prop key="sales">sales@163.com</prop>
				<prop key="support">support@163.com</prop>
			</props>
		</property>
	</bean>
 </beans>
null值的处理
 <value></value>相当于 setString("");
 <value><null/></value>setString(null);

xml-based的一些简化
<property name="myProperty">
	<value>hellow</value>
</property>

<property name="myProperty" value="hellow" />

<constructor-arg>
	<value>hellow</value>
</constructor-arg>

<constructor-arg value="hellow"/>

<entry>
	<key>
		<ref bean="myKeyBean"/>
	</key>
	<ref bean="myValueBean"/>
</entry>

<entry key-ref="myKeyBean" value-ref="myValueBean" />
没有<ref-local/>的简写

组合属性
例子

class UserMode
{
	private String name,id;
	/**
	 * get the value of id
	 * @return the value of id
	 */
	public  getId(){
		return this.id;
	}
	/**
	 * set a new value to id
	 * @param id the new value to be used
	 */
	public void setId( id) {
		this.id=id;
	}
	/**
	 * get the value of name
	 * @return the value of name
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * set a new value to name
	 * @param name the new value to be used
	 */
	public void setName(String name) {
		this.name=name;
	}
}

class BEbo implements MyFactory
{
	private UserMode um = new UserMode();
	/**
	 * get the value of um
	 * @return the value of um
	 */
	public UserMode getUm(){
		return this.um;
	}
	/**
	 * set a new value to um
	 * @param um the new value to be used
	 */
	public void setUm(UserMode um) {
		this.um=um;
	}
}
则此时要给UserMode对象的name赋值,则
<beans>
	<bean id="cctest" class="spring.BEbo">
		<property name="mm" ref="mm">
	</bean>
	<bean id="mm" class="spring.UserMode">
		<property name="um.name" value="ccc"/> //此处的Um为注入bean中的bean的name名
	</bean>
</beans>

延迟初始化bean
 如果设定不在容器启动时就将所有的singleton bean 实例化,则可以用 lazy-init属性来设定
 	<bean id="this" class="singleton.Test" lazy-init="true">
	</bean>
 该bean就在第一次被引用的时候被初始化
 所有缺省延迟初始化则:
 <beans default-lazy-init="true">
 </beans>

 方法注入
  大部分情况下,容器中的bean都是singleton的(spring默认的bean为singleton)	
  如何实现在一个singleton的bean访问另一个singleton的bean(非singleton的bean访问非singleton的bean)?
  	将一个bean设置为另一个bean的属性
 如何实现在一个singleton的bean访问一个非singleton的bean?
 	lookup方法注入
<beans>
	<bean id="cctest" class="spring.BEbo">
		<property name="mm" ref="mm">
		<lookup-method name="getUm" bean="um22"/> //此处的name为注入的bean中获取另一个非singleton的bean的方法名称
	</bean>
	<bean id="um22" class="spring.UserMode" scope="property"/>
	<bean id="mm" class="spring.UserMode">
		<property name="um.name" value="ccc"/> //此处的Um为注入bean中的bean的name名
		</bean>
</beans>

定义bean的特性
 lifecycle接口
  几个可以改变容器中bean行为的接口,可以在bean的初始化或析构时调用afterProperyiesSet()方法和destory()方法
  	InitilizingBean
         初始化回调
           <bean id="name" class="spring.Name" init-method="initMethod">
           </bean>
           class Name
	   {
	     public void initMethod()
             {
	       //some initilized method
             }
           }             
	DisposableBean
         析构回调
            同 initilizingbean 
	<bean id="name" class="spring.Name" distory-method="distoryMethod">
        </bean>  
关闭spring ioc容器
  通过spring的AbstractApplicationContext的registerShutdownHook()方法来关闭容器

ApplicationContext
	  Context包的核心类是ApplicationContext,由Beanfactory接口派生而来
  Context包的功能:
     MessageSource国际化,资源访问,事件传播,载入多个有继承关系的上下文
MessageSource实现国际化
 ResourceBundleMessageSource
  <beans>
	<bean id="messageResource" class="org.springframework.context.support.ResourceBundleMessageSource">
		<property name="basesName">
			<list>
				<value>format</value>//此处value的值就是properties文件名
				<value>windows</value>	
				<value>exception</value>
	                         <value>test</value>
	    
	               </list>
	         </property>
	 </bean>
 </beans>         
	    
	    ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"test.xml"}) 
            String message = ctx.getMessage("name",null,"",null);
            System.out.println(message);
 读取资源 
     Resource rs = ctx.getSource("D:/test.xml");
     Inputstream is = rs.getInputStream();
     可以从外部注入一个任意的资源(配置文件，文档)
class BEbo
{
    private Resource rs = null;
    public getRs(Resource rs)
    {
        this.rs = rs;
    }
}

application.xml
<bean id="test" class="spring.BEbo">
    <property name="rs">
    <value>D:/test.java</value> //此处注入指定位置的任意资源
    </property>
</bean>

singleton-spring注意事项:
 spring层与web层分开
