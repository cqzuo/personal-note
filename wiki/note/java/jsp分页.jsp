●问题描述：
简单点说是JSP分页问题.用三层架构来做.(一个JSP页,一个JAVABEAN,一个SERVLET).在网上找了N多例子,好不容易用一层架构(逻辑,控制,模型全在一个JSP页里).勉强做起来了.也勉强达到需要的效果. 
但是想来想去,还没能搞懂其中的逻辑关系.哪位前辈能在我的源码基础上,帮我剥离一下,分成MVC三层架构.这个问题我苦苦思考了两个通宵.都没解决的了. 
实在是想不出如何分离,拜托了... 
●数据库：
我的数据库是SQL SERVER 2000.开发工具MYECLIPSE. 数据库在我打包的DATA文件夹里,数据库用户名和密码均为"sa".采用JTDS驱动连接,JTDS驱动包在WEB-INF的LIB文件夹下.INDEX.JSP为显示页面.CONN包中的DATABASE为数据库连接驱动. 
●其它：
我的源代码下载地址:http://ne.suu.cn/tools/page.rar
另外.我做的页面中.有个TEXT框,让用户选择跳到第几页. 输入数字,肯定是会跳,不排除输入非数字的情况,比如字母或者字符.虽然我用TRY-CATCH拦截了一下,但是在MYECLIPSE的控制台中会打印出异常结果,这是我写了一句,打印出异常. 如果我在页面里用JS脚本做个判断(用的isNaN),则这个功能也无法实现了. 
麻烦前辈连同这个问题一起指点一下. 


★★★ 问题补充 ★★★  (2007-10-3 0:33:57)
拜托哪位前辈尽快能为我解决.我真的急啊.
我的项目因为这个模块,已经耽搁很久了.
如果我做一层的缴上去,项目主管会扣我项目分成的...
拜托...

★★★ 问题补充 ★★★  (2007-10-6 22:30:59)
郁闷了~~ 我都帮别人回答了那么多问题.咋没人帮我解决呢...哭...

★★★ 问题补充 ★★★  (2007-10-21 2:49:24)
谢了.不过,这个问题我后来解决了.
用了AJAX技术,做成了真分页...
你的方法也行的通.
不过,还是要谢谢下.
提问者：chris01@163.com  - 头衔：开发爱好者   

最佳答案
/*index.jsp*/
<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<script language="javaScript">
			function openPage(curpage)
			{
			document.spage.cp.value = curpage ;
			// alert(cupage) ;
			document.spage.submit() ;
			}
		</script>
	</head>
	<body>
		<%
		// 定义如下分页变量
		// 1、定义每页要显示的记录数，默认是10条每页
		int lineSize = 15 ;
		// 2、定义一个当前是第几页
		int currentPage = 1 ;
		// 计算出总页数
		int pageSize = 0 ;
		// 总记录数 / 每页显示的记录数
		int allRecorders = 0 ;
		%>
		<%
		// 全部数据
		List all = (List)request.getAttribute("all") ;
		if(request.getAttribute("currentPage")!=null)
		currentPage=request.getAttribute("currentPage");
		if(request.getAttribute("allRecorders")!=null)
		currentPage=request.getAttribute("allRecorders");
		if(request.getAttribute("currentPage")!=null&&request.getAttribute("allRecorders")!=null)
		pageSize = (allRecorders+lineSize-1)/lineSize ;
		%>
		<form name="spage" action="PageServlet">
			<%
			if(allRecorders>0)
			{
			%> 
			<input type="button" value="首页" onClick="openPage(1)" <%=currentPage==1?"disabled":""%>>
			<input type="button" value="上一页" onClick="openPage(<%=currentPage-1%>)" <%=currentPage==1?"disabled":""%>>
			<input type="button" value="下一页" onClick="openPage(<%=currentPage+1%>)" <%=currentPage==pageSize?"disabled":""%>>
			<input type="button" value="尾页" onClick="openPage(<%=pageSize%>)" <%=currentPage==pageSize?"disabled":""%>>
			<input type="hidden" name="cp" value="">
			<font color="red" size="5"><%=currentPage%></font>
			/
			<font color="red" size="5"><%=pageSize%></font>
			页
			<%
			}
			%>
		</form>
		<table>
			<tr >
				<th align=center>序号</th>
				<th align=center>ID</th>
				<th align=center>Name</th>
				<th align=center>Job</th>
				<th align=center>Address</th>
				<th aligh=center>Update</th>
				<th aligh=center>Delete</th>
			</tr>
			<%
			Iterator iter = all.iterator() ;
			int i=1;
			while(iter.hasNext())
			{
			pageContext.setAttribute("page",iter.next()) ;
			%>
			<tr>
				<td align="center"><%i++%></td>
				<td align="center">${page.id}</td>
				<td align="center">${page.name}</td>
				<td align="center">${page.job}</td>
				<td align="center">${page.address}</td>
				<td align="center"><a href=PageUpdateServlet?id=${page.id}%>>Update</a></td>
				<td align="center"><a href=PageDeleteServlet?id=${page.id}%>>Delete</a></td>
			</tr>
			<%
			}
			if(all.size()==0)
			{
			%>
			<tr>
				<td colspan="6">没有任何数据！！</td>
			</tr>
			<%
			}
			%>
		</table>
	</body>
</html>
/*Servlet*/
package servlet;
import java.util.* ;
import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
import vo.*;
import dao.*;
public class PageServlet extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
request.setCharacterEncoding("GB2312") ;
String path="error.jsp"
// 定义一个当前是第几页
int currentPage = 1 ;
// 定义没页要显示的记录数
int lineSize = 10 ;
// 总记录数 / 每页显示的记录数
int allRecorders = 0 ;
PageDAO pdao = new PageDAO();
try
{
currentPage = Integer.parseInt(request.getParameter("cp")) ;
}
catch(Exception e)
{}
// 查询数据库
try
{
// 查询全部记录数
allRecorders = pdao.getAllCount() ;
// 查询全部记录
request.setAttribute("all",pdao.queryAll(currentPage,lineSize)) ;
}
catch (Exception e)
{
}
request.setAttribute("currentPage",new Integer(currentPage)) ;
request.setAttribute("allRecorders",new Integer(allRecorders)) ;
path = "index.jsp" ;
request.getRequestDispatcher(path).forward(request,response) ;
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
this.doGet(request,response) ;
}
}

/*DAO*/
package dao;
import java.sql.* ;
import java.util.* ;
import conn.*;
import vo.*;
public class PageDAO
{
private DataBase db=null;

public PageDAO(){
db=new DataBase();
}
public int getAllCount() throws Exception{
int count = 0 ;
String sql = "SELECT COUNT(id) from page" ;
PreparedStatement pstmt = null ;
try
{
pstmt = this.db.getConn().prepareStatement(sql) ;
ResultSet rs = pstmt.executeQuery() ;
if(rs.next())
{
count = rs.getInt(1) ;
}
pstmt.close() ;
rs.close() ;
}
catch (Exception e)
{
throw e ;
}
return count ;
}
public List getAll(int currentPage, int lineSize) throws Exception{
List<Person> all = new ArrayList<Person>() ;
String sql = "SELECT * FROM page limit "+(currentPage-1)*lineSize+","+lineSize ;
PreparedStatement pstmt = null ;
try
{
pstmt = this.db.getConn().prepareStatement(sql)  ;
ResultSet rs = pstmt.executeQuery() ;
while(rs.next())
{
Page p = new Person() ;
p.setId(rs.getInt(1)) ;
p.setName(rs.getString(2)) ;
p.setJob(rs.getString(3)) ;
p.setAddress(rs.getString(4)) ;
all.add(p) ;
}
rs.close() ;
pstmt.close() ;
}
catch (Exception e)
{
throw e ;
}
finally
{
this.db.close() ;
}
return all ;
}
}
/*welcome.html*/
<html>
	<head>
	</head>
	<body>
		<center>
			<h2><a href="PageServlet">进入MVC分页程序</a></h2>
		</center>
	</body>
	<html>
		/*web.xml*/
		<servlet>
		<servlet-name>PageServlet</servlet-name>
		<servlet-class>servlet.PageServlet</servlet-class>
		</servlet>
		<servlet-mapping>
		<servlet-name>PageServlet</servlet-name>
		<url-pattern>/PageServlet</url-pattern>
		</servlet-mapping>
		<welcome-file-list>
		<welcome-file>welcome.html</welcome-file>
		</welcome-file-list>
		------------------------------------------------------------
		<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<%@page import="java.sql.*"%>
		<html>
			<body>
				<%
				Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
				String url="jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=student";
				String user="sa";
				String password="command";
				Connection conn=DriverManager.getConnection(url,user,password);
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				String sql;
				int pagecount=0;//总页数
				int pagesize=4;//一页4行记录
				int showpage=1;//默认显示页为第一页
				int recordcount=0;//总记录数
				String topage=request.getParameter("topage");
				if(!(topage==null))
				showpage=Integer.parseInt(topage);
				sql="select count (*) recordcount from T_Student";
				ResultSet rs=stmt.executeQuery(sql);
				rs.next();
				recordcount=rs.getInt("recordcount");
				pagecount=(recordcount+pagesize-1)/pagesize;
				if(showpage>pagecount)
				showpage=pagecount;
				else if(showpage <=0)
				showpage=1;
				sql="SELECT TOP "+pagesize +" * FROM T_Student WHERE (xh NOT IN (SELECT TOP "+(showpage-1)*pagesize +" xh FROM T_Student ORDER BY xh)) ORDER BY xh";
				rs=stmt.executeQuery(sql);
				%>

				<form action="#"> //就是跳转到本页，也可以不写，默认是本页
					<table cellspacing="0" cellPadding="3" border=1 bordercolor="#B0B0B0" rules="all" width="100%">
						<tr bgcolor="#6699FF">
							<td>学号 </td>
							<td>姓名 </td>
							<td>性别 </td>
						</tr>
						<% 
						while(rs.next()){
						%>
						<tr>
							<td> <%=rs.getString(1)%>  </td>                   
							<td> <%=rs.getString(2)%>  </td>
							<td> <%=rs.getString(3)%>  </td>
						</tr>
						<%}%>
					</table>
					<table cellspacing="0" cellPadding="3" border=1 bordercolor="#B0B0B0">
						<tr>
							<td>
								<a href="index.jsp?topage= <%=1%>">第一页 </a>
								<a href="index.jsp?topage= <%=showpage-1%>">上一页 </a>
								<a href="index.jsp?topage= <%=showpage+1%>">下一页 </a>
								<a href="index.jsp?topage= <%=pagecount%>">最后一页 </a>
								<span> <input name="topage" type="text" class="txt_grey" value=" <%=showpage%>"> </span>
							</td>
						</tr>
					</table>
					<%
					rs.close();
					stmt.close();
					conn.close();

					%>
				</form>
			</body>
		</html>
		发表于：2008-05-06 12:47:083楼 得分:20

		HTML code

		<%@ page contentType="text/html; charset=GBK"%> <%@ page import="java.sql.*"%> <% int pagesize=2;//每页显示记录数 int recordcount=0;//记录总数 int pagecount=0;//总页数 int pageid=1;//待显页码 Connection conn=null; try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); conn=DriverManager.getConnection("jdbc:odbc:jspguest","sa","sa"); Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); String sql="select * from message"; ResultSet rs=stmt.executeQuery(sql); rs.last(); recordcount=rs.getRow();//取得总记录数 pagecount=(recordcount%pagesize==0?(recordcount/pagesize):(recordcount/pagesize)+1);//取得总页数 int count=1; String strpage=request.getParameter("pageid"); if(strpage==null) pageid=1; else pageid=Integer.parseInt(strpage); if(pageid>recordcount) pageid=recordcount; if(recordcount>0){ rs.absolute((pageid-1)*pagesize+1);} int i=0; //rs.previous(); rs.beforeFirst(); while(rs.next()&&count<=pagesize){ count++; i++; out.print(rs.getString("name")); out.print("||"); out.print(rs.getString("title")); out.print("<br/>"); } out.print("共"); out.print(pagecount); out.print("页"); out.print("共"); out.print(recordcount); out.print("条"); out.print("第"); out.print(pageid); out.print("页"); out.print("<br/>"); if(pageid<pagecount){ out.print("<a href=del.jsp?pageid="); out.print(pageid+1); out.print(">下一页</a>");} if(pageid>1){ out.print("<a href=del.jsp?pageid="); out.print(pageid-1); out.print(">上一页</a>");} out.print("<br/>"); for(int j=1;j<=pagecount;j++){ out.print("<a href=del.jsp?pageid="); out.print(j); out.print(">"); out.print(j); out.print("</a>");} stmt.close(); conn.close(); } catch(ClassNotFoundException e){ out.println(e.getMessage()); } catch(SQLException e) { out.println(e.getMessage()); } finally{ try{ if(conn != null) conn.close(); } catch(Exception e){} } %>

		发表于：2008-05-06 12:52:484楼 得分:0
		晕了  mysql 用 limit 呀

		select ****  limit begin,size

		begin 表示 从 哪行开始
		size 表示 返回行数 就是 每页显示多少记录

		begin ＝ (page-1)*size
		Java code

		int PageSize=10,i=0,RowCount=0,PageCount; int GetPage=Chk.IsPage(request.getParameter("page")); ResultSet RSs=Conn.executeQuery("Select Count(SID) As s From comments where SID ="+ID); if(RSs.next()){ RowCount=RSs.getInt("s"); } PageCount = (RowCount+PageSize-1) / PageSize; if(GetPage>PageCount) GetPage = PageCount; int p=(GetPage-1)*PageSize; String sqlComment="Select * From comments where SID = "+ID+" Order By ID ASC limit "+p+","+PageSize+"";
		发表于：2008-05-06 13:01:338楼 得分:40
		<script language="JavaScript" type="text/JavaScript">
			<!--
			function MM_openBrWindow(theURL,winName,features) { //v2.0
				window.open(theURL,winName,features);
			}
//-->
</script>
<script>
	function openbag(id) { window.open("basket.jsp?id="+id,"","height=420,width=460,left=190,top=10,resizable=yes,scrollbars=yes,status=no,toolbar=no,menubar=no,location=no");}
</script>
<table  border=0 align="center" cellpadding=0 cellspacing=1>
	<tr bgcolor="#E6E6E6">
		<th width="251">图书名称 </th>
		<th width="111">出版社 </th>
		<th width="112">定价 </th>
		<th colspan="2">日期 </th>
	</tr>
	<%
	//public bs=rs.getString("leiID");
	int intPageSize; //一页显示的记录数
	int intRowCount; //记录总数
	int intPageCount; //总页数
	int intPage; //待显示页码
	String  strPage,lei;
	int i;
	//设置一页显示的记录数
	intPageSize =15;
	//取得待显示页码
	strPage = request.getParameter("page");
	lei = request.getParameter("lei"); //图书类别
	if(lei==null){
	lei="1";
	}

	if(strPage==null){//表明在QueryString中没有page这一个参数，此时显示第一页数据
	intPage = 1;
	} else{//将字符串转换成整型
	intPage = java.lang.Integer.parseInt(strPage);
	}

	sql="select * from tushumingxi where lieID="+java.lang.Integer.parseInt(lei);
	Statement selstmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	rs=selstmt.executeQuery(sql);


	if(intPage < 1){
	intPage = 1;
	}
	//获取记录总数
	rs.last();
	intRowCount = rs.getRow();
	//记算总页数
	intPageCount = (intRowCount+intPageSize-1) / intPageSize;
	//调整待显示的页码
	if(intPage >intPageCount) intPage = intPageCount;
	if(intPageCount >0){
	//将记录指针定位到待显示页的第一条记录上
	rs.absolute((intPage-1) * intPageSize+1);
	//显示数据
	}
	i = 0;
	while(i < intPageSize && !rs.isAfterLast()){
	int bkid=rs.getInt("shuID");
	%>

	<tr valign="middle" bgcolor="#f8f8f8" height="25">
		<td width="251" bgcolor="#f8f8f8" > <a href=# onClick="MM_openBrWindow('browbook.jsp?id= <%=bkid%>','','width=400,height=550')"> <%=rs.getString("shu_name")%> </a> </td>
		<td> <%=rs.getString("banshe")%> </td>
		<td> <div align="center">￥ <%=rs.getString("dingjia")%>元 </div> </td>
		<td width="114"> <%=rs.getString("date")%> </td>
		<td width="34" align="center"> <a href="javascript:MM_openBrWindow('basket.jsp?id= <%=bkid%>','','scrollbars=yes,width=480,height=350')"> <img src="image/04dd_car.gif" width="19" height="16" border="0"> </a> </td>
	</tr>
	<tr>
		<td height=1 colspan="5" background="image/dian.gif"> <img src="images/blank.gif" width=1 height=1> </td>
	</tr>
	<%rs.next();
	i++;
	} rs.close();
	selstmt.close();
	conn.close();%>
</table>
<p align="center">
共 <%=intRowCount%>个记录,分 <%=intPageCount%>页显示,您所在本页是:第 <%=intPageCount%>页
<%for(int j=1;j <=intPageCount;j++)
{out.print("&nbsp;&nbsp; <a href='language.jsp?lei="+lei+"&page="+j+"'>"+j+" </a>");
}%>
