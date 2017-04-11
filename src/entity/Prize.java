package entity;

import java.util.Date;

/**
 * Prize entity. @author MyEclipse Persistence Tools
 */

public class Prize implements java.io.Serializable {

	// Fields

	private Integer id;
	private String phoneNumber;
	private Integer couponId;
	private Integer productId;
	private Date date;

	// Constructors

	/** default constructor */
	public Prize() {
	}

	/** full constructor */
	public Prize(String phoneNumber, Integer couponId, Integer productId,
			Date date) {
		this.phoneNumber = phoneNumber;
		this.couponId = couponId;
		this.productId = productId;
		this.date = date;
	}

	// Property accessors

	public Prize(String phonenumber, int couponId, int productId) {
		this.phoneNumber = phonenumber;
		this.couponId = couponId;
		this.productId = productId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getCouponId() {
		return this.couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}