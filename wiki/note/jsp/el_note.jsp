1.el���Ե�����:
      ���������洢�ڱ�־λ�õ�java�����ֵ�������,����jsp2.0����ı��ʽ����
	��־λ��:�������Է�Χ
	����:��ȷ�ķ��ʴ洢����;Bean���Եļ��ԼǷ�;��ֵȡ��������Ϣ
2.���ʽ���Եĵ���
       ��ʽ:${expression}
	 �������������
	         jsp�����ִ洢��Χ,Ҫ����˷�Χ֮�ڵ�����,ֻ��Ҫ�ڱ��ʽ������ʹ����������,��:${name};
		   ��ʾ��pageContext,HttpServletRequest,HttpSession,ServletContext����˳�����name����,����ҵ�,���������toString()�������ص��õĽ��,���û�ҵ�,�򷵻�null,
		   ��pageContext ,HttpServletRequest,HttpSession,ServletContext�ж��洢������ͬ���������ı���,�򷵻ص�ֵ����Ԥ�ȶ���õ�˳����������������ʱ�ҵ��ĵ�һ�����Ե�ֵ,�������ָ�����Ե�������
3.����:
<%
     pageContext.setAttribute("name","www.lord.com");
     request.setAttribute("name","www.laogong.com");
%>
${name}
<!--�൱����ǰ��<%=pageContext.getAttribute("name")%>-->
<!--������ڲ�ͬ�����Է�Χ����������ͬ������,��֮��������޷��ҵ�-->
4.���ʽ���Եĵ���
       ����bean�ı��
	 ��żǷ�:  ${beanName.beanProperty}//����
	 ����Ƿ�:  ${beanName["beanProperty"]}
5.����
bean�Ĵ���
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
web.xml����
<servlet>
    <servlet-name>el02</servlet-name>
    <servlet-class>cn.mldn.lxh.servlet.ELServlet01</servlet-class>
</servlet>
<servlet-mapping>
     <servlet-name>el02</servlet-name>
     <url-pattern>/el02</url-pattern>
</servlet-mapping>
servlet�Ĵ���
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
		//����������ת
		req.getRequestDispatcher("ELDmeo02.jsp").forward(req,rep);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse rep) throws IOException,ServletException
	{
		this.doGet(req,rep);
	}
}
jspǰ̨�ĵ���
<h1>${sim.name}</h1>
6.����:������Ե�����,�����µ���:
${bean����.������(bean).bean����}
����:
NameBean.java

//NameBean�������ǽ��ܲ�����String�� firstname lastname��������
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
		//������NameBean������ lasetname firsetname
		NameBean  nb = new NameBean();
		nb.setFirstName("lord");
		nb.setLastName("laopo");
		//������CompanyBean������ companyName business
		CompanyBean cb = new CompanyBean();
		cb.setCompanyName("king");
		cb.setBusiness("laogong");
		//������EmployeBean������ NameBean�͵�name CompanyBean��Company
		EmployeBean eb  = new EmployeBean();
        eb.setName(nb);
		eb.setCompany(cb);
		//����request��һ������emp,����ΪEmployeBean���͵�eb
		req.setAttribute("emp",eb);
 		//servlet��ת��ELDemo02.jsp
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
//{sevlet����.���õ�bean����.bean������}
<h1>firstName:${emp.name.firstName}</h1>
<h1>LastName:${emp.name.lastName}</h1>
<h1>CompanyName:${emp.company.companyName}</h1>
<h1>Business:${emp.company.business}</h1>
7.���ʼ��ϲ���
 