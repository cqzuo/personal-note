%toc
# SSc+JPA��Ŀ� #
## ����� ##
### struts2���� ###
#### �����ļ� ####
  1. jspҳ����ǩ��ʹ��
    * ��jspҳ��������������,����ʹ��struts2�ı�ǩ
> {{{ class="brush: xml"
> <!DOCTYPE struts PUBLIC
> > "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
> > "http://struts.apache.org/dtds/struts-2.0.dtd"> }}}
 * �����ļ��и�������������
 {{{class="brush: xml"
<constant name="struts.i18n.encoding" value="UTF-8" />
	<constant name="struts.action.extension" value="action,do" />
	<constant name="struts.serve.static.browserCache" value="false" />
	<constant name="struts.configuration.xml.reload" value="true" />
    <constant name="struts.enable.DynamicMethodInvocation" value="false" />
    <constant name="struts.devMode" value="true" />
    <constant name="struts.ui.theme" value="simple" />
	<!--����spring��struts���󹤳��Ĺ���-->
	<constant name="struts.objectFactory" value="spring" /> 
 }}}
 # action������=====
  * һ��action��action
 {{{class="brush: xml"
 <package name="task" namespace="/center/task" extends="struts-default">
		<!--�˴�����action��ִ�еķ���,ƥ��name����ֵ�ĵ�һ��-->
		<action name="TaskAction_*" class="taskAction" method="{1}">
			<result name="taskList_success">/WEB-INF/page/task/taskList.jsp</result>
		</action>
	</package>
 }}}
  * action�ķ�ɢ�����ļ�,���԰����ܽ�struts2�������ļ���ɢ����������
	{{{class="brush: xml"
		<include file="�����ļ�������·������"/>
	}}}
==== action���ı�д ====
  * �������ķ�ʽ��������ʵ�����ӵ�spring�����й���
   - @Controller
  *  ����ʵ��Ϊԭ��,Ϊÿ����������һ������
   - @Scope("prototype")
=== spring���� ===
==== �����ļ� ====
 # �����ļ��б�ǩ������
  * ��spring�������ļ�applicationContext.xml�ļ������Ӵ�������
 {{{class="brush: xml"
 <beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context-2.5.xsd
           http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.5.xsd
           http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">
 }}} 
 # aspectJ��̬����������
  - �Զ�����aspectJ
 {{{class="brush: xml"
 <aop:aspectj-autoproxy />
 }}}
 # springע������������
  - �Զ�ɨ�����еĸ���ע�Ͳ���������
 {{{class="brush: xml"
 <!--�����˶԰�����ɨ���Խ���ע������Bean�����Ĺ������Ӻ�ע���������Զ�ע��-->
 <context:component-scan base-package="com.decg" />
 }}}
 # �־û�����
  - entityManagerFactory������
 {{{class="brush: xml"
 <bean id="entityManagerFactory"
		class="org.springframework.orm.jpa.LocalEntityManagerFactoryBean">
		<property name="persistenceUnitName" value="demo" />
	</bean>
 }}}
  - transactionManager������
{{{class="brush: xml"
<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
		<property name="entityManagerFactory" ref="entityManagerFactory" />
	</bean>
}}}
 # springע�͵�����
  - ע������
{{{class="brush: xml"
<tx:annotation-driven transaction-manager="transactionManager" />
}}}
=== jpa������ ===
==== �����ļ� ====
 # ��ǩ
 {{{class="brush: xml"
 <persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd"
	version="1.0">
 }}}
 # �־û������� ====
  - �൱��hibernate��applicationContext.xml�ļ�
 {{{class="brush: xml"
	<!--������������-->
	<persistence-unit name="demo" transaction-type="RESOURCE_LOCAL">
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<properties>
			<!--��Ҫ���ӵ����� ����,����,�û���,����,��ַ,�Ƿ���ʾsqlִ������,�Զ��������ݿ����ķ�ʽ��-->
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect" />
			<property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver" />
			<property name="hibernate.connection.username" value="root" />
			<property name="hibernate.connection.password" value="root" />
			<property name="hibernate.connection.url"
				value="jdbc:mysql://localhost:3306/demo?useUnicode=true&amp;characterEncoding=UTF-8" />
			<property name="hibernate.max_fetch_depth" value="3" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
			<property name="hibernate.jdbc.fetch_size" value="18" />
			<property name="hibernate.jdbc.batch_size" value="10" />
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="false" />
		</properties>
	</persistence-unit>
</persistence>
}}}
==== �־û����ı�д ====
 # ��һ�����־û�Ϊpojo��
  - @Entity
 # id��ע��
  - @Id
  - @GeneratedValue(strategy=GeneratedType.AUTO)
 # 
=== ҳ�� ===
 # ҳ������web-inf��
 # ��action������
  * ҳ��ת��action������
 {{{class="brush: xml"
  <LI style= "">
	<A href="<%=basePath%>center/bank/BankAction_bankList.action" onclick="return onLoadAddAction();" target=mainFrame>|-����</A>
  </LI>
 }}}
 # ·���Ĵ���
 {{{class="brush: xml"
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
 }}}
 # action�ж������Ĵ�������
 {{{class="brush: xml"
 <!--�Զ���ȡaction�����ƺ�Ҫִ�еķ���-->
 <action name="BankAction_*" class="bankAction" method="{1}">
			<result name="bankList_success">/WEB-INF/page/bank/bankList.jsp</result>
			<result name="addBank_success" type="redirect">BankAction_bankList.action</result>
		</action>
 }}}  
```