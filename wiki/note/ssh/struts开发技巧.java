Struts�������� 
���α༭��admin �� �������ڣ�2005-8-6 
 
Struts��������

�ھ����ˡ��й����Ŵ�ͻ����ķ�����Ŀ�Ŀ����Լ�Ŀǰ���ڽ��п����еġ��й������ܲ���Ӫ��������Ŀ���ۼ���һЩ����Struts1.1��Tiles������һЩ�����ͼ��ɣ���д�����������Ժ�Ŀ�����ͬʱҲ�����ܸ������ڿ���Struts�ṩһЩ���� 
ģ������ 
1. Struts�����ļ����� 
����ϵͳ�е�ĳ��ģ�飬��Ҫ�ڿ���ǰ�����ģ������ã���struts�������ļ�����Ϊ�� 
struts-config-xxx.xml 
xxxΪģ���СдӢ��������д���磺struts-config-sysman.xml 
ע�⣺�м�Ϊ��-���������ǡ�_�����ӷ� 
ͳһ�����ڡ�WEB-INF\xml���ļ����£�����Ҫ��web.xml�������Ӧ�������ļ� 
��ַ�������������� 
�� 
<init-param> 
<param-name>config</param-name> 
<param-value>/WEB-INF/struts-config.xml, /WEB-INF/xml/struts-config-pages.xml,/WEB-INF/xml/struts-config-sysman.xml</param-value> 
</init-param> 
�� 
ע�⣺��Ҫ�á��������ӷ��������������ļ��� 
���⣬���еľ�̬jsp��Ҫͨ�������ļ������䡰.do����ʽ�ķ��ʣ������� 
struts-config-pages.xml�ļ��У������������� 
�� 
<!--��ҳת��--> 
<action path="/main" type="org.apache.struts.actions.ForwardAction" parameter="/main.jsp"/> 
�� 
2. Tiles�����ļ����� 
ϵͳ�Ŀ�������ļ�Ϊtiles-defs_zh_CN.xml��ͨ��.properties�����ļ�֧�ֹ��ʻ�Ӧ�ã�Ĭ����tiles-defs.xml����ģ��Ŀ�ܽṹ��Ҫ���������棬�������� 
�� 
<!-- ����Ĭ����ҳ --> 
<definition name="default.frame" path="/layouts/defaultLayout.jsp"> 
<put name="title" value="��ӭ������ž�Ӫ����ϵͳ" /> 
<put name="header" value="/top.jsp" /> 
<put name="body" value="default.body" /> 
<put name="footer" value="/buttom.jsp" /> 
</definition> 
<!-- ����Ĭ����ҳ��body --> 
<definition name="default.body" path="/layouts/main.jsp" > 
<put name="logon" value="/logon.jsp" /> 
<put name="date" value="/layouts/date.jsp" /> 
<put name="linkSite" value="/layouts/link.html" /> 
</definition> 
�� 
��������淶����ϵͳ����ϵͳ��.����ģ��.ҳ��ģ�顱��������ġ�default.frame�� 
��struts-config-pages.xml�ļ��е����õ�ҳ��action��������д�� 
<action path="/main" type="org.apache.struts.actions.ForwardAction" parameter=" default.frame "/> 
�����Ͳ��ص���дһ��tiles:insert��ҳ�棬���£� 
<tiles:insert definition="vip.warn.day" flush="true" /> 
3. ģ���е�ע�� 
������Ҫ�ڳ�������ӱ�Ҫ��ע�ͣ��ڶ��������ļ���ʱ��Ҳ������Ҫ�����Ӧע�ͣ���Ҫ����struts-config-xxx.xml��tiles-defs_zh_CN.xml��Щ�ļ������ע�ͣ�Ҫ��action������ģ��Ĺ��ܽ�������������������ǰ�棬�μ�����������ļ� 
4. ���������ļ��ı༭ 
����ʹ��Jbuilder�����xml�༭���ܣ���ΪJB���Զ��ظı�xml����ı�������ݣ���ˣ���xml�����ļ��ı༭��Ҫʹ�ñ༭�������UE�� 
�¼����� 
�¼���Ӧ������Ҫ��Action��ActionForm������jsp���ύ�ġ�.do�����壬�Լ�ҳ�涯�����ύ����login��¼Ϊ���� 
1�� ����������壨����ĸ���д�� 
��ʽΪ��������+Action/Form�� 
�磺LoginAction.class��LoginForm.class 
2�� ҳ���ַ���壨����ĸ��Сд�� 
����������������ϣ��ڶ�����������ĸ��д���������� 
��ʽΪ���������� 
�磺login.do��loginSys.do 
jsp�ļ�����Ҳ���˹淶 
3�� ҳ�涯������ 
��Ϊjspҳ���е�Form��ӦActionForm���䱾����action������ԣ�����ҳ�涯���������ҲΪaction�������𲻱�Ҫ���鷳�����ԣ���ҳ�涯��ͳһ����Ϊ��act���� 
����Ҫ�༭ĳ����¼����ַ���£� 
��/editRecord.do?act= Edit�� 
����Ҫɾ������ַ���£� 
��/editRecord.do?act=Delete�� 
4�� ���ڲ˵��Ͳ����¼������Ŀ��ƻ��� 
����ϵͳ�еĲ˵��Ͳ��������ɡ�.do����ʽ�����˷�����ģ������Ҫһ�׻�����������Щ�ǶԲ˵����¼�������Щ�ǶԲ������¼����� 
������ϵͳ��������Filter��������������������п��ƣ��Լ��ж��û��Ƿ��¼���Ƿ��ж���Դ���˵��ȣ�����Ȩ�޵ȣ� 
Լ���� 
jspҳ���϶���ϵͳ�в˵��������ǡ�GET�����������ڲ�����Action���ǡ�POST�������� 
����������Լ������Filter�����ж�request�����󷽷�������ǡ�GET������������Ϊ�ǶԲ˵�����������ȥ���˵������������ַ��ȡ��Ӧ�ļ�¼������ȡ�û���Ȩ�ޱ��ж��û��Ĳ˵�Ȩ�ޣ� 
����ǡ�POST���ķ���������Ϊ�ǶԲ��������󣬲���ȡrequest�еġ�act�����������ж��û���Ȩ�޵���ж��� 

������Ϣ��ȡ 
1. ����������Ϣͨ��Plugin��ʽ��Web��������ʱ����������application�У�ʹ�����κ���Ҫ�ñ�����jsp�ж����Ե��ã� 
��ʽ���£� 
public void setServletContext(ActionServlet actionServlet) { 
try { 
ServletContext sc = actionServlet.getServletContext(); 
//SysInitPwd 
sc.setAttribute(Constants.SYS_INIT_PWD,SelectLists.getSysConfig("PWDINIT")); 
�� 
��action�ȳ����еĵ��÷�ʽ�� 
getServlet().getServletContext().getAttribute(������); 

2. ����ҳ������Ҫչʾ�����ݾ��������request�����Χ����Լ�����������ڴ渺�أ���ʽ���£� 
//����Ա�������� 
StaffDeal sd=new StaffDeal(); 
//����Ա��״̬��ѯԱ�� 
ArrayList al=sd.qryStaff(strState); 
//����request 
request.setAttribute("staffInfo",al); 
3. ˽�еĻ���Ҫ�����û�����������ȡ������Ϣ�ģ�������tiles�Ķ�����ʹ�á�controlClass=xxx�������ʽ��ȡ�������������� 
<definition name="vip.welcome" path="/vip/welcome.jsp" controllerClass="viptx.logic.vip.welcomeAction" /> 
��implements Controller�е�perform������������������ 
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
String sql = "select userid,content from ti_salutatory where userid=��"+uid+"��"; 
try { 
�� 
} 
catch (Exception ex) { 
throw new ServletException(ex.getMessage()); 
} 
} 
4. ���ں�̨������Ϣ��ǰ̨ҳ����ʾ�ļ��� 
������properties���á�message.common={0}�� 
Ȼ����Action����ʹ��ActionErrors��ActionMessagesʱ���������£� 
�� 
ActionMessages ams = new ActionMessages(); //���⴦�� 
Try{ 
�� 
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
�� 
��jspҳ����ʹ�÷������£� 
<html:messages id="msg" message="true"> 
<font color="red"><bean:write name="msg"/></font> 
</html:messages> 
����к�̨��messages������ǰ̨ҳ��Ϳ��Գ��ֱ�����Ϣ 
5. ϵͳ�����ļ� 
ϵͳ���������ݿ����ӵ���sysConfi.xml�ļ������ã�����ڡ�WEB-INF/xml���ļ����£���μ����ļ��� 
�����淶�͹��÷��� 
����java�Ŀ����淶�μ���Java ��̹淶.doc���������������struts������һЩ�Ĺ淶�� 
1. java�ļ���Ű�ҵ���߼����֣�����ģ����Ϊ��������ʽ���磺telecombi.logic.sysman.security 
������ΪСд��ʽ 
���е�Action��ActionForm�������ͬһ���£����ڹ�����Ҫ������� 
2. ����ActionForm�е����Ծ�Ϊ���׵���Сд+�ڶ�����������ĸ��д+��������ʽ���磺staffId��staffName��������ʹ�á�_��Ϊ�������ӷ� 
3. ��Ҫ��֤��ҳ�棬����Ҫ�ͻ��˺ͷ����������֤������jsp�е�Form����javascript��֤��Action�е�excute�����н�����֤��������ֻ��������һ�ַ�������ֹ�ͻ��ƹ�jsֱ���ύ�� 
����֤��¼�ύ��formʱ������ʹ��staticJavascript="false"������ͻ��javascriptд��ҳ����磺 
<html:javascript formName="logonForm" 
dynamicJavascript="true" 
staticJavascript="false"/> 
<script language="Javascript1.1" src="staticJavascript.jsp"></script> 
��֤��formName�����validation.xml�е�Form�����ֶ�Ӧ������������֤��Ч 
4. ActionForm�Ǵ���html�е�Form�ģ����еı�����Ҫ��Form�е����Զ�Ӧ�������磺Ҫ��jsp��ʹ��<form:text property="userName"/>����ʹ�õ�ActionForm�оͱ�����userName������� 
5. ����Action�е��߼��������������һ�����ϣ���Ҫ�����½�һ�������࣬�����Action�е��߼����д�������ΪxxxDeal���磺LoginDeal; 
Actionͨ�����øô�����ķ�����ʵ��ҵ���߼����� 
6. �����ݿ�Ĳ���ʹ��DBManager����࣬�����е�һЩ����������������£� 
? ��ѯ������󻯵�Select������ʹ��Select(String sql,String className)���� 
StringBuffer sql = new StringBuffer( 
"select staff_id staffId from ts_m_staff ") 
.append("where staff_id=��").append(uid).append("��"); 
try { 
/** 
* User��һ���û������࣬������staffId������ԣ��Լ���Ӧ��get/set������ͨ�� 
* DBManager��Select�������һ��User��ArrayList���� 
*/ 
ArrayList rs = DBManager.Select(sql.toString(), User.class.getName()); 
/** 
* ���ȷ�����ص�ֻ��һ�����������ʹ�� 
* 
*/ 
User user=(User)rs.get(0); 
} 
catch (Exception ex) { 
throw new ServletException(ex.getMessage()); 
} 
ȡ���������ݿ��Դ����session��page�����jspҳ����ã�����Ϊsession.setAttribute(��user��,user1) 
�� 
? Insert��Update�Ȳ��� 
ʹ��DBManager�����executeSql(String sql)�������������������ʹ��executeBatchSql(String[] sqls)���������سɹ���־ΪConstants.OPERATE_SUCCESS 
ʧ�ܱ�־ΪConstants.OPERATE_FAILED 
����������Ϣ���� 
? ResultSet������Hashtable���϶����ת����ʹ��select(String sql)������ 
���˿���ʹ��DBManager��Select�Ѳ�ѯ���תΪ�������⣬������ʹ����ǰ��ֱ��ʹ��ResultSet����ķ�ʽ���������ﷵ�ص����ݼ�����ΪHashtable�� 
Hashtable��ŵ����ݽṹΪ�� 
columnName1 ? ArrayList1(���ֶεĽ����) 
columnName2 ? ArrayList2(���ֶεĽ����) 
�� 
ϵͳ��ʹ�ø÷����ıȽ϶���������������������ݣ���select�������ص�Hashtableȡ���ֶ�ֵ��������LabelValueBean�����巽�����£� 
/**���ú��� Hashtable ת���� ArrayList (LabelValueBean)*/ 
private static ArrayList hashToLVB(Hashtable ht, String id, String name,boolean hasBlank) { 
if (ht!=null){ 
ArrayList al = new ArrayList(); 
ArrayList alId = (ArrayList) ht.get(id.toUpperCase()); 
ArrayList alName = (ArrayList) ht.get(name.toUpperCase()); 
int iLen = alId.size(); 
if (hasBlank) 
al.add(new LabelValueBean("δ֪", "-1")); 
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
? AutoSetForm��String sql, Object frm���������ܣ� 
a) �÷������Է���һ����ѯ 
���ݿ���Ѷ����е����Ը�ֵ�Ķ���ʹ�÷������£� 
User user=DBManager. AutoSetForm(sql,new User()); 
sqlΪ��ѯ��� 
b) �÷��������Զ�ҳ��������Form���и�ֵ��������ҳ�����ύһ����ĳ����¼���б༭�Ĳ�������Action�õ�������¼��Id�Ų���ѯ���ݿ�ɹ�����Ҫ�Ѹ�����ϸ��Ϣset��ActionForm�����Ա�����ȥ�����ʱ��Ϳ���ʹ�ø÷������������£� 
form= DBManager. AutoSetForm(sql,form); 
formΪAction��excute�����д����ActionForm 

7. ���ô洢���� 
ʹ��DBManager�е�execProc(String procName,ArrayList procPrts)���� 
procNameΪ�洢��������procPrts�Ǹô洢���̵���ڲ����������ص���ProcOuts�Ķ���������Result��ExceptionInfo�������ԣ���ʾ���صĴ����Ǻ��쳣��Ϣ������еĻ��� 
8. ���ݲ���������Ϣ�Ĵ��� 
�ڶ����ݲ�����ɺ���Ҫ���ز����Ƿ�ɹ�����Ϣ�����岽�����£� 
? ʹ�������ļ��еġ�messages.comm�����key�����ԶԸ�key��Ӿ��巵����Ϣ 
? ������ʹ�á�ActionMessages���������java�������£� 
ActionMessages ams = new ActionMessages(); 
�� 
//ִ�н�� 
ProcOuts pResult=null; 
//�Ƿ���óɹ� 
if (pResult.getResult() == -1) { 
ams.add(ActionMessages.GLOBAL_MESSAGE, 
new ActionMessage("message.common", 
pResult.getExceptionInfo())); 
} 
if (!ams.isEmpty()) { 
saveMessages(request, ams); 
} 
Jsp�е��÷������£� 
<html:messages id="msg" message="true"> 
<font color="red"><bean:write name="msg"/></font> 
</html:messages> 
  
