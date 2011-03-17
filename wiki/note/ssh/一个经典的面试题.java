一道小而精巧的笔试题——Set、equals、类型转换……
题目：

public class SetSize {
    public static void main(string[] args) {
        Set<Short> set = new HashSet<Short>();
        for(short i = 0; i < 10; i++) {
            set.add(i);
            set.remove(i - 1);
        }

        System.out.println(set.size());
    }
}

上面代码输出结果为10，为什么？


题目乍一看很简单，不就是一个HashSet么，但看完了题目又觉得困惑：对啊，怎么会是10？真难为自己还特意花了一些时间学习Java的Collection Framework，居然连这么小的一个题目都吃不透，汗颜啊……

看了半天，没有思路，跳过去做其他题，待到收卷前10分钟，不甘心，再回过头来看这道题。发现一个值得怀疑的地方：Set<Short> set = ……
为什么要特意设定是Short？再看到下面的i - 1，马上感觉到似乎和类型转换有关。

目前可以肯定的是：
1. set存储的元素是Short类型
2. 调用remove方法时，i - 1会自动转型为int，也就是说，传给remove方法的参数是一个int值

接下来呢？int值会被自动包装成Integer还是Short？对Java的泛型和Auto-Boxing不是很了解，于是在这犯迷糊了，只好将目前的思路草草写了几笔，交卷……

作为一名后知后觉的Java爱好者，自然不能放过这么有意思的题目。如是回来之后，上机亲自试验，输入试题程序，出来的结果果然是10（嗯，没骗我……）。然后验证自己的猜测：将Set<Short>改为Set<Integer>，输出结果……1！

看来我还是有一定的嗅觉的……

接下来就是探索原因了

首先验证一下i - 1得到的结果会不会有错：-1，0，1，……8。嗯，是对的

然后验证一下每次remove之后有没有真的remove掉指定的值……发现没有。

苦思……

经一位精研C++的同学提醒：是不是因为存的是short，但删的是int，所以不能删？

试验一下：

short temp = 1;
Short s = new Short(temp);  //不能是new Short(1)，否则编译出错
Integer i = new Integer(1);
System.out.println(s.equals(i));

输出结果……false！看来终于找到真正的原因了。

查看一下Short.equals()方法的源代码：

public boolean equals(Object obj) {
    if (obj instanceof Short) {
        return value == ((Short)obj).shortValue();
    }
    return false;
}

ft……居然不是同一类型的就无视……这跟胸怀广阔的集合框架背道而驰啊……当然，这是我的错

目前可以大致推断：因为set中存入的是值为0～9的Short型对象，而每次删除是是要求删除值为－1～8的Integer型对象，但值相同的Short与Integer看来并不“相等”，所以无法删除。

那就看一下HashSet的remove方法究竟干了些什么

public boolean remove(Object o) {
    return map.remove(o)==PRESENT;
}

public V remove(Object key) {
        Entry<K,V> e = removeEntryForKey(key);
        return (e == null ? null : e.value);
}

终于到主菜了……
/** *//**
     * Removes and returns the entry associated with the specified key
     * in the HashMap.  Returns null if the HashMap contains no mapping
     * for this key.
     */
    final Entry<K,V> removeEntryForKey(Object key) {
        int hash = (key == null) ? 0 : hash(key.hashCode());
        int i = indexFor(hash, table.length);
        Entry<K,V> prev = table[i];
        Entry<K,V> e = prev;

        while (e != null) {
            Entry<K,V> next = e.next;
            Object k;
            if (e.hash == hash &&
                ((k = e.key) == key || (key != null && key.equals(k)))) {
                modCount++;
                size--;
                if (prev == e)
                    table[i] = next;
                else
                    prev.next = next;
                e.recordRemoval(this);
                return e;
            }
            prev = e;
            e = next;
        }

        return e;
    }

代码就不用解释了，大家都看得懂。

HashSet里面删除一个元素时，首先要根据传进来对象的hash值从hash table中找到对应的“Entry”，当然，难免会有碰撞的情况，这时需要遍历一下来找到真正需要删除的对象。一直到这一步，Short和 Integer的差异还没有体现出来，因为它们返回的hash值是相同的，但当执行key.equals(k)的时候，就“不相等”了，因此找不到要删除的元素，删除失败


小小的一道题，囊括了Java方方面面的细节，果然语言这个东西博大精深啊，有时候你以为自己很明白了，但随便揪出一共细节来就足以打到你……


