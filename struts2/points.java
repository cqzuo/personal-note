1. 需要的Jar包?
 7个
  common-logging
  freemarker
  ognl
  struts2-api
  struts2-core
  struts2-extras
  xwork
  
 2. 建立struts2项目的流程
  建立空白项目
  添加jar包
  添加并配置web.xml
  添加并配置struts.xml
  添加action
  添加jsp
  
 3. 几个配置文件的位置
  web.xml
    WEB-INF/
  struts.xml
    src/package-name/
 
 4. action与配置
    jsp中
      直接设置action=""
    struts.xml
      package 
        name extends
      action
 5. struts标签
 6. 几个接口所在包名
  ActionSupport  
    com.opensymphony.xwork2.ActionSupport
 7. 相对路径问题
 8. execute()调用action中的数据域
  getXXXX()
 9. 将信息存储在session中
  ActoinContext.getContext().getSession().put("keyname",getXXXX());
 10. 将存储在session中的信息在jsp页面中显示
  <%=session.getAttribute("keyname")%>