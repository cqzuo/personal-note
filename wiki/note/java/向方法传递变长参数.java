��ʱ�����Ǵ��뵽�����Ĳ����ĸ����ǲ��̶��ģ�Ϊ�˽��������⣬����һ���������ķ�����
1�����أ������ؼ��������������ܵ���������ĸ�������Ȼ�ⲻ��ʲô�ð취
2����������Ϊһ�����鴫�롣��Ȼ��������ֻ��һ���������ɣ����ǣ�Ϊ�˴���������飬������Ҫ������һ�����飬Ȼ�󽫲���һ��һ���ӵ�������
���ڣ����ǿ���ʹ�ÿɱ䳤��������������
�����ɱ䳤������ʽ����:
public void mymethod(String arg1,Object�� args)
Ҳ����ʹ�á������������ɿɱ䳤����
��Ȼ���ɱ䳤�������������һ������
�뿴������ɮʦ������ս��𾭵�����
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
		va.speak("���","�˺���������������,");
		va.speak("���","��ͬ����������������,","��������������,");
	}
}
����speak�еĲ����������ɿɱ䳤�Ĳ�������������Դ��ݸ�speak�����������