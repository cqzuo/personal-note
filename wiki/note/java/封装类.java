��������	��װ��
boolean	Boolean
byte	Byte
char	Character
double	Double
float	Float
int	Int
long	Long
short	Short
���磺
Boolean  wrapBool  = new Boolean("false");
Integer num1 = new Integer ("31");
Integer num2 = new Integer("3");
int sum = num1.intValue() * num2.intValue();//intValue()���ص��ö��������ֵ 
class CmdArg {
public static void main(String args[]){
	    int sum = 0;
	    for(int cnt = 0; cnt < args.length; cnt++)
          sum+=Integer.parseInt(args[cnt]);//parseInt()������ִ�д��ַ���ת������֮��Ӧ�����ͣ�int��ֵ 
		    System.out.println("��Ϊ��"+sum);
   }
} 
