1,错误：
java.lang.NullPointerException: Module 'null' not found.
错误原因，struts运行需要的.jar文件拷贝不足，应该把它们加入到classpath中。
2,连接oracle出错，no suitable driver
错误原因不在于驱动有误，而是由于url写错了，
jdbc:oracle:thin:@127.0.0.1:1521:mydatabase
写成了：jdbc:oracle.thin:@127.0.0.1:1521:mydatabase
3,insert功能实现过程中最主要的障碍。
（1）如何设置date类型。
可以利用preparestatement.setDate(index,java.sql.Date.valueOf("2000-01-02")
（2）另外，首先要保证数据库连接正确。
4，使用html:submit生成的按钮没有标签文字，具体使用的代码为<html:submit property="submit"><bean:message key="button.logon"/></html:submit>
经检查，代码无误，真正原因在于.properties文件中的button.logon="xxx"，不应该加引号。
5，JSP页中使用include的正确写法。
<%@ include file="taglib.jsp" %>
 
6，struts框架配置oracle数据源。
首先有3个必需的.jar包
commons-dbcp-1.2.jar"
commons-pool-1.2.jar
commons-legacy-1.0.jar需要拷贝到$TOMCAT/common/lib下
对于struts1.2来说，没有commons-legacy-1.0.jar，另外ojdbc14.jar要导入到buildpath中。
对于struts-config.xml中的datasource配置，struts1.1和struts1.2有很大区别。
Struts 1.1             Struts 1.2
driverClass          driverClassName
user                     username
 
7，nowrap（不换行）的用法。
在某一单元格，如果设置了width属性，则nowrap不其作用，超出的文字会换行。
只有未设置width的单元格，超出的文字会将表格拉长，以适应文字的长度。
 
8，JSP页上的图片在Dreamweaver编辑时，可以显示，但是运行时没有显示出来。
当我们使用welcome-file-list设定了默认主页，该主页中的图片所对应的当前路径已经是项目的路径了。所以主页放在项目的直接目录下为好。
 
9，错误：No action config found for the specified url
错误原因：struts-config.xml中，action的path有问题。
 
10，错误：org.apache.struts.config.FormBeanConfig.createActionForm(FormBeanConfig.java)
从错误提示来看是在创建ActionForm时出错，经查证为struts-config.xml中ActionForm的类名写错了。
 
11，错误：请求logon.do时出错，The requested resource(/logon.do) is not avaliable.
对于form的action属性，如果form不是用html:form构建的话，action不能写成action="/logon.do"的形式，只能写成，action="logon.do"的形式。如果是使用html:form来构建的话，则action既可以写成action="/logon.do"，也可以写成：action="logon.do"。
 
12，错误：org.apache.struts.chain.commands.servlet.CreateAction.getAction(CreateAction.java:66)
参照上面10的错误，查找struts-config.xml，发现action的配置没有错，经查找是action在构造的时候没有扩展Action类。即public class LogonAction{}，应该写成：public class LogonAction extends Action{}
 
13,如何在JSP页中使用html标签实现密码输入框。
使用：<html:password property="password"/>，而不是用<html:text property="password"/>
 
14，Action mapping中的parameter属性有何用途？
用来指定Action的配置参数，在Action类的execute()方法中可以调用mapping的getParameter()方法来获取该参数。
 
15，Foward中的contextRelative属性有何用途？
如果改性设为true，表示当path属性以“/”开头时，给出的时相对于当前上下文的URL
 
16，关于session-timeout.
session-timeout用来指定session的过期时间，以分钟为单位。
 
17，运用validator框架进行验证时，出现错误提示：No validatorAction named minLength found for filed userName.
错误原因：<field property="name" depends="required,mask,minlength">中的minlength写成了minLength。
 
18，this.getClass().getName()返回什么？
会返回类名（包括包名）。
 
19，Eclipse中路径问题：
在.java文件中和在XML配置文件中的当前目录为项目的目录。
但直接运行部署在项目中的文件如批处理文件，当前路径为eclipse的启动目录。
 
20，struts框架的国际化问题
当struts配置文件的<controller>元素的lcoale属性设为true时，struts框架将用户的locale实例保存在session范围内，以便struts 能自动根据locale实例从Resource Bundle中选择合适的资源文件，如果用户locale为英文时，struts会向用户返回来自于application_en.properties文件的文本内容，当为中文时，依次搜寻application_ch_CN.properties，application_ch.properties，application.properties
另外，当需要中文时，application_ch_CN.properties中的中文字符必需经过转换，转换的过程为：native2ascii -encoding gb2312 源文件　application_ch_CN.properties。
 
21，启动tomcat时出现错误提示：Offending class: javax/servlet/Servlet.class
到网上查了一下，发现是加载类冲突，原来是我在build.xml中将$TOMCAT_HOME/lib下的.jar文件也放到项目的lib里了。tomcat加在自己lib下的.jar文件后,再加载项目的lib,就重复了,造成了类冲突。解决方法，不把tomcat_home的.jar文件拷贝到项目的lib即可。
 
22，Q：build.xml脚本开头放置<property file="xxx.properties"/>是什么意思？
A：ant将加载文件中所声明的任何变量。
 
23，Q：spring加载Hibernate entity的两种方法。
A：
第一种方法是利用entity中的注解进行解析。
<bean id="sessionFactory" class="org.spring......">
        <property name="annotatedClasses">
            <list>
                <value>com.customer.pack.Employee</value>
                <value>com.customer.pack.Project</value>
                .
                .
                .
            </list>
        </property>
第二种方法是利用xml配置文件进行解析。
    <bean id="sessionFactory">
        <property name="mappingResources">
          <list>
              <value>com/customer/pack/Employee.hbm.xml</value>
              <value>com/customer/pack/Project.hbm.xml</value>
              .
              .
              .
          </list>
        </property>
   </bean>
 
ps:  sessionFactory是数据源的代理。

