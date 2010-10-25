package com.springinaction.chapter03.propeditor;

import java.beans.PropertyEditorSupport;
// 继承PropertyEditorSupport
public class PhoneEditor extends PropertyEditorSupport {
  //重写setAsText()方法
  public void setAsText(String text) {
    String stripped = stripNonNumeric(text);

    String areaCode = stripped.substring(0,3);
    String prefix = stripped.substring(3,6);
    String number = stripped.substring(6);
    PhoneNumber phone = new PhoneNumber(areaCode, prefix, number);
    setValue(phone);
  }

  private String stripNonNumeric(String original) {
    //建立StringBuffer对象allNumeric来存放需要返回的值
    StringBuffer allNumeric = new StringBuffer();
    //搜索该字符串
    for(int i=0; i<original.length(); i++) {
      //取出字符
      char c = original.charAt(i);
      //如果该字符是数字,则将其存进allNumeric中
      if(Character.isDigit(c)) {
        allNumeric.append(c);
      }
    }
  //将StringBuffer对象转换为String对象后返回
    return allNumeric.toString();
  }
}
