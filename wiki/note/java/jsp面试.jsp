1��forward ��redirect������
��forward�Ƿ�����������Դ��������ֱ�ӷ���Ŀ���ַ��URL�����Ǹ�URL����Ӧ���ݶ�ȡ������Ȼ�����Щ�����ٷ�������������������

��֪�����������͵������Ǵ��Ķ����ģ��������ĵ�ַ���л���ԭ���ĵ�ַ��
redirect���Ƿ���˸����߼�,����һ��״̬��,�������������ȥ�����Ǹ���ַ��һ����˵��������øղ���������в�������������

��session,request���������Ի�ȡ��
2��jsp����Щ���ö���?���÷ֱ���ʲô?
��JSP��������9�ֻ����������������ASP��6���ڲ�������Ӧ���� 
��request �û������󣬴�������������GET/POST����Ĳ��� 
response ��ҳ�����û��˵Ļ�Ӧ 
pageContext ��ҳ����������������� 
session �������йصĻỰ�� 
application servlet ����ִ�е����� 
out �������ͻ�Ӧ�����
config servlet�Ĺ��ܲ��� 
page JSP��ҳ���� 
exception ��Դ�����ҳ��δ��׽������ 
3��jsp����Щ����?���÷ֱ���ʲô?
��:JSP��������6�ֻ�������
jsp:include����ҳ�汻�����ʱ������һ���ļ��� 
jsp:useBean��Ѱ�һ���ʵ����һ��JavaBean�� 
jsp:setProperty������JavaBean�����ԡ� 
jsp:getProperty�����ĳ��JavaBean�����ԡ� 
jsp:forward��������ת��һ���µ�ҳ�档 
jsp:plugin���������������ΪJava�������OBJECT��EMBED���
4��JSP�ж�̬INCLUDE�뾲̬INCLUDE������ 
�𣺶�̬INCLUDE��jsp:include����ʵ��
<jsp:include page="included.jsp" flush="true" />�����ǻ��������ļ��еı仯���ʺ����ڰ�����̬ҳ�棬���ҿ��Դ�����
��̬INCLUDE��includeα��ʵ��,�������������ļ��ı仯�������ڰ�����̬ҳ��
<%@ include file="included.htm" %>
5��������ת��ʽ�ֱ���ʲô?��ʲô����?
�������֣��ֱ�Ϊ��
<jsp:include page="included.jsp" flush="true">
<jsp:forward page= "nextpage.jsp"/>
ǰ��ҳ�治��ת��include��ָ��ҳ�棬ֻ����ʾ��ҳ�Ľ������ҳ�滹��ԭ����ҳ�档ִ����󻹻�������൱�ں������á����ҿ��Դ�����

.������ȫת����ҳ�棬�����ٻ������൱��go to ��䡣
6��JSP�����ö��󼰷�����
��request��ʾHttpServletRequest�������������й�������������Ϣ�������ṩ�˼������ڻ�ȡcookie, header, ��session���ݵ���
�õķ����� 
response��ʾHttpServletResponse���󣬲��ṩ�˼������������ͻ� ���������Ӧ�ķ�������cookies,ͷ��Ϣ�ȣ� 
out������javax.jsp.JspWriter��һ��ʵ�������ṩ�˼�������ʹ��������������������������� 
pageContext��ʾһ��javax.servlet.jsp.PageContext�����������ڷ����ȡ���ַ�Χ�����ֿռ䡢servlet��صĶ����API�����Ұ�

װ��ͨ�õ�servlet��ع��ܵķ����� 
session��ʾһ�������javax.servlet.http.HttpSession����Session���Դ����û���״̬��Ϣ 
applicaton ��ʾһ��javax.servle.ServletContext�����������ڲ����й�servlet�����servlet��������Ϣ 
config��ʾһ��javax.servlet.ServletConfig���󡣸ö������ڴ�ȡservletʵ���ĳ�ʼ�������� 
page��ʾ�Ӹ�ҳ�������һ��servletʵ��