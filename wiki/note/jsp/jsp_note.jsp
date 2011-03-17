1.在也页面上判断是否出错,如出错则给出出错信息:
<%
		// 判断是否有错误信息，如果有则打印
		// 如果没有此段代码，则显示时会直接打印null
		if(request.getAttribute("err")!=null)
		{
	%>
			<h2><%=request.getAttribute("err")%></h2>
	<%
		}
	%>
2.接收从页面上login form中传递来的参数
<%
		// 声明一个boolean变量，用于保存用户是否合法的状态
		boolean flag = false ;

		// 接收参数,注意参数带""
		String id = request.getParameter("id") ;
		String password = request.getParameter("password") ;
	%>
	<%
try
		{
			id = Integer.parseInt(request.getParameter("id")) ;
		}
	%>
3.登录用户信息的保留和出错信息的设置
request 和session等容器内置对象可以直接使用
<%
rs = pstmt.executeQuery() ;
			if(rs.next())
			{
				// 用户合法
				flag = true ;
				// 将用户名保存在session之中
				session.setAttribute("uname",rs.getString(1)) ;
			}
			else
			{
				// 保存错误信息在下一个页面中显示request范围
				request.setAttribute("err","错误的用户名及密码！！！") ;//由于只是在login.jsp中显示其错误,request范围即可
			}
%>
4.在Jsp中的跳转用<jsp:forward page=""/>来实现
<%
		// 跳转
		if(flag)
		{
			// 用户合法
	%>
			<jsp:forward page="login_success.jsp"/>
	<%
		}
		else
		{
			// 用户非法
	%>
			<jsp:forward page="login.jsp"/>
	<%
		}
	%>
5.强制页面转向的方法
 response是jsp的对象 setHeader()是设置发送信息的头文件信息添加内容
 <%
else
		{
			// 用户未登陆，提示用户登陆，并跳转
			response.setHeader("refresh","2;URL=login.jsp") ;
	%>
			您还未登陆，请先登陆！！！<br>
			两秒后自动跳转到登陆窗口！！！<br>
			如果没有跳转，请按<a href="login.jsp">这里</a>！！！<br>
	<%
		}
	%>
	<%
          response.sendRedirect("welcome.jsp") ;//直接跳转到指定页面
      %>
6.设置必须登录用户才能访问的页面
  设置request传递来的参数字符格式化
<%
		// 编码转换
		request.setCharacterEncoding("GB2312") ;
		if(session.getAttribute("uname")!=null)
		{
			// 用户已登陆
	%>
	//代码..
		<%
		}
		else
		{
			// 用户未登陆，提示用户登陆，并跳转
			response.setHeader("refresh","2;URL=login.jsp") ;
	%>
	<%
			您还未登陆，请先登陆！！！<br>
			两秒后自动跳转到登陆窗口！！！<br>
			如果没有跳转，请按<a href="login.jsp">这里</a>！！！<br>
		}
	%>
7.关键词查询和模糊查询
<%
		// 如果有内容，则修改变量i，如果没有，则根据i的值进行无内容提示
		int i = 0 ;
		String sql = null; 
		String keyword = request.getParameter("keyword") ;//接收form传递来的Kyeword
		// out.println(keyword) ;
		if(keyword==null)
		{
			// 没有任何查询条件
			sql = "SELECT id,title,author,content FROM note" ;
		}
		else
		{
			// 有查询条件
			sql = "SELECT id,title,author,content FROM note WHERE title like ? or author like ? or content like ?" ;
		}
		
		try
		{
			Class.forName(DBDRIVER) ;
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
			pstmt = conn.prepareStatement(sql) ;

			// 如果存在查询内容，则需要设置查询条件
			if(keyword!=null)
			{
				// 存在查询条件
				pstmt.setString(1,"%"+keyword+"%") ;
				pstmt.setString(2,"%"+keyword+"%") ;
				pstmt.setString(3,"%"+keyword+"%") ;
			}

			rs = pstmt.executeQuery() ;
	%>
8.查询内容的输出和设置查询后关键字变色
<%
			while(rs.next())
			{
				i++ ;
				// 进行循环打印，打印出所有的内容，以表格形式
				// 从数据库中取出内容
				int id = rs.getInt(1) ;
				String title = rs.getString(2) ;
				String author = rs.getString(3) ;
				String content = rs.getString(4) ;

				if(keyword!=null)
				{
					// 需要将数据返红
					title = title.replaceAll(keyword,"<font color=\"red\">"+keyword+"</font>") ;
					author = author.replaceAll(keyword,"<font color=\"red\">"+keyword+"</font>") ;
					content = content.replaceAll(keyword,"<font color=\"red\">"+keyword+"</font>") ;
				}
%>
9.更新数据库的操作都是
rs = pstmt.executeQuery() ;
10.从request读取的参数的格式化
  id = Integer.parseInt(request.getParameter("id")) ;
 11.防止出现溢出错误,在判断两个字符串是否相等时,""字符串放在前面
 <%
		// 判断用户名及密码
		// if("mldn"==name&&"lxh"==password)
		if("mldn".equals(name)&&"lxh".equals(password))		
		{
			// 合法用户
	%>
12.浏览器传递参数
demo06.jsp?uname=MLDN&upass=LiXingHua
13.cookie的设置和使用
<%
	Cookie c1 = new Cookie("name","mldn") ;
	Cookie c2 = new Cookie("password","LXH") ;

	// 保存时间为60秒
	c1.setMaxAge(60) ;
	c2.setMaxAge(60) ;
%>
<%
	// 通过response对象将Cookie设置到客户端
	response.addCookie(c1) ;
	response.addCookie(c2) ;
%>
cookie的获取
<%
	// 通过request对象，取得客户端设置的全部Cookie
	// 实际上客户端的Cookie是通过HTTP头信息发送到服务器端上的
	Cookie c[] = request.getCookies() ;
%>
<%
	for(int i=0;i<c.length;i++)
	{
		Cookie temp = c[i] ;
%>
		<h1><%=temp.getName()%> --> <%=temp.getValue()%></h1>
<%
	}
%>
14.session里对用户登录时间的操作
<%
	long l = session.getCreationTime() ;//获取session的创建时间
	long l2 = session.getLastAccessedTime() ;//获取session最后一次登陆的 时间
%>
<h1>session CREATE : <%=new Date(l)%></h1>
<h1>session last access: <%=new Date(l2)%></h1>
<h1><%=(l2-l)/1000%></h1>
15.设置只有登陆过的用户才能访问
<%
	if(session.getAttribute("flag")!=null)
	{
		// session被在login.jsp中设置过,如登陆密码正确,设置session的attribute flag为ok
%>
16.jsp中页面转向的参数传递
参数设置
<%
	String name = "LiXingHua" ;
%>

<jsp:forward page="forwardDemo02.jsp">
	<jsp:param name="ref1" value="MLDN"/>
	<jsp:param name="ref2" value="<%=name%>"/>
</jsp:forward>
接收参数
<h1><%=request.getParameter("ref1")%></h1>
<h1><%=request.getParameter("ref2")%></h1>
17.<%@ include  file=""%>页面外文件的导入引用
 <body>直接include导入的文件文本内容,跟文件的后缀名无关,相当于将文件的内容直接复制到include的地方
<%@include%>标签的使用,直接在body中使用
<body>
<%@include file="incl.jsp"%>
<%@include file="incl.txt"%>
<%@include file="incl.inc"%>
</body>
<jsp:include page="">导入页面外文件,跟后缀名有关,将include导入的文件先执行在导入
<body>
<jsp:include page="incl.jsp">
	<jsp:param name="ref1" value="MLDN"/>
	<jsp:param name="ref2" value="LXH"/>
</jsp:include>
<jsp:include page="incl.txt">//由于是txt文件,所以传递的参数不可用
	<jsp:param name="ref1" value="MLDN"/>
	<jsp:param name="ref2" value="LXH"/>
</jsp:include>
<jsp:include page="incl.inc"/>
</body>
Jsp标签引用文件的接受
<body>
<jsp:include page="incl.jsp"/>
<jsp:include page="incl.txt"/>
<jsp:include page="incl.inc"/>
</body>
18.在jsp页面中使用bean和dao模式
在<jsp:useBean>中声明一个bean的使用,在<jsp:setProperty>中设置自动匹配来接受form传递过来的值到bean中去
        <jsp:useBean id="person" scope="page" class="cn.mldn.lxh.note.vo.Person"/>
	<jsp:setProperty name="person" property="*"/>
	<%
	try
	{
		// 跳转
		if(DAOFactory.getPersonDAOInstance().login(person))//获取一个DAO对象的方法:DAOFactory.getDAOInstance()来获取一个DAO类型的DAOImpl对象
		{
			// 设置用户姓名到session范围之中
			session.setAttribute("uname",person.getName()) ;
			// 用户合法
		}
	}
	%>
