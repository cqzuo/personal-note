1.ʲô�Ǽ�����
  �Ƕ�����web�����ļ���
  ��Ҫ������:
  	ServletContext:servlet������
  	Session:��session����
  	Request:��request����
2.��ServletContext�ļ���
  ��web��ʵ�ּ��� = ʵ��һϵ�еļ����ӿ�
  	ServletContextListener:������serlvet�����ĵļ���
  		public void contextInitialized(ServletContextEvent sce)//����������
  		public void contextDestroyed(ServletContextEvent sce)//����������
  			ServletContextEvent:
  				public ServletContextEvent(ServletContext source)
  				public ServletContext getServletContext()//ȡ��һ��ServletContext����(application����)
  	ServletContextAttributeListener:��Servlet���������Եļ���
  		public void attributeAdded(ServletContextAttributeEvent scab)//��������
  		public void attributeRemoved(ServletContextAttributeEvent scab)//�Ƴ�����
  		public void attributeReplaced(ServletContextAttributeEvent scab)//�滻����(�ڶ�����������)
  		     ServletContextAttributeEvent:
  		     	public java.lang.String getName()//�õ���������
  		     	public java.lang.Object getValue()//�õ�����ֵ
/*�������Եķ���:
 *public void setAttribute(String name,Object value)
 **/
3.һ����application������������
ServletContextListenDemo.java
package cn.mldn.lxh.servlet;
import javax.servlet.*;
public class ServletContextListenDemo implements ServletContextListener,ServletContextAttributeListener
{
	private ServletContext application =null;
	//ʵ�ַ���
  	public void contextInitialized(ServletContextEvent sce)
  	{
  		this.application = sce.getServletContext(); 
  	    System.out.println("�����ĳ�ʼ��");
  	    System.out.println("��ǰ����Ŀ¼�ľ���·��Ϊ:"+this.application.getRealPath("/"));
  	}
  	public void contextDestroyed(ServletContextEvent sce)
  	{
  		System.out.println("����������");
  	}
  	public void attributeAdded(ServletContextAttributeEvent scae)
  	{
  		System.out.println("��������:"+scae.getName()+"--->"+scae.getValue());
  	}
  	public void attributeRemoved(ServletContextAttributeEvent scae)
  	{
  		System.out.println("ɾ������:"+scae.getName()+"--->"+scae.getValue());
  	}
  	public void attributeReplaced(ServletContextAttributeEvent scae)
  	{
  		System.out.println("�滻����:"+scae.getName()+"--->"+scae.getValue());
  	}
}
��������
<%
   getServletContext().setAttribute("name","lord");
%>
ɾ������
<%
   getServletContext().removeAttribute("name");
%>
��servletContext�ļ����Ƕ�������:��ʼ��,����,���Բ���
4.��session�ļ���
session����httpЭ���µ�����:javax.servlet.HttpSessionXxxx
public interface HttpSessionListener extends java.util.EventListener
   public void sessionCreated(HttpSessionEvent se) //session�Ĵ���
   public void sessionDestroyed(HttpSessionEvent se)  //session������
HttpSessionEvent �¼�:
   public HttpSessionEvent(HttpSession source)
   public HttpSession getSession() //ȡ�õ�ǰ������session   
public interface HttpSessionAttributeListener extends java.util.EventListener
   public void attributeAdded(HttpSessionBindingEvent se) //��������
   public void attributeRemoved(HttpSessionBindingEvent se) //ɾ������
   public void attributeReplaced(HttpSessionBindingEvent se)  //�û�����
HttpSessionBindingEvent �¼�:
   public HttpSession getSession()//ȡ�õ�ǰsession
   public java.lang.String getName()//ȡ����������
   public java.lang.Object getValue()//ȡ������ֵ
4.����:
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
		System.out.println("Session����");
		System.out.println("SessionID--->"+this.session.getId());
	}
	public void sessionDestroyed(HttpSessionEvent se)
	{
		System.out.println("Session����");
	}
	public void attributeAdded(HttpSessionBindingEvent se)
	{
		System.out.println("Session��������--->"+se.getName()+"-->"+se.getValue());
	}
	public void attributeRemoved(HttpSessionBindingEvent se)
	{
		System.out.println("Sessionɾ������--->"+se.getName()+"-->"+se.getValue());
	}
	public void attributeReplaced(HttpSessionBindingEvent se)
	{
		System.out.println("Session�滻��--->"+se.getName()+"-->"+se.getValue());
	}
}
����
<%
   session.setAttribute("name");
%>
web.xml
<listener>
<listener-class>cn.mldn.lxh.listener.HttpSessionDemo01</listener-class>
</listener>
5.session������
   session��ʱʧЧweb.xml����
       <listener>
       <listener-class>cn.mldn.lxh.listener.HttpSessionDemo01</listener-class>
       </listener>
       <session-config>
       <session-timeout>1</session-timeout>//һ����ʧЧ
       </session-config>
   session�ֹ�ʧЧ
5.Ӧ��
 ͳ�Ƶ�ǰ������Ա�б�
 	ͳ����������-ServletContextListener�ӿ�
 	��ʾ�����˵ĵ�¼��-HttpServletSessionAttributeListener�ӿ�
 	����-HttpServletSessionListener�ӿ�