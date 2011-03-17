Struts2中允许用户自行选择程序语言 
最近在学习struts2，学习资料是李刚著的《struts2权威指南》，这本书写得非常好，非常有学习价值。我在学习过程中，自己跟着做了些例子。下面就是关于在struts2中允许用户自行选择程序语言的原理和示例：

在很多成熟的商业软件中，可以让用户自由切换语言，当用户进入系统时候，可以出现一个下拉列表框，让用户选择语言，一旦用户选择了自己需要使用的语言环境，整个系统的语言环境将一直是这种语言环境。
Struts2也可以允许用户自行选择程序语言。而且，因为Struts2的支持，在程序中自行选择语言环境将变得更加简单。

一. Struts2国际化的运行机制
在Struts 2中，我们可以通过ActionContext.getContext().setLocale(Locale arg)可以设置用户的默认语言。不过，这种方式完全是一种手动方式，而且需要编程实现。
为了简化设置用户默认语言环境，Struts 2提供了一个名i18n的拦截器（Interceptor），并且将其住注册在默认的拦截器栈中（defaultStack）。下面是Struts2的默认拦截器栈的配置片段，代码中粗体字表示的就是i18n的拦截器 
<interceptor-stack name="defaultStack">
 <interceptor-ref name="exception"/>
 <interceptor-ref name="alias"/>
 <interceptor-ref name="servlet-config"/>
 <interceptor-ref name="prepare"/>
 <interceptor-ref name="i18n"/>
 <interceptor-ref name="chain"/>
 <interceptor-ref name="debugging"/>
 <interceptor-ref name="profiling"/>
 <interceptor-ref name="scoped-model-driven"/>
 <interceptor-ref name="model-driven"/>
 <interceptor-ref name="fileUpload"/>
 <interceptor-ref name="checkbox"/>
 <interceptor-ref name="static-params"/>
 <interceptor-ref name="params">
  <param name="excludeParams">dojo\..*</param>
 </interceptor-ref>
 <interceptor-ref name="conversionError"/>
 <interceptor-ref name="validation">
     <param name="excludeMethods">input,back,cancel,browse</param>
 </interceptor-ref>
 <interceptor-ref name="workflow">
     <param name="excludeMethods">input,back,cancel,browse</param>
</interceptor-ref>
</interceptor-stack>
i18n拦截器在执行Action方法前，自动查找请求中的一个名为request_locale的参数。如果该参数存在，拦截器就将其作为参数，并转换成Locale对象，并将其设为用户默认的Locale（代表语言/国家环境）。
除此之外，i18n拦截器还会将上面生成的Locale对象保存在用户Session的名为“WW_TRANS_I18N_LOCALE”的属性中。一旦用户Session中存在一个名为“WW_TRANS_I18N_LOCALE”的属性，则该属性指定的Locale将会作为浏览者的默认Locale。

二. 创建下拉列表框
基于前面的介绍，为了实现让用户自行选择程序语言的功能，只需提供一个下拉列表框，让下拉列表框中列出本应用所支持的各种语言，并且，当用户选择下拉列表框中某一项时，系统将该下拉项的值作为request_locale参数提交给Struts2系统，
为此，我们将系统所支持的语言放入一个Map中，通过在JSP页面中迭代该Map对象，通过这种方式，就可以在页面上列出系统所支持的全部语言，并让用户自由选择。
下面定义了JavaBean，这个JavaBean里保存了当前应用所支持的全部语言，该JavaBean的代码如下：
//该JavaBean存放了系统所支持的全部语言。
public class Locales
{
 //因为本实例也需要实现国际化，所以使用current作为用户当前的Locale
 private Locale current;
 //取得用户当前Locale的setter方法
 public void setCurrent(Locale cur)
 {
  this.current = cur;
 }
 //取得本系统所支持的全部语言
     public Map<String, Locale> getLocales()
 {
  //将当前系统支持的全部语言保持在Map对象中
         Map<String, Locale> locales = new Hashtable<String, Locale>();
  ResourceBundle bundle = ResourceBundle.getBundle("messageResource" , current);
  //添加当前系统支持的语言，key是系统支持语言的显示名字，value是系统支持语言的Locale实例
         locales.put(bundle.getString("usen"), Locale.US);
         locales.put(bundle.getString("zhcn"), Locale.CHINA);
         return locales;
    }
}
在上面JavaBean中，我们使用了一个Map对象来保存所有用户支持的语言，该Map对象的key是所支持语言的显示名字，而该Map对象的value是所支持语言的Locale实例。应用支持语言的显示名字，也是通过国际化消息来生成的。
一旦定义了该JavaBean之后，就可以在JSP页面中创建该JavaBean的实例，并为其传入一个current参数，决定该JavaBean中的Locale参数，就可以根据该Locale参数来决定怎样显示系统所支持语言显示名称。
为了在JSP页面中使用该JavaBean实例，使用下面标签来创建该JavaBean实例。
<!-- 使用lee.Locales创建locales实例 -->
<s:bean id="locales" name="lee.Locales">
 <!-- 为locales实例这种current参数值 -->
 <s:param name="current" 
  value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE"/>
</s:bean>
上面标签创建了lee.Locales类的locales实例，并为该实例传入了current参数值，设置该参数值时使用了三目运算符，先判断SESSION_LOCALE是否为空，如果该SESSION_LOCALE为空，则返回ValueStack中locale属性值（即用户浏览器设置的Locale）；如果SESSION_LOCALE不为空，则返回该SESSION_LOCALE的值（即用户选择的Locale）。
为了让该页面中包含SESSION_LOCALE，使用Struts2的<s:set .../>标签将用户Session中的“WW_TRANS_I18N_LOCALE”属性值设置成SESSION_LOCALE。
下面是完成该设置的标签：
<!-- 将用户Session中的“WW_TRANS_I18N_LOCALE”属性值设置成SESSION_LOCALE。 -->
<s:set name="SESSION_LOCALE" value="#session['WW_TRANS_I18N_LOCALE']"/>
下面是该selectlanguage.jsp页面的代码：
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
function langSelecter_onChanged()
{
 document.getElementById("langForm").submit();
}
</script>
<!-- 将用户Session中的“WW_TRANS_I18N_LOCALE”属性值设置成SESSION_LOCALE。 -->
<s:set name="SESSION_LOCALE" value="#session['WW_TRANS_I18N_LOCALE']"/>
<!-- 使用lee.Locales创建locales实例 -->
<s:bean id="locales" name="lee.Locales">
 <!-- 为locales实例这种current参数值 -->
 <s:param name="current" 
  value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE"/>
</s:bean>
<!-- 让用户选择语言的表单 -->
<form action="<s:url/>" id="langForm" 
     style="background-color:#bbbbbb; padding-top: 4px; padding-bottom: 4px;">
 <!-- 输出国际化提示 -->
     <s:text name="languag"/>
 <!-- 使用s:select标签迭代locales实例的locales Map属性 -->
 <s:select label="Language" list="#locales.locales" listKey="value" listValue="key"
        value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE"
        name="request_locale" id="langSelecter" 
        onchange="langSelecter_onChanged()" theme="simple"/>
</form>
注意：上面页面中大量使用了Struts2的标签，关于Struts2标签的详细用法，请参考本书第十章的讲解。
上面页面的原理是：使用<s:set .../>标签实例化一个Locales对象，并使用<s:select ..../>标前来显示该Locales对象的locales（Map类型）属性， <s:select ..../>可以使用一个下拉列表框来显示Map类型的集合，本应用将该Map的key输出成下拉列表项的显示名称，将该Map的value输出成下拉列表项的值。
除此之外，页面上面还有一段简单的Javascript脚本，它会在用户在选择下拉列表中某一项后，提交包含“reqeust_locale”变量的表单到Action。
上面页面和JavaBean一共使用了三个国际化key，所以需要在资源文件定义这三个key对应的国际化消息。因为本系统仅支持简体中文和美式英语两种环境（如需要增加其他语言也非常简单， 只需要增加更过的资源文件，并简单修改Locales类即可），所以需要分别在中文资源文件中增加如下三项：
languag=选择语言
usen=美式英语
zhcn=简体中文
在英文资源文件中增加如下三项：
languag=Select Lanuage
usen=American English
zhcn=Simplified Chinese

三. 选择程序语言
本应用为了更好的安全性，将所有的JSP页面都放在WEB-INF/jsp路径下，从而避免了直接访问JSP页面，为了让所有的JSP页面都能得到Struts2的处理，在struts.xml文件中增加如下配置片段：
<!-- 使用通配符号定义Action的name -->
<action name="*">
 <!-- 将请求转发该WEB-INF/jsp路径下同名的JSP页面 -->
<result>/WEB-INF/jsp/{1}.jsp</result>
</action>
如果在浏览器中请求selectlanguage.action，将看到选择程序语言的页面。
如果用户通过上面的下拉列表框选择了“美式英语”项后，将看到用户选择美式英语的页面。
一旦定义了上面的页面后，我们就可以在JSP页面中通过<s:include .../>标签来包含该页面，包含该页面后，就可以自行选择程序语言了。
例如在登陆页面中通过如下标签来包含上面选择程序语言的页面：
<!-- 包含让用户自行选择程序语言的页面 -->
<s:include value="selectlanguage.jsp"/>
在任何页面中增加了上面代码后，该页面就能允许用户自行选择语言。通常，我们只需要在应用的第一个页面让用户选择程序语言，后续页面直接使用该语言即可。
如果浏览者在浏览器的地址栏访问input.action，Struts2自动进入WEB-INF/jsp/input.jsp页面，将看到允许用户选择程序语言的页面。
如果用户希望使用美式英语的语言，则在允许用户选择程序语言的页面的下拉列表框中选中“美式英语”项，将看到使用美式英语界面的页面。
如果用户登陆成功，将看到美式英语环境下登陆成功的页面。该页面自动使用了美式英语的环境，这都是因为用户选择了美式英语的语言后，系统将用户选择设置成了Session的WW_TRANS_I18N_LOCALE属性值，该Session属性值直接决定Struts2系统的语言环境。
