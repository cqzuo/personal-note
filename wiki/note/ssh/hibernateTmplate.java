1.管理SessionFactory

   使用Spring整合Hibernate时我们不需要hibernate.cfg.xml文件。首先，在applicationContext.xml中配置数据源（dataSource）bean和session工厂（sessionFactory）bean。其中，在配置session工厂bean 时，应该注入三个方面的信息：

      ●数据源bean

      ●所有持久化类的配置文件

      ●Hibernate的SessionFactory的属性

Hibernate的SessionFactory的属性信息又包括两个内容，一，Hibernate的连接方法；二，不同数据库连接，启动时的选择。

2.为HibernateTemplate注入SessionFactory对象，通过HibernateTemplate来持久化对象

   Spring提供了HibernateTemplate，用于持久层访问，该模板无需打开Session及关闭Session。它只要获得 SessionFactory的引用，将可以只能地打开Session，并在持久化访问结束后关闭Session，程序开发只需完成持久层逻辑，通用的操作（如对数据库中数据的增，删，改，查）则有HibernateTemplate完成。

   HibernateTemplate有三个构造函数，不论是用哪一种构造，要使HibernateTemplate能完成持久化操作，都必须向其传入一个SessionFactory的引用。

   HibernateTemplate的用法有两种，一种是常规的用法，另一种是复杂的用。

      一，常规的用法

         HibernateTemplate通过它自己的delete(Object entity) ，find(String queryString)，save(Object entity)等等常用的方法即可完成大多数DAO对象的增，删，改，查等操作。

      二，复杂的用法

         HibernateTemplate的复杂的用法是通过如下的两个方法来完成的：

            ●Object execute(HibernateCallback action)

            ●List execute(HibernateCallback action)

         这两个方法都需要一个HibernateCallback实例，程序开发者通过HibernateCallback，可以完全使用Hibernate灵活的方式来访问数据库，解决了Spring封装Hibernate后灵活不足的缺陷。HibernateCallback是一个接口，该接口只有一个方法 doInHibernate(org.hibernate.Session session)，该方法只有一个参数Session。

         通常，程序中采用实现HibernateCallback的匿名内部类来获取HibernateCallback的实例，方法doInHibernate就是Spring执行的持久化操作。具体的代码实例如下：

         public class PersonDaoImpl {

                 private SessionFactory sessionFactory;

                 public void setSessionFactory(SessionFactory sessionFactory) {

                         this.sessionFactory = sessionFactory;

                 }

                 public List findPersonByName(final String name) {

                         HibernateTemplate hibernateTemplate =

                                            new HibernateTemplate(this.sessionFactory);

                         return (List)hibernateTemplate.execute(

                                   public Object doInHibernate(Session session)  throws Hibernate Exception {

                                           List result =session.createCriteria(Person.clsss)

                                                                         .add(Restrictions.like("name",name+"%")).list();

                                           return result;

                                   }

                         );

                 }

        }

       注：在方法doInHibernate内可以访问Session，该Session对象是绑定到该线程的Session实例，该方法内的持久层操作与不使用Spring时的持久层操作完全相同，这保证了对于复杂的持久层访问时，依然可以使用Hibernate的访问方式。

3.DAO的实现

   DAO的实现有两种方式：一，继承HibernateDaoSupport实现DAO；二，基于Hibernate3.0实现DAO。

      一，继承HibernateDaoSupport实现DAO

         Spring为Hibernate的DAO提供了工具类HibernateDaoSupport。该类主要提供了如下两个方法来方便DAO的实现：

         ●public final HibernateTemplate getHibernateTemplate()

         ●public final void setSessionFactory(SessionFactory sessionFactory)

         其中，setSessionFactory方法用来接收Spring的ApplicationContext依赖注入的SessionFactory实例；getHibernateTemplate方法则用来根据刚才的SessionFactory产生Session，最后由 HibernateTemplate来完成数据库访问。

      二，基于Hibernate3.0实现DAO

        在Hibernate处于事务的管理下时（通常Spring为Hibernate提供事务管理），通过SessionFactory的 getCurrentSession()方法可以返回当前的Session，如果当前的JTA事务关联的Session不存在，则系统打开一次新的 Session，并关联到当前的JTA事务；如果当前JTA事务关联的Session已经存在，则直接返回该Session。获得了当前的Session 后就可以进行持久化操作了。

      可见，不论使用上面的哪一种方式实现DAO都需要用Spring来注入SessionFactory实例。

4.事务的管理

   Hibernate建议所有的对数据库的访问都应放在事务内进行，即使进行的只是读操作。Spring同时支持编程式事务和声明式事务。通常推荐使用声明式事务。

   编程式事务管理：

   编程式事务提供了TransactionTemplate模板类，用的时候必须向其体提供一个PlatformTransactionManager实例。只要TransactionTemplate获取了PlatformTransactionManager的引用， TransactionTemplate就可以完成事务操作了。TransactionTemplate提供了一个execute方法，它接收一个 TransactionCallback实例。TransactionCallback包含如下方法：

      ●Object doInTransaction(TransactionStatus status)

这是需要有返回值的情况。如果不需要有返回值的话，我们可以用TransactionCallbackWithOutResult类来代替TransactionCallback类，它也有一个方法：

      ●void doInTransaction(TransactionStatus status)

   在这个两个方法中，在出现异常时，TransactionStatus的实例status可以调用setRollbackOnly()方法进行回滚。

   一般情况下，向execute方法传入TransactionCallback或TransactionCallbackWithOutResult实例时，采用的是匿名内部类的形式。

   声明式事务管理：

   声明式事务管理的配置方式通常有三种：

      ●使用TransactionProxyFactoryBean为目标bean生成事务代理的配置。

      ●使用BeanNameAutoProxyCreator，根据bean name自动生成事务代理的方式，这是直接利用Spring的AOP框架配置事务代理的方式，需要对Spring的AOP框架有所了解。

      ●使用DefaultAdvisorAutoProxyCreator，这也是直接利用Spring的AOP框架配置事务代理的方式，只是这种配置方式的可读性不如使用BeanNameAutoProxyCreator的配置方式。
------------------------------------------------------------------

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
<beans>
 
 <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
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
           <value>8093</value>
       </property>
    </bean>
 
    <bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
  <property name="dataSource">
   <ref local="dataSource"/>
  </property>
  <property name="mappingResources">
   <list>
    <value>user.hbm.xml</value>
   </list>
  </property>
  <property name="hibernateProperties">
   <props>
    <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
    <prop key="hibernate.show_sql">true</prop>
   </props>
  </property>
 </bean>  
 
    <bean id="userDAO" class="com.dang.action.UserDAOImpl">
  <property name="sessionFactory">
   <ref local="sessionFactory"/>
  </property>
 </bean> 
 
 <bean name="/regedit" class="com.dang.action.RegeditAction">
     <property name="userDAO">
        <ref bean="userDAO"/>
     </property>
 </bean>
 
  <bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
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
            <prop key="create*">PROPAGATION_REQUIRED</prop>
         </props>
     </property>
   </bean>
</beans>

--------------------------------------------------------------------------

使用模板模式简化DAO操作Hibernate
http://www.webjx.com  更新日期：2005-09-21 06:46  出处：JR  作者：reverocean
　　相信使用过Spring ＋ Hibernate开发过的人，在写DAO的时候都使用过Spring的HibernateDaoSupport类，然后在实现的时候就可以很轻松的使用 getHibernateTemplate()方法之后就可以调用save()、delete()、update()等Hibernate的 Session的操作，很简单。比如：

getHibernateTemplate().save(user);

　　这样一句话在我们没有Spring的时候就必须使用如下的代码才能完成：

Session session = HibernateUtil.getSession();
Transaction tx = session.beginTransaction();
session.save(user);
tx.commit();
HibernateUtil.colseSession();


　　这里还省去了异常处理，同时使用了HibernateUtil类来简化从SessionFactory获取Session，以及关闭Session等处理。

　　但是我们在使用Hibernate的时候不一定会使用Spring，所以我们可以模仿Spring的处理方式，做一个Hibernate的模板，使用模板模式来简化我们的开发，其主要的目的就是为了简化开发，使代码达到最大话的重用。

　　1． 我们现来实现一个Hibernate模板：

package kick.hibernate;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

public class HibernateTemplate{
public static Object run(HibernateCallback callback) throws HibernateException{
Session session = null;
Transaction tx = null;
try {
session = HibernateSessionutil.currentSession();
tx = session.beginTransaction();
Object result = callback.execute(session);
tx.commit();
session.flush();
return result;
} catch (HibernateException e) {
tx.rollback();
return null;
} finally {
HibernateSessionutil.closeSession();
}
}


　　这里类很简单，就是使用一个实现HibernateCallBack接口的一个回掉类，在调用的时候根据具体的需求实现HibernateCallBack类。

　　2． 回掉接口HibernateCallBack：

package kick.hibernate;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

public interface HibernateCallBack {
Object execute(Session session)throws HibernateException;
}


　　好了，到此为止我们就可以使用这个模板了，可以用如下的方式使用：

HibernateTemplate.run(new HibernateCallback() {
public Object execute(Session session) throws HibernateException {
session.save(user);
return null;
}
});


　　看看，是不是省去了很多代码？

　　不过这还没有达到想Spring里面那样简单，不要着急，“面包会有的”，我们会达到的。

　　3． 实现我们自己的HibernateSupport类
　　从上面的代码可以看出，我们要自己实现 HibernateCallback接口，而每次我们实现的时候又重复代码了。因此我们再抽象，讲这些实现放到我们的HibernateSupport类里面去。看看我们上面的代码就知道我们实现HibernateCallback接口的目的就是为了调用session.save()方法，即 session的方法。代码如下：（点击查看附件）

　　4． 抽象RootDao：
　　该类为抽象类，在实现自己的DAO类的时候继承该类。该类的有一个HibernateSupport的对象，在子类中使用getHibernateTemplate()方法就可以得到该对象，然后调用它对应的方法。实现代码如下：

package kick.hibernate.dao;

import net.sf.hibernate.Session;
import kick.hibernate.HibernateTemplateImpl;

public abstract class RootDao {
private HibernateSupport temp = null;

/**
* @return Returns the temp.
*/
public HibernateTemplateImpl getHibernateTemplate(Session session) {
return new HibernateSupport();
}
}



　　5． 使用例子：
　　定义一个自己的DAO类，实现代码如下：

public class UserDaoImpl extends RootDao implements UserDaoInterface{
public void saveUser(User user) throws KickException {
getHibernateTemplate().saveOrUpdate(user);
}
…………………………………………
实现其他的方法
…………………………………………
}

