写一个Java类，在这个类中包含了需要调用的本地方法的描述。 

//WinMsgBox.java 
package   edu.netcom.jni; 
public   class   WinMsgBox     
{ 
static{ 
System.loadLibrary( "WinMsgDll ");         //   (1) 
} 
public   native   void   showMsgBox(String   str);     //   (2) 
} 

  


(1)中WinMsgDll是动态链接文件的文件名，不用加扩展名，因为在不同的平台下动态链接文件扩展名是不同的，由JVM自动识别，比如在Solaris下，会被转换为WinMsgDll.so；而Win32环境下会转换为WinMsgDll.dll。这个文件名必须和Step   4中生成的文件名一致。这个文件的存放位置也很重要，它只能被放在JVM属性值java.library.path中指定的文件夹中。这个属性值可以使用System.getProperty( "java.library.path ");来查看。一般情况下，至少放在这几个位置是确定可靠的，windows安装目录下的system32下面，JDK安装目录下的bin下面，以及调用主类文件的当前目录。 

(2)中指明了你必须用本地代码实现的方法。 

Step   2：提示符下使用命令javac   -d   .   WinMsgBox.java编译Step   1编写的java文件。 

此时会在当前目录下建立一个edu\netcom\jni目录结构，并且一个WinMsgBox.class文件存在其中。 

Step   3：提示符下使用命令javah   -jni   edu.netcom.jni.WinMsgBox，此时会在当前目录下产生一个edu_netcom_jni_WinMsgBox.h文件，注意这个文件名是由（包名+类名）组成，中间用（_）隔开。此文件内容如下： 

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

  


(1)包含的jni.h存在于JDK安装目录下的include下面。 

(2)(Ljava/lang/String;)V这是函数的标记符，当从本地方法端访问Java端的方法时，会用到这个标记符。JNI中为每种数据类型也定义了标记符，标记符的规则请查看JNI标准文档。 

(3)在WinMsgBox.java中本地方法void   showMsgBox(String   str);的定义，被映射为JNIEXPORT   void   JNICALL   Java_edu_netcom_jni_WinMsgBox_showMsgBox(JNIEnv   *,   jobject,   jstring);   其中函数名的映射规则是（Java_包名_类名_方法名），如果存在重载的方法，则在后面还会增加每个参数的标记符。每一个方法映射到本地C函数后都会增加两个参数：JNIEnv   *和jobject，关于这两个参数的用法将在后面阐述。另外，所有Java中的数据类型都会按一定规则进行映射为本地数据类型，这些数据类型都是在jni.h中定义的. 
Step   4：使用VC来编写本地方法的实现函数，最后编译成.dll文件。过程如下： 

1)   选择new-> projects(选择Win32   Dynamic-Link   Library，以Step   1中指定的库名WinMsgDll作为工程名)-> OK-> An   ampty   DLL   project-> Finish。 

2)   选择Tools-> Options-> Directories(添加目录D:\J2SDK1.4.2_03\INCLUDE和D:\J2SDK1.4.2_03\INCLUDE\WIN32)。在这些目录中包含JNI所需的头文件。 

3)   将Step   3生成的edu_netcom_jni_WinMsgBox.h拷贝到WinMsgDll工程文件夹中。然后FileView中添加这个头文件。 

4)   添加源文件WinMsgDll.cpp，内容如下： 

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

5)   编译生成WinMsgBox.dll文件。并将这个.dll文件拷贝到Step   1中说明的目录中。 


Step   5：编写一个测试文件来测试对WinMsgDll.dll的调用。测试文件TestJNI.java内容如下： 

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