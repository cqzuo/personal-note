����ת�� 

--------------------------------------------------------------------------------

2009-04-05 11:41:06����ǩ��struts2������[���͵�����Ȧ] 


�������Ϳ�������Զ�ת������Ҫת���������ͣ�����OGNL
��Ϊ��
----�ֲ�����ת��
                1.�Զ���ת����̳�DeaultTypeConverter                                    
                  ��дconvertValue(Map context, Object value, Class toType)
                  Xxx.class == toType (����equals())  String --> Object
                  String.class == toTtpe              Object --> String
                2.��̳�StrutsTypeConverter
                  ��д
                     Object convertFromString(Map context,String[] values,Class toClass)
                     String convertToString(Map context, Object o)
                3.�����ļ���
                   Action����-conversion.properties  ��Ҫ�Ͷ�ӦAction��ͬһĿ¼��
                   ���ݣ�
                      ������=ת������         ��������Ծ�д���У�
----ȫ������ת��
                1.  2.  ͬ�ֲ�ת��
                3.�����ļ���
                   xwork-conversion.properties���̶��ģ�
                   ���ݣ�
                      ��Ҫ����ת����Action��ȫ������=ת������
���ֲ�����ת����
=======================================
1. input.jsp
<h1>�ö��Ž������������ָ</h1>    �磺20��30
<s:form action="pointConverter">
 <s:textfield name="point" label="��" />
 <s:textfield name="age" label="����" />
 <s:textfield name="username" label="�û���" />
 <s:textfield name="date" label="����" />
 <s:submit label="�ύ" />
</s:form>

����һ��������˵���Ƚ�������ת����ת���ɹ����ٽ���������֤

=======================================
2.���� ģ����
.....test.bean ��
public class Point {
 private int x;
 private int y;
 //setter...getter...����
}

=======================================
3.��Ҫ˵��
����ʵ��ת����TypeCenverter�ӿڣ�
��Ҫʹ��DefaultTypeCenverter�� 

��дconvertValue()����
public Object convertValue(Map context, Object value, Class toType)
 
 

=======================================
4.�����Զ���ת����
����....test.converter��
���� ת����
��Ҫ�̳�DeaultTypeConverter��DeaultTypeConverterʵ����TypeConverterת���ӿ�
public class PointConverter extends DeaultTypeConverter {
 @Override
 public Object convertValue( 
  Map context, //������
  Object value, //Ҫת����ֵ(String����)
  Class toType  //Ŀ������(ת����ʲô)
 ) {  
  //���Ҫת����������Point
  if( Point.class == toType ) {
   Point point = new Point();
   String[] str = (String[])value;
   
   //�˴�����ֻ��һ��ֵ����0��λ����
   String[] paramValues = str[0].split(",");
   int x = Integer.parseInt(paramValues[0]); 
   int y = Integer.parseInt(paramValues[1]);
   point.setX(x);
   point.setY(y);
   return point;
  }
  //���Ҫת��������ΪString ��Ҳ������ϵͳ�Զ�ת����
  if( String.class == toType ) {
  
   Point point = (Point)value;
   int x = point.getX();
   int y = poitn.getY();
   String result = "[x=" + x + " , y=" + y + "]";
   return result;
  }
  return null;
 }

ע��Ϊʲôvalue�����飬��Ϊҳ����ֶο�����ͬ�������֣��磺
        <s:textfield name="username" />
        <s:textfield name="username" />
        �����Ļ������usernameʱ��Ӧ���Ƕ�����������ַ�������
 
=======================================
5.����action
public class PointAction extends ActionSupport {
 private Point point;
 private int age;
 private String username;
 private Date date;
 //setter...getter...
 @Override
 public String execute() throws Execption {
  return SUCCESS;
 }
}
--------------------
���䣺
Action�ӿ��У�
Field Summary  �ֶ�ժҪ
ERROR  ִ��ʧ��
INPUT  ��֤û�гɹ�
LOGIN   û��ִ�гɹ�����Ϊû�е�½
NONE   ִ�гɹ���������ʶ�κ���ͼ
SUCCESS ִ�гɹ�

=======================================
6. struts.xml
<package name="struts2" extends="struts-default">
 <action name="pointConverter" class="com.test.action.PointAction">
  <!-- ��Ӧexecute()�е�SUCCESS��SUCCESS��ֵ��success -->
  <result name="success">/output.jsp</result>
 </action>
</package>

=======================================
7.output.jsp
<%@ taglib prefix="s" uri="/strurs-tags" %>
property��ǩ�Զ�����value��Ӧ���ֶε�get����,value="point"��getPoint()����ƥ��
point: <s:property value="point"/><br/>
age:<s:property value="age"/><br/>
username:<s:property value="username"/><br/>
date:<s:property value="date"/><br/>
${point }<br/>
${point.x }<br/>
${point.y }  
 

=======================================
8.���������ļ�--����ָ��ת����
���ļ�����Ͷ�Ӧ��ת������ͬһ������
PointAction-conversion.properties
PointAction: ��Ӧ�ĸ�Action�е����Խ���ת��
-conversion.properties: �ǹ̶������
PointAction-conversion.properties������
���Ǹ����Խ���ת��=���Ǹ���������ת����������Ծ�д����
point=com....converter.PointConverter

����ɡ�
=======================================
��������
1.�ύ����->��struts.xml��ȥ�Ҷ�Ӧ��action��������pointConverter���ҵ�֮��֪������ָ�����ࣨPointAction������������
2.����PointAction��ʵ������PointAction�У��������е�ֵ����set�������������ÿ������
3.������set����ǰ�����ȼ�飬�������������û���Զ��������ת����û�е�ʱ��Ͱ���ϵͳ����Ϊ����Ĭ�ϵ�ת����
  ��������Ѿ������������ת�������PiontAction��Ŀ¼����û��PointAction-onversion.properties���ڣ���Ȼ�󵽸�.properties�ļ����ң��㵽��Ҫͨ���ĸ���ת����һ�����ԡ�
4.����Ӧ��ת�����У�������PointConverter��Ȼ���ж�ת���ķ���
Poitn.class==toType��ͨ���ַ������� ת���� Point���󣬽��뵽��Ӧ��if����
return�����̻ص�PointAction�е�setPoint������Ȼ��ʹ��ת����Ķ���ֵ������
5.�����е����Ը�ֵ�ɹ���ִ��execute������Ȼ��ͨ������ֵ�ҵ�struts.xml�е�action�е�result��Ӧ��ҳ�棨output.jsp������ʾ�����
6.Ȼ����<s:property>��ÿ�ҵ�value���͵�PointAction�е�����Ӧ��get���������Ҹ��ֶ���û�������Զ�ת���࣬����û���ֶΣ�Ӧ��ϵͳĬ�ϵ�ת����ֱ�ӷ��ء��������õģ�����ͬ�ϣ���PointConverter��ִ�ж�Ӧ��if���̣�String.class==toType����return��ص�PointAction�е�get����������ת�����ֵ����ʾ��ҳ�档
 
 
��ȫ������ת����
=======================================
����3���������
=======================================
������Եľֲ�����ת��
input.jsp��
��������������
<s:textfield name="point2" label="��2" />
<s:textfield name="point3" label="��3" />
PointAction��
����������ֶ�
private Point point2;
private Point point3;
//setter...getter...

PointAction-conversion.properties��
���
point2=com........converter.PointConverter
point3=com........converter.PointConverter

result.jsp��
���
��2��<s:property value="point2" /><br/>
��3��<s:property value="point3" /><br/>
 
=======================================
����Ҫת���Ķ���ֲ��ڶ��action���棬����ķ�ʽ�Ƚ��鷳
Ӧʹ��ȫ�ֵ�����ת������ϵͳ����������Ҫ��Ľ���ת��
=======================================
�����ļ���
�����ļ�����xwork-conversion.properties���̶��ģ�
Ӧ��classesĿ¼�£�Ҳ����struts.xml��ͬ��Ŀ¼
����src�¾Ϳ�����
���ݣ�
Ҫת���Ǹ����ȫ������=ʹ���ĸ������ת��
com.scorpio.jh.struts2.test.bean.Point=com.scorpio.jh.struts2.test.converter.PointConverter
��PointConverter���ϵͳ�����е���Ҫת���������ת��
 

=======================================
ͨ���̳�util���µ�StrutsTypeConverter�����ת��
=======================================
1. ����һ���µ�ת���࣬�̳�StrutsTypeConverter
public class PointConverter2 extends StrutsTypeConverter {
 //��Stringת����Ŀ�����
 @Override
 public Object convertFromString(
  Map context,
  String[] values,
  Class toClass) {
  Point point = new Point();
  String[] paramValues = values[0].split(",");
  int x = Integer.parseInt(paramValues[0]);
  int y = Integer.parseInt(paramValues[1]);
  
  point.setX(x);
  point.setY(y);
 
  return point;
 }
 //�Ӷ���ת����String
 @Override
 public String convertToString( Map context, Object o ) {
 
  Point point = (Point)o;
  int x = point.getX();
  int y = point.getY();
 
  String result = "[x=" + x + ", y=" + "]";
  return result;
 }
}
=======================================
2.�޸������ļ� xwork-conversion.properties
com.scorpio.jh.struts2.test.bean.Point=com.scorpio.jh.struts2.test.converter.PointConverter2

����ɡ�
 
��չ��
=======================================
����Action����һ���������ͣ��洢Piont����
=======================================
1.action��
public class PointAction extends ActionSupport {
 private List<Piont> point;
 private int age;
 private String username;
 private Date date;
 //setter...getter...
 public String execute() throws Exception { ... }
 
}
 
=======================================
2.input.jsp
<s:form action="pointConverter">
 <s:textfield name="point" label="��1" /> name��ͬ���᷵��һ������
 <s:textfield name="point" label="��2" />
 <s:textfield name="point" label="��3" />
 <s:textfield name="age" label="����" />
 <s:textfield name="username" label="�û���" />
 <s:textfield name="date" label="����" />
 <s:submit label="�ύ" />
</s:form>

=======================================
3. result.jsp
point: <s:property value="point"/><br/>
age:<s:property value="age"/><br/>
username:<s:property value="username"/><br/>
date:<s:property value="date"/><br/>
 
=======================================
4.ת���� PointConverter3 
public class PointConverter3 extends StrutsTypeConverter {
 //��String������
 @Override
 public Object convertFromString(
  Map context,
  String[] values,
  Class toClass) {
  List<Point> list = new ArrayList<Point>();
  for( String value : values ) {
   Point point = new Point();
   String[] paramValues = value.split.split(",");
   int x = Integer.parseInt(paramValues[0]);
   int y = Integer.parseInt(paramValues[1]);
   point.setX(x);
   point.setY(y);
   list.add(point);   
  }
  return list;
 }
 //�Ӷ���String
 @Override
 public String convertToString( Map context, Object o ) {
 
  List<Point> list = (List<Point>)o;
  
  //StringBuilder ��ͬ���汾��StringBuffer
  StringBuilder sb = new StringBuilder();
  sb.append("[");
  int number = 0;
 
  for( Point point : list ) {
  
   ++number;
   int x = point.getX();
   int y = point.getY();
   sb.append(number).append(" x=").append(x).append(", y=").append(y).append(" ");
  }
  sb.append("]");
  return sb.toString();
 }
}
=======================================
5.���þֲ�ת��
PointAction-conversion.properties
point=com....converter.PointConverter3

����ɡ�
=======================================
ע��
�����Ҫת�����ֶ�û��ʹ�÷��� List<Point>
��Ҫ�ھֲ�����ת���м��� Element_ ͷ + ��Ҫת���Ķ���
���ǽ���ʹ�÷���
 
=======================================
���䣺
 ������ ������.���Ե�ֵ ����һ�ַ�ʽ��ֵ
<s:form action="pointConverter">
 <s:textfield name="point.x" label="x����" /> ********* 
 <s:textfield name="point.y" label="y����" /> *********
 <s:textfield name="age" label="����" />
 <s:textfield name="username" label="�û���" />
 <s:textfield name="date" label="����" />
 <s:submit label="�ύ" />
</s:form>

------------------------
public class PointAction extends ActionSupport {
 private Piont point;
 private int age;
 private String username;
 private Date date;
 //setter...getter...
 public String execute() throws Exception { ... }
 
}
------------------------
��ȫ�ֺ;ֲ�����ת��ע�͵� ��#��
------------------------
��дPoint��toString()
pubic String toString() {
 return "[x=" + x + ", y=" + y + "]";
}
����ɡ�
 
����2��
=======================================
����jspĬ�ϵ��ַ���

�˵�window->Preferences->MyEclipse->FIles and Editors->JSP
��Encoding��ѡ����Ҫ�� ����UTF-8
======================================= 
Ҫ��eclipse����ʾstruts2��Դ���룬��Ҫ��Դ����������ӣ�
���ӵ���struts-2.0.11\src\core\src\main\java\ �Ϳ�����
���ĳ��� 51CTO.COM�������� 
