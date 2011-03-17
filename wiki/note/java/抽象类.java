1.定义抽象类的目的是提供可由其子类共享的一般形式。
    子类可以根据自身需要扩展抽象类。 
    抽象类不能实例化。
    抽象方法没有函数体。
    抽象方法必须在子类中给出具体实现
  使用抽象类的场合：
     当一个类的一个或多个方法为抽象方法时。
     当该类为一个抽象类的子类，并且没有为所有抽象方法提供实现细节或方法主体时。
     当一个类实现一个接口，并且没有为所有抽象方法提供实现细节或方法主体时
  abstract class Employee {	
  int basic = 2000;
  abstract void salary();//抽象方法
}
class Manager extends Employee{
   void salary() {		
     System.out.println("薪资等于 "+basic*5);
   }
 }
 class Worker extends Employee  {
   void salary() {		
   	System.out.println("薪资等于 "+basic*2);
   }
 } 
