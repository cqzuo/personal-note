1.xml的含义 extensible markup language
  xml是最根本的文件，用来描述数据本身的--xsl可以将xml装饰成不同的东西--DTD用来约束xml的性质
2.xml的基本概念
   xml语言----描述事物本身(可扩展)
   xsl语言----展现事物的表现形式
   DTD(Schema)---定义xml语言的语法
   例子：
   <课堂 名称="java工程师">
      <老师 名称="镇南关" 性别="人妖">
          <老师的胳膊 质地="木头"/>
      </老师>
  </课堂>
  xml的作用：数据交换和配置文件
  xml和html区别：
      html不可扩展，数据和标签混合
      xml语法要求严格
      xml可重用性高
  xml的应用：
     配置文件
     deploy文件
     编程表现
3.xml的历史
4.xml的语法 
   验证一个xml是否正确：
	在ie中打开看是否显示正常(语法结构上的错误)
	用程序来验证
	工具xmlspy
   xml的文档结构
	从xml文档声明开始 
        <?xml version="1.0" encoding="ISO-8859-7" standalone="no"?> 
    xml的元素组成数据 
    xls
        <?xml-stylesheet href="*.xsl" type="text/xsl"?xml>
    CDATA(格式化的数据)
	注释 
        <!-- 注释的内容 -->
	xml处理程序显示
    属性必须"";括号必须配对
   语法
      空格的处理： 
         <name>
             历史的天空
         </name>
         <name>
               历史的天空  
         </name>
         <poem xml:space="preserve">
                           老婆
                     可爱的老婆
             在吃菠萝的可爱老婆
         </poem>
       空元素的处理
         <name>  </name> 
         <name/>
      文档的声明
         <?xml version="1.0" encoding="ISO-8859-1" standalone="no"?>
         <?xml-stylesheet href="**.css" type="text/css"?>
         <?xml-stylesheet href="**.xsl" type="text/xsl"?>
      命名空间的问题
         <?xml version="1.0" encoding="ISO-8859-1" standalone="no"?>
         <policeman>
             <!--命名空间的使用-->
             xmlns:o="com.lord.o.dtd"
             xmlns:x="com.lord.x.dtd"
             <o:name>老婆</o:n>
             <x:crimanal>
                 <x:name>坏蛋</x:name>
             </x:crimanal>
         </policeman>
         属性和元素的选取：比较重要的元素，多行，含有子元素的设置为元素，辅助性的说明等用属性
5.xsl基础
  extensible stylesheet language
  作用：xml-->html xsl-->xsl  xml--->xml(企业数据交换)
  例子：
  数据层
<?xml version="1.0" encoding="GB2312"?>
<?xml-stylesheet type="text/xsl" href="icecream_search.xsl"?>
<icecream_shop>
    <name>西直门全全全冰激凌专营店</name>
    <icecream>
        <货号>00134679</货号>
        <品名>吃了必吐</品名>
        <价格>75.00</价格>
        <描述页 网址="http://www.icecream.com/ouou.html">详细了解请到这里</描述页>
    </icecream>
    <icecream>
        <货号>00258423</货号>
        <品名>吐了再吃</品名>
        <价格>40.00</价格>
        <描述页 网址="http://www.icecream.com/etet.html">详细了解请到这里</描述页>
    </icecream>
</icecream_shop>
显示样式表层
<?xml version="1.0" encoding="gb2312"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/TR/WD-xsl">
    <xsl:template match="/">
    	<html>
    	    <head><title>结果</title></head>
    	    <body>
    	        <div align="center"><p>冰激凌</p></div>
    	        <div align="center"><p>
    	            <xsl:value-of select="*/name"/><!--显示所有根节点/下name节点的属性-->
    	        </p></div>
    	    <xsl:apply-templates select="icecream_shop"/><!--调用一个已经设置好了的样式表 select参数为样式表的匹配对象-->
    	    </body>
    	</html>
    </xsl:template>
    
    <xsl:template match="icecream_shop">
        <p align="center">
        <table border="1">
            <tr>
                <td>货号</td>
    	        <td>品名</td>
    	        <td>价格</td>
    	        <td>描述页</td>
            </tr>
            <xsl:for-each select="icecream">
                <tr>
                    <td><xsl:value-of select="货号"/></td>
                    <td><xsl:value-of select="品名"/></td>
                    <td><xsl:value-of select="价格"/></td>
                    <td>
                        <a>
                            <xsl:attribute name="href">
                                <xsl:value-of select="描述页/@网址"/>
                            </xsl:attribute>
                            <xsl:value-of select="描述页"/>
                        </a>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
        </p>
    </xsl:template>

</xsl:stylesheet>
流程控制语句：
 <xsl:if id="">
     function
 </xsl:if>
 <xsl:choose>
     <xsl:when test="id[text()='1']"/><!--如果xml存储的数据中<id>属性为1，则。。-->
     <xsl:otherwise.../>
 </xsl:choose>
 <xsl:for-each select="">
     
 </xsl:for-each>
 例子：
 <xsl:when test="id[text()='1']">
     <font color="red">
         <td>
             <xsl:value-of select="货号"/>
         </td>
     </font>
 </xsl:when>
 访问节点的xpath1方法：
 *现节点下所有元素
 */element现节点下所有element元素
 @property 属性值
 @/element 所有属于现节点的属性值
 .现节点
 ..上级节点
6.DTD&Schema                    
DTD语法： 本身语法怪异，不支持数据类型，没有提供DTD接口
例子：<!--规定xml严格的格式--> 
<!ELEMENT 丛书(书*)><!--元素名为丛书 子元素为书，可以出现0到多次-->
   <!ELEMENT 书(名，人+，价*)> <!--子元素的属性 名只能出现一次 人可以出现1到多次 价可以出现0到多次-->
      <!ELEMENT 名(#PCDATA)>
      <!ELEMENT 人(#PCDATA)>
      <!ELEMENT 价(#PCDATA)>
         <!ATTLIST 价 unit(人民币|￥)'￥'><!--可以选择的属性值，默认为''-->
SCHEMA
 例子
 <xs:schema xmlns:xs="">
     <xs:element name="" type=""/>
 </xs:schema>
 <?xml version="1.0" encoding="gb2312"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
	<xs:element name="丛书">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="书">
					<xs:element name="名"  minoccurs="1"></xs:element>
					<xs:element name="人"></xs:element>
					<xs:element name="价">
						<xs:attribute name="unit">
							<xs:enumeration value="RMB"/>
							<xs:enumeration value="美元"/>
							<xs:enumeration value="日元"/>
						</xs:attribute>
					</xs:element>
				</xs:element>
		</xs:sequence>
		</xs:complexType>
	</xs:element>
</xs:schema>
7.程序分析模型
两种xml分析模型
  dom 所有数据位于内存
  sax 流程性分析，不必载入内存，可分析大型xml文件
  JDOM(优点是简单)
  例子：
  1.配置xml属性文件
  <?xml version="1.0" encoding="gb2312"?> 
  <sys-config>
      <jdbc-info>
          <driver-class-name>
              oracle.jdbc.driver.OracleDriver
          </driver-class-name>
          <url>
              jdbc:oracle:thin@192.168.1.2:1521:lord
          </url>
          <user-name>
              root
          </user-name>
          <user-password>
              laopo
          </user-password>
      </jdbc-info>
      <beans>
          <bean id="" class=""/>
          <bean id="" class=""/>
      </beans>
  </sys-config>
  2.项目中添加 jdom的Jar文件
  jdom\lib\*.jar
  jdom\bulid\jdom.jar
  3.写一个class类来读取xml中的配置信息
package cn.lord.xml;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
public class GlobalConfigure
{
private static GlobalConfigure instance = new GlobalConfigure();//单态模式
    private static final String CONFIG = "GlobalConfigure.xml";
    private Element rootElement;//存储读取的节点元素
    private JdbcInfo jdbcinfo = new JdbcInfo();//引用存储读取数据对象的类
    private GlobalConfigure()//构造函数
    {
    SAXBuilder sb = new SAXBuilder();//用Jdom包中的org.jdom.input.SAXBuilder类
        try {
        Document doc = sb.build(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG));//通过SAXBuilder对象sb来构造一个Document对象
        rootElement = doc.getRootElement();//读取Document对象的元素
        initJDBCInfo();//调用初始化数据，获取xml中数据，并储存到指定数据存储类对象中的方法
        } catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public static GlobalConfigure getInstance()//单态模式
    {
        return instance;
    }
    public void initJDBCInfo()
    {
    	try {
    		Element driverClassNameElt = (Element) XPath.selectSingleNode(rootElement,"//sys-config/jdbc-info/driver-class-name");//调用jdom中的XPath对象的选择单态模式方法selectSingleNode(),参数为获取的节点和要读取的节点的路径
    		Element urlElt = (Element) XPath.selectSingleNode(rootElement,"//sys-config/jdbc-info/url");
    		Element usernameElt = (Element) XPath.selectSingleNode(rootElement,"//sys-config/jdbc-info/user-name");
    		Element userpasswordElt = (Element) XPath.selectSingleNode(rootElement,"//sys-config/jdbc-info/user-password");
		    jdbcinfo.setDriverClassName(driverClassNameElt.getText());//将读取到的节点转换为string并存储到数据存储对象中
		    jdbcinfo.setUrl(urlElt.getText());
		    jdbcinfo.setUsername(usernameElt.getText());
		    jdbcinfo.setUserpassword(userpasswordElt.getText());
    	} catch (JDOMException e) {
			e.printStackTrace();
		}
    }
    public static void main(String[] args)
    {	
    	System.out.println(GlobalConfigure.getInstance().jdbcinfo);
    }
	public JdbcInfo getJdbcinfo() {
		return jdbcinfo ;
	}
}
存储读取信息的对象类
package cn.lord.xml;

public class JdbcInfo {
    private String driverClassName;
    private String url;
    private String username;
    private String userpassword;
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String toString()//重写toString()后可以直接打印该对象
	{
		return "driver="+driverClassName+" url="+url+",username="+username+" userpassword="+userpassword;
	}

}
例子2:读取一个内置bean的方法
<?xml version="1.0" encoding="gb2312"?> 
  <sys-config>
      <beans>
          <bean id="cn.lord.com.Itermdao" class="cn.lord.com.id1.class1"/>//在xml中定义好bean的id和类名
          <bean id="cn.lord.com.id1" class="cn.lord.com.id2.class2"/>
      </beans>
      </beans>
  </sys-config>
读取xml的类
package cn.lord.xml;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
public class GlobalConfigure
{
    private static GlobalConfigure instance = new GlobalConfigure();
    private static final String CONFIG = "GlobalConfigure.xml";
    private Element rootElement;
    private JdbcInfo jdbcinfo = new JdbcInfo();
    private Map beanMap = new HashMap();//用一个HashMap类对象来存储bean对象(id,class)
    private GlobalConfigure()
    {
        SAXBuilder sb = new SAXBuilder();
        try {
			Document doc = sb.build(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG));
	        rootElement = doc.getRootElement();
	        initBeans();//初始化initBeans()方法
	        initJDBCInfo();
        } catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public static GlobalConfigure getInstance()
    {
        return instance;
    }
    public void initJDBCInfo()
    {
    	try {
    		Element driverClassNameElt = (Element) XPath.selectSingleNode(rootElement,"//sys-config/jdbc-info/driver-class-name");
    		Element urlElt = (Element) XPath.selectSingleNode(rootElement,"//sys-config/jdbc-info/url");
    		Element usernameElt = (Element) XPath.selectSingleNode(rootElement,"//sys-config/jdbc-info/user-name");
    		Element userpasswordElt = (Element) XPath.selectSingleNode(rootElement,"//sys-config/jdbc-info/user-password");
		    jdbcinfo.setDriverClassName(driverClassNameElt.getText());
		    jdbcinfo.setUrl(urlElt.getText());
		    jdbcinfo.setUsername(usernameElt.getText());
		    jdbcinfo.setUserpassword(userpasswordElt.getText());
    	} catch (JDOMException e) {
			e.printStackTrace();
		}
    }
    public void initBeans()
    {
    	try {
			List idList = (List) XPath.selectNodes(rootElement, "//sys-config/beans/bean");//bean含有多个属性，所有必需用selectNodes方法，用List对象来存储
			for(Iterator iter = idList.iterator();iter.hasNext();)//将得到的List对象用Iterator对象封装
			{
				Element beanElt = (Element) iter.next();//将取得的Iterator对象用Element对象封装
				String id = beanElt.getAttributeValue("id");//从Element对象中取得id
				jdbcinfo.setId(id);//将取的id添加到数据存储对象JdbcInfo中
				String className = beanElt.getAttributeValue("class");
				jdbcinfo.setClassName(className);
				Object object = Class.forName(className).newInstance();//获取名为className的类
				beanMap.put(id, object);//将其添加到HashMap对象中
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String[] args)
    {	
    	System.out.println(GlobalConfigure.getInstance().jdbcinfo);
    	ItemDao intemdao = (ItemDao)GlobalConfigure.getInstance().getBean(ItemDao.class);//获取一个xml中内置bean的方法
    }
	public JdbcInfo getJdbcinfo() {
		return jdbcinfo ;
	}
	public Object getBean(Class c)//取得一个指定类名的类
	{
		return beanMap.get(c.getName());
    	}
}


