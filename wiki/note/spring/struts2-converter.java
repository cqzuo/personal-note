类型转换 

--------------------------------------------------------------------------------

2009-04-05 11:41:06　标签：struts2　　　[推送到技术圈] 


基本类型可以完成自动转换，主要转换对象类型，基于OGNL
分为：
----局部类型转换
                1.自定义转换类继承DeaultTypeConverter                                    
                  重写convertValue(Map context, Object value, Class toType)
                  Xxx.class == toType (或用equals())  String --> Object
                  String.class == toTtpe              Object --> String
                2.或继承StrutsTypeConverter
                  重写
                     Object convertFromString(Map context,String[] values,Class toClass)
                     String convertToString(Map context, Object o)
                3.配置文件：
                   Action类名-conversion.properties  需要和对应Action在同一目录下
                   内容：
                      属性名=转换类名         （多个属性就写多行）
----全局类型转换
                1.  2.  同局部转换
                3.配置文件：
                   xwork-conversion.properties（固定的）
                   内容：
                      需要类型转换的Action的全称类名=转换类名
【局部类型转换】
=======================================
1. input.jsp
<h1>用逗号将点的两个坐标分割开</h1>    如：20，30
<s:form action="pointConverter">
 <s:textfield name="point" label="点" />
 <s:textfield name="age" label="年龄" />
 <s:textfield name="username" label="用户名" />
 <s:textfield name="date" label="生日" />
 <s:submit label="提交" />
</s:form>

对于一个属性来说，先进行类型转化，转化成功了再进行输入验证

=======================================
2.建立 模型类
.....test.bean 包
public class Point {
 private int x;
 private int y;
 //setter...getter...方法
}

=======================================
3.简要说明
用于实现转换的TypeCenverter接口：
主要使用DefaultTypeCenverter类 

重写convertValue()方法
public Object convertValue(Map context, Object value, Class toType)
 
 

=======================================
4.建立自定义转换类
建立....test.converter包
建立 转换类
需要继承DeaultTypeConverter，DeaultTypeConverter实现了TypeConverter转换接口
public class PointConverter extends DeaultTypeConverter {
 @Override
 public Object convertValue( 
  Map context, //上下文
  Object value, //要转换的值(String数组)
  Class toType  //目标类型(转换成什么)
 ) {  
  //如果要转换的类型是Point
  if( Point.class == toType ) {
   Point point = new Point();
   String[] str = (String[])value;
   
   //此处数组只有一个值，在0的位置上
   String[] paramValues = str[0].split(",");
   int x = Integer.parseInt(paramValues[0]); 
   int y = Integer.parseInt(paramValues[1]);
   point.setX(x);
   point.setY(y);
   return point;
  }
  //如果要转换的类型为String （也可以用系统自动转换）
  if( String.class == toType ) {
  
   Point point = (Point)value;
   int x = point.getX();
   int y = poitn.getY();
   String result = "[x=" + x + " , y=" + y + "]";
   return result;
  }
  return null;
 }

注：为什么value是数组，因为页面的字段可以有同样的名字，如：
        <s:textfield name="username" />
        <s:textfield name="username" />
        这样的话，获得username时就应该是多个，所以是字符串数组
 
=======================================
5.建立action
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
补充：
Action接口中：
Field Summary  字段摘要
ERROR  执行失败
INPUT  验证没有成功
LOGIN   没有执行成功，因为没有登陆
NONE   执行成功，但不相识任何题图
SUCCESS 执行成功

=======================================
6. struts.xml
<package name="struts2" extends="struts-default">
 <action name="pointConverter" class="com.test.action.PointAction">
  <!-- 对应execute()中的SUCCESS，SUCCESS的值是success -->
  <result name="success">/output.jsp</result>
 </action>
</package>

=======================================
7.output.jsp
<%@ taglib prefix="s" uri="/strurs-tags" %>
property标签自动调用value对应的字段的get方法,value="point"和getPoint()方法匹配
point: <s:property value="point"/><br/>
age:<s:property value="age"/><br/>
username:<s:property value="username"/><br/>
date:<s:property value="date"/><br/>
${point }<br/>
${point.x }<br/>
${point.y }  
 

=======================================
8.定义属性文件--用于指定转换类
该文件必须和对应的转换类在同一个包下
PointAction-conversion.properties
PointAction: 对应哪个Action中的属性进行转换
-conversion.properties: 是固定不变的
PointAction-conversion.properties的内容
对那个属性进行转换=用那个类对其进行转换，多个属性就写多行
point=com....converter.PointConverter

【完成】
=======================================
整体流程
1.提交请求->到struts.xml中去找对应的action，这里是pointConverter，找到之后，知道了有指定的类（PointAction）来处理请求
2.生成PointAction的实例，到PointAction中，把请求中的值调用set方法赋给该类的每个属性
3.当调用set方法前，首先检查，对于这个属性有没有自定义的类型转换，没有的时候就按照系统的行为进行默认的转换；
  如果发现已经定义好了类型转换（检查PiontAction的目录下有没有PointAction-onversion.properties存在），然后到该.properties文件里找，你到底要通过哪个类转换哪一个属性。
4.到相应的转换类中，这里是PointConverter，然后判断转换的方向，
Poitn.class==toType：通过字符串数组 转换到 Point对象，进入到相应的if流程
return后，流程回到PointAction中的setPoint方法，然后使用转换后的对象赋值给属性
5.将所有的属性赋值成功后，执行execute方法，然后通过返回值找到struts.xml中的action中的result对应的页面（output.jsp），显示结果。
6.然后发现<s:property>，每找到value，就到PointAction中调用相应的get方法，查找该字段有没有配置自动转换类，对于没有字段，应用系统默认的转换后直接返回。对于配置的，流程同上，到PointConverter中执行对应的if流程（String.class==toType），return后回到PointAction中的get方法返回其转换后的值，显示到页面。
 
 
【全局类型转换】
=======================================
需求：3个点的坐标
=======================================
多个属性的局部类型转换
input.jsp中
添加两个点的坐标
<s:textfield name="point2" label="点2" />
<s:textfield name="point3" label="点3" />
PointAction中
添加两个点字段
private Point point2;
private Point point3;
//setter...getter...

PointAction-conversion.properties中
添加
point2=com........converter.PointConverter
point3=com........converter.PointConverter

result.jsp中
添加
点2：<s:property value="point2" /><br/>
点3：<s:property value="point3" /><br/>
 
=======================================
需求：要转换的对象分布在多个action里面，上面的方式比较麻烦
应使用全局的类型转换：对系统里所有满足要求的进行转换
=======================================
配置文件：
配置文件名：xwork-conversion.properties（固定的）
应在classes目录下，也就是struts.xml相同的目录
放在src下就可以了
内容：
要转化那个类的全称类名=使用哪个类进行转换
com.scorpio.jh.struts2.test.bean.Point=com.scorpio.jh.struts2.test.converter.PointConverter
用PointConverter类对系统中所有的需要转换的类进行转换
 

=======================================
通过继承util包下的StrutsTypeConverter类进行转换
=======================================
1. 建立一个新的转换类，继承StrutsTypeConverter
public class PointConverter2 extends StrutsTypeConverter {
 //从String转换到目标对象
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
 //从对象转换到String
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
2.修改配置文件 xwork-conversion.properties
com.scorpio.jh.struts2.test.bean.Point=com.scorpio.jh.struts2.test.converter.PointConverter2

【完成】
 
拓展：
=======================================
需求：Action中用一个集合类型，存储Piont对象
=======================================
1.action类
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
 <s:textfield name="point" label="点1" /> name相同，会返回一个数组
 <s:textfield name="point" label="点2" />
 <s:textfield name="point" label="点3" />
 <s:textfield name="age" label="年龄" />
 <s:textfield name="username" label="用户名" />
 <s:textfield name="date" label="生日" />
 <s:submit label="提交" />
</s:form>

=======================================
3. result.jsp
point: <s:property value="point"/><br/>
age:<s:property value="age"/><br/>
username:<s:property value="username"/><br/>
date:<s:property value="date"/><br/>
 
=======================================
4.转换类 PointConverter3 
public class PointConverter3 extends StrutsTypeConverter {
 //从String到对象
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
 //从对象到String
 @Override
 public String convertToString( Map context, Object o ) {
 
  List<Point> list = (List<Point>)o;
  
  //StringBuilder 非同步版本的StringBuffer
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
5.采用局部转换
PointAction-conversion.properties
point=com....converter.PointConverter3

【完成】
=======================================
注：
如果需要转换的字段没有使用泛型 List<Point>
则要在局部类型转换中加入 Element_ 头 + 你要转换的东西
但是建议使用泛型
 
=======================================
补充：
 可以用 属性名.属性的值 这样一种方式赋值
<s:form action="pointConverter">
 <s:textfield name="point.x" label="x坐标" /> ********* 
 <s:textfield name="point.y" label="y坐标" /> *********
 <s:textfield name="age" label="年龄" />
 <s:textfield name="username" label="用户名" />
 <s:textfield name="date" label="生日" />
 <s:submit label="提交" />
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
将全局和局部类型转换注释掉 用#号
------------------------
重写Point的toString()
pubic String toString() {
 return "[x=" + x + ", y=" + y + "]";
}
【完成】
 
补充2：
=======================================
更改jsp默认的字符集

菜单window->Preferences->MyEclipse->FIles and Editors->JSP
从Encoding中选择需要的 比如UTF-8
======================================= 
要在eclipse中显示struts2的源代码，需要和源代码进行链接，
连接到：struts-2.0.11\src\core\src\main\java\ 就可以了
本文出自 51CTO.COM技术博客 
