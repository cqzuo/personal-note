无法加载MYSQL驱动器！   我只能用JDBC-ODBC桥来和微软的SERV   2000通数据。例：  
      String   sDBDriver   =   "sun.jdbc.odbc.JdbcOdbcDriver";  
      Class.forName(sDBDriver);  
  但却无法和MYSQL同信：  
      String   driver ="org.git.mm.mysql.Driver";  
      Class.forName(driver);  
  还有如何选择数据库：  
      String   url ="jdbc:mysql://localhost:3306/web";  
  正确吗？  
  问题点数：20、回复次数：3Top
1 楼hbzyduwu（^-^鞋带又松了~-~）回复于 2004-07-11 20:08:20 得分 10

第一步:把你的mm.mysql-2.0.4-bin.jar文件拷到tomcat\common\lib下.  
  第二步:改一下程序  
  Class.forName("org.gjt.mm.mysql.Driver").newInstance();      
  String   url   ="jdbc:mysql://localhost/bbscs5?user=用户名&password=密码&useUnicode=true&characterEncoding=UTF-8";  
  Connection   conn=DriverManager.getConnection(url);  
  //...........Top
2 楼Jaogoy（想你）回复于 2004-07-11 20:30:25 得分 0

mm.mysql-2.0.4-bin.jar文件,到底是在什么文件夹下的，我的MYSQL是3。0版的Top
3 楼hbzyduwu（^-^鞋带又松了~-~）回复于 2004-07-11 21:47:29 得分 10

mm.mysql-2.0.4-bin.jar是mysql的驱动,去mysql.com找.
jsp 学习文档:JDBC接口技术;常用数据库连接方法;struts国际化+mysql中文乱码的问题
JDBC接口技术
JDBC是一种可用于执行SQL语句的JavaAPI（ApplicationProgrammingInterface应用程序设计接口）。它由一些 Java语言编写的类和界面组成。JDBC为数据库应用开发人员、数据库前台工具开发人员提供了一种标准的应用程序设计接口，使开发人员可以用纯Java 语言编写完整的数据库应用程序。

一、ODBC到JDBC的发展历程

说到JDBC，很容易让人联想到另一个十分熟悉的字眼“ODBC”。它们之间有没有联系呢？如果有，那么它们之间又是怎样的关系呢？

ODBC是OpenDatabaseConnectivity的英文简写。它是一种用来在相关或不相关的数据库管理系统（DBMS）中存取数据的，用C语言实现的，标准应用程序数据接口。通过ODBCAPI，应用程序可以存取保存在多种不同数据库管理系统（DBMS）中的数据，而不论每个DBMS使用了何种数据存储格式和编程接口。

1．ODBC的结构模型

ODBC的结构包括四个主要部分：应用程序接口、驱动器管理器、数据库驱动器和数据源。

应用程序接口：屏蔽不同的ODBC数据库驱动器之间函数调用的差别，为用户提供统一的SQL编程接口。

驱动器管理器：为应用程序装载数据库驱动器。

数据库驱动器：实现ODBC的函数调用，提供对特定数据源的SQL请求。如果需要，数据库驱动器将修改应用程序的请求，使得请求符合相关的DBMS所支持的文法。

数据源：由用户想要存取的数据以及与它相关的操作系统、DBMS和用于访问DBMS的网络平台组成。

虽然ODBC驱动器管理器的主要目的是加载数据库驱动器，以便ODBC函数调用，但是数据库驱动器本身也执行ODBC函数调用，并与数据库相互配合。因此当应用系统发出调用与数据源进行连接时，数据库驱动器能管理通信协议。当建立起与数据源的连接时，数据库驱动器便能处理应用系统向DBMS发出的请求，对分析或发自数据源的设计进行必要的翻译，并将结果返回给应用系统。

2．JDBC的诞生

自从Java语言于1995年5月正式公布以来，Java风靡全球。出现大量的用java语言编写的程序，其中也包括数据库应用程序。由于没有一个 Java语言的API，编程人员不得不在Java程序中加入C语言的ODBC函数调用。这就使很多Java的优秀特性无法充分发挥，比如平台无关性、面向对象特性等。随着越来越多的编程人员对Java语言的日益喜爱，越来越多的公司在Java程序开发上投入的精力日益增加，对java语言接口的访问数据库的API的要求越来越强烈。也由于ODBC的有其不足之处，比如它并不容易使用，没有面向对象的特性等等，SUN公司决定开发一Java语言为接口的数据库应用程序开发接口。在JDK1．x版本中，JDBC只是一个可选部件，到了JDK1．1公布时，SQL类包（也就是JDBCAPI）就成为Java语言的标准部件。

二、JDBC技术概述

JDBC是一种可用于执行SQL语句的JavaAPI（ApplicationProgrammingInterface，应用程序设计接口）。它由一些 Java语言写的类、界面组成。JDBC给数据库应用开发人员、数据库前台工具开发人员提供了一种标准的应用程序设计接口，使开发人员可以用纯Java语言编写完整的数据库应用程序。

通过使用JDBC，开发人员可以很方便地将SQL语句传送给几乎任何一种数据库。也就是说，开发人员可以不必写一个程序访问Sybase，写另一个程序访问Oracle，再写一个程序访问Microsoft的SQLServer。用JDBC写的程序能够自动地将SQL语句传送给相应的数据库管理系统（DBMS）。不但如此，使用Java编写的应用程序可以在任何支持Java的平台上运行，不必在不同的平台上编写不同的应用。Java和JDBC的结合可以让开发人员在开发数据库应用时真正实现“WriteOnce，RunEverywhere！”

Java具有健壮、安全、易用等特性，而且支持自动网上下载，本质上是一种很好的数据库应用的编程语言。它所需要的是Java应用如何同各种各样的数据库连接，JDBC正是实现这种连接的关键。

JDBC扩展了Java的能力，如使用Java和JDBCAPI就可以公布一个Web页，页中带有能访问远端数据库的Applet。或者企业可以通过 JDBC让全部的职工（他们可以使用不同的操作系统，如Windwos，Machintosh和UNIX）在Intranet上连接到几个全球数据库上，而这几个全球数据库可以是不相同的。随着越来越多的程序开发人员使用Java语言，对Java访问数据库易操作性的需求越来越强烈。

MIS管理人员喜欢Java和JDBC，因为这样可以更容易经济地公布信息。各种已经安装在数据库中的事务处理都将继续正常运行，甚至这些事务处理是存储在不同的数据库管理系统中；而对新的数据库应用来说，开发时间将缩短，安装和版本升级将大大简化。程序员可以编写或改写一个程序，然后将它放在服务器上，而每个用户都可以访问服务器得到最新的版本。对于信息服务行业，Java和JDBC提供了一种很好的向外界用户更新信息的方法。

1．JDBC的任务

简单地说，JDBC能完成下列三件事：

1）同一个数据库建立连接；

2）向数据库发送SQL语句；

3）处理数据库返回的结果。

2．JDBC—一种底层的API

JDBC是一种底层API，这意味着它将直接调用SQL命令。JDBC完全胜任这个任务，而且比其他数据库互联更加容易实现。同时它也是构造高层API和数据库开发工具的基础。高层API和数据库开发工具应该是用户界面更加友好，使用更加方便，更易于理解的。但所有这样的API将最终被翻译为象JDBC这样的底层API。目前两种基于JDBC的高层API正处在开发阶段。

1）SQL语言嵌入Java的预处理器。虽然DBMS已经实现了SQL查询，但JDBC要求SQL语句被当作字符串参数传送给Java程序。而嵌入式 SQL预处理器允许程序员将SQL语句混用：Java变量可以在SQL语句中使用，来接收或提供数值。然后SQL的预处理器将把这种Java／SQL混用的程序翻译成带有JDBCAPI的Java程序。

2）实现从关系数据库到Java类的直接映射。Javasoft和其他公司已经宣布要实现这一技术。在这种“对象／关系”映射中，表的每一行都将变成这类的一个实例，每一列的值对应实例的一个属性。程序员可以直接操作Java的对象；而存取所需要的SQL调用将在内部直接产生。还可以实现更加复杂的映射，比如多张表的行在一个Java的类中实现。

随着大家对JDBC兴趣的不断浓厚，越来越多的开发人员已经开始利用JDBC为基础的工具进行开发。这使开发工作变得容易。同时，程序员也正在开发对最终用户来说访问数据库更加容易的应用程序。

3．JDBC和ODBC及其他API的比较

到目前为止，微软的ODBC可能是用得最广泛的访问关系数据库的API。它提供了连接几乎任何一种平台、任何一种数据库的能力。那么，为什么不直接从Java中直接使用ODBC呢？

回答是可以从Java中使用ODBC，但最好在JDBC的协助下，用JDBC－ODBC桥接器实现。那么，为什么需要JDBC呢？要回答这个问题，有这么几个方面：

1）ODBC并不适合在Java中直接使用。ODBC是一个C语言实现的API，从Java程序调用本地的C程序会带来一系列类似安全性、完整性、健壮性的缺点。

2）其次，完全精确地实现从C代码ODBC到JavaAPI写的ODBC的翻译也并不令人满意。比如，Java没有指针，而ODBC中大量地使用了指针，包括极易出错的空指针“void＊”。因此，对Java程序员来说，把JDBC设想成将ODBC转换成面向对象的API是很自然的。

3）ODBC并不容易学习，它将简单特性和复杂特性混杂在一起，甚至对非常简单的查询都有复杂的选项。而JDBC刚好相反，它保持了简单事物的简单性，但又允许复杂的特性。

4）JDBC这样的JavaAPI对于纯Java方案来说是必须的。当使用ODBC时，人们必须在每一台客户机上安装ODBC驱动器和驱动管理器。如果 JDBC驱动器是完全用Java语言实现的话，那么JDBC的代码就可以自动的下载和安装，并保证其安全性，而且，这将适应任何Java平台，从网络计算机NC到大型主机Mainframe。

总而言之，JDBCAPI是能体现SQL最基本抽象概念的、最直接的Java接口。它建构在ODBC的基础上，因此，熟悉ODBC的程序员将发现学习 JDBC非常容易。JDBC保持了ODBC的基本设计特征。实际上，这两种接口都是基于X／OPENSQL的调用级接口（CLI）。它们的最大的不同是 JDBC是基于Java的风格和优点，并强化了Java的风格和优点。

最近，微软又推出了除了ODBC以外的新的API，如RDO，ADO和OLEDB。这些API事实上在很多方面上同JDBC一样朝着相同的方向努力，也就是努力成为一个面向对象的，基于ODBC的类接口。然而，这些接口目前并不能代替ODBC，尤其在ODBC驱动器已经在市场完全形成的时候，更重要的是它们只是ODBC的“漂亮的包装”。

4．JDBC两层模型和三层模型

JDBC支持两层模型，也支持三层模型访问数据库。

如图3所示，两层模型中，一个java Appple或者一个JA－va应用直接同数据库连接。这就需要能直接被访问的数据库进行连接的JDBC驱动器。用户的SQL语句被传送给数据库，而这些语句执行的结果将被传回给用户。数据库可以在同一机器上，也可以另一机器上通过网络进行连接。这被称为“Client/Server”结构，用户的计算机作为Client,运行数据库的计算机作为Server。这个网络可是intranet，比如连接全体雇员的企业内部网，当然也可以是internet。

如图4所示，在三层模型中，命令将被发送到服务的“中间层”，而“中间层”将SQL语句发送到数据库。数据库处理SQL语句并将结果返回“中间层”，然后 “中间层”将它们返回用户。MIS管理员将发现三层模型很有吸引力，因为“中间层”可以进行对访问的控制并协同数据库的更新，另一个优势就是如果有一个“中间层”用户就可以使用一个易用的高层的API，这个API可以由“中间层”进行转换，转换成底层的调用。而且，在许多情况下，三层模型可以提供更好的性能。

到目前为止，“中间层”通常还是用C或C++实现，以保证其高性能。但随着优化编译器的引入，将java的字节码转换成高效的机器码，用java来实现“中间层”将越来越实际。而JDBC是允许从一个java“中间层”访问数据库的关键。

常用数据库连接方法
1. MySQL(http://www.mysql.com)mm.mysql-2.0.2-bin.jar
Class.forName( "org.gjt.mm.mysql.Driver" );
cn = DriverManager.getConnection( "jdbc:mysql://MyDbComputerNameOrIP:3306/myDatabaseName", sUsr, sPwd );

2. PostgreSQL(http://www.de.postgresql.org)pgjdbc2.jar
Class.forName( "org.postgresql.Driver" );
cn = DriverManager.getConnection( "jdbc:postgresql://MyDbComputerNameOrIP/myDatabaseName", sUsr, sPwd );

3. Oracle(http://www.oracle.com/ip/deploy/database/oracle9i/)classes12.zip
Class.forName( "oracle.jdbc.driver.OracleDriver" );
cn = DriverManager.getConnection( "jdbc:oracle:thin:@MyDbComputerNameOrIP:1521:ORCL", sUsr, sPwd );

4. Sybase(http://jtds.sourceforge.net)jconn2.jar
Class.forName( "com.sybase.jdbc2.jdbc.SybDriver" );
cn = DriverManager.getConnection( "jdbc:sybase:Tds:MyDbComputerNameOrIP:2638", sUsr, sPwd );
//(Default-Username/Password: "dba"/"sql")

5. Microsoft SQLServer(http://jtds.sourceforge.net)
Class.forName( "net.sourceforge.jtds.jdbc.Driver" );
cn = DriverManager.getConnection( "jdbc:jtds:sqlserver://MyDbComputerNameOrIP:1433/master", sUsr, sPwd );

6. Microsoft SQLServer(http://www.microsoft.com)
Class.forName( "com.microsoft.jdbc.sqlserver.SQLServerDriver" );
cn = DriverManager.getConnection( "jdbc:microsoft:sqlserver://MyDbComputerNameOrIP:1433;databaseName=master", sUsr, sPwd );

7. ODBC
Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
Connection cn = DriverManager.getConnection( "jdbc:odbc:" + sDsn, sUsr, sPwd );

8.DB2
Class.forName("com.ibm.db2.jdbc.net.DB2Driver");
String url="jdbc:db2://192.9.200.108:6789/SAMPLE"
cn = DriverManager.getConnection( url, sUsr, sPwd );
各家JDBC driver的現行版本及使用語法 ver.20030611

http://www.javaworld.com.tw/jute/post/view?bid=21&id=366&sty=3&age=0&tpg=1&ppg=1#366
各家JDBC driver的現行版本及使用語法 ver.20030611


有鑒於許多版友對於尋找JDBC driver或者如何使用driver常常發問,
在這邊我簡單整理一下比較代表性的driver跟使用方式.

Microsoft SQL Server series (6.5, 7.x and 2000) and Sybase 10

JDBC Name: jTDS
URL: http://jtds.sourceforge.net/
Version: 0.5.1
Download URL: http://sourceforge.net/project/showfiles.php?group_id=33291

語法:


Class.forName("net.sourceforge.jtds.jdbc.Driver ");Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://host:port/database","user","password");orConnection con = DriverManager.getConnection("jdbc:jtds:sybase://host:port/database","user","password");


MySQL

JDBC Name: Connector/J 3.0
URL: http://www.mysql.com/
Version: 3.0.8-stable
Download URL: http://www.mysql.com/downloads/api-jdbc-stable.html

語法:


Class.forName("com.mysql.jdbc.Driver");Connection con = DriverManager.getConnection("jdbc:mysql://host:port/database","user","password");


Oracle

JDBC Name: Connector/J 3.0
URL: http://otn.oracle.com/
Version: 3.0.8-stable
Download URL: http://otn.oracle.com/software/tech/java/sqlj_jdbc/content.html

語法:


Class.forName("oracle.jdbc.driver.OracleDriver");Connection con = DriverManager.getConnection("jdbc:oracle:thin:@host:port:databse","user","password");


Sybase

Driver: jConnect 4.5/5.5 (JDBC 2.0 請使用5.5)

語法:

Class.forName ("com.sybase.jdbc2.jdbc.SybDriver").newInstance();Connection con = DriverManager.getConnection ("jdbc:sybase:Tds:[IP位址或機器名稱]:2638?ServiceName=資料庫名稱","帳號","密碼");


Postgresql

JDBC Name: PostgreSQL JDBC
URL: http://jdbc.postgresql.org/
Version: 7.3.3 build 110
Download URL: http://jdbc.postgresql.org/download.html

語法:


Class.forName("org.postgresql.Driver"); Connection con=DriverManager.getConnection("jdbc:postgresql://host:port/database","user","password");


Informix

Driver：com.informix.jdbc.IfxDriver

語法：


Class.forName("com.informix.jdbc.IfxDriver");String full_db="jdbc:informix-sqli://10.14.86.11:300/authority: INFORMIXSERVER=ifx9;user=informix;password=informix;NEWLOCALE=en_us,zh_tw;NEWCODESET=Big5,8859-1,819;";con =DriverManager.getConnection(full_db);


IBM AS400主機在用的JDBC語法

有裝V4R4以上版本的Client Access Express
可以在C:\Program Files\IBM\Client Access\jt400\lib
找到 driver 檔案 jt400.zip，並更改副檔名成為 jt400.jar

語法

java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ());Class.forName("com.ibm.as400.access.AS400JDBCConnection");con = DriverManager.getConnection("jdbc:as400://IP","user","password");

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
其他資訊:

* 尋找查詢JDBC Driver的地方: http://servlet.java.sun.com/products/jdbc/drivers

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
通常driver都已包成jar檔
將jar設定在CLASSPATH中,或者如果是寫JSP,Servel可以將這些jar放到
使用的container中的lib資料夾底下
詳細內容就請大家自行去各家網站看看介紹
有很多文件可以看


struts国际化+mysql中文乱码的问题

花了三个多小时解决的struts国际化+mysql中文乱码的问题
动力：都是这个很多字段数据表惹的祸，本来大概3个星期前就决定在代码里硬编码处理(那时折腾了前前后后近30小时)，现在节约了很多时间哦。。。。爽。。。。。休息下，晚上继续

浏览器  默认以UTF-8发送请求
数据库  一般是ISO-8859-1  useUnicode=true&amp;characterEncoding=GBK可以同一编码
tomcat编译jsp   是ISO-8859-1

做法：
jsp：<%@ page contentType="text/html;charset=UTF-8" language="java"%>
数据库：jdbc:mysql://127.0.0.1:3306/edusys?useUnicode=true&amp;characterEncoding=GBK

现象：
1.数据库里是中文也能显示成中文 --是什么样就显示成什么样，说明useUnicode=true&amp;characterEncoding=GBK有起到同一编码的作用，所以应该是从html到jsp编译成的servlet之间出问题了
2.如果在java代码里加入：
类似于这样的：String sort = new String(user.getSort().getBytes("ISO-8859-1"),"UTF-8");
操作数据库就没问题了

3.换成<%@ page contentType="text/html;charset=ISO-8859-1" language="java"%>问题就变成存入数据库的是些byte 码，读出到页面上不会乱码

结论：
1。用native2ascii -encoding gb2312 User_zh_CN.bak User_zh_CN.properties处理的目的是可以同一用UTF-8来编码jsp页面
2。只要在交给业务逻辑代码处理前把编码设置成UTF-8（而不是GB2312!!!! 原来就错在这里，那时没理解透）就可以了

用到了filter,相应到网上搜下一打把.
  <filter>
<filter-name>CharacterEncoding</filter-name>
<filter-class>com.lpeng.webapp.base.EncodingFilter</filter-class>
<init-param>
   <param-name>encoding</param-name>
   <param-value>UTF-8</param-value>
</init-param>
  </filter>
  <filter-mapping>
<filter-name>CharacterEncoding</filter-name>
<url-pattern>/*</url-pattern>
  </filter-mapping>
5:11 PM | Add a com