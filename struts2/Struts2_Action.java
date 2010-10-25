1.打包动作
1.1 Action的作用
封装工作单元 execute(){...}
数据携带者	set**()方法
决定对应的试图转向 <result name="SUCCESS">**.jsp</result>
1.2 Action中的包
分配的原则:功能的共通性
<package name="包名" namespace="命名空间" extends="struts-default" abstract="">
<action name="" class="">
<result name="">/**.jsp</result>
</action>
</package>

2. 实现动作
2.1 struts-default中的组件
<!--拦截器的名称和实现类-->
<interceptor name="workflow" class="com.opensymphony.xwork2.interceptor.DefaultWorkflowInterceptor"/>
...
<!--定义默认的拦截器栈-->
<interceptor-stack name="defaultStack">
...
<!--param拦截器将请求数据转移到Action对象上-->
<interceptor-ref name="params"/>
...
<!--workflow拦截器来验证这些数据-->
<interceptor-ref name="workflow">
<param name="excludeMethods">input,back,cancel,browse</param>
</interceptor-ref>
</interceptor-stack>

一个Action例子
public class Register extends ActionSupport
{
private String username;
/**
 * get the value of username
 * @return the value of username
		 */
public String getUsername(){
	return this.username;
}
/**
 * set a new value to username
 * @param username the new value to be used
 */
public void setUsername(String username) {
	this.username=username;
}
private String password;
/**
 * get the value of password
 * @return the value of password
 */
public String getPassword(){
	return this.password;
}
/**
 * set a new value to password
 * @param password the new value to be used
 */
public void setPassword(String password) {
	this.password=password;
}
private String portfolinName;
/**
 * get the value of portfolinName
 * @return the value of portfolinName
 */
public String getPortfolinName(){
	return this.portfolinName;
}
/**
 * set a new value to portfolinName
 * @param portfolinName the new value to be used
 */
public void setPortfolinName(String portfolinName) {
	this.portfolinName=portfolinName;
}
<!--业务逻辑-->
public String execute()
{
	User user = new User();
	user.setPassword(getPassword());
	user.setUsername(getUsername());
	user.setPortfolinName(getPortfolinName());

	getPortfoliService().createAccount(user);

	return SUCCESS;
}

public PortfoliService getPortfoliService()
{
	return new PortfoliService();
}
<!--验证逻辑-->
public void validate()
{
	PortfoliService ps = getPortfoliService();
	if(getPassword().length()==0)
	{
		addFieldError("password","password is required!");
	}
	if(getUsername().length()==0)
	{
		addFieldError("username","username is required!");
	}
	if(getPortfolinName().length()==0)
	{
		addFieldError("portfolinName","portfolinName is required!");
	}
	if(ps.userExists(getUsername()))
	{
		addFieldError("username","The user already exists!")
	}
}
		  }
/*
   动作扩展了ActionSupport
   提供了execute()方法:来实现业务逻辑
   javaBean属性:接受框架自动传输的数据
   validate():包含验证javaBean属性接收到的数据的合法性逻辑
 */
错误信息的存储和获取?
继承ActionSupport也就实现了com.opensymphony.xwork2.ValidationAware接口来存储和获取错误信息
ActionSupport实现了对错误信息的处理方法addFieldError("",""),addActionError()
2.2 使用资源包处理文本信息
ActionSupport实现了com.opensymphony.xwork2.TextProvider接口来实现从资源包中消息的访问
包下建立properties文件,使用getText()方法使用关键字调用属性文件中配置好的信息
ActionSupport实现了com.opensymphony.xwork2.LocaleProvider接口来根据用户本地设置的地域来取得信息
getLocale()获取本地地域配置
3. 介绍对象属性和ModelDriven动作
3.1 对象支持的javaBean
	将框架转移来的数据直接装配到JavaBean的属性上
public String execute()
{
	getPortfolioService().createAccount(user);
	return SUCCESS;
}
private User user;
/**
 * get the value of user
 * @return the value of user
 */
public User getUser(){
	return this.user;
}
/**
 * set a new value to user
 * @param user the new value to be used
 */
public void setUser(User user) {
	this.user=user;
}

public void validate()
{
	...
		if(getUser().getPassword().length==0)
		{
			addFieldError("user.password",getText("password.required"));
		}
	...
}
在jsp页面显示时 
<s:textfild name="user.username" lable="Username"/>
<s:property value="user.username">username属性名</s:property>
3.2 ModelDriven
private User user = new User();
public Object getModel()
{
	return user;
}
//在验证时
public void validate()
{
	...
		if(user.getPassword().length==0)
		{
			addFieldError("user","password.required");
		}
	...
}
在jsp页面显示:
<s:textfild name="username" lable="Username"/>
<s:property value="username">username属性名</s:property>
4. 上传文件
4.1 通过扩展struts-default包获取内建的支持
<package name="struts-default">
<interceptors>
...
<interceptor name="fileUpload" class="org.apache.struts2.interceptor.FileUploadInterceptor"/>
...
</interceptors>
<interceptor-stack name="defaultStack">
<interceptor-ref name="model-driven"/>
<interceptor-ref name="fileUpload"/>
<interceptor-ref name="param"/>
...
</interceptor-stack>
</package>
4.2 fileUpload拦截器
处理一个multipart request,并将文件和其他元数据一起转化到请求参数中.
4.3 预处理(preprocessing)拦截器和后处理(postprocessing)拦截器
preprocessing:multipart request请求到request的转换
postprocessing:Action执行完之后的转换
4.4 例子
4.4.1 上传页面 imageUpload.jsp
<!--必须设置action的entype属性值为"multipart/from-data"来通知框架为上传处理action-->
<s:action name="ImageUpload" method="post" entype="multipart/from-data">
<s:file name="pic" lable="Picture"/>
<s:submit lable="upLoad"/>
</s:action>
4.4.2 action设置
<package name="test" namespace="" entends="struts-default">
<action name="AddImage">
<result>/imageUpload.jsp</result>
</action>
<action name="ImageUpload" class="ImageUpload">
<result>/sucessful.jsp</result>
<result name="input">/imageUpload.jsp</result>
</action>
</package>
4.4.3 javaBean属性
File pic;
/**
 * get the value of pic
 * @return the value of pic
 */
public File getPic(){
	return this.pic;
}
/**
 * set a new value to pic
 * @param pic the new value to be used
 */
public void setPic(File pic) {
	this.pic=pic;
}
String picContentType;
/**
 * get the value of picContentType
 * @return the value of picContentType
 */
public String getPicContentType(){
	return this.picContentType;
}
/**
 * set a new value to picContentType
 * @param picContentType the new value to be used
 */
public void setPicContentType(String picContentType) {
	this.picContentType=picContentType;
}
String picFileName;
/**
 * get the value of picFileName
 * @return the value of picFileName
 */
public String getPicFileName(){
	return this.picFileName;
}
/**
 * set a new value to picFileName
 * @param picFileName the new value to be used
 */
public void setPicFileName(String picFileName) {
	this.picFileName=picFileName;
}
<!--javaBean的属性可以不实现-->
	业务逻辑
public String execute()
{
	getPortfolioService().addImage(getPic());
	return SUCCESS;
}
