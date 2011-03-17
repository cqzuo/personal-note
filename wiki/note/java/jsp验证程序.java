js比较常用的验证程序 
//判断控件的可见性
function isControlVisible(handle) {
var retValue = true;
while(handle.tagName.toLowerCase()!='form' && handle.style.display.toLowerCase()!='none') {
  handle = handle.parentElement;
}
if(handle.style.display=='none') retValue = false;
return retValue;
}

//================以上为系统函数区=======================//

//以下为输入过程中输入内容即时验证函数
//必须输入是数字
function inputNumber(handle,keyCode) {
if(!((keyCode>=48&&keyCode<=57)||(keyCode>=96&&keyCode<=105))) {
     window.event.returnValue=false;
     return "必须输入数字!即如下字符:<br>1234567890";
} else return true;
}

//必须输入字母
function inputLetter(handle,keyCode) {
if(!((keyCode>=97&&keyCode<=122)||(keyCode>=65&&keyCode<=90))) {
     window.event.returnValue=false;
     return "必须输入大小写字母!即如下字符:<br>abcdefghijklmnopqrstuvwxyz<br>ABCDEFGHIJKLMNOPQRSTUVWXYZ";
} else return true;
}

//必须输入所有可见字符
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
           return "必须输入可见字符!即如下字符:<br>ABCDEFGHIJKLMNOPQRSTUVWXYZ<br>abcdefghijklmnopqrstuvwxyz<br>0123456789.@><,-[]{}?/+=|\\\'\":<br>;~!#$%()`";
     }
}
//必须输入字母与数字
function inputNormal(handle,keyCode) {
     var pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
     var keyValue=String.fromCharCode(keyCode);
     if(pattern.indexOf(keyValue)!=-1) {
           window.event.returnValue=true;
           return true;
     }else{
           window.event.returnValue=false;
           return "必须输入可见字符!即如下字符:<br>ABCDEFGHIJKLMNOPQRSTUVWXYZ<br>abcdefghijklmnopqrstuvwxyz<br>0123456789";
     }
}

//================以下为校验函数区=======================//
//函数名说明:is+TypeName,TypeName首字母大写
//参数handle为当前控件句柄
//参数keyCode为当前按钮的值
//返回说明:通过返回"",不通过返回不通过的原因描述
/*格式支持例表
格式字符       格式描述     格式说明
Number         数字型
Userid         用户ID
Username       用户名称
Enterprisename   企业单位名称
Loginname       登录名称
Cardnumber       证件号码
Address         地址
Phone         电话号码
Mobile         手机号码
Postcode       邮政编码
Email         电子邮件
Namesimplicity   姓名简拼
Password       密码
Namestr         名称字符串
DescStr         描述字符串
Pageurl         页面URL
Dirctory       磁盘路径
*/

  //判断是否是正确的单位ID
     function isOrganizationId(handle){
           var pattern = /^(\d){16,16}$/;
           if (!pattern.exec(handle.value)){
           handle.value=''
           return "必须输入16位数字!";}
           return true;
     }
     
        //判断是否是数字
     function isNumber(handle){
           var pattern = /^(\d){1,16}$/;
           if (!pattern.exec(handle.value)){
           handle.value=''
           return "必须输入数字!";}
           return true;
     }
     
  //判断是否是用户账号
     function isUserid(handle){
           var pattern = /^(\d|\w){3,14}$/;
           if (!pattern.exec(handle.value)) return "必须输入数字<br>且长度需大于等于3位小于等于14位!";
           return true;
     }
     
  //判断是否用户名称可以是字母也可以是中文
     function isUsername(handle){
           var pattern = /^[a-zA-Z\u4E00-\u9FA5]{2,50}$/;
           if (!pattern.exec(handle.value)) return "必须是中文字母或者数字<br>且长度需大于等于2位小于等于50位!"
           return true;
  }
  
  //判断是否是名称:可以是字母 数字 中文 - _
  function isName(handle){
    var pattern =/^[a-zA-Z0-9-_\u4E00-\u9FA5]{1,30}$/;
    if (!pattern.exec(handle.value)) return "必须是中文字母或者数字!";
    return true;
  }


  //判断是否是菜单名称:可以是字母 数字 中文 - _
  function isMenuname(handle){
    var pattern = /^[a-zA-Z0-9-_\u4E00-\u9FA5]{2,200}$/;
    if (!pattern.exec(handle.value)){ return "必须是中文字母或者数字<br>且长度需大于等于2位小于等于40位!";
    handle.value=''
    }return true;
  }
  
  //判断是否是登录名称
  function isLoginname(handle){
    var pattern = /^([a-z]|[A-Z]|[0-9]){2,25}$/;
    if (!pattern.exec(handle.value)) return "必须是字母或者数字<br>且长度需大于等于2位小于等于25位!";
    return true;
     }
     
  //判断是否是证件号码
     function isCardnumber(handle){
           var pattern;
           pattern = /^(\d){5,18}$/;
           if (!pattern.exec(handle.value)) return "必须是数字<br>且长度需大于等于5位小于等于16位!";
           return true;
     }
     
  //地址
     function isAddress(handle){
           var pattern = /^[a-zA-Z0-9\u4E00-\u9FA5]{2,200}$/;
           if (!pattern.exec(handle.value)) return "必须是中文字母或者数字<br>且长度需大于等于2位小于等于200位!";
           return true;
     }
     
  //判断电话号码是否正确
     function isPhone(handle){
           var pattern = /^(\d){6,30}$/;
           if (!pattern.exec(handle.value)) return "必须是数字<br>且长度需大于等于6位小于等于30位!";
           return true;
     }
     
  //判断邮编是否符合规定
     function isPostcode(handle){
           var pattern = /^(\d){6}$/;
           if (!pattern.exec(handle.value)) return "必须是数字<br>且长度需是6位!";
           return true;
     }
     
  //判断是否是email正确格式
     function isEmail(handle){
           var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
           if (!pattern.exec(handle.value)) return "必须符合电子邮件地址格式";
           return true;
     }
     
  //简拼
     function isNamesimplicity(handle){
           var pattern = /^([a-zA-Z]){2,25}$/;
           if (!pattern.exec(handle.value)) return "必须是字母<br>且长度需大于等于2位小于等于25位!";
           return true;
     }
     
  //判断输入密码是否正确
     function isPassword(handle){
           var pattern = /^([a-zA-Z]|[0-9]){2,25}$/;
           if (!pattern.exec(handle.value)) return "必须是字母或者数字<br>且长度需大于等于2位小于等于25位!";
           return true;
     }
  
  //判断是否是描述信息:可以是字母 数字 中文 - _ , .
  function isDescstr(handle){
    var pattern = /^[a-zA-Z0-9-_,.\u4E00-\u9FA5]{1,50}$/;
    if (!pattern.exec(handle.value)) return "必须是中文字母或者数字<br>且长度需大于等于1位小于等于50位!";
    return true;
  }

  //判断页面URL是否正确
  function isPageurl(handle){
    var pattern = /^[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
    if (!pattern.exec(handle.value)){
      return "请输入正确的URL格式，比如a.do?b=1&c=2";
      handle.value=''
    }
    return true;
  }
  
  //判断版本号是否正确(第一个为数字，后面可以是.或者数字)
  function isVersion(handle){
      var pattern = /^\d{1}+[0-9-.]*$/;
      if (!pattern.exec(handle.value)){
      return "请输入正确的版本格式，比如1.234";
      handle.value=''
    }
    return true;
  }

  //判断系统ID是否正确(系统ID只能是数字与字母的组合)
  function isSysId(handle){
      var pattern = /^\w{1,10}$/;
      if (!pattern.exec(handle.value)){
      return "必须是字母或者数字<br>且长度需大于等于1位小于等于10位!";
      handle.value=''
    }
    return true;
  }


  //判断目录路径是否正确
  function isDirctoryurl(handle){
    var pattern = /^[a-zA-Z0-9-_,.\\u4E00-\u9FA5]{1,300}$/;
    if (!pattern.exec(handle.value)) return "必须是中文字母或者数字<br>且长度需大于等于1位小于等于300位!";
    return true;
  }
 
