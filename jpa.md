%toc
# JPA #
## JPA����������˼������ ##
### JPA�ĸ��� ###
> Java Persistence API
### ���ֵ�ԭ�� ###
> �������ڵĳ־û���������������ORM����
### �ص� ###
> ��ʹ�� ������ǿ
### JAP������ ###
#### RMӳ��Ԫ���� ####
> > - ֧��XML��JDK5.0ע������Ԫ������ʽ
> > - ���������ͱ�֮���Ĺ�ϵ
> > - ���ܾݴ˽������־û������ݿ�����
#### Java�־û�API ####
> > - ����ʵ������,����CRUD����
#### ��ѯ���� ####
> > - ���������Ĳ�ѯ����
#### ����JPA������JAR�� ####
  1. Hiberante���İ�(8���ļ�)
> > - hibernate-distribution-3.3.1.GA
> > - hibernate3.jar
> > - lib\bytecode\cglib\hibernate-cglib-repack-2.1\_3.jar
> > - lib\required\**.jar
  1. Hiberanteע����(3���ļ�)��hibernate-annotations-3.4.0.GA
> > - hibernate-annotations.jar
> > - lib\ejb3-persistence.jar
> > - hibernate-commons-annotations.jar
  1. Hibernate����JPA��ʵ�ְ�(3���ļ�)��hibernate-entitymanager-3.4.0.GA
> > - hibernate-entitymanager.jar
> > - lib\test\log4j.jar
> > - slf4j-log4j12.jar
#### JPA�������ļ� ####

> - ��META-INFĿ¼��,�̶��ļ���Ϊ persistence.xml
> - ģ���ļ�
{{{class="brush: xml"
<?xml version="1.0"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd" version="1.0">**

&lt;persistence-unit name="itcast" transaction-type="RESOURCE\_LOCAL"&gt;


> > 

&lt;properties&gt;


> > > 

&lt;property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect"/&gt;


> > > 

&lt;property name="hibernate.connection.driver\_class" value="org.gjt.mm.mysql.Driver"/&gt;


> > > 

&lt;property name="hibernate.connection.username" value="root"/&gt;


> > > 

&lt;property name="hibernate.connection.password" value="123456"/&gt;


> > > 

&lt;property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/itcast?useUnicode=true&characterEncoding=UTF-8"/&gt;


> > > 

&lt;property name="hibernate.hbm2ddl.auto" value="update"/&gt;



> > 

&lt;/properties&gt;




&lt;/persistence-unit&gt;




Unknown end tag for &lt;/persistence&gt;

}}}
 - transaction-type������
  - RESOURCE_LOCAL��JTA
 - hibernate.hbm2ddl.auto value��ȡֵ
  # create��<br>
	ÿ�μ���hibernateʱ����ɾ����һ�ε����ɵı���Ȼ����������model���������������±�����������û���κθı�ҲҪ����ִ�У������ǵ������ݿ������ݶ�ʧ��һ����Ҫԭ����
  # create-drop ��<br>
	ÿ�μ���hibernateʱ����model�����ɱ�������sessionFactoryһ�ر�,�����Զ�ɾ����
  # update��<br>
	��õ����ԣ���һ�μ���hibernateʱ����model�����Զ����������Ľṹ��ǰ�����Ƚ��������ݿ⣩���Ժ�����hibernateʱ���� model���Զ����±��ṹ����ʹ���ṹ�ı��˵����е�����Ȼ���ڲ���ɾ����ǰ���С�Ҫע�����ǵ����𵽷������󣬱��ṹ�ǲ��ᱻ���Ͻ��������ģ���Ҫ��Ӧ�õ�һ�������������Żᡣ     
=== ������˼�� ===
 # �Ƚ��������ٸ��ݱ�����д�����ļ���ʵ��bean��ʹ�����ַ����Ŀ�����Ա�յ��˴�ͳ���ݿ⽨ģ��Ӱ�졣
 # �ȱ�д�����ļ���ʵ��bean��Ȼ�������ɱ���ʹ�����ַ����Ŀ�����Ա���õ���������ģ˼�룬����˼������ǰһ��˼������OOP
== ��һ��JPAʵ����JPA�������ɲ��� ==
=== persistence.xml���� ===
{{{class="brush: xml"
<?xml version="1.0"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd" version="1.0">
<persistence-unit name="itcast" transaction-type="RESOURCE_LOCAL">
   <properties>
         <property name="hibernate.dialect" value="org.hibernate.dialect.OracleDialect"/>
         <property name="hibernate.connection.driver_class" value="oracle.jdbc.driver.OracleDriver"/>
         <property name="hibernate.connection.username" value="nec"/>
         <property name="hibernate.connection.password" value="nec"/>
         <property name="hibernate.connection.url" value="jdbc:oracle:thin:@localhost:1521:nec"/>
         <property name="hibernate.hbm2ddl.auto" value="update"/>
      </properties>
</persistence-unit>
</persistence> 
}}}
=== �־û����� ===
{{{class="brush: java"
Person.java��
package cn.itcast.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
private Integer id;
private String name;

public Person() {
}

public Person(String name) {
   this.name = name;
}

//@Id�ɱ�ע�����Ի����Ե�get�����ϣ�ͨ����ע��get������
@Id @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence1")
@SequenceGenerator(name = "sequence1", sequenceName = "SEQ_1", allocationSize = 1)
public Integer getId() {
   return id;
}
public void setId(Integer id) {
   this.id = id;
}
public String getName() {
   return name;
}
public void setName(String name) {
   this.name = name;
}

}
}}}
=== ������ ===
{{{class="brush: java"
PersonTest.java��
package junit.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.itcast.bean.Person;

public class PersonTest {

@BeforeClass
public static void setUpBeforeClass() throws Exception {
  
}
@Test public void save() {
   //-->sessionFactory-->session-->begin����
   EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
   EntityManager em= factory.createEntityManager();
   em.getTransaction().begin(); // ��ʼ����
   em.persist(new Person("���ǲ���"));
   em.getTransaction().commit();
   em.close();
   factory.close();
}

}
}}}
== ����_ö�ٵ��ֶ����͵�JPAӳ�� ==
=== �־û��� ===
{{{class="brush: java"
Person.java��

package cn.itcast.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//ʵ��Person��Ӧ�ı�����ΪmyPerson
//@Entity(name="myPerson") ����
@Entity
@Table(name="myPerson")
public class Person {
private Integer id;
private String name;
private Date regdate; //ע�����ڣ�ֻ�������ڣ������ų�����ʱ��
private Gender gender=Gender.MAN; //�Ա�������Ĭ��ֵ

public Person() {
}

public Person(String name) {
   this.name = name;
   regdate = new Date();
}

//@Id�ɱ�ע�����Ի����Ե�get�����ϣ�ͨ����ע��get������
@Id @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence1")
//ʹ������SEQ_1��������
@SequenceGenerator(name = "sequence1", sequenceName = "SEQ_1", allocationSize = 1)
public Integer getId() {
   return id;
}
public void setId(Integer id) {
   this.id = id;
}
//��Ӧ�����ֶ���Ϊmyname������Ϊ20��������Ϊ��
@Column(name="myname",length=20,nullable=false)
public String getName() {
   return name;
}
public void setName(String name) {
   this.name = name;
}

//ֻ�����ڣ�����ʱ��
@Temporal(TemporalType.DATE)
public Date getRegdate() {
   return regdate;
}

public void setRegdate(Date regdate) {
   this.regdate = regdate;
}

//����ö�����͵��ַ���
@Enumerated(EnumType.STRING)
@Column(length=5, nullable=false)
public Gender getGender() {
   return gender;
}

public void setGender(Gender gender) {
   this.gender = gender;
}
}

Gender.java��
package cn.itcast.bean;

public enum Gender {
MAN, WOMAN
}
}}}
== �������ֶ�ӳ�����ֶ��ӳټ��� ==
{{{class="brush: java"
Person.java��
package cn.itcast.bean;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//ʵ��Person��Ӧ�ı�����ΪmyPerson
//@Entity(name="myPerson") ����
@Entity
@Table(name="myPerson")
public classa Person {
private Integer id;
private String name;
private Date regdate; //ע�����ڣ�ֻ�������ڣ������ų�����ʱ��
private Gender gender=Gender.MAN; //�Ա�������Ĭ��ֵ
private String info; //�������ֶ�
private byte[] fileblob=null;

//ϣ�������Բ���Ϊ�־û��ֶΣ����������ݿ��е��ֶν������� @Transient
private String imagePath;

public Person() {
}

public Person(String name) {
   this.name = name;
   regdate = new Date();
}

//@Id�ɱ�ע�����Ի����Ե�get�����ϣ�ͨ����ע��get������
@Id @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence1")
//ʹ������SEQ_1��������
@SequenceGenerator(name = "sequence1", sequenceName = "SEQ_1", allocationSize = 1)
public Integer getId() {
   return id;
}
public void setId(Integer id) {
   this.id = id;
}
//��Ӧ�����ֶ���Ϊmyname������Ϊ20��������Ϊ��
@Column(name="myname",length=20,nullable=false)
public String getName() {
   return name;
}
public void setName(String name) {
   this.name = name;
}

//ֻ�����ڣ�����ʱ��
@Temporal(TemporalType.DATE)
public Date getRegdate() {
   return regdate;
}

public void setRegdate(Date regdate) {
   this.regdate = regdate;
}

//����ö�����͵��ַ���
@Enumerated(EnumType.STRING)
@Column(length=5, nullable=false)
public Gender getGender() {
   return gender;
}

public void setGender(Gender gender) {
   this.gender = gender;
}

//���ı��ֶΣ���Ӧ�����ֶ�����ΪCLOB
@Lob
public String getInfo() {
   return info;
}

public void setInfo(String info) {
   this.info = info;
}

//�ӳټ���
//�����ӳ�����ʱ�����뱣֤session�Ǵ���״̬��
//�������ֶΣ���Ӧ�����ֶ�����ΪBLOB
@Lob
@Basic(fetch=FetchType.LAZY)
public byte[] getFileblob() {
   return fileblob;
}

public void setFileblob(byte[] filebyte) {
   this.fileblob = filebyte;
}

@Transient
public String getImagePath() {
   return imagePath;
}

public void setImagePath(String imagePath) {
   this.imagePath = imagePath;
}
}

PersonTest.javaƬ�Σ�
     Person person = new Person("���ǲ���");
     File file = new File("E:\\jpa.JPG");
     InputStream is = new FileInputStream(file);
     byte[] filebyte = new byte[(int) file.length()];
     is.read(filebyte);
     is.close();
     person.setFileblob(filebyte);
     em.persist(person);
}}}
== ʹ��JPA���ء����¡�ɾ������ ==
=== ����,ɾ������ ===
{{{class="brush: java"
  Person person = em.find(Person.class, 210);
    if (person != null) {
     em.getTransaction().begin(); // ��ʼ����
     em.remove(person);
     em.getTransaction().commit();
    }
}}}
=== ���ض��� ===
{{{class="brush: java"
    Person person = em.find(Person.class, 210); // get  //������¼�������򷵻�null
    // ʹ�ø÷���ʱ�������ϴ����ݿ����ض��󣬶��Ƿ���һ���������󣬵���Ҫ�Ըö������в���ʱ���Ŵ����ݿ��õ����ݣ�����em.close()���ٶԸö������в�����������δ�������ع�������������
    //org.hibernate.LazyInitializationException: could not initialize proxy - no Session
    Person person2 = em.getReference(Person.class, 211); // load 
    //������¼���������ڶԶ������в���ʱ�����쳣��
    //javax.persistence.EntityNotFoundException: Unable to find cn.itcast.bean.Person with id 210
    System.out.println(person2.getName());
}}}
=== ���¶��� ===
{{{class="brush: java"
Person person = em.find(Person.class, 211);
    if (person != null) {
     em.getTransaction().begin(); // ��ʼ����
     person.setName("����");
    // ��������������ʱ������ֱ��ͨ���޸Ķ������޸Ŀ������ݣ�
    // 1. ���޸Ĳ�������������
    // 2. ������managed(�й�)״̬ʱ��new(�½�)�����롢ɾ��״̬�����ã�
     //em.persist(person); 
     em.getTransaction().commit();
    }

    //��������״̬�Ķ����޸Ĳ��ɹ�
    Person person = em.find(Person.class, 211);
    if (person != null) {
     em.getTransaction().begin(); // ��ʼ����
     person.setName("����");
     //��ʵ���������е�����ʵ��bean��Ϊ��������
    em.clear(); 
     em.getTransaction().commit();
    }

    //������״̬�Ķ����ĸ���ͬ�������ݿ⣬��merge
    Person person = em.find(Person.class, 211);
    if (person != null) {
     em.getTransaction().begin(); // ��ʼ����
     person.setName("����2");
     em.clear(); // ȫ������Ϊ����״̬
     em.merge(person);
     em.getTransaction().commit();
    }
/*
   ����״̬֮����ת��
   1. �й�-->����
     em.clear()
   2. ����-->�й�
     em.merge()
   ɾ������
     remove()
   ���ض���
     load()
*/
}}}
== ʹ��JPQL�������в�ѯ ==
 - JPQL = Java Presistence Query Language 
=== ��ѯ���� ===
 - ͨ�������²�Ҫֱ�ӽ�����������ѯ���䣬��ʹ�ò����ķ�ʽ����ֹע��
{{{class="brush: java"
Named Parameters :
Query q = em.createQuery("SELECT p FROM Person p WHERE p.lastName = :surnameAND p.firstName =:forename");
q.setParameter("surname", theSurname);
q.setParameter("forename", theForename");
----------------------------------------------------------------------------------------
Numbered Parameters :
Query q = em.createQuery("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.firstName = ?2");
q.setParameter(1, theSurname);
q.setParameter(2, theForename); 
}}}
=== ��ȡ���� ===
{{{class="brush: java"
  List result = (List) query1.getResultList();
//��ȡΨһ��������Ӧhibernate�е�?session.createQuery("").uniqueResult()
//������¼�����ڻ��׳��쳣��?javax.persistence.NoResultException: No entity found for query
//����ͨ����ʹ��getResultList()
   Person person = (Person) query1.getSingleResult();
}}}
 - ʵ��
{{{class="brush: java"
@Test
 public void query() {
   EntityManagerFactory factory = Persistence
     .createEntityManagerFactory("itcast");
   EntityManager em = factory.createEntityManager();
   Query query1 = em.createQuery("select o from Person o where o.id=:id");
   query1.setParameter("id", 201);
   Person person = (Person) query1.getSingleResult();
   if (person != null) {
    System.out.println("q1:" + person.getId());
   }
   else {
    System.out.println("q1:empty");
   }
  
   Query query2 = em.createQuery("select o from Person o where o.id=?1");
   query2.setParameter(1, 200);
   List<Person> persons = (List<Person>) query2.getResultList();
   for (Person person2 : persons) {
    System.out.println("person:" + person2.getId());
   }
   em.close();
   factory.close();
/*
  ��ѯ�в���������
  1. ��ѯ������ ���� = ?����
  2. �������� Query����.setParameter(��Ӧ����,��Ӧֵ)
*/
}
}}}
=== ɾ����ѯ�͸��²�ѯ�����ŵ������� ===
 {{{class="brush: java"
em.getTransaction().begin();
   int iCount = 0;
   //ɾ����ѯ
   Query queryDelete = em.createQuery("delete from Person o where o.id=?1");
   queryDelete.setParameter(1, 202);
   iCount = queryDelete.executeUpdate();
   System.out.println("Delete count:" + iCount);
  
   //���²�ѯ
   Query queryUpdate = em.createQuery("update Person o set myname=?1 where o.id=?2");
   queryUpdate.setParameter(1, "����");
   queryUpdate.setParameter(2, 203);
   iCount = queryUpdate.executeUpdate();
   System.out.println("Update count:" + iCount);
  
   em.getTransaction().commit();
/*
  ���²���
  1. Query������executeUpdate(SQL);
  2. ɾ������ delete from .... where ... 
  3. �������� update TableName from .... where ....
*/
 }}}
== JPA�е�һ�Զ�˫�������뼶���������ӳټ�������ϵά�� ==
 - �ԡ�����Order 1:N ������OrderItem��Ϊ����
  # ��JPA�У�������˫��1:N�Ĺ�ϵ����N��һ��Ϊ��ϵά����
  # ��ϵά���˸���������¼�ĸ��£���ϵ��ά������û��Ȩ������������¼��
  # ����ֻ��ͨ��������(OrderItem)���޸������Ķ���(Order)��������ͨ���������޸Ķ����������Ķ���
  # Nһ�ߵ�Ĭ�ϼ��ط�ʽΪ�ӳټ��أ�1һ�ߵ�Ĭ�ϼ��ط�ʽΪ��������
 - ��ϵ��ά����
 - 
{{{class="brush: java"
Order.java��
package cn.itcast.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
private String orderid;
private Float amount = 0f;
private Set<OrderItem> items = new HashSet<OrderItem>();

@Id
@Column(length=12)
public String getOrderid() {
   return orderid;
}
public void setOrderid(String orderid) {
   this.orderid = orderid;
}

@Column(nullable=false)
public Float getAmount() {
   return amount;
}
public void setAmount(Float amount) {
   this.amount = amount;
}

//1:N�Ĺ�ϵ��ע�⣺@OneToMany
//CascadeType.PERSIST: insert Order ʱ���Զ� insert OrderItem
//CascadeType.MERGE����Order������������״̬ʱ���޸� Order ʱ���Զ��޸� OrderItem
//����������ֻ���ڵ���Merge����ʱCascadeType.MERGE�������ã�ֻ���ڵ���Remove����ʱ��CascadeType.REMOVE�������ã����������Դ�����
@OneToMany(cascade={CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE},
    fetch=FetchType.LAZY, //Many��Ĭ��ΪLAZY
    mappedBy="order") //��mappedBy���Ǳ�ά���ˣ�ָ�����������ԣ��˴�ָ��Orderͨ����order��������OrderItem����
public Set<OrderItem> getItems() {
   return items;
}
public void setItems(Set<OrderItem> items) {
   this.items = items;
}

public void addOrderItem(OrderItem orderItem) {
orderItem.setOrder(this); //����ά����
   this.items.add(orderItem);
  
}
} 
}}}
 - ��ϵά����
{{{class="brush: java"
OrderItem.java��
package cn.itcast.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
private Integer id;
private String productName;
private Float sellPrice = 0f;
private Order order;

@Id @GeneratedValue
public Integer getId() {
   return id;
}
public void setId(Integer id) {
   this.id = id;
}
@Column(length=40, nullable=false)
public String getProductName() {
   return productName;
}
public void setProductName(String productName) {
   this.productName = productName;
}
@Column(nullable=false)
public Float getSellPrice() {
   return sellPrice;
}
public void setSellPrice(Float sellPrice) {
   this.sellPrice = sellPrice;
}

@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH },
    fetch=FetchType.EAGER, //One��Ĭ��ΪEAGER
    optional=false //�Ƿ���ѡ
    )
@JoinColumn(name="order_id") // ��������
public Order getOrder() {
   return order;
}
public void setOrder(Order order) {
   this.order = order;
}
}
}}}
 - ����
{{{class="brush: java"
ManyToOneTest.java��
package cn.itcast.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class OneToManyTest {
@Test
public void save() {
   EntityManagerFactory factory = Persistence
     .createEntityManagerFactory("itcast");
   EntityManager em = factory.createEntityManager();

   em.getTransaction().begin(); // ��ʼ����
   Order order = new Order();
   order.setAmount(34f);
   order.setOrderid("999"); //UUID.randomUUID().toString()
  
   OrderItem orderItem1 = new OrderItem();
   orderItem1.setProductName("����");
   orderItem1.setSellPrice(90f);

   OrderItem orderItem2 = new OrderItem();
   orderItem2.setProductName("����");
   orderItem2.setSellPrice(30f);

   order.addOrderItem(orderItem1);
   order.addOrderItem(orderItem2);
  
   em.persist(order);
   em.getTransaction().commit();

   em.close();
   factory.close();
}
}
}}}
```