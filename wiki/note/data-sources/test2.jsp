<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <body>
  <%
   try {
    Context envContext = (Context) new InitialContext()
      .lookup("java:/comp/env");
    DataSource ds = (DataSource) envContext.lookup("jdbc/lord"); //²éÕÒÅäÖÃ

    Connection conn = ds.getConnection();
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("select name from person");

    while (rs.next()) {
     out.println(rs.getString("name") + "<br>");
    }
   } catch (NamingException e) {
    e.printStackTrace();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  %>
 </body>
</html>


