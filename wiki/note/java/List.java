J2SE基础知识复习_1(原创)
1。易混淆的知识（equal 与＝＝的 区别 ，string和stringbuffer的 联系和区别）
2。从数组谈起，比较数组和 容器的区别（数组的缺点固定大小，遍历不方便）
    数组可以存储一些基本数据类型，还有对象！
    集合呢？存储的都是一些对象，可以弥补数字,对于一些基本数据类型怎么办呢？基本类型是不是都有封装类？（int,char,float,double）
3。接着谈论arraylist，允许添加重复的数据（底层是数组实现的），随即遍历速度快，靠索引实现
4、介绍集合中的迭代器
例子：
知识点：首先说明了arraylist可以添加重复的元素，其次覆盖了父类的tostring方法，打印方便
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
下面继续扩展：我们现在自定义一个类，并向集合arraylist中添加，如何打印所有的元素（hamsternumber）
public class HamsterMaze
{
    public static void main(String[] args)
    {
        List list=new ArrayList();
        for(int i=0;i<3;i++)
        {
            list.add(new Hamster(i));//如何打印了？
            //System.out.println(list);//没有重写父类的tostring方法时的打印
            //System.out.println(list);//重写了父类tostring方法后的打印
            //(Hamster)list.get(0).print();
            //list.get(0).print();
           
        }
    }
}
写一个类，并且重写了父类的tostring方法
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


4。容器的确定（未知类型）
可以用引用参数化来解决！

向集合中存储元素是不是很方便？而且打印时如果是自定义的类，重写下父类的tostring方法就可以了
对于一般的官方定义类（Integer，String，。。。）这些类都在设计时都已经重写了父类的tostring方法，那么我们如何取集合中的元素呢？
这就面临一个类型丢失的问题！可以用集合的泛化来解决？这样对于集合中存储的对象，就会一只监控！除了你定义的类型或他的 父类型，
其他的对象就不会存储
我推荐大家这样去做，集合一般是只存储一种类型的对象，避免你无意中增加了其他的对象类型！


这样做是不是很麻烦，放入集合中的对象取出来后都丢失了类型，怎么解决？


下面我们讲述令一种集合linkedlist：（都实现了list接口，因此对于list中的方法两中集合都是用）：

linkedlist提供了其他一些比较奇特的方法：addFirst，removeFirst，addLast，removeLast


对于linkedlist和arraylist我们发现只能通过索引来访问某个元素，如果数据过多索引就会失取意义，我们能否通过一些有意思的关键字来访问存储在集合中的数据呢 ？
map就是解决方法！为什么称为map呢？地图上的每个城市，每个地点，是不是都有一个名字和其对应？通过一个名字我可以获得一个地点，所有我们也可以通过一个关键字来获取一个对象！
map通过put（键，直）来存储对象 通过get（键）来获取对象

HashSet

首先先向大家介绍以下什么是散列码：用一个INT直来标志对象的唯一性（hashcode是在父类object中定义的方法）
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
对于类库中定义的一些类，很多都实现了hashcode()方法，实现了比较两对象的比较
，如果我们字定义类呢？比方说：

import java.util.*;
class HashSetTest
{
    public static void main(String[] args)
    {
        HashSet hs=new HashSet();
        /*hs.add("one");//相同的数据
        hs.add("two");
        hs.add("three");
        hs.add("one");*///相同的数据
        hs.add(new Stu(1,"zhangsan"));//相同的数据
        hs.add(new Stu(2,"lisi"));
        hs.add(new Stu(3,"wangwu"));
        hs.add(new Stu(1,"zhangsan"));//相同的数据
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


至于如何更改字定义类的HASH码，只需覆盖父类的HASHCODE（）方法，大家课后先自己钻研一下！


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

