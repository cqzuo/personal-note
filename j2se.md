%toc
### �ڲ��� ###
#### �ڲ������ⲿ���Ķ��� ####
#### �ڲ������ص� ####
  1. ��������public protected private�ȷ�������
  1. ��������Ϊabstract�๩�����ڲ������ⲿ���̳�����չ
  1. ����ʵ���ض��ӿ�
  1. ���Է����ⲿ�������з���������
#### static �ڲ��� ####
  1. �Ǿ�̬�ڲ��಻�ܶ��徲̬���Ի򷽷�
  1. ֻ�ܷ����ⲿ���ľ�̬����������
#### �ڲ���ʹ�� ####
  1. �ⲿ�����Է����ڲ��������з�������
  1. �ڲ��������ⲿ�����뷽��-- �ⲿ��������.this.���Ի򷽷���
  1. �ⲿ�������ڲ���-- �ⲿ������.new �ڲ�����()
  1. �ڲ��������������ⲿ���ķ�������������
    * �ڲ������ʰ��������ⲿ���ķ������������ľֲ�����������ʱ,��������final
    * �ⲿ���������������������޷����������ڷ����ڲ����������е��ڲ���
  1. �����������̳��ڲ���,���ڸ����б����ṩһ�����ڲ������ⲿ��������Ϊ�����Ĺ��췽��
#### �����ڲ��� ####
  1. ����
    * ʹ���ڲ���ʵ�ֽӿڵĹ���
  1. �ص�
    * �����ڲ������Դ����ӿ�,������,��ͨ���Ķ���
    * �����ڲ��ഴ���ӿ�ʱ,����ʵ�ֽӿ����з���
    * ���������ڲ�����Ҫ���ݲ���,�ڲ�����ʹ��ʱ,����final
    * ���Ը������ڲ��ඨ�����Բ���ʼ��,ʹ��{}
  1. ʹ��
    * ���ݲ���
> {{{class="brush: java"
class A
{
> private String name;

> public A(int num)
> {
> > System.out.println("num is "+num);

> }
> public A(){}
}

class  B
{
> private A getA(final int num)
> {
> > return new A(num){
> > > public int getNum()
> > > {
> > > > return num;

> > > }

> > };

> }
} }}}
  * ʵ���������ڲ���������
{{{class="brush: java"
	public A getA()
	{
		return	new A()
	 	{
			private int num = 0;
			private String str;
			{
				str = "lord";
			}
		}
	}
}}}
=== �� ===
==== ���ļ��ж�ȡ����д������ ====
  - �����ļ������� -- new FileInputStream("�ļ�·������")
  - ��FileInputStream���ж�ȡ�����ݿ��Դ�����int���ͱ�����,��char(����)��ת��
  - �����ж�ȡ���� -- int c = in.read()
==== �����е�����д�뵽�ļ��� ====
  - �����ļ������� -- new FileOutputStream("�ļ�·������")
  - ������д���ļ� -- out.write(���������ж�����int�ͱ���);
==== �����ļ�����ȡ���� ====
  - ���������ļ���ȡ�� -- new BufferedReadaer(new FileReader("�ļ���·��"));
  - ��ȡ�ļ�-- br.readLine()
==== �����ļ���д������ ====
  - ���������ļ�д���� -- new BufferedWriter(new FileWriter("�ļ���·��"));
  - ���ַ���д���ļ� -- bw.write(s);
  - ���з� -- bw.newLine();
  - ������һ��д���ļ� -- bw.flush();
==== �ļ����� ====
  - new OutputStreamWriter(new FileOutputStream("�ļ���·��",true),"gb2312");
==== ������ ====
  - ByteArrayOutputStream DataOutputStream
   * bos.writeDouble()
   * bos.writeBoolean()
  - ByteArrayInputStream DataInputStream
   * bis.readDouble()
   * bis.readBoolean()
==== ������ ====
  - ������ӡ������ PrintStream ps = new PrintStream(new FileOutputStream("�ļ�·����"));
  - ������������ -- System.setOut(ps);
  - ��ӡ -- System.out.print(�ַ���);
==== �ļ�����������̨ ====
  - ��������������̨ -- PrintStream ps = System.out
==== �ӿ���̨��ȡ���� ====
  - ���ն˶�ȡ���ݵ�BufferedReadaer�� -- new BufferedReadaer(new InputStreamReader(System.in))
  - �ӻ������ж�ȡ���� -- br.readLine();
  - ������ӡ������ -- new PrintWriter(new FileWriter("�ļ�·����"),true)
  - ����ӡ��д������
   - pw.write(�ַ���);
   - pw.println(�ַ���);
```