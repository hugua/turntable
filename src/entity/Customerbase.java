package entity;

/**
 * Customerbase entity. @author MyEclipse Persistence Tools
 */

public class Customerbase implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer baseId;
	private String customerBase;
	private Integer productId;
	private Double productProblity;
	private Integer couponId;

	// Constructors

	/** default constructor */
	public Customerbase() {
	}

	/** full constructor */
	public Customerbase(Integer baseId, String customerBase, Integer productId,
			Double productProblity, Integer couponId) {
		this.baseId = baseId;
		this.customerBase = customerBase;
		this.productId = productId;
		this.productProblity = productProblity;
		this.couponId = couponId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBaseId() {
		return this.baseId;
	}

	public void setBaseId(Integer baseId) {
		this.baseId = baseId;
	}

	public String getCustomerBase() {
		return this.customerBase;
	}

	public void setCustomerBase(String customerBase) {
		this.customerBase = customerBase;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getProductProblity() {
		return this.productProblity;
	}

	public void setProductProblity(Double productProblity) {
		this.productProblity = productProblity;
	}

	public Integer getCouponId() {
		return this.couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

}