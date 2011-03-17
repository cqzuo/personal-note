java的try-finally给我们提供了一个“保证某个动作必然执行”的机会。 

一个try-finally结构，只要try块开始执行了，finally块里面的代码保证执行一次并且只有一次。 
打个比方，就象你上厕所，只要你一旦开始拉了，我们保证无论如何，是拉稀了也好，放屁了也罢，最终你肯定是擦了屁股走出卫生间。 

应用try-finally，我们可以在异常满天飞的程序里保证我们的关键资源被按时正确清理。一个最常见的应用就是jdbc的Connection, Statement, ResultSet等。 

但是，我最近惊奇地发现，不知道怎么正确清理资源的人大有人在，即使是一些java老手。 

看一个例子先： 


代码 
void f(){ 
Connection conn = ...; 
Statement stmt = conn.createStatement(); 
ResultSet rset = ...; 
... 
} 

典型的jdbc程序。但是也是典型的光着屁股，其臭如兰地走出厕所的典范。哎，你擦屁股了吗？ 
有的哥们振振有辞：我不用管，我的jdbc driver/我的应用服务器/garbage collector会处理的。 
这是典型的糊涂蛋逻辑。没有close()，jdbc driver, 应用服务器怎么知道你是拉完了，还是光着屁股出去接个电话先？难不成这driver都智能地会算命了？ 
garbage collector倒确实管得了。不过，garbage collector不一定运行啊。你要是有10G得内存，要是你的程序就用了10M，garbage collector说不定就一直睡大觉。而且，就算它管，也许等你光着屁股上班被警察抓起来之后才匆匆赶到，你等的起吗？ 


好，有人说，那我擦，我擦，我擦擦擦。行了吧？ 


代码 
void f(){ 
Connection conn = ...; 
Statement stmt = conn.createStatement(); 
ResultSet rset = ...; 
rset.close(); 
conn.close(); 
... 
} 


呵呵。我的傻哥们，你只擦了靠近后背的那三公分，剩下的嘛，别人看不见你就乐得省土块儿了是么？ 

按jdbc标准，ResultSet, Statement, Connection都要close()，也许有的driver会在Connection关闭的时候同时正确清理ResultSet, Statement，但是，并没有一条规定让所有的driver都这么做。 
另外，也许你的Connection是从一个池里面来的，它只是回到池中去，如果你不关闭Statement, ResultSet，下一个拿到这个Connection的人也许就倒霉了！ 
做事要有始有终，既然开始擦了，就擦干净点儿，行不？（那个，谁谁谁，借我个防毒面具先！） 

ok，有个讲卫生的小傻子这样擦： 


代码 
void f(){ 
Connection conn = ...; 
Statement stmt = conn.createStatement(); 
ResultSet rset = ...; 
rset.close(); 
stmt.close(); 
conn.close(); 
... 
} 


然后洋洋得意地说：我是好孩子，我天天擦屁屁。 

是啊，多听话的孩子呀。可惜，某天，这孩子正坐在马桶上美着呢，妈妈喊了嗓子：二傻子，吃饭啦。 
哦！吃饭。二傻子裤子都没提就窜出来了，熏得妈妈一个跟头。 

什么问题，傻子做事一根筋，不能打扰，一旦有异常情况出现，屁股就忘了擦了。 

所以，我这里郑重提醒大家，请用"try-finally"！它独有凹槽，防止侧漏...（糟了，串台了） 

是啊，java老手们都不是傻子，都知道用try-finally的，可是，别美，你现在就保不齐擦没擦屁股呢！ 

常见擦法： 


代码 
void f(){ 
Connection conn = null; 
Statement stmt = null; 
ResultSet rset = null; 
try{ 
conn = ...; 
stmt = ...; 
rset = ...; 
... 
} 
finally{ 
if(rset!=null)rset.close(); 
if(stmt!=null)stmt.close(); 
if(conn!=null)conn.close(); 

} 
} 


嗯。怎么说呢。挺聪明的。都学会if(xxx!=null)这种传说中条件判断的上古绝学了。 
可惜，你屁股大，一张纸不够，你用了第一张纸，满意地看着它圆满地完成了金灿灿的任务，再用第二张，靠，只太薄，破了，一手金灿灿地，象带了个金戒指。你大怒，起，绝尘而去。于是也忘了第三张纸， 
哥们儿，close()是可以出异常的，你rset关了，stmt.close()出现了异常，但是conn就不管了？ 

近日有位室外高人，据说是鬼谷子高徒，鉴于怜我世人，不擦屁股的实多的高尚情操，亲手赚写一本绝世擦功秘籍，其文美，其意高，除了擦不干净之外，真可以说是称霸擦林。 


代码 
void close(Connection conn){ 
try{ 
if(conn!=null) conn.close(); 
} 
catch(Exception e){ 
e.printStackTrace(); 
} 
} 
void close(ResultSet rset){ 
... 
} 
void close(Statement rset){ 
... 
} 
void f(){ 
Connection conn = null; 
Statement stmt = null; 
ResultSet rset = null; 
try{ 
conn = ...; 
stmt = ...; 
rset = ...; 
... 
} 
finally{ 
close(rset); 
close(stmt); 
close(conn); 

} 
} 


哈，你们不能纸擦破了就不接着擦啊，甚至大而化之，不能擦股用具有了问题就半途而废呀！ 

具信，该高人以此法擦遍天下凡十数载，未有擦而无功者。 

可惜，高人却忽视了，除了纸会出故障，甚至大而化之，一切擦具（如土块儿，木条儿，手指）都可能出现故障，还有别的地方也会出故障地！ 
除了Exception，还有Error啊，我的高人！如果close(rset)抛了一个Error，你的close(stmt), close(conn)不都歇菜了？ 

后来，高人在《绝世武功补遗》里面解释说：Error代表不可恢复错误，说明整个排泄大业都受阻了，所以根本不应该试图对这种情况做任何处理，你也处理不了（自然也隐含此时你也根本无法擦屁股了的论断）。任何试图在这种情况下仍然固执擦屁股的做法都是倒行逆施，螳臂当车，必然被历史的车轮所撵碎。 

此书一处，天下辟易。其革命性之深远，难以估量。具有关方面评论，Sun这个公共厕所的try-finally这个工具的设定本身就是不合理的，应该被历史车轮撵碎的，因为try-finally居然试图在出现Error的时候去做一些事情！是可忍，孰不可忍？ 
可以预见，try-finally将被sun彻底废弃，并且向广大公众做公开道歉以检讨多年来的欺骗造成的恶劣影响。 
另外，公厕的构造也受到质疑，因为一旦有一个拉客在擦的时候某一步无可挽回地失败（比如，太紧张，手一抖，纸掉到了坑里，又死活伸手捞不着），那么他就大摇大摆不再继续擦，而如果碰巧此人刚吃了萝卜，就会把整个厕所里的其它拉客都熏得无法继续。（想想一个app server吧。你一个程序歇菜，乐得请病假不擦了，别人也跟着倒霉？） 

嘿嘿，那么，你擦了吗？你肯定你擦了？擦干净了？ 

幸好，我们翻遍上古秘籍，最终在北京山顶洞人的失传宝典《呼呼，擦！》中发现了一个据称绝对干净的擦法，那就是－－－－－－－－－－－－ 

一下一下擦！ 

具体操作办法如下： 


代码 
void f(){ 
final Connection conn = ...; 
try{ 
final Statement stmt = ...; 
try{ 
final ResultSet rset = ...; 
try{ 
... 
} 
finally{rset.close();} 
} 
finally{stmt.close();} 
} 
finally{conn.close();} 
} 


其诀窍就是，每建立一个需要清理的资源，就用一个try-finally来保证它可以被清理掉。 

如此，任何时候，你都是屁股干干静静地离开卫生间。 

哪。好多圣人门徒跟我说：这样一下一下擦，姿势非常不雅观（看看那嵌套的try块吧），有违古礼。我们反对！ 

靠，你说孔丑儿古还是山顶洞人古？？ 
屁股还泛着味儿呢，还拽什么“雅”？ 

而且，要是死要面子，也可以拉个帘子，擦的时候别让人看见嘛。比如： 


代码 
interface ResultListener{ 
void call(ResultSet rset); 
} 
class SqlReader{ 
void read(ResultListener l){ 
final Connection conn = ...; 
try{ 
final Statement stmt = ...; 
try{ 
final ResultSet rset = ...; 
try{ 
l.call(rset); 
} 
finally{rset.close();} 
} 
finally{stmt.close();} 
} 
finally{conn.close();} 
} 
} 


这一下一下擦的动作都藏在SqlReader这个帘子里，你直接在ResultListener里面拉不就行了？ 

那位高人说了，这太复杂，就为了擦个屁股不值。 

这个嘛，值不值的另说，你那个简单，就是简简单单地擦不干净屁股。要不您干脆别擦得了，更简单呢还。反正您出门儿就愣说擦的是Chanel香水儿就是了。有啥比瞪眼儿说白话儿简单？ 

对了， 我还忘了一个条款： 
就是擦屁股的时候按顺序擦。谁后进厕所的，要让人家先出去。 

“什么狗屁规则？“那位问了。 

这个这个--，啊，你猜猜~~~？ 

嗯，对了，是这样的，上厕所都不着急，姗姗来迟，上课更不着急，更喜欢迟到了，对不对？而谁上课天天迟到早退还不担心毕业？当然是了，是不？ 
人家都了，你还不让人家先出去？活腻味了你？（此处尾音要拉长，而且向上拐） 

反正啊，具体说，ResultSet最后创建，但是要先关。 

Statement其次。Connection最后。 

当然了，也许在你的环境下，次序错了也没出事情。但是，咱么吃软饭的（吃软件这口饭的）图啥？不就图个放心吗？上厕所图啥？不就图个别让抓去当兔子吗？ 
也许某个driver对次序不敏感，但是不好说哪天你换个环境就忽然她奶奶的敏感了呢？ 
比如吧，你有connection pool, conn.close()把connection返回到connection。 

你要是先conn.close()，好嘛，connection先回到pool了，正好别的线程里面等着要connection，立马这个connection又给分配出去了。 
这下齐了，你statement, resultset还没关呢，那边事故单位领导就找上门了。什么香油油的桌子，什么桐油炸丸子，全给你送来了。这不添堵吗？ 

好在，在我们《呼呼，擦！》宝典中记载的“一下一下擦”神功，老少咸宜，童叟无欺，有道是：法擦大法好，不如法擦冰箱好！ 

跑题了。反正是，只要你一个try-finally对应一个资源，你就不可能在次序上出错。自然而然的就是后入先出的堆栈结构。 
反观别的擦法，就没有这个效果，次序如何，全靠你自己掌握。弄错了，系统也不告诉你。等着吃桐油炸丸子吧。 

这也是我们推广一下一下擦的一个原因。 
------------------------------------------------------------

