1.java环境配置：
    新建系统变量JAVA_HOME,参数为jdk目录，例如： c:\j2jdk;
    新建系统变量classpath，参数为sdk目录下的\lib和lib\tool.jar;
    新建系统变量Path,参数为sdk目录下的\bin;
2. 一个java web应用系统的基本结构：
    WEB-INF目录，该目录下的一个Web.xml(Java Web应用配置文件)，该目录下一个classes的目录(编译后的java类文件),一个lib目录(所需要的jar包)
3.jsp的两种注释方法：
	<!-- 注释的内容-->客户端显示
	<％--注释的内容--％>客户端不显示
4.jsp的基本语法：
       指令元素:page,include,taglib
       动作元素:<jsp:useBean><jsp:setProperty><jsp:getProperty>
5.MYSQL数据库的Jbuilder连接 :
	 1.下载驱动程序，放在Jbuilder目录下
	 2.将目录写入环境变量；
	3.Tools-->Configure-->Libraries中添加驱动类
	4.Enterprise-->Enterprise Setup-->Database Driver中添加驱动类
	5.注意数据库连接是的用户名和密码（一般是root）   
6.jdbc 数据库连接
	dao代码框架：
package login1;

public class LoginTest {
  String driver ="org.gjt.mm.mysql.Driver";//驱动类字符串，定位驱动主类
  String url = "jdbc:mysql://localhost:3306/login";//连接字符串，定位数据库，内容包括数据库类型、访问类型、数据库位置、数据库端口、具体的数据库名字
  String name = "root";//用户名及密码
  String password = "lord";

  public void creatUser(){};
  public void updateUser(){};
  public void findUser(){};
  public void removeUser(){};
  public static void main(String[] args) {
   LoginTest logintest = new LoginTest();
   logintest.creatUser();
   logintest.findUser();
   logintest.updateUser();
   logintest.removeUser();
  }
}
6.jdbc的几个接口：
	Connection(表示一个数据库的连接)//所有的数据库连接必须在连接后立即关闭
	  格式：
package login1;

public interface Conncetion {
  Connection con=null;
           try{
                    //加载数据库驱动;
                    Class.forName(driver);
                    //获取数据库连接;
                    con = DriverManager.getConnection(url,username,password);
                    //.....
           }
           finally{
                    if(con !=null)
                      try{
                         con.close(); 
                      }catch (SQLexception sqlex2){
                      sqlex2.printStackTrace();
                    }
                    
           }
               

}
	Statement(执行具体的sql语句的接口)
		接口对象由Connection接口的对象来获得,完整的语句通过Statement方法来执行,插入数据和修改数据通过execute()方法:
		  String sql = "insert into user(userId,userName,userPassword)" values(1,"lord","wanglifeng");//简单的SQL语句
	        stmt = con.createStatement();
	        stmt.execute(sql);	//执行sql语句
	      查询是要用StatementQuery()方法，返回一个ResultSet方法;
	        ResultSet rs = null;
	        ....
	       String sql = "select * from user where userName="lord"";
	        rs=executeQuery(sql);//返回查询的结果集 	
	     修改语句通过executeUpdate()实现;
	        String sql = "update user set userPassword="laopo"  where userName="lord";
	        stmt  = con.creatStatement();
	        stmt.executeUpdate(sql);//执行更新语句    
	Prepearstatement
		Prepearstatement接口是一个特殊的statement接口,可以执行预制的语句;
	Resultest
		Resultset是结果集,是jdbc封装返回数据的接口,提供了完善的遍历方法来获取数据
		next()可以顺序遍历所有的数据行
		   while(rs.next()){//遍历结果集
		   System.out.println(rs.getInt("userId")+""+rs.getString("userName")+""+rs.getString("userPassword")+"");//输出一行结果的内容
		   }
7.sql的几种操作
	CRUD的操作(create read update delete)
	createUser()
	  public void createUser(){
	  Connection cn = null;
	  Statement stmt = null;
	  Result rs = null;
	  try{
	  class.forName(driver);
	  con.DriverManager.getConnection(url,username,password);
	  String sql = "insert into user(userId,userName,userPassword)" values(1,"lord","wanglifeng");//简单的SQL语句
	        stmt = con.createStatement();
	        stmt.execute(sql);	  
	  }
	  }