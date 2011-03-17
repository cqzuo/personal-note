java的环境配置：
  class_path:lib lib/tools目录
  java_home:jdk的目录
  path:bin目录

  jdbc连接数据库

  public class JdbcImpl
  {
	  private  final String DBURL="";
	  private final String DBUSER="";
	  private final String PASSWORD="";
	  private final String DRIVER="";

	  private Connection con = null;
	  private PreparedStatemeng ps = null;
	  private ResultSet rs = null;
	  private String sql = "";

	  public static void main()
	 {
             try{
                 Class.forName(DRIVER);
		 con = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
                  ps = con.createStatement();
		  rs = ps.executeQuery(sql);
	       }catch(Exception e)
	{
		e.printStackTrace();
		}
		 whle(rs.next())
		 {
                         System.out.println("the name is :"+rs.getString("name"));
			 System.out.println("the age is :"+rs.getInt("age"));
			 }
		 }
	  }

常见异常
	NullPointException
	ClassNotFoundException
	  FileNotFoundException
	  IOException
	IndexOutOfBoundsException
	  StringIndexOutOfBoundsException
	  ArrayIndexOutOfBoundsException

data类相关操作
   格式化显示日期:
	  SimpleDateFormat sdf = new SimpleDateFormat();
	  System.out.println(sdf.format(rs.getDate("pdate")));
基本封装类
    int Integer :
    int i = Integer.intValue(i);
    int i = Integer.parseInt(i);
    Integer iner = new Integer(i); 
文件类
public class FileTest
{
    private String separator = File.separtor;
    private String fileName = "";
    private String fileDirectory = ""+separator+"";
    File f = new File(fileDirectory,fileName);
    if(f.exists())
	{
	    System.out.println("文件的路径为："+f.getAbsolutePath());
	    System.out.println("文件大小为:"+f.length());
	    
	    try(
		f.getParentFile().mkdir();
		}catch(IOException e)
		   {
		       e.printStackTrace();
		   }
	}
}