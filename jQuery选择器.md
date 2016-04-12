%toc
# ѡ���� #
## ���� ##
  1. 4�л�������
> > - id
> > > - #
> > > - ���ݸ�����IDƥ��һ��Ԫ��
> > > - ����

> {{{class="brush: js"
> > <div><p>id="notMe"</p></div>
> > <div>id="myDiv"</div>
> > $("#myDiv"); }}}
  - element
   - ���ݸ�����Ԫ����ƥ������Ԫ��
   - ����
 {{{class="brush: js"
<div>DIV1</div>
<div>DIV2</div>
<span>SPAN</span>
$("div");
 }}}
  - class
   - .
   - ���ݸ�������ƥ��Ԫ��
   - ����
 {{{class="brush: js"
<div class="notMe">div class="notMe"</div>
<div class="myClass">div class="myClass"</div>
<span class="myClass">span class="myClass"</span>
$(".myClass");
 }}}
  - ����
   - ƥ������Ԫ��  
== �㼶 ==
 # ancester desendant
  - �ڸ���������Ԫ����ƥ�����еĺ���Ԫ��
  - $("form input")
 # parent>child
  - �ڸ����ĸ�Ԫ����ƥ�����е���Ԫ��
  - $("form > input")
 # prev+next
  - ƥ�����н����� prev Ԫ�غ��� next Ԫ��
  - $("label + input")
 # prev~siblings
  - ƥ�� prev Ԫ��֮�������� siblings Ԫ��
  - $("form ~ input")
== ���� ==
 # :first
  - ��һ��Ԫ��
 # :last
  - ����һ��Ԫ��
 # :not
  - ȥ������������ѡ����ƥ����Ԫ��
  - ����:��ȡδѡ�е�Ԫ��
 {{{class="brush: js"
<input name="apple" />
<input name="flower" checked="checked" />
$("input:not(:checked)")
 }}}
 # :even
  - ����Ϊż��
 # :odd
  - ����Ϊ����
 # :eq
  - ƥ������
 # :gt
  - ����
 # :lt
  - С��
 # :header
  - ����Ԫ��
 # :animated
  - ����ִ�еĶ���Ч��
  - ���� ��δִ�еĶ���ʩ��һ����Ч
 {{{class="brush: js"
 <button id="run">Run</button><div></div>
  $("#run").click(function(){
  $("div:not(:animated)").animate({ left: "+=20" }, 1000);
 });
 }}}
== ����ƥ�� ==
 # :contains
  - ƥ�������ı���Ԫ��
  - ���� ƥ�京��"John"��div
 {{{class="brush: js"
<div>John Resig</div>
<div>George Martin</div>
<div>Malcom John Sinclair</div>
<div>J. Ohn
$("div:contains('John')")
 }}}
 # :empty
  - ��������Ԫ�ػ��ı�Ԫ��
 # :has
  - ����ָ��Ԫ�ص�Ԫ��
 # :parent
  - ������Ԫ�ػ��ı�Ԫ��
== �ɼ��� ==
 # :hiden
 # :visible
== ���� ==
 # [attribute]
  - ƥ�京�и����Ե�Ԫ��
 # [attribute=value]
  - ����Ϊָ��ֵ
 # [atu!=value]
  - ����Ϊָ��ֵ
 # [attribute^=value]
  - ��ʼ
 # [attribute$=value]
  - ��β
 # [attribute*=value]
  - ��������
 # [selector1][selector2]...
  - ͬʱ������������
== ��Ԫ�� ==
 # :nth-child
  - ƥ��ָ��Ԫ�ظ���
 # :first-child
  - ��һ��Ԫ��
 # :last-child
  - ����һ��Ԫ��
 # :only-child
  - Ψһƥ��ֵ
== ���� ==
 # ��������Ԫ��
  - :input
  - :text
  - :password
  - :radio
  - :checkbox
  - :submit
  - :image
  - :reset
  - :button
  - :file
  - :hidden
== ������������ ==
 # :enable
  - ����
 # :disable
  - ������
 # :checked
  - ��ѡ����(������select)
 # :selected
  - select��ѡ�е�
```