JAVA �ڲ���ļ��ܽ� 
  ������һ�����ڲ�������ڲ��࣬�����ڲ�������Ϊ�ⲿ�ࡣ�ڲ����������public��protected��private�ȷ������ƣ���������Ϊabstract�Ĺ������ڲ�����ⲿ��̳�����չ����������Ϊstatic��final�ģ�Ҳ����ʵ���ض��Ľӿڡ�static���ڲ�����Ϊ����һ���������࣬��static����Ϊ������������Ի򷽷��ҽ�ֹ����static�ķ������ڲ�����Է����ⲿ������з��������ԣ���static���ڲ���ֻ�ܷ����ⲿ���  ��̬�����뷽��
�ⲿ�ఴ���������ʷ�ʽʹ���ڲ��࣬Ψһ�Ĳ�����ⲿ����Է����ڲ�������з��������ԣ�����˽�з��������ԡ��磺
        pinner p = new pinner();
        p.index = 20;
        p.Print();
        ---- ���ַ�ʽ�ʺ��ⲿ��ķ�static������
        pouter po = new pouter();
        pinner pi = po.new pinner();
        pi.index = 40;
        pi.Print();
        ---- ���ַ�ʽ�ʺ��ⲿ���static������
  �ڲ��������ⲿ������ԣ���˷����ڲ������ʱ������Ҫһ�������õ��ⲿ������ڲ������ͨ�����ⲿ����.this.xxx������ʽ�����ⲿ��������뷽�����磺
            System.out.println("Print in inner Outer.index=" + pouter.this.index);
            System.out.println("Print in inner Inner.index=" + this.index);
  �����Ҫ���������з����ڲ��࣬����ʹ�ã�
(1)�ⲿ���ṩ�����ڲ���ķ�����������ʹ�á��磺
        // �ⲿ��
        pinner getInner()
        {
            return new pinner();
        }
        // ������
        pouter.pinner pi = po.getInner();
        pi.Print();
(2)ֱ�Ӵ����ڲ���Ķ����磺
        pouter po = new pouter();
        pouter.pinner pi = po.new pinner();
        pi.Print();

  �ڲ�������������ⲿ��ķ����л������С�����ڲ�����Ҫ���ʰ��������ⲿ�෽��������ľֲ��������������þֲ����������������final�ġ��ⲿ��������������������޷����������ڷ����ڲ�����ڲ����ڲ��ࡣ
���һ����̳��ڲ��࣬�򴴽�����Ķ���ʱ���ṩһ���ⲿ��Ķ�����Ϊ���췽���Ĳ������磺
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
  ��������������ڲ���û�ж���ʵ������ʱ�����Դ����������ڲ��ࡣ����ʹ���ڲ���ʵ�ֽӿڵĹ���(���¼�����������������)�������ܵĲ���ϴ���Ҫ����ʵ�ʵ����������Ӧ���ڲ���ʱ������ʹ�������ڲ��ࡣ�򵥵�ʾ�����£�
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
���JAVA �ڲ��໹��һ�����ã��Ǿ���ʵ��JAVA�Ķ�̳С�JAVA�����ǲ������̳еģ����������һ����̳ж�����࣬�Ϳ���ʹ���ڲ��ࡣͨ���ڲ���ֱ�̳�һ�����࣬�ⲿ�ഴ���ڲ���Ķ��󣬲�ʹ���ڲ���ķ����������ʵ���˶�̳С�
