<map version="0.9.0">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node BACKGROUND_COLOR="#00bfff" CREATED="1298510322937" ID="ID_1410509232" MODIFIED="1298510322937" TEXT="&#x96c6;&#x5408;&#x6846;&#x67b6;.org">
<richcontent TYPE="NOTE"><html><head/><body><p>--org-mode: WHOLE FILE</p></body></html></richcontent>
<node CREATED="1298510322953" ID="ID_950883762" MODIFIED="1298510345546" POSITION="left" TEXT="&#x6846;&#x67b6;&#x6982;&#x8ff0;">
<node CREATED="1298510322953" FOLDED="true" ID="ID_906901400" MODIFIED="1298510395140" TEXT="&#x4f5c;&#x7528;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_1610193374" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 保存数量不确定的数据<br/> - 保存有映射关系的数据</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "作用" --</p></body></html></richcontent>
</node>
</node>
<node CREATED="1298510322953" FOLDED="true" ID="ID_431024832" MODIFIED="1298510395828" TEXT="&#x4e0e;&#x6570;&#x7ec4;&#x7684;&#x533a;&#x522b;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_4157438" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 数量不确定<br/> - 只能保存对象</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "与数组的区别" --</p></body></html></richcontent>
</node>
</node>
<node CREATED="1298510322953" FOLDED="true" ID="ID_433157005" MODIFIED="1298510397890" TEXT="&#x6839;&#x63a5;&#x53e3;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_369793978" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - Collection<br/> - Map <br/>  + 保存的数据为key不重复的key-value对</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "根接口" --</p></body></html></richcontent>
</node>
</node>
</node>
<node CREATED="1298510322953" FOLDED="true" ID="ID_1854114970" MODIFIED="1298510473140" POSITION="left" TEXT="Collection&#x63a5;&#x53e3;&#x548c;Iterator&#x63a5;&#x53e3;">
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="Collection">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 常用方法 add,addAll,clear,contains,containAll,remove,removeAll,size,isEmpty,toArray,iterator,re-tainAll</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "Collection" --</p></body></html></richcontent>
</node>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="Iterator">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_1658545927" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 常用方法 next,hasNext,remove</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "Iterator" --</p></body></html></richcontent>
</node>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="forEach">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 也可以实现遍历集合</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "forEach" --</p></body></html></richcontent>
</node>
</node>
</node>
<node CREATED="1298510322953" FOLDED="true" ID="ID_1657693747" MODIFIED="1298510665343" POSITION="right" TEXT="Set">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 元素无序且不能相同<br/> - 比较值的方法是equal()而非"=="</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "Set" --</p></body></html></richcontent>
</node>
<node CREATED="1298510322953" ID="ID_469103410" MODIFIED="1298510492843" TEXT="HashSet">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_619307386" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 使用hash算法来存取集合中的元素<br/> - 通过比较hashcode的值来比较对象<br/> - 重写equals()时,必须同时重写hashcode()<br/> - 如果放入Hashset集合的对象为可变对象,则可能无法准确访问</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "HashSet" --</p></body></html></richcontent>
</node>
<node CREATED="1298510322953" ID="ID_1307253146" MODIFIED="1298510322953" TEXT="LinkedHashSet">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_1755670308" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 使用链表维护集合元素的顺序 </p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "LinkedHashSet" --</p></body></html></richcontent>
</node>
</node>
</node>
<node CREATED="1298510322953" ID="ID_643513913" MODIFIED="1298510493968" TEXT="TreeSet">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_1812873198" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 继承了SortedSet接口,确保集合元素处于排序状态<br/> - 放入其中的元素必须是同一类型</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "TreeSet" --</p></body></html></richcontent>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="&#x5e38;&#x7528;&#x65b9;&#x6cd5;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_1310040117" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - first,last,lower,higher,subset,headSet,tailSet,comparator</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "常用方法" --</p></body></html></richcontent>
</node>
</node>
<node CREATED="1298510322953" FOLDED="true" MODIFIED="1298510322953" TEXT="&#x6392;&#x5e8f;">
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="&#x81ea;&#x7136;&#x6392;&#x5e8f;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 将插入的元素通过compareTo()进行升序排列<br/> - 放入TreeSet集合的对象必须实现Comparable接口</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "自然排序" --</p></body></html></richcontent>
</node>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="&#x5b9a;&#x5236;&#x6392;&#x5e8f;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 通过接口Comparator</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "定制排序" --</p></body></html></richcontent>
</node>
</node>
</node>
</node>
<node CREATED="1298510322953" ID="ID_11383368" MODIFIED="1298510494796" TEXT="EnumSet">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 专为枚举类型设计<br/> - 元素必须是枚举类型</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "EnumSet" --</p></body></html></richcontent>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="&#x5bf9;&#x8c61;&#x7684;&#x6784;&#x9020;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 通过对象的静态方法构造<br/> - 方法<br/>  + allOf,noneOf,of,range,copyof(EnumSet),copyOf(Collection),complementOf</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "对象的构造" --</p></body></html></richcontent>
</node>
</node>
</node>
<node CREATED="1298510322953" FOLDED="true" ID="ID_135712319" MODIFIED="1298510660218" TEXT="&#x96c6;&#x5408;&#x7684;&#x9009;&#x62e9;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_1694675054" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - HashSet类的性能比TreeSet类和LinkedHashSet类的性能要好<br/> - TreeSet在需要排序时才使用<br/> - LinkedHashSet对象在遍历集合元素的时候要更快<br/> - EnumSet类的性能最好<br/> - EnumSet只能保存枚举类型对象<br/> - Set实现类都不是线程安全的</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "集合的选择" --</p></body></html></richcontent>
</node>
</node>
</node>
<node CREATED="1298510322953" FOLDED="true" ID="ID_303446761" MODIFIED="1298510976343" POSITION="right" TEXT="List">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_1365638072" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - List是一个有序集合,每个元素都有对应的索引</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "List" --</p></body></html></richcontent>
</node>
<node CREATED="1298510322953" FOLDED="true" ID="ID_981195427" MODIFIED="1298510768468" TEXT="List&#x63a5;&#x53e3;&#x548c;ListIterator&#x63a5;&#x53e3;">
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="List&#x63a5;&#x53e3;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_1224072622" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 根据索引操作元素的方法<br/>  + 添加元素：add(Object),add(index,Object),addAll(Collection),addAll(index,Collection)<br/>  + 删除元素：remove(Object),removeAll(Collection),remove(index)<br/>  + 获取元素：get(index)<br/>  + 替换元素：set(index,Object)<br/>  + 截取元素：subList(fromIndex,toIndex)<br/>  + 返回索引值：indexOf(Object),lastIndexOf(Object)</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "List接口" --</p></body></html></richcontent>
</node>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="ListIterator&#x63a5;&#x53e3;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 实现了Iterator的子接口<br/> - 操作List的方法<br/>  + hasPrevious()<br/>  + previous()<br/>  + add()</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "ListIterator接口" --</p></body></html></richcontent>
</node>
</node>
</node>
<node CREATED="1298510322953" FOLDED="true" ID="ID_1452808825" MODIFIED="1298510791218" TEXT="ArrayList&#x548c;Vector&#x5b9e;&#x73b0;&#x7c7b;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 都是基于数组实现的<br/> - 有属性capacity来记录数组的大小<br/> - 方法<br/>  + ensureCapacity(minCapacity)<br/>  + trimToSize()</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "ArrayList和Vector实现类" --</p></body></html></richcontent>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="Stack">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 是Vector的子接口,模拟栈结构<br/> - 方法<br/>  + push(Object)<br/>  + pop()<br/>  + peek()</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "Stack" --</p></body></html></richcontent>
</node>
</node>
</node>
<node CREATED="1298510322953" ID="ID_1485660692" MODIFIED="1298510792375" TEXT="&#x56fa;&#x5b9a;&#x957f;&#x5ea6;&#x7684;List">
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="ArrayList">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_268133748" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 可将数组和多个对象转换成一个List集合,但是不能插入和删除数据<br/> - 只能遍历 </p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "ArrayList" --</p></body></html></richcontent>
</node>
</node>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="List&#x96c6;&#x5408;&#x7c7b;&#x7684;&#x9009;&#x62e9;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_54679877" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 遍历集合时,ArrayList和Vector需要用get(),LinkedList使用迭代器<br/> - 集合需要经常修改数据,则使用LinkedList<br/> - 如果多线程访问对象,则使用Vector实现同步</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "List集合类的选择" --</p></body></html></richcontent>
</node>
</node>
</node>
<node CREATED="1298510322953" ID="ID_437328093" MODIFIED="1298510974750" POSITION="right" TEXT="Queue&#x63a5;&#x53e3;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 模拟队列的接口<br/> - 方法<br/>  + add(),offer(),element(),peek(),poll(),remove()</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "Queue接口" --</p></body></html></richcontent>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="LinkedList&#x5b9e;&#x73b0;&#x7c7b;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" ID="ID_1332806160" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 可以当作双向队列,栈和List集合<br/> - 插入删除性能好<br/> - 遍历最好使用迭代器</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "LinkedList实现类" --</p></body></html></richcontent>
</node>
</node>
<node CREATED="1298510322953" MODIFIED="1298510322953" TEXT="PriorityQueue&#x5b9e;&#x73b0;&#x7c7b;">
<node BACKGROUND_COLOR="#eeee00" CREATED="1298510322953" MODIFIED="1298510322953" STYLE="bubble">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 0 }
-->
</style>
</head>
<body>
<p> - 同TreeSet</p>
</body>
</html></richcontent>
<richcontent TYPE="NOTE"><html><head/><body><p>-- This is more about "PriorityQueue实现类" --</p></body></html></richcontent>
</node>
</node>
</node>
</node>
</map>
