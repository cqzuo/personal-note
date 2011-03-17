дһ��Java�࣬��������а�������Ҫ���õı��ط����������� 

//WinMsgBox.java 
package   edu.netcom.jni; 
public   class   WinMsgBox     
{ 
static{ 
System.loadLibrary( "WinMsgDll ");         //   (1) 
} 
public   native   void   showMsgBox(String   str);     //   (2) 
} 

  


(1)��WinMsgDll�Ƕ�̬�����ļ����ļ��������ü���չ������Ϊ�ڲ�ͬ��ƽ̨�¶�̬�����ļ���չ���ǲ�ͬ�ģ���JVM�Զ�ʶ�𣬱�����Solaris�£��ᱻת��ΪWinMsgDll.so����Win32�����»�ת��ΪWinMsgDll.dll������ļ��������Step   4�����ɵ��ļ���һ�¡�����ļ��Ĵ��λ��Ҳ����Ҫ����ֻ�ܱ�����JVM����ֵjava.library.path��ָ�����ļ����С��������ֵ����ʹ��System.getProperty( "java.library.path ");���鿴��һ������£����ٷ����⼸��λ����ȷ���ɿ��ģ�windows��װĿ¼�µ�system32���棬JDK��װĿ¼�µ�bin���棬�Լ����������ļ��ĵ�ǰĿ¼�� 

(2)��ָ����������ñ��ش���ʵ�ֵķ����� 

Step   2����ʾ����ʹ������javac   -d   .   WinMsgBox.java����Step   1��д��java�ļ��� 

��ʱ���ڵ�ǰĿ¼�½���һ��edu\netcom\jniĿ¼�ṹ������һ��WinMsgBox.class�ļ��������С� 

Step   3����ʾ����ʹ������javah   -jni   edu.netcom.jni.WinMsgBox����ʱ���ڵ�ǰĿ¼�²���һ��edu_netcom_jni_WinMsgBox.h�ļ���ע������ļ������ɣ�����+��������ɣ��м��ã�_�����������ļ��������£� 

/*   DO   NOT   EDIT   THIS   FILE   -   it   is   machine   generated   */ 
#include   <jni.h>                                               //   (1) 
/*   Header   for   class   edu_netcom_jni_WinMsgBox   */ 

#ifndef   _Included_edu_netcom_jni_WinMsgBox 
#define   _Included_edu_netcom_jni_WinMsgBox 
#ifdef   __cplusplus 
extern   "C "   { 
#endif 
/* 
  *   Class:           edu_netcom_jni_WinMsgBox 
  *   Method:         showMsgBox 
  *   Signature:   (Ljava/lang/String;)V               //   (2) 
  */ 
JNIEXPORT   void   JNICALL   Java_edu_netcom_jni_WinMsgBox_showMsgBox 
    (JNIEnv   *,   jobject,   jstring);                       //   (3) 

#ifdef   __cplusplus 
} 
#endif 
#endif 

  


(1)������jni.h������JDK��װĿ¼�µ�include���档 

(2)(Ljava/lang/String;)V���Ǻ����ı�Ƿ������ӱ��ط����˷���Java�˵ķ���ʱ�����õ������Ƿ���JNI��Ϊÿ����������Ҳ�����˱�Ƿ�����Ƿ��Ĺ�����鿴JNI��׼�ĵ��� 

(3)��WinMsgBox.java�б��ط���void   showMsgBox(String   str);�Ķ��壬��ӳ��ΪJNIEXPORT   void   JNICALL   Java_edu_netcom_jni_WinMsgBox_showMsgBox(JNIEnv   *,   jobject,   jstring);   ���к�������ӳ������ǣ�Java_����_����_��������������������صķ��������ں��滹������ÿ�������ı�Ƿ���ÿһ������ӳ�䵽����C�����󶼻���������������JNIEnv   *��jobject�������������������÷����ں�����������⣬����Java�е��������Ͷ��ᰴһ���������ӳ��Ϊ�����������ͣ���Щ�������Ͷ�����jni.h�ж����. 
Step   4��ʹ��VC����д���ط�����ʵ�ֺ������������.dll�ļ����������£� 

1)   ѡ��new-> projects(ѡ��Win32   Dynamic-Link   Library����Step   1��ָ���Ŀ���WinMsgDll��Ϊ������)-> OK-> An   ampty   DLL   project-> Finish�� 

2)   ѡ��Tools-> Options-> Directories(���Ŀ¼D:\J2SDK1.4.2_03\INCLUDE��D:\J2SDK1.4.2_03\INCLUDE\WIN32)������ЩĿ¼�а���JNI�����ͷ�ļ��� 

3)   ��Step   3���ɵ�edu_netcom_jni_WinMsgBox.h������WinMsgDll�����ļ����С�Ȼ��FileView��������ͷ�ļ��� 

4)   ���Դ�ļ�WinMsgDll.cpp���������£� 

#include   "windows.h " 
#include   "edu_netcom_jni_WinMsgBox.h " 
/* 
  *   Class:           edu_netcom_jni_WinMsgBox 
  *   Method:         showMsgBox 
  *   Signature:   (Ljava/lang/String;)V 
  */ 
JNIEXPORT   void   JNICALL   Java_edu_netcom_jni_WinMsgBox_showMsgBox 
(JNIEnv   *   env,   jobject   obj,   jstring   str){ 
const   char   *msg; 
msg   =   env-> GetStringUTFChars(str,0); 
MessageBox(NULL,msg, "Java   invoke ",MB_OK); 
env-> ReleaseStringUTFChars(str,msg); 
} 

5)   ��������WinMsgBox.dll�ļ����������.dll�ļ�������Step   1��˵����Ŀ¼�С� 


Step   5����дһ�������ļ������Զ�WinMsgDll.dll�ĵ��á������ļ�TestJNI.java�������£� 

//TestJNI.java 
import   edu.netcom.jni.WinMsgBox; 
public   class   TestJNI   
{ 
public   static   void   main(String[]   args)   
{ 
          WinMsgBox   box   =   new   WinMsgBox(); 
box.showMsgBox( "Wonderful!! "); 
} 
}