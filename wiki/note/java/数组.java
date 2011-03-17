1.数组
   属于复杂数据类型，元素类型相同；固定不能扩展；可存储基本数据或对象；通过数组名和下标访问元素；.数组的类型除了基本类型外，也可以是引用类型
    数组类型 数组名[ ];数组变量名 ＝ new 数组类型名();
   int [] narry; int narry[];//作用等同
2.命令行参数
   java应用程序可以从命令行中接受任意数量的参数；每个参数被视为字符串分别存储在main函数的参数数组中；可以使用双引号将多个字符串作为一个整体显示；
    class ComndLineArg1
      {
          public static void main(String args[ ]) 
               {
                 for(int i=0;i<args.length;i++) 
                       {
                           System.out.println(args[i]);
                       }
              }
     } 
3.动态确定数组的长度
	int len;int[] narry = new int[len];