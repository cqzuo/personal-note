JAVA 内部类的简单总结 
  定义在一个类内部的类叫内部类，包含内部类的类称为外部类。内部类可以声明public、protected、private等访问限制，可以声明为abstract的供其他内部类或外部类继承与扩展，或者声明为static、final的，也可以实现特定的接口。static的内部类行为上象一个独立的类，非static在行为上类似类的属性或方法且禁止声明static的方法。内部类可以访问外部类的所有方法与属性，但static的内部类只能访问外部类的  静态属性与方法
外部类按常规的类访问方式使用内部类，唯一的差别是外部类可以访问内部类的所有方法与属性，包括私有方法与属性。如：
        pinner p = new pinner();
        p.index = 20;
        p.Print();
        ---- 这种方式适合外部类的非static方法；
        pouter po = new pouter();
        pinner pi = po.new pinner();
        pi.index = 40;
        pi.Print();
        ---- 这种方式适合外部类的static方法；
  内部类类似外部类的属性，因此访问内部类对象时总是需要一个创建好的外部类对象。内部类对象通过‘外部类名.this.xxx’的形式访问外部类的属性与方法。如：
            System.out.println("Print in inner Outer.index=" + pouter.this.index);
            System.out.println("Print in inner Inner.index=" + this.index);
  如果需要在其他类中访问内部类，可以使用：
(1)外部类提供创建内部类的方法供其他类使用。如：
        // 外部类
        pinner getInner()
        {
            return new pinner();
        }
        // 其他类
        pouter.pinner pi = po.getInner();
        pi.Print();
(2)直接创建内部类的对象。如：
        pouter po = new pouter();
        pouter.pinner pi = po.new pinner();
        pi.Print();

  内部类可以声明在外部类的方法中或语句块中。如果内部类需要访问包含它的外部类方法或语句块的局部变量或参数，则该局部变量或参数必须是final的。外部类的其他方法、其他类无法访问声明在方法内部或块内部的内部类。
如果一个类继承内部类，则创建该类的对象时需提供一个外部类的对象作为构造方法的参数。如：
class Car
{
    class Wheel
    {
    }
}
class SuperWheel extends Car.Wheel
{
    SuperWheel(Car car)
    {
        car.super();
    }
    public static void main(String [] args)
    {
        Car car = new Car();
        SuperWheel wl = new SuperWheel(car);
    } 
}
  如果创建命名的内部类没有多少实际意义时，可以创建匿名的内部类。比如使用内部类实现接口的功能(如事件处理器、适配器等)，而功能的差异较大，需要根据实际的情况创建相应的内部类时，可以使用匿名内部类。简单的示例如下：
interface WebView
{
    void doGet();
}
class A
{
    WebView ShowName()
    {
        return new WebView()
        {
            void doGet()
            {
                System.out.println("Name");
            }    
        };
    }
    WebView ShowCode()
    {
        return new WebView()
        {
            void doGet()
            {
                System.out.println("Code");
            }    
        };
    }
}
最后，JAVA 内部类还有一个作用，那就是实现JAVA的多继承。JAVA本身是不允许多继承的，如果我们想一个类继承多个基类，就可以使用内部类。通过内部类分别继承一个基类，外部类创建内部类的对象，并使用内部类的方法，变相地实现了多继承。
