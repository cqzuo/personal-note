对指定目录下的文件和文件夹进行排序并打印
Java代码 
/* 
 * @(#) FileTest.java 2008/09/12 
 */  
  
import java.io.File;  
import java.util.ArrayList;  
import java.util.HashSet;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Set;  
import java.util.TreeSet;  
  
/** 
 * FileTest 
 * 
 * @version 1.0 
 * @since 2008/09/12 
 */  
public class FileTest  
{  
    public static void main(String[] args)  
    {  
        File directory = new File("c:\\temp\\");  
        List fileList = listAllFiles(directory);  
  
        Set fileNameSet = new HashSet(fileList.size());  
        for (int i = 0 ; i< fileList.size() ; i++)  
        {  
            File file = (File)fileList.get(i);  
            fileNameSet.add(file.getAbsolutePath());  
        }  
  
        for (Iterator i = new TreeSet(fileNameSet).iterator() ; i.hasNext() ; )  
        {  
            System.out.println(i.next());  
        }  
  
    }  
  
  
    private static List listAllFiles(File directory)  
    {  
        if (directory == null   
            || !directory.isDirectory()  
        ){  
            return null;  
        }  
  
        List fileList = new ArrayList();  
        addSubFileList(directory, fileList);  
  
        return fileList;  
    }  
  
    private static void addSubFileList(  
        File file,   
        List fileList  
    ){  
        File[] subFileArray = file.listFiles();  
        if (subFileArray == null  
            || subFileArray.length == 0  
        ){  
            return;  
        }  
  
        for (int i = 0 ; i < subFileArray.length ; i++)  
        {  
            File subFile = subFileArray[i];  
            if (subFile == null  
            ){  
                continue;  
            }  
            if (subFile.isFile()  
            ){  
                fileList.add(subFile);  
                continue;  
            }  
            else if (subFile.isDirectory()  
            ){  
                addSubFileList(subFile, fileList);  
            }  
        }  
    }  
}  



引用

c:\temp\ASTOption\ASTOption.exe 
c:\temp\ASTOption\ASTOption.inf 
c:\temp\ASTOption\ITMFP014_Win2K.dev 
c:\temp\ASTOption\cnpdsdk.dll 
c:\temp\ASTOption\cnsdk16.dll 
c:\temp\ASTOption\cnsdk32.dll 
c:\temp\acegi-security-1.0.1.jar 
c:\temp\acegi-security-rsi-1.0.1.jar 
c:\temp\cls 
c:\temp\commons-attributes-api-2.1.jar 
c:\temp\commons-beanutils.jar 
c:\temp\commons-codec-1.3.jar 
c:\temp\commons-collections-3.1.jar 
c:\temp\commons-dbcp-1.2.1.jar 
c:\temp\commons-lang-2.1.jar 
c:\temp\commons-logging-api.jar 
c:\temp\commons-logging.jar 
c:\temp\commons-pool-1.3.jar 
c:\temp\ehcache-1.1.jar 
c:\temp\ibatis-common-2.jar 
c:\temp\ibatis-sqlmap-2.jar 
c:\temp\j2ee.jar 
c:\temp\jakarta-oro-2.0.8.jar 
c:\temp\java 
c:\temp\jsf-api.jar 
c:\temp\jsf-ibm.jar 
c:\temp\jsf-rsi-2.2.7.jar 
c:\temp\log4j-1.2.13.jar 
c:\temp\log4j-1.2.4.jar 
c:\temp\mpibtbatch.jar 
c:\temp\ojdbc14.jar 
c:\temp\oro-2.0.8.jar 
c:\temp\rsi.jar 
c:\temp\spring.jar 
c:\temp\sqljdbc.jar 
c:\temp\vssver.scc 
_________________________________
Java代码 
  
package com.zhangpeng.file; 

import java.io.File; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 
import java.util.Iterator; 
import java.util.List; 

public class Directory { 
private List file = new ArrayList(); 
private File f ; 
public Directory(){ 
} 

public List getAllFile(String dir_name){ 
File[] files = null; 
try { 
f = new File(dir_name); 
files = f.listFiles(); 
for(int i=0;i<files.length;i++){ 
if(files[i].isFile()){ 
file.add(files[i].getName()); 
}else{ 
getAllFile(files[i].getAbsolutePath()); 
} 
} 
} catch (Exception e) { 
System.out.println("目录路径不正确。"); 
} 
Collections.sort(file,new Com()); 
return file; 
} 
public static void main(String[] args){ 
List l = new Directory().getAllFile("D:\\test"); 
Iterator it = l.iterator(); 
while(it.hasNext()){ 
System.out.println(it.next()); 
} 
} 
} 

//比较器 
class Com implements Comparator{ 

public int compare(Object o1, Object o2) { 
String s = (String)o1; 
String s1 = (String)o2; 
// TODO Auto-generated method stub 
return s.compareTo(s1); 
} 
//123.txt 
//12321.txt 
//asdsf.txt 
//cscdf.txt 
//123.txt 
//3435.txt 

}
————————————————————————————
Java代码 
import java.io.File;  
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.List;  
  
  
public class FilePrinfTool {  
  
    /** 
     * @param args 
     */  
    static List<String> fileListGlobal = new ArrayList<String>();  
    public static void main(String[] args) {  
         getAllFileList("C:\\Downloads\\");  
         Collections.sort(fileListGlobal);  
         for (String name : fileListGlobal) {  
             System.out.println(name);  
         }  
    }  
  
    public static void getAllFileList(String root){  
        File rootDir = new File(root);  
        if (rootDir == null || !rootDir.isDirectory()){  
            System.out.println(String.format("\"%s\" 这个目录不存在 !", root));  
        } else {  
            getSubDirectotyFile(rootDir);  
        }  
    }  
  
    private static void getSubDirectotyFile(File rootDir) {  
        File[] fileArray = rootDir.listFiles();  
        for (File file : fileArray) {  
            if (file.isDirectory()) {  
                getSubDirectotyFile(file);//递归  
            } else {  
                String filePath = file.getPath();  
                fileListGlobal.add(filePath);  
            }  
        }  
    }  
}  


C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\record\formula\package-summary.html 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\record\package-frame.html 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\record\package-summary.html 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\usermodel\TestBug42464-out.txt 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\usermodel\TestBug42464.html 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\usermodel\TestBug43093.html 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\usermodel\TestBug44297.html 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\usermodel\TestBugs-out.txt 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\usermodel\TestBugs.html 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\usermodel\TestCellStyle.html 
C:\Downloads\poi-bin-3.0.2-FINAL-20080204\poi-3.0.2-FINAL\docs\junit\org\apache\poi\hssf\usermodel\TestCloneSheet.html.....
一般来讲，程序的目的不会仅仅是读出文件名 
把所有子目录下的文件放到一个列表是共通的需求 
所以才会用一个List<File>的结构 

至于Out of Memory 
可以先做一个检查
