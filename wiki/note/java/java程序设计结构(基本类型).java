1.java����������
	�Դ�Сд���У�����ĸ��ͷ�����Ի����ĸ�����֣��޳������ƣ�����ʹ��java������
	��ʶ����������ĸ���»��߻�$��ʼ���������������	
2.ע������
	java��Ӧ�ó���д������
	�ļ�������͹���������ͬ
3.��������
	��������
	      ����byte(1) short(2) int(4) long(8)  (һ���ֽڰ˸�λ)
	      ������float(4) double(8)
	      �ַ���char(2)������ݵ�unicode��
	      ������boolean(һ��λ) true false
	      �໥ת��ʱ���ȵĶ�ʧ   int a=10; float a=(float)a;
            ���ͺ��ַ����໥ת������ǿ�� int a=10; char b; b=a;
            ��֧�����ͺͲ����͵�ת��
	��������(��ʹ��������й�)  ���� ������ �� new ����();
            �������ͺͻ�������֮���ת��   
                ��������ת��Ϊ��������(��������������ĳ�Ա����.valueof())
                  String str = new String("1234");str=str+Str.valueof(1);System.out.println(str);
                ��������ת��Ϊ��������(�û������ͷ�װ��)
                	String str = new String("1234");
                  int i = Integer.parseInt(str)+1;
                  double i=Double.parseDouble(str)*3;
                  char i = Character.parseCharacter(str);
4.java��ע��
	����ע��//.....
	����ע��/*....*/
	�ĵ�ע��/** ....*/
5.java�Ĺؼ���
     ԭʼ��������  byte  short  int  long float  double  char boolean
     ѭ���ؼ���  do  while  for  break  continue
     ��֧�ؼ��� if else switch case default break
     �����������������η� private public protected final static abstract synchronized volatile strictfp 
     �쳣���� try catch finally throw throws
     ������عؼ���new extends implements class instanceof this super
     ����ֵ���� false  true null
     ������عؼ��� return void
     ����عؼ��� package import
6.����
	��������������	 ���� ��ʼֵ ������
7.Instanceof�����
     ������ instanceof ���� �ж϶����Ƿ�����һ���ض�����
8.�������õ���
   String���һЩ���÷���
    charAt() �����ַ�����ĳ���ض�λ�õ��ַ�
    indexOf() �����ַ�����ĳ���ض��ַ������ַ����״γ��ֵ�����
    toUpperCase() ���ַ�����������ַ���Сд��Ϊ��д
    toLowerCase() ���ַ����������ַ��Ӵ�д��ΪСд
9.java.lang��    	
    �ð���java������ԵĻ���
    	Object ����ϵ�ṹ�ĸ�
    	Class  ��װ�����ӿ�����ʱ��״̬
    	��װ�� ��װ�����������ͣ�Ϊ�����������ͼ���������ʽ
    	Void ��TYPE�򣬱��������void ��Class���������
    	Math  
    	       java.lang.Math���п��õ�static������ 
    	      abs()
    	      ceil()���ز�С�ڲ��������� floor()���ز����ڲ��������� 
    	      random() 0-1֮��������double��   	      
    	      max() min()
    	      round()˫���������������ͻ�����
    	String StringBuffer
    	ClassLoader	Process   	Runtime   SecurityManager    	System//�ṩϵͳ������������Ķ�̬���أ��ⲿ���̵Ĵ������������Ĳ�ѯ����ȫ����
10.java���ƽṹ
	ѡ�� if else;switch case default(��������Ϊ������);
	ѭ��while ;do while; for;
	��ת
	break ������ǰѭ��
      continue �ص�ѭ����ʼ����ִ�к������
