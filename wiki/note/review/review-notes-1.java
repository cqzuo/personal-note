今天去参加了微软的一个外包的公司的招聘，当然，这个招聘的公司不在国内，不过好在出人意料的是这个公司竟然在武汉来招聘了，我的一个非常优秀的 c++的朋友被应聘了，然后他极力推荐我去参加应聘，我第一次去，那个boss（老外）非常赞赏我，因为我的简历的原因，原来做了Shangducms这个项目并且还出了一本书，所以那个老外非常赞赏我，并且直接安排我到最后的面试。 

话说回来，这个老外是一个hr，但是是微软的员工并且长达10年的工龄，这个老外对算法和素质要求的比较高（其实国外的公司都差不多是这样），然后这个老外出了两个题，一个题是编程题，另一个是设计题，这两个题在各位高手眼中肯定比较简单，这两个题是这样的。 

1.对字符串进行排序，用任意一种编程语言来实现，不能使用现有的类，在排序中，字符串“Bc”，“Ad”，“aC”,“Hello”，“X man”，“little”，“During”,“day”能够排序成 “Ad”，"aC"，“Bc”，“During”，“day”，“Hello”，“little”，“Hello”，也就是说，在排序的过程并不是传统的按照字符串排序，在排序中还需要将小写字母一并排序，也就是说a字符串要在B或b之前。 

2.设计一个图书管理系统，无需实现，只需要写清思路就可以了。 

考试也很轻松，出了不能用QQ，MSN以外，其他的什么baidu啊google啊都可以查，本来拿到这两个题的时候觉得非常的简单（当时的感觉那是相当的简单），但是没想到做了2-3个小时还没有做出来，要不就是出现错误要不就是无法排序，结果只好被老外说“I'm sorry”了。 

后来回来了之后，感觉非常的郁闷，其实也不是特别郁闷，但是觉得自己水平不错嘛，这样的工作当然是唾手可得了，没想到马失前蹄，感觉不爽，就和朋友玩了几个小时游戏，后来坐回电脑前，改不了程序员的“劣根性”，非要搞出个所以然来，结果没出20分钟就搞定了，真是很郁闷！因为如果做不出来就算了，结果自己做20分钟就做出来了，在面试时却没有做出来，我想除了紧张以外，更多的还是基础知识不牢固的原因，下面分享一下自己的代码。 

其实第一题很简单，就是一个排序，随便用什么算法都可以，直接冒泡就可以，不过难点在于比较字符串中间的字符的ASCII的值，首先写其他代码，初始化一下，示例代码如下所示。 
        public string[] str = { "dad", "bood","bada","Admin","Good","aete","cc","Ko","Beta","Could"}; 
        public Form1() 
        { 
            InitializeComponent(); 
        } 

        private void Form1_Load(object sender, EventArgs e) 
        { 
            textBox1.Text = ""; 
            for (int i = 0; i < str.Length; i++) 
            { 
                textBox1.Text += str[i].ToString()+" "; 
            } 
        } 



上面这串代码很简单，就是先声明一个数组咯，然后在窗体加载时进行数组的遍历（原题是从文件中读取一串字符串转化为数组，这个简单，固可以忽略），当用户单击排序按钮时，进行排序，这里也很简单，示例代码如下所示。 
Code 
        private void button1_Click(object sender, EventArgs e) 
        { 
            Sort(str); 
            textBox1.Text = ""; 
            for (int i = 0; i < str.Length; i++) 
            { 
                textBox1.Text += str[i].ToString() + " "; 
            } 
        } 



当用户单击按钮时，使用排序Sort方法排序字符串然后清空现有的内容再呈现在控件中，这里关键的就是Sort方法的实现，Sort方法的实现很简单，直接冒泡就可以了，但是注意的是，这里是字符串，而不是数字，冒泡的话需要判断大小，如果使用C#函数，则可以很容易的实现Sort方法，示例代码如下所示。 
Code 
        private void Sort(string[] s) 
        { 
            for (int i = 0; i < s.Length; i++) 
            { 
                for (int j = 0; j < s.Length - i-1; j++) 
                { 
                    if (String.CompareOrdinal(s[j], s[j + 1]) > 0) 
                    { 
                        string tem = s[j]; 
                        s[j] = s[j+1]; 
                        s[j + 1] = tem; 
                    } 
                } 
            } 
        } 



好了，如果使用String.CompareOrdinal方法当然能够快速的排序，但是这里有一个问题，先不说这里不能用自带的类，就说这个题目吧，CompareOrdinal方法还是无法实现需求，但是这里给了一个思路，使用冒泡排序进行排序，可以在函数中实现字符串的大小的对比，就好像数字的对比一样，这里就该一下，使用自己的方法，示例代码如下所示。 
Code 
        private void Sort(string[] s) 
        { 
            for (int i = 0; i < s.Length; i++) 
            { 
                for (int j = 0; j < s.Length - i-1; j++) 
                { 
                    if (compare(s[j], s[j + 1]) > 0) 
                    { 
                        string tem = s[j]; 
                        s[j] = s[j+1]; 
                        s[j + 1] = tem; 
                    } 
                } 
            } 
        } 



上面的代码使用自己的compare方法进行判断，其实现思路基本同String.CompareOrdinal相同再加以改进就可以了，这是最重要的方法，因为这个方法直接关系到排序，示例代码如下所示。 


Code 
        private int compare(string str1, string str2) 
        { 
            int x=0; 
            for (int i=0,j=0; (i < str1.Length)&&(j <str2.Length); i++,j++) 
            { 
                int s1 = (int)str1[i]; 
                int s2 = (int)str2[j]; 

                //insert 
                if (s1 >= 97) 
                { 
                    s1 -= 32; 
                } 

                if (s2 >= 97) 
                { 
                    s2 -= 32; 
                } 
                //end 

                if (s1 > s2) 
                { 
                    x = 1; 
                    break; 
                } 
                else if (s1 < s2) 
                { 
                    x = 0; 
                    break; 
                } 
                else if (s1 == s2) 
                { 
                    if ((int)str1[i] > (int)str2[j]) 
                    { 
                        x = 1; 
                        break; 
                    } 
                    else 
                    { 
                        x = 0; 
                        break; 
                    } 
                } 
            } 
            return x; 
        } 



在进行compare方法的实现时，首先要确定思想，对字符串进行排序，首先要判断两个字符串的第一个字母的ASCII码，如果相等，就判断字符串的下一个字母的ASCII，以此类推，但是这里注意的是a的ASCII要比Z要大，所以在判断前还需要判断是否为小写字母（这里的方法比较蠢，呵呵），如果是小写，转换成大写进行判断，同样为了实现String.CompareOrdinal方法的效果，可以返回一个int类型的值进行判断. 

这样，整个排序就完成了，做完之后，我自己真的是感慨良深啊，自己做了多年的.NET开发，却真正意义上并不太懂How the Program Works，老外在最后也对我说了“虽然你懂很多ASP.NET,WCF,WPF等等知识，但是最基础的却掌握的不好，相比之下，我建议你在这几个月的时间里多学习一下基础，当你的基础牢固了之后，一切都变得简单了（Everything gonna to be easy）”，确实，当时做不出来最郁闷的并不是题目本身，而是忽然感觉到自己学习的过程有点像揠苗助长一样，应用做多了，反而基本的都忘记了。 

其实，这篇文章并不是最出彩的文章，也不是技术含量最深的文章，而且这个题目肯定有很多高手看一眼就能够做出来，但是我写这篇文章，只是想分享一下自己的经历，真的，其实越到后来越发现，基础往往是最重要的，这让我想起几个月前讨论的基础是不是最重要的话题时，很多人都说只要工作的时候翻翻书就可以了，当时我也是这么想，想着不会了翻书找一下就行了，没想到优秀是一种习惯，熟练的掌握基础才是编写高质量代码的基本要求。 

最后在这里分享一下一点总结： 

1.面试千万不要紧张，特别是face to face的时候，还特别是老外面试，千万不要紧张，否则水平还没有平时的十分之一。 

2.多多锻炼一下自己的基本功，无论是在校学生（像我还有几个月时间），还是上班的同学（我也工作了几年），都应该好好把握时间多练习基本功，在校生有很多的机会可以练，而参加工作的同学也需要“温故而知新”。 

3.优秀是一种习惯，无论是在解决问题上还是在编码风格上，都应该按照最好的标准要求自己（老外还说看代码主要是要看风格）。 

最后在文章的结尾希望能够和各位高手一起分享Code的乐趣和经验。 

4.可以上www.izuren.com去看看面试题 

分享一句不想关的话，人本是人，不必刻意去做人，世本是世，无须精心处世。
-------------------------------------------------------------------
分页程序代码
      
功能： 
1.每页设置显示9页，超过9页，点5页后的+1页显示（可以随便修改） 
2.CSS样式自己可以设置 
3.无任何咋代码产生，利于搜索引擎优化 
4.至于性能怎么样大家可以试下 

演示地址：http://www.dzswej.com/newslist_ej4.html 


PagedDataSource objPDS; 
...... 

//分页程序 
        objPDS = new PagedDataSource(); 
        objPDS.DataSource = dtTable.DefaultView;//绑定数据源 
        objPDS.AllowPaging = true; 
        objPDS.PageSize =10;//分页数目 
        int curPage; 
        int cshi; 
        int jshi; 
        int zyes = Int32.Parse( objPDS.PageCount.ToString()); 
        this.tjixx.Text = "总共 <font color=red>" + dtTable.Rows.Count + " </font>条信息"; 
        this.tjixx.Text += "|共 <font color=red>" + zyes + " </font>页"; 
        if (Request.QueryString["Page"] != null) 
        { 
            if (Int32.Parse(Request.QueryString["Page"]) > zyes) 
                curPage = zyes; 
            else 
            curPage = Int32.Parse(Request.QueryString["Page"]); 
        } 

        else 
        { 
            curPage = 1; 
        } 
      

        if (zyes <= 9) 
        { 
            cshi = 1; 
            jshi = zyes; 

        } 
        else 
        { 
            if (curPage <= 5) 
            { 
                cshi = 1; 
                jshi = 9; 

            } 

        else 
        { 

            cshi = curPage - 4; 
            int jshils = curPage + 4; 
            if (jshils > zyes) 
                jshi = zyes; 
            else 
                jshi=curPage + 4; 


        } 
        } 
        objPDS.CurrentPageIndex = curPage - 1; 
        StringBuilder m_strPageInfo = new StringBuilder(); 
        for (int i = cshi; i <=jshi; i++) 
        { 
            if (i == Int32.Parse(curPage.ToString())) 
                m_strPageInfo.Append(" <span class=\"dqye\"> <strong>" + i + " </strong> </span>  "); 
            else 
                m_strPageInfo.Append(" <span class=\"qtye\"> <strong> <a  href=\"newslist_ej" + Request.QueryString["wzcat"] + "_Page" + i + ".html\">" + i + " </a> </strong> </span> "); 
        } 
        this.yemsl.Text = m_strPageInfo.ToString(); 

        if (!objPDS.IsFirstPage) 
        { 


            linkPre.NavigateUrl = "newslist_ej" + Request.QueryString["wzcat"] + "_Page" + Convert.ToString(curPage - 1); 
            linkPre.NavigateUrl += ".html"; 
        } 
        if (!objPDS.IsLastPage) 
        { 
            linkNext.NavigateUrl = "newslist_ej" + Request.QueryString["wzcat"] + "_Page" + Convert.ToString(curPage + 1); 
            linkNext.NavigateUrl += ".html"; 
        } 
        linkFirstPage.NavigateUrl = "newslist_ej" + Request.QueryString["wzcat"] + "_Page1"; 
        linkFirstPage.NavigateUrl += ".html"; 
        linkEndPage.NavigateUrl = "newslist_ej" + Request.QueryString["wzcat"] + "_Page" + objPDS.PageCount.ToString(); 
        linkEndPage.NavigateUrl += ".html"; 
        this.DataList4.DataSource = objPDS;//绑定分页的数据 
        this.DataList4.DataBind(); 
----------------------------------------------------------------
java面试题
首页 新闻 论坛 群组 Blog 文档 下载 读书 Tag 网摘 搜索 .NET Java 游戏 视频 人才 外包 培训 数据库 书店 程序员 

 欢迎您:游客 | 退出 | 登录 注册 帮助 
我的帖子我参与的帖子我的空间我的网摘
 
   CSDNCSDN社区JavaJ2SE / 基础类将帖子提前   放进我的网摘   推荐给好友 我要提问 帖子加分 生成帖子 置顶 推荐(加精) 取消推荐(加精) 锁定帖子 移动帖子 取消引用结帖去... 管理菜单 页面风格切换标准风格老版本论坛  JAVA程序员面试32问!(答者有分!)  
  
 加为好友 
发送私信 
在线聊天
czp0608 
小志天下 
等级: 
可用分等级：贫农 
总技术分：438 
总技术分排名：37542 
结帖率：77.78% 

 发表于：2008-12-01 22:40:41 楼主 
第一，谈谈final, finally, finalize的区别。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 

第四，&和&&的区别。 

第五，HashMap和Hashtable的区别。 

第六，Collection 和 Collections的区别。 

第七，什么时候用assert。 

第八，GC是什么? 为什么要有GC? 

第九，String s = new String("xyz");创建了几个String Object? 

第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 

第十二，sleep() 和 wait() 有什么区别? 

第十三，Java有没有goto? 

第十四，数组有没有length()这个方法? String有没有length()这个方法? 

第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 

第十七，给我一个你最常见到的runtime exception。 

第十八，error和exception有什么区别? 

第十九，List, Set, Map是否继承自Collection接口? 

第二十，abstract class和interface有什么区别? 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 

第二十三，启动一个线程是用run()还是start()? 

第二十四，构造器Constructor是否可被override? 

第二十五，是否可以继承String类? 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 

第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 

第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 

第三十二，编程题: 写一个Singleton出来。 
 
 
 
问题点数：50 回复次数：109 显示所有回复显示星级回复显示楼主回复 修改 删除 举报 引用 回复   
 

 加为好友 
发送私信 
在线聊天
 rosewj 
rosewj 
等级: 
可用分等级：富农 
总技术分：457 
总技术分排名：35467 

 发表于：2008-12-01 22:48:571楼 得分:0 
我来顶的 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 oyto12o 
该用户很懒，没有设置昵称 
等级: 
可用分等级：中农 
总技术分：12 
总技术分排名：212675 

 发表于：2008-12-01 22:54:562楼 得分:0 
先顶下~~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 huacaisolo 
 
等级: 
可用分等级：长工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-01 23:19:023楼 得分:0 
谢谢了，最近需要这些东西！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 kokobox 
koko 
等级: 
可用分等级：富农 
总技术分：23225 
总技术分排名：502 

 发表于：2008-12-01 23:29:554楼 得分:0 
现在面试问这些的一般都少了 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 kerry_lulu 
lulu 
等级: 
可用分等级：中农 
总技术分：568 
总技术分排名：30394 

 发表于：2008-12-01 23:31:385楼 得分:0 
顶一个再顶一个 是不是算两个 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 dzh523 
Fiorentina 
等级: 
可用分等级：贫农 
总技术分：38 
总技术分排名：146056 

 发表于：2008-12-01 23:34:496楼 得分:0 
额滴神呀，一道都不会答！ 

敬候答案！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 xfzhuhan 
coolboy 
等级: 
可用分等级：短工 
总技术分：2 
总技术分排名：325861 

 发表于：2008-12-01 23:43:187楼 得分:0 
1:  final是常量关键字，finally 是异常处理中的一块(tyr,carch,)，finalize是Object 中提供的一个方法， 
    在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收， 
    例如关闭文件等。 
2：  可以。 
3：  静态类的方法直接用方法名就可调用，类部类的方法其他类不可直接调用。 
4：&是位运算符，&&是逻辑运算符。 
5：  HashMap 是HashTable 的轻量级实现，HashMap允许空键值，HashTable不允许， 
6： collection 是集合类的上级接口，继承她的有 List，Map ，collections 是针对集合类提供的方法，包括索引.. 
7:  断言，为了精确反应方法返回值进行的测试。 
8：  GC 垃圾回收机制，java中新提供的方法，有了GC程序员就不用在去费力管理自己声明的对象，.. 
9： 2 
10：12，-11 
11： 有，类型不一致， 
12：sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那 
    个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)“醒来”的线程具有更高的优先级 (b)正在运 
    行的线程因为其它原因而阻塞。  wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用， 
    该线程会  暂停执行，被调对象进入等待状 态，直到被唤醒或等待时间到。 
13：有，保留子，不使用。 
14：数组是属性，String是方法， 
15：一个是重写（对类的操作，子类继承父类，重写父类的方法），一个是重载（对方法，相同的方法名， 
    不同的参数个数，类型，构成重载），Overloaded可改变返回值。 
16： equals(),==是比较是否的同一对象，equals对值比较 
17：  下标越界，空指针。 
18: error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序 
    能处理这样的情况。 
　　exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 
19：List ，Set是 
20:  Static Nested Class是被声明为静态（static）的内部类，它可以不依赖于外部类实例被实例化。 
      而通常的内部类需要在外部类实例化后才能实例化。 

21: 可以。 
22:  都可以。 
23：start(). 
24： 不可以 
25: 不可以 
26： 不可以， 
27： 之前， 
28： 2 < <3 
29:  不可以 
30:  值传递 
31： 可以。 
32： 
public class StringLogn { 
  public StringLogn (){}; 
  private static StringLogn logn=new StringLogn(); 
  public StringLogn getLogn(){ 
    return logn; 
  }        
} 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 wp0140502 
非我莫属 
等级: 
可用分等级：长工 
总技术分：14 
总技术分排名：207949 

 发表于：2008-12-01 23:44:528楼 得分:0 
  Java陷阱一箩筐----面试题集及解答 
第一，谈谈final, finally, finalize的区别。 
final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载。 
　　finally—再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
　　finalize—方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
　　匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 
第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
　　Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
　　注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 
第四，&和&&的区别。 
　　&是位运算符。&&是布尔逻辑运算符。 
第五，HashMap和Hashtable的区别。 
　　都属于Map接口的类，实现了将惟一键映射到特定的值上。 
　　HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
　　Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 
第六，Collection 和 Collections的区别。 
　　Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
　　Collection是个java.util下的接口，它是各种集合结构的父接口。 

第七，什么时候用assert。 
　　断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 Assertionerror。它用于调试目的： 
assert(a > 0); // throws an Assertionerror if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
　　Expression1 应该总是产生一个布尔值。 
　　Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
　　断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
　　javac -source 1.4 Test.java 
　　要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
　　要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
　　要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
　　可以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状态。 
第八，GC是什么? 为什么要有GC? (基础)。 
　　GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 
第九，String s = new String("xyz");创建了几个String Object? 
　　两个对象，一个是“xyx”,一个是指向“xyx”的引用对象s。 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
　　Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 
第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
　　short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 
第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
　　sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)“醒来”的线程具有更高的优先级 (b)正在运行的线程因为其它原因而阻塞。 
　　wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 
第十三，Java有没有goto? 
　　Goto—java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
　　数组没有length()这个方法，有length的属性。 
　　String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
　　方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被“屏蔽”了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 
第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
　　Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
　　equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 
第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFORMatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 
第十八，error和exception有什么区别? 
　　error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
　　exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 
第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 
Map不是 
第二十，abstract class和interface有什么区别? 
　　声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
　　接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 
二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
　　都不能 
第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
　　接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 
第二十三，启动一个线程是用run()还是start()? 
　　启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 
第二十四，构造器Constructor是否可被override? 
　　构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 
第二十五，是否可以继承String类? 
　　String类是final类故不可以继承。 
第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
　　不能，一个对象的一个synchronized方法只能由一个线程访问。 
第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
　　会执行，在return前执行。 
第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
　　有C背景的程序员特别喜欢问这种问题。 
　　2 < < 3 
第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
　　不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
　　是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
　　switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 
　　Singleton模式主要作用是保证在Java应用程序中，一个类Class只有一个实例存在。 
　　一般Singleton模式通常有几种种形式： 
　　第一种形式：定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton(); 
　　//这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　public static Singleton getInstance() { 
　　　　return instance; 　　 
　　 } 
} 
　　第二种形式： 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式： 
　　定义一个类，它的构造函数为private的，所有方法为static的。 
　　一般认为第一种形式要更加安全些 
　　Hashtable和HashMap 
　　Hashtable继承自Dictionary类，而HashMap是Java1.2引进的Map interface的一个实现 
　　HashMap允许将null作为一个entry的key或者value，而Hashtable不允许 
　　还有就是，HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解。 
　　最大的不同是，Hashtable的方法是Synchronize的，而HashMap不是，在 
多个线程访问Hashtable时，不需要自己为它的方法实现同步，而HashMap 
就必须为之提供外同步。 
　　Hashtable和HashMap采用的hash/rehash算法都大概一样，所以性能不会有很大的差异。 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 TJYnebula 
tjynebula 
等级: 
可用分等级：富农 
总技术分：127 
总技术分排名：127521 

 发表于：2008-12-01 23:45:039楼 得分:0 
这组题见过无数次了. 
  java面试题及答案 
第一，谈谈final, finally, finalize的区别。 
final?修饰符（关键字）如果一个类被声明为final，意味着它不 能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定 初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载 
finally?再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
finalize? 方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 

第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 

第四，&和&&的区别。 
&是位运算符。&&是布尔逻辑运算符。 

第五，HashMap和Hashtable的区别。 
都属于Map接口的类，实现了将惟一键映射到特定的值上。 
HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 

第六，Collection 和 Collections的区别。 
Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
Collection是个java.util下的接口，它是各种集合结构的父接口。 


第七，什么时候用assert。 
断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 AssertionError。它用于调试目的： 
assert(a > 0); // throws an AssertionError if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
Expression1 应该总是产生一个布尔值。 
Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
javac -source 1.4 Test.java 
要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
可 以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否 启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状 态。 


第八，GC是什么? 为什么要有GC? (基础)。 
GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 

第九，String s = new String("xyz");创建了几个String Object? 
两个对象，一个是"xyx",一个是指向"xyx"的引用对象s。 

第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 

第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)"醒来"的线程具有更高的优先级 
(b)正在运行的线程因为其它原因而阻塞。 
wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 

第十三，Java有没有goto? 
Goto?java中的保留字，现在没有在java中使用。 

第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
数组没有length()这个方法，有length的属性。 
String有有length()这个方法。 

第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方 法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重 载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方 法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 
error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 

Map不是 

第二十，abstract class和interface有什么区别? 
声 明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接 口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有 程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。 然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到 接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不能 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
有C背景的程序员特别喜欢问这种问题。 
2 < < 3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 

第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
  32题答案太长，复制出来估计你也不会看~~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 TJYnebula 
tjynebula 
等级: 
可用分等级：富农 
总技术分：127 
总技术分排名：127521 

 发表于：2008-12-01 23:46:2910楼 得分:0 
晕,有人在我前几秒已经帖出来了，我只能占版面了， 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 wp0140502 
非我莫属 
等级: 
可用分等级：长工 
总技术分：14 
总技术分排名：207949 

 发表于：2008-12-02 00:00:2811楼 得分:0 
失望了哈，，，，呵呵呵。o 
我前了一点点 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 L502650 
E 
等级: 
可用分等级：贫农 
总技术分：255 
总技术分排名：52889 

 发表于：2008-12-02 01:14:2612楼 得分:0 
膜拜..牛人太多了.. 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 myjava_024 
myjava_024 
等级: 
可用分等级：中农 
总技术分：886 
总技术分排名：24257 

 发表于：2008-12-02 08:30:4613楼 得分:0 
这个好像网上有很多版本的答案呢，但是内容都差不多，我也贴个： 
java面试题及答案 
第一，谈谈final, finally, finalize的区别。 
final?修饰符（关键字）如果一个类被声明为final，意味着它不 能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定 初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载 
finally?再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
finalize? 方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 

第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 

第四，&和&&的区别。 
&是位运算符。&&是布尔逻辑运算符。 

第五，HashMap和Hashtable的区别。 
都属于Map接口的类，实现了将惟一键映射到特定的值上。 
HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 

第六，Collection 和 Collections的区别。 
Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
Collection是个java.util下的接口，它是各种集合结构的父接口。 


第七，什么时候用assert。 
断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 AssertionError。它用于调试目的： 
assert(a > 0); // throws an AssertionError if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
Expression1 应该总是产生一个布尔值。 
Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
javac -source 1.4 Test.java 
要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
可 以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否 启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状 态。 


第八，GC是什么? 为什么要有GC? (基础)。 
GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 

第九，String s = new String("xyz");创建了几个String Object? 
两个对象，一个是"xyx",一个是指向"xyx"的引用对象s。 

第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 

第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)"醒来"的线程具有更高的优先级 
(b)正在运行的线程因为其它原因而阻塞。 
wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 

第十三，Java有没有goto? 
Goto?java中的保留字，现在没有在java中使用。 

第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
数组没有length()这个方法，有length的属性。 
String有有length()这个方法。 

第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方 法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重 载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方 法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 
error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 

Map不是 

第二十，abstract class和interface有什么区别? 
声 明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接 口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有 程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。 然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到 接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不能 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
有C背景的程序员特别喜欢问这种问题。 
2 < < 3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 

第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
  32题答案太长，复制出来估计你也不会看~~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 qsrock 
 
等级: 
可用分等级：富农 
总技术分：323 
总技术分排名：45132 

 发表于：2008-12-02 08:33:0214楼 得分:0 
都是从网上来的，占楼 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ZangXT 
http://blog.csdn.net/ZangXT 
等级: 
可用分等级：富农 
总技术分：19613 
总技术分排名：639 
2
 发表于：2008-12-02 09:02:0015楼 得分:0 
上面抄的答案还是有不少问题的，最好自己编代码测试一下再确定。 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 phoenixLotus 
该用户很懒,没有设置昵称 
等级: 
可用分等级：贫农 
总技术分：525 
总技术分排名：34883 

 发表于：2008-12-02 09:09:3516楼 得分:0 
很久了！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ZiSheng 
CSDN 
等级: 
可用分等级：中农 
总技术分：1526 
总技术分排名：14320 

 发表于：2008-12-02 09:10:0717楼 得分:0 
顶一下 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ZiSheng 
CSDN 
等级: 
可用分等级：中农 
总技术分：1526 
总技术分排名：14320 

 发表于：2008-12-02 09:12:4218楼 得分:0 
引用 8 楼 wp0140502 的回复:
第一种形式：定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton(); 
　　//这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　public static Singleton getInstance() { 
　　　　return instance; 　　 
　　 } 
} 
　　第二种形式： 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
 
这两个效率应该一样，第一个怎么会是每次都进行生成对象？？？？？？ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 berlou 
 
等级: 
可用分等级：中农 
总技术分：212 
总技术分排名：59064 

 发表于：2008-12-02 11:06:5319楼 得分:0 
就是， 那样的话还是Singleton么。 


引用 18 楼 ZiSheng 的回复:
引用 8 楼 wp0140502 的回复: 
第一种形式：定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton… 

 发表于：2008-12-02 12:52:2423楼 得分:0 
第一，谈谈final, finally, finalize的区别。 
final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载。 
　　finally—再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
　　finalize—方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
　　匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 
第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
　　Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
　　注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 
第四，&和&&的区别。 
　　&是位运算符。&&是布尔逻辑运算符。 
第五，HashMap和Hashtable的区别。 
　　都属于Map接口的类，实现了将惟一键映射到特定的值上。 
　　HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
　　Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 
第六，Collection 和 Collections的区别。 
　　Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
　　Collection是个java.util下的接口，它是各种集合结构的父接口。 

第七，什么时候用assert。 
　　断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 Assertionerror。它用于调试目的： 
assert(a > 0); // throws an Assertionerror if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
　　Expression1 应该总是产生一个布尔值。 
　　Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
　　断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
　　javac -source 1.4 Test.java 
　　要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
　　要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
　　要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
　　可以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状态。 
第八，GC是什么? 为什么要有GC? (基础)。 
　　GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 
第九，String s = new String("xyz");创建了几个String Object? 
　　两个对象，一个是“xyx”,一个是指向“xyx”的引用对象s。 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
　　Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 
第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
　　short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 
第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
　　sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)“醒来”的线程具有更高的优先级 (b)正在运行的线程因为其它原因而阻塞。 
　　wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 
第十三，Java有没有goto? 
　　Goto—java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
　　数组没有length()这个方法，有length的属性。 
　　String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
　　方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被“屏蔽”了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 
第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
　　Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
　　equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 
第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFORMatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 
第十八，error和exception有什么区别? 
　　error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
　　exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 
第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 
Map不是 
第二十，abstract class和interface有什么区别? 
　　声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
　　接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 
二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
　　都不能 
第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
　　接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 
第二十三，启动一个线程是用run()还是start()? 
　　启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 
第二十四，构造器Constructor是否可被override? 
　　构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 
第二十五，是否可以继承String类? 
　　String类是final类故不可以继承。 
第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
　　不能，一个对象的一个synchronized方法只能由一个线程访问。 
第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
　　会执行，在return前执行。 
第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
　　有C背景的程序员特别喜欢问这种问题。 
　　2 < < 3 
第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
　　不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
　　是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
　　switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 
　　Singleton模式主要作用是保证在Java应用程序中，一个类Class只有一个实例存在。 
　　一般Singleton模式通常有几种种形式： 
　　第一种形式：定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton(); 
　　//这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　public static Singleton getInstance() { 
　　　　return instance; 　　 
　　 } 
} 
　　第二种形式： 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式： 
　　定义一个类，它的构造函数为private的，所有方法为static的。 
　　一般认为第一种形式要更加安全些 
　　Hashtable和HashMap 
　　Hashtable继承自Dictionary类，而HashMap是Java1.2引进的Map interface的一个实现 
　　HashMap允许将null作为一个entry的key或者value，而Hashtable不允许 
　　还有就是，HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解。 
　　最大的不同是，Hashtable的方法是Synchronize的，而HashMap不是，在 
多个线程访问Hashtable时，不需要自己为它的方法实现同步，而HashMap 
就必须为之提供外同步。 
　　Hashtable和HashMap采用的hash/rehash算法都大概一样，所以性能不会有很大的差异。 
 


 发表于：2008-12-01 22:40:41 楼主 
第一，谈谈final, finally, finalize的区别。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 

第四，&和&&的区别。 

第五，HashMap和Hashtable的区别。 

第六，Collection 和 Collections的区别。 

第七，什么时候用assert。 

第八，GC是什么? 为什么要有GC? 

第九，String s = new String("xyz");创建了几个String Object? 

第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 

第十二，sleep() 和 wait() 有什么区别? 

第十三，Java有没有goto? 

第十四，数组有没有length()这个方法? String有没有length()这个方法? 

第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 

第十七，给我一个你最常见到的runtime exception。 

第十八，error和exception有什么区别? 

第十九，List, Set, Map是否继承自Collection接口? 

第二十，abstract class和interface有什么区别? 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 

第二十三，启动一个线程是用run()还是start()? 

第二十四，构造器Constructor是否可被override? 

第二十五，是否可以继承String类? 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 

第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 

第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 

第三十二，编程题: 写一个Singleton出来。 
 
 
 
问题点数：50 回复次数：109 显示所有回复显示星级回复显示楼主回复 修改 删除 举报 引用 回复   
 

 加为好友 
发送私信 
在线聊天
 rosewj 
rosewj 
等级: 
可用分等级：富农 
总技术分：457 
总技术分排名：35467 

 发表于：2008-12-01 22:48:571楼 得分:0 
我来顶的 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 oyto12o 
该用户很懒，没有设置昵称 
等级: 
可用分等级：中农 
总技术分：12 
总技术分排名：212675 

 发表于：2008-12-01 22:54:562楼 得分:0 
先顶下~~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 huacaisolo 
 
等级: 
可用分等级：长工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-01 23:19:023楼 得分:0 
谢谢了，最近需要这些东西！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 kokobox 
koko 
等级: 
可用分等级：富农 
总技术分：23225 
总技术分排名：502 

 发表于：2008-12-01 23:29:554楼 得分:0 
现在面试问这些的一般都少了 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 kerry_lulu 
lulu 
等级: 
可用分等级：中农 
总技术分：568 
总技术分排名：30394 

 发表于：2008-12-01 23:31:385楼 得分:0 
顶一个再顶一个 是不是算两个 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 dzh523 
Fiorentina 
等级: 
可用分等级：贫农 
总技术分：38 
总技术分排名：146056 

 发表于：2008-12-01 23:34:496楼 得分:0 
额滴神呀，一道都不会答！ 

敬候答案！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 xfzhuhan 
coolboy 
等级: 
可用分等级：短工 
总技术分：2 
总技术分排名：325861 

 发表于：2008-12-01 23:43:187楼 得分:0 
1:  final是常量关键字，finally 是异常处理中的一块(tyr,carch,)，finalize是Object 中提供的一个方法， 
    在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收， 
    例如关闭文件等。 
2：  可以。 
3：  静态类的方法直接用方法名就可调用，类部类的方法其他类不可直接调用。 
4：&是位运算符，&&是逻辑运算符。 
5：  HashMap 是HashTable 的轻量级实现，HashMap允许空键值，HashTable不允许， 
6： collection 是集合类的上级接口，继承她的有 List，Map ，collections 是针对集合类提供的方法，包括索引.. 
7:  断言，为了精确反应方法返回值进行的测试。 
8：  GC 垃圾回收机制，java中新提供的方法，有了GC程序员就不用在去费力管理自己声明的对象，.. 
9： 2 
10：12，-11 
11： 有，类型不一致， 
12：sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那 
    个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)“醒来”的线程具有更高的优先级 (b)正在运 
    行的线程因为其它原因而阻塞。  wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用， 
    该线程会  暂停执行，被调对象进入等待状 态，直到被唤醒或等待时间到。 
13：有，保留子，不使用。 
14：数组是属性，String是方法， 
15：一个是重写（对类的操作，子类继承父类，重写父类的方法），一个是重载（对方法，相同的方法名， 
    不同的参数个数，类型，构成重载），Overloaded可改变返回值。 
16： equals(),==是比较是否的同一对象，equals对值比较 
17：  下标越界，空指针。 
18: error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序 
    能处理这样的情况。 
　　exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 
19：List ，Set是 
20:  Static Nested Class是被声明为静态（static）的内部类，它可以不依赖于外部类实例被实例化。 
      而通常的内部类需要在外部类实例化后才能实例化。 

21: 可以。 
22:  都可以。 
23：start(). 
24： 不可以 
25: 不可以 
26： 不可以， 
27： 之前， 
28： 2 < <3 
29:  不可以 
30:  值传递 
31： 可以。 
32： 
public class StringLogn { 
  public StringLogn (){}; 
  private static StringLogn logn=new StringLogn(); 
  public StringLogn getLogn(){ 
    return logn; 
  }        
} 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 wp0140502 
非我莫属 
等级: 
可用分等级：长工 
总技术分：14 
总技术分排名：207949 

 发表于：2008-12-01 23:44:528楼 得分:0 
  Java陷阱一箩筐----面试题集及解答 
第一，谈谈final, finally, finalize的区别。 
final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载。 
　　finally—再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
　　finalize—方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
　　匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 
第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
　　Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
　　注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 
第四，&和&&的区别。 
　　&是位运算符。&&是布尔逻辑运算符。 
第五，HashMap和Hashtable的区别。 
　　都属于Map接口的类，实现了将惟一键映射到特定的值上。 
　　HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
　　Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 
第六，Collection 和 Collections的区别。 
　　Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
　　Collection是个java.util下的接口，它是各种集合结构的父接口。 

第七，什么时候用assert。 
　　断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 Assertionerror。它用于调试目的： 
assert(a > 0); // throws an Assertionerror if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
　　Expression1 应该总是产生一个布尔值。 
　　Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
　　断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
　　javac -source 1.4 Test.java 
　　要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
　　要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
　　要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
　　可以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状态。 
第八，GC是什么? 为什么要有GC? (基础)。 
　　GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 
第九，String s = new String("xyz");创建了几个String Object? 
　　两个对象，一个是“xyx”,一个是指向“xyx”的引用对象s。 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
　　Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 
第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
　　short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 
第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
　　sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)“醒来”的线程具有更高的优先级 (b)正在运行的线程因为其它原因而阻塞。 
　　wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 
第十三，Java有没有goto? 
　　Goto—java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
　　数组没有length()这个方法，有length的属性。 
　　String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
　　方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被“屏蔽”了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 
第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
　　Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
　　equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 
第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFORMatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 
第十八，error和exception有什么区别? 
　　error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
　　exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 
第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 
Map不是 
第二十，abstract class和interface有什么区别? 
　　声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
　　接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 
二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
　　都不能 
第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
　　接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 
第二十三，启动一个线程是用run()还是start()? 
　　启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 
第二十四，构造器Constructor是否可被override? 
　　构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 
第二十五，是否可以继承String类? 
　　String类是final类故不可以继承。 
第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
　　不能，一个对象的一个synchronized方法只能由一个线程访问。 
第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
　　会执行，在return前执行。 
第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
　　有C背景的程序员特别喜欢问这种问题。 
　　2 < < 3 
第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
　　不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
　　是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
　　switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 
　　Singleton模式主要作用是保证在Java应用程序中，一个类Class只有一个实例存在。 
　　一般Singleton模式通常有几种种形式： 
　　第一种形式：定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton(); 
　　//这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　public static Singleton getInstance() { 
　　　　return instance; 　　 
　　 } 
} 
　　第二种形式： 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式： 
　　定义一个类，它的构造函数为private的，所有方法为static的。 
　　一般认为第一种形式要更加安全些 
　　Hashtable和HashMap 
　　Hashtable继承自Dictionary类，而HashMap是Java1.2引进的Map interface的一个实现 
　　HashMap允许将null作为一个entry的key或者value，而Hashtable不允许 
　　还有就是，HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解。 
　　最大的不同是，Hashtable的方法是Synchronize的，而HashMap不是，在 
多个线程访问Hashtable时，不需要自己为它的方法实现同步，而HashMap 
就必须为之提供外同步。 
　　Hashtable和HashMap采用的hash/rehash算法都大概一样，所以性能不会有很大的差异。 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 TJYnebula 
tjynebula 
等级: 
可用分等级：富农 
总技术分：127 
总技术分排名：127521 

 发表于：2008-12-01 23:45:039楼 得分:0 
这组题见过无数次了. 
  java面试题及答案 
第一，谈谈final, finally, finalize的区别。 
final?修饰符（关键字）如果一个类被声明为final，意味着它不 能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定 初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载 
finally?再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
finalize? 方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 

第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 

第四，&和&&的区别。 
&是位运算符。&&是布尔逻辑运算符。 

第五，HashMap和Hashtable的区别。 
都属于Map接口的类，实现了将惟一键映射到特定的值上。 
HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 

第六，Collection 和 Collections的区别。 
Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
Collection是个java.util下的接口，它是各种集合结构的父接口。 


第七，什么时候用assert。 
断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 AssertionError。它用于调试目的： 
assert(a > 0); // throws an AssertionError if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
Expression1 应该总是产生一个布尔值。 
Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
javac -source 1.4 Test.java 
要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
可 以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否 启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状 态。 


第八，GC是什么? 为什么要有GC? (基础)。 
GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 

第九，String s = new String("xyz");创建了几个String Object? 
两个对象，一个是"xyx",一个是指向"xyx"的引用对象s。 

第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 

第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)"醒来"的线程具有更高的优先级 
(b)正在运行的线程因为其它原因而阻塞。 
wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 

第十三，Java有没有goto? 
Goto?java中的保留字，现在没有在java中使用。 

第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
数组没有length()这个方法，有length的属性。 
String有有length()这个方法。 

第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方 法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重 载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方 法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 
error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 

Map不是 

第二十，abstract class和interface有什么区别? 
声 明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接 口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有 程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。 然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到 接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不能 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
有C背景的程序员特别喜欢问这种问题。 
2 < < 3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 

第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
  32题答案太长，复制出来估计你也不会看~~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 TJYnebula 
tjynebula 
等级: 
可用分等级：富农 
总技术分：127 
总技术分排名：127521 

 发表于：2008-12-01 23:46:2910楼 得分:0 
晕,有人在我前几秒已经帖出来了，我只能占版面了， 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 wp0140502 
非我莫属 
等级: 
可用分等级：长工 
总技术分：14 
总技术分排名：207949 

 发表于：2008-12-02 00:00:2811楼 得分:0 
失望了哈，，，，呵呵呵。o 
我前了一点点 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 L502650 
E 
等级: 
可用分等级：贫农 
总技术分：255 
总技术分排名：52889 

 发表于：2008-12-02 01:14:2612楼 得分:0 
膜拜..牛人太多了.. 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 myjava_024 
myjava_024 
等级: 
可用分等级：中农 
总技术分：886 
总技术分排名：24257 

 发表于：2008-12-02 08:30:4613楼 得分:0 
这个好像网上有很多版本的答案呢，但是内容都差不多，我也贴个： 
java面试题及答案 
第一，谈谈final, finally, finalize的区别。 
final?修饰符（关键字）如果一个类被声明为final，意味着它不 能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定 初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载 
finally?再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
finalize? 方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 

第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 

第四，&和&&的区别。 
&是位运算符。&&是布尔逻辑运算符。 

第五，HashMap和Hashtable的区别。 
都属于Map接口的类，实现了将惟一键映射到特定的值上。 
HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 

第六，Collection 和 Collections的区别。 
Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
Collection是个java.util下的接口，它是各种集合结构的父接口。 


第七，什么时候用assert。 
断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 AssertionError。它用于调试目的： 
assert(a > 0); // throws an AssertionError if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
Expression1 应该总是产生一个布尔值。 
Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
javac -source 1.4 Test.java 
要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
可 以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否 启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状 态。 


第八，GC是什么? 为什么要有GC? (基础)。 
GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 

第九，String s = new String("xyz");创建了几个String Object? 
两个对象，一个是"xyx",一个是指向"xyx"的引用对象s。 

第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 

第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)"醒来"的线程具有更高的优先级 
(b)正在运行的线程因为其它原因而阻塞。 
wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 

第十三，Java有没有goto? 
Goto?java中的保留字，现在没有在java中使用。 

第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
数组没有length()这个方法，有length的属性。 
String有有length()这个方法。 

第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方 法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重 载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方 法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 
error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 

Map不是 

第二十，abstract class和interface有什么区别? 
声 明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接 口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有 程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。 然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到 接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不能 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
有C背景的程序员特别喜欢问这种问题。 
2 < < 3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 

第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
  32题答案太长，复制出来估计你也不会看~~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 qsrock 
 
等级: 
可用分等级：富农 
总技术分：323 
总技术分排名：45132 

 发表于：2008-12-02 08:33:0214楼 得分:0 
都是从网上来的，占楼 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ZangXT 
http://blog.csdn.net/ZangXT 
等级: 
可用分等级：富农 
总技术分：19613 
总技术分排名：639 
2
 发表于：2008-12-02 09:02:0015楼 得分:0 
上面抄的答案还是有不少问题的，最好自己编代码测试一下再确定。 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 phoenixLotus 
该用户很懒,没有设置昵称 
等级: 
可用分等级：贫农 
总技术分：525 
总技术分排名：34883 

 发表于：2008-12-02 09:09:3516楼 得分:0 
很久了！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ZiSheng 
CSDN 
等级: 
可用分等级：中农 
总技术分：1526 
总技术分排名：14320 

 发表于：2008-12-02 09:10:0717楼 得分:0 
顶一下 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ZiSheng 
CSDN 
等级: 
可用分等级：中农 
总技术分：1526 
总技术分排名：14320 

 发表于：2008-12-02 09:12:4218楼 得分:0 
引用 8 楼 wp0140502 的回复:
第一种形式：定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton(); 
　　//这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　public static Singleton getInstance() { 
　　　　return instance; 　　 
　　 } 
} 
　　第二种形式： 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
 
这两个效率应该一样，第一个怎么会是每次都进行生成对象？？？？？？ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 berlou 
 
等级: 
可用分等级：中农 
总技术分：212 
总技术分排名：59064 

 发表于：2008-12-02 11:06:5319楼 得分:0 
就是， 那样的话还是Singleton么。 


引用 18 楼 ZiSheng 的回复:
引用 8 楼 wp0140502 的回复: 
第一种形式：定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton… 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 Wing198812 
Wing 
等级: 
可用分等级：贫农 
总技术分：412 
总技术分排名：42429 

 发表于：2008-12-02 12:27:0120楼 得分:0 
关注 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 angelestening 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：10 
总技术分排名：220020 

 发表于：2008-12-02 12:35:1921楼 得分:0 
收藏咯   
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 qindequan 
kakashi 
等级: 
可用分等级：贫农 
总技术分：97 
总技术分排名：102596 

 发表于：2008-12-02 12:42:0922楼 得分:0 
学习！！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 xiaolong19870717 
巨龙 
等级: 
可用分等级：贫农 
总技术分：10 
总技术分排名：220020 

 发表于：2008-12-02 12:52:2423楼 得分:0 
第一，谈谈final, finally, finalize的区别。 
final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载。 
　　finally—再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
　　finalize—方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
　　匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 
第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
　　Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
　　注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 
第四，&和&&的区别。 
　　&是位运算符。&&是布尔逻辑运算符。 
第五，HashMap和Hashtable的区别。 
　　都属于Map接口的类，实现了将惟一键映射到特定的值上。 
　　HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
　　Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 
第六，Collection 和 Collections的区别。 
　　Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
　　Collection是个java.util下的接口，它是各种集合结构的父接口。 

第七，什么时候用assert。 
　　断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 Assertionerror。它用于调试目的： 
assert(a > 0); // throws an Assertionerror if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
　　Expression1 应该总是产生一个布尔值。 
　　Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
　　断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
　　javac -source 1.4 Test.java 
　　要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
　　要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
　　要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
　　可以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状态。 
第八，GC是什么? 为什么要有GC? (基础)。 
　　GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 
第九，String s = new String("xyz");创建了几个String Object? 
　　两个对象，一个是“xyx”,一个是指向“xyx”的引用对象s。 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
　　Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 
第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
　　short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 
第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
　　sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)“醒来”的线程具有更高的优先级 (b)正在运行的线程因为其它原因而阻塞。 
　　wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 
第十三，Java有没有goto? 
　　Goto—java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
　　数组没有length()这个方法，有length的属性。 
　　String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
　　方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被“屏蔽”了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 
第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
　　Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
　　equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 
第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFORMatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 
第十八，error和exception有什么区别? 
　　error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
　　exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 
第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 
Map不是 
第二十，abstract class和interface有什么区别? 
　　声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
　　接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 
二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
　　都不能 
第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
　　接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 
第二十三，启动一个线程是用run()还是start()? 
　　启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 
第二十四，构造器Constructor是否可被override? 
　　构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 
第二十五，是否可以继承String类? 
　　String类是final类故不可以继承。 
第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
　　不能，一个对象的一个synchronized方法只能由一个线程访问。 
第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
　　会执行，在return前执行。 
第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
　　有C背景的程序员特别喜欢问这种问题。 
　　2 < < 3 
第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
　　不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
　　是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
　　switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 
　　Singleton模式主要作用是保证在Java应用程序中，一个类Class只有一个实例存在。 
　　一般Singleton模式通常有几种种形式： 
　　第一种形式：定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton(); 
　　//这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　public static Singleton getInstance() { 
　　　　return instance; 　　 
　　 } 
} 
　　第二种形式： 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式： 
　　定义一个类，它的构造函数为private的，所有方法为static的。 
　　一般认为第一种形式要更加安全些 
　　Hashtable和HashMap 
　　Hashtable继承自Dictionary类，而HashMap是Java1.2引进的Map interface的一个实现 
　　HashMap允许将null作为一个entry的key或者value，而Hashtable不允许 
　　还有就是，HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解。 
　　最大的不同是，Hashtable的方法是Synchronize的，而HashMap不是，在 
多个线程访问Hashtable时，不需要自己为它的方法实现同步，而HashMap 
就必须为之提供外同步。 
　　Hashtable和HashMap采用的hash/rehash算法都大概一样，所以性能不会有很大的差异。 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ZangXT 
http://blog.csdn.net/ZangXT 
等级: 
可用分等级：富农 
总技术分：19613 
总技术分排名：639 
2
 发表于：2008-12-02 12:54:1624楼 得分:0 
ｍａｒｋ，找时间总结一下． 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 guogaocheng 
GgcHeňg﹎Ж 
等级: 
可用分等级：长工 
总技术分：52 
总技术分排名：146056 

 发表于：2008-12-02 13:04:1125楼 得分:0 
不错 。。。 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 natee 
nate 
等级: 
可用分等级：中农 
总技术分：315 
总技术分排名：46015 

 发表于：2008-12-02 13:06:2226楼 得分:0 
路过~ 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 lshy168 
永不放弃 
等级: 
可用分等级：贫农 
总技术分：95 
总技术分排名：117623 

 发表于：2008-12-02 13:17:3327楼 得分:0 
第十三，Java有没有goto? 
答：没有 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 wang511123 
功夫熊猫的老爸是鸭子！ 
等级: 
可用分等级：中农 
总技术分：198 
总技术分排名：61760 

 发表于：2008-12-02 14:22:0228楼 得分:0 
引用 27 楼 lshy168 的回复:
第十三，Java有没有goto? 
答：没有 
 

不对，java有goto，只是你没用而已，JDK在用 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 jjy1983 
玩奶IN北京：影响有影响力的人，受有影响力的人的影响！ 
等级: 
可用分等级：中农 
总技术分：40 
总技术分排名：149363 

 发表于：2008-12-02 14:25:1129楼 得分:0 
顶！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 zhuyang7654321 
无知∽无畏 
等级: 
可用分等级：贫农 
总技术分：2 
总技术分排名：291913 

 发表于：2008-12-02 15:18:5230楼 得分:0 
学习 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 fifaqzx 
热音群 
等级: 
可用分等级：中农 
总技术分：62 
总技术分排名：116878 

 发表于：2008-12-02 15:26:3431楼 得分:0 
几年前的过时问题 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 kao331431214 
小明哥 o(∩_∩)o... 
等级: 
可用分等级：贫农 
总技术分：132 
总技术分排名：83734 

 发表于：2008-12-02 16:32:1932楼 得分:0 
又看到了 
嗯嗯~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 lwlivy 
 
等级: 
可用分等级：中农 
总技术分：200 
总技术分排名：61147 

 发表于：2008-12-02 16:39:5933楼 得分:0 
哇,发现晚了 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 talangzhang 
 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-02 16:44:4434楼 得分:0 
面试的时候就是这题 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 yh850472175 
口十叶三告浩 
等级: 
可用分等级：中农 
总技术分：65 
总技术分排名：116202 

 发表于：2008-12-02 17:12:1235楼 得分:0 
UP 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 javacf 
 
等级: 
可用分等级：长工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-02 17:20:3836楼 得分:0 
开眼了，不错！O(∩_∩)O哈哈~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 yangyirui 
regal 
等级: 
可用分等级：短工 
总技术分：10 
总技术分排名：325861 

 发表于：2008-12-02 17:21:5737楼 得分:0 
顶一个， 
呵呵 大部分都不会 

受教了！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 hhff519 
该用户很懒,没有设置昵称 
等级: 
可用分等级：乞丐 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-02 17:25:0738楼 得分:0 
顶一下有分不？ 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 cxalxpks 
该用户很懒,没有设置昵称 
等级: 
可用分等级：长工 
总技术分：23 
总技术分排名：283293 

 发表于：2008-12-02 17:27:3139楼 得分:0 
学习下。 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 cjmiou 
Love 
等级: 
可用分等级：富农 
总技术分：2595 
总技术分排名：8411 

 发表于：2008-12-02 17:43:0740楼 得分:0 
引用 23 楼 xiaolong19870717 的回复:
第一，谈谈final, finally, finalize的区别。 
final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载。 
finally—再异常处理时… 
 

顶,楼上正解 

这些其实都是网上有的,楼主一查就知道了 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 junying2yu 
学习中…… 
等级: 
可用分等级：贫农 
总技术分：133 
总技术分排名：85273 

 发表于：2008-12-02 17:46:0541楼 得分:0 
顶一个,学习着呢 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 mengyunshuitian 
天下论坛 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-02 17:52:5142楼 得分:0 
呵呵    高手如云啊   
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 kao126 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：3000000 

 发表于：2008-12-02 17:55:2343楼 得分:0 
sdtgfuhfghgfh 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 langtul 
 
等级: 
可用分等级：长工 
总技术分：7 
总技术分排名：246566 

 发表于：2008-12-02 18:18:3644楼 得分:0 
那么多高手，顶下啊。。。 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 jiangpinhe 
roy 
等级: 
可用分等级：富农 
总技术分：145 
总技术分排名：74180 

 发表于：2008-12-02 19:06:1645楼 得分:0 
妈的今天去ibm面试，里面的好几道题我都是见过，可都是了解的不全面结果答得很不好，这么好的机会就错过了，啊~~~~~~~~~~~~我要疯了 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 zboaif 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：1 
总技术分排名：307504 

 发表于：2008-12-02 19:10:0446楼 得分:0 
这个好像网上有很多版本的答案呢，但是内容都差不多，我也贴个： 
java面试题及答案 
第一，谈谈final, finally, finalize的区别。 
final?修饰符（关键字）如果一个类被声明为final，意味着它不 能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定 初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载 
finally?再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
finalize? 方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 

第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 

第四，&和&&的区别。 
&是位运算符。&&是布尔逻辑运算符。 

第五，HashMap和Hashtable的区别。 
都属于Map接口的类，实现了将惟一键映射到特定的值上。 
HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 

第六，Collection 和 Collections的区别。 
Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
Collection是个java.util下的接口，它是各种集合结构的父接口。 


第七，什么时候用assert。 
断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 AssertionError。它用于调试目的： 
assert(a > 0); // throws an AssertionError if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
Expression1 应该总是产生一个布尔值。 
Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
javac -source 1.4 Test.java 
要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
可 以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否 启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状 态。 


第八，GC是什么? 为什么要有GC? (基础)。 
GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 

第九，String s = new String("xyz");创建了几个String Object? 
两个对象，一个是"xyx",一个是指向"xyx"的引用对象s。 

第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 

第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)"醒来"的线程具有更高的优先级 
(b)正在运行的线程因为其它原因而阻塞。 
wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 

第十三，Java有没有goto? 
Goto?java中的保留字，现在没有在java中使用。 

第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
数组没有length()这个方法，有length的属性。 
String有有length()这个方法。 

第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方 法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重 载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方 法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 
error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 

Map不是 

第二十，abstract class和interface有什么区别? 
声 明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接 口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有 程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。 然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到 接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不能 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
有C背景的程序员特别喜欢问这种问题。 
2 < < 3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 

第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
  32题答案太长，复制出来估计你也不会看~~ 


 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 bigbro001 
该用户很懒,没有设置昵称 
等级: 
可用分等级：长工 
总技术分：153 
总技术分排名：72180 

 发表于：2008-12-02 19:32:3647楼 得分:0 
记号一个～ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ywbchengyi 
该用户很懒,没有设置昵称 
等级: 
可用分等级：中农 
总技术分：32 
总技术分排名：154351 

 发表于：2008-12-02 19:33:1548楼 得分:0 
第一，谈谈final, finally, finalize的区别。 
      1.final 用于声明属性、方法、类。表示属性不可变，方法不可覆盖，类不可继承 
  finally是异常处理语句（try catch finally)结构的一部分，总是执行 
  finalize 是object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 

2.可以。匿名内部类是没有名字的内部类，可以继承，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
3.static Nested class是声明位静态的内部类，它可以不依赖外部类实例被实例化，而通常的Inner Class内部类需要外部类实例化后才能实例化。 

第四，&和&&的区别。 

4。&是位运算符，表示按位与运算。&&是逻辑运算符，表示逻辑与。 
第五，HashMap和Hashtable的区别。 
HashMap是Hashtable的轻量级实现，他们都完成了Map接口， 
主要区别： 
HashMap允许空键值,线程安全，效率可能高于HashTable. 
hashtable方法是synchronize而hashmap不是。 

第六，Collection 和 Collections的区别。 
Collection 是集合类的上级接口，继承与他的接口由Set和List 
Collections是针对集合类的一个帮助类。 
第七，什么时候用assert。 
这是一种调试方式，通常在开发和测试的时候用到，软件发布之后，通常关闭掉它。 
第八，GC是什么? 为什么要有GC? 

Gc是垃圾收集的一是。因为内存的处理是编程人员容易出现错误的地方，忘记或错误的内存回收会导致程序或系统的不稳定甚至崩溃. 
第九，String s = new String("xyz");创建了几个String Object? 

创建了2个 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 

12，11 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 

第一个错误s1+1 是int型，需要强制转换， 
第二个对。 
第十二，sleep() 和 wait() 有什么区别? 

sleep是线程类（Thread）的方法，导致此线程暂停执行指定时间，给执行机会给其他线程，但是监控状态依然保持，到时后会自动恢复。调用sleep不会释放对象锁。 
wait是Object类的方法，对此对象调用wait方法导致本线程放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象发出notify方法（或notifyAll）后本线程才进入对象锁定池准备获得对象锁进入运行状态。 

第十三，Java有没有goto? 

java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法? 

数组没有length()这个方法，有length的属性。String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 

Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 

error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 

List，Set是，Map不是 
第二十，abstract class和interface有什么区别? 

声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不行。 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
start(); 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
　String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
2 < <3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 

是值传递。Java 编程语言只有值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 

switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 

第一种形式: 定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
private Singleton(){} 
　　 //在自己内部定义自己一个实例，是不是很奇怪？ 
　　 //注意这是private 只供内部调用 
　　 private static Singleton instance = new Singleton(); 
　　 //这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　 public static Singleton getInstance() { 
　　　　 return instance; 　　 
　　 } 
} 
第二种形式: 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式: 
定义一个类，它的构造函数为private的，所有方法为static的。 
一般认为第一种形式要更加安全些 


 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 l527391549 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：4 
总技术分排名：3000000 

 发表于：2008-12-02 20:10:0249楼 得分:0 
第十三，Java有没有goto? 
有 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 fzu030501305 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：3000000 

 发表于：2008-12-02 20:44:4450楼 得分:0 
呵呵，这种面试题多的去了~~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 silent_day 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：3000000 

 发表于：2008-12-02 20:58:3851楼 得分:0 
顶啊~~~~ 牛人很多，我现在正在找工作........  看了这些，很有帮助，谢谢！！！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 kahn178 
我为诗狂 
等级: 
可用分等级：中农 
总技术分：78 
总技术分排名：105653 

 发表于：2008-12-02 21:14:4652楼 得分:0 
第一，谈谈final, finally, finalize的区别。 
final---修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载 
finally---在异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
finalize---方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 
第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
注：静态内部类（Inner Class）意味着 
1创建一个static内部类的对象，不需要一个外部类对象 
2不能从一个static内部类的一个对象访问一个外部类对象 
第四，&和&&的区别。 
&是位运算符。&&是布尔逻辑运算符。 
第五，HashMap和Hashtable的区别。 
都属于Map接口的类，实现了将惟一键映射到特定的值上。 
HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 
第六，Collection 和 Collections的区别。 
Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
Collection是个java.util下的接口，它是各种集合结构的父接口。 
抽象类能被继承，不能被实现；接口能被继承，也能被实现。 
第七，什么时候用assert。 
断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 AssertionError。它用于调试目的： 
assert(a > 0); // throws an AssertionError if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
Expression1 应该总是产生一个布尔值。 
Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
javac -source 1.4 Test.java 
要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
可以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状态。 

第八，GC是什么? 为什么要有GC? (基础)。 
GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 
第九，String s = new String("xyz");创建了几个String Object? 
两个对象，一个是“xyx”,一个是指向“xyx”的引用对象s。 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 
第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 
第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)“醒来”的线程具有更高的优先级 
(b)正在运行的线程因为其它原因而阻塞。 
wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 

第十三，Java有没有goto? 
Goto?java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
数组没有length()这个方法，有length的属性。 
String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被“屏蔽”了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 
第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 
第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 
第十八，error和exception有什么区别? 
error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 
Map不是 
第二十，abstract class和interface有什么区别? 
声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 
第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不能 
第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 
第二十三，启动一个线程是用run()还是start()? 
启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 
第二十五，是否可以继承String类? 
String类是final类故不可以继承。 
第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 
第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
有C背景的程序员特别喜欢问这种问题。 
2 < < 3 
第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 

第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 
Singleton模式主要作用是保证在Java应用程序中，一个类Class只有一个实例存在。 
一般Singleton模式通常有几种种形式: 
第一种形式: 定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton(); 
　　//这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　public static Singleton getInstance() { 
　　　　return instance; 　　 
　　 } 
} 
第二种形式: 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式: 
定义一个类，它的构造函数为private的，所有方法为static的。 
一般认为第一种形式要更加安全些 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 abcniu 
 
等级: 
可用分等级：长工 
总技术分：273 
总技术分排名：50443 

 发表于：2008-12-02 21:26:5753楼 得分:0 
都那么牛 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 GoodNetChenRan 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：3000000 

 发表于：2008-12-02 21:33:3954楼 得分:0 
对我因该有一定的好处啊 ，谢谢了 
9楼回答的很到位啊  同样谢谢了 呵呵  
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 rian4570 
该用户很懒,没有设置昵称 
等级: 
可用分等级：奴隶 
总技术分：0 
总技术分排名：3000000 

 发表于：2008-12-02 21:45:4155楼 得分:0 
可能在几天之后，有一场JAVA面试，我顶！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 a13323778446 
程序员之家 
等级: 
可用分等级：长工 
总技术分：22 
总技术分排名：176133 

 发表于：2008-12-02 21:47:3056楼 得分:0 
第四，&和&&的区别。 
&即可做位运算符，也可做逻辑运算符。&&表逻辑运算。 
&在做逻辑运算符是和&&在结果上没有区别，只是&&会发生短路，而&则不会。 
本人观点！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 a13323778446 
程序员之家 
等级: 
可用分等级：长工 
总技术分：22 
总技术分排名：176133 

 发表于：2008-12-02 21:47:4757楼 得分:0 
第四，&和&&的区别。 
&即可做位运算符，也可做逻辑运算符。&&表逻辑运算。 
&在做逻辑运算符是和&&在结果上没有区别，只是&&会发生短路，而&则不会。 
本人观点！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 dongtian15 
雪 
等级: 
可用分等级：贫农 
总技术分：4 
总技术分排名：276826 

 发表于：2008-12-02 22:10:4858楼 得分:0 
我也是来顶~~~~~~~~~~~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 nzz1985 
 
等级: 
可用分等级：长工 
总技术分：2 
总技术分排名：291913 

 发表于：2008-12-02 22:28:2959楼 得分:0 
顶下 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ZangXT 
http://blog.csdn.net/ZangXT 
等级: 
可用分等级：富农 
总技术分：19613 
总技术分排名：639 
2
 发表于：2008-12-02 22:37:3960楼 得分:0 
不要抄来抄去了，把错误改掉再发． 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 richard_2010 
等待第七天/CSDNNO007 
等级: 
可用分等级：中农 
总技术分：2517 
总技术分排名：8688 

 发表于：2008-12-02 22:44:4861楼 得分:0 
引用 60 楼 ZangXT 的回复:
不要抄来抄去了，把错误改掉再发． 
 

太老了，这也能推荐？ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 panny1982 
 
等级: 
可用分等级：长工 
总技术分：5 
总技术分排名：256231 

 发表于：2008-12-02 22:45:3462楼 得分:0 
ding hao dongxi 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ZangXT 
http://blog.csdn.net/ZangXT 
等级: 
可用分等级：富农 
总技术分：19613 
总技术分排名：639 
2
 发表于：2008-12-02 22:46:0663楼 得分:0 
引用 61 楼 richard_2010 的回复:
引用 60 楼 ZangXT 的回复: 
不要抄来抄去了，把错误改掉再发． 


太老了，这也能推荐？ 
 
最近推荐的帖子好像越来越差了． 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 to_cm 
学走路的小鹰 
等级: 
可用分等级：中农 
总技术分：9 
总技术分排名：240269 

 发表于：2008-12-02 22:52:5664楼 得分:0 
在GOOGLE上走一趟，答案全都有~~~ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 he1988 
该用户很懒,没有设置昵称 
等级: 
可用分等级：长工 
总技术分：2 
总技术分排名：291913 

 发表于：2008-12-02 23:07:2265楼 得分:0 
在帮我巩固java基本知识了,mark! 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 Kingofcode 
该用户很懒,没有设置昵称 
等级: 
可用分等级：贫农 
总技术分：6 
总技术分排名：251002 

 发表于：2008-12-02 23:10:3566楼 得分:0 
现在搞java的都很牛 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 DenielJean 
无天 
等级: 
可用分等级：中农 
总技术分：88 
总技术分排名：109219 

 发表于：2008-12-02 23:20:0267楼 得分:0 
mark 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 derelictangel 
该用户很懒,没有设置昵称 
等级: 
可用分等级：长工 
总技术分：30 
总技术分排名：162482 

 发表于：2008-12-03 08:50:2468楼 得分:0 
MARK 


PS: 
我的目标是 ---->  

^_^ 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 zhangchaokun 
lywin 
等级: 
可用分等级：掌柜 
总技术分：2850 
总技术分排名：7575 

 发表于：2008-12-03 08:52:0669楼 得分:0 
还是有不少高人啊,我是来学习的 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 fengsky491 
fengsky491 
等级: 
可用分等级：富农 
总技术分：261 
总技术分排名：58898 

 发表于：2008-12-03 09:00:0470楼 得分:0 
引用 24 楼 ZangXT 的回复:
ｍａｒｋ，找时间总结一下． 
 
等着你总结，嘿嘿 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 bldwinln 
 
等级: 
可用分等级：长工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-03 09:02:1471楼 得分:0 
还是有不少高人啊,我是来学习的 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 pofich 
 
等级: 
可用分等级：贫农 
总技术分：25 
总技术分排名：168292 

 发表于：2008-12-03 09:15:1272楼 得分:0 
取其精华，去其糟粕 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 pofich 
 
等级: 
可用分等级：贫农 
总技术分：25 
总技术分排名：168292 

 发表于：2008-12-03 09:15:2473楼 得分:0 
取其精华，去其糟粕 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 snowflychen 
与其去看远处飘渺的东西    不如去做眼前清楚的事情 
等级: 
可用分等级：贫农 
总技术分：72 
总技术分排名：109219 

 发表于：2008-12-03 09:16:4274楼 得分:0 
感谢分享！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ph215405357 
sss 
等级: 
可用分等级：富农 
总技术分：233 
总技术分排名：55651 

 发表于：2008-12-03 09:24:3975楼 得分:0 
jf 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 ph215405357 
sss 
等级: 
可用分等级：富农 
总技术分：233 
总技术分排名：55651 

 发表于：2008-12-03 09:24:5976楼 得分:0 
jf 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 qqqqqwwqqq 
低头做事 抬头做人 
等级: 
可用分等级：贫农 
总技术分：220 
总技术分排名：86421 

 发表于：2008-12-03 09:28:1477楼 得分:0 
网上百度一下这些答案都能出来  而且是在一个页面里 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 sunrise2199 
牛牛 
等级: 
可用分等级：中农 
总技术分：140 
总技术分排名：76137 

 发表于：2008-12-03 09:37:1378楼 得分:0 
学习一下 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 lintf1986 
东风西醉 
等级: 
可用分等级：贫农 
总技术分：22 
总技术分排名：325861 

 发表于：2008-12-03 09:41:0579楼 得分:0 
UP 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 lintf1986 
东风西醉 
等级: 
可用分等级：贫农 
总技术分：22 
总技术分排名：325861 

 发表于：2008-12-03 09:41:2680楼 得分:0 
UP 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 w3349516 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-03 09:48:3481楼 得分:0 
国家有希望啦 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 yangerick 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：1 
总技术分排名：325861 

 发表于：2008-12-03 10:03:1382楼 得分:0 
学java得人应该都见过这几道题吧，顶一下 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 iloveayumi1 
该用户很懒,没有设置昵称 
等级: 
可用分等级：奴隶 
总技术分：0 
总技术分排名：3000000 

 发表于：2008-12-03 10:23:0683楼 得分:0 
回复下,,能增加积分吗?我要下载资源哦 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 liu_zhaoqf 
阿牛 
等级: 
可用分等级：富农 
总技术分：514 
总技术分排名：32638 

 发表于：2008-12-03 10:28:3484楼 得分:0 
mark 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 zerozxk44118154 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-03 10:48:4785楼 得分:0 
有答案不 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 jon_wd 
靓鼠 
等级: 
可用分等级：中农 
总技术分：451 
总技术分排名：35819 

 发表于：2008-12-03 10:55:5886楼 得分:0 
学习 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 yegushui 
yegushui 
等级: 
可用分等级：中农 
总技术分：37 
总技术分排名：149363 

 发表于：2008-12-03 11:00:1687楼 得分:0 
mark 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 panner 
坏坏的眼镜 
等级: 
可用分等级：贫农 
总技术分：12 
总技术分排名：212675 

 发表于：2008-12-03 11:09:5388楼 得分:0 
盖章 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 dashi99 
ゞ沉默是金ゞ 
等级: 
可用分等级：中农 
总技术分：109 
总技术分排名：87959 

 发表于：2008-12-03 11:29:3289楼 得分:0 
基础性的题目 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 talayayaya 
talaya 
等级: 
可用分等级：乞丐 
总技术分：203 
总技术分排名：61943 

 发表于：2008-12-03 12:27:1990楼 得分:0 
1.39 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 heeten 
CrazyCoder 
等级: 
可用分等级：短工 
总技术分：32 
总技术分排名：325861 

 发表于：2008-12-03 12:42:5791楼 得分:0 
此帖为  hr杀手贴 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 Mr_Von 
 
等级: 
可用分等级：富农 
总技术分：2727 
总技术分排名：8120 

 发表于：2008-12-03 12:49:1792楼 得分:0 
这些题的答案在网上都有的啊  LZ去搜一下     
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 sikezx 
 
等级: 
可用分等级：中农 
总技术分：148 
总技术分排名：115580 

 发表于：2008-12-03 13:22:4793楼 得分:0 
第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。  
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 huangxingchina 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-03 13:43:3194楼 得分:0 
第十四，数组有没有length()这个方法? String有没有length()这个方法? 

很经典的题目 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 henry84 
henry 
等级: 
可用分等级：中农 
总技术分：30 
总技术分排名：157312 

 发表于：2008-12-03 14:32:0395楼 得分:0 
这个题目网上很多的 答案也都有的 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 zhuyc 
被奥运包围了 
等级: 
可用分等级：中农 
总技术分：69 
总技术分排名：111976 

 发表于：2008-12-03 15:50:3396楼 得分:0 
好像在哪发现过 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 meiguanggan 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：3000000 

 发表于：2008-12-03 16:09:4797楼 得分:0 
想回答赚分, 但不会 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 cqbogu 
CSDN开发队 
等级: 
可用分等级：短工 
总技术分：5 
总技术分排名：325861 

 发表于：2008-12-03 16:10:4998楼 得分:0 
,哎，知道天外有天，人外有人了啊。 
学过一点皮毛，却全然看不懂 
第十八，error和exception有什么区别? 
一个是异常，一个是错误，从中文上理解都不一样。 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 lxmtx___2008 
该用户很懒,没有设置昵称 
等级: 
可用分等级：贫农 
总技术分：63 
总技术分排名：128464 

 发表于：2008-12-03 16:41:2999楼 得分:0 
学习 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 eliteguan 
该用户很懒,没有设置昵称 
等级: 
可用分等级：短工 
总技术分：0 
总技术分排名：325861 

 发表于：2008-12-03 16:42:06100楼 得分:0 
这算是什么问题啊……………… 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 aimyang 
M 
等级: 
可用分等级：掌柜 
总技术分：102 
总技术分排名：90857 

 发表于：2008-12-03 16:46:05101楼 得分:0 
第一，谈谈final, finally, finalize的区别。 
      1.final 用于声明属性、方法、类。表示属性不可变，方法不可覆盖，类不可继承 
  finally是异常处理语句（try catch finally)结构的一部分，总是执行 
  finalize 是object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 

2.可以。匿名内部类是没有名字的内部类，可以继承，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
3.static Nested class是声明位静态的内部类，它可以不依赖外部类实例被实例化，而通常的Inner Class内部类需要外部类实例化后才能实例化。 

第四，&和&&的区别。 

4。&是位运算符，表示按位与运算。&&是逻辑运算符，表示逻辑与。 
第五，HashMap和Hashtable的区别。 
HashMap是Hashtable的轻量级实现，他们都完成了Map接口， 
主要区别： 
HashMap允许空键值,线程安全，效率可能高于HashTable. 
hashtable方法是synchronize而hashmap不是。 

第六，Collection 和 Collections的区别。 
Collection 是集合类的上级接口，继承与他的接口由Set和List 
Collections是针对集合类的一个帮助类。 
第七，什么时候用assert。 
这是一种调试方式，通常在开发和测试的时候用到，软件发布之后，通常关闭掉它。 
第八，GC是什么? 为什么要有GC? 

Gc是垃圾收集的一是。因为内存的处理是编程人员容易出现错误的地方，忘记或错误的内存回收会导致程序或系统的不稳定甚至崩溃. 
第九，String s = new String("xyz");创建了几个String Object? 

创建了2个 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 

12，11 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 

第一个错误s1+1 是int型，需要强制转换， 
第二个对。 
第十二，sleep() 和 wait() 有什么区别? 

sleep是线程类（Thread）的方法，导致此线程暂停执行指定时间，给执行机会给其他线程，但是监控状态依然保持，到时后会自动恢复。调用sleep不会释放对象锁。 
wait是Object类的方法，对此对象调用wait方法导致本线程放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象发出notify方法（或notifyAll）后本线程才进入对象锁定池准备获得对象锁进入运行状态。 

第十三，Java有没有goto? 

java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法? 

数组没有length()这个方法，有length的属性。String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 

Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 

error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 

List，Set是，Map不是 
第二十，abstract class和interface有什么区别? 

声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不行。 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
start(); 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
　String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
2 < <3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 

是值传递。Java 编程语言只有值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 

switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 

第一种形式: 定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
private Singleton(){} 
　　 //在自己内部定义自己一个实例，是不是很奇怪？ 
　　 //注意这是private 只供内部调用 
　　 private static Singleton instance = new Singleton(); 
　　 //这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　 public static Singleton getInstance() { 
　　　　 return instance; 　　 
　　 } 
} 
第二种形式: 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式: 
定义一个类，它的构造函数为private的，所有方法为static的。 
一般认为第一种形式要更加安全些 
 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 xhh_1986178185 
随风飘逝 
等级: 
可用分等级：长工 
总技术分：4 
总技术分排名：276826 

 发表于：2008-12-03 16:48:39102楼 得分:0 
第十三 JAVA有goto 但未使用 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 weizhao_2008 
该用户很懒,没有设置昵称 
等级: 
可用分等级：贫农 
总技术分：56 
总技术分排名：139361 

 发表于：2008-12-03 16:49:03103楼 得分:0 
学习下 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 binary_system 
小班 
等级: 
可用分等级：乞丐 
总技术分：0 
总技术分排名：3000000 

 发表于：2008-12-03 16:50:04104楼 得分:0 
珍贵的资料  收藏了 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 jaylongli 
该人还算上进 
等级: 
可用分等级：中农 
总技术分：622 
总技术分排名：28638 

 发表于：2008-12-03 17:31:43105楼 得分:0 
引用 9 楼 TJYnebula 的回复:
这组题见过无数次了. 
  java面试题及答案 
第一，谈谈final, finally, finalize的区别。 
final?修饰符（关键字）如果一个类被声明为final，意味着它不 能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定 初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同… 
 

呵呵，找工作的时候可是不错的参考哦 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 learnonedelisonedel 
learnonedelisonedel 
等级: 
可用分等级：贫农 
总技术分：1 
总技术分排名：307504 

 发表于：2008-12-03 17:54:47106楼 得分:0 
mark 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 dengjinjin 
该用户很懒,没有设置昵称 
等级: 
可用分等级：奴隶 
总技术分：0 
总技术分排名：3000000 

 发表于：2008-12-03 17:56:23107楼 得分:0 
很一般的问题嘛！ 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 garylijia 
该用户很懒,没有设置昵称 
等级: 
可用分等级：贫农 
总技术分：58 
总技术分排名：121066 

 发表于：2008-12-03 19:28:05108楼 得分:0 
谢谢分享 
 
修改 删除 举报 引用 回复   
 
 加为好友 
发送私信 
在线聊天
 learnonedelisonedel 
learnonedelisonedel 
等级: 
可用分等级：贫农 
总技术分：1 
总技术分排名：307504 

 发表于：2008-12-03 19:33:14109楼 得分:0 
mark 
 
 
修改 删除 举报 引用 回复   
 

将帖子提前   放进我的网摘   推荐给好友 我要提问 帖子加分 结帖去... 管理菜单 页面风格切换标准风格老版本论坛  


--------------------------------------------------------------------------------
网站简介－广告服务－网站地图－帮助－联系方式－诚聘英才－English－ 问题报告
北京创新乐知广告有限公司 版权所有 京 ICP 证 070598 号
世纪乐知(北京)网络技术有限公司 提供技术支持
Copyright © 2000-2008, CSDN.NET, All Rights Reserved
--------------------------------------------------------------------------------

  
      
 abc推荐给好友 
 

         
         
         
  


 发表于：2008-12-02 17:43:0740楼 得分:0 
引用 23 楼 xiaolong19870717 的回复:
第一，谈谈final, finally, finalize的区别。 
final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载。 
finally—再异常处理时… 
 

 发表于：2008-12-02 19:06:1645楼 得分:0 
妈的今天去ibm面试，里面的好几道题我都是见过，可都是了解的不全面结果答得很不好，这么好的机会就错过了，啊~~~~~~~~~~~~我要疯了 

 发表于：2008-12-02 19:10:0446楼 得分:0 
这个好像网上有很多版本的答案呢，但是内容都差不多，我也贴个： 
java面试题及答案 
第一，谈谈final, finally, finalize的区别。 
final?修饰符（关键字）如果一个类被声明为final，意味着它不 能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定 初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载 
finally?再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
finalize? 方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 

第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
注： 静态内部类（Inner Class）意味着1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象 

第四，&和&&的区别。 
&是位运算符。&&是布尔逻辑运算符。 

第五，HashMap和Hashtable的区别。 
都属于Map接口的类，实现了将惟一键映射到特定的值上。 
HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 

第六，Collection 和 Collections的区别。 
Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
Collection是个java.util下的接口，它是各种集合结构的父接口。 


第七，什么时候用assert。 
断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 AssertionError。它用于调试目的： 
assert(a > 0); // throws an AssertionError if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
Expression1 应该总是产生一个布尔值。 
Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
javac -source 1.4 Test.java 
要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
可 以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否 启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状 态。 


第八，GC是什么? 为什么要有GC? (基础)。 
GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 

第九，String s = new String("xyz");创建了几个String Object? 
两个对象，一个是"xyx",一个是指向"xyx"的引用对象s。 

第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 

第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)"醒来"的线程具有更高的优先级 
(b)正在运行的线程因为其它原因而阻塞。 
wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 

第十三，Java有没有goto? 
Goto?java中的保留字，现在没有在java中使用。 

第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
数组没有length()这个方法，有length的属性。 
String有有length()这个方法。 

第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方 法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重 载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方 法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 
error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 

Map不是 

第二十，abstract class和interface有什么区别? 
声 明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接 口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有 程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。 然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到 接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不能 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
有C背景的程序员特别喜欢问这种问题。 
2 < < 3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 

第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
  32题答案太长，复制出来估计你也不会看~~ 
 发表于：2008-12-02 19:33:1548楼 得分:0 
第一，谈谈final, finally, finalize的区别。 
      1.final 用于声明属性、方法、类。表示属性不可变，方法不可覆盖，类不可继承 
  finally是异常处理语句（try catch finally)结构的一部分，总是执行 
  finalize 是object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 

2.可以。匿名内部类是没有名字的内部类，可以继承，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
3.static Nested class是声明位静态的内部类，它可以不依赖外部类实例被实例化，而通常的Inner Class内部类需要外部类实例化后才能实例化。 

第四，&和&&的区别。 

4。&是位运算符，表示按位与运算。&&是逻辑运算符，表示逻辑与。 
第五，HashMap和Hashtable的区别。 
HashMap是Hashtable的轻量级实现，他们都完成了Map接口， 
主要区别： 
HashMap允许空键值,线程安全，效率可能高于HashTable. 
hashtable方法是synchronize而hashmap不是。 

第六，Collection 和 Collections的区别。 
Collection 是集合类的上级接口，继承与他的接口由Set和List 
Collections是针对集合类的一个帮助类。 
第七，什么时候用assert。 
这是一种调试方式，通常在开发和测试的时候用到，软件发布之后，通常关闭掉它。 
第八，GC是什么? 为什么要有GC? 

Gc是垃圾收集的一是。因为内存的处理是编程人员容易出现错误的地方，忘记或错误的内存回收会导致程序或系统的不稳定甚至崩溃. 
第九，String s = new String("xyz");创建了几个String Object? 

创建了2个 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 

12，11 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 

第一个错误s1+1 是int型，需要强制转换， 
第二个对。 
第十二，sleep() 和 wait() 有什么区别? 

sleep是线程类（Thread）的方法，导致此线程暂停执行指定时间，给执行机会给其他线程，但是监控状态依然保持，到时后会自动恢复。调用sleep不会释放对象锁。 
wait是Object类的方法，对此对象调用wait方法导致本线程放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象发出notify方法（或notifyAll）后本线程才进入对象锁定池准备获得对象锁进入运行状态。 

第十三，Java有没有goto? 

java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法? 

数组没有length()这个方法，有length的属性。String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 

Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 

error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 

List，Set是，Map不是 
第二十，abstract class和interface有什么区别? 

声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不行。 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
start(); 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
　String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
2 < <3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 

是值传递。Java 编程语言只有值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 

switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 

第一种形式: 定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
private Singleton(){} 
　　 //在自己内部定义自己一个实例，是不是很奇怪？ 
　　 //注意这是private 只供内部调用 
　　 private static Singleton instance = new Singleton(); 
　　 //这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　 public static Singleton getInstance() { 
　　　　 return instance; 　　 
　　 } 
} 
第二种形式: 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式: 
定义一个类，它的构造函数为private的，所有方法为static的。 
一般认为第一种形式要更加安全些 

 发表于：2008-12-02 21:14:4652楼 得分:0 
第一，谈谈final, finally, finalize的区别。 
final---修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载 
finally---在异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 
finalize---方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 
匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现。 
第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。具体可见http: //www.frontfree.net/articles/services/view.asp?id=704&page=1 
注：静态内部类（Inner Class）意味着 
1创建一个static内部类的对象，不需要一个外部类对象 
2不能从一个static内部类的一个对象访问一个外部类对象 
第四，&和&&的区别。 
&是位运算符。&&是布尔逻辑运算符。 
第五，HashMap和Hashtable的区别。 
都属于Map接口的类，实现了将惟一键映射到特定的值上。 
HashMap 类没有分类或者排序。它允许一个 null 键和多个 null 值。 
Hashtable 类似于 HashMap，但是不允许 null 键和 null 值。它也比 HashMap 慢，因为它是同步的。 
第六，Collection 和 Collections的区别。 
Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。 
Collection是个java.util下的接口，它是各种集合结构的父接口。 
抽象类能被继承，不能被实现；接口能被继承，也能被实现。 
第七，什么时候用assert。 
断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为 true。如果表达式计算为 false，那么系统会报告一个 AssertionError。它用于调试目的： 
assert(a > 0); // throws an AssertionError if a <= 0 
断言可以有两种形式： 
assert Expression1 ; 
assert Expression1 : Expression2 ; 
Expression1 应该总是产生一个布尔值。 
Expression2 可以是得出一个值的任意表达式。这个值用于生成显示更多调试信息的 String 消息。 
断言在默认情况下是禁用的。要在编译时启用断言，需要使用 source 1.4 标记： 
javac -source 1.4 Test.java 
要在运行时启用断言，可使用 -enableassertions 或者 -ea 标记。 
要在运行时选择禁用断言，可使用 -da 或者 -disableassertions 标记。 
要系统类中启用断言，可使用 -esa 或者 -dsa 标记。还可以在包的基础上启用或者禁用断言。 
可以在预计正常情况下不会到达的任何位置上放置断言。断言可以用于验证传递给私有方法的参数。不过，断言不应该用于验证传递给公有方法的参数，因为不管是否启用了断言，公有方法都必须检查其参数。不过，既可以在公有方法中，也可以在非公有方法中利用断言测试后置条件。另外，断言不应该以任何方式改变程序的状态。 

第八，GC是什么? 为什么要有GC? (基础)。 
GC是垃圾收集器。Java 程序员不用担心内存管理，因为垃圾收集器会自动进行管理。要请求垃圾收集，可以调用下面的方法之一： 
System.gc() 
Runtime.getRuntime().gc() 
第九，String s = new String("xyz");创建了几个String Object? 
两个对象，一个是“xyx”,一个是指向“xyx”的引用对象s。 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 
Math.round(11.5)返回（long）12，Math.round(-11.5)返回（long）-11; 
第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 
short s1 = 1; s1 = s1 + 1;有错，s1是short型，s1+1是int型,不能显式转化为short型。可修改为s1 =(short)(s1 + 1) 。short s1 = 1; s1 += 1正确。 
第十二，sleep() 和 wait() 有什么区别? 搞线程的最爱 
sleep()方法是使线程停止一段时间的方法。在sleep 时间间隔期满后，线程不一定立即恢复执行。这是因为在那个时刻，其它线程可能正在运行而且没有被调度为放弃执行，除非(a)“醒来”的线程具有更高的优先级 
(b)正在运行的线程因为其它原因而阻塞。 
wait()是线程交互时，如果线程对一个同步对象x 发出一个wait()调用，该线程会暂停执行，被调对象进入等待状态，直到被唤醒或等待时间到。 

第十三，Java有没有goto? 
Goto?java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法？ 
数组没有length()这个方法，有length的属性。 
String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被“屏蔽”了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 
第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 
Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 
第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, 
ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 
第十八，error和exception有什么区别? 
error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 
List，Set是 
Map不是 
第二十，abstract class和interface有什么区别? 
声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 
第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不能 
第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 
第二十三，启动一个线程是用run()还是start()? 
启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 
第二十五，是否可以继承String类? 
String类是final类故不可以继承。 
第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 
第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
有C背景的程序员特别喜欢问这种问题。 
2 < < 3 
第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 
是值传递。Java 编程语言只由值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 

第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 
switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 
Singleton模式主要作用是保证在Java应用程序中，一个类Class只有一个实例存在。 
一般Singleton模式通常有几种种形式: 
第一种形式: 定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
　　private Singleton(){} 
　　//在自己内部定义自己一个实例，是不是很奇怪？ 
　　//注意这是private 只供内部调用 
　　private static Singleton instance = new Singleton(); 
　　//这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　public static Singleton getInstance() { 
　　　　return instance; 　　 
　　 } 
} 
第二种形式: 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式: 
定义一个类，它的构造函数为private的，所有方法为static的。 
一般认为第一种形式要更加安全些 
 
  发表于：2008-12-03 16:46:05101楼 得分:0 
第一，谈谈final, finally, finalize的区别。 
      1.final 用于声明属性、方法、类。表示属性不可变，方法不可覆盖，类不可继承 
  finally是异常处理语句（try catch finally)结构的一部分，总是执行 
  finalize 是object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收。 
第二，Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)? 

2.可以。匿名内部类是没有名字的内部类，可以继承，但一个内部类可以作为一个接口，由另一个内部类实现。 

第三，Static Nested Class 和 Inner Class的不同，说得越多越好(面试题有的很笼统)。 
3.static Nested class是声明位静态的内部类，它可以不依赖外部类实例被实例化，而通常的Inner Class内部类需要外部类实例化后才能实例化。 

第四，&和&&的区别。 

4。&是位运算符，表示按位与运算。&&是逻辑运算符，表示逻辑与。 
第五，HashMap和Hashtable的区别。 
HashMap是Hashtable的轻量级实现，他们都完成了Map接口， 
主要区别： 
HashMap允许空键值,线程安全，效率可能高于HashTable. 
hashtable方法是synchronize而hashmap不是。 

第六，Collection 和 Collections的区别。 
Collection 是集合类的上级接口，继承与他的接口由Set和List 
Collections是针对集合类的一个帮助类。 
第七，什么时候用assert。 
这是一种调试方式，通常在开发和测试的时候用到，软件发布之后，通常关闭掉它。 
第八，GC是什么? 为什么要有GC? 

Gc是垃圾收集的一是。因为内存的处理是编程人员容易出现错误的地方，忘记或错误的内存回收会导致程序或系统的不稳定甚至崩溃. 
第九，String s = new String("xyz");创建了几个String Object? 

创建了2个 
第十，Math.round(11.5)等於多少? Math.round(-11.5)等於多少? 

12，11 

第十一，short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 

第一个错误s1+1 是int型，需要强制转换， 
第二个对。 
第十二，sleep() 和 wait() 有什么区别? 

sleep是线程类（Thread）的方法，导致此线程暂停执行指定时间，给执行机会给其他线程，但是监控状态依然保持，到时后会自动恢复。调用sleep不会释放对象锁。 
wait是Object类的方法，对此对象调用wait方法导致本线程放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象发出notify方法（或notifyAll）后本线程才进入对象锁定池准备获得对象锁进入运行状态。 

第十三，Java有没有goto? 

java中的保留字，现在没有在java中使用。 
第十四，数组有没有length()这个方法? String有没有length()这个方法? 

数组没有length()这个方法，有length的属性。String有有length()这个方法。 
第十五，Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型? 
方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。 

第十六，Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别? 

Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。 
equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。 

第十七，给我一个你最常见到的runtime exception。 
ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, CannotRedoException, CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException, DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException 

第十八，error和exception有什么区别? 

error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。 
exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。 

第十九，List, Set, Map是否继承自Collection接口? 

List，Set是，Map不是 
第二十，abstract class和interface有什么区别? 

声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。 
接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。 

第二十一，abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized? 
都不行。 

第二十二，接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)? 
接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。 

第二十三，启动一个线程是用run()还是start()? 
start(); 

第二十四，构造器Constructor是否可被override? 
构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。 

第二十五，是否可以继承String类? 
　String类是final类故不可以继承。 

第二十六，当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法? 
不能，一个对象的一个synchronized方法只能由一个线程访问。 

第二十七，try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? 
会执行，在return前执行。 

第二十八，编程题: 用最有效率的方法算出2乘以8等於几? 
2 < <3 

第二十九，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 
不对，有相同的hash code。 
第三十，当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递? 

是值传递。Java 编程语言只有值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。 
第三十一，swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上? 

switch（expr1）中，expr1是一个整数表达式。因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。 
第三十二，编程题: 写一个Singleton出来。 

第一种形式: 定义一个类，它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。 
public class Singleton { 
private Singleton(){} 
　　 //在自己内部定义自己一个实例，是不是很奇怪？ 
　　 //注意这是private 只供内部调用 
　　 private static Singleton instance = new Singleton(); 
　　 //这里提供了一个供外部访问本class的静态方法，可以直接访问　　 
　　 public static Singleton getInstance() { 
　　　　 return instance; 　　 
　　 } 
} 
第二种形式: 
public class Singleton { 
　　private static Singleton instance = null; 
　　public static synchronized Singleton getInstance() { 
　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　 
　　//使用时生成实例，提高了效率！ 
　　if (instance==null) 
　　　　instance＝new Singleton(); 
return instance; 　　} 
} 
其他形式: 
定义一个类，它的构造函数为private的，所有方法为static的。 
一般认为第一种形式要更加安全些 
 
 

这组题见过无数次了. 
  java面试题及答案 
第一，谈谈final, finally, finalize的区别。 
final?修饰符（关键字）如果一个类被声明为final，意味着它不 能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定 初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同… 
 

呵呵，找工作的时候可是不错的参考哦 
 

