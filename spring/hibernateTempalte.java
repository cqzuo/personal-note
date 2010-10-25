//save()
public void  save对象类名(对象类名 对象名称)
{
	hibtenateTemplate.saveOrUpate(对象名称);
}
//find()
String SQL = "from 表名称 where 字段1=? and 字段2=?";
public 对象类名 find(条件1,条件2)
{
	List result = hibtenateTemplate.find(SQL,
		new Object[]{条件1,条件2}
	);
	
	return result.size>0?(对象类名})result.get(0):null;
}
//load
String SQL="from 表名称 where 字段1=? and 字段2=?";
public 对象类名 load(条件)
{
  return (对象类名)hibernateTemplate.load(对象类名.class,条件);
}