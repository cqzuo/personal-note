J2SE����֪ʶ��ϰ_1(ԭ��)
1���׻�����֪ʶ��equal �룽���� ���� ��string��stringbuffer�� ��ϵ������
2��������̸�𣬱Ƚ������ ���������������ȱ��̶���С�����������㣩
    ������Դ洢һЩ�����������ͣ����ж���
    �����أ��洢�Ķ���һЩ���󣬿����ֲ�����,����һЩ��������������ô���أ����������ǲ��Ƕ��з�װ�ࣿ��int,char,float,double��
3������̸��arraylist����������ظ������ݣ��ײ�������ʵ�ֵģ����漴�����ٶȿ죬������ʵ��
4�����ܼ����еĵ�����
���ӣ�
֪ʶ�㣺����˵����arraylist��������ظ���Ԫ�أ���θ����˸����tostring��������ӡ����
public class HasterMaze()
{
    public static void main(String[] args)
    {
        List list=new ArrayList();
            list.add("dog");
            list.add("dog");   
            list.add("cat");       
        System.out.println(list);
    }
}
���������չ�����������Զ���һ���࣬���򼯺�arraylist����ӣ���δ�ӡ���е�Ԫ�أ�hamsternumber��
public class HamsterMaze
{
    public static void main(String[] args)
    {
        List list=new ArrayList();
        for(int i=0;i<3;i++)
        {
            list.add(new Hamster(i));//��δ�ӡ�ˣ�
            //System.out.println(list);//û����д�����tostring����ʱ�Ĵ�ӡ
            //System.out.println(list);//��д�˸���tostring������Ĵ�ӡ
            //(Hamster)list.get(0).print();
            //list.get(0).print();
           
        }
    }
}
дһ���࣬������д�˸����tostring����
public class Hamster
{
    private int hamsterNumber;
    public Hamster(int hamsteNumber)
    {
        this.hamsterNumber=this.hamsterNumber;
    }
    /*public String toString()
    {
        return "this is hamster #"+hamsterNumber;
    }*/
    /*public void print()
    {
        System.out.println( "this is hamster #"+hamsterNumber);
    }*/
}


4��������ȷ����δ֪���ͣ�
���������ò������������

�򼯺��д洢Ԫ���ǲ��Ǻܷ��㣿���Ҵ�ӡʱ������Զ�����࣬��д�¸����tostring�����Ϳ�����
����һ��Ĺٷ������ࣨInteger��String������������Щ�඼�����ʱ���Ѿ���д�˸����tostring��������ô�������ȡ�����е�Ԫ���أ�
�������һ�����Ͷ�ʧ�����⣡�����ü��ϵķ�����������������ڼ����д洢�Ķ��󣬾ͻ�һֻ��أ������㶨������ͻ����� �����ͣ�
�����Ķ���Ͳ���洢
���Ƽ��������ȥ��������һ����ֻ�洢һ�����͵Ķ��󣬱����������������������Ķ������ͣ�


�������ǲ��Ǻ��鷳�����뼯���еĶ���ȡ�����󶼶�ʧ�����ͣ���ô�����


�������ǽ�����һ�ּ���linkedlist������ʵ����list�ӿڣ���˶���list�еķ������м��϶����ã���

linkedlist�ṩ������һЩ�Ƚ����صķ�����addFirst��removeFirst��addLast��removeLast


����linkedlist��arraylist���Ƿ���ֻ��ͨ������������ĳ��Ԫ�أ�������ݹ��������ͻ�ʧȡ���壬�����ܷ�ͨ��һЩ����˼�Ĺؼ��������ʴ洢�ڼ����е������� ��
map���ǽ��������Ϊʲô��Ϊmap�أ���ͼ�ϵ�ÿ�����У�ÿ���ص㣬�ǲ��Ƕ���һ�����ֺ����Ӧ��ͨ��һ�������ҿ��Ի��һ���ص㣬��������Ҳ����ͨ��һ���ؼ�������ȡһ������
mapͨ��put������ֱ�����洢���� ͨ��get����������ȡ����

HashSet

���������ҽ�������ʲô��ɢ���룺��һ��INTֱ����־�����Ψһ�ԣ�hashcode���ڸ���object�ж���ķ�����
public class HashDemo
{
    public static void main(String arghs[])
    {
       
        System.out.println(new Integer(1).hashCode());
        System.out.println(new Demo().hashCode());
    }
}
class Demo
{
   
}
��������ж����һЩ�࣬�ܶ඼ʵ����hashcode()������ʵ���˱Ƚ�������ıȽ�
����������ֶ������أ��ȷ�˵��

import java.util.*;
class HashSetTest
{
    public static void main(String[] args)
    {
        HashSet hs=new HashSet();
        /*hs.add("one");//��ͬ������
        hs.add("two");
        hs.add("three");
        hs.add("one");*///��ͬ������
        hs.add(new Stu(1,"zhangsan"));//��ͬ������
        hs.add(new Stu(2,"lisi"));
        hs.add(new Stu(3,"wangwu"));
        hs.add(new Stu(1,"zhangsan"));//��ͬ������
        System.out.println(hs.size());
    }
}
class Stu
{
    private int i;
    private String name;
    public Stu(int i,String name)
    {
        this.i=i;
        this.name=name;
    }
}


������θ����ֶ������HASH�룬ֻ�踲�Ǹ����HASHCODE������������ҿκ����Լ�����һ�£�


import java.util.*;
class HashMapTest
{
    public static void printElements(Collection c)
    {
        Iterator it=c.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
    public static void main(String[] args)
    {
        HashMap hm=new HashMap();
        hm.put("one","zhangsan");
        hm.put("two","lisi");
        hm.put("three","wangwu");
       
        System.out.println(hm.get("one"));
        System.out.println(hm.get("two"));
        System.out.println(hm.get("three"));
       
       
        Collection keys=hm.keySet();
        System.out.println("Key:");
        printElements(keys);
       
        Collection values=hm.values();
        System.out.println("Value:");
        printElements(values);
       
    }
}

