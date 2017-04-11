package entity;

public class ProductEntity {
	private Integer productId;
	private Double productProblity;
	private Integer couponId;
	private String productImg;
	private String customerImg;
	private String couponDesc;
	private String productName;
	
	


	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCouponDesc() {
		return couponDesc;
	}
	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}
	public ProductEntity(Integer productId, Double productProblity,
			Integer couponId, String productImg, String productName,String couponDesc,String customerImg) {
		this.productId = productId;
		this.productProblity = productProblity;
		this.couponId = couponId;
		this.productImg = productImg;
		this.couponDesc = couponDesc;
		this.customerImg = customerImg;
		this.productName = productName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Double getProductProblity() {
		return productProblity;
	}
	public void setProductProblity(Double productProblity) {
		this.productProblity = productProblity;
	}
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getCustomerImg() {
		return customerImg;
	}
	public void setCustomerImg(String customerImg) {
		this.customerImg = customerImg;
	}
	

}
