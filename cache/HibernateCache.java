// ��ʼ״̬ʵ����
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
 ע��:
 	��:	@ManyToOne
	һ:	
		@OneToMany
		@OneToOne
	���:	@JoinColumn(name="���������")
			һ������ڶ��һ��
	���һ�Ĳ���:	
		���� Cascade=CascadeType.REFRESH
		�Ƿ�ǿ� nullable = false
		�Ƿ��ѡ optional = false
		mapedBy("ӳ���������ͷ��ĸСд") ��ǰ�����ѱ���ע�����ӳ��
			����ά���˵ı�ά��������
  ʵ����:
	��:
		��һ��һ������Set<���һ��������>��Ϊ������
	һ:
		�ڶ��ж���һһ��������Ϊ������
 **/ 