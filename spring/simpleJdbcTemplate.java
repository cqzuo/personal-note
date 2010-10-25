public Bean类名 get***(查询条件(id))
{
	List<Bean类名> mathes =  getSimpleJdbcTemplate().query(查询语句SQL,
	//这个行映射器知道它在处理一个Bean类而非Object对象
	new ParameterizedRowMapper<Bean类名>(){
			public Bean类名 mapRow(ResultSet rs,int intRow) throws SQLException
			{
				Bean类名 Bean对象名 = new Bean类名();
				//设置Bean的各个属性的值
				Bean对象名.set***(rs.getInt(0));
				Bean对象名.set***(rs.getDouble(1));
				Bean对象名.set***(rs.getString(2));
				...
				return Bean对象名;
			}
		},查询条件(id),
	);
	return mathes.size()>0 ?  mathes.get(0):null;
}