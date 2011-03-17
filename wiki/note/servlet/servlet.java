servlet的概念
1.什么是servlet
      java支持动态的网页技术,直接编写java代码,利用cgi的方式来与web server沟通
		servlet编写的困难:需要完整的java程序设计技巧
		                           网页呈现部分与逻辑业务处理代码部分混合不易维护
	servlet是一种使用java编写的cgi程序
	      cgi:通用网关接口
		与传统cgi的不同:servlet是一种使用多线程的程序处理方式--性能高
		servlet可以控制输出html代码,html代码都必须使用out.println("...")输出
servlet生命周期
	初始化时期
	   public void init(ServletConfig config) throws ServletException
	    {super.init(config)}
	 执行周期
	    doServices
	    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	结束周期
	    public void destroy()
2.简单的servlet程序
	直接继承自HttpServlet
	在doPost(doGet)方法中写入相应的程序代码
	配置web.xml
	//servlet必须放在web-inf/classes/下   
	JSP程序的功能和servlet一致,也就意味这servlet程序同样可以被外部访问,就必须有同一个地址,通过web隐射解决
	    修改web.xml文件(/web-info目录下)配置隐射文件
	    <servlet>
	    //servlet名
    <servlet-name>simple</servlet-name>
    //具体的servlet地址
    <servlet-class>cn.mldn.lxh.servlet.SimpleServlet</servlet-class>
</servlet>
<servlet-mapping>
      //与映射地址对象的servlet名
     <servlet-name>simple</servlet-name>
     //在地址栏中输入的映射地址
     <url-pattern>/demo</url-pattern>
</servlet-mapping>
3./*web.xml修改后,服务器必须重启*/
4.在编译servlet时,有时候会出现找不到servlet的情况,这是因为servlet为jdk的扩展包,所以在使用时必需指定classpath .具体方法:
           set classpath = %tomcat%\common\lib\servlet.jar
   或者:
           将servlet.jar包复制到jdk的jre\lib\ext下
5.HttpServlet包
      HttpServlet类:  继承自GenericServlet类,增加了7个方法:
	     doGet()//表示处理get请求,缺省的,表单和地址栏输入都为get请求
	     doPost()//表单输入请求
	     doPut()
	     doHean()
	     doOption()
	     doDelete()
	     doTrace()
6.一个servlet框架
package cn.mldn.lxh.servlet;
 //HttpServlet属于javax.servlet目录下
 import java.io.*;
 import javax.servlet.*;
 //HttpServletRequest,HttpServletResponse都存放在javax.servlet.http包下
 import javax.servlet.http.*;
public class LifeCycleServlet extends HttpServlet
{
	//初始化
	public void init(ServletConfig config) throws ServletException
	{
		system.out.println("....Servlet初始化...");
	}
    public void doGet(HttpServletRequest request,HttpServletResponse resp) throws IOException,ServletException
    {
             system.out.println("....Servlet doGet()处理...");
    }
        public void doPost(HttpServletRequest request,HttpServletResponse resp) throws IOException,ServletException
    {
          system.out.println("....Servlet  doPost()处理...");
    }
        public void destroy()
     {
	     system.out.println("....Servlet销毁..");
	}
}
7. 
   在第一次使用servlet的时候初始化 init()
               可以在容器启动时初始化servlet程序,配置web.xml
<servlet>
    <servlet-name>simple</servlet-name>
    <servlet-class>cn.mldn.lxh.servlet.SimpleServlet</servlet-class>
    <load-on-startup>1</load-on-startup>//1代表优先级 o最高
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
   服务(doGet doPost)直接输入地址就是get
   销毁:服务器关闭;此servlet长时间不使用;只调用一次
8.servlet注意事项:
    符合servlet开发结构
    配置web.xml
9.servlet的两种初始化
   //无参的构造方法 ,在不需要传递初始化参数时使用
   public void init() throws ServletException
   {
	   
   }
   //有参构造方法,当需要传递初始化参数时使用
   public void init(ServletConfig config) throws IOException,ServletException
   {
	   
    }
10.多个名称映射一个servlet文件
    只需要保持<servlet-name>一致,就可以有多个ServletMapping
    <servlet>
    <servlet-name>simple</servlet-name>
    <servlet-class>cn.mldn.lxh.servlet.SimpleServlet</servlet-class>
    <load-on-startup>1</load-on-startup>//1代表优先级 o最高,自动加载更新的类
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
     <url-pattern>/hellow/*</url-pattern>//这里的*必需输入完成的路径名 例如  /hellow/www.baidu.com
</servlet-mapping>
*/
11.获得初始化配置参数
 在Servlet启动时,往往需要读取一些初始化配置的信息,在Servlet中使用,使用ServletConfig可以取得初始化配置参数
 初始化配置参数需要在web.xml中配置;
 可以通过初始化参数来设置数据库的连接地址,驱动程序等,但很少使用;
 12.动态web的主要功能体现在交互-表单上
     HttpServletRequest HttpServletResponse的两个对象 request response
13.解决servlet的路径问题:
    用../表示上一级目录;
    在servlet-mapping下的url-pattern中配置好完整的路径;
14. servlet接口                            jsp接口
  HttpServletRequest                   request
  HttpServletResponse                 response
  ServletConfig                           config
  HttpSession                             session通过request取得
  ServletContext                         application
                                                两种初始化方法:
								      无参数初始化();
									有参构造(init(ServletConfig config))config对象取得