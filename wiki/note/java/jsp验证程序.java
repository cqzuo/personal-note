js�Ƚϳ��õ���֤���� 
//�жϿؼ��Ŀɼ���
function isControlVisible(handle) {
var retValue = true;
while(handle.tagName.toLowerCase()!='form' && handle.style.display.toLowerCase()!='none') {
  handle = handle.parentElement;
}
if(handle.style.display=='none') retValue = false;
return retValue;
}

//================����Ϊϵͳ������=======================//

//����Ϊ����������������ݼ�ʱ��֤����
//��������������
function inputNumber(handle,keyCode) {
if(!((keyCode>=48&&keyCode<=57)||(keyCode>=96&&keyCode<=105))) {
     window.event.returnValue=false;
     return "������������!�������ַ�:<br>1234567890";
} else return true;
}

//����������ĸ
function inputLetter(handle,keyCode) {
if(!((keyCode>=97&&keyCode<=122)||(keyCode>=65&&keyCode<=90))) {
     window.event.returnValue=false;
     return "���������Сд��ĸ!�������ַ�:<br>abcdefghijklmnopqrstuvwxyz<br>ABCDEFGHIJKLMNOPQRSTUVWXYZ";
} else return true;
}

//�����������пɼ��ַ�
function inputVisible(handle,keyCode) {
     var pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.@><,-[]{}?/+=|\\\'\":;~!#$%()`";
     var keyValue=String.fromCharCode(keyCode);
     if(keyCode==190) keyValue = ".";
     if(keyCode==189) keyValue = "-";
     if(keyCode==188) keyValue = "<";
     if(keyCode==219) keyValue = "[";
     if(keyCode==221) keyValue = "]";
     if(keyCode==191) keyValue = "?";
     if(keyCode==187) keyValue = "+";
     if(keyCode==220) keyValue = "|";
     if(keyCode==222) keyValue = "'";
     if(keyCode==186) keyValue = ";";
     if(keyCode==192) keyValue = "~";
     if(pattern.indexOf(keyValue)!=-1) {
           window.event.returnValue=true;
           return true;
     }else{
           window.event.returnValue=false;
           return "��������ɼ��ַ�!�������ַ�:<br>ABCDEFGHIJKLMNOPQRSTUVWXYZ<br>abcdefghijklmnopqrstuvwxyz<br>0123456789.@><,-[]{}?/+=|\\\'\":<br>;~!#$%()`";
     }
}
//����������ĸ������
function inputNormal(handle,keyCode) {
     var pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
     var keyValue=String.fromCharCode(keyCode);
     if(pattern.indexOf(keyValue)!=-1) {
           window.event.returnValue=true;
           return true;
     }else{
           window.event.returnValue=false;
           return "��������ɼ��ַ�!�������ַ�:<br>ABCDEFGHIJKLMNOPQRSTUVWXYZ<br>abcdefghijklmnopqrstuvwxyz<br>0123456789";
     }
}

//================����ΪУ�麯����=======================//
//������˵��:is+TypeName,TypeName����ĸ��д
//����handleΪ��ǰ�ؼ����
//����keyCodeΪ��ǰ��ť��ֵ
//����˵��:ͨ������"",��ͨ�����ز�ͨ����ԭ������
/*��ʽ֧������
��ʽ�ַ�       ��ʽ����     ��ʽ˵��
Number         ������
Userid         �û�ID
Username       �û�����
Enterprisename   ��ҵ��λ����
Loginname       ��¼����
Cardnumber       ֤������
Address         ��ַ
Phone         �绰����
Mobile         �ֻ�����
Postcode       ��������
Email         �����ʼ�
Namesimplicity   ������ƴ
Password       ����
Namestr         �����ַ���
DescStr         �����ַ���
Pageurl         ҳ��URL
Dirctory       ����·��
*/

  //�ж��Ƿ�����ȷ�ĵ�λID
     function isOrganizationId(handle){
           var pattern = /^(\d){16,16}$/;
           if (!pattern.exec(handle.value)){
           handle.value=''
           return "��������16λ����!";}
           return true;
     }
     
        //�ж��Ƿ�������
     function isNumber(handle){
           var pattern = /^(\d){1,16}$/;
           if (!pattern.exec(handle.value)){
           handle.value=''
           return "������������!";}
           return true;
     }
     
  //�ж��Ƿ����û��˺�
     function isUserid(handle){
           var pattern = /^(\d|\w){3,14}$/;
           if (!pattern.exec(handle.value)) return "������������<br>�ҳ�������ڵ���3λС�ڵ���14λ!";
           return true;
     }
     
  //�ж��Ƿ��û����ƿ�������ĸҲ����������
     function isUsername(handle){
           var pattern = /^[a-zA-Z\u4E00-\u9FA5]{2,50}$/;
           if (!pattern.exec(handle.value)) return "������������ĸ��������<br>�ҳ�������ڵ���2λС�ڵ���50λ!"
           return true;
  }
  
  //�ж��Ƿ�������:��������ĸ ���� ���� - _
  function isName(handle){
    var pattern =/^[a-zA-Z0-9-_\u4E00-\u9FA5]{1,30}$/;
    if (!pattern.exec(handle.value)) return "������������ĸ��������!";
    return true;
  }


  //�ж��Ƿ��ǲ˵�����:��������ĸ ���� ���� - _
  function isMenuname(handle){
    var pattern = /^[a-zA-Z0-9-_\u4E00-\u9FA5]{2,200}$/;
    if (!pattern.exec(handle.value)){ return "������������ĸ��������<br>�ҳ�������ڵ���2λС�ڵ���40λ!";
    handle.value=''
    }return true;
  }
  
  //�ж��Ƿ��ǵ�¼����
  function isLoginname(handle){
    var pattern = /^([a-z]|[A-Z]|[0-9]){2,25}$/;
    if (!pattern.exec(handle.value)) return "��������ĸ��������<br>�ҳ�������ڵ���2λС�ڵ���25λ!";
    return true;
     }
     
  //�ж��Ƿ���֤������
     function isCardnumber(handle){
           var pattern;
           pattern = /^(\d){5,18}$/;
           if (!pattern.exec(handle.value)) return "����������<br>�ҳ�������ڵ���5λС�ڵ���16λ!";
           return true;
     }
     
  //��ַ
     function isAddress(handle){
           var pattern = /^[a-zA-Z0-9\u4E00-\u9FA5]{2,200}$/;
           if (!pattern.exec(handle.value)) return "������������ĸ��������<br>�ҳ�������ڵ���2λС�ڵ���200λ!";
           return true;
     }
     
  //�жϵ绰�����Ƿ���ȷ
     function isPhone(handle){
           var pattern = /^(\d){6,30}$/;
           if (!pattern.exec(handle.value)) return "����������<br>�ҳ�������ڵ���6λС�ڵ���30λ!";
           return true;
     }
     
  //�ж��ʱ��Ƿ���Ϲ涨
     function isPostcode(handle){
           var pattern = /^(\d){6}$/;
           if (!pattern.exec(handle.value)) return "����������<br>�ҳ�������6λ!";
           return true;
     }
     
  //�ж��Ƿ���email��ȷ��ʽ
     function isEmail(handle){
           var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
           if (!pattern.exec(handle.value)) return "������ϵ����ʼ���ַ��ʽ";
           return true;
     }
     
  //��ƴ
     function isNamesimplicity(handle){
           var pattern = /^([a-zA-Z]){2,25}$/;
           if (!pattern.exec(handle.value)) return "��������ĸ<br>�ҳ�������ڵ���2λС�ڵ���25λ!";
           return true;
     }
     
  //�ж����������Ƿ���ȷ
     function isPassword(handle){
           var pattern = /^([a-zA-Z]|[0-9]){2,25}$/;
           if (!pattern.exec(handle.value)) return "��������ĸ��������<br>�ҳ�������ڵ���2λС�ڵ���25λ!";
           return true;
     }
  
  //�ж��Ƿ���������Ϣ:��������ĸ ���� ���� - _ , .
  function isDescstr(handle){
    var pattern = /^[a-zA-Z0-9-_,.\u4E00-\u9FA5]{1,50}$/;
    if (!pattern.exec(handle.value)) return "������������ĸ��������<br>�ҳ�������ڵ���1λС�ڵ���50λ!";
    return true;
  }

  //�ж�ҳ��URL�Ƿ���ȷ
  function isPageurl(handle){
    var pattern = /^[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
    if (!pattern.exec(handle.value)){
      return "��������ȷ��URL��ʽ������a.do?b=1&c=2";
      handle.value=''
    }
    return true;
  }
  
  //�жϰ汾���Ƿ���ȷ(��һ��Ϊ���֣����������.��������)
  function isVersion(handle){
      var pattern = /^\d{1}+[0-9-.]*$/;
      if (!pattern.exec(handle.value)){
      return "��������ȷ�İ汾��ʽ������1.234";
      handle.value=''
    }
    return true;
  }

  //�ж�ϵͳID�Ƿ���ȷ(ϵͳIDֻ������������ĸ�����)
  function isSysId(handle){
      var pattern = /^\w{1,10}$/;
      if (!pattern.exec(handle.value)){
      return "��������ĸ��������<br>�ҳ�������ڵ���1λС�ڵ���10λ!";
      handle.value=''
    }
    return true;
  }


  //�ж�Ŀ¼·���Ƿ���ȷ
  function isDirctoryurl(handle){
    var pattern = /^[a-zA-Z0-9-_,.\\u4E00-\u9FA5]{1,300}$/;
    if (!pattern.exec(handle.value)) return "������������ĸ��������<br>�ҳ�������ڵ���1λС�ڵ���300λ!";
    return true;
  }
 
