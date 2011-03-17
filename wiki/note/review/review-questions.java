1.Hashtable和HashMap有什么区别？ 
  a.Hashtable是继承自陈旧的Dictionary类的，HashMap继承自AbstractMap类同时是Java 1.2引进的Map接口的一个实现。 
  b.也许最重要的不同是Hashtable的方法是同步的，而HashMap的方法不是。这就意味着， 
    虽然你可以不用采取任何特殊的行为就可以在一个  多线程的应用程序中用一个Hashtable， 
    但你必须同样地为一个HashMap提供外同步。一个方便的方法就是利用Collections类的静态的synchronizedMap()方法， 
    它创建一个线程安全的Map对象，并把它作为一个封装的对象来返回。这个对象的方法可以让你同步访问潜在的HashMap。 
    这么做的结果就是当你不需要同步时，你不能切断Hashtable中的同步（比如在一个单线程的应用程序中）， 
    而且同步增加了很多处理费用。 
  c.第三点不同是，只有HashMap可以让你将空值作为一个表的条目的key或value。 
    HashMap中只有一条记录可以是一个空的key，但任意数量的条目可以是空的value。 
    这就是说，如果在表中没有发现搜索键，或者如果发现了搜索键，但它是一个空的值，那么get()将返回null。 
    如果有必要，用containKey()方法来区别这两种情况。 
  d.HashMap去掉了Hashtable的contains方法，保留了containsValue和containsKey方法  
  e.Hashtable中hash数组默认大小是11，增加的方式是 old*2+1。HashMap中hash数组的默认大小是16，而且一定是2的指数 
2.你怎么理解MVC模式？ 
  MVC是SUN早期提出的model2开发模式,强制的把视图控制和模型层分开 
　不仅实现了功能模块和显示模块的分离，同时它还提高了应用系统的可维护性、可扩展性、可移植性和组件的可复用性 
3.SQLServer中左联接查询用left join，Oracle中用什么？ 
  左连接:select(nvl(a.c,0)-nvl(b.c,0)) from  a,b where a.id(+)=b.id 
  右连接:select(nvl(a.c,0)-nvl(b.c,0)) from  a,b where a.id=b.id(+) 
  自连接:select(nvl(a.c,0)-nvl(b.c,0)) from  a,b where a.id(+)=b.id(+) 
  说明:加号写在左就是左连接,写在右就是右连接,看加号的方法来定 
4.SQLServer中的数据库，在Oracle中对应的是什么？ 
  表空间 
5.如果SQLServer中有两个数据库，那么让你把这两个数据库对应到Oracle中，你应该怎么做？ 
  在Oracle中建一个用户,对应两个表空间 
6.有两个页面a.jsp和b.jsp，要从a.jsp传值到b.jsp有几种方法？分别是什么？ 
  a:最常用的方法是用form中的text, <input type=text name=username value=admin>，然后在b.jsp页面中这样获取 
    String username=request.getParameter("username"); 
  b:直接在Url地址栏里面输入第一个页面的地址，在后加问号，然后把要传的参数及值写在后面，如有多个用&隔开，然后在下一页面用 
    request.getParameter("参数名")来获取，例如：http://localhost:8080/a.jsp?username=admin&password=111 
    在b.jsp中可用这样获取:String username=request.getParameter("username");String username=request.getParameter("password"); 
  c:在form中放hidden，如: <input type=hidden name=username value=admin>，获取方法同上 
  说明：传值的方法有很多种，以上是最常用最简单的几种方式,当然，如果传的值有中文的话，需另做处理 
6.有三个页面，a.jsp,b.jsp和c.jsp,流程是：a.jsp->b.jsp->c.jsp,其中a.jsp中提交的数据要在c.jsp中访问，用最简单的方法  怎么做？注意不能放在session里 
  用隐藏表单域，即在b.jsp页面中用N个hidden把上一页面提交过来的信息保存下来，然后和当前一起提交,再到c.jsp里面获取 
  说明：尽量不要用session和少用session 
7.jsp和servlet有什么区别？ 
  a:servlet是在java代码里面放html,jsp是在html里面放java代码(最后运行的时候服务器会把JSP解析成servlet)  
  b:servlet是一个java类，有自己的映射,而jsp不是 
  说明：区别太多，请参考http://00000000.net.cn/200606/200606097/97681.htm 
8.映射是什么？你怎么理解映射？ 
  映射即别名，通过别名可以访问 
9.Hibernate中：不看数据库，不看XML文件，不看查询语句，怎么样能知道表结构？ 
  看表结构对应的类文件，比如UserInfo表对应的UserInfo.java文件 
10.SQLServer支持集群吗？ 
  支持，但是是属于热备份类型，不能做负载平衡。不过符合你的条件。 
  首先系统做集群，数据库文件放到磁盘阵列里，双机或多机共同访问磁盘阵列，就可以了 
  IIS可以做集群后负载平衡。 
11.为什么要用MVC？我从JSP页面直接访问数据库不是更简单吗,为什么非要先提交到控制再做处理？ 
  MVC各施其职，互不干涉 
  在MVC模式中，三个层各施其职，所以如果一旦哪一层的需求发生了变化， 
  就只需要更改相应的层中的代码而不会影响到其它层中的代码。  有利于开发中的分工 
  在MVC模式中，由于按层把系统开，那么就能更好的实现开发中的分工。网页设计人员可以进行开发视图层中的JSP， 
  对业务熟悉的开发人员可开发业务层，而其它开发人员可开发控制层。  有利于组件的重用 
  分层后更有利于组件的重用。如控制层可独立成一个能用的组件，视图层也可做成通用的操作界面 
  说明：这个好处就太多了!!! 
12.在struts中，假设有一个对数据库中一张表的增删改查的操作，你是写一个action还是写多个action？为什么？ 
  写一个action，让这个action继承自DispatchAction,然后在struts-config.xml中给这个action映射加一参数，parameter="method" 
  这个在提交到这个action中时,会根据传来的参数中method的值来执行相应的action的方法,比如,http://localhost:8080/login.do?method=doLogin 
  这个提交到action的时会自动找方法名叫doLogin的方法,参数返回值原来一样ActionForward 
13.struts中的actionform有什么好处？ 
  struts的actionform其实不好，里面有一堆属性，虽然可以自动填充，但是你会发现，在很多情况下(比如你用到Hibernate) 
  你还要需要自动写一个数据库表的映射类，通常是domain.UserInfo.java，这样就和strutsform中的属性重复，所以他很多余, 
  struts1.1版本，保留了actionform，struts1.2中已经有了新的LazyValidatorForm，但仍然保留了原有的actionform， 
  而在struts 2.0中已经把actionform去掉了 
  下面是解决方法 
  a:  把actionform换成DynaActionForm ，和原来不同的是在dynaActionForm可以domain.UserInfo.java的一个实例做为他的一个属性 
      这样你就不需要在里面写一堆的get,set方法，只是在页面上绑定稍有不同 
  b:  把actionform换成org.apache.struts.validator.LazyValidatorForm，这样你完全不用写你的actionform这个类，直接在xml里面做
      相应配置,当然也可以加上验证框架 
  警告:这个问题是陷阱,实际上struts的actionform很不好,非常麻烦,用久了你会发现他其实是多余的,所以这个问题你应该说他的坏处, 
  和怎么把actonform去掉,请参考http://tqyq.blog.hexun.com/2911285_d.html 
14.用过Hibernate吗，用它有什么好处？ 
  Hibernate的最大的好处就是简化数据库的操作，允许你的代码以对象模式来访问数据库内容， 
  比如通常我们找一个User的资料需要select出所需要的资料，而通过hibnate我们可以把这个User的资料作为一个对象来看待 
  ，通过User.getName()或者User.getId()等操作来获得，这样就完全统一了上层JAVA或者C#等OO语言中对于数据库的非OO操作的不和谐了. 
  另外对于复杂的表和表之间的关联我们也不用去使用复杂的Select等SQL来操作,而使用对象可以方便获得, 
  比如多对多关系某用户属于的部门的名称,虽然底层数据库使用了3个表的主键关联操作, 
  但是我们可以通过User.getDep().getName()来简单的获得,这个就是持久化对象的好处了 
  说明：好处太多，只能在用的过程中慢慢体会  只能说一个字：爽 
15.通常所说的web应用程序分3层，即MVC，如果我想分四层，应该怎么分？ 
    加一个Hibernate数据持久层 
    (
