package entity;

/**
 * Coupons entity. @author MyEclipse Persistence Tools
 */

public class Coupons implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer couponId;
	private Integer discount;
	private Integer productId;
	private String couponDescription;
	private String customerImg;

	// Constructors

	/** default constructor */
	public Coupons() {
	}

	/** full constructor */
	public Coupons(Integer couponId, Integer discount, Integer productId,
			String couponDescription, String customerImg) {
		this.couponId = couponId;
		this.discount = discount;
		this.productId = productId;
		this.couponDescription = couponDescription;
		this.customerImg = customerImg;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCouponId() {
		return this.couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getCouponDescription() {
		return this.couponDescription;
	}

	public void setCouponDescription(String couponDescription) {
		this.couponDescription = couponDescription;
	}

	public String getCustomerImg() {
		return this.customerImg;
	}

	public void setCustomerImg(String customerImg) {
		this.customerImg = customerImg;
	}

}