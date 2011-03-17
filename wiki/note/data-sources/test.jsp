<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%!
    final String JNDINAME = "java:comp/env/jdbc/lord";
%>
<%
    Connection conn = null;
    try
    {
    //初始化查找命名空间
    Context ctx = new InitialContext();
    //找到datasource
    DataSource ds = (DataSource)ctx.lookup(JNDINAME);
    conn = ds.getConnection();
    }catch(Exception e)
    {
      System.out.println(e);
    }
%>
<%=conn%>
