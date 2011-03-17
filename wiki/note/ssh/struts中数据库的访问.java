［访问一个数据库］

在一个其于struts的应用系统的设计过程中，最好能在web/表示层（presentation layer）和你的商务逻辑类（包含所有数据访问操作的层）的中间，定义一个action类，作为小型的适配器（thin adapter）。

所以，你可以先定义一些商务api（business api），这些api就是简单的java类。你可以传递一些参数给这些对象，并从这些对象返回一个java bean或者java bean的集合。这个action类负责调用这些对象，并把它们返回的值传递给web/表示层。

通常，你可以为每一个你需要调用的商务方法/商务类api创建一个action类。理想情况下，所有的数据库访问代码都被封装进了这些商务api类里，所以struts并不知道你正在使用的持久层（persistent layer）（甚至都不知道你使用了持久层）。它只需要传递一个主键（key）或者一个查询参数，然后处理返回的结果bean或者bean集合。这样，你就可以在其他的应用环境里复用这些商务api类，你还可以对这些独立于struts或http环境的商务api进行单体测试。

开始的时候，最简单的方法就是设计一个1:1的方案，为你的每一个商务api入口（entry-point）定义一个action类。当你的经验丰富了以后，你也可以使用dispatchaction组合这些action类。你甚至可以定义一个简单的"框架"action，用来调用所有的这些商务类。你可以在 contrib目录里找到scaffold设计的processaction，这是一个"框架"action的完整实现。使用这种方案可以使用更少的 action类，但你必须对struts和mvc框架的底层实现有较深的理解。不要害怕在开始的时候定义过多的action，struts的配置方案可以给予你充分的自由在以后重构你的设计，因为你可以灵活的改变你的action类，而不会对应用程序造成影响。

在理想情况下，商务逻辑层（business logic layer）应该封装所有的数据访问细节，包括数据库连接的获得。但是，一些应用程序的设计要求调用者可以从一个datasource对象来获得数据库连接。遇到这种情况时，struts datasource管理器可以使你在需要的时候配置这些datasource资源。

struts datasource管理器在struts配置文件（struts-config.xml）里定义。这个管理器可以用来分发和配置任何实现了 javax.sql.datasource接口的数据库连接池（connection pool）。如果你的dbms或者容器内置了符合这些要求的连接池，你可以优先选用它。


［jakarta的公共连接池实现 - basicdatasource］

如果你的手头没有连接池的本地（native）实现，你可以使用jakarta提供的公共连接池实现 [org.apache.commons.dbcp.basicdatasource]，它可以和datasource管理器"合作"的很好。另外， struts还在它的util包里包含了一个genericdatasource类，这也是一个连接池实现。但是这只是一个非常简单的实现方案，不推荐使用，因为它可能在struts的以后版本中被basicdatasource或其它的数据源实现替换掉。

下面是一段struts-config.xml配置文件中的数据源配置（使用genericdatasource数据源实现），你可以更改相应的设置以适合你自己的系统。


<!-- configuration for genericdatasource wrapper -->
<data-sources>
<data-source>
<set-property
property="autocommit"
value="false"/>
<set-property
property="description"
value="example data source configuration"/>
<set-property
property="driverclass"
value="org.postgresql.driver"/>
<set-property
property="maxcount"
value="4"/>
<set-property
property="mincount"
value="2"/>
<set-property
property="password"
value="mypassword"/>
<set-property
property="url"
value="jdbc:postgresql://localhost/mydatabase"/>
<set-property
property="user"
value="myusername"/>
</data-source>
</data-sources>

使用basicdatasource数据源实现的配置方案如下：

<data-sources>
<!-- configuration for commons basicdatasource -->
<data-source type="org.apache.commons.dbcp.basicdatasource">
<set-property
property="driverclassname"
value="org.postgresql.driver" />
<set-property
property="url"
value="jdbc:postgresql://localhost/mydatabase" />
<set-property
property="username"
value="me" />
<set-property
property="password"
value="test" />
<set-property
property="maxactive"
value="10" />
<set-property
property="maxwait"
value="5000" />
<set-property
property="defaultautocommit"
value="false" />
<set-property
property="defaultreadonly"
value="false" />
<set-property
property="validationquery"
value="select count(*) from market" />
</data-source>
</data-sources>

注意，你可以在你的应用系统中定义不止一个数据源，你可以根据需要定义多个数据源，并为它们分别起一个逻辑名（logical name）。这样做可以给你的应用系统提供更好的安全性和可测量性（scalability），你还可以定义一个专用于测试的数据源。

配置好datasource以后，你就可以在你的应用系统中使用这些数据源了。下面这段代码演示了怎样在action类的execute方法中通过这些数据源来生成数据库连接。

public actionforward execute(
actionmapping mapping,
actionform form,
httpservletrequest request,
httpservletresponse response)
throws exception
{
datasource datasource;
connection cnn;

try
{
datasource = getdatasource(request);
cnn = datasource.getconnection();
// 数据连接已经建立了，你可以做你想做的事情了
}
catch (sqlexception e)
{
getservlet().log("处理数据库连接", e);
}
finally
{
// 在finally块里包含这些代码
// 用以保证连接最后会被关闭
try
{
cnn.close();
}
catch (sqlexception e)
{
getservlet().log("关闭数据库连接", e);
}
}
}

注意：如果你使用公共的basicdatasource，你提供给pingquery属性的查询语句（如果你设置了话）必须至少要能返回一行记录。

例子：select count(*) from validtable

你可以把validtable替换成你的数据库中包含的任何有效的表。

［使用多个数据源］

如果你需要在模块（module）中使用多于一个的数据源，你可以在配置文件的<data-source>元素里包含一个key属性。

<data-source>
<data-source key="a" type="org.apache.commons.dbcp.basicdatasource">
…属性配置略, 同上…
</data-source>
<data-source key="b" type="org.apache.commons.dbcp.basicdatasource">
…属性配置略, 同上…
</data-source>
</data-source>

你代码里，你可以通过这些key获得不同的数据源。代码如下：

…
try
{
datasourcea = getdatasource(request, "a");
datasourceb = getdatasource(request, "b");
…

你可以根据需要为每一个模块设置多个数据源。但同一模块里每个数据源的key属性必须唯一，因为struts模块系统是以每一个模块为单位管理命名空间的。

大多数的数据库查询结果都会跟你的已经使用的actionforms一一对应，你只需要把你的查询结果集合提交给相应的actionform就可以了。但有时候，结果集（resultset）里有些字段并不是actionform的属性，或者更糟。

幸运的是，struts的自定义标签集并不关心你传递给他们的bean类型。你甚至可以直接输出结果集。但是由于结果集会一直保持着与数据库的连接，并且由于它们把所有的数据都直接传递给了jsp，使得页面变得零乱不堪。那么我们该怎么做呢？

从struts 1.1开始，你可以使用新增加的resultsetdynaclass来把你的结果集转换成一个dynabeans的arraylist。struts自定义标签集可以像一般的javabean一样使用dynabean的属性。（关于dynaactionform类更详细的信息，请参考struts用户手册）。

resultsetdynaclass类已经包含在于beanutils.jar包中，所以你现在所要做的，只需要拿出这个工具，实现自己的传递方案吧………… 

------------------------------------------------------------------------------------------------------------------------


1.在struts 1.1 中不必设置type(默认为org.apache.struts.util.GenericDataSource)

　　属性就可访问数据库。

　　＜ data-source key="..." ＞

　　＜ set-property property="driverClass" value="..." /＞

　　＜ set-property property="description" value="..." /＞

　　＜ set-property property="url" value="..." /＞

　　＜ /data-source＞

　　//----------------------------------------------------------------------------

　　2. 而在struts 1.2 后一定要指定type属性，一般指定为：org.apache.commons.dbcp ,但问题出现了.很多书籍介绍都是这样配置的.(至少孙妹妹的是这样配置的)

　　< data-source type="org.apache.commons.dbcp.BasicDataSource">

　　< set-property property="driverClass" value="..." />

　　< set-property property="user" value="..." />

　　< set-property property="password" value="..."/>

　　......

　　< /data-source>

　　这样编绎时，会提示找不到合适的驱动，也就是大多数网友提出的问题。

　　其实，在org.apache.commons.dbcp.BasicDataSource中

　　"driverClass"并不是其中的属性值，而是"driverClassName",

　　"user" 也不是其中的属性值，而是"username",改掉这两个关键的东东，你的程序就可以运行起来了。

　　//----------------------------------------------------------------------

