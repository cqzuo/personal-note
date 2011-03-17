Struts   +   Spring   +   Hibernate的整合使用 
           
        开发工具:Eclipse3.1,MyEclipse4.0 ,Tomcat5.0.28,mysql-4.0.18
       
       
        开发步骤：
        1：创建web projectSSHlogin 加入struts1.2  
              
            创建loginForm选择DynaValidatorForm，加入password，username，创建jsp文件打上钩，将路径改为/login.jsp，然后下一步，改LoginAction的Input source改为/login.jsp，加入 <forward name="ok" path="ok.jsp" />点击完成
           
            完成后修改struts-config.xml文件加入 
            <plug-in className="org.apache.struts.validator.ValidatorPlugIn">
        <set-property property="pathnames" value="/WEB-INF/validator-rules.xml,/WEB-INF/validation.xml" />
        </plug-in> 
      拷贝validator-rules.xml和validation.xml到WEB-INF目录中   在validation.xml文件中加入
        <form-validation>
      <formset>
        <form name="loginForm">
         <field property="username" depends="required">
         <arg0 key="prompt.username" />
         </field>
         <field property="password" depends="required">
          <arg0 key="prompt.password" />
         </field>
        </form>
         </formset>
     </form-validation>
      validator-rules.xml文件直接考一个就行。
      编辑资源文件“ApplicationResources.properties”
    增加以下内容   
     prompt.username=User Name
     prompt.password=User Password
     errors.required={0} is required.
        
              
          修改LoginAction.java文件的execute方法，内容如下
    public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response) {
      DynaValidatorForm loginForm = (DynaValidatorForm) form;
      String username=loginForm.getString("username");
      String password=loginForm.getString("password");
      if(username.equals("test")||password.equals("test")){
       return mapping.findForward("indexGo");
      }else{
       return mapping.getInputForward();
      }
     }
   好了，现在可以启动Tomcat进行测试了如果不输入任何数据而直接提交表单的话就可以看到效果了。

   好了，如果没有什么问题的话就继续往下看吧，如果有问题的话就得往上看了^_^
  
   2：加入Spring框架
    在这里我将Spring所有的包全部加载进去，因为我还不知道具体用到哪些类，全部加进去方便点

    单选框选第二个，这样的话所有的类库和标签等都将拷贝到项目中去，这样方便以后的布署
    下一步后是创建配置文件，将文件放到“WebRoot/WEB-INF”目录下，文件名称为“applicationContext.xml”
   
    
    配置struts-config.xml文件，添加（spring）的插件
    
    <plug-in className="org.springframework.web.struts.ContextLoaderPlugIn">
        <set-property property="contextConfigLocation" value="/WEB-INF/applicationContext.xml" />
      </plug-in>
    
     
    修改LoginAction配置
    
    原：
    <action
          attribute="loginForm"
          input="/login.jsp"
          name="loginForm"
          path="/login"
          scope="request"
          validate="true"
          type="com.test.struts.action.LoginAction" >
       <forward name="ok" path="ok.jsp" />
        </action>
    
      </action-mappings>
    
    改为：
    <action
          attribute="loginForm"
;   input="/login.jsp"
          name="loginForm"
          path="/login"
          scope="request"
          validate="true"
          type="org.springframework.web.struts.DelegatingActionProxy">
          <forward name="ok" path="ok.jsp" />
        </action>
      </action-mappings>
    

    这里将使用spring的代理器来对Action进行控制
      
    当提交到/login.do是将控制权交给了spring，然后由spring来决定是否转回到struts的Action

    现在来配置spring
    
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
    
    <beans>
     <bean name="/login" class="com.test.struts.action.LoginAction" singleton="false"></bean>
    </beans>
    
           好了，现在可以启动Tomcat进行测试了如果没有什么问题的话就继续往下看吧，如果有问题的话就得往上看了^_^    
  
  
       3：创建Hibernate框架        
              
           建立数据库在 这里我使用的是mysql4.1.18

    CREATE TABLE `user` (
      `ID` int(11) NOT NULL auto_increment,
      `USERNAME` varchar(50) NOT NULL default '''',
      `PASSWORD` varchar(50) NOT NULL default '''',
      PRIMARY KEY   (`ID`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1; 
    
    添加记录 insert into user (USERNAME,PASSWORD) values (''test'',''test'')
                 
   在配置界面中配置数据库的连接部份，重要的是点击链接将jdbc驱动拷贝到lib目录中
   使用MyEclipse的数据Database Explorer工具创建User.hmb.xml、AbstractUser.java、User.java映射文件               
     
       创建UserDAO.java、UserDAOImp.java
    UserDAO.java：
   
    public interface UserDAO {
   
       public abstract boolean isValidUser(String username, String password);
   
    }   
   
    UserDAOImp.java：
   
    import java.util.List;
   
    import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
   
    public class UserDAOImp extends HibernateDaoSupport implements UserDAO {
   
     private static String hql = "from User u where u.username=? and password=?";
   
     public boolean isValidUser(String username, String password) {
   
      String[] userlist=new String[2];
      userlist[0]=username;
      userlist[1]=password;
   
      List userList = this.getHibernateTemplate().find(hql,userlist);
   
      if (userList.size() > 0) {
   
       return true;
   
      }
   
      return false;
   
     }
   
    } 

   
    
    修改LoginAction.java文件，使用userDao的方法来进行用户验证
    package com.test.struts.action;
    
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    import org.apache.struts.action.Action;
    import org.apache.struts.action.ActionForm;
    import org.apache.struts.action.ActionForward;
    import org.apache.struts.action.ActionMapping;
    import org.apache.struts.validator.DynaValidatorForm;
    
    import com.test.UserDAO;
   
    public class LoginAction extends Action {
   
     private UserDAO userDAO;
    
     public UserDAO getUserDAO() {
      return userDAO;
     }
    
     public void setUserDAO(UserDAO userDAO) {
      this.userDAO = userDAO;
     }
    
     public ActionForward execute(ActionMapping mapping, ActionForm form,
       HttpServletRequest request,

HttpServletResponse response) {
      DynaValidatorForm loginForm = (DynaValidatorForm) form;
      // TODO Auto-generated method stub
      String username = (String) loginForm.get("username");
      String password = (String) loginForm.get("password");
      loginForm.set("password", null);
      if (userDAO.isValidUser(username,password)) {
       return mapping.findForward("ok");
      } else {
       return mapping.getInputForward();
      }
     }
    }
              
              
           现在剩下最后的spring配置了
           <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
   
    <beans>
     <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
      <property name="driverClassName">
       <value>com.mysql.jdbc.Driver</value>
      </property>
      <property name="url">
       <value>jdbc:mysql://localhost/test</value>
      </property>
      <property name="username">
       <value>root</value>
      </property>
      <property name="password">
       <value>lxl</value>
      </property>
     </bean>
    
     <!-- 配置sessionFactory, 注意这里引入的包的不同   -->
     <bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
      <property name="dataSource">
       <ref local="dataSource" />
      </property>
      <property name="mappingResources">
       <list>
        <value>com/test/Hibernate/User.hbm.xml</value>
       </list>
      </property>
      <property name="hibernateProperties">
       <props>
        <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
        <prop key="hibernate.show_sql">true</prop>
       </props>
      </property>
     </bean>
    
     <bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
      <property name="sessionFactory">
       <ref local="sessionFactory" />
      </property>
     </bean>
    
     <bean id="userDAO" class="com.test.UserDAOImp">
      <property name="sessionFactory">
       <ref local="sessionFactory" />
      </property>
     </bean>
    
     <bean id="userDAOProxy" class="org.springframework.transaction.interceptor.TransactionProxyFactoryBean">
      <property name="transactionManager">
       <ref bean="transactionManager" />
      </property>
      <property name="target">
       <ref local="userDAO" />
      </property>
      <property name="transactionAttributes">
       <props>
        <prop key="insert*">PROPAGATION_REQUIRED</prop>
        <prop key="get*">PROPAGATION_REQUIRED,readOnly</prop>
        <prop key="is*">PROPAGATION_REQUIRED,readOnly</prop>
       </props>
      </property>
     </bean>
    
     <bean name="/login" class="com.test.struts.action.LoginAction" singleton="false">
      <property name="userDAO">
       <ref bean="userDAOProxy" />
      </property>
</bean>
    </beans>
         现在可以进行测试了！

     在编写代码有配置内容时一定要注意 hibernate 和 hibernate3 ，这两个包的名字就只差一个字，千万不要有错，否则找错误可是很难的。
     注意要把spring-hibernate.jar或者把spring.jar加到工程lib里

