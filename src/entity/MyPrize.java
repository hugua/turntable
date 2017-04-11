package entity;

import java.sql.Date;

public class MyPrize {

	private int price;
	private String couponDesc;
	private int productid;
	private int couponid;
	private String valitime;
	private boolean vali;



	public boolean isVali() {
		return vali;
	}

	public void setVali(boolean vali) {
		this.vali = vali;
	}

	public String getValitime() {
		return valitime;
	}

	public void setValitime(String valitime) {
		this.valitime = valitime;
	}

	public int getProductid() {
		return productid;
	}

	public MyPrize(int price, String couponDesc, int productid, int couponid,String valitime) {
		super();
		this.price = price;
		this.couponDesc = couponDesc;
		this.productid = productid;
		this.couponid = couponid;
		this.valitime = valitime;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getCouponid() {
		return couponid;
	}

	public void setCouponid(int couponid) {
		this.couponid = couponid;
	}

	public MyPrize(String CouponDesc,int price){
		this.price = price;
		this.couponDesc = CouponDesc;
	}

	public String getCouponDesc() {
		return couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
