Spring事务的学习 

       今天对 spring 的 AOP 事务有了一个新的认识，所以赶紧把今天的学习记下来，希望在今后的学习中能够起到一些作用，也能对今天的认识做一次总结。 

1          同事的 spring 分享 
先看一段代码： 
    Connection conn = Conn.getConnection();
    conn.setAutoCommit(false);
    ……..
    ……...
    conn.rollback();
    conn.commit(); 

    数据库的事务是针对 Connection 的。 

    接着再看一段代码：（ spring 中事务的一段学习代码，这段代码是把 spring 和 hibernate 结合在一起的，增加了理解上的难度，因为我的出发点一开始不要 hibernate ，就光用 jdbc 来进行数据库事务，但是没有其他好的代码，就这样吧） 

    public Long addLineItem(Long orderId, LineItem lineItem){ 

       log("OrderListDAOHibernate.addLineItem : Start..."); 

       OrderList orderList = (OrderList) getHibernateTemplate().load(OrderList.class, orderId); 

       lineItem.setOrderList(orderList); 

       getHibernateTemplate().saveOrUpdate(lineItem); 

       getHibernateTemplate().saveOrUpdate(orderList); 

       log("OrderListDAOHibernate.addLineItem : Ending..."); 

       return lineItem.getId(); 

    }

    在这个代码的配置文件中，把 addLineItem 做为一个切入点，进行事务，也就是说，在 addLineItem 的外面，再包上一层事务的外壳。 

    但是这个时候，问题出来了，事务是针对 Connection 的，而上面的两个连续的 HibernateTemplate 执行的 saveOrUpdate 中的 Connection 必须是一致才能用事务， spring 怎么做到这一点的呢？（这个问题也就是在找 spring 的事务例子前，我想的 spring 中用 jdbc 来进行事务，怎么样让 Connection 保持一致呢？但是没有 jdbc 的例子，只有整合 hibernate 或者 ibatis 的例子，但是，我想，原理是一样的吧。） 

  

    解决问题的思路： HibernateTemplate 中的 Connection 必定一致。那么就从 HibernateTemplate 入手。 

    看 spring 的源代码，既然是 Hibernate ，那么，就没有 Connection 给你看，只有 Session ，由 Session 来管理 Connection ，那么用事务来控制的话，这个 Session 必定在所有该事务中是一致的。于是在 HibernateTemplate 中找到： 


protected Session getSession() { 

       if (isAlwaysUseNewSession()) { 

return SessionFactoryUtils.getNewSession(getSessionFactory(), getEntityInterceptor()); 

       } 

       else if (!isAllowCreate()) { 

return SessionFactoryUtils.getSession(getSessionFactory(), false); 

       } 

       else { 

return SessionFactoryUtils.getSession( 

                  getSessionFactory(), getEntityInterceptor(), getJdbcExceptionTranslator()); 

       } 

    } 

  

看来在 SessionFactoryUtils 里面，接着在 SessionFactoryUtils.getSession 中找： 

  

这个方法太长了，太复杂了，从简，发现了非常关键的一点： 

  

SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory); 

  

假如 sessionHolder 不等于空，说明，在事务中有这样一个还没有 commit 的 session ，那么就返回这个 session ，假如等于空，新建一个 session ，并且在事务里加入这个 session 。这段代码的意思大概是这样，太繁杂了，只能猜，也肯定是如此。 

  

再看 getHibernateTemplate() 方法来自继承 HibernateDaoSupport ，看了电子书《 spring-reference 》的第九章“ Dao 支持”， Dao 的支持类可以有好多，如： JdbcDaoSupport ， HibernateDaoSupport ， JdoDaoSupport 等等。 

  

既然前面一开始就是从 jdbc 的 spring 事务控制引起的，那么看到了同样的 HibernateDaoSupport---JdbcDaoSupport ，那么 JdbcDaoSupport 也应该有 getJdbcTemplate() 这个方法，并且返回 JdbcTemplate 这个类。 

  

果然如此。 

  

于是剖析 JdbcTemplate 是不是和 HibernateTemplate 一样。果然一样。 

  

注意到： 

Connection con = DataSourceUtils.getConnection(getDataSource()); 

  

Connection 是从 DataSourceUtils.getConnection() 来的，继续跟踪 DataSourceUtils.getConnection() 。 

  

找到： 

ConnectionHolder conHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource); 

  

和 Hibernate 中的一模一样，因为没有了 session 的封装，条理在 jdbc 中更加清晰了。 

  

至此， spring 的事务控制 已经全部搞定。 

2          Spring 事务管理的配置 
看了上面同事学习 spring 的笔记后自己也觉得有新的理解，从什么地方说起呢？就从 spring 的事务配置说起吧。那么我们看看 contextConfig.xml 吧。 

<bean id="sessionFactory" class="org.springframework.orm.hibernate.LocalSessionFactoryBean"> 

       <property name="dataSource"> 

           <ref bean="dataSource" /> 

       </property> 

       <property name="mappingResources"> 

           <list> 

              <value>mf/org/user/User.hbm.xml</value> 

           </list> 

       </property> 

</bean> 

<bean id="transactionManager" class="org.springframework.orm.hibernate.HibernateTransactionManager"> 

       <property name="sessionFactory"> 

           <ref local="sessionFactory" /> 

       </property> 

    </bean> 

<bean id="txProxyTemplate" abstract="true" class="org.springframework.transaction.interceptor.TransactionProxyFactoryBean"> 

       <property name="transactionManager"> 

           <ref bean="transactionManager" /> 

       </property> 

       <property name="transactionAttributes"> 

           <props> 

<prop key="save*">PROPAGATION_REQUIRED,-Exception</prop> 

<prop key="remove*">PROPAGATION_REQUIRED,-Exception </prop> 

<prop key="update*">PROPAGATION_REQUIRED,-Exception </prop> 

<prop key="incress*">PROPAGATION_REQUIRED,-Exception </prop> 

<prop key="*">PROPAGATION_REQUIRED,readOnly</prop> 

           </props> 

       </property> 

    </bean> 

<bean id="userManager" parent="txProxyTemplate"> 

       <property name="target" ref="userManagerTarget" /> 

</bean> 

<bean id="userManagerTarget" 

class=" mf.org.hb.user.service.impl.UserManagerImpl"> 

       <property name="userDAO" ref="userDAO" /> 

</bean> 

<bean id="userDAO" class="mf.org.hb.user.dao.hibernate.UserDAOHibernate"> 

       <property name="sessionFactory" ref="sessionFactory" /> 

</bean> 

    以上就是一个完整的 spring 配置，是不是很熟悉呢，这里是用的 Appfuse 的框架，呵呵。有那么点味道吧。 

    首先我们看看 

<bean id="transactionManager" class="org.springframework.orm.hibernate.HibernateTransactionManager"> 

       <property name="sessionFactory"> 

           <ref local="sessionFactory" /> 

       </property> 

</bean> 

    这一个 bean 让 spring 为我们注入了什么呢？事务，对！我们把 hibernate 的事务注入到了 spring 的 IOC 容器之中了。然后我们再看看： 

    <bean id="txProxyTemplate" abstract="true" class="org.springframework.transaction.interceptor.TransactionProxyFactoryBean"> 

       <property name="transactionManager"> 

           <ref bean="transactionManager" /> 

       </property> 

       <property name="transactionAttributes"> 

           <props> 

<prop key="save*">PROPAGATION_REQUIRED,-Exception</prop> 

<prop key="remove*">PROPAGATION_REQUIRED,-Exception </prop> 

<prop key="update*">PROPAGATION_REQUIRED,-Exception </prop> 

<prop key="incress*">PROPAGATION_REQUIRED,-Exception </prop> 

<prop key="*">PROPAGATION_REQUIRED,readOnly</prop> 

           </props> 

       </property> 

</bean> 

    这个 bean 又是让 spring 为我们注入了了什么呢？事务代理，对了！我们把事务的代理交给一个 txProxyTemplate 的去做了，这样的好处我待会再说，现在我们看看下面的一些配置信息。 

<prop key="save*">PROPAGATION_REQUIRED,-Exception</prop> 

<prop key="remove*">PROPAGATION_REQUIRED,-Exception </prop> 

<prop key="update*">PROPAGATION_REQUIRED,-Exception </prop> 

<prop key="incress*">PROPAGATION_REQUIRED,-Exception </prop> 

<prop key="*">PROPAGATION_REQUIRED,readOnly</prop> 

这里就是事务处理时如果遇到异常信息，或者其他的原因时我们要求 spring 把当前的事务回滚了，这样才能不至于在数据库中产生垃圾啊。我们规定所有的 save,remove,update,incress 这样的方法开头的在出现一些问题后把事务给回滚了，看看我们写的： PROPAGATION_REQUIRED,-Exception 。 

有人就会说 PROPAGATION_REQUIRED 就可以回滚事务啊，为什么加上 ,-Exception 呢？其实我以前也时这样想的，但这是不完全正确的，当然我们在处理一个事务时只要有一个 PROPAGATION_REQUIRED 就可以了，但是当我们的业务逻辑中要求我们在一个事务代理中开启两个事务，这两个事务表面上没有联系，但是实际中又有很多联系的，比如我们上传附件和提交文档，这样两个操作我们可以分开，因为他们不是往一个表里插入数据，我们又不希望这两个操作写在一个 service 里，这样我们要是有一个业务只要上传附件呢？那样我们是不是又要再写一个方法啊！所以在开启两个事务时如果有一个抛出异常了，我们就要把上一个提交的事务回滚了，这样做我们就要用的 -Exception 了，这样就完全满足我们的要求了，我也试过如果我写的是 PROPAGATION_REQUIRED,-SQLException 时，这样我们只会在出现 SQLException 时事务回顾，出现其他的异常事务就不回滚了，好在 spring 可以让我们写如异常的基类就可以做到捕获任何异常，这样我们就写 -Exception 好了。特殊情况在特殊处理吧。通用情况下我们还是这样的。 

我们再看看： 

<bean id="userManager" parent="txProxyTemplate"> 

       <property name="target" ref="userManagerTarget" /> 

</bean> 

<bean id="userManagerTarget" 

class="mf.org.hb.user.service.impl.UserManagerImpl"> 

       <property name="userDAO" ref="userDAO" /> 

</bean> 

<bean id="userDAO" class="mf.org.hb.user.dao.hibernate.UserDAOHibernate"> 

       <property name="sessionFactory" ref="sessionFactory" /> 

</bean> 

    当然我们也可以写成： 

<bean id="userManager" parent="txProxyTemplate"> 

       <property name="target"> 

           <bean class="mf.org.hb.user.service.impl.UserManagerImpl"> 

              <property name="userDAO"> 

                  <ref bean="userDao"/> 

              </property> 

           </bean> 

       </property> 

</bean> 

<bean id="userDAO" class="mf.org.hb.user.dao.hibernate.UserDAOHibernate"> 

       <property name="sessionFactory" ref="sessionFactory" /> 

</bean> 

  

这下我们解除以前的疑惑， parent="txProxyTemplate" 知道我们为什么在上面先写了 txProxyTemplate 的 bean 了吧，这样我们就没有必要再写一编了。是不是很方便？ spring 的这些技巧还不只这些呢。这样我们就可以轻松利用以上这三个注入的类去做我们的逻辑了。 

Spring 就是要我们注入实现类，然后使用接口操作，这样耦合性就不是那么强了，这也体现了 Spring 的工厂模式。而 AOP 的 manager 又象我们熟知的代理模式吧 ! 

3          注意要点 
在写配置的时候注意各个 Manager 和 DAO 之间的关系，以及 <ref= ”” > 之间的关系，清晰里面的关系才能更好的配置。 


 