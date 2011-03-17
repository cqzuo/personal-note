/*
  1. ActionContext
      1) ʹ���龰
          ��Action��ֱ�ӻ�ȡ�����Ự��һЩ��Ϣ
          ֱ�Ӷ�JavaServlet Http������(HttpServletRequest),��Ӧ(HttpServletResponse)����
      2) ʹ��
          ��ȡrequest�е���Ϣ
	  Map map = ActionContext.getContext().getParameters();
	  String ����ֵ = (String)map.get("��������")
          ��ȡsession
	  Map session= ActionContext.getContext().getSession();
*/
1. ActionContext
��Struts2������,���˽���������Զ����õ�Action���ֶ���,��������Ҳ��Ҫ��Action��ֱ�ӻ�ȡ����(Request)��Ự(Session)��һЩ��Ϣ,������Ҫֱ�Ӷ�JavaServlet Http������(HttpServletRequest),��Ӧ(HttpServletResponse)����. ������Ҫ��Action��ȡ��request�������"username"��ֵ:
ActionContext context = ActionContext.getContext(); 
Map params = context.getParameters(); 
String username = (String) params.get("username");
ActionContext(com.opensymphony.xwork.ActionContext)��Actionִ��ʱ��������,�����Ŀ��Կ�����һ������(��ʵ�����������������һ��Map����),����ŵ���Action��ִ��ʱ��Ҫ�õ��Ķ���. һ�����, ���ǵ�ActionContext����ͨ��: ActionContext context = (ActionContext) actionContext.get();����ȡ��.�����������������actionContext����Ĵ���:
static ThreadLocal actionContext = new ActionContextThreadLocal();
ActionContextThreadLocal��ʵ��ThreadLocal��һ���ڲ���.ThreadLocal��������Ϊ"�ֲ߳̾�����",��Ϊÿһ��ʹ�øñ������̶߳��ṩһ������ֵ�ĸ���,ʹÿһ���̶߳����Զ����ظı��Լ��ĸ���,������������̵߳ĸ�����ͻ.����,����ActionContext�������ֻ���ڶ�Ӧ�ĵ�ǰ�����߳��пɼ�,�Ӷ���֤�����̰߳�ȫ��.
ͨ��ActionContextȡ��HttpSession: Map session = ActionContext.getContext().getSession();
/*
  2. ServletActionContext
     1) �ص�
       �̳���ActionContext
     2) ����
       ����ȡ�õĶ����� Http������,HttpSession����,HTTPservlet��Ӧ����,Servlet��������Ϣ,Httpҳ��������,Servlet���ö���
     3) ʵ��
       + ȡ��HttpServletRequest����
         HttpServletRequest request = ServletActionContext.getRequest();
       + ȡ��HttpSession����
          HttpSession  session = ServletActionContext.getRequest().getSession();
*/
2. ServletActionContext
ServletActionContext(com.opensymphony.webwork. ServletActionContext),�����ֱ�Ӽ̳�������������ܵ�ActionContext,���ṩ��ֱ����Servlet��ض�����ʵĹ���,������ȡ�õĶ�����:
(1)javax.servlet.http.HttpServletRequest : HTTPservlet�������
(2)javax.servlet.http.HttpServletResponse : HTTPservlet��Ӧ����
(3)javax.servlet.ServletContext : Servlet��������Ϣ
(4)javax.servlet.ServletConfig : Servlet���ö���
(5)javax.servlet.jsp.PageContext : Httpҳ��������
��δ�ServletActionContext��ȡ��Servlet����ض���:
<1>ȡ��HttpServletRequest����: HttpServletRequest request = ServletActionContext. getRequest();
<2>ȡ��HttpSession����: HttpSession session = ServletActionContext. getRequest().getSession();
����3. ServletActionContext��ActionContext��ϵ
ServletActionContext��ActionContext����һЩ�ظ��Ĺ���,�����ǵ�Action��,�����ȥ������?������ѭ��ԭ����:���ActionContext�ܹ�ʵ�����ǵĹ���,����þͲ�Ҫʹ��ServletActionContext,�����ǵ�Action������Ҫֱ��ȥ����Servlet����ض���.
ע�⣺��ʹ��ActionContextʱ��һ��Ҫע��: ��Ҫ��Action�Ĺ��캯����ʹ��ActionContext.getContext(),��Ϊ���ʱ��ActionContext���һЩֵҲ��û������,��ʱͨ��ActionContextȡ�õ�ֵҲ����null��ͬ����HttpServletRequest req = ServletActionContext.getRequest()Ҳ��Ҫ���ڹ��캯���У�Ҳ��Ҫֱ�ӽ�req��Ϊ��������丳ֵ������ԭ����������Ϊǰ�潲����static ThreadLocal actionContext = new ActionContextThreadLocal()�����������ǿ��Կ���ActionContext���̰߳�ȫ�ģ���ServletActionContext�̳���ActionContext������ServletActionContextҲ�̰߳�ȫ���̰߳�ȫҪ��ÿ���̶߳��������У�����req�Ĵ���ҲҪ��������У�����ServletActionContext.getRequest()��仰��Ҫ���ڹ��캯���У�Ҳ��Ҫֱ�ӷ������У���Ӧ�÷���ÿ������ķ�������(eg��login()��queryAll()��insert()��)���������ܱ�֤ÿ�β�������ʱ�����Ľ�����һ��req��
����4. struts2�л��request��response��session
(1)��IoC��ʽ
����һ��ʹ��org.apache.struts2.ActionContext�࣬ͨ�����ľ�̬����getContext()��ȡ��ǰAction�������Ķ���
ActionContext ctx = ActionContext.getContext();
ctx.put("liuwei", "andy"); //request.setAttribute("liuwei", "andy"); 
Map session = ctx.getSession(); //session
HttpServletRequest request = ctx.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST); 
HttpServletResponse response = ctx.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
ϸ�ĵ����ѿ��Է��������session�Ǹ�Map����, ��Struts2�еײ��session������װ����Map����. ���ǿ���ֱ�Ӳ������Map������ж�session��д��Ͷ�ȡ����, ������ȥֱ�Ӳ���HttpSession����.
��������ʹ��org.apache.struts2.ServletActionContext��
public class UserAction extends ActionSupport { 
     
    //��������Ƭ�� 
     
    private HttpServletRequest req; 
// private HttpServletRequest req = ServletActionContext.getRequest(); �������������λ���Ǵ���ģ�ͬ�������������ڹ��췽����Ҳ�Ǵ���ġ�
    public String login() { 
        req = ServletActionContext.getRequest(); //req�Ļ�ñ����ھ���ķ�����ʵ�� 
        user = new User(); 
        user.setUid(uid); 
        user.setPassword(password); 
        if (userDAO.isLogin(user)) { 
            req.getSession().setAttribute("user", user); 
            return SUCCESS; 
        } 
        return LOGIN; 
    } 
    public String queryAll() { 
        req = ServletActionContext.getRequest(); //req�Ļ�ñ����ھ���ķ�����ʵ�� 
        uList = userDAO.queryAll(); 
        req.getSession().setAttribute("uList", uList); 
        return SUCCESS; 
    } 
     
    //��������Ƭ�� 
}
(2)IoC��ʽ(��ʹ��Struts2 Aware������)
Ҫʹ��IoC��ʽ����������Ҫ����IoC����(Container)��ȡ��ĳ���������Ը��ͨ��ʵ����Ӧ�Ľӿ�������㡣
public class UserAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {
    private HttpServletRequest request; 
    private HttpServletResponse response;
    public void setServletRequest(HttpServletRequest request) { 
        this.request = request; 
    }
    public void setServletResponse(HttpServletResponse response) { 
        this.response = response; 
    }
    public String execute() { 
        HttpSession session = request.getSession(); 
        return SUCCESS; 
    } 
}