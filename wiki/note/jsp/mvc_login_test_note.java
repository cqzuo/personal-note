1.������¼��������:
     �ŵ�:DAO�������ݲ����
            jap������ʾ
	ȱ��:javaBean��jsp����������
2.mvcģʽ:���javaBean��jsp������ϵ�����
3.��������
	ȥ��ʧ��ҳ,����¼ʧ����Ϣ��ʾ�ڵ�¼ҳ
	�Դ�����ʾ���Ӵ�����Ϣ��ʾ(����Ϊ��,���Ȳ�����)
	ʹ��servlet���滻��¼��֤
4.�Ե�¼ҳ���������
	<%
		if(request.getAttribute("errors")!=null)
		{
			// �д���Ҫ���д�ӡ���
			List all = (List)request.getAttribute("errors") ;
			Iterator iter = all.iterator() ;
			while(iter.hasNext())
			{
	%>
				<li><%=iter.next()%>
	<%
			}
		}
	%>
//ע��List��������: ����iterator()������װΪiterator����,��while(iter.next()){}���
  ��һ��servlet����������
// ����MVC�е�C�����JSP+Servlet+JavaBean�Ŀ���ģʽ
//servlet������ ���Ƶ���
package org.lxh.servlet ;

import java.io.* ;
import java.util.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
import org.lxh.factory.* ;
import org.lxh.vo.* ;

public class LoginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		this.doPost(request,response) ;
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		// ����һ�������࣬���ڱ��������Ϣ
		List errors = new ArrayList() ;
		// ��ɵ�½��֤���滻��login_conf.jsp
		String path = "login.jsp" ;
		// 1��������������
		String id = request.getParameter("id") ;
		String password = request.getParameter("password") ;
		// 2���������ݺϷ�����֤�������Ƿ�Ϊ�գ������Ƿ������
		// Ҫ�����յ����������ø�PersonVO����
		PersonVo pv = new PersonVo() ;
		pv.setId(id) ;
		pv.setPassword(password) ;
		pv.setErrors(errors) ;
		// 3������Ϸ�����������ݿ���֤
		if(pv.invalidate())
		{
			// ���ݺϷ������Խ������ݿ���֤
			if(DAOFactory.getPersonDAOInstance().isLogin(pv))
			{
				// �û�ID������Ϸ�
				// �޸���ת·��
				// �����û�����request��Χ֮��
				// request.setAttribute("name",pv.getName()) ;
				path = "login_success.jsp" ;
			}
			else
			{
				// �û�ID������Ƿ�
				errors.add("������û�ID�����룡") ;
			}
		}
		// ��������Ϣ����
		request.setAttribute("errors",errors) ;
		request.setAttribute("person",pv) ;
		request.getRequestDispatcher(path).forward(request,response) ;
	}
};
