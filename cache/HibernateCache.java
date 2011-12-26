// 初始状态实体类
public class Person
{
    private Integer id = null;
	/**
	 * get the value of id
	 * @return the value of id
	 */
	public Integer getId(){
		return this.id;
	}
	/**
	 * set a new value to id
	 * @param id the new value to be used
	 */
	public void setId(Integer id) {
		this.id=id;
	}
    private String name = null;
	/**
	 * get the value of name
	 * @return the value of name
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * set a new value to name
	 * @param name the new value to be used
	 */
	public void setName(String name) {
		this.name=name;
	}
    
}

public class IdCard
{
	private Integer id;
	/**
	 * get the value of id
	 * @return the value of id
	 */
	public Integer getId(){
		return this.id;
	}
	/**
	 * set a new value to id
	 * @param id the new value to be used
	 */
	public void setId(Integer id) {
		this.id=id;
	}
	private String idCardNo;
	/**
	 * get the value of idCardNo
	 * @return the value of idCardNo
	 */
	public String getIdCardNo(){
		return this.idCardNo;
	}
	/**
	 * set a new value to idCardNo
	 * @param idCardNo the new value to be used
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo=idCardNo;
	}
}
/**
 注解:
 	多:	@ManyToOne
	一:	
		@OneToMany
		@OneToOne
	外键:	@JoinColumn(name="外键的名称")
			一般添加在多的一端
	多或一的参数:	
		级联 Cascade=CascadeType.REFRESH
		是否非空 nullable = false
		是否必选 optional = false
		mapedBy("映射对象名称头字母小写") 当前对象已被被注解对象映射
			放在维护端的被维护对象上
  实体类:
	多:
		在一的一方定义Set<多的一方类名称>作为其属性
	一:
		在多中定义一一方对象作为其属性
 **/ 