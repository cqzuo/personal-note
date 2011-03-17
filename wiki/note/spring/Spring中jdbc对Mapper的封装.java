  Spring jdbc 对象Mapper的简单封装
  一般查询实体的时候，都需要这么使用: /** *//**
  * 根据id查询
  *
  * @return
  */
  public Emp queryEmpById(Integer id)
  {
  String sql = "select * from emp where empno = ?";
  ParameterizedRowMapper<Emp> mapper = new ParameterizedRowMapper<Emp>()
  {
  public Emp mapRow(ResultSet rs, int rowNum) throws SQLException
  {
  Emp emp = new Emp();
  System.out.println("row:" + rowNum);
  emp.setEmpno(rs.getInt("empno"));
  emp.setEname(rs.getString("ename"));
  return emp;
  }
  };
  return this.getSimpleJdbcTemplate().queryForObject(sql, mapper, id);
  }
  复制代码能不能像Hibernate那样自动set这些值呢，用反射可以实现． package orm;
  import java.lang.reflect.Field;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
  /** *//**
  * 通用的Object包装类(类型问题，依然是个瓶颈，如果有好的解决方案请pm我)
  *
  * 功能：查询对象类型或对象集合时的通用包装类
  *
  * @author zdw
  *
  */
  @SuppressWarnings("unchecked")
  public class ObjectMapper implements ParameterizedRowMapper
  {
  private Class clazz;
  public ObjectMapper(Class clazz)
  {
  this.clazz = clazz;
  }
  /** *//**
  * 重写mapRow方法
  */
  @Override
  public Object mapRow(ResultSet rs, int rowNum) throws SQLException
  {
  try
  {
  Object obj = clazz.newInstance();
  Field fields[] = obj.getClass().getDeclaredFields();
  for (int i = 0; i < fields.length; i++)
  {
  Field field = fields;
  // 暴力访问
  field.setAccessible(true);
  this.typeMapper(field, obj, rs);
  // 恢复默认
  field.setAccessible(false);
  }
  return obj;
  }
  catch (Exception e)
  {
  e.printStackTrace();
  }
  return null;
  }
  /** *//**
  * 数据类型包装器
  *
  * @param field
  * 目标属性
  * @param obj
  * 目标对象
  * @param rs
  * 结果集
  * @throws Exception
  */
  private void typeMapper(Field field, Object obj, ResultSet rs)
  throws Exception
  {
  String type = field.getType().getName();
  if (type.equals("java.lang.String"))
  {
  field.set(obj, rs.getString(field.getName()));
  }
  else if (type.equals("int") || type.equals("java.lang.Integer"))
  {
  field.set(obj, rs.getInt(field.getName()));
  }
  else if (type.equals("long") || type.equals("java.lang.Long"))
  {
  field.set(obj, rs.getLong(field.getName()));
  }
  else if (type.equals("boolean") || type.equals("java.lang.Boolean"))
  {
  field.set(obj, rs.getBoolean(field.getName()));
  }
  else if (type.equals("java.util.Date"))
  {
  field.set(obj, rs.getDate(field.getName()));
  }
  }
  }
  复制代码dao: /** *//**
  * 查询操作 (自动setEmp类型所有值)
  *
  * @return
  */
  public List queryList()
  {
  return this.getJdbcTemplate().query("select * from emp",
  new ObjectMapper(Emp.class));
  }
  复制代码单个查询: public Emp queryEmpById2(Integer id)
  {
  String sql = "select * from emp where empno = ?";
  ObjectMapper om = new ObjectMapper(Emp.class);
  return (Emp) this.getSimpleJdbcTemplate().queryForObject(sql, om, id);
  }
  复制代码测试通过:
  7369
  7499
  7521
  7566
  7654
  7698
  7782
  7788
  7839
  7844
  上面是我的一个简单封装，在Spring2.5中及以后版本，已经提供了便捷方法： /** *//**
  * 查询操作 (自动setEmp类型所有值)
  *
  * @return
  */
  public List queryList()
  {
  return this.getSimpleJdbcTemplate().query(
  "SELECT * from emp",
  ParameterizedBeanPropertyRowMapper.newInstance(Emp.class));
  }
  /** *//**
  * 根据id查询
  *
  * @return
  */
  public Emp queryById(Integer id)
  {
  return this.getSimpleJdbcTemplate().queryForObject(
  "SELECT * from emp where id = ?",
  ParameterizedBeanPropertyRowMapper.newInstance(Emp.class),7369);
  }
  复制代码这样就简单多了，也是用反射实现的.
