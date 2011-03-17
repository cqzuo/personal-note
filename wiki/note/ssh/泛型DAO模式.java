

普通数据访问对象，这个是Hibernate官方网站上面的一个DAO类的设计模式，基于JDK5.0范型支持,文章地址如下：
http://www.hibernate.org/328.html
下面的代码与Hibernate官网上提供的有点不同。
首先定义DAO类的接口IGenericDAO，该接口定义了共同的CRUD操作：
java 代码
 
/** 
 * 定义通用的CRUD操作 
 * @author rainlife 
 */  
public interface IGenericDAO 〈T, ID extends Serializable〉
{  
//  通过主键标识查找某个对象。  
    public T findById(ID id);  
      
//  通过主键标识查找某个对象，可以锁定表中对应的记录。  
    T findById(ID id, boolean lock);  
  
    //得到所有的对象。  
    List findAll();  
  
    //通过给定的一个对象，查找与其匹配的对象。  
    List findByExample(T exampleInstance);  
  
    //持久化对象。  
    T makePersistent(T entity);  
  
    //删除对象。  
    void makeTransient(T entity);  
}  
下面是使用Hibernate针对该接口的实现GenericDAOHibernate：
java 代码
 
/** 
 * 这是针对IGenericDAO接口的Hibernate实现，完成通用的CRUD操作。 
 * @author rainlife 
 * @param  POJO类 
 * @param   POJO类的主键标识符 
 * @param  针对每一个POJO类的DAO类实现  
 */  
public abstract class GenericDAOHibernate 〈T,ID extends Serializable, DAOImpl extends IGenericDAO〈T,ID〉〉
        implements IGenericDAO〈T,ID〉
{  
    private Class persistentClass;  
  
    protected Session session;  
  
    public GenericDAOHibernate()  
    {  
        this.persistentClass = (Class) ((ParameterizedType) getClass()  
                .getGenericSuperclass()).getActualTypeArguments()[0];  
    }  
  
    @SuppressWarnings("unchecked")  
    public DAOImpl setSession(Session s)  
    {  
        this.session = s;  
        return (DAOImpl)this;  
    }  
  
    protected Session getSession()  
    {  
        if (session == null)  
            throw new IllegalStateException(  
                    "Session has not been set on DAO before usage");  
        return session;  
    }  
  
    public Class getPersistentClass()  
    {  
        return persistentClass;  
    }  
  
      
    @SuppressWarnings("unchecked")  
    public T findById(ID id)  
    {  
        return (T) getSession().load(getPersistentClass(), id);  
    }  
      
    @SuppressWarnings("unchecked")  
    public T findById(ID id, boolean lock)  
    {  
        T entity;  
        if (lock)  
            entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);  
        else  
            entity = findById(id);  
  
        return entity;  
    }  
  
    @SuppressWarnings("unchecked")  
    public List findAll()  
    {  
        return findByCriteria();  
    }  
  
    @SuppressWarnings("unchecked")  
    public List findByExample(T exampleInstance)  
    {  
        Criteria crit = getSession().createCriteria(getPersistentClass());  
        Example example = Example.create(exampleInstance);  
        crit.add(example);  
        return crit.list();  
    }  
      
    @SuppressWarnings("unchecked")  
    public List findByExample(T exampleInstance, String[] excludeProperty)  
    {  
        Criteria crit = getSession().createCriteria(getPersistentClass());  
        Example example = Example.create(exampleInstance);  
        for (String exclude : excludeProperty)  
        {  
            example.excludeProperty(exclude);  
        }  
        crit.add(example);  
        return crit.list();  
    }  
  
    @SuppressWarnings("unchecked")  
    public T makePersistent(T entity)  
    {  
        getSession().saveOrUpdate(entity);  
        //getSession().save(entity);  
        return entity;  
    }  
  
    public void makeTransient(T entity)  
    {  
        getSession().delete(entity);  
    }  
  
    @SuppressWarnings("unchecked")  
    protected List findByCriteria(Criterion... criterion)  
    {  
        Criteria crit = getSession().createCriteria(getPersistentClass());  
        for (Criterion c : criterion)  
        {  
            crit.add(c);  
        }  
        return crit.list();  
    }  
      
    @SuppressWarnings("unchecked")  
    /** 
     * 增加了排序的功能。 
     */  
    protected List findByCriteria(Order order,Criterion... criterion)  
    {  
        Criteria crit = getSession().createCriteria(getPersistentClass());  
        for (Criterion c : criterion)  
        {  
            crit.add(c);  
        }  
        if(order!=null)  
            crit.addOrder(order);  
        return crit.list();  
    }  
      
    @SuppressWarnings("unchecked")  
    protected List findByCriteria(int firstResult,int rowCount,Order order,Criterion... criterion)  
    {  
        Criteria crit = getSession().createCriteria(getPersistentClass());  
        for (Criterion c : criterion)  
        {  
            crit.add(c);  
        }  
        if(order!=null)  
            crit.addOrder(order);  
        crit.setFirstResult(firstResult);  
        crit.setMaxResults(rowCount);  
        return crit.list();  
    }  
}  
这样，我们自己所要使用的DAO类，就可以直接从这个Hibernate的DAO类继承：
比如说我们定义一个IUserDAO接口，该接口继承IGenericDAO:
java 代码
public interface IUserDAO extends IGenericDAO〈User,Integer〉
{  
    public User find(String username,String password);  
    public User find(String username);  
}  
 
该接口从IGenericDAO继承，自然也就定义了IGenericDAO接口所定义的通用CRUD操作。
再来看一下针对IUserDAO 的Hibernate实现UserDAOHibernate:
java 代码
public class UserDAOHibernate extends GenericDAOHibernate〈User,Integer,IUserDAO〉 implements IUserDAO {       
  
    public User find(String username, String password) {  
        //此处省略具体代码  
    }  
  
    public User find(String username) {  
        //此处省略具体代码  
    }  
}  
 
UserDAOHibernate继承GenericDAOHibernate并实现IUserDAO接口，这样，我们的UserDAOHibernate既拥有通用的CRUD操作，也实现了针对用户的特定的业务操作。

