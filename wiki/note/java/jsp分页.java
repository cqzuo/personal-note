��ʹ�����ݿ�Ĺ����У����ɱ������Ҫʹ�õ���ҳ�Ĺ��ܣ�����JDBC�Ĺ淶�Դ�ȴû�кܺõĽ���������������ܶ����Ѷ����Լ��Ľ������������ʹ��Vector�ȼ������ȱ���ȡ���������ٷ�ҳ�������ַ����Ŀ����Ժܲ��JDBC����Ľӿ���ȫ��ͬ���Բ�ͬ���͵��ֶε�֧��Ҳ���á������ṩ��һ����JDBC�����Էǳ��õķ�����  
JDBC�ͷ�ҳ
����Sun��JDBC�淶���ƶ�����ʱ�����˿�Ц���ã���JDBC1.0�У�����һ���������ResultSet��������ֻ��ִ��next()���������޷����������������ֱ�ӵ�����ִֻ��һ��SQL��ѯ��������޷���ý�����Ĵ�С�����ԣ������ʹ�õ���JDBC1.0����������ô�Ǽ����޷�ʵ�ַ�ҳ�ġ�
��������Sun��JDBC2�淶�кܺõ��ֲ�����һ�����㣬�����˽������ǰ�������������Ȼ��Ȼ����ֱ��֧�ַ�ҳ���������Ѿ����������������д���Լ��Ŀ�֧�ַ�ҳ��ResultSet�ˡ�

�;������ݿ���ص�ʵ�ַ���
������һЩ���ݿ⣬��Mysql, Oracle�����Լ��ķ�ҳ����������Mysql����ʹ��limit�Ӿ䣬Oracle����ʹ��ROWNUM�����ƽ�����Ĵ�С����ʼλ�á�������MysqlΪ��������ʹ������£�
// �����ܵļ�¼����
String SQL = "SELECT Count(*) AS total " + this.QueryPart; 
rs = db.executeQuery(SQL); 
if (rs.next()) 
Total = rs.getInt(1); 
// ���õ�ǰҳ������ҳ��
TPages = (int)Math.ceil((double)this.Total/this.MaxLine); 
CPages = (int)Math.floor((double)Offset/this.MaxLine+1); 
// ���������жϣ�ȡ�������¼
if (Total > 0) { 
SQL = Query + " LIMIT " + Offset + " , " + MaxLine; 
rs = db.executeQuery(SQL); 
} 
return rs; 
} 
���ƴ���

�����������ʣ���δ��������ݿ���Mysqlʱ������Ư���ģ�������Ϊһ��ͨ�õ��ࣨ��ʵ���Һ���Ҫ�ṩ�ľ���һ��ͨ������е�һ���֣�����Ҫ��Ӧ��ͬ�����ݿ⣬����������ࣨ�⣩��Ӧ�ã�Ҳ����ʹ�ò�ͬ�����ݿ⣬���ԣ����ǽ���ʹ�����ַ�����

��һ�ַ�����ʵ�ַ���
�����ҿ���һЩ�˵���������ʵ�ϰ��������ڣ�һ��ʼҲ��ʹ�����ַ����ģ�������ʹ���κη�װ������Ҫ��ҳ�ĵط���ֱ�Ӳ���ResultSet������Ӧ��λ�ã��ٶ�ȡ��Ӧ�����ļ�¼������ʹ������£�
<%
sqlStmt = sqlCon.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
java.sql.ResultSet.CONCUR_READ_ONLY);
strSQL = "select name,age from test";
//ִ��SQL��䲢��ȡ�����
sqlRst = sqlStmt.executeQuery(strSQL);
//��ȡ��¼����
sqlRst.last();
intRowCount = sqlRst.getRow();
//������ҳ��
intPageCount = (intRowCount+intPageSize-1) / intPageSize;
//��������ʾ��ҳ��
if(intPage>intPageCount) intPage = intPageCount;
%>
<table border="1" cellspacing="0" cellpadding="0">
<tr>
   <th>����</th>
   <th>����</th>
</tr>
<%
if(intPageCount>0){
   //����¼ָ�붨λ������ʾҳ�ĵ�һ����¼��
   sqlRst.absolute((intPage-1) * intPageSize + 1);
   //��ʾ����
   i = 0;
   while(i<intPageSize && !sqlRst.isAfterLast()){
      %>
<tr>
   <td><%=sqlRst.getString(1)%></td>
   <td><%=sqlRst.getString(2)%></td>
</tr>
      <%
      sqlRst.next();
      i++;
   }
}
%>
</table> intPageCount) intPage = intPageCount;
%>
���ƴ���

������Ȼ�����ַ���û�п��ǵ��������õ����⣬�������������޴󣬶����ڴ�����Ҫ�޸ĵ�����£����������ʴӡ�

ʹ��Vector���з�ҳ
������������һЩʵ�ַ�ҳ���࣬���Ƚ����м�¼��select������Ȼ��ResultSet�е����ݶ�get����������Vector�ȼ������У��ٸ��������ҳ�Ĵ�С��ҳ������λ����Ӧ��λ�ã���ȡ���ݡ�������ʹ��ǰ���ᵽ�����ַ�ҳ������ȡ�������ҳ��֮���ٴ���Vector�С�
�����ӿ������Ч�ʲ�˵�����Ǵӳ���ṹ��ʹ�õķ������Ͻ������Ǻ����ġ����磬��������֧�ֵ��ֶ��������ޣ�int, double, String���ͻ��ȽϺô����������Blob, Text�����ͣ�ʵ�������ͺ��鷳�ˡ�����һ�ָ�����ȡ�ķ�����

һ���µ�Pageable�ӿڼ���ʵ��
��������Ȼ��������������ʵ�ַ��������Ƕ��µķ�ҳ��������һ��Ŀ�꣬��������������ݿ���أ������������������ã���������ԭJDBC�ӿڵ�ʹ�÷�������һ�£������ܸߵ�Ч�ʡ�
�������ȣ�������Ҫ�ṩһ����java.sql.ResultSet���¼��ݵĽӿڣ���������ΪPageable���ӿڶ������£�
public interface Pageable extends java.sql.ResultSet{
/**������ҳ��
*/
int getPageCount();
/**���ص�ǰҳ�ļ�¼����
*/
int getPageRowsCount();
/**���ط�ҳ��С
*/
int getPageSize();
/**ת��ָ��ҳ
*/
void gotoPage(int page) ;
/**���÷�ҳ��С
*/
void setPageSize(int pageSize);
/**�����ܼ�¼����
*/
int getRowsCount();
/**
* ת����ǰҳ�ĵ�һ����¼
* @exception java.sql.SQLException �쳣˵����
*/
void pageFirst() throws java.sql.SQLException;
/**
* ת����ǰҳ�����һ����¼
* @exception java.sql.SQLException �쳣˵����
*/
void pageLast() throws java.sql.SQLException;
/**���ص�ǰҳ��
*/
int getCurPage();
}  
���ƴ���

��������һ����java.sql.ResultSet��������չ�Ľӿڣ���Ҫ�������˶Է�ҳ��֧�֣������÷�ҳ��С����ת��ĳһҳ��������ҳ���ȵȡ�
�������ţ�������Ҫʵ������ӿڣ���������ӿڼ̳���ResultSet���������Ĵ󲿷ֹ���Ҳ����ResultSetԭ�й�����ͬ����������ʹ����һ���򵥵�Decoratorģʽ��
����PageableResultSet2���������ͳ�Ա�������£�
public class PageableResultSet2 implements Pageable {
    protected java.sql.ResultSet rs=null;
    protected int rowsCount;
    protected int pageSize;
    protected int curPage;
    protected String command = "";
}  
�������Կ�������PageableResultSet2�У�������һ��ResultSet��ʵ�������ʵ��ֻ��ʵ����ResultSet�ӿڣ���ʵ�������ɸ������ݿ⳧�̷ֱ�ʵ�ֵģ������Ұ�������ResultSet�̳����ķ�����ֱ��ת������ʵ��������
����PageableResultSet2�м̳���ResultSet����Ҫ������
//����
public boolean next() throws SQLException {
    return rs.next();
}
//����
public String getString(String columnName) throws SQLException {
    try {
        return rs.getString(columnName);
    }
    catch (SQLException e) {//������Ϊ������һЩ������Ϣ�����ݱ��ڵ���
        throw new SQLException (e.toString()+" columnName="
            +columnName+" SQL="+this.getCommand());
    }
}
//����  
����ֻ����Pageable�ӿ��������ķ�������Ҫ�Լ���д��������
/**����ע�Ϳɲο�Pageable.java
*/
public int getCurPage() {
    return curPage;
}
public int getPageCount() {
    if(rowsCount==0) return 0;
    if(pageSize==0) return 1;
    //calculate PageCount
    double tmpD=(double)rowsCount/pageSize;
    int tmpI=(int)tmpD;
    if(tmpD>tmpI) tmpI++;
    return tmpI;
}
public int getPageRowsCount() {
    if(pageSize==0) return rowsCount;
    if(getRowsCount()==0) return 0;
    if(curPage!=getPageCount()) return pageSize;
    return rowsCount-(getPageCount()-1)*pageSize;
}
public int getPageSize() {
    return pageSize;
}
public int getRowsCount() {
    return rowsCount;
}
public void gotoPage(int page) {
    if (rs == null)
        return;
    if (page < 1)
        page = 1;
    if (page > getPageCount())
        page = getPageCount();
    int row = (page - 1) * pageSize + 1;
    try {
        rs.absolute(row);
        curPage = page;
    }
    catch (java.sql.SQLException e) {
    }
}
public void pageFirst() throws java.sql.SQLException {
    int row=(curPage-1)*pageSize+1;
    rs.absolute(row);
}
public void pageLast() throws java.sql.SQLException {
    int row=(curPage-1)*pageSize+getPageRowsCount();
    rs.absolute(row);
}
public void setPageSize(int pageSize) {
    if(pageSize>=0){
        this.pageSize=pageSize;
        curPage=1;
    }
}  
����PageableResultSet2�Ĺ��췽����
public PageableResultSet2(java.sql.ResultSet rs) throws java.sql.SQLException {
    if(rs==null) throw new SQLException("given ResultSet is NULL","user");
    
    rs.last();
    rowsCount=rs.getRow();
    rs.beforeFirst();
    
    this.rs=rs;
}  
��������ֻ�Ǽ򵥵�ȡ��һ���ܼ�¼����������¼�α��ƻس�ʼλ�ã�before first����ͬʱ�������е�ResultSet������Ա������

Pageable��ʹ�÷���
������ΪPageable�ӿڼ̳���ResultSet��������ʹ�÷�������ResultSetһ�£��������ڲ���Ҫ��ҳ���ܵ�ʱ�򣬿���ֱ�ӵ���ResultSetʹ�á�������Ҫ��ҳʱ��ֻ��Ҫ�򵥵�setPageSize, gotoPage�����ɡ�
PreparedStatement pstmt=null;
Pageable rs=null;
����//����SQL����׼��һ��pstmt.
rs=new PageableResultSet2(pstmt.executeQuery());//����һ��Pageable
rs.setPageSize(20);//ÿҳ20����¼
rs.gotoPage(2);//��ת����2ҳ
for(int i=0; i<rs.getPageRowsCount(); i++){//ѭ������
int id=rs.getInt(��ID��);
����//��������
rs.next();
}  

�ܽ�
����һ���õĻ�����Ӧ���Ǳ���ʹ�ã����Ҿ߱��㹻�Ŀ���ֲ�ԣ�ͬʱҪ��֤�书�ܵ����ơ��������ʵ���У����Ǵ�java.sql.ResultSet�ӿڼ̳г�Pageable����ʵ����������ͱ�֤����ʹ������JDBCԭ�в�����һ���ԣ�ͬʱ��ԭ�й���û��������
����ͬʱ��Ҳ������ʹ�õģ���Ϊ��װ��һ�б�Ҫ�Ĳ�������������Ĵ�����Ψһ�Ե�"�ѿ�"��"�����"�ĵط�������Ҫ�Լ�ȥ����һ��PageableResultSet2������ֻҪ��Ը�⣬��Ҳ�ǿ��Խ���ġ�
������Ȼ��Ҳ�о��г�ֵĿ���ֲ�ԣ����㽫���ݿ���Oracle��ΪMysql����SQLServer��ʱ������Ȼ����ʹ����Щ��ҳ�Ĵ��롣����ʹ���У�����˵����ֲ�Ĺ����У�Ψһ�����ƾ��������Ҫʹ��һ��֧��JDBC2����������������Ϊʲô�Ұ�������ΪPageableResultSet2�˰ɡ�:P��������������JDBC2�Ѿ���Ϊ��׼�ˣ�������������ݿ⣨��Oracle, Mysql, SQLServer�������Լ��Ļ��ߵ������ṩ��JDBC2��������
����OK�������ҳ��ʵ���Ƿ����ı���а����أ���ϸ��������ʵ�����Լ�д�Ĵ��벢����ģ��󲿷ֶ�ֻ�Ǽ򵥵�ת��������һ�����ʵ�ģʽӦ�ÿ��԰���ܴ�æ��