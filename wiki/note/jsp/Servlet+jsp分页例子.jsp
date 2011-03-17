Servlet+JSP分页的一个例子
文章分类:Java编程 
想在网上找个这样的例子，奈何这个世界太浮夸，干实事的不多，搞转帖的垃圾网站一大堆，有的还转的七零八落，有的例子下载还要登录，着实郁闷了一把
最后还是决定自己写吧，本例子提供eclipse工程压缩包下载，直接导入就能用了，本着踏实的态度干这件事，希望能给新手帮助。
本例着重介绍如何表现层分页的小技巧，DAO只是一个Demo，数据库查询的分页技巧不在本文讨论范围之内。
 
先看看最终效果的一个截图：
  
单从表现层来说分页不是一个复杂的工作，稍微理一下思路，处于不同competence level的同学应该都能自己搞出来。
 
以上面的文章列表分页为例，我觉得分页有两点重要的，
一是：分页我们必须首先自己搞清楚，文章总数、每页显示文章数(页大小)、页数
二是：如何做好页脚的分页导航条
 
实际应用中，文章总数这个值我们从数据库可以得到；每页显示的文章数即分页的页大小可以自己定义；页数我们可以通过下面的个表达式简单得出。
 
假设：
  int pageSize = 10; //分页大小
  int totalPosts = PagingDAO.entryList.size(); //总文章数
  int totalPages = totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0); //计算得出的总页数
 
每页的文章怎么取出来？
  知道分页的大小之后，我们生成了页好的选取下拉框，每次选择第几页的时候，都会向Servlet传递当前选择页号的参数，这样Servlet调用后面的DAO相应的方法，取得文章列表信息，再回传到JSP以供显示。
 
看看我们用作显示的index.jsp
Html代码 
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
page Size : ${pageSize}  
<br />  
Total Posts: ${totalPosts}  
<br />  
Total Pages: ${totalPages}  
<br />  
Current Page: ${pageNumber}  
<hr />  
  
<table>  
    <thead>  
        <tr align="center">  
            <td width="10%">Article ID</td>  
            <td width="70%">Article Title</td>  
            <td colspan="3">Actions</td>  
        </tr>  
    </thead>  
    <tbody>  
        <c:forEach items="${entryList}" var="entry">  
            <tr align="center">  
                <td>${entry.entryID}</td>  
                <td>${entry.title}</td>  
                <td><a href="viewEntry?entryID=${entry.entryID}">View</a></td>  
                <td><a href="editEntry?entryID=${entry.entryID}">Edit</a></td>  
                <td><a href="deleteEntry?entryID=${entry.entryID}">Delete</a></td>  
            </tr>  
        </c:forEach>  
    </tbody>  
    <tfoot>  
        <tr align="center">  
            <td colspan="5">  
                <jsp:include page="paging_footer.jsp"></jsp:include>  
            </td>  
        </tr>  
    </tfoot>  
</table>  
  
<hr/>  
 
 
这些流程清晰之后，我们就可以实现分页导航条了，也就是上面的paging_footer.jsp
Html代码 
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<script type="text/javascript">  
function gotoSelectedPage()  
{  
    var x = document.getElementById("navigatorForm");  
    //alert("Original action: " + x.action)  
    x.submit();  
}  
</script>  
<form action="Posts" method="get" id="navigatorForm">  
    <a href="Posts?pageNumber=1">首页</a>   
    <c:if test="${pageNumber>1}">  
        <a href="Posts?pageNumber=${pageNumber-1}">上一页</a>  
    </c:if>   
    跳转到第 <select name="pageNumber" onchange="gotoSelectedPage();">  
    <c:forEach begin="1" end="${totalPages}" step="1" var="pageIndex">  
        <c:choose>  
            <c:when test="${pageIndex eq pageNumber}">  
                <option value="${pageIndex}" selected="selected">${pageIndex}</option>  
            </c:when>  
            <c:otherwise>  
                <option value="${pageIndex}">${pageIndex}</option>  
            </c:otherwise>  
        </c:choose>  
    </c:forEach>  
    </select>页   
    <c:if test="${pageNumber<totalPages}">  
        <a href="Posts?pageNumber=${pageNumber+1}">下一页</a>  
    </c:if>   
    <a href="Posts?pageNumber=${totalPages}">末页</a>  
</form>  
 
 
Posts是我们的Servlet，负责取得相关参数，和DAO打交道，取得一些文章的数据，然后传递到JSP，我们来看一下这个Servlet 的 doGet 方法。
Java代码 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    String pageNumberStr = request.getParameter("pageNumber");  
    int pageNumber = 1;  
    if(pageNumberStr!=null && !pageNumberStr.isEmpty())  
    {  
        pageNumber = Integer.parseInt(pageNumberStr);  
    }  
      
    int pageSize = 10; //分页大小  
    int totalPosts = PagingDAO.entryList.size(); //总文章数  
    int totalPages = totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0); //计算得出的总页数  
      
    request.setAttribute("pageSize", pageSize);  
    request.setAttribute("totalPosts", totalPosts);  
    request.setAttribute("pageNumber", pageNumber);  
    request.setAttribute("totalPages", totalPages);  
      
    List<Entry> entryList = PagingDAO.getEntryList(pageNumber, pageSize);  
    System.out.println("entryList:"+ entryList.size());  
    request.setAttribute("entryList", entryList);  
      
    request.getRequestDispatcher("index.jsp").forward(request, response);         
}  
 
  分页其实还是很简单的事情，为了方便新手上路，这里提供一下这个eclipse的工程压缩包，直接导入就能用了。
(注意：对于eclipse JEE版本，工程导入后，请自行拷贝jstl.jar 和 standard.jar到WEB-INF/lib目录，如果没有配置Server的话，down个tomcat在eclipse里配置一下，不然怎么run？这个基础的应该都会吧)