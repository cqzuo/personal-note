package com.springinaction.chapter03.postprocessor;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
//实现BeanPostProcessor接口,重写postProcessBeforeInitialization()和postProcessAfterInitialization()方法
public class Fuddifier implements BeanPostProcessor {
   public Object postProcessAfterInitialization(Object bean, String name)
                     throws BeansException {
      //获取该Bean的数据域,保存进Field[]对象)
      Field[] fields = bean.getClass().getDeclaredFields();

      try {
         //遍历所有Field对象
         for (int i = 0; i < fields.length; i++) {
            //如果是String类型,执行如下操作
            if (fields[i].getType().equals(java.lang.String.class)) {
                  /*
                     public void setAccessible(boolean flag) 
                     throws SecurityException 
                     值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。可以访问私有域 
                     值为 false 则指示反射的对象应该实施 Java 语言访问检查。 即不能访问私有域
                  */
               //设置Field对象中private域的可读取
               fields[i].setAccessible(true);
               //将Field对象中的属性转换为String值
               String original = (String) fields[i].get(bean);
               //将String类型的属性转换为Fuddify类型}}
               fields[i].set(bean, fuddify(original));
            }
         }
      }
      catch (IllegalAccessException e) {
         e.printStackTrace();
      }

      return bean;
   }

   String fuddify(String orig) {
      if (orig == null) return orig;
      return orig.replaceAll("(r|l)", "w").replaceAll("(R|L)", "W");
   }

   public Object postProcessBeforeInitialization(Object bean, String name)
                     throws BeansException {
      return bean;
   }
}
