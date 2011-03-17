时常看到一些人说掌握了Java，但是让他们用Java做一个实际的项目可能又困难重重，在这里，笔者根据自己的一点理解斗胆提出自己的一些对掌握Java这个说法的标准，当然对于新手，也可以提供一个需要学习哪些内容的参考。另外这个标准仅限于J2SE部分，J2EE部分的内容有时间再另说。 
　　1、语法：必须比较熟悉，在写代码的时候IDE的编辑器对某一行报错应该能够根据报错信息知道是什么样的语法错误并且知道任何修正。

　　2、命令：必须熟悉JDK带的一些常用命令及其常用选项，命令至少需要熟悉：appletviewer、HtmlConverter、jar、java、javac、javadoc、javap、javaw、native2ascii、serialver，如果这些命令你没有全部使用过，那么你对java实际上还很不了解。

　　3、工具：必须至少熟练使用一种IDE的开发工具，例如Eclipse、Netbeans、JBuilder、Jdeveloper、IDEA、JCreator或者Workshop，包括进行工程管理、常用选项的设置、插件的安装配置以及进行调试。

　　4、API：Java的核心API是非常庞大的，但是有一些内容笔者认为是必须熟悉的，否则不可能熟练的运用Java，包括：

　　    1）、java.lang包下的80％以上的类的功能的灵活运用。

　　    2）、java.util包下的80％以上的类的灵活运用，特别是集合类体系、规则表达式、zip、以及时间、随机数、属性、资源和Timer。

　　    3）、java.io包下的60％以上的类的使用，理解IO体系的基于管道模型的设计思路以及常用IO类的特性和使用场合。

　　    4）、java.math包下的100％的内容。

　　    5）、java.net包下的60％以上的内容，对各个类的功能比较熟悉。

　　    6）、java.text包下的60％以上的内容，特别是各种格式化类。

　　    7）、熟练运用JDBC。

　　    8）、java.security包下40％以上的内容，如果对于安全没有接触的话根本就不可能掌握java。

　　    9）、AWT的基本内容，包括各种组件事件、监听器、布局管理器、常用组件、打印。

　　    10）、Swing的基本内容，和AWT的要求类似。

　　    11）、XML处理，熟悉SAX、DOM以及JDOM的优缺点并且能够使用其中的一种完成XML的解析及内容处理。

　　5、测试：必须熟悉使用junit编写测试用例完成代码的自动测试。

　　6、管理：必须熟悉使用ant完成工程管理的常用任务，例如工程编译、生成javadoc、生成jar、版本控制、自动测试。

　　7、排错：应该可以根据异常信息比较快速的定位问题的原因和大致位置。

　　8、思想：必须掌握OOP的主要要求，这样使用Java开发的系统才能是真正的Java系统。

　　9、规范：编写的代码必须符合流行的编码规范，例如类名首字母大写，成员和方法名首字母小写，方法名的第一个单词一般是动词，包名全部小写等，这样程序的可读性才比较好。

　J2EE学习之路

zhangxhsj

Java (2003-06-04 10:40:01) 


--------------------------------------------------------------------------------

 

  初次接触Java，以为Java就是做Applet的。慢慢地知道了http://java.sun.com，开始知道Java其实博大精深。学习中,慢慢地知道了JCP组织是制定Java相关规范的发源地（http://java.jcp.org）, 于是订阅了一份邮件列表。真是好东西，定期有Java的最新动向，让我受益非浅。后来, 自己动手下载了Java 2 SDK和Java 2 SDK Documentation, 边看边学完成了安装。 

  记得刚搭起Java开发环境后，还是用UltraEdit编辑并编译的（在其中可以配好Java的编译环境），后来改用JCreator了。偶然地看到《Java 2核心技术》Ⅱ，很是喜欢，后来知道了《Thinking in Java》也是一本好书，直到今天有了Java经验后，看这本书仍然觉得特别过瘾，还经常翻翻。逐渐地知道Oreilly公司（http://www.oreilly.com）出的图书不错，很高雅，后来从网上知道了jjhou（侯捷）这个人(http://jjhou.csdn.net )以及他的个人网站，尤其是侯捷老师写的书评，很好读。 

  逐渐地开始参加项目，书上看到的东西在项目中有了很好的机会去体验。最初接触的是用Swing 开发桌面系统，开始连放一个按钮都放不好，后来才知道有一个布局管理器。这时候的我常常到Sun的Java网站看Java Tutorial（http://java.sun.com/docs/books/tutorial/）。 

  随着对Java的了解，发现自己的知识比较混乱。于是,我开始研究Java规范和JDBC规范,从中我对很多概念有了新认识，尤其是DataBase的事务性控制，自己慢慢有了较为深入的理解，也知道了用Swing和JDBC开发C/S结构的数据库应用系统。后来接到了一个开发网站的任务，这是一个基于Linux、JSP、JavaBean、Oracle的系统，不同于Swing加JDBC的模式，系统之间多了一层，于是我认识了三层结构。 

  完成项目后，自己对于Java很多方面都有更多的了解。开始思考一个问题，J2EE是什么东西？有人告诉我，学习Java大概有三个方向: 一个是桌面系统，包括C/S结构；一个是J2ME, 面向无限领域; 最后一个是面向企业应用J2EE平台。 

  在痛苦的抉择后，我选择了J2EE，开始进入我的J2EE之旅。还是从下载J2EE规范、J2EE SDK开始学习。结合http://java.sun.com/j2ee/tutorial/index.html 提供的J2EE Tutorial开始研究，1个月后，接到一个J2EE构架方面的项目，是基于JSP(Servlet)、Session Bean、EIS构架开发系统，在这个项目中我学到更多的东西，掌握了SB EJB的编写，懂得了JSP如何调用EJB…… 

  完成项目后，我开始研究Java Pet Store了，大呼过瘾。开始知道了Servlet过滤器，XML方面较为全面的知识，知道了J2EE整个框架中各种技术的实际应用。慢慢地，开始研究WebLogic配置好的Pet Store（也是Sun公司的），开始尝试分析两者的不同之处，对J2EE Specification有了自己的认识：J2EE Specification本身是很严肃，但Pet Store充满活力。 

  在反复的学习中，我明白了J2EE构架。这时，新的问题又出来了，实际企业中会如何建构一个J2EE系统呢？带着这个问题，我开始分析《Core J2EE Patterns》和《EJB Design Patterns》。这时才开始真正知道J2EE的魅力所在，懂得了J2EE为什么会在企业中得到认可。 

  对“设计模式”一词的理解是一个更长的过程。慢慢地我领悟到，作为一个J2EE开发者，要掌握的核心内容主要有三个方面：实施EJB系统常用的架构、设计模式，比如Session facade、message facade、DTO等; J2EE系统构架中常用的模式; UML与 EJB相互映射。 

  我现在仍然在学习J2EE，而且还想研究下去。学习的过程很孤独，但幸好有J2EE相伴！
 
＝＝＝＝＝＝＝＝＝＝＝＝＝＝回复分割线＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
 
另一篇文章里的回复：
 
  
… 以J2SE为基础，以J2EE为核心

 

J2EE包含的技术太多了。如果你想坐在桌子旁边抱着一大堆书来学习的话，效果不大。我建议在开始这一阶段的学习的时候，可以按以下步骤来做，总的思想是“总体把握，各个击破”。 

 

◆ 了解J2EE中的技术术语的含义。

J2EE标准中涉及到的各种技术很多，如果一开始就一个一个去学习的话是不现实的，也是没效果的。我的建议是，先对其中的技术有个大概的了解，比如EJB、JavaIDL、JTA等。可能你并不知道怎么去写一个EJB，但是要知道什么是EJB、它能做什么，当有了这样的概念后，再去有目的地学习它就会快很多。我还要再重复一句：必须要在实践中动手去做才行。 

 

◆ 了解J2EE中的设计模式，这样能帮助你对J2EE做个整体把握。 

MVC开发模式被证明是有效的处理方法之一。它可以分离数据访问和数据表现。你可以开发一个有伸缩性的、便于扩展的控制器，来维护整个流程。通过这一层次的学习，当你面对一个项目的时候，应该首先把握它的总体架构的设计，以来决定采用J2EE标准中的哪些技术。 

 

◆ 了解一些J2EE平台的典型案列，加深对基本概念和相关技术的理解。 

平时可以多留意这方面，熟悉一些典型案例，分析它为什么要采用那个实践？那样做能达到什么样的目的？然后联系到自己身边的项目是否可以作为参考。（研究开源项目） 

 

◆ 学习J2EE下的各种技术。 

在有了前几阶段的学习后，可以自己搭建一个J2EE平台开始具体学习每一种技术。你可以参与公司相关项目进行学习，也可以自己搭建一个平台进行学习。这时候应该找点相关的书来一步一步学习，没有捷径可走。如果你不满足于这些，那么还应该更深入地学习UML、设计模式等方面的东西。

 

◆ 需要注意的地方

1、 理清Java的知识体系，要有的放矢的学习；

2、 一定要学会“整体框架 →功能模块 →具体细节”的编程思想；

3、 要多收集典型的功能模块（一定要懂、会写）；

4、 有了一定的基础之后要看<<Thinking In Java>>、<<Effective Java>> 

5、 推荐的学习步骤：①学语法；②学类库；③学网络（了解各种技术）；④学开源；⑤学UML；⑥学模式；⑦做项目，精通各项技术。


