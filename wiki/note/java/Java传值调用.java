public class Example2 
{ 
//自定义方法用来改变参数 
public static void change(String str,char ch[]) 
{ 
str = "Changed"; 
ch[0] = 'C';      //将字符'C'赋值给字符数组的第一个元素 
} 
static void change(int x,int y) 
{ 
int t; 
t=x;x=y;y=t; 
} 

public static void main(String[] args) 
{ 
//创建并初始化字符串对象，及字符数组对象 
String s = new String("World"); 
char ch[] = {'H','e','l','l','o'}; 

//调用change()方法 
change(s,ch); 
System.out.println(s+" and "+ch[0]); 

int a=111,b=222; 
change(a,b); 
System.out.println(a+"\t"+b); 
} 
} 


String 是不可改变的对象 
ch[]就是对象引用了 
int y就是传值 
JAVA中都是传值，而且传递的都是该值的一个副本，比如传递一个基本类型就是这个基本类型的副本，传递一个引用，就是该引用的副本，那么此时的意思就是2个引用同时指向一个对象，只要其中一个引用调用了对象的方法改变的该对象的字段值，那么另一个引用获得的值也就是改变后的值了 
都是传值。区别是String s;传的是引用s本身，方法中有一个s的副本，方法中的str和参数s不是一个东西，但指向同一个对象。如果你让str指向一个新的对象，当然不会对外面的s造成印象。但是你如果更改了对象的状态，就是实实在在改变了外面的对象。 
关键是区别对象本身和对象的引用。 
对于char ch[]; 
如果你在方法里让ch=一个新的数组，外面的同样不受影响，但你用ch[0]就是访问了ch指向的实际数组对象了，做出的修改就是对方法外对象的修改。 
在java中，有实例变量和引用变量之分 
例如: 
A a = new A(); 
在这里，new A()得到一个实例变量，它存放在内存的某个位置 
而a是一个引用变量，它是一个位串，指向刚才new的实例变量 
而java函数传递的是引用变量的拷贝，也就是说如果你传a给函数，其实会拷贝一份a(暂且叫a)再把a传进去 
假设有个字符串引用变量s传给了change（），s是指向"world"的，实际上它是传了s的拷贝s进去，刚传进去时a作为a的拷贝同样指向"world" 
但是在函数体内，s被指向了"Changed"，但是s 还是指向“world”,因而打印s时依然是"world" 
再来看ch,当传递数组进去的时候又会怎么样呢？ 
同样，拷贝成ch'传递进去，同ch指向同一个实例，而ch'[0]代表什么呢？代表这个数组实例在0位置的值，它是个什么呢？它是个指向'H' 的应用变量， 
ch[0] = "C"则使这个引用变量指向了'C' 
再来看对基本类型有什么不同 
对于基本类型，就不存在什么引用变量指向实例变量的问题了，应为基本类型很简单，直接用位串就能表示了，int a = 111中的a就直接用来表示111 
但在函数传值时依然传的是a 的拷贝a'在函数体内无论你怎么改变，知识改变a'的值而不会改变a 
再来看 
Java code
public class Example2 
{ 
//自定义方法用来改变参数 
public static void change(String str,char ch[]) 
{ 
str = "Changed"; 
ch[0] = 'C';      //将字符'C'赋值给字符数组的第一个元素 
} 
static void change(int x,int y) 
{ 
int t; 
t=x;x=y;y=t; 
} 

public static void main(String[] args) 
{ 
//创建并初始化字符串对象，及字符数组对象 
String s = new String("World"); 
char ch[] = {'H','e','l','l','o'}; 

//调用change()方法 
change(s,ch); 
System.out.println(s+" and "+ch[0]); 

int a=111,b=222; 
change(a,b); 
System.out.println(a+"\t"+b); 
} 
} 
String 是不可改变的对象 
ch[]就是对象引用了 
int y就是传值 
都是传值。区别是String s;传的是引用s本身，方法中有一个s的副本，方法中的str和参数s不是一个东西，但指向同一个对象。如果你让str指向一个新的对象，当然不会对外面的s造成印象。但是你如果更改了对象的状态，就是实实在在改变了外面的对象。 
关键是区别对象本身和对象的引用。 
对于char ch[]; 
如果你在方法里让ch=一个新的数组，外面的同样不受影响，但你用ch[0]就是访问了ch指向的实际数组对象了，做出的修改就是对方法外对象的修改。  
JAVA中都是传值，而且传递的都是该值的一个副本，比如传递一个基本类型就是这个基本类型的副本，传递一个引用，就是该引用的副本，那么此时的意思就是2个引用同时指向一个对象，只要其中一个引用调用了对象的方法改变的该对象的字段值，那么另一个引用获得的值也就是改变后的值了 
1、Java都是按“值”传递，基本类型是通过拷贝传递的，即楼上各位所说的“副本”，所以基本类型传参后，接收方改变了参数的值后，不会影响传递方的原值。 
2、引用类型（如String）可以看作是一个遥控器（假设长虹的遥控器只能对一台长虹电视起作用），引用类型本身就是一个指向对象在内存中的字节组合的。 
3、引用类型的传递意思是克隆了一个遥控器（即“副本”），而这个遥控器副本与被克隆的遥控器“原件”具有相同功能，即只能对同一台长虹电视起作用。 
4、当遥控器“原件”将电视机音量从0调整到15后，遥控器“副本”要再次改变电视机音量状态则必定从音量为15的起始位置开始作调整。诸如此类的，我们就可以总结出，引用类型传参后，接收方改变了参数的值后，将直接改变传递方的原值。 
String 是不可改变的对象 
ch[]就是对象引用了 
int y就是传值 
Java code
//按引用传递
　　public class Test {
　　 public static void test(StringBuffer str) {
　　 str.append(", World!");
　　 }
　　 public static void main(String[] args) {
　　 StringBuffer string = new StringBuffer("Hello");
　　 test(string);
　　 System.out.println(string); 网管u家u.bitscn@com 
　　 }
　　}
　　　　运行结果：
　　
　　Hello, World!

//按值传递

public class Test {
　　 public static void test(String str) {
　　 str = "World";
　　 }
　　 public static void main(String[] args) {
　　 String string = "Hello";
　　 test(string);
　　 System.out.println(string);
　　 }
　　}
　　　　运行结果：
　　Hello
