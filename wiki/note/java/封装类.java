数据类型	封装类
boolean	Boolean
byte	Byte
char	Character
double	Double
float	Float
int	Int
long	Long
short	Short
例如：
Boolean  wrapBool  = new Boolean("false");
Integer num1 = new Integer ("31");
Integer num2 = new Integer("3");
int sum = num1.intValue() * num2.intValue();//intValue()返回调用对象的整型值 
class CmdArg {
public static void main(String args[]){
	    int sum = 0;
	    for(int cnt = 0; cnt < args.length; cnt++)
          sum+=Integer.parseInt(args[cnt]);//parseInt()方法将执行从字符串转换成与之相应的整型（int）值 
		    System.out.println("和为："+sum);
   }
} 
