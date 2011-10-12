<map version="0.9.0">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node text="链表.org" background_color="#00bfff">
<richcontent TYPE="NOTE"><html><head></head><body><p>--org-mode: WHOLE FILE</p></body></html></richcontent>
<node text="&#x5e8f;&#x8a00;" folded="true" position="left">
<node text="&#x6570;&#x7ec4;&#x7684;&#x7f3a;&#x70b9;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x63d2;&#x5165;/&#x641c;&#x7d22;/&#x5220;&#x9664;&#x4f4e;&#x6548;<br />- &#x5927;&#x5c0f;&#x4e0d;&#x53ef;&#x53d8;</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x94fe;&#x8868;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x89e3;&#x51b3;&#x6570;&#x7ec4;&#x7684;&#x7f3a;&#x70b9;</p></body>
</html>
</richcontent>
</node>
</node>
</node>
<node text="&#x94fe;&#x63a5;&#x70b9;" folded="true" position="left">
<node text="&#x7279;&#x70b9;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x6570;&#x636e;&#x9879;&#x5305;&#x542b;&#x5728;Link&#x4e2d;<br />- &#x6bcf;&#x4e2a;&#x94fe;&#x63a5;&#x70b9;&#x90fd;&#x662f;&#x67d0;&#x4e2a;Link&#x7684;&#x5bf9;&#x8c61;</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x4f8b;&#x5b50;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>#+BEGIN_SRC java<br />&#160;class Link<br />{<br />&#160;&#160;public Object obj ;<br />&#160;&#160;public Link next;<br />}<br />#+END_SRC</p></body>
</html>
</richcontent>
</node>
</node>
</node>
<node text="&#x5355;&#x94fe;&#x8868;" folded="true" position="left">
<node text="&#x7279;&#x70b9;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x8868;&#x5934;&#x63d2;&#x5165;&#x6570;&#x636e;<br />- &#x8868;&#x5934;&#x5220;&#x9664;&#x6570;&#x636e;<br />0 &#x904d;&#x5386;&#x94fe;&#x8868;&#x663e;&#x793a;&#x5185;&#x5bb9;</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x4f8b;&#x5b50;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>#+BEGIN_SRC java<br />&#160;class Link<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;public int iData;              // data item<br />&#160;&#160;&#160;public double dData;           // data item<br />&#160;&#160;&#160;public Link next;              // next link in list<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public Link(int id, double dd) // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;iData = id;                 // initialize data<br />&#160;&#160;&#160;&#160;&#160;&#160;dData = dd;                 // ('next' is automatically<br />&#160;&#160;&#160;&#160;&#160;&#160;}                           //  set to null)<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void displayLink()      // display ourself<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;{&quot; + iData + &quot;, &quot; + dData + &quot;} &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;}  // end class Link<br />////////////////////////////////////////////////////////////////<br />class LinkList<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;private Link first;            // ref to first link on list</p><p>// -------------------------------------------------------------<br />&#160;&#160;&#160;public LinkList()              // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;first = null;               // no links on list yet<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public boolean isEmpty()       // true if list is empty<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;return (first==null);<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;// insert at start of list<br />&#160;&#160;&#160;public void insertFirst(int id, double dd)<br />&#160;&#160;&#160;&#160;&#160;&#160;{                           // make new link<br />&#160;&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(id, dd);<br />&#160;&#160;&#160;&#160;&#160;&#160;newLink.next = first;       // newLink --&gt; old first<br />&#160;&#160;&#160;&#160;&#160;&#160;first = newLink;            // first --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public Link deleteFirst()      // delete first item<br />&#160;&#160;&#160;&#160;&#160;&#160;{                           // (assumes list not empty)<br />&#160;&#160;&#160;&#160;&#160;&#160;Link temp = first;          // save reference to link<br />&#160;&#160;&#160;&#160;&#160;&#160;first = first.next;         // delete it: first--&gt;old next<br />&#160;&#160;&#160;&#160;&#160;&#160;return temp;                // return deleted link<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void displayList()<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;List (first--&gt;last): &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;Link current = first;       // start at beginning of list<br />&#160;&#160;&#160;&#160;&#160;&#160;while(current != null)      // until end of list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current.displayLink();   // print data<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;  // move to next link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;}  // end class LinkList<br />#+END_SRC</p></body>
</html>
</richcontent>
</node>
</node>
</node>
<node text="&#x67e5;&#x627e;&#x548c;&#x5220;&#x9664;&#x6307;&#x5b9a;&#x94fe;&#x63a5;&#x70b9;" folded="true" position="left">
<node text="find">
</node>
<node text="delete">
</node>
<node text="&#x4f8b;&#x5b50;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>#+BEGIN_SRC java<br />&#160;public Link find(int key)      // find link with given key<br />&#160;&#160;&#160;&#160;&#160;&#160;{                           // (assumes non-empty list)<br />&#160;&#160;&#160;&#160;&#160;&#160;Link current = first;              // start at 'first'<br />&#160;&#160;&#160;&#160;&#160;&#160;while(current.iData != key)        // while no match,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if(current.next == null)        // if end of list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return null;                 // didn't find it<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;else                            // not end of list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;      // go to next link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;return current;                    // found it<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public Link delete(int key)    // delete link with given key<br />&#160;&#160;&#160;&#160;&#160;&#160;{                           // (assumes non-empty list)<br />&#160;&#160;&#160;&#160;&#160;&#160;Link current = first;              // search for link<br />&#160;&#160;&#160;&#160;&#160;&#160;Link previous = first;<br />&#160;&#160;&#160;&#160;&#160;&#160;while(current.iData != key)<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if(current.next == null)<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return null;                 // didn't find it<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;previous = current;          // go to next link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}                               // found it<br />&#160;&#160;&#160;&#160;&#160;&#160;if(current == first)               // if first link,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;first = first.next;             //    change first<br />&#160;&#160;&#160;&#160;&#160;&#160;else                               // otherwise,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;previous.next = current.next;   //    bypass it<br />&#160;&#160;&#160;&#160;&#160;&#160;return current;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />#+END_SRC</p></body>
</html>
</richcontent>
</node>
</node>
</node>
<node text="&#x53cc;&#x7aef;&#x94fe;&#x63a5;&#x70b9;" folded="true" position="left">
<node text="&#x7279;&#x70b9;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x53ef;&#x5728;&#x8868;&#x5c3e;&#x76f4;&#x63a5;&#x63d2;&#x5165;&#x4e00;&#x4e2a;&#x94fe;&#x63a5;&#x70b9;</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x4f8b;&#x5b50;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>#+BEGIN_SRC java<br />&#160;class Link<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;public long dData;                 // data item<br />&#160;&#160;&#160;public Link next;                  // next link in list<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public Link(long d)                // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{ dData = d; }<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void displayLink()          // display this link<br />&#160;&#160;&#160;&#160;&#160;&#160;{ System.out.print(dData + &quot; &quot;); }<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;}  // end class Link<br />////////////////////////////////////////////////////////////////<br />class FirstLastList<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;private Link first;               // ref to first link<br />&#160;&#160;&#160;private Link last;                // ref to last link<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public FirstLastList()            // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;first = null;                  // no links on list yet<br />&#160;&#160;&#160;&#160;&#160;&#160;last = null;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public boolean isEmpty()          // true if no links<br />&#160;&#160;&#160;&#160;&#160;&#160;{ return first==null; }<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void insertFirst(long dd)  // insert at front of list<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(dd);   // make new link</p><p>&#160;&#160;&#160;&#160;&#160;&#160;if( isEmpty() )                // if empty list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;last = newLink;             // newLink &lt;-- last<br />&#160;&#160;&#160;&#160;&#160;&#160;newLink.next = first;          // newLink --&gt; old first<br />&#160;&#160;&#160;&#160;&#160;&#160;first = newLink;               // first --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void insertLast(long dd)   // insert at end of list<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(dd);   // make new link<br />&#160;&#160;&#160;&#160;&#160;&#160;if( isEmpty() )                // if empty list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;first = newLink;            // first --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;last.next = newLink;        // old last --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;last = newLink;                // newLink &lt;-- last<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public long deleteFirst()         // delete first link<br />&#160;&#160;&#160;&#160;&#160;&#160;{                              // (assumes non-empty list)<br />&#160;&#160;&#160;&#160;&#160;&#160;long temp = first.dData;<br />&#160;&#160;&#160;&#160;&#160;&#160;if(first.next == null)         // if only one item<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;last = null;                // null &lt;-- last<br />&#160;&#160;&#160;&#160;&#160;&#160;first = first.next;            // first --&gt; old next<br />&#160;&#160;&#160;&#160;&#160;&#160;return temp;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void displayList()<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;List (first--&gt;last): &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;Link current = first;          // start at beginning<br />&#160;&#160;&#160;&#160;&#160;&#160;while(current != null)         // until end of list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current.displayLink();      // print data<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;     // move to next link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;}  // end class FirstLastList<br />#+END_SRC</p></body>
</html>
</richcontent>
</node>
</node>
</node>
<node text="&#x94fe;&#x8868;&#x7684;&#x6548;&#x7387;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x8868;&#x5934;&#x63d2;&#x5165;&#x548c;&#x5220;&#x9664;&#x901f;&#x5ea6;&#x5757;<br />- &#x67e5;&#x627e;&#x548c;&#x5220;&#x9664;&#x6307;&#x5b9a;&#x94fe;&#x63a5;&#x70b9;<br />- &#x65e0;&#x5bb9;&#x91cf;&#x9650;&#x5236;</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x62bd;&#x8c61;&#x6570;&#x636e;&#x7c7b;&#x578b;" folded="true">
<node text="&#x7528;&#x94fe;&#x5b9e;&#x73b0;&#x7684;&#x6808;" folded="true">
<node text="&#x4f8b;&#x5b50;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>#+BEGIN_SRC java<br />&#160;&#160;class Link<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;public long dData;             // data item<br />&#160;&#160;&#160;public Link next;              // next link in list<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public Link(long dd)           // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{ dData = dd; }<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void displayLink()      // display ourself<br />&#160;&#160;&#160;&#160;&#160;&#160;{ System.out.print(dData + &quot; &quot;); }<br />&#160;&#160;&#160;}  // end class Link<br />////////////////////////////////////////////////////////////////<br />class LinkList<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;private Link first;            // ref to first item on list<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public LinkList()              // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{ first = null; }           // no items on list yet<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public boolean isEmpty()       // true if list is empty<br />&#160;&#160;&#160;&#160;&#160;&#160;{ return (first==null); }<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void insertFirst(long dd) // insert at start of list<br />&#160;&#160;&#160;&#160;&#160;&#160;{                           // make new link<br />&#160;&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(dd);<br />&#160;&#160;&#160;&#160;&#160;&#160;newLink.next = first;       // newLink --&gt; old first<br />&#160;&#160;&#160;&#160;&#160;&#160;first = newLink;            // first --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public long deleteFirst()      // delete first item<br />&#160;&#160;&#160;&#160;&#160;&#160;{                           // (assumes list not empty)<br />&#160;&#160;&#160;&#160;&#160;&#160;Link temp = first;          // save reference to link<br />&#160;&#160;&#160;&#160;&#160;&#160;first = first.next;         // delete it: first--&gt;old next<br />&#160;&#160;&#160;&#160;&#160;&#160;return temp.dData;          // return deleted link<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void displayList()<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;Link current = first;       // start at beginning of list<br />&#160;&#160;&#160;&#160;&#160;&#160;while(current != null)      // until end of list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current.displayLink();   // print data<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;  // move to next link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;}  // end class LinkList<br />////////////////////////////////////////////////////////////////<br />class LinkStack<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;private LinkList theList;<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public LinkStack()             // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;theList = new LinkList();<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public void push(long j)     // put item on top of stack<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;theList.insertFirst(j);<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public long pop()            // take item from top of stack<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;return theList.deleteFirst();<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public boolean isEmpty()       // true if stack is empty<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;return ( theList.isEmpty() );<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public void displayStack()<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;Stack (top--&gt;bottom): &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;theList.displayList();<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;}  // end class LinkStack<br />#+END_SRC</p></body>
</html>
</richcontent>
</node>
</node>
</node>
<node text="&#x7528;&#x94fe;&#x8868;&#x5b9e;&#x73b0;&#x7684;&#x961f;&#x5217;" folded="true">
<node text="&#x4f8b;&#x5b50;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>#+BEGIN_SRC java<br />&#160;&#160;class LinkQueue<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;private FirstLastList theList;<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public LinkQueue()                // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{ theList = new FirstLastList(); }  // make a 2-ended list<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public boolean isEmpty()          // true if queue is empty<br />&#160;&#160;&#160;&#160;&#160;&#160;{ return theList.isEmpty(); }<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public void insert(long j)        // insert, rear of queue<br />&#160;&#160;&#160;&#160;&#160;&#160;{ theList.insertLast(j); }<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public long remove()              // remove, front of queue<br />&#160;&#160;&#160;&#160;&#160;&#160;{  return theList.deleteFirst();  }<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public void displayQueue()<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;Queue (front--&gt;rear): &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;theList.displayList();<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;}  // end class LinkQueue<br />#+END_SRC</p></body>
</html>
</richcontent>
</node>
</node>
</node>
</node>
<node text="&#x6709;&#x5e8f;&#x94fe;&#x8868;" folded="true">
<node text="&#x7279;&#x70b9;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x6570;&#x636e;&#x6309;&#x7167;&#x5173;&#x952e;&#x503c;&#x6709;&#x5e8f;&#x6392;&#x5217;</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x63d2;&#x5165;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x4f8b;&#x5b50;<br />#+BEGIN_SRC java<br /># &#x63d2;&#x5165;&#x4e0e;&#x65e0;&#x5e8f;&#x94fe;&#x8868;&#x4e0d;&#x540c;<br />&#160;&#160;public void insert(long key)        // insert, in order<br />&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(key);    // make new link<br />&#160;&#160;&#160;&#160;&#160;Link previous = null;            // start at first<br />&#160;&#160;&#160;&#160;&#160;Link current = first;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;// until end of list,<br /># &#x5982;&#x679c;&#x63d2;&#x5165;&#x7684;&#x503c;&#x6bd4;&#x5f53;&#x524d;&#x94fe;&#x63a5;&#x7684;&#x503c;&#x8981;&#x5927;,&#x5219;&#x6bd4;&#x8f83;&#x4e0b;&#x4e00;&#x4e2a;&#x4f4d;&#x7f6e;&#x7684;&#x503c;<br />&#160;&#160;&#160;&#160;&#160;while(current != null &amp;&amp; key &gt; current.dData)<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{                             // or key &gt; current,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;previous = current;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;       // go to next item<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br /># &#x5982;&#x679c;&#x5f53;&#x524d;&#x94fe;&#x63a5;&#x70b9;&#x4e3a;&#x7a7a;,&#x5219;&#x5c06;&#x65b0;&#x94fe;&#x63a5;&#x70b9;&#x6dfb;&#x52a0;&#x5230;&#x94fe;&#x8868;&#x4e2d;<br />&#160;&#160;&#160;&#160;&#160;if(previous==null)               // at beginning of list<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;first = newLink;              // first --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;else                             // not at beginning<br /># &#x5982;&#x679c;&#x5f53;&#x524d;&#x94fe;&#x63a5;&#x70b9;&#x975e;&#x7a7a;,&#x5219;&#x5c06;&#x524d;&#x4e00;&#x4f4d;&#x7f6e;&#x6307;&#x5411;&#x65b0;&#x94fe;&#x63a5;&#x70b9;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;previous.next = newLink;      // old prev --&gt; newLink<br /># &#x65b0;&#x94fe;&#x63a5;&#x70b9;&#x6307;&#x5411;&#x5f53;&#x524d;&#x4f4d;&#x7f6e;&#x7684;&#x94fe;&#x63a5;&#x70b9;<br />&#160;&#160;&#160;&#160;&#160;newLink.next = current;          // newLink --&gt; old currnt<br />&#160;&#160;&#160;&#160;&#160;}  // end insert()<br />#+END_SRC</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x6548;&#x7387;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x63d2;&#x5165;&#x548c;&#x5220;&#x9664;&#x64cd;&#x4f5c;&#x9700;&#x8981;O(N)&#x6b21;&#x6bd4;&#x8f83;</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x8868;&#x63d2;&#x5165;&#x6392;&#x5e8f;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x5c06;&#x4e00;&#x4e2a;&#x65e0;&#x5e8f;&#x6570;&#x7ec4;&#x63d2;&#x5165;&#x4e00;&#x4e2a;&#x6709;&#x5e8f;&#x94fe;&#x8868;&#x4e2d;,&#x518d;&#x5220;&#x9664;,&#x5c06;&#x6bcf;&#x4e2a;&#x5143;&#x7d20;&#x4f9d;&#x6b21;&#x653e;&#x5165;&#x6570;&#x7ec4;&#x4e2d;</p></body>
</html>
</richcontent>
</node>
</node>
</node>
<node text="&#x53cc;&#x5411;&#x94fe;&#x8868;" folded="true">
<node text="&#x7279;&#x70b9;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x89e3;&#x51b3;&#x53cd;&#x5411;&#x904d;&#x5386;&#x7684;&#x95ee;&#x9898;</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x4f8b;&#x5b50;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>#+BEGIN_SRC java<br />&#160;&#160;class DoublyLinkedList<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;private Link first;               // ref to first item<br />&#160;&#160;&#160;private Link last;                // ref to last item<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public DoublyLinkedList()         // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;first = null;                  // no items on list yet<br />&#160;&#160;&#160;&#160;&#160;&#160;last = null;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public boolean isEmpty()          // true if no links<br />&#160;&#160;&#160;&#160;&#160;&#160;{ return first==null; }<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void insertFirst(long dd)  // insert at front of list<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(dd);   // make new link</p><p>&#160;&#160;&#160;&#160;&#160;&#160;if( isEmpty() )                // if empty list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;last = newLink;             // newLink &lt;-- last<br />&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;first.previous = newLink;   // newLink &lt;-- old first<br />&#160;&#160;&#160;&#160;&#160;&#160;newLink.next = first;          // newLink --&gt; old first<br />&#160;&#160;&#160;&#160;&#160;&#160;first = newLink;               // first --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void insertLast(long dd)   // insert at end of list<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(dd);   // make new link<br />&#160;&#160;&#160;&#160;&#160;&#160;if( isEmpty() )                // if empty list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;first = newLink;            // first --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;last.next = newLink;        // old last --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;newLink.previous = last;    // old last &lt;-- newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;last = newLink;                // newLink &lt;-- last<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public Link deleteFirst()         // delete first link<br />&#160;&#160;&#160;&#160;&#160;&#160;{                              // (assumes non-empty list)<br />&#160;&#160;&#160;&#160;&#160;&#160;Link temp = first;<br />&#160;&#160;&#160;&#160;&#160;&#160;if(first.next == null)         // if only one item<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;last = null;                // null &lt;-- last<br />&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;first.next.previous = null; // null &lt;-- old next<br />&#160;&#160;&#160;&#160;&#160;&#160;first = first.next;            // first --&gt; old next<br />&#160;&#160;&#160;&#160;&#160;&#160;return temp;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public Link deleteLast()          // delete last link<br />&#160;&#160;&#160;&#160;&#160;&#160;{                              // (assumes non-empty list)<br />&#160;&#160;&#160;&#160;&#160;&#160;Link temp = last;<br />&#160;&#160;&#160;&#160;&#160;&#160;if(first.next == null)         // if only one item<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;first = null;               // first --&gt; null<br />&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;last.previous.next = null;  // old previous --&gt; null<br />&#160;&#160;&#160;&#160;&#160;&#160;last = last.previous;          // old previous &lt;-- last<br />&#160;&#160;&#160;&#160;&#160;&#160;return temp;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;// insert dd just after key<br />&#160;&#160;&#160;public boolean insertAfter(long key, long dd)<br />&#160;&#160;&#160;&#160;&#160;&#160;{                              // (assumes non-empty list)<br />&#160;&#160;&#160;&#160;&#160;&#160;Link current = first;          // start at beginning<br />&#160;&#160;&#160;&#160;&#160;&#160;while(current.dData != key)    // until match is found,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;     // move to next link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if(current == null)<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return false;            // didn't find it<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(dd);   // make new link</p><p>&#160;&#160;&#160;&#160;&#160;&#160;if(current==last)              // if last link,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;newLink.next = null;        // newLink --&gt; null<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;last = newLink;             // newLink &lt;-- last<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;else                           // not last link,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;newLink.next = current.next; // newLink --&gt; old next<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;// newLink &lt;-- old next<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current.next.previous = newLink;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;newLink.previous = current;    // old current &lt;-- newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;current.next = newLink;        // old current --&gt; newLink<br />&#160;&#160;&#160;&#160;&#160;&#160;return true;                   // found it, did insertion<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public Link deleteKey(long key)   // delete item w/ given key<br />&#160;&#160;&#160;&#160;&#160;&#160;{                              // (assumes non-empty list)<br />&#160;&#160;&#160;&#160;&#160;&#160;Link current = first;          // start at beginning<br />&#160;&#160;&#160;&#160;&#160;&#160;while(current.dData != key)    // until match is found,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;     // move to next link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if(current == null)<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return null;             // didn't find it<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;if(current==first)             // found it; first item?<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;first = current.next;       // first --&gt; old next<br />&#160;&#160;&#160;&#160;&#160;&#160;else                           // not first<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;// old previous --&gt; old next<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current.previous.next = current.next;</p><p>&#160;&#160;&#160;&#160;&#160;&#160;if(current==last)              // last item?<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;last = current.previous;    // old previous &lt;-- last<br />&#160;&#160;&#160;&#160;&#160;&#160;else                           // not last<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;// old previous &lt;-- old next<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current.next.previous = current.previous;<br />&#160;&#160;&#160;&#160;&#160;&#160;return current;                // return value<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void displayForward()<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;List (first--&gt;last): &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;Link current = first;          // start at beginning<br />&#160;&#160;&#160;&#160;&#160;&#160;while(current != null)         // until end of list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current.displayLink();      // display data<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;     // move to next link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;public void displayBackward()<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;List (last--&gt;first): &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;Link current = last;           // start at end<br />&#160;&#160;&#160;&#160;&#160;&#160;while(current != null)         // until start of list,<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current.displayLink();      // display data<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.previous; // move to previous link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />// -------------------------------------------------------------<br />&#160;&#160;&#160;}<br />#+END_SRC</p></body>
</html>
</richcontent>
</node>
</node>
</node>
<node text="&#x8fed;&#x4ee3;&#x5668;" folded="true">
<node text="&#x4f5c;&#x7528;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>- &#x904d;&#x5386;&#x94fe;&#x8868;</p></body>
</html>
</richcontent>
</node>
</node>
<node text="&#x4f8b;&#x5b50;">
<node style="bubble" background_color="#eeee00">
<richcontent TYPE="NODE"><html>
<head>
<style type="text/css">
<!--
p { margin-top: 3px; margin-bottom: 3px; }-->
</style>
</head>
<body>
<p>#+BEGIN_SRC java<br />&#160;class ListIterator<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;private Link current;          // current link<br />&#160;&#160;&#160;private Link previous;         // previous link<br />&#160;&#160;&#160;private LinkList ourList;      // our linked list<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public ListIterator(LinkList list) // constructor<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;ourList = list;<br />&#160;&#160;&#160;&#160;&#160;&#160;reset();<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public void reset()            // start at 'first'<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;current = ourList.getFirst();<br />&#160;&#160;&#160;&#160;&#160;&#160;previous = null;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public boolean atEnd()         // true if last link<br />&#160;&#160;&#160;&#160;&#160;&#160;{ return (current.next==null); }<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public void nextLink()         // go to next link<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;previous = current;<br />&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public Link getCurrent()       // get current link<br />&#160;&#160;&#160;&#160;&#160;&#160;{ return current; }<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public void insertAfter(long dd)     // insert after<br />&#160;&#160;&#160;&#160;&#160;&#160;{                                 // current link<br />&#160;&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(dd);</p><p>&#160;&#160;&#160;&#160;&#160;&#160;if( ourList.isEmpty() )     // empty list<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;ourList.setFirst(newLink);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = newLink;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;else                        // not empty<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;newLink.next = current.next;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current.next = newLink;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;nextLink();              // point to new link<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public void insertBefore(long dd)    // insert before<br />&#160;&#160;&#160;&#160;&#160;&#160;{                                 // current link<br />&#160;&#160;&#160;&#160;&#160;&#160;Link newLink = new Link(dd);</p><p>&#160;&#160;&#160;&#160;&#160;&#160;if(previous == null)        // beginning of list<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{                        // (or empty list)<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;newLink.next = ourList.getFirst();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;ourList.setFirst(newLink);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;reset();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;else                        // not beginning<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;newLink.next = previous.next;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;previous.next = newLink;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = newLink;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public long deleteCurrent()    // delete item at current<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;long value = current.dData;<br />&#160;&#160;&#160;&#160;&#160;&#160;if(previous == null)        // beginning of list<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;ourList.setFirst(current.next);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;reset();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;else                        // not beginning<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;previous.next = current.next;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if( atEnd() )<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;reset();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;current = current.next;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;return value;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;}<br />#+END_SRC<br />- &#x8fed;&#x4ee3;&#x5668;&#x7684;&#x4f7f;&#x7528;<br />&#160;&#160;+ &#x4f8b;&#x5b50;<br />#+BEGIN_SRC java<br />&#160;class InterIterApp<br />&#160;&#160;&#160;{<br />&#160;&#160;&#160;public static void main(String[] args) throws IOException<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;LinkList theList = new LinkList();           // new list<br />&#160;&#160;&#160;&#160;&#160;&#160;ListIterator iter1 = theList.getIterator();  // new iter<br />&#160;&#160;&#160;&#160;&#160;&#160;long value;</p><p>&#160;&#160;&#160;&#160;&#160;&#160;iter1.insertAfter(20);             // insert items<br />&#160;&#160;&#160;&#160;&#160;&#160;iter1.insertAfter(40);<br />&#160;&#160;&#160;&#160;&#160;&#160;iter1.insertAfter(80);<br />&#160;&#160;&#160;&#160;&#160;&#160;iter1.insertBefore(60);</p><p>&#160;&#160;&#160;&#160;&#160;&#160;while(true)<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;Enter first letter of show, reset, &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;next, get, before, after, delete: &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.flush();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;int choice = getChar();         // get user's option<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;switch(choice)<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;case 's':                    // show list<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if( !theList.isEmpty() )<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;theList.displayList();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;List is empty&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;break;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;case 'r':                    // reset (to first)<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;iter1.reset();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;break;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;case 'n':                    // advance to next item<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if( !theList.isEmpty() &amp;&amp; !iter1.atEnd() )<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;iter1.nextLink();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;Can't go to next link&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;break;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;case 'g':                    // get current item<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if( !theList.isEmpty() )<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;value = iter1.getCurrent().dData;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;Returned &quot; + value);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;List is empty&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;break;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;case 'b':                    // insert before current<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;Enter value to insert: &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.flush();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;value = getInt();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;iter1.insertBefore(value);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;break;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;case 'a':                    // insert after current<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.print(&quot;Enter value to insert: &quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.flush();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;value = getInt();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;iter1.insertAfter(value);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;break;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;case 'd':                    // delete current item<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if( !theList.isEmpty() )<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;value = iter1.deleteCurrent();<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;Deleted &quot; + value);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;else<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;Can't delete&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;break;<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;default:<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;System.out.println(&quot;Invalid entry&quot;);<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}  // end switch<br />&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}  // end while<br />&#160;&#160;&#160;&#160;&#160;&#160;}  // end main()<br />//--------------------------------------------------------------<br />&#160;&#160;&#160;public static String getString() throws IOException<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;InputStreamReader isr = new InputStreamReader(System.in);<br />&#160;&#160;&#160;&#160;&#160;&#160;BufferedReader br = new BufferedReader(isr);<br />&#160;&#160;&#160;&#160;&#160;&#160;String s = br.readLine();<br />&#160;&#160;&#160;&#160;&#160;&#160;return s;<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//-------------------------------------------------------------<br />&#160;&#160;&#160;public static char getChar() throws IOException<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;String s = getString();<br />&#160;&#160;&#160;&#160;&#160;&#160;return s.charAt(0);<br />&#160;&#160;&#160;&#160;&#160;&#160;}</p><p>//-------------------------------------------------------------<br />&#160;&#160;&#160;public static int getInt() throws IOException<br />&#160;&#160;&#160;&#160;&#160;&#160;{<br />&#160;&#160;&#160;&#160;&#160;&#160;String s = getString();<br />&#160;&#160;&#160;&#160;&#160;&#160;return Integer.parseInt(s);<br />&#160;&#160;&#160;&#160;&#160;&#160;}<br />//-------------------------------------------------------------<br />&#160;&#160;&#160;} <br />#+END_SRC</p></body>
</html>
</richcontent>
</node>
</node>
</node>
</node>
</map>
