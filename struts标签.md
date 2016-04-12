%toc
struts��5����ǩ��
## html ##
### ���� ###
�����ܹ���struts���ܺ�������Ӧ��Html��ǩ������html��������
### ʹ�ù̶��������Ƶ�Struts ��ǩ ###
#### id ####
�����Զ�����ǩ����ʱ�Ľű�������
#### name ####
> - ָ�����ؼ���ֵ��bean
#### property ####
#### scope ####
## bean ##
### ���� ###
�ڷ���javaBeans���������Լ�����һ���µ�beanʱʹ��
## logic ##
### ���� ###
�������������������Ͷ��󼯲�����ѭ��
## template ##
### ���� ###
tiles���ܰ��Ѽ�ȡ��
## nested ##
### ���� ###
��ǿ��������struts��ǩ��Ƕ��ʹ�õ�����
## html:multibox ##
### �÷� ###
#### ҳ�� ####
{{{class="brush: jsp"
> 

&lt;html:form action="/checkbox.do" method="post"&gt;


> > 

&lt;html:multibox property="checkList" value="001"/&gt;

001<br />
> > 

&lt;html:multibox property="checkList" value="002"/&gt;

002<br />
> > 

&lt;html:multibox property="checkList" value="003"/&gt;

003<br />
> > 

&lt;html:submit /&gt;

<br />
> > 

&lt;/html:form&gt;

}}}
==== action���� ====

```