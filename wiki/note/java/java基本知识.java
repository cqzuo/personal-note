java�Ļ������ã�
  class_path:lib lib/toolsĿ¼
  java_home:jdk��Ŀ¼
  path:binĿ¼

  jdbc�������ݿ�

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

�����쳣
	NullPointException
	ClassNotFoundException
	  FileNotFoundException
	  IOException
	IndexOutOfBoundsException
	  StringIndexOutOfBoundsException
	  ArrayIndexOutOfBoundsException

data����ز���
   ��ʽ����ʾ����:
	  SimpleDateFormat sdf = new SimpleDateFormat();
	  System.out.println(sdf.format(rs.getDate("pdate")));
������װ��
    int Integer :
    int i = Integer.intValue(i);
    int i = Integer.parseInt(i);
    Integer iner = new Integer(i); 
�ļ���
public class FileTest
{
    private String separator = File.separtor;
    private String fileName = "";
    private String fileDirectory = ""+separator+"";
    File f = new File(fileDirectory,fileName);
    if(f.exists())
	{
	    System.out.println("�ļ���·��Ϊ��"+f.getAbsolutePath());
	    System.out.println("�ļ���СΪ:"+f.length());
	    
	    try(
		f.getParentFile().mkdir();
		}catch(IOException e)
		   {
		       e.printStackTrace();
		   }
	}
}