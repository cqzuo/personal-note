Struts2�������û�����ѡ��������� 
�����ѧϰstruts2��ѧϰ������������ġ�struts2Ȩ��ָ�ϡ����Ȿ��д�÷ǳ��ã��ǳ���ѧϰ��ֵ������ѧϰ�����У��Լ���������Щ���ӡ�������ǹ�����struts2�������û�����ѡ��������Ե�ԭ���ʾ����

�ںܶ�������ҵ����У��������û������л����ԣ����û�����ϵͳʱ�򣬿��Գ���һ�������б�����û�ѡ�����ԣ�һ���û�ѡ�����Լ���Ҫʹ�õ����Ի���������ϵͳ�����Ի�����һֱ���������Ի�����
Struts2Ҳ���������û�����ѡ��������ԡ����ң���ΪStruts2��֧�֣��ڳ���������ѡ�����Ի�������ø��Ӽ򵥡�

һ. Struts2���ʻ������л���
��Struts 2�У����ǿ���ͨ��ActionContext.getContext().setLocale(Locale arg)���������û���Ĭ�����ԡ����������ַ�ʽ��ȫ��һ���ֶ���ʽ��������Ҫ���ʵ�֡�
Ϊ�˼������û�Ĭ�����Ի�����Struts 2�ṩ��һ����i18n����������Interceptor�������ҽ���סע����Ĭ�ϵ�������ջ�У�defaultStack����������Struts2��Ĭ��������ջ������Ƭ�Σ������д����ֱ�ʾ�ľ���i18n�������� 
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
i18n��������ִ��Action����ǰ���Զ����������е�һ����Ϊrequest_locale�Ĳ���������ò������ڣ��������ͽ�����Ϊ��������ת����Locale���󣬲�������Ϊ�û�Ĭ�ϵ�Locale����������/���һ�������
����֮�⣬i18n���������Ὣ�������ɵ�Locale���󱣴����û�Session����Ϊ��WW_TRANS_I18N_LOCALE���������С�һ���û�Session�д���һ����Ϊ��WW_TRANS_I18N_LOCALE�������ԣ��������ָ����Locale������Ϊ����ߵ�Ĭ��Locale��

��. ���������б��
����ǰ��Ľ��ܣ�Ϊ��ʵ�����û�����ѡ��������ԵĹ��ܣ�ֻ���ṩһ�������б���������б�����г���Ӧ����֧�ֵĸ������ԣ����ң����û�ѡ�������б����ĳһ��ʱ��ϵͳ�����������ֵ��Ϊrequest_locale�����ύ��Struts2ϵͳ��
Ϊ�ˣ����ǽ�ϵͳ��֧�ֵ����Է���һ��Map�У�ͨ����JSPҳ���е�����Map����ͨ�����ַ�ʽ���Ϳ�����ҳ�����г�ϵͳ��֧�ֵ�ȫ�����ԣ������û�����ѡ��
���涨����JavaBean�����JavaBean�ﱣ���˵�ǰӦ����֧�ֵ�ȫ�����ԣ���JavaBean�Ĵ������£�
//��JavaBean�����ϵͳ��֧�ֵ�ȫ�����ԡ�
public class Locales
{
 //��Ϊ��ʵ��Ҳ��Ҫʵ�ֹ��ʻ�������ʹ��current��Ϊ�û���ǰ��Locale
 private Locale current;
 //ȡ���û���ǰLocale��setter����
 public void setCurrent(Locale cur)
 {
  this.current = cur;
 }
 //ȡ�ñ�ϵͳ��֧�ֵ�ȫ������
     public Map<String, Locale> getLocales()
 {
  //����ǰϵͳ֧�ֵ�ȫ�����Ա�����Map������
         Map<String, Locale> locales = new Hashtable<String, Locale>();
  ResourceBundle bundle = ResourceBundle.getBundle("messageResource" , current);
  //��ӵ�ǰϵͳ֧�ֵ����ԣ�key��ϵͳ֧�����Ե���ʾ���֣�value��ϵͳ֧�����Ե�Localeʵ��
         locales.put(bundle.getString("usen"), Locale.US);
         locales.put(bundle.getString("zhcn"), Locale.CHINA);
         return locales;
    }
}
������JavaBean�У�����ʹ����һ��Map���������������û�֧�ֵ����ԣ���Map�����key����֧�����Ե���ʾ���֣�����Map�����value����֧�����Ե�Localeʵ����Ӧ��֧�����Ե���ʾ���֣�Ҳ��ͨ�����ʻ���Ϣ�����ɵġ�
һ�������˸�JavaBean֮�󣬾Ϳ�����JSPҳ���д�����JavaBean��ʵ������Ϊ�䴫��һ��current������������JavaBean�е�Locale�������Ϳ��Ը��ݸ�Locale����������������ʾϵͳ��֧��������ʾ���ơ�
Ϊ����JSPҳ����ʹ�ø�JavaBeanʵ����ʹ�������ǩ��������JavaBeanʵ����
<!-- ʹ��lee.Locales����localesʵ�� -->
<s:bean id="locales" name="lee.Locales">
 <!-- Ϊlocalesʵ������current����ֵ -->
 <s:param name="current" 
  value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE"/>
</s:bean>
�����ǩ������lee.Locales���localesʵ������Ϊ��ʵ��������current����ֵ�����øò���ֵʱʹ������Ŀ����������ж�SESSION_LOCALE�Ƿ�Ϊ�գ������SESSION_LOCALEΪ�գ��򷵻�ValueStack��locale����ֵ�����û���������õ�Locale�������SESSION_LOCALE��Ϊ�գ��򷵻ظ�SESSION_LOCALE��ֵ�����û�ѡ���Locale����
Ϊ���ø�ҳ���а���SESSION_LOCALE��ʹ��Struts2��<s:set .../>��ǩ���û�Session�еġ�WW_TRANS_I18N_LOCALE������ֵ���ó�SESSION_LOCALE��
��������ɸ����õı�ǩ��
<!-- ���û�Session�еġ�WW_TRANS_I18N_LOCALE������ֵ���ó�SESSION_LOCALE�� -->
<s:set name="SESSION_LOCALE" value="#session['WW_TRANS_I18N_LOCALE']"/>
�����Ǹ�selectlanguage.jspҳ��Ĵ��룺
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
function langSelecter_onChanged()
{
 document.getElementById("langForm").submit();
}
</script>
<!-- ���û�Session�еġ�WW_TRANS_I18N_LOCALE������ֵ���ó�SESSION_LOCALE�� -->
<s:set name="SESSION_LOCALE" value="#session['WW_TRANS_I18N_LOCALE']"/>
<!-- ʹ��lee.Locales����localesʵ�� -->
<s:bean id="locales" name="lee.Locales">
 <!-- Ϊlocalesʵ������current����ֵ -->
 <s:param name="current" 
  value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE"/>
</s:bean>
<!-- ���û�ѡ�����Եı� -->
<form action="<s:url/>" id="langForm" 
     style="background-color:#bbbbbb; padding-top: 4px; padding-bottom: 4px;">
 <!-- ������ʻ���ʾ -->
     <s:text name="languag"/>
 <!-- ʹ��s:select��ǩ����localesʵ����locales Map���� -->
 <s:select label="Language" list="#locales.locales" listKey="value" listValue="key"
        value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE"
        name="request_locale" id="langSelecter" 
        onchange="langSelecter_onChanged()" theme="simple"/>
</form>
ע�⣺����ҳ���д���ʹ����Struts2�ı�ǩ������Struts2��ǩ����ϸ�÷�����ο������ʮ�µĽ��⡣
����ҳ���ԭ���ǣ�ʹ��<s:set .../>��ǩʵ����һ��Locales���󣬲�ʹ��<s:select ..../>��ǰ����ʾ��Locales�����locales��Map���ͣ����ԣ� <s:select ..../>����ʹ��һ�������б������ʾMap���͵ļ��ϣ���Ӧ�ý���Map��key����������б������ʾ���ƣ�����Map��value����������б����ֵ��
����֮�⣬ҳ�����滹��һ�μ򵥵�Javascript�ű����������û���ѡ�������б���ĳһ����ύ������reqeust_locale�������ı���Action��
����ҳ���JavaBeanһ��ʹ�����������ʻ�key��������Ҫ����Դ�ļ�����������key��Ӧ�Ĺ��ʻ���Ϣ����Ϊ��ϵͳ��֧�ּ������ĺ���ʽӢ�����ֻ���������Ҫ������������Ҳ�ǳ��򵥣� ֻ��Ҫ���Ӹ�������Դ�ļ��������޸�Locales�༴�ɣ���������Ҫ�ֱ���������Դ�ļ��������������
languag=ѡ������
usen=��ʽӢ��
zhcn=��������
��Ӣ����Դ�ļ��������������
languag=Select Lanuage
usen=American English
zhcn=Simplified Chinese

��. ѡ���������
��Ӧ��Ϊ�˸��õİ�ȫ�ԣ������е�JSPҳ�涼����WEB-INF/jsp·���£��Ӷ�������ֱ�ӷ���JSPҳ�棬Ϊ�������е�JSPҳ�涼�ܵõ�Struts2�Ĵ�����struts.xml�ļ���������������Ƭ�Σ�
<!-- ʹ��ͨ����Ŷ���Action��name -->
<action name="*">
 <!-- ������ת����WEB-INF/jsp·����ͬ����JSPҳ�� -->
<result>/WEB-INF/jsp/{1}.jsp</result>
</action>
����������������selectlanguage.action��������ѡ��������Ե�ҳ�档
����û�ͨ������������б��ѡ���ˡ���ʽӢ���󣬽������û�ѡ����ʽӢ���ҳ�档
һ�������������ҳ������ǾͿ�����JSPҳ����ͨ��<s:include .../>��ǩ��������ҳ�棬������ҳ��󣬾Ϳ�������ѡ����������ˡ�
�����ڵ�½ҳ����ͨ�����±�ǩ����������ѡ��������Ե�ҳ�棺
<!-- �������û�����ѡ��������Ե�ҳ�� -->
<s:include value="selectlanguage.jsp"/>
���κ�ҳ�����������������󣬸�ҳ����������û�����ѡ�����ԡ�ͨ��������ֻ��Ҫ��Ӧ�õĵ�һ��ҳ�����û�ѡ��������ԣ�����ҳ��ֱ��ʹ�ø����Լ��ɡ�
����������������ĵ�ַ������input.action��Struts2�Զ�����WEB-INF/jsp/input.jspҳ�棬�����������û�ѡ��������Ե�ҳ�档
����û�ϣ��ʹ����ʽӢ������ԣ����������û�ѡ��������Ե�ҳ��������б����ѡ�С���ʽӢ��������ʹ����ʽӢ������ҳ�档
����û���½�ɹ�����������ʽӢ�ﻷ���µ�½�ɹ���ҳ�档��ҳ���Զ�ʹ������ʽӢ��Ļ������ⶼ����Ϊ�û�ѡ������ʽӢ������Ժ�ϵͳ���û�ѡ�����ó���Session��WW_TRANS_I18N_LOCALE����ֵ����Session����ֱֵ�Ӿ���Struts2ϵͳ�����Ի�����
