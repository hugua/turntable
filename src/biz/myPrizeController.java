package biz;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import dao.CouponsDAO;
import dao.PrizeDAO;
import entity.Coupons;
import entity.MyPrize;
import entity.Prize;

public class myPrizeController extends AbstractCommandController {
	private CouponsDAO conpondao;
	private PrizeDAO prizedao;
	public CouponsDAO getConpondao() {
		return conpondao;
	}
	public void setConpondao(CouponsDAO conpondao) {
		this.conpondao = conpondao;
	}
	public PrizeDAO getPrizedao() {
		return prizedao;
	}
	public void setPrizedao(PrizeDAO prizedao) {
		this.prizedao = prizedao;
	}
	
	public Date getValiDate(Date date){
		Date validate = new Date();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			validate = df.parse(df.format(date));
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 7);
			return cal.getTime();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public boolean getVali(Date date){
		boolean v = false;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
        	Date dt1 = df.parse(df.format(new Date()));
			Date dt2 = df.parse(df.format(date));
			if(dt1.getTime() >= dt2.getTime()){
				v = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return v;
	}
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		ModelAndView model = null;
		String phonenumber = (String) arg0.getSession().getAttribute("phonenumber");
		if(phonenumber == null){
			System.out.println("未登录查看我的奖品");
			model = new ModelAndView("login.do");
		}else{
			ArrayList<MyPrize> myprize = new ArrayList<MyPrize>();
			ArrayList<Prize> prizes = (ArrayList<Prize>) prizedao.findByPhoneNumber(phonenumber);
			if(prizes.size()>0 ){
				System.out.println("prize size=" + prizes.size() );
				for(int i=0;i<prizes.size();i++){
					int  couponid = prizes.get(i).getCouponId();
					Date date = prizes.get(i).getDate();
					ArrayList<Coupons>  c =  (ArrayList<Coupons>) conpondao.findByCouponId(couponid);
					String desc =  c.get(0).getCouponDescription();
					int price = c.get(0).getDiscount();
					int productid = c.get(0).getProductId();
					String valitime = null;	
					Date validate  = getValiDate(date);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					valitime = df.format(validate);
					MyPrize p = new MyPrize(price,desc,productid,couponid,valitime);
					p.setVali(getVali(validate));
					myprize.add(p);
				}
			}else{
				System.out.println("no prize");
			}
			model = new ModelAndView("myprize");
			model.addObject("myprize", myprize);
		}
		return model;
	}
	

}
