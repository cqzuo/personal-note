
ssh ���ϲ���
���˺ܾõ�ssh���ϣ����ǻ������������;���ϣ����������Ļ����䣬�������������ssh���������ϣ�����Ϊssh�Ĵ�����Զ�����ҳ����ˣ���ףһ�¡�
1��ע�����jar��˳�� �����struts+spring+hibernate �����Ӿ�˵���Խ��jar�ĳ�ͻ���⣬һ����spring��hibernate jar���ĳ�ͻ��ɾ����ͻ��jar�� �������µ�jar��
2����spring�й�hibernate��sessionFactory��spring������sessionFactory��ע��dataSource��
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
 3����application�����ú�dao��manager��dao���Ǹ�������ݿ�Ľ�����Ҳ�����hDB��dao�Ŀͻ�������hibernate�������ݿ����ͨ��session��session�����һ�ε����ݿ�Ĳ�����sessionͨ��sessionFactory��ȡ������dao����sessionFactory����Բ������ݿ⣬��˽�sessionFactoryע�뵽dao�㣬����dataSourceע�뵽SessionFactroy��service����ҵ���Ӧ�ã����Ŀͻ���action����˽�managerע�뵽action����������һ��ҵ��Ĵ���
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
����applicationContext.xml����
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
 
4��spring����һ��Bean���������ٸ�bean�嵥����applicationContext�ж������Ӧ�ó���������ʱ����ܹ����أ�����嵥��?���Ի�����web.xml������spring�����ļ���·�����Լ�������
name="code" class="xml"<context-param> 
<param-name>contextConfigLocation</param-name> 
<param-value>/WEB-INF/applicationContext.xml</param-value> 
</context-param> 
//����application��·�� name="code" class="xml"<listener> 
<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class> 
</listener>//����application���صļ��� name="code" class="xml"�ı����ػ���Ҫ��struts������plugIn          name="code" class="xml"<plug-in className="org.springframework.web.struts.ContextLoaderPlugIn"> 
    <set-property property="contextConfigLocation" value="/WEB-INF/action-servlet.xml" /> 
   </plug-in>                                                                                                                                
�������ܹ���Ӧ�ó����������ܹ���ʼ����̬�ĵ���bean������
5��spring ������������
name="code" class="java"//filter ���� 
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
//filter mapping ���� 
<filter-mapping> 
<filter-name>encodingFilter</filter-name> 
<url-pattern>/*</url-pattern> 
</filter-mapping> 
 ����springFilter�Ļ�Ҫ���spring��web��
6��valiadator�����ã�һ���� ValidatorForm��
���裬���·������/web-inf�¼���validator-rules.xml��validations.xml
Ȼ����struts�� Ҫ��Ӳ����������Ϣ��applicationResource�����ã��������֤��Ҫ��validations.xml���б�д��
name="code" class="xml" <plug-in className="org.apache.struts.validator.ValidatorPlugIn"> 
   <set-property property="pathnames" value="/WEB-INF/validator-rules.xml,/WEB-INF/validations.xml" /> 
   </plug-in>  

 
struts�еĲ����ָ�������λ�ã����ͣ��Ա�Ӧ�ó�������ʱ�����
7��action��spring�еĹ���
actionҲ������Ϊһ��bean��spring�й�����struts�и���action��typeΪ org.springframework.web.struts.DelegatingActionProxy
eg��
name="code" class="java" <action 
      attribute="loginForm" 
      input="/login.jsp" 
      name="loginForm" 
      parameter="method" 
      path="/login" 
      scope="request" 
      type="org.springframework.web.struts.DelegatingActionProxy"  validate="false" /> 
 ����������������,�������jstl��֧�ֵ������Ҫ��web��xml�е�dtd�޸�Ϊ2.4
name="code" class="xml"<web-app xmlns="http://java.sun.com/xml/ns/j2ee" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd" 
    version="2.4">  

