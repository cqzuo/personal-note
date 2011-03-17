1.以往登录案例分析:
     优点:DAO负责数据层操作
            jap负责显示
	缺点:javaBean和jsp代码紧密耦合
2.mvc模式:解决javaBean和jsp代码耦合的问题
3.代码修正
	去掉失败页,将登录失败信息显示在登录页
	对代码显示增加错误信息提示(数据为空,长度不够等)
	使用servlet来替换登录验证
4.对登录页错误的描述
	<%
		if(request.getAttribute("errors")!=null)
		{
			// 有错误，要进行打印输出
			List all = (List)request.getAttribute("errors") ;
			Iterator iter = all.iterator() ;
			while(iter.hasNext())
			{
	%>
				<li><%=iter.next()%>
	<%
			}
		}
	%>
//注意List对象的输出: 调用iterator()方法封装为iterator对象,用while(iter.next()){}输出
  用一个servlet来做控制器
// 建立MVC中的C，完成JSP+Servlet+JavaBean的开发模式
//servlet的作用 控制调用
package org.lxh.servlet ;

import java.io.* ;
import java.util.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
import org.lxh.factory.* ;
import org.lxh.vo.* ;

public class LoginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		this.doPost(request,response) ;
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		// 声明一个集合类，用于保存错误信息
		List errors = new ArrayList() ;
		// 完成登陆验证，替换掉login_conf.jsp
		String path = "login.jsp" ;
		// 1、接收请求内容
		String id = request.getParameter("id") ;
		String password = request.getParameter("password") ;
		// 2、进行数据合法性验证，包括是否为空，长度是否满足等
		// 要将接收到的内容设置给PersonVO对象
		PersonVo pv = new PersonVo() ;
		pv.setId(id) ;
		pv.setPassword(password) ;
		pv.setErrors(errors) ;
		// 3、如果合法，则进行数据库验证
		if(pv.invalidate())
		{
			// 数据合法，可以进行数据库验证
			if(DAOFactory.getPersonDAOInstance().isLogin(pv))
			{
				// 用户ID、密码合法
				// 修改跳转路径
				// 保存用户名到request范围之中
				// request.setAttribute("name",pv.getName()) ;
				path = "login_success.jsp" ;
			}
			else
			{
				// 用户ID、密码非法
				errors.add("错误的用户ID及密码！") ;
			}
		}
		// 将错误信息保存
		request.setAttribute("errors",errors) ;
		request.setAttribute("person",pv) ;
		request.getRequestDispatcher(path).forward(request,response) ;
	}
};
