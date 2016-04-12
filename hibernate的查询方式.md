Hibernate�Ĳ�ѯ����
1: QBE (Query By Example)
> Criteria cri = session.createCriteria(Student.class);
> cri.add(Example.create(s)); //s��һ�� Student ����
> list cri.list();
> ʵ�ʣ�����һ��ģ�棬��������һ����serial ��һ��  giftortoy �ֶΣ������� serial.setgifttoy(\"2\"),
> > ���������е����е�giftortoy Ϊ 2 �����ݶ�������
QBC��ѯ��ʽ

QBC(Query By Criteria)��ѯ��ʽ�� Hibernate �ṩ�� �� ������������ �� ��һ�ּ�����ʽ�� QBC ��������ѯ�ϱ� HQL ��ѯ��Ϊ�������֧������ʱ��̬���ɲ�ѯ���䡣
��Hibernate Ӧ����ʹ�� QBC ��ѯͨ������ 3 ������

> (1)ʹ�� Session ʵ���� createCriteria() �������� Criteria ����
> (2)ʹ�ù����� Restrictions �����ط���Ϊ Criteria �������ò�ѯ����
> (3)ʹ�� Criteria ������ list() ����ִ�в�ѯ�����ز�ѯ����
Restrictions���ĳ��÷���
Restrictions.eq(String propertyName,Object value)
����
Restrictions.allEq(Map propertyNameValues)
ʹ��Map key/value ���ж������ڵıȶ�
Restrictions.gt(String propertyName, Object value)
���� >    (gt----->greater than)
Restrictions.ge(String propertyName, Object value)
���ڵ��� >=    (ge----->greater equal)
Restrictions.It(String propertyName, Object value)
С��< (It---->less than)
Restrictions.Le(String propertyName, Object value)
С�ڵ���<= (le---->less equal)
Restrictions.between(String propertyName, Object lo, Object hi)
��ӦSQL ������ Between �Ӿ�
Restrictions.like(String propertyName, Object value)
��ӦSQL ������ LIKE �Ӿ�
Restrictions.in(String propertyName, Collection value)
��ӦSQL ������ in �Ӿ�
Restrictions.and(Criterion lhs, Criterion rhs)
And��ϵ
Restrictions.or(Criterion lhs, Criterion rhs)
Or��ϵ
Restrictions.sqlRestriction(String sql,Object[.md](.md) values,Type[.md](.md) types)
SQL�޶���ѯ

> ������Order �ṩ����������ʽ
Order.asc(String propertyName)
��������
Order.desc(String propertyName)
��������

> ������Projections �ṩ�Բ�ѯ��������ͳ������������
Porjections.avg(String propertyName)
��ĳ���Ե�ƽ��ֵ
Projections.count(String propertyName)
ͳ��ĳ���Ե�����
Projections.countDistinct(String propertyName)
ͳ��ĳ���ԵĲ�ֵͬ������
Projections.groupProperty(String propertyName)
ָ��һ������ֵ
Projections.max(String propertyName)
ĳ���Ե�����ֵ
Projections.min(String propertyName)
ĳ���Ե���Сֵ
Projections.projectionList()
����һ���µ�projectionList ����
Projections.rowCount()
��ѯ�������м�¼������
Projections.sum(String propertyName)
����ĳ����ֵ�ĺϼ�

QBE��ѯ

> QBE��ѯ���Ǽ�����ָ����������������ͬ����ֵ�Ķ��������� QBE ��ѯ�Ĺؼ��������������Ĵ��������������е����зǿ����Ծ�����Ϊ��ѯ������ QBE ��ѯ�Ĺ����Ӽ�����Ȼ QBE û�� QBC ���ܴ󣬵�����Щ���� QBE ʹ��������Ϊ���㡣

> ������Example Ϊ Criteria ����ָ������������Ϊ��ѯ����
Java����
1  Session session = HibernateSessionFactory.getSessionFactory().openSession();
2  Transaction ts = session.beginTransaction();
3  Customer c =  new  Customer();
4  c.setCname("Hibernate");
5  Criteria criteria = session.createCriteria(Customer. class );
6  Criteria.add(Example.create(c));
7  Iterator it = criteria.list().iterator();
8  ts.commit();
9  HibernateSessionFactory.closeSession();
QBC��ҳ��ѯ
> CriteriaΪ�����ṩ���������õķ����� setFirstResult(int firstResult) �� setMaxResults(int maxResults).
setFirstResult(int firstResult)��������ָ������һ��������ʼ���������Ŵ� 0 ��ʼ����Ĭ��Ϊ��һ������������Ϊ 0 ���� setMaxResults(int maxResults) ��������ָ��һ�������������Ķ�����Ŀ��Ĭ��Ϊ���ж�����
Java����
1  Session session = HibernateSessionFactory.getSessionFactory().openSession();
2  Transaction ts =  null ;
3  Criteria criteria = session.createCriteria(Order. class );
4  int  pageSize = 15;
5  int  pageNo = 1;
6  criteria.setFirstResult((pageNo-1)**pageSize);
7  criteria.setMaxResults(pageSize);
8  Iterator it = criteria.list().iterator();
9  ts.commit();
10  HibernateSessionFactory.closeSession();**

QBC���ϲ�ѯ
> ���ϲ�ѯ������ԭ�еĲ�ѯ�������ٽ��в�ѯ�������ڹ˿ͶԶ�����һ�Զ���ϵ�У��ڲ�ѯ�����еĹ˿Ͷ�������ϣ���ڲ�ѯ������money ���� 1000 �Ķ�������
DetachedCriteria  criteria= DetachedCriteria . forClass (Model. class );
criteria.add(Restrictions. eq ( "userid" , userid));
criteria.add(Restrictions. eq ( "state" , false ));
criteria.add(Restrictions. not ( Expression . eq ( "freeze" , false )  ));
criteria.addOrder( Order. desc ( "createtime" ) );
return   modelDAO .findByCriteria(criteria);
Java����
1  Session session = HibernateSessionFactory.getSessionFactory().openSession();
2  Transaction ts = session.beginTransaction();
3  Criteria cuscriteria = session.createCriteria(Customer. class );
4  Criteria ordCriteria = cusCriteria.createCriteria("orders");
5  ordCriteria.add(Restrictions.gt("money",  new  Double(1000)));
6  Iterator it = cusCriteria.list().iterator();
7  ts.commit();
8  HibernateSessionFactory.closeSession();
QBC���߲�ѯ
> ���߲�ѯ�ֽ�DetachedCriteria ��ѯ���������� Session ֮�����й��죬ֻ������Ҫִ�в�ѯʱ���� Session �󶨡�
2: QBC (Query By Criteria) ��Ҫ�� Criteria,Criterion,Oder,Restrictions ������
> session = this.getSession();
> Criteria cri = session.createCriteria(JdItemSerialnumber.class);
> Criterion cron = Restrictions.like(\"customer\",name);
> cri.add(cron);
> list = cri.list();
> 
> �Ƚ�������
> HQL������                    QBC ������                      ����
> > =                     Restrictions.eq()                  ����
> > <>                   Restrictions.not(Exprission.eq())  ������
> > >                     Restrictions.gt()                  ����
> > >=                   Restrictions.ge()                  ���ڵ���
> > <                     Restrictions.lt()                  С��  [Page](Page.md)
> > <=                   Restrictions.le()                  С�ڵ���
> > is null             Restrictions.isnull()              ���ڿ�ֵ
> > is not null      Restrictions.isNotNull()           �ǿ�ֵ
> > like                 Restrictions.like()                �ַ���ģʽƥ��
> > and                Restrictions.and()                 �߼���
> > and                Restrictions.conjunction()         �߼���
> > or                   Restrictions.or()                  �߼���
> > or                   Restrictions.disjunction()         �߼���
> > not                  Restrictions.not()                 �߼���
> > in(�б� )          Restrictions.in()                   �����б��е�ĳһ��ֵ  [Page](Page.md)
ont in(�б� )         Restrictions.not(Restrictions.in()) �������б�������һ��ֵ
> > between x and y      Restrictions.between()             ������ xy �е�����ֵ
> > not between x and y  Restrictions.not(Restrictions..between()) С��ֵ X ���ߴ���ֵ y
3: HQL

> String hql = \"select s.name ,avg(s.age) from Student s group by s.name\";
> Query query = session.createQuery(hql);
> list = query.list();
> ....
4: ���� SQL ��ѯ
> session = sessionFactory.openSession();
> tran = session.beginTransaction();
> SQLQuery sq = session.createSQLQuery(sql);
> sq.addEntity(Student.class);
> list = sq.list();
> tran.commit();
5: QID
> Session�� get() �� load() �����ṩ�˸��ݶ��� ID �����������ķ�ʽ���÷�ʽ����������֪����Ҫ�������� ID ��������
Hibernate�� HQL/QBC ��ѯ���ԱȽϵ��÷�
Hib�ļ�����ʽ  1 ����������ͼ������ʽ��ͨ���Ѿ����صĶ��󣬵��� .iterator() �������Եõ� order �����������״�ִ�д˷����� Hib �������ݿ����ع����� order ���󣬷����ʹӻ����еõ���  2 �� OID ������ʽ��ͨ�� session �� get �� load ����֪���� OID �������¿���ʹ��  3 �� HQL ������

Hib�ļ�����ʽ
  1. ���������ͼ������ʽ��ͨ���Ѿ����صĶ��󣬵��� .iterator() �������Եõ� order �����������״�ִ�д˷����� Hib �������ݿ����ع����� order ���󣬷����ʹӻ����еõ���
2�� OID ������ʽ��ͨ�� session �� get �� load ����֪���� OID �������¿���ʹ��
3�� HQL ������ʽ��ʹ������������ HQL ��ѯ���� session �� find �������� HQL ����ѯ
4�� QBC ������ʽ������ QBCAPI ���������Ƿ�װ�˻����ַ����Ĳ�ѯ����
5�����ص� SQL ������ʽ��ʹ�ñ������ݿ��� SQL ��ѯ���� Hib �Ḻ���Ѽ������� JDBC ������ӳ��Ϊ�־û�����ͼ��
> ���ּ�����ʽ��ʹ�ó��Ϻ��ص㣺
HQL �� �����������Ĳ�ѯ���ԣ�ͬ SQL ��Щ������ Hib ����õķ�ʽ��
��ѯ�趨���ֲ�ѯ������
֧��ͶӰ��ѯ�������������Ĳ������ԡ�
֧�ַ�ҳ��ѯ������ʹ��having �� group by
�ṩ���Ƶľۼ�������sum() �� min() �� max()
�ܵ����û����Զ���SQL
֧���Ӳ�ѯ��Ƕ��ʽ��ѯ
֧�ֶ�̬�󶨲���
����ʹ��Query �ӿ��滻 session �� find ������

Query Q = session.createQuery("from customer as c where c.name = :customerName" +"and c.age = :customerAge");
query.setString("customerName" , "tom");
> query.setInteger("customerAge" , "21");
> list result = query.list();
QBC : QBCAPI�ṩ����һ�ַ�ʽ����Ҫ�� Criteria �ӿڡ� Criterion �ӿں� Expression ��
Criteria criteria = session.createCriteria(customer.class);
> Criterion criterion1 =Expression.like("name","t%");
> Criterion criterion2 =Expression.eq("age",new Integer(21));
> Critera = criteria.add(criterion1) ;
> Critera = criteria.add(criterion2) ;
> list result = criteria.list();
���ǣ� list result = session.createCriteria(Customer.class).add(Expression.eq("this.name","tom")).list();
SQL : ���� HQL �� QBC ����ʱ�� Hib ���� SQL ���������������ݿ⡣
Query query  =session.createSQLQuery("select {c.**} from customers c where c.name like : customername " + "and c.age =:customerage","c",customer.calss);
> query.setString("customername","tom");
> query.setInteger("customerage","21");
> list result = query.list();
/////////////��̬��ѯ
> HQL �� session.createQuery("from employee");
> QBC �� session.createCriteria(employee.class);
> HQL : session.createQuery("from hourlyEmployee");
> QBC : session.createCriteria(hourlyEmployee.class);
������HQL ��ѯ���佫���������еĳ־û�������
from java.lang.Object ;
from java.io.serializable ;
////////////��ѯ������
1����ѯ�������տͻ������������У�
HQL ��
Query query = session.createQuery
("from customer c order by c.name");
QBC ��
Criteria criteria = session.createCriteria(customer.class);
criteria.addOrder(order.asc("name"));
HQL :
Query query = session.createQuery("from customer c orderby c.name asc , c.age desc");
QBC :
Criteria criteria =session.createCriteria(customer.class);
criteria.addOrder(order.asc ("name"));
criteria.addOrder(order.desc("age"));
import net.sf.hibernate.pression.Order
import mypack.Order
...........
Criteria criteria = session.createCritria (mypack.Order.class);
criteria.addOrder(net.sf.hibernate.Order.asc("name"));
///////////HQL�����Ĳ������� Query �ӿ�
�ṩ�˰󶨸���Hib ӳ�����͵ķ�����
setBinary()
setString()
setBoolean()
setByte()
setCalendar()
setCharacter()
setDate()
setDouble()
setText()
setTime()
setTimestamp()
setEntity()
//�Ѳ�����һ���־û�������������
lsit result = session.createQuery
("from order o where o.customer = :customer").setEntity("customer" , customer).list ;
setParameter()
//�����������͵Ĳ���
setProperties()
//������������һ������������ֵ����
Query query = session.createQuery
("from customer c where c.name =:name " + "and c.age =:age" );
Query.setProperties(customer);**

Java����
1.public AlBasic queryAlBasicByEtpsIdAndAnnlYear(String entityName, String etpsId, String annlYear) {
2.        if (etpsId == null | "".equals(etpsId) | annlYear == null || "".equals(annlYear))|
|:------------------|:-----------------|
3.            return null;
4.        DetachedCriteria dc = DetachedCriteria.forEntityName(entityName);
5.        dc.add(Restrictions.eq("etpsId", etpsId));
6.        dc.add(Restrictions.eq("annlYear", annlYear));
7.
8.        List result = findByCriteria(dc);
9.        if (result == null || result.size() == 0) {
10.            return null;
11.        }
12.        return (AlBasic) result.get(0);
13.    }
