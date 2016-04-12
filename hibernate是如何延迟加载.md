## �ӳټ��صĶ��� ##
> - hibernate 2����ʵ�������ͼ���
> - hibernate 3ͬʱ�ṩ�����Ե��ӳټ��ع��ܡ�
> ���жԼ��ϵ��ӳټ�������������Ϊ�ش���
## ʵ���������ӳټ��� ##
1.��hibernate�����ļ��е�classָ��
�������͵��ӳټ��أ�
��set��ָ��lazy=true
����ֻ��ʵ�ʼ����������������ļ��϶�����ʱ������ͨ��session�����ݿ��м���ʵ�ʵ����ݼ���
Hibernate.initialize��������ǿ��Hibernate�������ع����Ķ��󼯣����磺
Hibernate.initialize(user.getAddress());
�������͵Ļ��棺
����Ϊĳ���������趨�˻��棬��
<set
> > name="address"
> > table="t\_address"
> > lazy="true"
> > ......
>
> > 

&lt;cache usage="read-only"/&gt;


> > 

&lt;key column="user\_id" /&gt;


> > 

&lt;one-to-many class="cn.blogjava.TAddress" /&gt;




Unknown end tag for &lt;/set&gt;


Hibernate�Լ������ͽ��л�����ʱ�򣬷������ֱ��档��������������������ʵ����id�б������β��Ǹ���ʵ��������
�����ƶ���cache usage="read-only"ֻ��ʹ��Hibernate�������������л��档Ҳ����˵ֻ�����˼����е������������������������еĸ���ʵ��Ԫ�ء�
����ָ��cache usage="read-write"�Ż��Լ����е�ʵ�����л��档

���Ե��ӳټ��أ�
��property�ڵ�������lazy=true,���һ���Ҫ����Hibernate����ǿ����POJO���Ķ�����Class�ļ�����ǿ��������



hibernate�е�Collection
Hibernate��JDK Collention�ӿڵĶ���ʵ�֣�
���ڴ�ͳ��Java Set, Map, Listʵ�ֲ�������Ҫ����Hibernate������Щ�ӿ��ṩ���Լ���ʵ�֡�
Hibernate��ʵ�֣�
���򼯣�Set, Bag, Map
���򼯣�List
Bag�൱��һ�������ظ�Ԫ�ش��ڵ�Set��
��ΪHibernate���Լ���Collectionʵ�֣���������������������
Set hset = (HashSet)user.getAddresses();
���������ڱ���һ��java.lang.ClassCastException,��Ϊʵ���Ϸ��ص���һ������Ϊorg.hibernate.collention.Set�Ķ�����
����������дPOJOʱ��������JDK Collection Interface(��Set, Map)�������ض���JDK Collectionʵ����(��HashSet, HashMap)����Collection�����Ե�ԭ�������磺
Ӧ����private Set addresses;
������private HashSet addresses;

collection�������Եı������̡�
����
public class TUser implements Serializable {

> private Set addresses = new HashSet();
> > ......
}

Ȼ�󴴽�һ��TUserʵ���󣬾Ϳ���Ϊ�����ӹ�����address������
TUser user = new TUser();
TAddress addr = new TAddress();
addr.setAddress("HongKong");
user.getAddress().add(addr);
session.save(user);
user�����ھ���Hibernate�����������˱仯�����ȣ�����insert������������idֵ�������䵽user������id���ԣ���һ����Hibernateʹ�����Լ���collectionʵ�ֶ�user�е�HashSet��addresses���Խ������滻���������ݶ������������䡣

