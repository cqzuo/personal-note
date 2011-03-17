
ssh 整合测试
搞了很久的ssh整合，总是环境的问题而半途而废，甚至让人心灰意冷，今天终于完成了ssh的完美整合，这以为ssh的大门永远的向我敞开了，庆祝一下。
1，注意添加jar的顺序 先添加struts+spring+hibernate 这样子据说可以解决jar的冲突问题，一般是spring和hibernate jar包的冲突，删除冲突的jar包 保留最新的jar包
2，用spring托管hibernate（sessionFactory由spring管理，在sessionFactory中注入dataSource）
name="code" class="xml" 
<bean id="sessionFactory" 
  class="org.springframework.orm.hibernate3.LocalSessionFactoryBean"> 
  <property name="dataSource"> 
   <ref bean="dataSource"/> 
  </property> 
  <property name="mappingResources"> 
  <list> 
  <value>com/v512/guestbook/model/Guestbook.hbm.xml</value> 
  <value>com/v512/guestbook/model/Admin.hbm.xml</value> 
  </list> 
  </property> 
  <property name="hibernateProperties"> 
  <props> 
   <prop key="hibernate.dialect">org.hibernate.dialect.Oracle9Dialect</prop> 
   <prop key="hibernate.show_sql">true</prop> 
  </props> 
  </property>   
 </bean> 
  
 <bean id="dataSource" 
  class="org.apache.commons.dbcp.BasicDataSource"> 
  <property name="driverClassName" 
   value="oracle.jdbc.driver.OracleDriver"> 
  </property> 
  <property name="url" 
   value="jdbc:oracle:thin:@localhost:1521:test"> 
  </property> 
  <property name="username" value="scott"></property> 
  <property name="password" value="tiger"></property> 
 </bean> 
 3，在application中配置好dao和manager，dao层是负责和数据库的交互，也就是説DB是dao的客户，而用hibernate操作数据库必须通过session，session是完成一次的数据库的操作，session通过sessionFactory获取，所以dao持有sessionFactory则可以操作数据库，因此将sessionFactory注入到dao层，而将dataSource注入到SessionFactroy，service负责业务的应用，他的客户是action，因此将manager注入到action中则可以完成一次业务的处理。
name="code" class="xml"  
 <bean id="guestbookDao" 
  class="com.v512.guestbook.dao.hibernate.GuestbookDaoHibernate" 
  abstract="false" lazy-init="default" autowire="default" 
  dependency-check="default"> 
  <property name="sessionFactory"> 
   <ref bean="sessionFactory" /> 
  </property> 
 </bean> 
 <bean id="adminDao" 
  class="com.v512.guestbook.dao.hibernate.AdminDaoHibernate" 
  abstract="false" lazy-init="default" autowire="default" 
  dependency-check="default"> 
  <property name="sessionFactory"> 
   <ref bean="sessionFactory" /> 
  </property> 
 </bean> 
  
 <bean id="guestbookManager" 
  class="com.v512.guestbook.service.impl.GuestbookManagerImpl" 
  abstract="false" lazy-init="default" autowire="default" 
  dependency-check="default"> 
  <property name="guestbookDao"> 
   <ref bean="guestbookDao" /> 
  </property> 
 </bean>  
 <bean id="adminManager" 
  class="com.v512.guestbook.service.impl.AdminManagerImpl" 
  abstract="false" lazy-init="default" autowire="default" 
  dependency-check="default"> 
  <property name="adminDao"> 
   <ref bean="adminDao" /> 
  </property> 
 </bean></beans> 
整个applicationContext.xml如下
name="code" class="xml"<?xml version="1.0" encoding="UTF-8"?> 
<beans 
 xmlns="http://www.springframework.org/schema/beans" 
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
 xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd"> 
 
 
 <bean id="sessionFactory" 
  class="org.springframework.orm.hibernate3.LocalSessionFactoryBean"> 
  <property name="dataSource"> 
   <ref bean="dataSource"/> 
  </property> 
  <property name="mappingResources"> 
  <list> 
  <value>com/v512/guestbook/model/Guestbook.hbm.xml</value> 
  <value>com/v512/guestbook/model/Admin.hbm.xml</value> 
  </list> 
  </property> 
  <property name="hibernateProperties"> 
  <props> 
   <prop key="hibernate.dialect">org.hibernate.dialect.Oracle9Dialect</prop> 
   <prop key="hibernate.show_sql">true</prop> 
  </props> 
  </property>   
 </bean> 
  
 <bean id="dataSource" 
  class="org.apache.commons.dbcp.BasicDataSource"> 
  <property name="driverClassName" 
   value="oracle.jdbc.driver.OracleDriver"> 
  </property> 
  <property name="url" 
   value="jdbc:oracle:thin:@localhost:1521:test"> 
  </property> 
  <property name="username" value="scott"></property> 
  <property name="password" value="tiger"></property> 
 </bean> 
  
 <bean id="guestbookDao" 
  class="com.v512.guestbook.dao.hibernate.GuestbookDaoHibernate" 
  abstract="false" lazy-init="default" autowire="default" 
  dependency-check="default"> 
  <property name="sessionFactory"> 
   <ref bean="sessionFactory" /> 
  </property> 
 </bean> 
 <bean id="adminDao" 
  class="com.v512.guestbook.dao.hibernate.AdminDaoHibernate" 
  abstract="false" lazy-init="default" autowire="default" 
  dependency-check="default"> 
  <property name="sessionFactory"> 
   <ref bean="sessionFactory" /> 
  </property> 
 </bean> 
  
 <bean id="guestbookManager" 
  class="com.v512.guestbook.service.impl.GuestbookManagerImpl" 
  abstract="false" lazy-init="default" autowire="default" 
  dependency-check="default"> 
  <property name="guestbookDao"> 
   <ref bean="guestbookDao" /> 
  </property> 
 </bean>  
 <bean id="adminManager" 
  class="com.v512.guestbook.service.impl.AdminManagerImpl" 
  abstract="false" lazy-init="default" autowire="default" 
  dependency-check="default"> 
  <property name="adminDao"> 
   <ref bean="adminDao" /> 
  </property> 
 </bean></beans> 
 
4，spring就是一个Bean工厂，而再个bean清单都在applicationContext中而如何在应用程序启动的时候就能够加载，这份清单呢?所以还得在web.xml中配置spring配置文件的路径，以及监听。
name="code" class="xml"<context-param> 
<param-name>contextConfigLocation</param-name> 
<param-value>/WEB-INF/applicationContext.xml</param-value> 
</context-param> 
//配置application的路径 name="code" class="xml"<listener> 
<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class> 
</listener>//配置application加载的监听 name="code" class="xml"文本加载还需要在struts中配置plugIn          name="code" class="xml"<plug-in className="org.springframework.web.struts.ContextLoaderPlugIn"> 
    <set-property property="contextConfigLocation" value="/WEB-INF/action-servlet.xml" /> 
   </plug-in>                                                                                                                                
这样就能够在应用程序启动就能够初始化静态的单例bean工厂了
5，spring 过滤器的配置
name="code" class="java"//filter 配置 
<filter> 
<filter-name>encodingFilter</filter-name> 
<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class> 
<init-param> 
<param-name>encoding</param-name> 
<param-value>UTF-8</param-value> 
</init-param> 
<init-param> 
<param-name>forceEncoding</param-name> 
<param-value>true</param-value> 
</init-param> 
</filter> 
//filter mapping 配置 
<filter-mapping> 
<filter-name>encodingFilter</filter-name> 
<url-pattern>/*</url-pattern> 
</filter-mapping> 
 加入springFilter的话要添加spring的web包
6，valiadator的配置（一般是 ValidatorForm）
步骤，添加路径：在/web-inf下加入validator-rules.xml和validations.xml
然后在struts中 要添加插件，错误信息在applicationResource中配置，具体的验证需要在validations.xml的中编写。
name="code" class="xml" <plug-in className="org.apache.struts.validator.ValidatorPlugIn"> 
   <set-property property="pathnames" value="/WEB-INF/validator-rules.xml,/WEB-INF/validations.xml" /> 
   </plug-in>  

 
struts中的插件是指明插件的位置，类型，以便应用程序启动时候加载
7，action在spring中的管理
action也可以作为一个bean在spring中管理，在struts中更改action的type为 org.springframework.web.struts.DelegatingActionProxy
eg：
name="code" class="java" <action 
      attribute="loginForm" 
      input="/login.jsp" 
      name="loginForm" 
      parameter="method" 
      path="/login" 
      scope="request" 
      type="org.springframework.web.struts.DelegatingActionProxy"  validate="false" /> 
 如此这整个配置完毕,如果出现jstl不支持的情况，要把web。xml中的dtd修改为2.4
name="code" class="xml"<web-app xmlns="http://java.sun.com/xml/ns/j2ee" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd" 
    version="2.4">  

