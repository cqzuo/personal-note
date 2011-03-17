class A
{
	private String name;

	public A(int num)
	{
		System.out.println("num is "+num);
	}
}

class  B
{
	private A getA(final int num)
	{
		return new A(num){
			public int getNum()
			{
				return num;
			}
		}
	}
}
