package entity;

public class PayWay {
	private String imageUrl;
	private String paywayName;
	
	public PayWay(){}
	public PayWay(String paywayName, String imageUrl){
		this.imageUrl = imageUrl;
		this.paywayName = paywayName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getPaywayName() {
		return paywayName;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setPaywayName(String paywayName) {
		this.paywayName = paywayName;
	}
	
}
