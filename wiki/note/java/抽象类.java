1.����������Ŀ�����ṩ���������๲���һ����ʽ��
    ������Ը���������Ҫ��չ�����ࡣ 
    �����಻��ʵ������
    ���󷽷�û�к����塣
    ���󷽷������������и�������ʵ��
  ʹ�ó�����ĳ��ϣ�
     ��һ�����һ����������Ϊ���󷽷�ʱ��
     ������Ϊһ������������࣬����û��Ϊ���г��󷽷��ṩʵ��ϸ�ڻ򷽷�����ʱ��
     ��һ����ʵ��һ���ӿڣ�����û��Ϊ���г��󷽷��ṩʵ��ϸ�ڻ򷽷�����ʱ
  abstract class Employee {	
  int basic = 2000;
  abstract void salary();//���󷽷�
}
class Manager extends Employee{
   void salary() {		
     System.out.println("н�ʵ��� "+basic*5);
   }
 }
 class Worker extends Employee  {
   void salary() {		
   	System.out.println("н�ʵ��� "+basic*2);
   }
 } 
