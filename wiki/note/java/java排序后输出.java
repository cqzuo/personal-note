代码一：

/** 
　　* 采用交换方式 排序 
　　*/ 
　　package 排序.交换排序; 
　　import java.util.concurrent.Executor; 
　　import java.util.concurrent.ExecutorService; 
　　import java.util.concurrent.Executors; 
　　/** 
　　* @author liuyi 
　　*/ 
　　public class 快速排序 { 
　　public static void main(String[] args) throws InterruptedException { 
　　int test[] = {15,23,56,7,13,52,20,7}; 
　　new 快速排序().qSort(test, 0, test.length-1); 
　　for(int k:test) System.out.println(k); 
　　} 
　　public void qSort(int []array,int low,int high){ 
　　if(low  
　　int privot=partition(array,low,high); 
　　qSort(array,low,privot-1); 
　　qSort(array,privot+1,high); 
　　} 
　　} 
　　public int partition(int [] array,int low,int high){ 
　　/** 
　　* 选择 low位置 作为曲轴(支点) 
　　*/ 
　　int pivot=array[low]; 
　　int temp=0; 
　　/** 
　　* 如果 low  
　　*/ 
　　while(low  
　　/** 
　　* 先从 high端 开始判断 
　　*/ 
　　while(low=pivot) high--; 
　　/** 
　　* 进行 置换操作 
　　*/ 
　　if(low  
　　temp=array[low]; 
　　array[low]=array[high]; 
　　array[high]=temp; 
　　low++; 
　　} 
　　/** 
　　* 从 low 端判断 
　　*/ 
　　while(low  
　　/** 
　　* 进行 置换操作 
　　*/ 
　　if(low  
　　temp=array[high]; 
　　array[high]=array[low]; 
　　array[low]=temp; 
　　high--; 
　　} 
　　} 
　　return low; 
　　} 
　　}
代码二：

/** 
　　* 改进的 快速排序 
　　*/ 
　　package 排序.交换排序; 
　　import java.util.concurrent.Executor; 
　　import java.util.concurrent.ExecutorService; 
　　import java.util.concurrent.Executors; 
　　/** 
　　* @author liuyi 
　　*/ 
　　public class 快速排序_1 { 
　　public static void main(String[] args) throws InterruptedException { 
　　int test[] = {15,23,56,7,13,52,20,7}; 
　　new 快速排序_1().qSort(test, 0, test.length-1); 
　　for(int k:test) System.out.println(k); 
　　} 
　　public void qSort(int []array,int low,int high){ 
　　if(low  
　　int privot=partition(array,low,high); 
　　qSort(array,low,privot-1); 
　　qSort(array,privot+1,high); 
　　} 
　　} 
　　public int partition(int [] array,int low,int high){ 
　　/** 
　　* 选择 low位置 作为曲轴(支点) 
　　*/ 
　　int pivot=array[low]; 
　　int temp=0; 
　　/** 
　　* 如果 low  
　　*/ 
　　while(low  
　　/** 
　　* 先从 high端 开始判断 
　　*/ 
　　while(low=pivot) high--; 
　　/** 
　　* 进行 置换操作 
　　*/ 
　　if(low  
　　array[low]=array[high]; 
　　low++; 
　　} 
　　/** 
　　* 从 low 端判断 
　　*/ 
　　while(low  
　　/** 
　　* 进行 置换操作 
　　*/ 
　　if(low  
　　array[high]=array[low]; 
　　high--; 
　　} 
　　} 
　　array[low]=pivot; 
　　return low; 
　　} 
　　}

 

/*给你关于排序的代码，输入跟输出自己写吧！完全依赖别人对自己没什么好处的。*/