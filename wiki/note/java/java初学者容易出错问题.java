１.String类和StringBuffer类

　　它们都是处理字符串的类,但是它们有一个最大的区别,那就是,String对象是存储你不能改动的文本字符

　　串,相反,如果你希望改动,则应使用StringBuffer类作为替换.
　
　　eg1:

　　......

　　//omit some code

　　String s1="You are hired!";

　　System.out.println(s1.replace('h','f'));//用f把字串中的h替换了

　　System.out.println(s1);

　　 ......

　　//omit some code

　　运行结果:

　　You are fired!

　　You are hired!


结果分析:

　　从结果,明显可知,s1的值并没有被改变,而第一行结果只是屏幕内容的替换.
　
　　eg2:

　　......

　　//omit some code

　　StringBuffer s2=new StringBuffer("Hello from Java!");

　　s2.replace(6,10,"to");

　　System.out.println(s2);

　　......

　　//omit some code

　　运行结果:

　　Hello to Java!

　　结果分析:

　　显然,s2的值已改变.
２.位逻辑与条件逻辑
　
　　首先声明, 为了与位逻辑更好区分开来,我把通常所说的逻辑取了个别名叫做条件逻辑.

　　它们都有各自的操作符,位逻辑操作符有:&(与运算),^(异或运算),|(或运算);条件逻辑操作符有:&&(并且),||(或者).

位逻辑运算通常是针对两个数而言,实行位操作;而条件逻辑运算是针对两个条件表达式而言,实行条件操作.其实,位逻辑操作符一样可以实现条件操作,但是此时有一个重要的区别:用位操作符时,不管操作符两边的

　　条件表达式成不成立,它都要通通进行运算判断,而条件逻辑操作符不一样了,如果通过左侧的操作数就可以进行它们需要的判断,那么它就不会再计算右侧的操作数了,这种情况叫短路.废话少说!且看下例.

　　eg1:

　　......

　　//omit some code

　　double value=0;

　　if(value!=0 && 1/value<1000){

　　System.out.println("The value is not too small.");
　　
　　}

　　else{

　　System.out.println("The value is too small.");

　　}

　　......

　　//omit some code

　　运行结果:

　　The value is too small.
　结果分析:

　　照理说应会出现除数为0的错误,但是我刚才说了,由于条件逻辑操作符是短路操作符,显然,value!=0不成立,立即就可作出判断应执行else后的语句,所以它就不再会运算判断1/value<1000了.如果不懂请再看一例:

　　eg2:

　　......

　　//omit some code

　　double int1=0,int2=1,int3=1;

　　if(int1!=0 & (int2=2)==1){}

　　System.out.println("int2="+int2);

　　if(int1!=0 && (int3=2)==1){}

　　System.out.println("int3="+int3);

　　......

　　//omit some code

　　运行结果:

　　int2=2.0

　　int3=1.0

　　结果分析:

　　我想不用我分析了,你应该懂了吧.

 

