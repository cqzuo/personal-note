public class IdCard
{
    //id
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
    //…Ì∑›÷§±‡∫≈
    @Column(length=40)
    private String number  = null;
	/**
	 * get the value of number
	 * @return the value of number
	 */
	public String getNumber(){
		return this.number;
	}
	/**
	 * set a new value to number
	 * @param number the new value to be used
	 */
	public void setNumber(String number) {
		this.number=number;
	}
}
