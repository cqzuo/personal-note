Servlet+JSP��ҳ��һ������
���·���:Java��� 
���������Ҹ����������ӣ��κ��������̫���䣬��ʵ�µĲ��࣬��ת����������վһ��ѣ��еĻ�ת��������䣬�е��������ػ�Ҫ��¼����ʵ������һ��
����Ǿ����Լ�д�ɣ��������ṩeclipse����ѹ�������أ�ֱ�ӵ���������ˣ�����̤ʵ��̬�ȸ�����£�ϣ���ܸ����ְ�����
�������ؽ�����α��ֲ��ҳ��С���ɣ�DAOֻ��һ��Demo�����ݿ��ѯ�ķ�ҳ���ɲ��ڱ������۷�Χ֮�ڡ�
 
�ȿ�������Ч����һ����ͼ��
  
���ӱ��ֲ���˵��ҳ����һ�����ӵĹ�������΢��һ��˼·�����ڲ�ͬcompetence level��ͬѧӦ�ö����Լ��������
 
������������б��ҳΪ�����Ҿ��÷�ҳ��������Ҫ�ģ�
һ�ǣ���ҳ���Ǳ��������Լ������������������ÿҳ��ʾ������(ҳ��С)��ҳ��
���ǣ��������ҳ�ŵķ�ҳ������
 
ʵ��Ӧ���У������������ֵ���Ǵ����ݿ���Եõ���ÿҳ��ʾ������������ҳ��ҳ��С�����Լ����壻ҳ�����ǿ���ͨ������ĸ����ʽ�򵥵ó���
 
���裺
  int pageSize = 10; //��ҳ��С
  int totalPosts = PagingDAO.entryList.size(); //��������
  int totalPages = totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0); //����ó�����ҳ��
 
ÿҳ��������ôȡ������
  ֪����ҳ�Ĵ�С֮������������ҳ�õ�ѡȡ������ÿ��ѡ��ڼ�ҳ��ʱ�򣬶�����Servlet���ݵ�ǰѡ��ҳ�ŵĲ���������Servlet���ú����DAO��Ӧ�ķ�����ȡ�������б���Ϣ���ٻش���JSP�Թ���ʾ��
 
��������������ʾ��index.jsp
Html���� 
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
 
 
��Щ��������֮�����ǾͿ���ʵ�ַ�ҳ�������ˣ�Ҳ���������paging_footer.jsp
Html���� 
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
    <a href="Posts?pageNumber=1">��ҳ</a>   
    <c:if test="${pageNumber>1}">  
        <a href="Posts?pageNumber=${pageNumber-1}">��һҳ</a>  
    </c:if>   
    ��ת���� <select name="pageNumber" onchange="gotoSelectedPage();">  
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
    </select>ҳ   
    <c:if test="${pageNumber<totalPages}">  
        <a href="Posts?pageNumber=${pageNumber+1}">��һҳ</a>  
    </c:if>   
    <a href="Posts?pageNumber=${totalPages}">ĩҳ</a>  
</form>  
 
 
Posts�����ǵ�Servlet������ȡ����ز�������DAO�򽻵���ȡ��һЩ���µ����ݣ�Ȼ�󴫵ݵ�JSP����������һ�����Servlet �� doGet ������
Java���� 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    String pageNumberStr = request.getParameter("pageNumber");  
    int pageNumber = 1;  
    if(pageNumberStr!=null && !pageNumberStr.isEmpty())  
    {  
        pageNumber = Integer.parseInt(pageNumberStr);  
    }  
      
    int pageSize = 10; //��ҳ��С  
    int totalPosts = PagingDAO.entryList.size(); //��������  
    int totalPages = totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0); //����ó�����ҳ��  
      
    request.setAttribute("pageSize", pageSize);  
    request.setAttribute("totalPosts", totalPosts);  
    request.setAttribute("pageNumber", pageNumber);  
    request.setAttribute("totalPages", totalPages);  
      
    List<Entry> entryList = PagingDAO.getEntryList(pageNumber, pageSize);  
    System.out.println("entryList:"+ entryList.size());  
    request.setAttribute("entryList", entryList);  
      
    request.getRequestDispatcher("index.jsp").forward(request, response);         
}  
 
  ��ҳ��ʵ���Ǻܼ򵥵����飬Ϊ�˷���������·�������ṩһ�����eclipse�Ĺ���ѹ������ֱ�ӵ���������ˡ�
(ע�⣺����eclipse JEE�汾�����̵���������п���jstl.jar �� standard.jar��WEB-INF/libĿ¼�����û������Server�Ļ���down��tomcat��eclipse������һ�£���Ȼ��ôrun�����������Ӧ�ö����)