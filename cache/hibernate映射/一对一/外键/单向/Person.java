// 一对一单向外键关联
pualic class Person
{
	//id
	@id
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

	@Column(length=20)
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
    //引用IdCard对象
    private Integer idCardId = null;
    @ManyToOne(name="idCardId",unique="true")
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

