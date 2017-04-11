package entity;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */

public class Products implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer productId;
	private String productName;
	private String productImg;
	private String productDescription;
	private Integer price;
	private String seller;

	// Constructors

	/** default constructor */
	public Products() {
	}

	/** minimal constructor */
	public Products(Integer productId, String productName, String productImg,
			String productDescription, Integer price) {
		this.productId = productId;
		this.productName = productName;
		this.productImg = productImg;
		this.productDescription = productDescription;
		this.price = price;
	}

	/** full constructor */
	public Products(Integer productId, String productName, String productImg,
			String productDescription, Integer price, String seller) {
		this.productId = productId;
		this.productName = productName;
		this.productImg = productImg;
		this.productDescription = productDescription;
		this.price = price;
		this.seller = seller;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImg() {
		return this.productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

}