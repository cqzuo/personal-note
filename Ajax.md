%toc
## ajax�ļ������� ##
> - �첽��javaScript��xml
  * ʹ��xhtml��css�Ļ��ڱ�׼����ʾ����
  * ʹ��dom���ж�̬��ʾ�ͽ���
  * ʹ��xml��xslt�������ݽ����ʹ���
  * ʹ��XMLHTTPRequest�����첽���ݼ���
  * ʹ��javaScript�����ϼ����ں�
## ajax��ʵ�� ##
  * �½�servlet
> > - ����
{{{class="brush:java"
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ClassicServer extends HttpServlet {

> protected void doGet(HttpServletRequest request, HttpServletResponse response)
> > throws ServletException, IOException {
> > try{
> > > response.setContentType("text/html;charset=GB2312");
> > > PrintWriter out = response.getWriter();
> > > String old = request.getParameter("name");
> > > if(old == null || old.length() == 0){
> > > > out.println("�û�������Ϊ��");

> > > } else{
> > > > String name = new String(old.getBytes("ISO8859-1"));
> > > > if(name.equals("wangxingkui")){
> > > > > out.println("�û���[" + name + "]�Ѿ����ڣ���ʹ�������û���");

> > > > } else{
> > > > > out.println("�û���[" + name + "]��δ���ڣ�����ʹ�ø��û���ע��");

> > > > }

> > > }
> > > out.println("<br /><a href='\"index.html\">����У��ҳ��</a'>");<br>
</li></ul><blockquote>} catch(Exception e){
> > > e.printStackTrace();

> > }

> }
> protected void doPost(HttpServletRequest request, HttpServletResponse response)
> > throws ServletException, IOException {
> > doGet(request,response);

> }
> }}}}
 - ����servlet
{{{class="brush: xml"
<servlet>
        <servlet-name>ClassicServer</servlet-name>
        <servlet-class>ClassicServer</servlet-class>
    </servlet>
 <servlet-mapping>
        <servlet-name>ClassicServer</servlet-name>
        <url-pattern>/ClassicServer</url-pattern>
    </servlet-mapping> 
}}}
 - ��������servlet
{{{class="brush: java"
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * Created by IntelliJ IDEA.
 * User: ming
 * Date: 2008-6-11
 * Time: 11:11:34
 * To change this template use File | Settings | File Templates.
 */
public class AJAXServer extends HttpServlet{
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try{
//            request.setCharacterEncoding("UTF-8");
//            response.setContentType("text/html;charset=gb18030");

            httpServletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();

            Integer inte = (Integer) httpServletRequest.getSession().getAttribute("total");
            int temp = 0;
            if (inte == null) {
                temp = 1;
            } else {
                temp = inte.intValue() + 1;
            }
            httpServletRequest.getSession().setAttribute("total",temp);

            //1.ȡ����
            String old = httpServletRequest.getParameter("name");
            //String name = new String(old.getBytes("iso8859-1"),"UTF-8");
            String name = URLDecoder.decode(old,"UTF-8");
            //2.���������Ƿ�������
            if(old == null || old.length() == 0){
                out.println("�û�������Ϊ��");
            } else{
//                String name = URLDecoder.decode(old,"UTF-8");
//                byte[] by = old.getBytes("ISO8859-1");
//                String name = new String(by,"utf-8");
//                String name = URLDecoder.decode(old,"utf-8");
                //3.У������
//                String name = old;
                if(name.equals("wangxingkui")){
                    //4���ʹ�ͳӦ�ò�֮ͬ������һ����Ҫ���û�����Ȥ�����ݷ��ظ�ҳ���Σ������ǽ�һ���µ�ҳ�淢�͸��û�
                    //д��û�б仯�����ʷ����˸ı�
                    out.println("�û���[" + name + "]�Ѿ����ڣ���ʹ�������û���, " + temp);
                } else{
                    out.println("�û���[" + name + "]��δ���ڣ�����ʹ�ø��û���ע��, " + temp);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
}
 
}}}
=== ajax���� ===
  * ȡ����
  * У������
  * У������
  * �������ݿ���ȡ�����ݷ��ص�ҳ��
 - 
== ajax��˼ά��ʽ ==
 * �û�����δ�ж�
 * ÿ�ν���Ϣ����֮���᷵��һ���ص�����,XMLHTTPRequest�ҵ�����ִ�к����еĴ���
 * �봫ͳģʽ������
  - ����ȡ����
  - XMLHTTPRequest��������֮��,���ص�ֵ��ע���Ļص���������ʾ��ҳ����
```