package entity;

import java.util.List;


public class Bill {
	private String shopName;
	private String conductName;
	private String conductProvider;
	private double price;
	private double discount;
	private double payment;
	private boolean isWeixin;
	private List<PayWay> payway;
	public String getShopName() {
		return shopName;
	}
	public String getConductName() {
		return conductName;
	}
	public String getConductProvider() {
		return conductProvider;
	}
	public double getPrice() {
		return price;
	}
	public double getDiscount() {
		return discount;
	}
	public double getPayment() {
		return payment;
	}
	public boolean isWeixin() {
		return isWeixin;
	}
	public List<PayWay> getPayway() {
		return payway;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public void setConductName(String conductName) {
		this.conductName = conductName;
	}
	public void setConductProvider(String conductProvider) {
		this.conductProvider = conductProvider;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public void setWeixin(boolean isWeixin) {
		this.isWeixin = isWeixin;
	}
	public void setPayway(List<PayWay> payway) {
		this.payway = payway;
	}
	
	
}
