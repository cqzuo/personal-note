有时候，我们传入到方法的参数的个数是不固定的，为了解决这个问题，我们一般采用下面的方法：
1．重载，多重载几个方法，尽可能的满足参数的个数。显然这不是什么好办法
2．将参数作为一个数组传入。虽然这样我们只需一个方法即可，但是，为了传递这个数组，我们需要先声明一个数组，然后将参数一个一个加到数组中
现在，我们可以使用可变长参数解决这个问题
声明可变长参数方式如下:
public void mymethod(String arg1,Object… args)
也就是使用…将参数声明成可变长参数
显然，可变长参数必须是最后一个参数
请看下面唐僧师傅给悟空讲佛经的例子
package com.kuaff.jdk5;
public class Varargs1
{
    public void speak(String name,Object... arguments)
	{
		for(Object object : arguments)
		{
			System.out.println(object);
		}
	}
	public static void main(String[] args)
	{
		Varargs1 va = new Varargs1();
		va.speak("悟空","人和妖精都是妈生的,");
		va.speak("悟空","不同的人是人他妈生的,","妖是妖他妈生的,");
	}
}
其中speak中的参数被声明成可变长的参数，所以你可以传递给speak方法多个参数