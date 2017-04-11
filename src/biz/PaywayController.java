package biz;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.mysql.jdbc.Statement;

import util.ImageURL;
import util.Tags;
import dao.CouponsDAO;
import dao.PrizeDAO;
import dao.ProductsDAO;
import entity.Bill;
import entity.Coupons;
import entity.PayWay;
import entity.Prize;
import entity.Products;


public class PaywayController extends AbstractCommandController{
	
	private CouponsDAO couponsDAO;
	private ProductsDAO productsDAO;
	private PrizeDAO prizedao;
	
	public PrizeDAO getPrizedao() {
		return prizedao;
	}

	public void setPrizedao(PrizeDAO prizedao) {
		this.prizedao = prizedao;
	}



	public Bill createBill(String phonenumber, int couponId, int productId){
		Bill bill = new Bill();

		Products product = (Products)productsDAO.findByProductId(productId).get(0);
		Coupons coupon = (Coupons)couponsDAO.findByCouponId(couponId).get(0);
		
		bill.setConductName(product.getProductName());
        bill.setConductProvider(product.getSeller());
        bill.setPrice(product.getPrice());
        bill.setDiscount(coupon.getDiscount());
        bill.setPayment(product.getPrice()-coupon.getDiscount());
        bill.setShopName("和商汇微店");
        Prize prize = new Prize(phonenumber,couponId,productId);
        System.out.println("aa");
        ArrayList<Prize> ps = (ArrayList<Prize>) prizedao.findByExample(prize);
        System.out.println("findByExample size = " + ps.size());
        if(ps.size()>0){
        	prizedao.delete(ps.get(0));
        	System.out.println("删除成功: pid: "+couponId+", proid: "+productId);
        }
        
		return bill;
	}
	
	public CouponsDAO getCouponsDAO() {
		return couponsDAO;
	}
	public ProductsDAO getProductsDAO() {
		return productsDAO;
	}

	public void setCouponsDAO(CouponsDAO couponsDAO) {
		this.couponsDAO = couponsDAO;
	}

	public void setProductsDAO(ProductsDAO productsDAO) {
		this.productsDAO = productsDAO;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException exception)
			throws Exception {
		ModelAndView mav = new ModelAndView("payway");
		Bill bill = null;
		/*-- 判断请求的浏览器信息：判断是否来自微信 --*/
		String ua = ((HttpServletRequest) request).getHeader("user-agent")
		          .toLowerCase();
		System.out.println(ua);
        if (ua.indexOf("mobile") > 0 || ua.indexOf("micromessenger") > 0) {// 是微信浏览器
           System.out.println("来自微信的请求");
           mav.addObject("p1", new PayWay(Tags.weixinPay,ImageURL.weixinImage));
           mav.addObject("p2", new PayWay(Tags.aliPay,ImageURL.aliImage));
        }else{
           mav.addObject("p1", new PayWay(Tags.aliPay,ImageURL.aliImage));
           mav.addObject("p2", new PayWay(Tags.unionPay,ImageURL.unionPayImage));
        }
        int productid = Integer.parseInt(request.getParameter("productid").trim());
        int couponid = Integer.parseInt(request.getParameter("couponid").trim());
        bill = createBill((String)request.getSession().getAttribute("phonenumber"),couponid,productid);
        if(bill==null)
        	System.out.println("Bill is null!!!");
        mav.addObject("bill", bill);
        

		return mav;
	}

}
