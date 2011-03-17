目标: 掌握jsp+javaBean的开发模式
         MVC的设计模式
1.网站开发模式1:
       jsp+javaBean开发:
	       适合快速开发,jsp与javaBean紧密耦合,会对开发维护造成麻烦:
		   browser--->jsp--->javaBean-->DataBase
       jsp+servlet+javaBean开发:
	       适合团队开发,用此模式开发,速度慢,可维护性高
		 browser---->servlet(Controler)--->javaBean(model)<--->database
			     <----jsp
2.分析:
     javaBean优点:可重复使用,需要接收参数进行相应的处理;
     jsp优点:开发界面前台方便做ui容易;
     Servlet优点:是java程序,安全性高,性能也高;可以像jsp一样接收参数
     servlet缺点:显示不方便;
3.问题:
     由jsp跳转到servlet:表单提交或链接;
     由servlet跳转到jsp:response对象;
4.两种跳转语句的区别:
     response sendRedirect():客户端跳转,请求不保存;
     <jsp:forward page="**.jsp">:服务器端跳转,请求可以保存;
5.jsp的四种属性保存范围:
     page 
     request
     session
     application
6.通过Servlet给jsp传递值:
     如果在servlet中设置 req.setAttribute("",""); 
     在jsp中这样获取: <%=request.getAttribute("")%>
     这样是取不到值的
     正确的做法:
     servlet中通过session传递: req.getSession().setAttribute("","");
     jsp中设置:<%=session.getAttribute("")%>
     //session方法,在用户登录阶段存在,浪费资源
     完美的解决方法:
     使用request的接口RequestDispatcher
      RequestDispatcher接口,是基于服务器端servlet到jsp的跳转,要去使用 HttpServletRequest进行实例化
	该接口的两个方法: include() forward()
		req.setAttribute("name","lord");
		RequestDispatcher rd = null;
		//将要跳转的jsp页面转换成一个RequestDispatcher对象,有该对象的 forward(request,response)方法完成传递
		rd = req.getRequestDispatcher("mvcdemo.jsp");
		rd.forward(req,rep);
		//完成与<jsp:forward>一样的功能
	在jsp中 <%=request.getAttribute("name")%>
7.例子
login.html页面
//将表单的内容提交到servlet中处理
<form action="mvcdemo.mldn" method="post">
输入姓名：<input type="text" name="uname">
<input type="submit" value="提交">
</form>
//登录成功页面
<%@page contentType="text/html;charset=gb2312"%>
<h1>输入成功！！！</h1>
<h2>欢迎：<%=request.getAttribute("name")%>光临！！！</h2>
//登录失败页面
<%@page contentType="text/html;charset=gb2312"%>
<h1>输入失败！！！</h1>
<h2><a href="mvc_login.htm">重新登陆</a></h2>
//一个包含name 和 判断是否为空方法的bean
package cn.mldn.lxh.bean;

public class MVCCheckBean
{
	private String name;
	public void setName(String name)
	{
            this.name = name;
 	}
	public String getName()
	{
		return this.name;
	}
	public boolean isValidate()
	{
		//名称为空
		if(this.name==null||"".equals(this.name))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
//servlet
package cn.mldn.lxh.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import cn.mldn.lxh.bean.MVCCheckBean ;

public class MVCServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse rep) throws IOException,ServletException
	{
		this.doPost(req,rep);
	}
	public  void doPost(HttpServletRequest req,HttpServletResponse rep) throws IOException,ServletException
	{
		String name = req.getParameter("uname");
		MVCCheckBean mc = new MVCCheckBean();
		mc.setName(name);
		String path = null;
		if(mc.isValidate())
		{
			req.setAttribute("name",mc.getName());
			path="mvc_sucess.jsp";
		}
		else
		{
			path="mvc_failure.jsp";
		}
		 req.getRequestDispatcher(path).forward(req,rep);
	}
}
8.mvc特点
    jsp与javaBean没什么直接的联系
    servlet根据javaBean返回的内容进行跳转
    servlet最好有下面的几种代码:
         接受参数
	   调用javaBean
	   进行跳转
	   有一些简单的逻辑判断
    