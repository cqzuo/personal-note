接口
    一个接口允许一个类从几个接口继承而来。
    Java 程序一次只能继承一个类但可以实现几个接口。 
    接口不能有任何具体的方法。
   接口也可用来定义可由类使用的一组常量。 
   接口提供“is a”关系。
   // 有方法的接口
public interface myinterface {
	public void add(int x, int y);
	public void volume(int x,int y, int z);
}
// 定义程序使用的常量的接口
public interface myconstants {
	public static final double price = 1450.00;
 public static final int counter = 5;
}
如果有一个以上接口被实现，则用逗号隔开接口名称，如下所示：
 class demo implements Mycalc, Mycoun
