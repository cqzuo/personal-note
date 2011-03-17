1.el语言的作用:
      计算和输出存储在标志位置的java对象的值而引入的,用于jsp2.0输出的表达式语言
	标志位置:四种属性范围
	功能:精确的访问存储对象;Bean属性的简略记法;空值取代错误消息
2.表达式语言的调用
       格式:${expression}
	 访问作用域变量
	         jsp有四种存储范围,要输出此范围之内的内容,只需要在表达式语言里使用它的名字,如:${name};
		   表示在pageContext,HttpServletRequest,HttpSession,ServletContext按此顺序查找name属性,如果找到,则调用它的toString()方法返回调用的结果,如果没找到,则返回null,
		   在pageContext ,HttpServletRequest,HttpSession,ServletContext中都存储了有相同的属性名的变量,则返回的值是以预先定义好的顺序搜索各个作用域时找到的第一个属性的值,否则必需指定属性的作用域
3.例子:
<%
     pageContext.setAttribute("name","www.lord.com");
     request.setAttribute("name","www.laogong.com");
%>
${name}
<!--相当于以前的<%=pageContext.getAttribute("name")%>-->
<!--如果在在不同的属性范围中设置了相同的属性,则之后的属性无法找到-->
4.表达式语言的调用
       访问bean的标记
	 点号记法:  ${beanName.beanProperty}//常用
	 数组记法:  ${beanName["beanProperty"]}
5.例子
bean的代码
package cn.mldn.lxh.servlet.el;
public class Simple
{
	private String name;
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
}
web.xml设置
<servlet>
    <servlet-name>el02</servlet-name>
    <servlet-class>cn.mldn.lxh.servlet.ELServlet01</servlet-class>
</servlet>
<servlet-mapping>
     <servlet-name>el02</servlet-name>
     <url-pattern>/el02</url-pattern>
</servlet-mapping>
servlet的代码
package cn.mldn.lxh.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import cn.mldn.lxh.servlet.el.*;

public class ELServlet01 extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse rep) throws IOException,ServletException
	{
		Simple s = new Simple();
		s.setName("lord");
		req.setAttribute("sim",s);
		//服务器端跳转
		req.getRequestDispatcher("ELDmeo02.jsp").forward(req,rep);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse rep) throws IOException,ServletException
	{
		this.doGet(req,rep);
	}
}
jsp前台的调用
<h1>${sim.name}</h1>
6.例子:如果属性的属性,则如下调用:
${bean名称.属性名(bean).bean属性}
例子:
NameBean.java

//NameBean的作用是接受并设置String型 firstname lastname两个属性
package cn.mldn.lxh.bean;
public class NameBean
{
	private String firstName;
	private String lastName;
	public void setFirstName(String firstname)
	{
		this.firstName=firstname;
	}
	public String getFirstName()
	{
		return this.firstName;
	}

	public void setLastName(String lastname)
	{
		this.lastName=lastName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
}
CompanyBean.java
package cn.mldn.lxh.bean;
public class CompanyBean
{
	private String companyName;
	private String business;
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	public String getCompanyName()
	{
		return this.companyName;

	}
	public void setBusiness(String business)
	{
		this.business = business;
	}
	public String getBusiness()
	{
		return this.business;
	}
}
EmployeBean.java

package cn.mldn.lxh.bean;
import cn.mldn.lxh.bean.name.*;
import cn.mldn.lxh.bean.company.*;
public class EmployeBean
{
	private NameBean name;
	private CompanyBean company;
	public void setName(NameBean name)
	{
		this.name=name;
	}
	public NameBean getName()
	{
		return this.name;
	}
	public void setCompany(CompanyBean company)
	{
		this.company=company;
	}
	public CompanyBean getCompany()
	{
		return this.company;
	}
}
ELServlet02.java
package cn.mldn.lxh.bean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ELServlet02 extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse rep) throws IOException,ServletException
	{
		//设置了NameBean的属性 lasetname firsetname
		NameBean  nb = new NameBean();
		nb.setFirstName("lord");
		nb.setLastName("laopo");
		//设置了CompanyBean的属性 companyName business
		CompanyBean cb = new CompanyBean();
		cb.setCompanyName("king");
		cb.setBusiness("laogong");
		//设置了EmployeBean的属性 NameBean型的name CompanyBean的Company
		EmployeBean eb  = new EmployeBean();
        eb.setName(nb);
		eb.setCompany(cb);
		//设置request的一个属性emp,内容为EmployeBean类型的eb
		req.setAttribute("emp",eb);
 		//servlet的转向到ELDemo02.jsp
		req.getRequestDispatcher("ELDmeo02.jsp").forward(req,rep);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse rep) throws IOException,ServletException
	{
		this.doGet(req,rep);
	}
}
web.xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
  Copyright 2004 The Apache Software Foundation

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->

<web-app xmlns="http://java.sun.com/xml/ns/j2ee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd"
    version="2.4">

  <display-name>Welcome to Tomcat</display-name>
  <description>
     Welcome to Tomcat
  </description>


<!-- JSPC servlet mappings start -->
<servlet>
    <servlet-name>emp</servlet-name>
    <servlet-class>cn.mldn.lxh.bean.ELServlet02</servlet-class>
</servlet>
<servlet-mapping>
     <servlet-name>emp</servlet-name>
     <url-pattern>/el03</url-pattern>
</servlet-mapping>
<!-- JSPC servlet mappings end -->

</web-app>
ELDmeo02.jsp
//{sevlet名称.调用的bean对象.bean的属性}
<h1>firstName:${emp.name.firstName}</h1>
<h1>LastName:${emp.name.lastName}</h1>
<h1>CompanyName:${emp.company.companyName}</h1>
<h1>Business:${emp.company.business}</h1>
7.访问集合操作
 