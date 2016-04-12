%toc
# jQuery���� #
## ���ķ��� ##
  1. jQuery(expression, [context](context.md))
> > - ����һ������cssѡ�������ַ�����ƥ��һ��Ԫ��
> > - ��дΪ$()
> > - ����ָ������������ȥ����ƥ����Ϣ
> > - ����:���ҵ�һ��form�е�radioԪ��
> > {{{class="brush: js"
> > > $("input:radio",document.forms[0](0.md)) }}}
 # jQueryjQuery(html, [ownerDocument])
  - �����ṩ��ԭʼHTML�����ַ���,��̬������jQuery������װ��DOMԪ��
  - ����html�ַ�������"�ַ�,��ת��\
  - ����
 {{{class="brush: js"
 $("<li><div id=\"gname\">���ǲ���</div></li>").appendTo("form");
 }}}
 # jQuery(html, props)
  - �����ṩ��ԭʼ HTML �����ַ�������̬������ jQuery ������װ�� DOM Ԫ�ء�ͬʱ����һϵ�е����ԡ��¼���
  - ����:��form������һ��text���͵�input��ǩ,�����þ۽����뽹ʱ�ķ���
 {{{class="brush: js"
$("<input>", {
  type: "text",
  val: "Test",
  focusin: function() {
    $(this).addClass("active");
  },
  focusout: function() {
    $(this).removeClass("active");
  }
}).appendTo("form"); 
 }}}
 # jQuery(elements)
  - ��һ��������DOMԪ��ת��ΪjQuery����
  - ����Ϊָ����Ԫ������css
 {{{class="brush: js"
 $(document.body).css( "background", "black" );
 }}}
 # jQuery(callback)
  - $(document).ready()�ļ�д
  - ����functionΪ��DOM�������ɺ�Ҫִ�еĺ���
  - ����
 {{{class="brush: js"
 $(document).ready(function(){
    $("<li><div id=\"gname\">���ǲ���</div></li>").appendTo("form");
   });
 }}}
```