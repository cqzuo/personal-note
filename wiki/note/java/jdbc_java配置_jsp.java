1.java�������ã�
    �½�ϵͳ����JAVA_HOME,����ΪjdkĿ¼�����磺 c:\j2jdk;
    �½�ϵͳ����classpath������ΪsdkĿ¼�µ�\lib��lib\tool.jar;
    �½�ϵͳ����Path,����ΪsdkĿ¼�µ�\bin;
2. һ��java webӦ��ϵͳ�Ļ����ṹ��
    WEB-INFĿ¼����Ŀ¼�µ�һ��Web.xml(Java WebӦ�������ļ�)����Ŀ¼��һ��classes��Ŀ¼(������java���ļ�),һ��libĿ¼(����Ҫ��jar��)
3.jsp������ע�ͷ�����
	<!-- ע�͵�����-->�ͻ�����ʾ
	<��--ע�͵�����--��>�ͻ��˲���ʾ
4.jsp�Ļ����﷨��
       ָ��Ԫ��:page,include,taglib
       ����Ԫ��:<jsp:useBean><jsp:setProperty><jsp:getProperty>
5.MYSQL���ݿ��Jbuilder���� :
	 1.�����������򣬷���JbuilderĿ¼��
	 2.��Ŀ¼д�뻷��������
	3.Tools-->Configure-->Libraries�����������
	4.Enterprise-->Enterprise Setup-->Database Driver�����������
	5.ע�����ݿ������ǵ��û��������루һ����root��   
6.jdbc ���ݿ�����
	dao�����ܣ�
package login1;

public class LoginTest {
  String driver ="org.gjt.mm.mysql.Driver";//�������ַ�������λ��������
  String url = "jdbc:mysql://localhost:3306/login";//�����ַ�������λ���ݿ⣬���ݰ������ݿ����͡��������͡����ݿ�λ�á����ݿ�˿ڡ���������ݿ�����
  String name = "root";//�û���������
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
6.jdbc�ļ����ӿڣ�
	Connection(��ʾһ�����ݿ������)//���е����ݿ����ӱ��������Ӻ������ر�
	  ��ʽ��
package login1;

public interface Conncetion {
  Connection con=null;
           try{
                    //�������ݿ�����;
                    Class.forName(driver);
                    //��ȡ���ݿ�����;
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
	Statement(ִ�о����sql���Ľӿ�)
		�ӿڶ�����Connection�ӿڵĶ��������,���������ͨ��Statement������ִ��,�������ݺ��޸�����ͨ��execute()����:
		  String sql = "insert into user(userId,userName,userPassword)" values(1,"lord","wanglifeng");//�򵥵�SQL���
	        stmt = con.createStatement();
	        stmt.execute(sql);	//ִ��sql���
	      ��ѯ��Ҫ��StatementQuery()����������һ��ResultSet����;
	        ResultSet rs = null;
	        ....
	       String sql = "select * from user where userName="lord"";
	        rs=executeQuery(sql);//���ز�ѯ�Ľ���� 	
	     �޸����ͨ��executeUpdate()ʵ��;
	        String sql = "update user set userPassword="laopo"  where userName="lord";
	        stmt  = con.creatStatement();
	        stmt.executeUpdate(sql);//ִ�и������    
	Prepearstatement
		Prepearstatement�ӿ���һ�������statement�ӿ�,����ִ��Ԥ�Ƶ����;
	Resultest
		Resultset�ǽ����,��jdbc��װ�������ݵĽӿ�,�ṩ�����Ƶı�����������ȡ����
		next()����˳��������е�������
		   while(rs.next()){//���������
		   System.out.println(rs.getInt("userId")+""+rs.getString("userName")+""+rs.getString("userPassword")+"");//���һ�н��������
		   }
7.sql�ļ��ֲ���
	CRUD�Ĳ���(create read update delete)
	createUser()
	  public void createUser(){
	  Connection cn = null;
	  Statement stmt = null;
	  Result rs = null;
	  try{
	  class.forName(driver);
	  con.DriverManager.getConnection(url,username,password);
	  String sql = "insert into user(userId,userName,userPassword)" values(1,"lord","wanglifeng");//�򵥵�SQL���
	        stmt = con.createStatement();
	        stmt.execute(sql);	  
	  }
	  }