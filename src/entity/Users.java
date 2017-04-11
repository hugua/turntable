package entity;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String phoneNumber;
	private String customerBase;
	private Integer times;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(Integer userId, String phoneNumber, String customerBase,
			Integer times) {
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.customerBase = customerBase;
		this.times = times;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerBase() {
		return this.customerBase;
	}

	public void setCustomerBase(String customerBase) {
		this.customerBase = customerBase;
	}

	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

}