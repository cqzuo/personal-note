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

// 一对一单向外键关联
@Entity
@Table(name="person")
public class Person
{
	@Id
	@GeneratedValue
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
	
	@Column(length=30)
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

	@ManyToOne()
	private IdCard idCard = null;
	/**
	 * get the value of idCard
	 * @return the value of idCard
	 */
	public IdCard getIdCard(){
		return this.idCard;
	}
	/**
	 * set a new value to idCard
	 * @param idCard the new value to be used
	 */
	public void setIdCard(IdCard idCard) {
		this.idCard=idCard;
	}
}
