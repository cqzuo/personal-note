private static final String SQL = "select 熟悉名称 from 表名称";
private static final String SQL_WHERE = "where 条件=?";
public Bean名称 getBean名称By条件名称(条件)
{
	List mathes = jdbcTemplate.query(SQL,new Object[]{
		条件
	},
	new RowMapper()
	{
		public Object mapRow(ResultSet rs,int rowNum)
		{
			Bean类名 Bean对象名 = new Bean类名();
			Bean对象名.set***(rs.geInt(i));
			Bean对象名.set***(rs.getString(i));
			Bean对象名.set***(rs.get数据类型(1));
			Bean对象名.set***(rs.get数据类型(2));
			Bean对象名.set***(rs.get数据类型(3));

			return Bean对象名;
		}
	}
	)
	return mathes.size()>0 ?(Bean类名)mathes.get(0) : null;
}
