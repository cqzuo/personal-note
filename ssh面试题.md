%toc
## Hibernate ##
### ԭ�� ###
  1. ��ȡ�����������ļ�
  1. ��ȡ������ӳ����Ϣ������sessionFactory
  1. ����Sesssion
  1. ��������Transation
  1. �־û�����
  1. �ύ����
  1. �ر�Session
  1. �ر�sesstionFactory
### ΪʲôҪ�� ###
  1. ��JDBC�������ݿ��Ĵ������˷�װ���������������ݷ��ʲ㷱�����ظ��Դ��롣
  1. Hibernate��һ������JDBC�������־û����ܣ���һ��������ORMʵ�֡����ܴ��̶ȵļ���DAO���ı��빤��
  1. hibernateʹ��Java�������ƣ��������ֽ�����ǿ������ʵ��͸���ԡ�
  1. hibernate�����ܷǳ��ã���Ϊ���Ǹ����������ܡ�ӳ���������Ժܳ�ɫ����֧�ָ��ֹ�ϵ���ݿ⣬��һ��һ�����Զ��ĸ��ָ��ӹ�ϵ��
### [[hibernate�������ӳټ���|hibernate�������ӳټ���]] ###
  1. Hibernate2�ӳټ���ʵ�֣�a)ʵ������ b)���ϣ�Collection��
  1. Hibernate3 �ṩ�����Ե��ӳټ��ع���
  1. ��Hibernate�ڲ�ѯ���ݵ�ʱ�������ݲ�û�д������ڴ��У����������������ݵĲ���ʱ�������Ŵ������ڴ��У���ʵ�����ӳټ��أ�����ʡ�˷��������ڴ濪�����Ӷ������˷����������ܡ�
### Hibernate������ʵ����֮���Ĺ�ϵ ###
> ������֮���Ĺ�ϵ��Ҫ�����ڱ�����֮���Ĺ�ϵ���в��������Ƕ��ǶԶ������в��������ǳ����а����еı����඼ӳ����һ��������ͨ�������ļ��е�many-to-one��one-to-many��many-to-many��
### ˵��[[Hibernate�Ļ�������|Hibernate�Ļ�������]] ###
  1. �ڲ���������Hibernate���ֽ�һ�����棬����Ӧ�����񼶻���
  1. �������棺
> > - Ӧ�ü�����
> > - �ֲ�ʽ����
> > > - ���������ݲ��ᱻ�������޸ġ����ݴ�С�ڿɽ��ܷ�Χ�����ݸ���Ƶ�ʵ͡�ͬһ���ݱ�ϵͳƵ��ʹ�á��� �ؼ�����

> > - ������������ʵ��
### [[hibernate�Ĳ�ѯ��ʽ|hibernate�Ĳ�ѯ��ʽ]] ###

> - Sql��Criteria,object comptosition Hql��
  1. ���Բ�ѯ
  1. ������ѯ������������ѯ
  1. ������ѯ
  1. ��ҳ��ѯ
  1. ͳ�ƺ���
### �����Ż�Hibernate ###
  1. ʹ��˫��һ�Զ���������ʹ�õ���һ�Զ�
  1. ����ʹ�õ���һ�Զ�����
  1. ����һ��һ���ö���һȡ��
  1. ���ö��󻺴棬��ʹ�ü��ϻ���
  1. һ�Զ༯��ʹ��Bag,���Զ༯��ʹ��Set
  1. �̳���ʹ����ʽ��̬
  1. ���ֶ�Ҫ�٣���������Ҫ�¶࣬�ж�����������
## Struts1 ##
### �������� ###
> - ��webӦ������ʱ�ͻ����س�ʼ��actionServlet,actionServlet��struts-config.xml�ļ��ж�ȡ������Ϣ,�����Ǵ��ŵ��������ö���
> - ��actionServlet���յ�һ���ͻ�����ʱ,��ִ����������
    1. �������û�����ƥ����actionMappingʵ��,����������,�ͷ�������·����Ч��Ϣ;
    1. ����actionFormʵ��������,�ʹ���һ��actionForm����,�ѿͻ��ύ�ı������ݱ��浽actionForm������;
    1. ����������Ϣ�����Ƿ���Ҫ������֤.������Ҫ��֤,�͵���actionForm��validate()����;
    1. ����actionForm��validate()��������null�򷵻�һ��������actionMessage��actuibErrors����, �ͱ�ʾ������֤�ɹ�;
    1. actionServlet����actionMapping��������ӳ����Ϣ����������ת�����ĸ�Action,������Ӧ�� Actionʵ��������,���ȴ�������ʵ��,Ȼ������Action��execute()����;
    1. Action��execute()��������һ��actionForward����,actionServlet�ڰѿͻ�����ת���� actionForward����ָ����JSP����;
    1. actionForward����ָ��JSP�������ɶ�̬��ҳ,���ظ��ͻ�;
### ΪʲôҪ�� ###
> - JSP��Servlet��JavaBean�����ĳ��ָ����ǹ���ǿ������ҵӦ��ϵͳ�ṩ�˿��ܡ�������Щ����������ϵͳ�ǳ��ķ��ң������ڴ�֮�ϣ�������Ҫһ��������һ������Щ������֯�����Ĺ����������ǿ��ܣ�Struts��Ӧ�˶�����
> - ����Struts������Ӧ����3���������ɣ�������������ģ����������ͼ����
### Struts��validate������������֤�ģ� ###
> ��struts�����ļ������þ����Ĵ�����ʾ������formBean�е�validate()�����������á�
### ˵��Struts������ģʽ ###
> MVCģʽ: webӦ�ó�������ʱ�ͻ����ز���ʼ��actionServlert���û��ύ����ʱ��һ�����úõ�actionForm���󱻴�������������������Ӧ�����ݣ�ActionServler����Struts-config.xml�ļ����úõ����þ����Ƿ���Ҫ������֤��������Ҫ�͵���actionForm�� Validate������֤��ѡ�����������͵��ĸ�Action������Action�����ڣ�actionServlet���ȴ�������������Ȼ������ Action��execute����������Execute������actionForm�����л�ȡ���ݣ�����ҵ���߼�������һ��actionForward������actionServlet�ٰѿͻ�����ת����actionForward����ָ����jsp������actionForward����ָ����jsp���ɶ�̬����ҳ�����ظ��ͻ���
## spring ##
### spring�������� ###
  1. spring mvc�����е��������ύ��DispatcherServlet,����ί��Ӧ��ϵͳ������ģ�鸺���������������������Ĵ���������
  1. DispatcherServlet��ѯһ��������HandlerMapping,�ҵ�����������Controller
  1. DispatcherServlet�������ύ��Ŀ��Controller
  1. Controller����ҵ���߼������󣬻᷵��һ��ModelAndView
  1. Dispathcher��ѯһ��������ViewResolver��ͼ������,�ҵ�ModelAndView����ָ������ͼ����
  1. ��ͼ����������Ⱦ���ظ��ͻ��ˡ�
### Ϊʲô�� ###
> AOP �ÿ�����Ա���Դ�������Ϊ�ԵĹ�ע�㣬��Ϊ���й�ע�㣬�������ǲ��뵽Ӧ�ó��������С�ʹ�� AOP �󣬹������� ��������־���־��ԡ������ȣ��Ϳ��Էֽ��ɷ��沢Ӧ�õ��������ϣ�ͬʱ���������������Ķ���ģ�͵ĸ����ԡ�
> IOC ��������һ�����Թ���������Ӧ�û�����Ȼ������Щ���󴫵����ǵ�Э�����������絥�� ���� �������ģ�IOC ������ ������ JNDI��û��ʹ��һ�ѳ��󹤳���������λ������Ԫ�أ�singleton����ֱ�ӹ��죨straight construction����ÿһ��������������Э�����������ġ�����������������Э��������collaborator����
> Spring��ʹһ��AOP���ܣ�Ҳ��һIOC������ Spring ���õĵط��������������滻���������� Spring��ֻҪ�� JavaBean ���Ժ������ļ����������ԣ�Э�����󣩡�Ȼ�����Ժ����׵�����Ҫʱ�滻�������ƽӿڵ�Э������
Spring ������һ���ֲ��ܹ����� 7 ���������õ�ģ�����ɡ�Spring ģ�鹹���ں�������֮�ϣ��������������˴��������ú͹��� bean �ķ�ʽ
���� Spring ���ܵ�ÿ��ģ�飨�������������Ե������ڣ�����������һ��������ģ������ʵ�֡�ÿ��ģ���Ĺ������£�
�� �������������������ṩ Spring ���ܵĻ������ܡ�������������Ҫ������ BeanFactory�����ǹ���ģʽ��ʵ�֡�BeanFactory ʹ�ÿ��Ʒ�ת ��IOC��ģʽ��Ӧ�ó��������ú������Թ淶��ʵ�ʵ�Ӧ�ó��������ֿ���
�� Spring �����ģ�Spring ��������һ�������ļ����� Spring �����ṩ��������Ϣ��Spring �����İ�����ҵ���������� JNDI��EJB�������ʼ������ʻ���У���͵��ȹ��ܡ�
�� Spring AOP��ͨ�����ù������ԣ�Spring AOP ģ��ֱ�ӽ����������ı��̹��ܼ��ɵ��� Spring �����С����ԣ����Ժ����׵�ʹ Spring ���ܹ������κζ���֧�� AOP��Spring AOP ģ��Ϊ���� Spring ��Ӧ�ó����еĶ����ṩ����������������ͨ��ʹ�� Spring AOP���������� EJB �������Ϳ��Խ������������������ɵ�Ӧ�ó����С�
�� Spring DAO��JDBC DAO �������ṩ�����������쳣���νṹ�����øýṹ�������쳣�����Ͳ�ͬ���ݿ⹩Ӧ���׳��Ĵ�����Ϣ���쳣���νṹ�����˴������������Ҽ����ؽ�������Ҫ��д���쳣���������������򿪺͹ر����ӣ���Spring DAO ������ JDBC ���쳣����ͨ�õ� DAO �쳣���νṹ��
�� Spring ORM��Spring ���ܲ��������ɸ� ORM ���ܣ��Ӷ��ṩ�� ORM �Ķ�����ϵ���ߣ����а��� JDO��Hibernate �� iBatis SQL Map��������Щ������ Spring ��ͨ�������� DAO �쳣���νṹ��
�� Spring Web ģ�飺Web ������ģ�齨����Ӧ�ó���������ģ��֮�ϣ�Ϊ���� Web ��Ӧ�ó����ṩ�������ġ����ԣ�Spring ����֧���� Jakarta Struts �ļ��ɡ�Web ģ�黹�����˴����ಿ�������Լ������������󶨵��������Ĺ�����
�� Spring MVC ���ܣ�MVC ������һ��ȫ���ܵĹ��� Web Ӧ�ó����� MVC ʵ�֡�ͨ�����Խӿڣ�MVC ���ܱ���Ϊ�߶ȿ����õģ�MVC �����˴�����ͼ���������а��� JSP��Velocity��Tiles��iText �� POI��
Spring ���ܵĹ��ܿ��������κ� J2EE �������У�����������Ҳ�����ڲ��ܹ����Ļ�����Spring �ĺ���Ҫ���ǣ�֧�ֲ��󶨵��ض� J2EE �����Ŀ�����ҵ�������ݷ��ʶ��󡣺������ʣ������Ķ��������ڲ�ͬ J2EE ���� ��Web �� EJB��������Ӧ�ó��򡢲��Ի���֮�����á�
IOC �� AOP
���Ʒ�תģʽ��Ҳ���������Խ��룩�Ļ��������ǣ����������󣬵��������������ǵķ�ʽ���ڴ����в�ֱ���������ͷ������ӣ����������ļ���������һ��������Ҫ��һ���������������� Spring �������� IOC ������ ��������Щ��ϵ��һ����
�ڵ��͵� IOC �����У��������������ж��󣬲����ñ�Ҫ�����Խ�����������һ�𣬾���ʲôʱ�����÷������±��г��� IOC ��һ��ʵ��ģʽ��

Spring ���ܵ� IOC ������������ 2 ������3 ʵ�֡�
���������ı���
���������ı��̣��� AOP����һ�ֱ��̼���������������Ա�Ժ��й�ע�������е��͵�ְ���ֽ��ߵ���Ϊ��������־����������������ģ�黯��AOP �ĺ��Ĺ����Ƿ��棬������ЩӰ������������Ϊ��װ�������õ�ģ���С�
AOP �� IOC �ǲ����Եļ��������Ƕ�����ģ�黯��ʽ������ҵӦ�ó��򿪷��еĸ������⡣�ڵ��͵��������󿪷���ʽ�У�����Ҫ����־��¼�����������з����� Java ���в���ʵ����־���ܡ��� AOP ��ʽ�У����Է���������־����ģ�黯�����������ķ�ʽ������Ӧ�õ���Ҫ��־�������ϡ���Ȼ�����ƾ��� Java �಻��Ҫ֪����־�����Ĵ��ڣ�Ҳ����Ҫ�������صĴ��롣���ԣ��� Spring AOP ��д��Ӧ�ó�����������ɢ���ϵġ�
AOP �Ĺ�����ȫ���ɵ��� Spring ������������־�������������Ե��������С�
IOC ����
Spring ���Ƶĺ����� org.springframework.beans ������������Ŀ������ JavaBean ����һ��ʹ�á�������ͨ���������û�ֱ��ʹ�ã������ɷ������������������������ܵĵײ��н顣��һ�����߼������� BeanFactory �ӿڣ����ǹ�������ģʽ��ʵ�֣�����ͨ�����ƴ����ͼ���������BeanFactory Ҳ���Թ�������֮���Ĺ�ϵ��
BeanFactory ֧����������ģ�͡�
�� ��̬ ģ���ṩ�˾����ض����ƵĶ����Ĺ���ʵ���������ڲ�ѯʱ�������м�����Singleton ��Ĭ�ϵ�Ҳ����õĶ���ģ�͡�������״̬�������������롣
�� ԭ�� ģ��ȷ��ÿ�μ������ᴴ�������Ķ�������ÿ���û�����Ҫ�Լ��Ķ���ʱ��ԭ��ģ�����ʺϡ�
bean �����ĸ����� Spring ��Ϊ IOC �����Ļ�����IOC ���������������δ�Ӧ�ó�������ת�Ƶ����ܡ������ҽ�����һ��ʾ������ʾ��������Spring ����ʹ�� JavaBean ���Ժ�����������ָ���������õ�������ϵ��
BeanFactory �ӿ�
��Ϊ org.springframework.beans.factory.BeanFactory ��һ���򵥽ӿڣ����Կ������Ը��ֵײ��洢����ʵ�֡���õ� BeanFactory ������ XmlBeanFactory�������� XML �ļ��еĶ���װ�� bean�����嵥 1 ��ʾ��
�嵥 1. XmlBeanFactory
BeanFactory factory = new XMLBeanFactory(new FileInputSteam("mybean.xml"));
�� XML �ļ��ж����� Bean �Ǳ��������صģ�����ζ����Ҫ bean ֮ǰ��bean �������ᱻ��ʼ����Ҫ�� BeanFactory ���� bean��ֻ������ getBean() ���������뽫Ҫ������ bean �����Ƽ��ɣ����嵥 2 ��ʾ��
�嵥 2. getBean()
MyBean mybean = (MyBean) factory.getBean("mybean");
ÿ�� bean �Ķ��嶼������ POJO ���������� JavaBean ��ʼ�����Զ��壩 �� FactoryBean��FactoryBean �ӿ�Ϊʹ�� Spring ���ܹ�����Ӧ�ó���������һ�����ӵļ�����
IOC ʾ��
�������Ʒ�ת���򵥵ķ�ʽ���ǿ�����ʵ��Ӧ�á��ڶ������������ɵ� Spring ϵ�� �ĵ� 1 ���ֽ����ܽ�ʱ����ʹ����һ��ʾ������ʾ������ͨ�� Spring IOC ����ע��Ӧ�ó�����������ϵ�������ǽ����ǹ�����������
���ÿ������������ʻ���������Ϊ���㡣���ڸ�ʵ�֣����������ʻ�Ҫ���û������·������н�����
�� ���ü����������񣬲�ѯ�û���������ʷ��Ϣ��
�� Զ����Ϣ���ӷ��񣬲����ͻ���Ϣ�����ͻ���Ϣ�����ÿ���������Ϣ�����������Խ����Զ����ǣ�������Ҫ�Ļ�����
�� �����ʼ����������û������й����ÿ�״̬�ĵ����ʼ���
�����ӿ�
��������ʾ�����Ҽ��������Ѿ����ڣ�����������������ɢ���ϵķ�ʽ�����Ǽ�����һ���������嵥��ʾ������������Ӧ�ó����ӿڡ�
�嵥 3. CreditRatingInterface
public interface CreditRatingInterface {
public boolean getUserCreditHistoryInformation(ICustomer iCustomer);
}
�嵥 3 ��ʾ�����ü��������ӿ��ṩ��������ʷ��Ϣ������Ҫһ�������ͻ���Ϣ�� Customer ���󡣸ýӿڵ�ʵ������ CreditRating ���ṩ�ġ�
�嵥 4. CreditLinkingInterface
public interface CreditLinkingInterface {
public String getUrl();
public void setUrl(String url);
public void linkCreditBankAccount() throws Exception ;
}
�������ӽӿڽ�������ʷ��Ϣ��������Ϣ��������Ҫ�Ļ���������һ�𣬲������û������ÿ���Ϣ���������ӽӿ���һ��Զ�̷��������Ĳ�ѯ��ͨ�� getUrl() �������еġ�URL �� Spring ���ܵ� bean ���û������ã����Ժ������������ýӿڵ�ʵ������ CreditLinking ���ṩ�ġ�
�嵥 5. EmailInterface
public interface EmailInterface {
public void sendEmail(ICustomer iCustomer);
public String getFromEmail();
public void setFromEmail(String fromEmail) ;
public String getPassword();
public void setPassword(String password) ;
public String getSmtpHost() ;
public void setSmtpHost(String smtpHost);
public String getUserId() ;
public void setUserId(String userId);
## ���Լ��Ļ���Ҫ����struts2��ִ�����̡� ##
> - Struts 2���ܱ������¿��Է�Ϊ3�����֣����Ŀ�����FilterDispatcher��ҵ��������Action���û�ʵ�ֵ���ҵҵ���߼�������
> - ���Ŀ�����FilterDispatcher��Struts 2���ܵĻ����������˿����ڲ��Ŀ������̺ʹ������ơ�
> - ҵ��������Action��ҵ���߼���������Ҫ�û����Լ�ʵ�ֵġ��û��ڿ���Action��ҵ���߼�������ͬʱ������Ҫ��д���ص������ļ��������Ŀ�����FilterDispatcher��ʹ�á� S
> - truts 2�Ĺ�������������Struts 1Ҫ�򵥣���WebWork���ܻ�����ͬ������˵Struts 2��WebWork�������汾��������Ҫ�������£�
    1. �ͻ�������������HTTP������
    1. ����web.xml���ã���������FilterDispatcher���ա�
    1. ����struts.xml���ã��ҵ���Ҫ���õ�Action���ͷ����� ��ͨ��IoC��ʽ����ֵע����Aciton��
    1. Action����ҵ���߼���������ҵ���߼�����һ������������֤��
    1. Actionִ�����ϣ�����struts.xml�е������ҵ���Ӧ�ķ��ؽ���result������ת����Ӧҳ�档
    1. ����HTTP��Ӧ���ͻ�����������
- һ��������Struts2�����еĴ������ŷ�Ϊ���¼�������
    1. �ͻ��˳�ʼ��һ��ָ��Servlet����������Tomcat��������
    1. �������󾭹�һϵ�еĹ�������Filter������Щ����������һ������ActionContextCleanUp�Ŀ�ѡ����������������������Struts2���������ܵļ��ɺ��а��������磺SiteMesh Plugin��
    1. ����FilterDispatcher�����ã�FilterDispatcherѯ��ActionMapper�������������Ƿ���Ҫ����ĳ��Action
    1. ����ActionMapper������Ҫ����ĳ��Action��FilterDispatcher�������Ĵ�������ActionProxy
    1. ActionProxyͨ��Configuration Managerѯ�ʿ��ܵ������ļ����ҵ���Ҫ���õ�Action��
    1. ActionProxy����һ��ActionInvocation��ʵ����
    1. ActionInvocationʵ��ʹ������ģʽ�����ã��ڵ���Action�Ĺ���ǰ�����漰��������������Intercepter���ĵ��á�
    1. һ��Actionִ�����ϣ�ActionInvocation��������struts.xml�е������ҵ���Ӧ�ķ��ؽ��������ؽ���ͨ���ǣ��������ǣ�Ҳ�� ����������һ��Action����һ����Ҫ����ʾ��JSP����FreeMarker��ģ�档�ڱ�ʾ�Ĺ����п���ʹ��Struts2 �����м̳еı�ǩ����������������Ҫ�漰��ActionMapper
- ���������������еĶ�����Action��Results��Interceptors���ȣ�����ͨ��ObjectFactory�������ġ�
һ��spring����ԭ����
1.spring mvc�����е��������ύ��DispatcherServlet,����ί��Ӧ��ϵͳ������ģ�鸺���������������������Ĵ���������
2.DispatcherServlet��ѯһ��������HandlerMapping,�ҵ�����������Controller.
3.DispatcherServlet�������ύ��Ŀ��Controller
4.Controller����ҵ���߼������󣬻᷵��һ��ModelAndView
5.Dispathcher��ѯһ��������ViewResolver��ͼ������,�ҵ�ModelAndView����ָ������ͼ����
6.��ͼ����������Ⱦ���ظ��ͻ��ˡ�

����ΪʲôҪ��spring:
AOP �ÿ�����Ա���Դ�������Ϊ�ԵĹ�ע�㣬��Ϊ���й�ע�㣬�������ǲ��뵽Ӧ�ó��������С�ʹ�� AOP �󣬹�������   ���� ����־���־��ԡ������ȣ��Ϳ��Էֽ��ɷ��沢Ӧ�õ��������ϣ�ͬʱ���������������Ķ���ģ�͵ĸ����ԡ�
IOC ��������һ�����Թ���������Ӧ�û�����Ȼ������Щ���󴫵����ǵ�Э�����������絥�� ���� �������ģ�IOC ������      ������ JNDI��û��ʹ��һ�ѳ��󹤳���������λ������Ԫ�أ�singleton����ֱ�ӹ��죨straight construction����ÿһ������������     ��Э�����������ġ�����������������Э��������collaborator����
Spring��ʹһ��AOP���ܣ�Ҳ��һIOC������ Spring ���õĵط��������������滻���������� Spring��ֻҪ�� JavaBean ���Ժ������ļ����������ԣ�Э�����󣩡�Ȼ�����Ժ����׵�����Ҫʱ�滻�������ƽӿڵ�Э��������
��������̸̸SSH���ϣ�
SSH��
Struts����ʾ�㣩+Spring��ҵ���㣩+Hibernate���־ò㣩
Struts��
Struts��һ����ʾ�����ܣ���Ҫ�����ǽ���չʾ���������󣬷ַ�������
��MVC�����У�Struts����VC���Σ������������֣�����MVC��ϵ�ķַ�����View������JSP��HTTP��Form��Tag��Resourse ��Controller��actionServlet��struts-config.xml��Action��
Hibernate��
Hibernate��һ���־ò����ܣ���ֻ��������ϵ���ݿ��Ĳ�����
Spring��
Spring��һ��ҵ�������ܣ���һ�����ϵĿ��ܣ��ܹ��ܺõ����ϱ�ʾ�����־ò㡣
�ġ�����һ��Spring������������
�������Ƕ�һϵ�е����ݿ����������������������ݣ�����ͳһ���ύ���ع����������������ɹ�����ôһ���ɹ��������м���һ�������쳣����ô�ع�֮ǰ�����в�����
�������Է�ֹ���������ݣ���ֹ���ݿ����ݳ������⡣
������Ϊ�˱�����������һ�㶼����������������Spring��Ҳ���Լ��������������ƣ�һ����ʹ��TransactionMananger���й���������ͨ��Spring��ע�������ɴ˹��ܡ�
spring�ṩ�˼������������������ࣺ
TransactionDefinition //�������Զ���
TranscationStatus //�����˵�ǰ�����񣬿����ύ���ع���
PlatformTransactionManager������spring�ṩ�����ڹ��������Ļ����ӿڣ�������һ��ʵ�ֵĳ�����AbstractPlatformTransactionManager,����ʹ�õ���������������DataSourceTransactionManager�ȶ��������������ࡣ
һ���������岽�裺
TransactionDefinition td = new TransactionDefinition();
TransactionStatus ts = transactionManager.getTransaction(td);
try
{ //do sth
transactionManager.commit(ts);
}
catch(Exception e){transactionManager.rollback(ts);}
spring�ṩ�������������Է�Ϊ���ࣺ����ʽ�ĺ�����ʽ�ġ�����ʽ�ģ��Ƚ�������Ǵ������󣬴����ظ��Ĵ����Ƚ϶ࣻ����ʽ�ıȱ���ʽ�ĸ����
����ʽ��Ҫʹ��transactionTemplate��ʡ���˲��ֵ��ύ���ع���һϵ�е������������壬��ע��������������.
void add(){
transactionTemplate.execute( new TransactionCallback(){
pulic Object doInTransaction(TransactionStatus ts)
{ //do sth}
}
}
����ʽ��
ʹ��TransactionProxyFactoryBean:
PROPAGATION\_REQUIRED PROPAGATION\_REQUIRED PROPAGATION\_REQUIRED,readOnly

Χ��Poxy�Ķ�̬���� �ܹ��Զ����ύ�ͻع�����
org.springframework.transaction.interceptor.TransactionProxyFactoryBean
PROPAGATION\_REQUIRED�C֧�ֵ�ǰ������������ǰû�����񣬾��½�һ�����������������ѡ����
PROPAGATION\_SUPPORTS�C֧�ֵ�ǰ������������ǰû�����񣬾��Է�������ʽִ�С�
PROPAGATION\_MANDATORY�C֧�ֵ�ǰ������������ǰû�����񣬾��׳��쳣��
PROPAGATION\_REQUIRES\_NEW�C�½�������������ǰ�������񣬰ѵ�ǰ����������
PROPAGATION\_NOT\_SUPPORTED�C�Է�������ʽִ�в�����������ǰ�������񣬾Ͱѵ�ǰ����������
PROPAGATION\_NEVER�C�Է�������ʽִ�У�������ǰ�������������׳��쳣��
PROPAGATION\_NESTED�C������ǰ��������������Ƕ��������ִ�С�������ǰû����������������PROPAGATION\_REQUIRED���ƵĲ�����
�塢Spring���������������ݿ�������
ʹ�á�org.springframework.jdbc.datasource.DriverManagerDataSource������Դ���������ݿ�������ʾ�����£�


&lt;bean id=��dataSource��&gt;


> 

&lt;property name=��driverClassName��&gt;


> > 

&lt;value&gt;

org.hsqldb.jdbcDriver

&lt;/value&gt;



> 

&lt;/property&gt;


> 

&lt;property name=��url��&gt;


> > 

&lt;value&gt;

jdbc:hsqldb:db/appfuse

&lt;/value&gt;



> 

&lt;/property&gt;


> 

&lt;property name=��username��&gt;&lt;value&gt;sa&lt;/value&gt;&lt;/property&gt;


> 

&lt;property name=��password��&gt;&lt;value&gt;&lt;/value&gt;&lt;/property&gt;




Unknown end tag for &lt;/bean&gt;


����Spring����applicationContext.xml�ļ��ܲ��ܸĳ������ļ�����
ContextLoaderListener��һ��ServletContextListener, ��������webӦ��������ʱ����ʼ����ȱʡ�����£� ������WEB-INF/applicationContext.xml�ļ���Spring�����á� ������ͨ������һ��

&lt;context-param&gt;

Ԫ������Ϊ��contextConfigLocation�����ı�Spring�����ļ���λ�á�ʾ�����£�


&lt;listener&gt;


> 

&lt;listener-class&gt;

org.springframework.web.context.ContextLoaderListener
> 

&lt;context-param&gt;


> > 

&lt;param-name&gt;

contextConfigLocation

&lt;/param-name&gt;


> > 

&lt;param-value&gt;

/WEB-INF/xyz.xml

&lt;/param-value&gt;



> 

&lt;/context-param&gt;


> 

&lt;/listener-class&gt;




&lt;/listener&gt;


�ߡ�������webӦ����������spring?
��web.xml�м�������ͬ��,������web������ʱ����/WEB-INF/applicationContext.xml�е����ݡ�


&lt;servlet&gt;




&lt;servlet-name&gt;

context

&lt;/servlet-name&gt;




&lt;servlet-class&gt;


org.springframework.web.context.ContextLoaderServlet


&lt;/servlet-class&gt;




&lt;load-on-startup&gt;

1

&lt;/load-on-startup&gt;




&lt;/servlet&gt;


ͨ���������õ�ApplicationContextʵ��
> WebApplicationContextUtils.getWebApplicationContext
�ˡ�Spring�������ζ���hibernate mapping��
����hibernate mapping �ļ���web/WEB-INFĿ¼�µ�applicationContext.xml�ļ����档ʾ�����£�


&lt;property name=��mappingResources��&gt;


> 

&lt;list&gt;


> > 

&lt;value&gt;

org/appfuse/model/User.hbm.xml

&lt;/value&gt;



> 

&lt;/list&gt;




&lt;/property&gt;


�š�����һ��Dependency injection(DI,����ע��)��IOC(Inversion of control,���Ʒ�ת)?
����ע��DI��һ����������ģʽ�ͼܹ�ģ�ͣ� һЩʱ��Ҳ�������Ʒ�ת�������ڼ���������������ע����һ��IOC������ʵ�֣�����ע����ָһ������Ӧ������һ���������ṩһ�����������������磺��һ�����ݿ������Ѳ�������ʽ����һ�������Ľṹ�����������������Ǹ������ڲ����д���һ�����ӡ����Ʒ�ת������ע���Ļ���˼�����ǰ��������������ڲ�ת�����ⲿ�Լ�������
Ӧ�ÿ��Ʒ�ת�������ڱ�������ʱ������һ������ϵͳ�����ж���������ʵ�壬�����������Ķ��������ã����ݸ�����Ҳ����˵��������ע�뵽�����С����ԣ����Ʒ�ת�ǣ�����һ���������λ�ȡ���������Ķ��������ã��������εķ�ת��
ʮ��spring�е�BeanFactory��ApplicationContext����������Щ��
1. BeanFactory������ȡbean�����ĵ�������bean�ļ��أ�ʵ������ά��bean֮����������ϵ������bean���������ڡ�
2. ApplicationContext�����ṩ����BeanFactory�����ṩ�Ĺ���֮�⣬���ṩ�˸������Ŀ��ܹ��ܣ�
a. ���ʻ�֧��
b. ��Դ���ʣ�Resource rs = ctx. getResource(��classpath:config.properties��), ��file:c:/config.properties��
c. �¼����ݣ�ͨ��ʵ��ApplicationContextAware�ӿ�
3. ���õĻ�ȡApplicationContext�ķ�����
FileSystemXmlApplicationContext�����ļ�ϵͳ����urlָ����xml�����ļ�����������Ϊ�����ļ������ļ�������
ClassPathXmlApplicationContext����classpath��xml�����ļ����������Դ�jar���ж�ȡ�����ļ�
WebApplicationContextUtils����webӦ�õĸ�Ŀ¼��ȡ�����ļ�����Ҫ����web.xml�����ã��������ü���������servlet��ʵ��


&lt;listener&gt;




&lt;listener-class&gt;

org.springframework.web.context.ContextLoaderListener

&lt;/listener-class&gt;




&lt;/listener&gt;




&lt;servlet&gt;




&lt;servlet-name&gt;

context

&lt;/servlet-name&gt;




&lt;servlet-class&gt;

org.springframework.web.context.ContextLoaderServlet

&lt;/servlet-class&gt;




&lt;load-on-startup&gt;

1

&lt;/load-on-startup&gt;




&lt;/servlet&gt;


�����ַ�ʽ��Ĭ�������ļ�Ϊweb-inf/applicationContext.xml��Ҳ��ʹ��context-paramָ�������ļ�


&lt;context-param&gt;




&lt;param-name&gt;

contextConfigLocation

&lt;/param-name&gt;




&lt;param-value&gt;

/WEB-INF/myApplicationContext.xml

&lt;/param-value&gt;




&lt;/context-param&gt;


ʮһ��������web����������applicationContext.xml�ļ�?


&lt;listener&gt;


> 

&lt;listener-class&gt;


> > org.springframework.web.context.ContextLoaderListener

> 

&lt;/listener-class&gt;




&lt;/listener&gt;


����


&lt;servlet&gt;


> 

&lt;servlet-name&gt;

context

&lt;/servlet-name&gt;


> > 

&lt;servlet-class&gt;


> > > org.springframework.web.context.ContextLoaderServlet

> > 

&lt;/servlet-class&gt;



> 

&lt;load-on-startup&gt;

1

&lt;/load-on-startup&gt;




&lt;/servlet&gt;


ͨ�����·���ȡ��applicationContextʵ��:
ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext);
ʮ������������spring+struts?
��struts-config.xml����һ��������ͨ��������applicationContext.xml
? ��struts-config.xml�޸�action-mapping���ǣ�����action������DelegateActionProxy
? ͨ��DelegateActionProxy����һspring�Ļ�����
? ��spring��applicationContext.xml����

&lt;bean name=��/login�� class=��" singleton=��false��/&gt;


ʮ����spring+hibernate�������ļ��е���Ҫ������Щ?��������?
dataSource
> sessionFactory:hibernate.cfg.xml
> transactionManager
> userDao (extends HibernateDaoSupport)
> sessionFactory
> facade
> proxy
> sessionFactory
> transactionManager
> facade
��myeclipse���ȼ���spring�����ټ���hibernate������
����spring��hibernate������һ�����Բ���Ҫhibernate.cfg.xml�ļ��Ƿ���ȷ
ʮ�ġ�������spring��ʵ�ֹ��ʻ�?
��applicationContext.xml����һ��bean


&lt;bean id=��messageSource�� class=��org.springframework.context.support.ResourceBundleMessageSource��&gt;


> 

&lt;property name=��basename��&gt;


> > 

&lt;value&gt;

message

&lt;/value&gt;



> 

&lt;/property&gt;




&lt;/bean&gt;


? ��srcĿ¼�½�����properties�ļ�
? ���ڷ�Ӣ�ĵ�Ҫ��native2ascii -encoding gb2312 Դ Ŀת���ļ���������
? ��������ʽ��message_����_���ҡ�
? ҳ���е�����ʾ��ʾ��Ϣ������ȡ��ֵ��
? ���������ң�ϵͳ���Զ����ض�Ӧ�Ĺ��ҵ�properties��Ϣ��
? ͨ��applictionContext.getMessage(��������,��������,��������)ȡ�����ص���Ϣ��
ʮ�塢spring�еĺ���������Щ������ʲô����?
BeanFactory������һ���µ�ʵ��������ʵ�ֵ���ģʽ
BeanWrapper���ṩͳһ��get��set����
ApplicationContext:�ṩ���ܵ�ʵ�֣�����BeanFactory�����й���
ʮ����ʲô��aop��aop��������ʲô?
�����������̣�AOP���ṩ����һ�ֽǶ���˼�������ṹ��ͨ�����ַ�ʽ�ֲ��������������̣�OOP���Ĳ���
�����ࣨclasses�����⣬AOP�ṩ�����档�����Թ�ע������ģ�黯���������ж������ͺͶ�������������
Spring��һ���ؼ�����������AOP���ܣ���������ѡ���Ƿ�ʹ��AOP
�ṩ����ʽ��ҵ�������ر���Ϊ������EJB����ʽ����������Ҫ�ķ�����������������������������������Spring�ĳ�����������֮��
�����û�ʵ���Զ������棬��AOP������OOP��ʹ��
���԰�Spring AOP�����Ƕ�Spring��һ����ǿ
ʮ�ߡ�ʹ��Spring��ʲô�ô���
��Spring����Ч����֯�����м�������,�������Ƿ�ѡ��ʹ����EJB������������ʹ����Struts�������İ�����J2EE����APIs��framework�����ᷢ��Spring��ע�������µ����⣬��
��Spring�����������๤���϶�Singleton�Ĺ���ʹ�á������ҵľ��飬����һ����Ҫ�����⣬��������ϵͳ�Ŀɲ����Ժ������������ԡ�
��Spring������ʹ�ø��ָ�����ʽ�����Զ����ļ�����Ҫ,������Ӧ�ú͹����У���ͨ��һ�� һ�µķ������������á������е��Ի���һ���ض���Ҫ�����Իð������Թؼ��ֻ�ϵͳ����,Ϊ�˲��ò���Javadoc����Դ������������Spring������ �ܼ򵥵ؿ�������JavaBean���ԡ����ÿ��Ƶ�ʹ��(����������)�����������ּ򻯡�
��Spring��ͨ���ӿڶ��������ٽ��õı���ϰ�ߣ����ٱ��̴��۵�����Ϊ�㡣
��Spring������Ϊ��ʹ����������Ӧ�þ������ٵ�����������APIs����SpringӦ���еĴ�����ҵ������û��������Spring��
��ʹ��Spring������Ӧ�ó������ڵ�Ԫ���ԡ�
��Spring��ʹEJB��ʹ�ó�Ϊһ��ʵ��ѡ��,������Ӧ�üܹ��ı�Ȼѡ��������ѡ����POJOs��local EJBs��ʵ��ҵ���ӿڣ�ȴ����Ӱ�����ô��롣
��Spring������������������������ʹ��EJB��Spring���ṩһ��EJB���滻�������������webӦ�á�����,Spring��ʹ��AOP�ṩ��������������ͨ��ʹ��EJB������������������Ҫ�뵥�������ݿ��򽻵�����������ҪJTAʵ�֡�
��SpringΪ���ݴ�ȡ�ṩ��һ�µĿ���,������ʹ��JDBC��O/R mapping��Ʒ����Hibernate����
Springȷʵʹ����ͨ�����򵥿��еĽ����취�����������⡣��Щ�������кܴ���ֵ�ġ�
�ܽ�������Spring�������ŵ㣺
��������ʽ���ƣ�������Ⱦ����
�� �����ڸ���Ӧ�÷���������������ʵ��Write Once,Run Anywhere�ĳ�ŵ
��Spring��DI���ƽ�����ҵ�������滻�ĸ�����
��Spring������ȫ������Spring�������߿�����ѡ��Spring���ܵĲ��ֻ�ȫ��
ʮ�ˡ�ʲô��Spring, ����ʲô�ص㣿
Spring��һ���������Ŀ��Ʒ�ת(IoC)����������(AOP)���������ܡ�
�����������Ӵ�С�뿪������������Spring���������ġ�������Spring���ܿ�����һ����Сֻ��1MB����JAR�ļ��﷢������ ��Spring�����Ĵ�������Ҳ��΢�������ġ����⣬Spring�Ƿ�����ʽ�ģ����͵أ�SpringӦ���еĶ�����������Spring���ض��ࡣ
�����Ʒ�ת����Springͨ��һ�ֳ������Ʒ�ת��IoC���ļ����ٽ������� �ϡ���Ӧ����IoC��һ����������������������ͨ�������ķ�ʽ���ݽ��������������������Լ��������߲���������������������ΪIoC��JNDI�෴������ �Ƕ����������в������������������ڶ�����ʼ��ʱ���ȶ����������������������ݸ�����
���������桪��Spring�ṩ�������������̵ķḻ֧�֣�����ͨ������Ӧ�õ� ҵ���߼���ϵͳ���������������ƣ�auditing�������񣨣������������ھ��ԵĿ�����Ӧ�ö���ֻʵ������Ӧ�����ġ�������ҵ���߼��������˶��ѡ����� ������������������ʶ��������ϵͳ����ע�㣬������־������֧�֡�
����������Spring����������Ӧ�ö��������ú��������ڣ����������������� һ����������������������ÿ��bean���α�������������һ��������ԭ�ͣ�prototype��������bean���Դ���һ��������ʵ������ÿ����Ҫʱ���� ��һ���µ�ʵ�������Լ������������໥�����ġ�Ȼ����Spring��Ӧ�ñ���ͬ�ڴ�ͳ����������EJB���������Ǿ������Ӵ��뱿�صģ�����ʹ�á�
�����ܡ���Spring���Խ��򵥵��������á����ϳ�Ϊ���ӵ�Ӧ�á���Spring�У�Ӧ�ö���������ʽ�����ϣ����͵�����һ��XML�ļ��SpringҲ�ṩ�˺ܶ��������ܣ������������־û����ܼ��ɵȵȣ�����Ӧ���߼��Ŀ����������㡣
ʮ�š�������һ��Spring������Bean����������
һ��Bean�Ķ���
Springͨ��ͨ�������ļ�����Bean���磺
<?xml version=��1.0�� encoding=��UTF-8��?>
<beans xmlns=��http://www.springframework.org/schema/beans��
xmlns:xsi=��http://www.w3.org/2001/XMLSchema-instance��
xsi:schemaLocation=��http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd��>


&lt;bean id=��HelloWorld�� class=��com.pqf.beans.HelloWorld��&gt;




&lt;property name=��msg��&gt;




&lt;value&gt;

HelloWorld

&lt;/value&gt;




&lt;/property&gt;




&lt;/bean&gt;




Unknown end tag for &lt;/beans&gt;


���������ļ��Ͷ�����һ����ʶΪ HelloWorld ��Bean����һ�������ĵ��п��Զ�������Bean��
����Bean�ĳ�ʼ��
�����ַ�ʽ��ʼ��Bean��
1���������ĵ���ͨ��ָ��init-method ����������
��Bean������ʵ��һ����ʼ��Bean���Եķ�������init()���磺
public class HelloWorld{
public String msg=null;
public Date date=null;
public void init() {
msg=��HelloWorld��;
date=new Date();
}
����
}
Ȼ�����������ļ�������init-mothod���ԣ�


&lt;bean id=��HelloWorld�� class=��com.pqf.beans.HelloWorld�� init-mothod=��init�� &gt;




&lt;/bean&gt;


2��ʵ�� org.springframwork.beans.factory.InitializingBean�ӿ�
Beanʵ��InitializingBean�ӿڣ��������� afterPropertiesSet() ������
public class HelloWorld implement InitializingBean {
public String msg=null;
public Date date=null;
public void afterPropertiesSet() {
msg=����ȫ�����ʺã���;
date=new Date();
}
����
}
��ô��������Bean���������Ա�Spring��BeanFactory�������󣬻��Զ�����afterPropertiesSet()������Bean���г�ʼ�������ǣ������ļ��Ͳ���ָ�� init-method�����ˡ�
����Bean�ĵ���
�����ַ�ʽ���Եõ�Bean�����е��ã�
1��ʹ��BeanWrapper
HelloWorld hw=new HelloWorld();
BeanWrapper bw=new BeanWrapperImpl(hw);
bw.setPropertyvalue(��msg��,��HelloWorld��);
system.out.println(bw.getPropertyCalue(��msg��));
2��ʹ��BeanFactory
InputStream is=new FileInputStream(��config.xml��);
XmlBeanFactory factory=new XmlBeanFactory(is);
HelloWorld hw=(HelloWorld) factory.getBean(��HelloWorld��);
system.out.println(hw.getMsg());
3��ʹ��ApplicationConttext
ApplicationContext actx=new FleSystemXmlApplicationContext(��config.xml��);
HelloWorld hw=(HelloWorld) actx.getBean(��HelloWorld��);
System.out.println(hw.getMsg());
�ġ�Bean������
1��ʹ�������ļ��е� destory-method ����
����ʼ������ init-methods���ƣ���Bean������ʵ��һ������Bean�ķ�����Ȼ���������ļ���ͨ�� destory-methodָ������ô��bean����ʱ��Spring���Զ�����ָ�������ٷ�����
2��ʵ�� org.springframwork.bean.factory.DisposebleBean�ӿ�
����ʵ����DisposebleBean�ӿڣ���ôSpring���Զ�����bean�е�Destory�����������٣����ԣ�Bean�б����ṩDestory������
��ʮ��AOP������Ҫ�ļ������ʸ������ͣ�
���棨Aspect���� һ����ע����ģ�黯��������ע�����ܻ����ж�������������������J2EEӦ����һ�����ں��й�ע���ĺܺõ����ӡ� ��Spring AOP�У���������ʹ��ͨ���ࣨ����ģʽ�ķ����� ��������ͨ������ @Aspect ע�⣨@AspectJ��������ʵ�֡�
���ӵ㣨Joinpoint���� �ڳ���ִ�й�����ĳ���ض��ĵ㣬����ĳ�������õ�ʱ�����ߴ����쳣��ʱ���� ��Spring AOP�У�һ�����ӵ� ���� ����һ��������ִ�С� ͨ������һ��org.aspectj.lang.JoinPoint���͵Ĳ�������ʹ֪ͨ��Advice�������岿�ֻ������ӵ���Ϣ��
֪ͨ��Advice���� ��������ĳ���ض������ӵ㣨Joinpoint����ִ�еĶ�����֪ͨ�и������ͣ����а�����around������before���͡�after����֪ͨ�� ֪ͨ�����ͽ��ں��沿�ֽ������ۡ�����AOP���ܣ�����Spring����������������֪ͨģ�ͣ� ��ά��һ�������ӵ�Ϊ���ĵ�����������
�����㣨Pointcut���� ƥ�����ӵ㣨Joinpoint���Ķ��ԡ�֪ͨ��һ������������ʽ�����������������������������ӵ������У����磬��ִ��ĳ���ض����Ƶķ���ʱ���� ����������ʽ���κ����ӵ�ƥ����AOP�ĺ��ģ�Springȱʡʹ��AspectJ�������﷨��
���루Introduction���� ��Ҳ����Ϊ�ڲ�����������inter-type declaration���������������ķ�������ĳ�����͵��ֶΡ� Spring���������µĽӿڣ��Լ�һ����Ӧ��ʵ�֣����κα������Ķ����� ���磬������ʹ��һ��������ʹbeanʵ�� IsModified �ӿڣ��Ա��򻯻������ơ�
Ŀ��������Target Object���� ��һ�����߶������棨aspect����֪ͨ��advise���Ķ�����Ҳ���˰������� ��֪ͨ��advised�� ������ ��ȻSpring AOP��ͨ������ʱ����ʵ�ֵģ�����������Զ��һ�� ��������proxied�� ������
AOP������AOP Proxy���� AOP���ܴ����Ķ���������ʵ��������Լ��aspect contract��������֪ͨ����ִ�еȹ��ܣ��� ��Spring�У�AOP����������JDK��̬��������CGLIB������ ע�⣺Spring 2.0���������Ļ���ģʽ��schema-based��������@AspectJע����������������������ʹ����Щ�������û���˵�������Ĵ�����͸���ġ�
֯�루Weaving���� �����棨aspect�����ӵ�������Ӧ�ó������ͻ��߶����ϣ�������һ����֪ͨ��advised���Ķ����� ��Щ�����ڱ���ʱ������ʹ��AspectJ����������������ʱ������ʱ���ɡ� Spring��������Java AOP����һ����������ʱ����֯�롣
֪ͨ�����ͣ�
ǰ��֪ͨ��Before advice���� ��ĳ���ӵ㣨join point��֮ǰִ�е�֪ͨ��������֪ͨ������ֹ���ӵ�ǰ��ִ�У��������׳�һ���쳣����
���غ�֪ͨ��After returning advice���� ��ĳ���ӵ㣨join point���������ɺ�ִ�е�֪ͨ�����磬һ������û���׳��κ��쳣���������ء�
�׳��쳣��֪ͨ��After throwing advice���� �ڷ����׳��쳣�˳�ʱִ�е�֪ͨ��
��֪ͨ��After (finally) advice���� ��ĳ���ӵ��˳���ʱ��ִ�е�֪ͨ���������������ػ����쳣�˳�����
����֪ͨ��Around Advice���� ��Χһ�����ӵ㣨join point����֪ͨ���緽�����á�������ǿ����һ��֪ͨ���͡� ����֪ͨ�����ڷ�������ǰ�������Զ�������Ϊ����Ҳ��ѡ���Ƿ�����ִ�����ӵ���ֱ�ӷ��������Լ��ķ���ֵ���׳��쳣������ִ�С�
����֪ͨ����õ�һ��֪ͨ���͡��󲿷ֻ������ص�AOP���ܣ�����Nanning��JBoss4����ֻ�ṩ����֪ͨ��
�����㣨pointcut�������ӵ㣨join point��ƥ���ĸ�����AOP�Ĺؼ�����ʹ��AOP��ͬ�����������ṩ���ع��ܵľɼ����� ������ʹ�ö�λ֪ͨ��advice���ɶ�����OO���Ρ� ���磬һ���ṩ����ʽ����������around֪ͨ���Ա�Ӧ�õ�һ���������������еķ����ϣ�����������������ҵ����������
һ��Hibernate����ԭ����
��ȡ�����������ļ�
��ȡ������ӳ����Ϣ������SessionFactory
����Sesssion
��������Transation
�־û�����
�ύ����
�ر�Session
�ر�SesstionFactory

����Hibernate��ʲô�ô���
��JDBC�������ݿ��Ĵ������˷�װ���������������ݷ��ʲ㷱�����ظ��Դ��롣
Hibernate��һ������JDBC�������־û����ܣ���һ��������ORMʵ�֡����ܴ��̶ȵļ���DAO���ı��빤��
hibernateʹ��Java�������ƣ��������ֽ�����ǿ������ʵ��͸���ԡ�
hibernate�����ܷǳ��ã���Ϊ���Ǹ����������ܡ�ӳ���������Ժܳ�ɫ����֧�ָ��ֹ�ϵ���ݿ⣬��һ��һ�����Զ��ĸ��ָ��ӹ�ϵ��

����Hibernate�������ӳټ��صģ�
Hibernate2�ӳټ���ʵ�֣�a)ʵ������ b)���ϣ�Collection��
Hibernate3 �ṩ�����Ե��ӳټ��ع���
�ġ�Hibernate�Ĳ�ѯ��ʽ��
Sql��Criteria,object comptosition
Hql��
���Բ�ѯ
������ѯ������������ѯ
������ѯ
��ҳ��ѯ
ͳ�ƺ���

�塢˵��Hibernate�Ļ������ƣ�

ʹ��˫��һ�Զ���������ʹ�õ���һ�Զ�
����ʹ�õ���һ�Զ�����
����һ��һ���ö���һȡ��
���ö��󻺴棬��ʹ�ü��ϻ���
һ�Զ༯��ʹ��Bag,���Զ༯��ʹ��Set
�̳���ʹ����ʽ��̬
���ֶ�Ҫ�٣���������Ҫ�¶࣬�ж�����������



�ڲ���������Hibernate���ֽ�һ�����棬����Ӧ�����Ｖ����
�������棺
���������Ż�Hibernate:

a)Ӧ�ü�����
b)�ֲ�ʽ����
���������ݲ��ᱻ�������޸ġ����ݴ�С�ڿɽ��ܷ�Χ�����ݸ���Ƶ�ʵ͡�ͬһ���ݱ�ϵͳƵ��ʹ�á��ǹؼ�����
c) ������������ʵ��}}}
```