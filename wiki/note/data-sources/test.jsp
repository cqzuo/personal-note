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
    //��ʼ�����������ռ�
    Context ctx = new InitialContext();
    //�ҵ�datasource
    DataSource ds = (DataSource)ctx.lookup(JNDINAME);
    conn = ds.getConnection();
    }catch(Exception e)
    {
      System.out.println(e);
    }
%>
<%=conn%>
