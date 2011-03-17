1.java的命名规则
	对大小写敏感，以字母开头，可以混合字母和数字，无长度限制，不能使用java保留字
	标识符必须以字母或下划线或$开始，其余可以是数字	
2.注意事项
	java的应用程序都写在类中
	文件名必须和公共类名相同
3.数据类型
	基本类型
	      整型byte(1) short(2) int(4) long(8)  (一个字节八个位)
	      浮点型float(4) double(8)
	      字符型char(2)存放数据的unicode码
	      布尔型boolean(一个位) true false
	      相互转化时精度的丢失   int a=10; float a=(float)a;
            整型和字符型相互转化不需强制 int a=10; char b; b=a;
            不支持整型和布尔型的转化
	引用类型(与使用类对象有关)  类名 变量名 ＝ new 类名();
            引用类型和基本类型之间的转化   
                引用类型转化为基本类型(用引用类型自身的成员函数.valueof())
                  String str = new String("1234");str=str+Str.valueof(1);System.out.println(str);
                基本类型转化为引用类型(用基本类型封装类)
                	String str = new String("1234");
                  int i = Integer.parseInt(str)+1;
                  double i=Double.parseDouble(str)*3;
                  char i = Character.parseCharacter(str);
4.java的注释
	单行注释//.....
	多行注释/*....*/
	文档注释/** ....*/
5.java的关键字
     原始数据类型  byte  short  int  long float  double  char boolean
     循环关键字  do  while  for  break  continue
     分支关键字 if else switch case default break
     方法、变量和类修饰符 private public protected final static abstract synchronized volatile strictfp 
     异常处理 try catch finally throw throws
     对象相关关键字new extends implements class instanceof this super
     字面值常量 false  true null
     方法相关关键字 return void
     包相关关键字 package import
6.变量
	变量的三个特征	 名称 初始值 作用域
7.Instanceof运算符
     对象名 instanceof 类名 判断对象是否属于一个特定的类
8.几个常用的类
   String类的一些常用方法
    charAt() 返回字符串中某个特定位置的字符
    indexOf() 返回字符串中某个特定字符或子字符串首次出现的索引
    toUpperCase() 将字符串类的所有字符从小写改为大写
    toLowerCase() 将字符串内所有字符从大写改为小写
9.java.lang包    	
    该包是java编程语言的基础
    	Object 类体系结构的根
    	Class  封装对象或接口运行时的状态
    	封装类 封装基本数据类型，为基本数据类型简历对象表达式
    	Void 有TYPE域，保存对类型void 的Class对象的引用
    	Math  
    	       java.lang.Math类中可用的static方法有 
    	      abs()
    	      ceil()返回不小于参数的整数 floor()返回不大于参数的整数 
    	      random() 0-1之间的随机数double型   	      
    	      max() min()
    	      round()双精度四舍五入整型或长整型
    	String StringBuffer
    	ClassLoader	Process   	Runtime   SecurityManager    	System//提供系统操作，管理类的动态加载，外部进程的创建主机环境的查询及安全策略
10.java控制结构
	选择 if else;switch case default(参数不能为浮点型);
	循环while ;do while; for;
	跳转
	break 跳出当前循环
      continue 回到循环起始，不执行后面语句
