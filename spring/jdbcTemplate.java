public void save(Bean类名 Bean对象名)
{
	Map parameterMaps = new HashMap();
	parameterMaps.put(参数名称1,参数值)
	parameterMaps.put(参数名称2,参数值)
	parameterMaps.put(参数名称3,参数值)
	...
	jdbcTemplate.update(查询语句SQL,包含参数信息的Map对象parameterMaps);
}
