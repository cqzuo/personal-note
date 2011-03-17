面向spring编程
 dao模块 jdo
 orm-apping模块 hibernate
一致的DAO支持抽象类
  JdbcDaoSupport jdbc访问数据对象的基类,需要一个数据库,一个JdbcTemplate
  HibernateDaoSupport Hibernate访问数据对象的基类,需要一个SessionFactory,同时为子类提供HibernateTemplate
spring jdbc框架的价值
  1.指定数据库连接参数
  2.打开数据库连接
  3.声明sql语句
  4.预编译并执行sql语句
  5.遍历查询结果
  6.处理每一次遍历操作
  7.处理抛出的任何异常
  8.处理事务
  9.关闭数据库
利用JDBC核心类实现jdbc的操作
1. JdbcTemplate类
  jdbc包的核心类,替我们完成资源的创建及释放
  例子:
test.java
public class Test
     {
       public static void main(String[] args)
       {
	 ApplicationContext context = new ClassPathXmlApplicationContext(applicationContext.xml);
	 DaoImpl dao = (DaoImpl)context.getBean("myDaoImpl");
	 UserModel um = new UserModel();
	 um.setName("c");
	 um.setPassword("c");
	 dao.add(um);
       }
}
DaoImpl.java

  public class DaoImpl
	{
	  private DataSource ds = null;
	  public boolean setDs(DataSource ds)
	  {
	    this.ds = ds;
	  }
	  public boolean add(UserModel um)
	  {
	    //此处JdbcTemplate对象的创建需要一个DataSource对象,此对象由spring配置
	    JdbcTemplate jt = new JdbcTemplate(ds);
	    String sql = "insert into table_name(schem1,schem2..) value('+"um.getId()"+','+"um.getName()"+','+"um.getName()"+')";
	    jt.execute(sql);
	  } 
}
spring中DataSource的配置
applicationContext.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="
          http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd 
          http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
 <beans>
   <bean id="datasource" class="org.apache.commons.dhcp.BasicDataSource">
     <property name="driverClassName">
        <value>oracle.jdbc.driver.OracleDriver</value>
     </property>
     <property name="url">
        <value></value>
     </property>
     <property name="username">
        <value></value>
     </property>
     <property name="password">
        <value></value>
     </property>
   </bean>
   <bean id="myDaoImpl" class="spring.DaoImpl">
  <property name="ds" ref="datasource">//注入一个DAO
   </bean>
 </beans>
2.NamedParameterJdbcTemplate类
DaoImpl.java
public class DaoImpl
	{
	  private DataSource ds = null;
	  public static void main(String[] args)
	  {
	    String sql = "select * form  tableName where id==:id and name=:name and password=:password";
	    NamedParameterJdbcTemplate nt = new NamedParameterJdbcTemplate(ds);
	    MapSqlParameterSource ms = new MapSqlParameterSource();
	    ms.addValue(":id",um.getId());
	    ms.addValue(":name",um.getName());
	    ms.addValue(":password",um.getPassword());

	    List list = nt.QueryForList(sql,ms);
	    Iterator iter = list.iterator();
	    while(iter.hasNext())
	      {
		Map map = iter.next();//NamedParameterJdbcTemplate对象查询返回为Map对象
		System.out.println("id=="+map.get("ID")+"name=="+map.get("NAME")+"password=="+map.get(PASSWORD));//注意此处map的get参数必须为大写(oracle中列名返回为大写)
	      }
	    
	  }
}
NamedParameterJdbcTemplate类 用于参数不固定情况相当于 PreparedStatement
JdbcTemplate类 用于固定参数 相当于 StateMent
使用继承JdbcDaoSuport类方法实现数据库操作
DaoImpl.java

  public class DaoImpl
	{
	  public boolean add(UserModel um)
	  {
	    //此处JdbcTemplate对象的创建需要一个DataSource对象,此对象由spring配置
	    JdbcTemplate jt = this.getJdbcTemplate();
	    String sql = "insert into table_name(schem1,schem2..) value('+"um.getId()"+','+"um.getName()"+','+"um.getName()"+')";
	    jt.execute(sql);
	  } 
}
spring中DataSource的配置
applicationContext.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="
          http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd 
          http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
 <beans>
   <bean id="datasource" class="org.apache.commons.dhcp.BasicDataSource">
     <property name="driverClassName">
        <value>oracle.jdbc.driver.OracleDriver</value>
     </property>
     <property name="url">
        <value></value>
     </property>
     <property name="username">
        <value></value>
     </property>
     <property name="password">
        <value></value>
     </property>
   </bean>
   <bean id="myDaoImpl" class="spring.DaoImpl">
  <property name="dataSource" ref="datasource">//此处的name必须是dataSource
   </bean>
 </beans>

DataSourceUtil类
 DaoImpl.java
  
  public class DaoImpl
	 {
	   
	   public boolean add(UserModel um)
	   {
	     Connection con = null;
	     con = DataSourceUtil.getConnection(this.getDataSource());//通过DataSourceUtil类获取的连接才支持事务
	     String sql = "insert into table_name(schem1,schem2..) value('+"um.getId()"+','+"um.getName()"+','+"um.getName()"+')";
	     jt.execute(sql);
	   } 
 }
//自己开的连接 spring不支持