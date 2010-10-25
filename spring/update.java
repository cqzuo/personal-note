private String SQL = "insert into 表名(各个属性名称) values(null,?,?,?)";
public void save***(要持久化的bean类名 bean对象名)
	｛
		jdbcTemplate.update(SQL,
				new Object[]{
			bean对象名.get属性名1(),
			bean对象名.get属性名2(),
			bean对象名.get属性名3(),...
		}
				);
	｝
