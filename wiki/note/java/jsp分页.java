在使用数据库的过程中，不可避免的需要使用到分页的功能，可是JDBC的规范对此却没有很好的解决。对于这个需求很多朋友都有自己的解决方案，比如使用Vector等集合类先保存取出的数据再分页。但这种方法的可用性很差，与JDBC本身的接口完全不同，对不同类型的字段的支持也不好。这里提供了一种与JDBC兼容性非常好的方案。  
JDBC和分页
　　Sun的JDBC规范的制定，有时很让人哭笑不得，在JDBC1.0中，对于一个结果集（ResultSet）你甚至只能执行next()操作，而无法让其向后滚动，这就直接导致在只执行一次SQL查询的情况下无法获得结果集的大小。所以，如果你使用的是JDBC1.0的驱动，那么是几乎无法实现分页的。
　　好在Sun的JDBC2规范中很好的弥补了这一个不足，增加了结果集的前后滚动操作，虽然仍然不能直接支持分页，但我们已经可以在这个基础上写出自己的可支持分页的ResultSet了。

和具体数据库相关的实现方法
　　有一些数据库，如Mysql, Oracle等有自己的分页方法，比如Mysql可以使用limit子句，Oracle可以使用ROWNUM来限制结果集的大小和起始位置。这里以Mysql为例，其典型代码如下：
// 计算总的记录条数
String SQL = "SELECT Count(*) AS total " + this.QueryPart; 
rs = db.executeQuery(SQL); 
if (rs.next()) 
Total = rs.getInt(1); 
// 设置当前页数和总页数
TPages = (int)Math.ceil((double)this.Total/this.MaxLine); 
CPages = (int)Math.floor((double)Offset/this.MaxLine+1); 
// 根据条件判断，取出所需记录
if (Total > 0) { 
SQL = Query + " LIMIT " + Offset + " , " + MaxLine; 
rs = db.executeQuery(SQL); 
} 
return rs; 
} 
复制代码

　　毫无疑问，这段代码在数据库是Mysql时将会是漂亮的，但是作为一个通用的类（事实上我后面要提供的就是一个通用类库中的一部分），需要适应不同的数据库，而基于这个类（库）的应用，也可能使用不同的数据库，所以，我们将不使用这种方法。

另一种繁琐的实现方法
　　我看过一些人的做法（事实上包括我在内，一开始也是使用这种方法的），即不使用任何封装，在需要分页的地方，直接操作ResultSet滚到相应的位置，再读取相应数量的记录。其典型代码如下：
<%
sqlStmt = sqlCon.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
java.sql.ResultSet.CONCUR_READ_ONLY);
strSQL = "select name,age from test";
//执行SQL语句并获取结果集
sqlRst = sqlStmt.executeQuery(strSQL);
//获取记录总数
sqlRst.last();
intRowCount = sqlRst.getRow();
//记算总页数
intPageCount = (intRowCount+intPageSize-1) / intPageSize;
//调整待显示的页码
if(intPage>intPageCount) intPage = intPageCount;
%>
<table border="1" cellspacing="0" cellpadding="0">
<tr>
   <th>姓名</th>
   <th>年龄</th>
</tr>
<%
if(intPageCount>0){
   //将记录指针定位到待显示页的第一条记录上
   sqlRst.absolute((intPage-1) * intPageSize + 1);
   //显示数据
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
复制代码

　很显然，这种方法没有考虑到代码重用的问题，不仅代码数量巨大，而且在代码需要修改的情况下，将会无所适从。

使用Vector进行分页
　　还见过另一些实现分页的类，是先将所有记录都select出来，然后将ResultSet中的数据都get出来，存入Vector等集合类中，再根据所需分页的大小，页数，定位到相应的位置，读取数据。或者先使用前面提到的两种分页方法，取得所需的页面之后，再存入Vector中。
　　扔开代码的效率不说，单是从程序结构和使用的方便性上讲，就是很糟糕的。比如，这种做法支持的字段类型有限，int, double, String类型还比较好处理，如果碰到Blob, Text等类型，实现起来就很麻烦了。这是一种更不可取的方案。

一个新的Pageable接口及其实现
　　很显然，看过上面三种实现方法后，我们对新的分页机制有了一个目标，即：不与具体数据库相关；尽可能做到代码重用；尽可能与原JDBC接口的使用方法保持一致；尽可能高的效率。
　　首先，我们需要提供一个与java.sql.ResultSet向下兼容的接口，把它命名为Pageable，接口定义如下：
public interface Pageable extends java.sql.ResultSet{
/**返回总页数
*/
int getPageCount();
/**返回当前页的记录条数
*/
int getPageRowsCount();
/**返回分页大小
*/
int getPageSize();
/**转到指定页
*/
void gotoPage(int page) ;
/**设置分页大小
*/
void setPageSize(int pageSize);
/**返回总记录行数
*/
int getRowsCount();
/**
* 转到当前页的第一条记录
* @exception java.sql.SQLException 异常说明。
*/
void pageFirst() throws java.sql.SQLException;
/**
* 转到当前页的最后一条记录
* @exception java.sql.SQLException 异常说明。
*/
void pageLast() throws java.sql.SQLException;
/**返回当前页号
*/
int getCurPage();
}  
复制代码

　　这是一个对java.sql.ResultSet进行了扩展的接口，主要是增加了对分页的支持，如设置分页大小，跳转到某一页，返回总页数等等。
　　接着，我们需要实现这个接口，由于这个接口继承自ResultSet，并且它的大部分功能也都和ResultSet原有功能相同，所以这里使用了一个简单的Decorator模式。
　　PageableResultSet2的类声明和成员声明如下：
public class PageableResultSet2 implements Pageable {
    protected java.sql.ResultSet rs=null;
    protected int rowsCount;
    protected int pageSize;
    protected int curPage;
    protected String command = "";
}  
　　可以看到，在PageableResultSet2中，包含了一个ResultSet的实例（这个实例只是实现了ResultSet接口，事实上它是由各个数据库厂商分别实现的），并且把所有由ResultSet继承来的方法都直接转发给该实例来处理。
　　PageableResultSet2中继承自ResultSet的主要方法：
//……
public boolean next() throws SQLException {
    return rs.next();
}
//……
public String getString(String columnName) throws SQLException {
    try {
        return rs.getString(columnName);
    }
    catch (SQLException e) {//这里是为了增加一些出错信息的内容便于调试
        throw new SQLException (e.toString()+" columnName="
            +columnName+" SQL="+this.getCommand());
    }
}
//……  
　　只有在Pageable接口中新增的方法才需要自己的写方法处理。
/**方法注释可参考Pageable.java
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
　　PageableResultSet2的构造方法：
public PageableResultSet2(java.sql.ResultSet rs) throws java.sql.SQLException {
    if(rs==null) throw new SQLException("given ResultSet is NULL","user");
    
    rs.last();
    rowsCount=rs.getRow();
    rs.beforeFirst();
    
    this.rs=rs;
}  
　　这里只是简单的取得一个总记录数，并将记录游标移回初始位置（before first），同时将参数中的ResultSet赋给成员变量。

Pageable的使用方法
　　因为Pageable接口继承自ResultSet，所以在使用方法上与ResultSet一致，尤其是在不需要分页功能的时候，可以直接当成ResultSet使用。而在需要分页时，只需要简单的setPageSize, gotoPage，即可。
PreparedStatement pstmt=null;
Pageable rs=null;
……//构造SQL，并准备一个pstmt.
rs=new PageableResultSet2(pstmt.executeQuery());//构造一个Pageable
rs.setPageSize(20);//每页20个记录
rs.gotoPage(2);//跳转到第2页
for(int i=0; i<rs.getPageRowsCount(); i++){//循环处理
int id=rs.getInt(“ID”);
……//继续处理
rs.next();
}  

总结
　　一个好的基础类应该是便于使用，并且具备足够的可移植性，同时要保证其功能的完善。在上面的实现中，我们从java.sql.ResultSet接口继承出Pageable，并实现了它。这就保证了在使用中与JDBC原有操作的一致性，同时对原有功能没有缩减。
　　同时它也是易于使用的，因为封装了一切必要的操作，所以在你的代码中唯一显得"难看"和"不舒服"的地方就是需要自己去构造一个PageableResultSet2。不过只要你愿意，这也是可以解决的。
　　当然它也有具有充分的可移植性，当你将数据库由Oracle变为Mysql或者SQLServer的时候，你仍然可以使用这些分页的代码。它在使用中（或者说在移植的过程中）唯一的限制就是你必须要使用一个支持JDBC2的驱动（现在明白为什么我把类命名为PageableResultSet2了吧。:P），不过，好在JDBC2已经成为标准了，绝大多数的数据库（如Oracle, Mysql, SQLServer）都有自己的或者第三方提供的JDBC2的驱动。
　　OK，这个分页的实现是否对你的编程有帮助呢？仔细看看，其实真正自己写的代码并不多的，大部分都只是简单的转发操作。一个合适的模式应用可以帮你很大忙。