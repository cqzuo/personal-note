������λ��Ӧ�ó�������������Դ֮�䣬������ʱ���Ÿ������ݵ��ڴ�������Ŀ����Ϊ�˼���Ӧ�ó�������������Դ���ʵĴ������Ӷ�����Ӧ�ó�������������.
> Hibernate�ڲ�ѯ����ʱ�����ȵ�������ȥ���ң������ҵ���ֱ��ʹ�ã��Ҳ�����ʱ���ͻ�����������Դ�м��������ԣ���Ƶ��ʹ�õ����ݼ��ص��������󣬾Ϳ��Դ�������Ӧ�ó�������������Դ�ķ��ʣ�ʹ�ó����������������Ե�����.

Hibernate�������ࣺ

Session���棬һ������.

SessionFactory�Ļ�����Ϊ���û��������û���.���û����д��ŵ���SessionFactory������һЩ�������԰���������(ӳ��Ԫ�ؾݼ�Ԥ����SQL������),����Ӧ�ó�����˵,����ֻ����.���û����д��ŵ������ݿ����ݵĸ���,�����ú�һ����������.���������������ڴ���Ϊ�洢������,������ѡ��Ӳ�̵��ⲿ�洢�豸.

Hibernate�Ļ��淶Χ

Hibernate��һ�������Ͷ������涼λ�ھ�λ�ڳ־ò�,�Ҿ����ڴ������ݿ����ݵĸ���,�������������ǻ����ķ�Χ����һ��.

�����ķ�Χ��Ϊ3��:

1.������Χ
> ������Χ�Ļ���ֻ�ܱ���ǰ��������,ÿ���������и��ԵĻ���,�����ڵ�����ͨ�������໥�����Ķ�����ʽ.����������������������������������,ֻ�е���������ʱ,�������������ڲŻ�����.������Χ�Ļ���ʹ���ڴ���Ϊ�洢����,һ������������������Χ.
2.Ӧ�÷�Χ
> Ӧ�ó����Ļ������Ա�Ӧ�÷�Χ�ڵ�����������������.��������������������Ӧ�õ���������,ֻ�е�Ӧ�ý���ʱ,�������������ڲŻ�����.Ӧ�÷�Χ�Ļ�������ʹ���ڴ���Ӳ����Ϊ�洢����,��������������Ӧ�÷�Χ.
3.��Ⱥ��Χ
> �ڼ�Ⱥ������,���汻һ�����������������Ľ��̹���,�����е����ݱ����Ƶ���Ⱥ�����е�ÿ�����̽ڵ�,���̼�ͨ��Զ��ͨ������֤�����е����ݵ�һ��,�����е�����ͨ�����ö�������ɢ������ʽ.

> Hibernate�Ļ�������

һ�������Ĺ���:

> evit(Object obj)  ��ָ���ĳ־û�������һ������������,�ͷŶ�����ռ�õ��ڴ���Դ,ָ�������ӳ־û�״̬��Ϊ�ѹ�״̬,�Ӷ���Ϊ��������.
> clear()  ��һ�������е����г־û���������,�ͷ���ռ�õ��ڴ���Դ
> contains(Object obj) �ж�ָ���Ķ����Ƿ�������һ��������.
> flush() ˢ��һ��������������,ʹ֮�����ݿ����ݱ���ͬ��.

> ���������Ĺ���:

> evict(Class arg0, Serializable arg1)  ��ĳ������ָ��ID�ĳ־û������Ӷ�������������,�ͷŶ�����ռ�õ���Դ.

Java����
1.sessionFactory.evict(Customer.class, new Integer(1));
sessionFactory.evict(Customer.class, new Integer(1));
> evict(Class arg0)  ��ָ���������г־û������Ӷ�������������,�ͷ���ռ�õ��ڴ���Դ.

Java����
1.sessionFactory.evict(Customer.class);
sessionFactory.evict(Customer.class);
> evictCollection(String arg0)  ��ָ���������г־û�������ָ�����ϴӶ�������������,�ͷ���ռ�õ��ڴ���Դ.

Java����
1.sessionFactory.evictCollection("Customer.orders");
sessionFactory.evictCollection("Customer.orders");

Hibernate�Ķ�������������

����,�������е����ݶ��ʺϷ��ڶ���������,��һ��,ʲô���������ʺϷ��ڶ�����������?ʲô�������ݲ��ʺϷ��ڶ�����������?
> �����⼸�������Ͳ��ʺϼ��ص�����������:
  1. �������޸ĵ�����
> 2.���Բ��������ֲ������ʵ�����
> 3.������Ӧ�ù���������
> �����⼺���������ʼ��ص�����������:
  1. ���ݸ���Ƶ�ʵ�
> 2.����ż�����ֲ��������ķ���Ҫ����
> 3.���ᱻ�������ʵ�����
> 4.��������
> 5.���ᱻ�������޸ĵ�����

Hibernate�Ķ������湦���ǿ����ö�������������ʵ�ֵ�,HibernateΪ�˼�����Щ����,Hibernate�ṩ��org.hibernate.cache.CacheProvider����,���䵱����������Hibernate֮���������� .

���õĶ�����������
EHCache  org.hibernate.cache.EhCacheProvider
OSCache  org.hibernate.cache.OSCacheProvider
SwarmCahe  org.hibernate.cache.SwarmCacheProvider
JBossCache  org.hibernate.cache.TreeCacheProvider

�򵥽���һ��EHCache������
hibernate.cfg.xml

Xml����
1.

&lt;hibernate-configuration&gt;


2.   

&lt;session-factory&gt;


3.      <!-- ���ö�����������EHCache��Provider��-->
4.      

&lt;property name="hibernate.cache.provider\_class"&gt;


5.         org.hibernate.cache.EhCacheProvider
6.      

&lt;/property&gt;


7.      <!-- ����"��ѯ����" -->
8.      

&lt;property name="hibernate.cache.use\_query\_cache"&gt;


9.         true
10.      

&lt;/property&gt;


11.   

&lt;/session-factory&gt;


12. 

&lt;/hibernate-configuration&gt;


> 

&lt;hibernate-configuration&gt;


> > 

&lt;session-factory&gt;


> > > <!-- ���ö�����������EHCache��Provider��-->
> > > 

&lt;property name="hibernate.cache.provider\_class"&gt;


> > > > org.hibernate.cache.EhCacheProvider

> > > 

&lt;/property&gt;


> > > <!-- ����"��ѯ����" -->
> > > 

&lt;property name="hibernate.cache.use\_query\_cache"&gt;


> > > > true

> > > 

&lt;/property&gt;



> > 

&lt;/session-factory&gt;


> > 

&lt;/hibernate-configuration&gt;



ehcache.xml


Xml����
1.

&lt;ehcache&gt;


2.  <!-- maxElementsInMemoryΪ����������������Ŀ, eternal�����Ƿ���Զ������,timeToIdleSeconds�������ڿ���״̬����������,timeToLiveSeconds�������ڻ���״̬���������� -->
3.  

&lt;diskStore path="java.io.tmpdir"/&gt;


4.    

&lt;defaultCache maxElementsInMemory="10000" eternal="false"  timeToIdleSeconds="300" timeToLiveSeconds="600" overflowToDisk="true"/&gt;


5.

&lt;/ehcache&gt;




&lt;ehcache&gt;



> <!-- maxElementsInMemoryΪ����������������Ŀ, eternal�����Ƿ���Զ������,timeToIdleSeconds�������ڿ���״̬����������,timeToLiveSeconds�������ڻ���״̬���������� -->
> 

&lt;diskStore path="java.io.tmpdir"/&gt;


> > 

&lt;defaultCache maxElementsInMemory="10000" eternal="false"  timeToIdleSeconds="300" timeToLiveSeconds="600" overflowToDisk="true"/&gt;




&lt;/ehcache&gt;




.hbm.xml


Xml����
1.<?xml version="1.0" encoding='UTF-8'?>
2.<!DOCTYPE hibernate-mapping PUBLIC
3.                            "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
4.                            "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd" >
5.
6.

&lt;hibernate-mapping&gt;


7.
8.   

&lt;class&gt;


9.       <!-- ���øó־û����Ķ������沢�����ʲ��� read-only read-write nonstrict-read-write transactional-->
10.       

&lt;cache usage="read-write"/&gt;


11.   

&lt;/class&gt;


12.
13.

&lt;/hibernate-mapping&gt;


