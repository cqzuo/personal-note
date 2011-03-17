Struts开发技巧 
责任编辑：admin 　 更新日期：2005-8-6 
 
Struts开发技巧

在经历了《中国电信大客户贴心服务》项目的开发以及目前正在进行开发中的《中国电信总部经营分析》项目，累计了一些对于Struts1.1和Tiles开发的一些技术和技巧，特写出来，方便以后的开发，同时也相信能给读者在开发Struts提供一些帮助 
模块配置 
1. Struts配置文件定义 
对于系统中的某个模块，需要在开发前定义该模块的配置，该struts的配置文件命名为： 
struts-config-xxx.xml 
xxx为模块的小写英文名或缩写，如：struts-config-sysman.xml 
注意：中间为“-”，而不是“_”连接符 
统一保存在“WEB-INF\xml”文件夹下，并需要在web.xml中添加相应的配置文件 
地址，具体如下例： 
… 
<init-param> 
<param-name>config</param-name> 
<param-value>/WEB-INF/struts-config.xml, /WEB-INF/xml/struts-config-pages.xml,/WEB-INF/xml/struts-config-sysman.xml</param-value> 
</init-param> 
… 
注意：需要用“，”连接符隔开各个配置文件名 
另外，所有的静态jsp需要通过配置文件定义其“.do”形式的访问，保存在 
struts-config-pages.xml文件中，内容如下例： 
… 
<!--主页转向--> 
<action path="/main" type="org.apache.struts.actions.ForwardAction" parameter="/main.jsp"/> 
… 
2. Tiles配置文件定义 
系统的框架配置文件为tiles-defs_zh_CN.xml（通过.properties属性文件支持国际化应用，默认是tiles-defs.xml），模块的框架结构需要定义在里面，如下例： 
… 
<!-- 定义默认首页 --> 
<definition name="default.frame" path="/layouts/defaultLayout.jsp"> 
<put name="title" value="欢迎进入电信经营分析系统" /> 
<put name="header" value="/top.jsp" /> 
<put name="body" value="default.body" /> 
<put name="footer" value="/buttom.jsp" /> 
</definition> 
<!-- 定义默认首页的body --> 
<definition name="default.body" path="/layouts/main.jsp" > 
<put name="logon" value="/logon.jsp" /> 
<put name="date" value="/layouts/date.jsp" /> 
<put name="linkSite" value="/layouts/link.html" /> 
</definition> 
… 
框架命名规范按“系统（子系统）.功能模块.页面模块”，如上面的“default.frame” 
在struts-config-pages.xml文件中的设置的页面action可以这样写： 
<action path="/main" type="org.apache.struts.actions.ForwardAction" parameter=" default.frame "/> 
这样就不必单独写一个tiles:insert的页面，如下： 
<tiles:insert definition="vip.warn.day" flush="true" /> 
3. 模块中的注释 
不但需要在程序中添加必要的注释，在定义配置文件的时候也必须需要添加相应注释，主要是在struts-config-xxx.xml和tiles-defs_zh_CN.xml这些文件中添加注释，要把action或配置模块的功能解释清楚，放在配置项的前面，参见上面的配置文件 
4. 对于配置文件的编辑 
不能使用Jbuilder里面的xml编辑功能，因为JB会自动地改变xml里面的编码和内容，因此，对xml配置文件的编辑，要使用编辑软件，如UE等 
事件定义 
事件对应的类主要有Action、ActionForm，还有jsp中提交的“.do”定义，以及页面动作的提交，以login登录为例： 
1． 类的命名定义（首字母需大写） 
形式为“动作名+Action/Form” 
如：LoginAction.class、LoginForm.class 
2． 页面地址定义（首字母需小写） 
如果有两个单词以上，第二个单词首字母大写，依此类推 
形式为“动作名” 
如：login.do或loginSys.do 
jsp文件命名也按此规范 
3． 页面动作定义 
因为jsp页面中的Form对应ActionForm，其本身有action这个属性，所以页面动作如果定义也为action，会引起不必要的麻烦，所以，把页面动作统一定义为“act”， 
如需要编辑某条记录，地址如下： 
“/editRecord.do?act= Edit” 
如需要删除，地址如下： 
“/editRecord.do?act=Delete” 
4． 对于菜单和操作事件触发的控制机制 
由于系统中的菜单和操作都是由“.do”形式向服务端发请求的，因此需要一套机制来控制哪些是对菜单的事件请求，哪些是对操作的事件请求； 
我们在系统中引入了Filter过滤器，对所有请求进行控制，以及判断用户是否登录和是否有对资源（菜单等）访问权限等； 
约定： 
jsp页面上对于系统中菜单的请求都是“GET”方法，对于操作的Action都是“POST”方法； 
有了这样的约定，在Filter中先判断request的请求方法，如果是“GET”方法，则认为是对菜单的请求，所以去“菜单表”根据请求地址读取相应的记录，并读取用户的权限表，判断用户的菜单权限； 
如果是“POST”的方法，则认为是对操作的请求，并提取request中的“act”动作，进行对用户的权限点的判定。 

参数信息获取 
1. 公共参数信息通过Plugin方式在Web服务启动时将变量放入application中，使得在任何需要该变量的jsp中都可以调用； 
方式如下： 
public void setServletContext(ActionServlet actionServlet) { 
try { 
ServletContext sc = actionServlet.getServletContext(); 
//SysInitPwd 
sc.setAttribute(Constants.SYS_INIT_PWD,SelectLists.getSysConfig("PWDINIT")); 
… 
在action等程序中的调用方式： 
getServlet().getServletContext().getAttribute(“…”); 

2. 对于页面上需要展示的数据尽量存放在request这个范围里，可以减轻服务器端内存负载，方式如下： 
//调用员工处理类 
StaffDeal sd=new StaffDeal(); 
//根据员工状态查询员工 
ArrayList al=sd.qryStaff(strState); 
//放入request 
request.setAttribute("staffInfo",al); 
3. 私有的或需要根据用户的属性来获取参数信息的，可以在tiles的定义中使用“controlClass=xxx”这个方式获取，配置如下例： 
<definition name="vip.welcome" path="/vip/welcome.jsp" controllerClass="viptx.logic.vip.welcomeAction" /> 
需implements Controller中的perform方法，代码如下例： 
public void perform(ComponentContext componentContext, 
HttpServletRequest request, 
HttpServletResponse response, 
ServletContext servletContext) throws IOException,ServletException { 
HttpSession session = request.getSession(); 
// Get current session. 
User user = (User) session.getAttribute(Constants.USER_KEY); 
if (user == null) { 
return null; 
} 
String uid = user.getUserid(); 
String sql = "select userid,content from ti_salutatory where userid=′"+uid+"′"; 
try { 
… 
} 
catch (Exception ex) { 
throw new ServletException(ex.getMessage()); 
} 
} 
4. 对于后台出错信息在前台页面显示的技巧 
首先在properties配置“message.common={0}” 
然后在Action类中使用ActionErrors或ActionMessages时，方法如下： 
… 
ActionMessages ams = new ActionMessages(); //例外处理 
Try{ 
… 
} 
catch (Exception ex) { 
ex.printStackTrace(); 
ams.add(ActionMessages.GLOBAL_MESSAGE, 
new ActionMessage("message.common", ex.getMessage())); 
} 
finally { 
if (!ams.isEmpty()) { 
saveMessages(request, ams); 
} 
} 
… 
在jsp页面中使用方法如下： 
<html:messages id="msg" message="true"> 
<font color="red"><bean:write name="msg"/></font> 
</html:messages> 
如果有后台的messages产生，前台页面就可以出现报错信息 
5. 系统配置文件 
系统参数如数据库连接等在sysConfi.xml文件中配置，存放在“WEB-INF/xml”文件夹下，请参见该文件。 
开发规范和公用方法 
关于java的开发规范参见《Java 编程规范.doc》，这里仅给出用struts开发中一些的规范： 
1. java文件存放按业务逻辑划分，并用模块作为包名的形式，如：telecombi.logic.sysman.security 
包名都为小写形式 
所有的Action和ActionForm都存放在同一包下，便于管理，不要跨包调用 
2. 所有ActionForm中的属性均为“首单词小写+第二个单词首字母大写+…”的形式，如：staffId、staffName，不允许使用“_”为单词连接符 
3. 需要验证的页面，均需要客户端和服务端两次验证（即对jsp中的Form进行javascript验证和Action中的excute方法中进行验证），不能只采用其中一种方法，防止客户绕过js直接提交； 
在验证登录提交的form时，必须使用staticJavascript="false"，否则就会把javascript写到页面里，如： 
<html:javascript formName="logonForm" 
dynamicJavascript="true" 
staticJavascript="false"/> 
<script language="Javascript1.1" src="staticJavascript.jsp"></script> 
验证的formName必须和validation.xml中的Form的名字对应起来，否则验证无效 
4. ActionForm是代表html中的Form的，其中的变量需要和Form中的属性对应起来，如：要在jsp中使用<form:text property="userName"/>，则使用的ActionForm中就必须有userName这个变量 
5. 对于Action中的逻辑，如果处理方法在一个以上，需要另外新建一个处理类，负责对Action中的逻辑集中处理，命名为xxxDeal，如：LoginDeal; 
Action通过调用该处理类的方法，实现业务逻辑处理 
6. 对数据库的操作使用DBManager这个类，对其中的一些方法，具体介绍如下： 
? 查询结果对象化的Select操作，使用Select(String sql,String className)方法 
StringBuffer sql = new StringBuffer( 
"select staff_id staffId from ts_m_staff ") 
.append("where staff_id=′").append(uid).append("′"); 
try { 
/** 
* User是一个用户对象类，其中有staffId这个属性，以及对应的get/set方法，通过 
* DBManager的Select方法获得一个User的ArrayList集合 
*/ 
ArrayList rs = DBManager.Select(sql.toString(), User.class.getName()); 
/** 
* 如果确定返回的只有一个对象，则可以使用 
* 
*/ 
User user=(User)rs.get(0); 
} 
catch (Exception ex) { 
throw new ServletException(ex.getMessage()); 
} 
取出来的数据可以存放在session或page等里，供jsp页面调用，方法为session.setAttribute(“user”,user1) 
… 
? Insert或Update等操作 
使用DBManager里面的executeSql(String sql)方法，如果是批量处理，使用executeBatchSql(String[] sqls)方法，返回成功标志为Constants.OPERATE_SUCCESS 
失败标志为Constants.OPERATE_FAILED 
暂无其它信息返回 
? ResultSet对象向Hashtable集合对象的转化，使用select(String sql)方法： 
除了可以使用DBManager的Select把查询结果转为对象以外，还可以使用以前的直接使用ResultSet对象的方式，不过这里返回的数据集对象为Hashtable； 
Hashtable存放的数据结构为： 
columnName1 ? ArrayList1(该字段的结果集) 
columnName2 ? ArrayList2(该字段的结果集) 
… 
系统中使用该方法的比较多的是用在生成下拉框数据，从select方法返回的Hashtable取到字段值，并生成LabelValueBean，具体方法如下： 
/**公用函数 Hashtable 转换成 ArrayList (LabelValueBean)*/ 
private static ArrayList hashToLVB(Hashtable ht, String id, String name,boolean hasBlank) { 
if (ht!=null){ 
ArrayList al = new ArrayList(); 
ArrayList alId = (ArrayList) ht.get(id.toUpperCase()); 
ArrayList alName = (ArrayList) ht.get(name.toUpperCase()); 
int iLen = alId.size(); 
if (hasBlank) 
al.add(new LabelValueBean("未知", "-1")); 
for (int i = 0; i < iLen; i++) { 
al.add(new LabelValueBean( (String) alName.get(i), 
(String) alId.get(i))); 
} 
return al; 
} 
else{ 
return null; 
} 
} 
? AutoSetForm（String sql, Object frm）方法介绍： 
a) 该方法可以返回一个查询 
数据库后已对其中的属性赋值的对象，使用方法如下： 
User user=DBManager. AutoSetForm(sql,new User()); 
sql为查询语句 
b) 该方法还可以对页面操作后的Form进行赋值，比如在页面上提交一个对某条记录进行编辑的操作，当Action得到该条记录的Id号并查询数据库成功后，需要把各个详细信息set到ActionForm的属性变量中去，这个时候就可以使用该方法，方法如下： 
form= DBManager. AutoSetForm(sql,form); 
form为Action的excute方法中传入的ActionForm 

7. 调用存储过程 
使用DBManager中的execProc(String procName,ArrayList procPrts)方法 
procName为存储过程名，procPrts是该存储过程的入口参数集，返回的是ProcOuts的对象，其中有Result和ExceptionInfo两个属性，表示返回的处理标记和异常信息（如果有的话） 
8. 数据操作返回信息的处理 
在对数据操作完成后，需要返回操作是否成功等信息，具体步骤如下： 
? 使用属性文件中的“messages.comm”这个key，可以对该key添加具体返回信息 
? 程序中使用“ActionMessages”这个对象，java程序如下： 
ActionMessages ams = new ActionMessages(); 
… 
//执行结果 
ProcOuts pResult=null; 
//是否调用成功 
if (pResult.getResult() == -1) { 
ams.add(ActionMessages.GLOBAL_MESSAGE, 
new ActionMessage("message.common", 
pResult.getExceptionInfo())); 
} 
if (!ams.isEmpty()) { 
saveMessages(request, ams); 
} 
Jsp中调用方法如下： 
<html:messages id="msg" message="true"> 
<font color="red"><bean:write name="msg"/></font> 
</html:messages> 
  
