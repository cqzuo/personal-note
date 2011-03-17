protected abstract function();
Р§зг:
public abstract class BEbo implements MyFactory
{
	private DAO dao = null;
	private int i;
	private UserMod um = new UserMod();

	public void setUm(UserMod um)
	{
		this.um = um;
		}
	public abstract UserMod getUm();
        public void BEbo(DAO dao,int i)
	{
		this.dao = dao;
		this.i = i;
	}

	public String test()
	{
		dao.create("b invoke");
		System.out.println("haha now id B:"+this.getUm());
		return "this is B";
       	}
}
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
	        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.0.xsd">
		<bean id="test" class="spring.BEbo">
	<constructor-arg index="0" ref="dao"/>
	<constructor-arg index="1" type="int" value="445"/>
		</bean>
	<bean id="dao" class="spring.DAOImpl">
		</bean>
</beans>