servlet�ĸ���
1.ʲô��servlet
      java֧�ֶ�̬����ҳ����,ֱ�ӱ�дjava����,����cgi�ķ�ʽ����web server��ͨ
		servlet��д������:��Ҫ������java������Ƽ���
		                           ��ҳ���ֲ������߼�ҵ������벿�ֻ�ϲ���ά��
	servlet��һ��ʹ��java��д��cgi����
	      cgi:ͨ�����ؽӿ�
		�봫ͳcgi�Ĳ�ͬ:servlet��һ��ʹ�ö��̵߳ĳ�����ʽ--���ܸ�
		servlet���Կ������html����,html���붼����ʹ��out.println("...")���
servlet��������
	��ʼ��ʱ��
	   public void init(ServletConfig config) throws ServletException
	    {super.init(config)}
	 ִ������
	    doServices
	    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	��������
	    public void destroy()
2.�򵥵�servlet����
	ֱ�Ӽ̳���HttpServlet
	��doPost(doGet)������д����Ӧ�ĳ������
	����web.xml
	//servlet�������web-inf/classes/��   
	JSP����Ĺ��ܺ�servletһ��,Ҳ����ζ��servlet����ͬ�����Ա��ⲿ����,�ͱ�����ͬһ����ַ,ͨ��web������
	    �޸�web.xml�ļ�(/web-infoĿ¼��)���������ļ�
	    <servlet>
	    //servlet��
    <servlet-name>simple</servlet-name>
    //�����servlet��ַ
    <servlet-class>cn.mldn.lxh.servlet.SimpleServlet</servlet-class>
</servlet>
<servlet-mapping>
      //��ӳ���ַ�����servlet��
     <servlet-name>simple</servlet-name>
     //�ڵ�ַ���������ӳ���ַ
     <url-pattern>/demo</url-pattern>
</servlet-mapping>
3./*web.xml�޸ĺ�,��������������*/
4.�ڱ���servletʱ,��ʱ�������Ҳ���servlet�����,������ΪservletΪjdk����չ��,������ʹ��ʱ����ָ��classpath .���巽��:
           set classpath = %tomcat%\common\lib\servlet.jar
   ����:
           ��servlet.jar�����Ƶ�jdk��jre\lib\ext��
5.HttpServlet��
      HttpServlet��:  �̳���GenericServlet��,������7������:
	     doGet()//��ʾ����get����,ȱʡ��,���͵�ַ�����붼Ϊget����
	     doPost()//����������
	     doPut()
	     doHean()
	     doOption()
	     doDelete()
	     doTrace()
6.һ��servlet���
package cn.mldn.lxh.servlet;
 //HttpServlet����javax.servletĿ¼��
 import java.io.*;
 import javax.servlet.*;
 //HttpServletRequest,HttpServletResponse�������javax.servlet.http����
 import javax.servlet.http.*;
public class LifeCycleServlet extends HttpServlet
{
	//��ʼ��
	public void init(ServletConfig config) throws ServletException
	{
		system.out.println("....Servlet��ʼ��...");
	}
    public void doGet(HttpServletRequest request,HttpServletResponse resp) throws IOException,ServletException
    {
             system.out.println("....Servlet doGet()����...");
    }
        public void doPost(HttpServletRequest request,HttpServletResponse resp) throws IOException,ServletException
    {
          system.out.println("....Servlet  doPost()����...");
    }
        public void destroy()
     {
	     system.out.println("....Servlet����..");
	}
}
7. 
   �ڵ�һ��ʹ��servlet��ʱ���ʼ�� init()
               ��������������ʱ��ʼ��servlet����,����web.xml
<servlet>
    <servlet-name>simple</servlet-name>
    <servlet-class>cn.mldn.lxh.servlet.SimpleServlet</servlet-class>
    <load-on-startup>1</load-on-startup>//1�������ȼ� o���
</servlet>
<servlet-mapping>
     <servlet-name>simple</servlet-name>
     <url-pattern>/demo</url-pattern>
</servlet-mapping>
  <servlet>
    <servlet-name>LifeCycleServlet</servlet-name>
    <servlet-class>cn.mldn.lxh.servlet.LifeCycleServlet</servlet-class>
</servlet>
<servlet-mapping>
     <servlet-name>LifeCycleServlet</servlet-name>
     <url-pattern>/demo1</url-pattern>
</servlet-mapping>
   ����(doGet doPost)ֱ�������ַ����get
   ����:�������ر�;��servlet��ʱ�䲻ʹ��;ֻ����һ��
8.servletע������:
    ����servlet�����ṹ
    ����web.xml
9.servlet�����ֳ�ʼ��
   //�޲εĹ��췽�� ,�ڲ���Ҫ���ݳ�ʼ������ʱʹ��
   public void init() throws ServletException
   {
	   
   }
   //�вι��췽��,����Ҫ���ݳ�ʼ������ʱʹ��
   public void init(ServletConfig config) throws IOException,ServletException
   {
	   
    }
10.�������ӳ��һ��servlet�ļ�
    ֻ��Ҫ����<servlet-name>һ��,�Ϳ����ж��ServletMapping
    <servlet>
    <servlet-name>simple</servlet-name>
    <servlet-class>cn.mldn.lxh.servlet.SimpleServlet</servlet-class>
    <load-on-startup>1</load-on-startup>//1�������ȼ� o���,�Զ����ظ��µ���
</servlet>
<servlet-mapping>
     <servlet-name>simple</servlet-name>
     <url-pattern>/demo</url-pattern>
</servlet-mapping>
    <servlet-mapping>
     <servlet-name>simple</servlet-name>
     <url-pattern>/demo.lxh</url-pattern>
</servlet-mapping>
    <servlet-mapping>
     <servlet-name>simple</servlet-name>
     <url-pattern>/demo.mldn</url-pattern>
</servlet-mapping>
    <servlet-mapping>
     <servlet-name>simple</servlet-name>
     <url-pattern>/hellow/*</url-pattern>//�����*����������ɵ�·���� ����  /hellow/www.baidu.com
</servlet-mapping>
*/
11.��ó�ʼ�����ò���
 ��Servlet����ʱ,������Ҫ��ȡһЩ��ʼ�����õ���Ϣ,��Servlet��ʹ��,ʹ��ServletConfig����ȡ�ó�ʼ�����ò���
 ��ʼ�����ò�����Ҫ��web.xml������;
 ����ͨ����ʼ���������������ݿ�����ӵ�ַ,���������,������ʹ��;
 12.��̬web����Ҫ���������ڽ���-����
     HttpServletRequest HttpServletResponse���������� request response
13.���servlet��·������:
    ��../��ʾ��һ��Ŀ¼;
    ��servlet-mapping�µ�url-pattern�����ú�������·��;
14. servlet�ӿ�                            jsp�ӿ�
  HttpServletRequest                   request
  HttpServletResponse                 response
  ServletConfig                           config
  HttpSession                             sessionͨ��requestȡ��
  ServletContext                         application
                                                ���ֳ�ʼ������:
								      �޲�����ʼ��();
									�вι���(init(ServletConfig config))config����ȡ��