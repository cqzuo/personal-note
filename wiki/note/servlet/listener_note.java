1.什么是监听器
  是对整个web环境的监听
  主要有三类:
  	ServletContext:servlet上下文
  	Session:对session监听
  	Request:对request监听
2.对ServletContext的监听
  在web端实现监听 = 实现一系列的监听接口
  	ServletContextListener:对整个serlvet上下文的监听
  		public void contextInitialized(ServletContextEvent sce)//上下文启动
  		public void contextDestroyed(ServletContextEvent sce)//上下文销毁
  			ServletContextEvent:
  				public ServletContextEvent(ServletContext source)
  				public ServletContext getServletContext()//取得一个ServletContext对象(application对象)
  	ServletContextAttributeListener:对Servlet上下文属性的监听
  		public void attributeAdded(ServletContextAttributeEvent scab)//增加属性
  		public void attributeRemoved(ServletContextAttributeEvent scab)//移除属性
  		public void attributeReplaced(ServletContextAttributeEvent scab)//替换属性(第二次设置属性)
  		     ServletContextAttributeEvent:
  		     	public java.lang.String getName()//得到属性名称
  		     	public java.lang.Object getValue()//得到属性值
/*设置属性的方法:
 *public void setAttribute(String name,Object value)
 **/
3.一个对application监听器的例子
ServletContextListenDemo.java
package cn.mldn.lxh.servlet;
import javax.servlet.*;
public class ServletContextListenDemo implements ServletContextListener,ServletContextAttributeListener
{
	private ServletContext application =null;
	//实现方法
  	public void contextInitialized(ServletContextEvent sce)
  	{
  		this.application = sce.getServletContext(); 
  	    System.out.println("上下文初始化");
  	    System.out.println("当前虚拟目录的绝对路径为:"+this.application.getRealPath("/"));
  	}
  	public void contextDestroyed(ServletContextEvent sce)
  	{
  		System.out.println("上下文销毁");
  	}
  	public void attributeAdded(ServletContextAttributeEvent scae)
  	{
  		System.out.println("增加属性:"+scae.getName()+"--->"+scae.getValue());
  	}
  	public void attributeRemoved(ServletContextAttributeEvent scae)
  	{
  		System.out.println("删除属性:"+scae.getName()+"--->"+scae.getValue());
  	}
  	public void attributeReplaced(ServletContextAttributeEvent scae)
  	{
  		System.out.println("替换属性:"+scae.getName()+"--->"+scae.getValue());
  	}
}
增加属性
<%
   getServletContext().setAttribute("name","lord");
%>
删除属性
<%
   getServletContext().removeAttribute("name");
%>
对servletContext的监听是对容器的:初始化,销毁,属性操作
4.对session的监听
session属于http协议下的内容:javax.servlet.HttpSessionXxxx
public interface HttpSessionListener extends java.util.EventListener
   public void sessionCreated(HttpSessionEvent se) //session的创建
   public void sessionDestroyed(HttpSessionEvent se)  //session的销毁
HttpSessionEvent 事件:
   public HttpSessionEvent(HttpSession source)
   public HttpSession getSession() //取得当前操作的session   
public interface HttpSessionAttributeListener extends java.util.EventListener
   public void attributeAdded(HttpSessionBindingEvent se) //增加属性
   public void attributeRemoved(HttpSessionBindingEvent se) //删除属性
   public void attributeReplaced(HttpSessionBindingEvent se)  //置换属性
HttpSessionBindingEvent 事件:
   public HttpSession getSession()//取得当前session
   public java.lang.String getName()//取得属性名称
   public java.lang.Object getValue()//取得属性值
4.例子:
HttpSessionDemo01.java
package cn.mldn.lxh.listener;

import javax.servlet.http.*;

public class HttpSessionDemo01 
implements HttpSessionListener,HttpSessionAttributeListener
{
	private HttpSession session;
	public void sessionCreated(HttpSessionEvent se)
	{
		this.session=se.getSession();
		System.out.println("Session创建");
		System.out.println("SessionID--->"+this.session.getId());
	}
	public void sessionDestroyed(HttpSessionEvent se)
	{
		System.out.println("Session销毁");
	}
	public void attributeAdded(HttpSessionBindingEvent se)
	{
		System.out.println("Session增加属性--->"+se.getName()+"-->"+se.getValue());
	}
	public void attributeRemoved(HttpSessionBindingEvent se)
	{
		System.out.println("Session删除属性--->"+se.getName()+"-->"+se.getValue());
	}
	public void attributeReplaced(HttpSessionBindingEvent se)
	{
		System.out.println("Session替换属--->"+se.getName()+"-->"+se.getValue());
	}
}
操作
<%
   session.setAttribute("name");
%>
web.xml
<listener>
<listener-class>cn.mldn.lxh.listener.HttpSessionDemo01</listener-class>
</listener>
5.session的销毁
   session超时失效web.xml配置
       <listener>
       <listener-class>cn.mldn.lxh.listener.HttpSessionDemo01</listener-class>
       </listener>
       <session-config>
       <session-timeout>1</session-timeout>//一分钟失效
       </session-config>
   session手工失效
5.应用
 统计当前在线人员列表
 	统计在线人数-ServletContextListener接口
 	显示在线人的登录名-HttpServletSessionAttributeListener接口
 	在线-HttpServletSessionListener接口