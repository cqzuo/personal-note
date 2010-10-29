package hello;
 
 import java.io.IOException;
 import java.io.PrintWriter;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 import com.lord.test.mvn.App;  // 引用app工程中的App类
 
  public class HelloServlet extends HttpServlet {
     private static final long serialVersionUID = -3696470690560528247L;
     public void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
         App app = new App();
         String str = app.getStr("CE Maven Demo");
         PrintWriter out = response.getWriter();
         out.print("<html><body>");
         out.print("<h1>" + str);
         out.print("</body></html>");
     }
 }
