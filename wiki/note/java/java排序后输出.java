����һ��

/** 
����* ���ý�����ʽ ���� 
����*/ 
����package ����.��������; 
����import java.util.concurrent.Executor; 
����import java.util.concurrent.ExecutorService; 
����import java.util.concurrent.Executors; 
����/** 
����* @author liuyi 
����*/ 
����public class �������� { 
����public static void main(String[] args) throws InterruptedException { 
����int test[] = {15,23,56,7,13,52,20,7}; 
����new ��������().qSort(test, 0, test.length-1); 
����for(int k:test) System.out.println(k); 
����} 
����public void qSort(int []array,int low,int high){ 
����if(low  
����int privot=partition(array,low,high); 
����qSort(array,low,privot-1); 
����qSort(array,privot+1,high); 
����} 
����} 
����public int partition(int [] array,int low,int high){ 
����/** 
����* ѡ�� lowλ�� ��Ϊ����(֧��) 
����*/ 
����int pivot=array[low]; 
����int temp=0; 
����/** 
����* ��� low  
����*/ 
����while(low  
����/** 
����* �ȴ� high�� ��ʼ�ж� 
����*/ 
����while(low=pivot) high--; 
����/** 
����* ���� �û����� 
����*/ 
����if(low  
����temp=array[low]; 
����array[low]=array[high]; 
����array[high]=temp; 
����low++; 
����} 
����/** 
����* �� low ���ж� 
����*/ 
����while(low  
����/** 
����* ���� �û����� 
����*/ 
����if(low  
����temp=array[high]; 
����array[high]=array[low]; 
����array[low]=temp; 
����high--; 
����} 
����} 
����return low; 
����} 
����}
�������

/** 
����* �Ľ��� �������� 
����*/ 
����package ����.��������; 
����import java.util.concurrent.Executor; 
����import java.util.concurrent.ExecutorService; 
����import java.util.concurrent.Executors; 
����/** 
����* @author liuyi 
����*/ 
����public class ��������_1 { 
����public static void main(String[] args) throws InterruptedException { 
����int test[] = {15,23,56,7,13,52,20,7}; 
����new ��������_1().qSort(test, 0, test.length-1); 
����for(int k:test) System.out.println(k); 
����} 
����public void qSort(int []array,int low,int high){ 
����if(low  
����int privot=partition(array,low,high); 
����qSort(array,low,privot-1); 
����qSort(array,privot+1,high); 
����} 
����} 
����public int partition(int [] array,int low,int high){ 
����/** 
����* ѡ�� lowλ�� ��Ϊ����(֧��) 
����*/ 
����int pivot=array[low]; 
����int temp=0; 
����/** 
����* ��� low  
����*/ 
����while(low  
����/** 
����* �ȴ� high�� ��ʼ�ж� 
����*/ 
����while(low=pivot) high--; 
����/** 
����* ���� �û����� 
����*/ 
����if(low  
����array[low]=array[high]; 
����low++; 
����} 
����/** 
����* �� low ���ж� 
����*/ 
����while(low  
����/** 
����* ���� �û����� 
����*/ 
����if(low  
����array[high]=array[low]; 
����high--; 
����} 
����} 
����array[low]=pivot; 
����return low; 
����} 
����}

 

/*�����������Ĵ��룬���������Լ�д�ɣ���ȫ�������˶��Լ�ûʲô�ô��ġ�*/