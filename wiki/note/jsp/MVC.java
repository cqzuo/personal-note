Ŀ��: ����jsp+javaBean�Ŀ���ģʽ
         MVC�����ģʽ
1.��վ����ģʽ1:
       jsp+javaBean����:
	       �ʺϿ��ٿ���,jsp��javaBean�������,��Կ���ά������鷳:
		   browser--->jsp--->javaBean-->DataBase
       jsp+servlet+javaBean����:
	       �ʺ��Ŷӿ���,�ô�ģʽ����,�ٶ���,��ά���Ը�
		 browser---->servlet(Controler)--->javaBean(model)<--->database
			     <----jsp
2.����:
     javaBean�ŵ�:���ظ�ʹ��,��Ҫ���ղ���������Ӧ�Ĵ���;
     jsp�ŵ�:��������ǰ̨������ui����;
     Servlet�ŵ�:��java����,��ȫ�Ը�,����Ҳ��;������jspһ�����ղ���
     servletȱ��:��ʾ������;
3.����:
     ��jsp��ת��servlet:���ύ������;
     ��servlet��ת��jsp:response����;
4.������ת��������:
     response sendRedirect():�ͻ�����ת,���󲻱���;
     <jsp:forward page="**.jsp">:����������ת,������Ա���;
5.jsp���������Ա��淶Χ:
     page 
     request
     session
     application
6.ͨ��Servlet��jsp����ֵ:
     �����servlet������ req.setAttribute("",""); 
     ��jsp��������ȡ: <%=request.getAttribute("")%>
     ������ȡ����ֵ��
     ��ȷ������:
     servlet��ͨ��session����: req.getSession().setAttribute("","");
     jsp������:<%=session.getAttribute("")%>
     //session����,���û���¼�׶δ���,�˷���Դ
     �����Ľ������:
     ʹ��request�Ľӿ�RequestDispatcher
      RequestDispatcher�ӿ�,�ǻ��ڷ�������servlet��jsp����ת,Ҫȥʹ�� HttpServletRequest����ʵ����
	�ýӿڵ���������: include() forward()
		req.setAttribute("name","lord");
		RequestDispatcher rd = null;
		//��Ҫ��ת��jspҳ��ת����һ��RequestDispatcher����,�иö���� forward(request,response)������ɴ���
		rd = req.getRequestDispatcher("mvcdemo.jsp");
		rd.forward(req,rep);
		//�����<jsp:forward>һ���Ĺ���
	��jsp�� <%=request.getAttribute("name")%>
7.����
login.htmlҳ��
//�����������ύ��servlet�д���
<form action="mvcdemo.mldn" method="post">
����������<input type="text" name="uname">
<input type="submit" value="�ύ">
</form>
//��¼�ɹ�ҳ��
<%@page contentType="text/html;charset=gb2312"%>
<h1>����ɹ�������</h1>
<h2>��ӭ��<%=request.getAttribute("name")%>���٣�����</h2>
//��¼ʧ��ҳ��
<%@page contentType="text/html;charset=gb2312"%>
<h1>����ʧ�ܣ�����</h1>
<h2><a href="mvc_login.htm">���µ�½</a></h2>
//һ������name �� �ж��Ƿ�Ϊ�շ�����bean
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
		//����Ϊ��
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
8.mvc�ص�
    jsp��javaBeanûʲôֱ�ӵ���ϵ
    servlet����javaBean���ص����ݽ�����ת
    servlet���������ļ��ִ���:
         ���ܲ���
	   ����javaBean
	   ������ת
	   ��һЩ�򵥵��߼��ж�
    