struts��action��ת�����ܽ� 
���ߣ�����  �������й���ѧ������ռ�����   �������ڣ�2007-08-02   
 
[1] ������action

<action path=\"/aFullAction\"
type=\"somePackage.someActionClass\">
name=\"someForm\"
input=\"someJSP.jsp\"
<forward name=\"successful\" path=\"someJSP.jsp\"/>
<forward name=\"failed\" path=\"someOtherJSP.jsp\"/>
</action>

���ȣ�Struts��ActionServlet���յ�һ������Ȼ�����struts-config.xml�����ö�λ����Ӧ��mapping��ӳ�䣩�����������form�ķ�Χ��request�����ڶ���ķ�Χ���Ҳ������form������һ���µ�formʵ����ȡ��formʵ���Ժ󣬵�����reset ()������Ȼ�󽫱��еĲ�������form�����validate���Բ�Ϊfalse������validate()���������validate()���طǿյ�ActionErrors�����ᱻת��input����ָ����URI��������ؿյ�ActionErrors����ôִ��Action��execute() ���������ݷ��ص�ActionForwardȷ��Ŀ��URI��

��������Ч���ǣ�execute()����validate()�ɹ��Ժ��ִ�У�input����ָ������һ��URI��


[2] ����Form��action

<action path=\"/aFormOnlyAction\"
type=\"org.apache.struts.actions.ForwardAction\"
name=\"someForm\"
input=\"someJSP.jsp\"
parameter=\"someOtherJSP.jsp\"
/>

���ȣ�Struts���ڶ����scope��ѰsomeForm������ҵ������ã�����Ҳ������½�һ��ʵ����ȡ��formʵ���Ժ󣬵�����reset()������Ȼ�󽫱��еĲ�������form�����validate���Բ�Ϊfalse������validate()���������validate()���طǿյ� ActionErrors�����ᱻת��input����ָ����URI��������ؿյ�ActionErrors����ôת��parameter����ָ����Ŀ�� URI��

��������Ч���ǣ�û��action����Դ�����ǵ�ҵ���߼�������������Ҫд����߼���ֻ��д��form��reset()���� validate()�����С�validate()����������֤�ͷ���ҵ��㡣��Ϊ�����actionӳ�䲻����forward��Ҳû�����壩�����Բ����ض���ֻ����Ĭ�ϵ��Ǹ�forward�����ֽ���form��action���������������ݻ�ȡ��forward����һ��JSP����ʾ��


[3] ����Action��action

<action path=\"/anActionOnlyAction\"
type=\"somePackage.someActionClass\">
input=\"someJSP.jsp\"
<forward name=\"successful\" path=\"someJSP.jsp\"/>
<forward name=\"failed\" path=\"someOtherJSP.jsp\"/>
</action>

���ȣ�ActionServlet���յ������ȡ��action��ʵ��������execute()������Ȼ����ݷ��ص�ActionForward����������forward��forward��ָ����URI��action��

��������Ч���ǣ�û��formʵ��������execute()����������execute()�����Լ��������л�ȡ������Action���Ա�forward�����ض�������action���ܴ���ͨ��HTML FORM�ύ������ֻ�ܴ�������ʽ������


[4] ����JSP��action

<action path=\"/aJSPOnlyAction\"
type=\"org.apache.struts.actions.ForwardAction\"
parameter=\"someOtherJSP.jsp\"
/>

���ȣ�ActionServlet�ӵ���������ForwardAction��execute()������execute()�������õ�parameter����ֵ��forward���Ǹ�URI��

��������Ч���ǣ�û���κ�form��ʵ�������Ƚ���ʵ�����ο�����form��request���߼���ķ�Χ�ж��壻�������action��������Ӧ�ó������ú�䵱ϵͳ������ֻ��Ҫ������������ļ�������Ҫ���±���ϵͳ��[Page]


[5] ����action��Ӧһ��form

<action path=\"/anAction\"
type=\"somePackage.someActionClass\">
name=\"someForm\"
input=\"someJSP.jsp\"
<forward name=\"successful\" path=\"/anotherAction.do\"/>
</action>
<action path=\"/anotherAction\"
type=\"somePackage.someOtherActionClass\">
name=\"someForm\"
input=\"someOtherJSP.jsp\"
<forward name=\"successful\" path=\"someResultJSP.jsp\"/>
</action>

��ÿ��������action�����������ϲ�û�к�������action��ʲôʵ�ʵ�����������ģʽ���Ա����������������form������Ҫע������ں�һ��action��ͬ�������form��reset()��validate()������������Ǳ���ȷ��form�е���Ϣ������д��

����ķ�ʽ���·�Ϊ���֣�a) ��request�з���һ��ָʾ������ǰһ��action�������һ��action����form���Ӷ��ں�һ��action���Ա����Ǹ�form�е�ֵ����һ��ʽֻ����ʹ��forwardʱʹ�á�b) ��ʹ��redirect������forwardʱ�����԰�ָʾ������session����ߵļ����������������һ�������ָʾ�������


[6] ����action��Ӧ����form

<action path=\"/anAction\"
type=\"somePackage.someActionClass\">
name=\"someForm\"
input=\"someJSP.jsp\"
<forward name=\"successful\" path=\"/anotherAction.do\" redirect=\"true\"/>
</action>
<action path=\"/anotherAction\"
type=\"somePackage.someOtherActionClass\">\"
name=\"someOtherForm\"
input=\"someOtherJSP.jsp\"
<forward name=\"successful\" path=\"someResultJSP.jsp\"/>
</action>

�����Ϸ�ʽ��ǰһ����������û��̫������ֻ���������ڶ�������action�ֱ��ṩ��form�����Ǵ��뿴��ȥ�����������������ǿ��Էֱ���WEBӦ�ó��������������ֵ��ע����ǣ���һ��actionͬ���᳢����form��д����Щ�������������ǿ�����������a) �ں�һ��form��ʹ����һ����������b) ֻ�ṩgetter�����ṩsetter��

���µĴ�����������
ǰһ��action�������롢��֤��Ȼ������д��ҵ����־ò㣬�ض��򵽺�һ��action����һ��action�ֶ��Ĵ�ҵ���/�־ò�ȡ�����ݣ�д��form��ͨ��������ʽ��������ǰ̨JSP��ʾ��

�������ĺô��ǲ��ر�������form�е�ֵ����˿���ʹ��redirect������forward�������ͽ���������action֮�����϶ȣ�ͬʱҲ�����˲���Ҫ���ظ��ύ��  
 
