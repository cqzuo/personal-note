1、forward 和redirect的区别
答：forward是服务器请求资源，服务器直接访问目标地址的URL，把那个URL的响应内容读取过来，然后把这些内容再发给浏览器，浏览器根本

不知道服务器发送的内容是从哪儿来的，所以它的地址栏中还是原来的地址。
redirect就是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址，一般来说浏览器会用刚才请求的所有参数重新请求，所

以session,request参数都可以获取。
2、jsp有哪些内置对象?作用分别是什么?
答：JSP共有以下9种基本内置组件（可与ASP的6种内部组件相对应）： 
　request 用户端请求，此请求会包含来自GET/POST请求的参数 
response 网页传回用户端的回应 
pageContext 网页的属性是在这里管理 
session 与请求有关的会话期 
application servlet 正在执行的内容 
out 用来传送回应的输出
config servlet的构架部件 
page JSP网页本身 
exception 针对错误网页，未捕捉的例外 
3、jsp有哪些动作?作用分别是什么?
答:JSP共有以下6种基本动作
jsp:include：在页面被请求的时候引入一个文件。 
jsp:useBean：寻找或者实例化一个JavaBean。 
jsp:setProperty：设置JavaBean的属性。 
jsp:getProperty：输出某个JavaBean的属性。 
jsp:forward：把请求转到一个新的页面。 
jsp:plugin：根据浏览器类型为Java插件生成OBJECT或EMBED标记
4、JSP中动态INCLUDE与静态INCLUDE的区别？ 
答：动态INCLUDE用jsp:include动作实现
<jsp:include page="included.jsp" flush="true" />它总是会检查所含文件中的变化，适合用于包含动态页面，并且可以带参数
静态INCLUDE用include伪码实现,定不会检查所含文件的变化，适用于包含静态页面
<%@ include file="included.htm" %>
5、两种跳转方式分别是什么?有什么区别?
答：有两种，分别为：
<jsp:include page="included.jsp" flush="true">
<jsp:forward page= "nextpage.jsp"/>
前者页面不会转向include所指的页面，只是显示该页的结果，主页面还是原来的页面。执行完后还会回来，相当于函数调用。并且可以带参数

.后者完全转向新页面，不会再回来。相当于go to 语句。
6、JSP的内置对象及方法。
答：request表示HttpServletRequest对象。它包含了有关浏览器请求的信息，并且提供了几个用于获取cookie, header, 和session数据的有
用的方法。 
response表示HttpServletResponse对象，并提供了几个用于设置送回 浏览器的响应的方法（如cookies,头信息等） 
out对象是javax.jsp.JspWriter的一个实例，并提供了几个方法使你能用于向浏览器回送输出结果。 
pageContext表示一个javax.servlet.jsp.PageContext对象。它是用于方便存取各种范围的名字空间、servlet相关的对象的API，并且包

装了通用的servlet相关功能的方法。 
session表示一个请求的javax.servlet.http.HttpSession对象。Session可以存贮用户的状态信息 
applicaton 表示一个javax.servle.ServletContext对象。这有助于查找有关servlet引擎和servlet环境的信息 
config表示一个javax.servlet.ServletConfig对象。该对象用于存取servlet实例的初始化参数。 
page表示从该页面产生的一个servlet实例