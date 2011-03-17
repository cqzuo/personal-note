(一)javascript是什么 （javascript 语言　学习笔记 ）

感谢Perl，让我从新认识了javascript!

严格的说，没有宿主环境，javascript是没有什么用处的！一样，没有VM，java也跑不起来！没有计算机，机器码也无法运行！

传统上讲的javascript是与宿主环境一起说的，通常包括以下几个部分：

	1 ECMAScript 由ECMA制定的语言标准
	2 DOM  Docment Object Model  (文档对象模型)
3 BOM  Browser Object Model  (浏览器对象模型)

	这里我们只讨论语言部分，也就是ECMAScript！
	下面从ECMA -262中摘录的一段话表明了ECMAScript是什么！



	"ECMAScript can provide core scripting capabilities for a variety of host environments, and therefore the core
	scripting language is specified in this document apart from any particular host environment....."


(ECMAScript 可以为不同的宿主环境提供核心的脚本编程能力，因此核心的脚本语言是与任何特定的宿主环境分开规定的...)


	　　ECMAScript属于动态语言！

	提到动态语言，当前比较流行的有ruby，python等等，php在开源Web领域也很著名，还有perl这个linux上的古老精灵！
	至于ECMAScript(javascript),很少有人提到！难道是因为名字的原因！先见识一下：
	用javascript写的虚拟Unix：  http://www.masswerk.at/jsuix/

	还有用javascript写的中文输入法：http://justinput.laoman.com/

	只因为javascript在浏览器中总是以一些小技巧出现(以及讨厌的名字javascript)，所以阻碍了人们认识她！

	那什么是动态语言！一般情况下，动态语言都是脚本语言。动态语言似乎没有官方的定义。动态语言有两层概念：第一是动态类型。
	意味着在运行时决定(或者发现)数据的类型。另外一层更有意思，也是与静态语言最大的不同，就是可以在运行时动态改变语言结构。
	这是解释语言才能做的事情！（问题出现了，机器语言是动态还是静态！呵呵）
	这个概念还是比较难以理解！等着看例子吧！

	总之ECMAScript有什么呢？其实只有一种东西，就是语言元素！
	比如：语法，类型，语句，关键字，保留字，运算符，对象（类）等等！

	别的就什么也没有了！但可以做出很多你意向不到的东西！

	忘掉那些没有用的所谓的技巧吧！
	引用 使用道具 报告 回复 TOP
	hotplum

	团级干部

	UID
	34283 
	帖子
	104 
	偶元
	492  
	个人空间发短消息加为好友当前离线	
	3#大中小 发表于 2008-2-1 09:25 	 只看该作者
	(二) 构建运行环境（javascript 语言　学习笔记 ）

	前面说过，javaScript(我们还是叫javascript吧，或者简称JS，虽然ECMAScript更准确)需要有运行的宿主环境！
	其实对于任何一个脚本语言都是一样的，首先我们需要一个编辑器，Windows下我比较喜欢EditPlus！当然notepad也可以写！
	然后我们需要一个解释器！然后就可以玩了！对于我还是比较喜欢IDE，集成了编辑，运行，调试等功能！对于宿主IE的ECMAScript，
	有个不错的IDE！一会儿我会介绍！
	当然IE，Firefox等都是不错的解释器！结合BOM还可以做点界面出来，不过只是学习语言，简单的输入输出就够了！
	微软虽然热衷VBScript的推广，但迫于javaScript广大的用户，对javascript也是一视同仁！在Windows系统里有个不错的解释器
	WSH(Windows Script Host)。虽然他的初衷是用来管理windows！但无形中提供了一个学习JS的好环境！
	在windows上WSH有两个,一个叫WSCript.exe 一个是CScript.exe 解释器是一样的，只是WScript.exe是视窗程序，CSCript.exe是控制台程序！
	当然，习惯linux的我还是喜欢控制台！其实只要有输入输出就够用了！
	windows上默认是使用WSCript.exe。 打开编辑器输入
	//hello.js
	WScript.echo("Hello world");
	保存为hello.js
	然后双击，或者在cmd中键入hello.js ！OK了
	如果喜欢控制台我们可以用CSCript hello.js
	或者修改默认宿主   C:\CScript /H:CScript

	为了编写不依赖宿主的JS程序！看看我的做法！
	编写一个wscript.js
	内容为(以后还可以加，先把输出搞定)
funtion println(str)
{
	WScript.echo(str);
}

然后编写一个test.wsf的文件(windows 脚本宿主文件，其实是个XML，很有用哦)
	内容如下：
	<job>
	<!--  先将上面的隔离宿主js include进来 -->
	<script language="javascript" src="wscript.js" />
	<!--  下面是你写个测试程序，当然可以直接在这里写 -->
	<script language="javascript" src="main.js" />
	</job>

	至于main.js 我们随便写
	这里我摘抄了《JavaScript高级程序设计》中比较漂亮的OO实现的一个例子
	main.js 的内容：
function Car(sColor, iDoors, iMpg)
{
	this.color = sColor;
	this.doors = iDoors;
	this.mpg = iMpg;
	this.drivers = new Array("Mike", "Sue");
}
Car.prototype.showColor = function()
{
	println(this.color);
}

var oCar1 = new Car("red", 4, 23);
var oCar2 = new Car("blue", 3, 25);
oCar1.showColor();
oCar2.showColor();
oCar1.drivers.push("wxd");
println(oCar1.drivers);
println(oCar2.drivers);

javascript的OO感觉还不错吧！其实还有更令人震撼的OO方式，呵呵，OO在动态语言看来就是一种方式而已！

现在在控制台中输入
c:\test\js\chat2\test.wsf

red
blue
Mike,Sue,wxd
Mike,Sue

OK!成功了！

下面介绍那个javascript在IE宿主中的那个IDE，是微软在Office中携带的工具：微软脚本编辑器！我这里叫MSE7.exe
这个玩意功能比较强大，如果IE中打开脚本调试，就是一个十足的javascript IDE了！当然如果没有，使用IE和其他浏览器做解释器也行！


	首先写一个html.js
funtion println(str)
{
	document.writeln(str+"<br>");
	//我就不要alert 了！弹出对话框，不爽
}

然后写一个test.html

<HTML>
<HEAD>
<TITLE></TITLE>
<!-- 这里和那个test.wsf是不是有点像 -->

<script language=javascript src="html.js"></script>
<script language=javascript src="main.js"></script>

</HEAD>
<BODY></BODY>
</HTML>

如果用MSE7很方便，还有编码提示等IDE功能，当然还有调试！

现在用浏览器打开test.html 或者直接在MSE7中执行！
浏览器中应该会出现下面的内容

red
blue
Mike,Sue,wxd
Mike,Sue


其实还有许多javascript的解释器！都可以使用！

下面是我写的JScript和VBScript的解析器(结合windows脚本调试工具可以调试)
	http://www.51leifeng.net/viewthr ... mp;page=1#pid100894
	引用 使用道具 报告 回复 TOP
	hotplum

	团级干部

	UID
	34283 
	帖子
	104 
	偶元
	492  
	个人空间发短消息加为好友当前离线	
	4#大中小 发表于 2008-2-2 23:04 	 只看该作者
	(三) 基于对象的函数语言（JavaScript 学习笔记）

	(三) 基于对象的函数语言

	上面介绍了构建学习JavaScript语言的环境！当然，除了微软的JS解析器，最著名的当属发明JavaScript的netscape，现在是mozilla组织，可以去www.mozilla.org
	下载解析器包括源代码。学习javascript资料也很多！
	最原始准确的资料应该是ECMA-262标准！不过，许多宿主环境有自己非ECMA的特性所以，宿主环境的原始资料也比较重要！（统一标准为何如此之难，为之一叹）！
	微软JScript查阅MSDN是最完备得了！
	另外有两本书值得推荐
	一本是  <<Professional JavaScript for Web Developers>>  作者是一个Web程序员 Nicholas C.Zakas,站在一个Web开发人员的角度审视JavaScript，
	是一本值得珍藏的JavaScript著作！ 中文翻译版叫做 《JavaScript 高级程序设计》
	另外一本是David Flanagan 的名著 《JavaScript: The Definitive Guide》目前是第五版，属于词典工具类型的，随时查阅！David Flanagan 是一个Java程序员。

	JavaScript的基本特性通过这两部书再加上ECMA-262标准的查阅就足够用了！但Web的B端开发设计到很多东西！而且缺一不可！当你发现Flash也是一个不错的B端开发
	工具时（或者你一直在用，而发现还有其他的B端开发方法），B端开发真是一盘散沙！作为一个程序员，看上去，JavaScript正是那只盘子！

	关于B端开发的相关名词太多，每一种名词都有很多相关的资料介绍，或者可以理解为一种学问！
	比如CSS（Cascading Style Sheets ），我们称之为样式表，当你想做一个兼容各种浏览器和物理设备的网页时必不可少的东西！
	比如DOM（Document Object Model），文档对象模型，这是只做动态网页效果的一个美丽的标准，但支持DOM标准看起来还是一个遥远的事情！现在，我们还需要学习DOM
	的同时掌握IE自己的动态网页的方法，真是无奈！
	最重要的HTML,网页的基础也是一门绝对的必修课，如果使用XHTML（符合XML标准的HTML），就可以用DOM操作HTML了。
	还有流行的XML，一个无所不能的文本格式标准，带来了无数革命的东西！呵呵
	而上面的这些东西，都可以在JavaScript中操作，也就是一切都可以用编程实现，哈哈，多么惬意的事情！

	上面提到的书中都有相关介绍，或者可以上google、baidu 上面搜索，搜索引擎代替了我们部分的脑存储的功能！可怕！
	如果不愿意付钱购买书籍，有个不错的电子书网站 www.51leifeng.net!

	前几天从网上购买了一个JavaScript IDE —— 1st JavaScript Editor Pro 3.8,花费了59.5$ ,借用《大腕儿》里的话：“真值”！
	结合FireFox的Debug插件成为完美的开发环境，IE方面还可以用微软的脚本编辑器补充（前面我介绍过）！


	回到正题！


	类似JavaScript这样的动态脚本语言一定会有大的发展，虽然现在形式还不是很明朗，许多的动态语言已经展露头角了（Python、ruby等等名词最近是不是很流行）。安装时下
	流行的观点，比如Java，C#等属于OOP（Object Oriented Programming）语言，而JavaScript属于FP（Function Programming），什么意思呢？在OOP中对象是第一位的，类是
	第一位的，而FP中函数是第一位的！JavaScript语言的这些本质特性，如果是用来做一些页面的特效，也不需要了解多深（如果遇不到多少问题），如果打算把JavaScript
	集成到自己的应用中做为脚本(实际上这样的应用也不少，比如Flash的ActionScript)，或者想用JavaScript设计出完整的类库和UI库（已经有人这样做了，国内我所知道的有一个
	Open的项目叫qomo,有兴趣的可以下载，相信会有不同的感受！https://qomo.svn.sourceforge.net/svnroot/qomo/trunk），语言特性的剖析以及宿主对象的研究就必不可少！


	当然，首先我们先看看纯语言特性的东西

	语法和语句的内容看看书就OK了！类型比较重要(前面说过，动态语言首先是动态类型，或者干脆是若类型)，运算符是类C语言的（或者java），对象和函数是比较有意思的话题，
	而且对象和函数有千丝万缕的联系，呵呵！后面的内容我们一步步探讨！我所用的方法完全是医生的方法类似，靠临床诊断，靠实际代码解释的情况判断解释器的意图！或者是
	javaScript的哲学！研究完再看ECMA 262估计会更有意思！

	JavaScript的许多语言特性是使用一系列关键字来实现的，比如变量声明的var，创建对象的new ，对象原型prototype 等等! 记住这些关键字！好像关键的关键字并不多！
	下面我们先看看类型！
	引用 使用道具 报告 回复 TOP
	hotplum

	团级干部

	UID
	34283 
	帖子
	104 
	偶元
	492  
	个人空间发短消息加为好友当前离线	
	5#大中小 发表于 2008-2-3 22:51 	 只看该作者
	(四) 数据类型和直接量 （JavaScript 学习笔记）

	(四) 数据类型和直接量

	动态语言的类型通常实在解释过程中去发现的！所以类型就不是很重要了！不像Perl那样严格的区分几种形式
	比如标量($前缀)、数组(@前缀)、哈希(%前缀)等等！或者微软的VBScript只有一种类型Variant。
	但总体来说JavaScript也有有限的几种数据类型！

	1 数字（Number），包括整数和浮点数！
	2 字符串（String），在JavaScript中感觉字符串处理的不是很好！造成复制、传递等有些不可理解！
	3 布尔类型（Boolean）。
	4 函数类型（Function），这是JavaScript的灵魂之一！
	5 对象（Object），其实JavaScript里的类型都是对象！呵呵
	6 数组（Array），JavaScript的数组和Perl几乎同出一辙！JavaScript的数组里不要求相同的数据类型，可以是对象，当然，还可以是函数！
	7 正则表达式（RegExp），实现了许多正则的功能，还兼容了Perl中的表示法！是字符串操作的利器！不用解释太多了！

	其实还有Date和Error，和RegExp一样是为了实现某种功能的JavaScript原生对象！

	先讨论一个有意思的话题——直接量（Literals）;

	在汇编里就有立即数的概念比如 MOV EAX，0X65   0X65就是一个立即数！直接量大体上也是这个概念，不过JavaScript中一切都是对象，直接量也不放过！
	如果你使用改直接量所属类型的对象特性时，他就被临时赋予了对象的特性！

	先说一下每种类型最简单的直接量
	数字比较简单一个整型和浮点型都可以 如1 或1.0 等
	字符串的标识是引号（单引号，双引号都可以）如 '' 或者""
	布尔类型就是 true 和false
对象的直接量最简单的是{} (两个大括号括起来)
	数组呢？数组是两个中括号括起来[]
	函数是这样的 function() {}
正则是/./ (如果两个反斜杠连着成了注释，呵呵中间加个字符就OK了)

	Date和Error 我没有找到他们的直接量！

	看个有趣的例子：


	String.prototype.toString = function () { return "Hi I'm String";};
Number.prototype.toString = function () {return "Hi I'm Number" ;};
Object.prototype.toString = function() {return "Hi I'm a Object";};
Function.prototype.toString = function () {return "Hi I'm a Function";};
Array.prototype.toString = function () {return "Hi I'm a Array";};
RegExp.prototype.toString = function () {return "Hi I'm a RegExp";};
Date.prototype.toString = function () {return "Hi I'm a Date";};
Error.prototype.toString = function () {return "Hi I'm a Error";};
writeln((1).toString());
writeln(("1").toString());
//writeln((1));
//writeln(("1"));
writeln({});
writeln(function () {});
writeln([]);
writeln(/./);
writeln(null);
writeln(undefined);
var d = new Date(2008,11,02);
writeln(d);
var e = new Error(100);
writeln(e);




看看运行结果！是不是很有趣，为了完整，我加上了Date和Error！

	使用直接量在某些地方会减少代码量！当然也就减少了我们的输入量！比如只需要简单的使用某种对象的特性的时候
if ((/dog/).test(str))
{
	// do something
}
比如上面看看str中有没有dog这个单词，是不是用直接量比较方便？

对于喜欢Pascal那种严谨的代码风格的我来说声明一个对象我会用
var obj1 = new Object();
不过下面的代码是等效的
var obj2 = {};
有兴趣你可以对比一下obj1 和obj2 的所有特性，我进行过简单的对比，结论是完全一样！
使用什么样的代码风格完全看使用者了！

