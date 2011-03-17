  Spring jdbc ����Mapper�ļ򵥷�װ
  һ���ѯʵ���ʱ�򣬶���Ҫ��ôʹ��: /** *//**
  * ����id��ѯ
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
  ���ƴ����ܲ�����Hibernate�����Զ�set��Щֵ�أ��÷������ʵ�֣� package orm;
  import java.lang.reflect.Field;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
  /** *//**
  * ͨ�õ�Object��װ��(�������⣬��Ȼ�Ǹ�ƿ��������кõĽ��������pm��)
  *
  * ���ܣ���ѯ�������ͻ���󼯺�ʱ��ͨ�ð�װ��
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
  * ��дmapRow����
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
  // ��������
  field.setAccessible(true);
  this.typeMapper(field, obj, rs);
  // �ָ�Ĭ��
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
  * �������Ͱ�װ��
  *
  * @param field
  * Ŀ������
  * @param obj
  * Ŀ�����
  * @param rs
  * �����
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
  ���ƴ���dao: /** *//**
  * ��ѯ���� (�Զ�setEmp��������ֵ)
  *
  * @return
  */
  public List queryList()
  {
  return this.getJdbcTemplate().query("select * from emp",
  new ObjectMapper(Emp.class));
  }
  ���ƴ��뵥����ѯ: public Emp queryEmpById2(Integer id)
  {
  String sql = "select * from emp where empno = ?";
  ObjectMapper om = new ObjectMapper(Emp.class);
  return (Emp) this.getSimpleJdbcTemplate().queryForObject(sql, om, id);
  }
  ���ƴ������ͨ��:
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
  �������ҵ�һ���򵥷�װ����Spring2.5�м��Ժ�汾���Ѿ��ṩ�˱�ݷ����� /** *//**
  * ��ѯ���� (�Զ�setEmp��������ֵ)
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
  * ����id��ѯ
  *
  * @return
  */
  public Emp queryById(Integer id)
  {
  return this.getSimpleJdbcTemplate().queryForObject(
  "SELECT * from emp where id = ?",
  ParameterizedBeanPropertyRowMapper.newInstance(Emp.class),7369);
  }
  ���ƴ��������ͼ򵥶��ˣ�Ҳ���÷���ʵ�ֵ�.
