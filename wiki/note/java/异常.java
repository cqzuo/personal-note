�쳣
�˽��쳣�Ķ���
�˽��쳣�ķ���
���� try��catch �� finally �����÷�
����throw��throws�Ӿ���÷�
������ζ����Լ����쳣
�˽� Java �������ռ�����
1.ʲô���쳣
   ����ʱ�����Ĵ����Ϊ�쳣��������Щ�쳣�ͳ�Ϊ�쳣���� 
  һ�������쳣������ͻȻ��ֹ���ҿ��ƽ����ز���ϵͳ�������쳣���ǰ�����������Դ������������ͬ��״̬���⽫������Դ©��
  public class exec 
{
        public static void main(String args[])
        {
                try
                {
                        String str=javax.swing.JOptionPane.showInputDialog("Please input the size:");
                        int size=Integer.parseInt(str);
                        int x[]=new int[size];
                }
                catch(NumberFormatException e)
                {
                        javax.swing.JOptionPane.showMessageDialog(null,"Not Integer!");  
                }
                catch(NegativeArraySizeException e)
                {
                        javax.swing.JOptionPane.showMessageDialog(null,"Not Positive!");  
                }
                System.exit(0);
        }
}
2.java�쳣�������
   Java�쳣������Ʋ���һ��ͳһ����Լ򵥵��׳��ʹ������Ļ��ơ����һ�����������������쳣���������õķ��������쳣ʱ�������߿��Բ����쳣ʹ֮�õ�����Ҳ���Իر��쳣����ʱ�쳣���ڵ��õĶ�ջ�����´��ݣ�ֱ��������
   Error�������Java��������ɲ��׳���Exception�������Ӧ�ó�������׳�
3.�����쳣
    RuntimeException 	java.lang���ж����쳣�Ļ��� 
    ArithmeticException 	������������� 0 
    IllegalArgumentException 	�����յ��Ƿ����� 
    ArrayIndexOutOfBoundsException 	�����±���� 
    NullPointerException 	��ͼ���� null �������� 
   SecurityException 	��ͼΥ����ȫ�� 
   ClassNotFoundException	���ܼ����������
   AWTException 	AWT �е��쳣 
  IOException 	I/O �쳣�ĸ��� 
  FileNotFoundException 	�����ҵ��ļ� 
  EOFException 	�ļ����� 
  IllegalAccessException 	����ķ��ʱ��ܾ� 
  NoSuchMethodException 	����ķ��������� 
  InterruptedException 	�߳��ж� 
4.�쳣����ģ��
   ������ؼ��� try��catch��throw��throws �� finally ����
   Java �п����ڴ����쳣�����ַ�ʽ��
   ���д������������쳣���������� try ���ڣ��������쳣����Ӧ���������� catch ���ڡ�
   �ر��쳣���ڷ��������а��� throws �Ӿ䣬֪ͨǱ�ڵ����ߣ�����������쳣�������ɵ����ߴ��� 
����
     public class ExceptionDemo 
     {
	 public static void main(String args[])
{
    try  {
 	   int c= calculate(9,0);
	   System.out.println(c);
	  } 
	  catch (Exception e) { 
	   System.err.println("�����쳣�� " + e.toString()); 
	   e.printStackTrace(); 
	  }
	}
	static int calculate(int a, int b) {
		int c = a/b; return c;
	}
 } 
5.���catch��
    ��������Ƭ�ο��ܻ�����������
    ���ṩ���catch��ֱ�������쳣����
    ����Exception��catch�Ӿ�һ��Ҫ�������
      try{ }
      catch(ArrayIndexOutOfBoundsException e){ }//�����±�Խ���쳣��
      catch(Exception e) { }
      ArrayIndexOutOfBoundsException��Ϊ Exception ������࣬��������쳣����ArrayIndexOutOfBoundsException�ཫִ�е�һ��catch�飬֮����ƽ�ת��try/catch��֮�����䣬����ʼ�ղ���ִ�еڶ��� catch �顣
class Catch22 {
		public static void main(String args[]) {
    try {
	   String num=args[0];//����һ����������������ַ���������Ϊ���ֻ��ַ�
	   int numValue=Integer.parseInt(num);//����ȡ������ת��Ϊint��
		System.out.println("ƽ��Ϊ "+numValue*numValue);//���ƽ��
    }
	  catch(ArrayIndexOutOfBoundsException ne) {//�����쳣����������������ַ����������
		 System.out.println("δ�ṩ�κβ�����");
	  }
	  catch(NumberFormatException nb)	{//���ָ�ʽ�쳣��
		System.out.println("�������֣�");
	  }
	}
 } 
 7.Ƕ�׵�try catch ��
   ��ʱ�����һ��������һ�����󣬶������������������һ�������ڴ�����£���Ҫ��һ���쳣�������Ƕ�׵���һ���С� 
  ��ʹ��Ƕ�׵�try��ʱ������ִ���ڲ� try �飬���û������ƥ��� catch �飬�򽫼���ⲿ try ��� catch �顣
 8.finally��
   ȷ�����ڳ����쳣ʱ����������������õ������� try ��һ��ʹ�ã������Ƿ�����쳣��finally�鶼������
   class FinallyDemo {
  int no1,no2;
  FinallyDemo(String args[])	{
    try {
      no1 = Integer.parseInt(args[0]);
      no2 = Integer.parseInt(args[1]);
      System.out.println("������Ϊ "+no1/no2);
    }
    catch(ArithmeticException i) {
	 System.out.println("���ܳ��� 0");
    }	
    finally {
      System.out.println("Finally ��ִ��");	
    } 	
  }
 public static void main(String args[]) {
   new FinallyDemo(args); 
  } 
} 
8.throw
   �쳣��ͨ���ؼ���throw�׳������������throw���������ȷ���쳣��
    try {
		if(flag<0)	{
		  throw new NullPointerException();
		}
        }
   throw���Ĳ�����һ����Throwable�����ͻ�Throwable�������͵�һ������
   ���һ���������ܵ���һ���쳣��������������ʱҪ���ڷ��������а��� throws �Ӿ䣬֪ͨǱ�ڵ����ߣ�����������쳣���ɵ����ߴ���
  һ��throws�Ӿ��о���һ���������������������쳣���͡�
  ����ڳ�Error��RuntimeException�����������������͵������쳣�Ǳ�Ҫ��
   class ThrowsDemo{    
 static void throwOne() throws IllegalAccessException{//�Լ�����Ҫ�׳����쳣
   System.out.println("��throwOne��.");
   throw new IllegalAccessException("�Ƿ������쳣");//�׳��쳣 IlleaglAccessException
 }
 public static void main(String args[]){
   try{
    throwOne();//�׳��쳣
   }
   catch(IllegalAccessException e){//�����쳣����ӡ
     System.out.println("����"+e);
   }
 }
} 
8.�û��Զ�����쳣
      �����쳣������ʼ�����Բ������д��������Ҫ�û��Զ�����쳣��
      �û��Զ�����쳣��ӦΪ Exception �ࣨ����Exception ������ࣩ������
      �������κ��û��Զ�����쳣�඼���Ի�� Throwable�ඨ��ķ���
   ����   
   class ArraySizeException extends NegativeArraySizeException{//�Զ���һ���쳣���̳���NegativeArraySizeException;
   ArraySizeException() {
      super(�������ݵ��ǷǷ��������С��);//���쳣����
  }
}
class UserExceptionDemo {//һ�������Զ����쳣����
	int size, array[];//���������������ݴ�С��size��������������array[];
	UserExceptionDemo(int s) {//���캯�������ã�����С�Ƿ�Ϸ������򲶻�����쳣
		size = s;
		try {checkSize();	}
		catch(ArraySizeException e) {System.out.println(e);}
	}
	void checkSize() throws ArraySizeException {//������ݴ�С�Ϸ��Եķ���
		if(size < 0) 	throw new ArraySizeException();
		array = new int[size];
		for(int i = 0; i < size; i++) {
		   array[i] = i+1;
          System.out.print(array[i]+" ");
       }
	}
	public static void main(String arg[]) { 
	    new UserExceptionDemo(Integer.parseInt(arg[0])); }
} 
