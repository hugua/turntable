package biz;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import dao.CouponsDAO;
import dao.CustomerbaseDAO;
import dao.ProductsDAO;
import dao.UsersDAO;
import entity.BigTurnEntity;
import entity.Coupons;
import entity.Customerbase;
import entity.LoginEntity;
import entity.ProductEntity;
import entity.Products;
import entity.Users;

public class LoginController extends AbstractCommandController {
	private UsersDAO userdao;
	private CouponsDAO coupondao;
	private CustomerbaseDAO customerbasedao;
	private ProductsDAO productdao;
	
	public CouponsDAO getCoupondao() {
		return coupondao;
	}

	public void setCoupondao(CouponsDAO coupondao) {
		this.coupondao = coupondao;
	}

	public CustomerbaseDAO getCustomerbasedao() {
		return customerbasedao;
	}

	public void setCustomerbasedao(CustomerbaseDAO customerbasedao) {
		this.customerbasedao = customerbasedao;
	}

	public ProductsDAO getProductdao() {
		return productdao;
	}

	public void setProductdao(ProductsDAO productdao) {
		this.productdao = productdao;
	}

	public UsersDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UsersDAO userdao) {
		this.userdao = userdao;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		HttpSession session = arg0.getSession();
		ModelAndView model = new ModelAndView("turntable");
		//清除session值，方便测试
		if(arg0.getParameter("clear")!=null && arg0.getParameter("clear").equals("1")){
			System.out.println(("clear login"));
			session.setAttribute("login", "0");
			session.setAttribute("phonenumber", "");
			session.setAttribute("time", "0");
			session.setAttribute("tip", "0");
			return model;
		}
		//构建实体类对象
		LoginEntity login = (LoginEntity) arg2;
		String number = null;
		
		if(session.getAttribute("login")==null || !session.getAttribute("login").equals("1")){
			//session。login不存在或者值不为1表示还未进行登录，厦门进行session设置
			session.setAttribute("login", "1");
			number = login.getFname();
			session.setAttribute("phonenumber", number);
			System.out.println(number);
			System.out.println("not login in!");
		}else{
			number = (String) session.getAttribute("phonenumber");
			session.setAttribute("login", "1");
			System.out.println("login in!");
		}
		System.out.println(session.getAttribute("phonenumber"));
		if(number != null){
			BigTurnEntity bigturn = new BigTurnEntity();
			//根据手机号码查找用户抽奖次数和客群信息
			ArrayList<Users> user = (ArrayList<Users>) userdao.findByPhoneNumber(number.trim());	
			if(user.size()>0){
				bigturn.setTimes(user.get(0).getTimes());
				session.setAttribute("time", user.get(0).getTimes()+"");
				ArrayList<Customerbase> c =  (ArrayList<Customerbase>) customerbasedao.findByCustomerBase(user.get(0).getCustomerBase());		
				for(int i=0;i<c.size();i++){	
					ArrayList<Coupons> coupons =  (ArrayList<Coupons>) coupondao.findByCouponId(c.get(i).getCouponId());
					ArrayList<Products>  product = (ArrayList<Products>) productdao.findByProductId(c.get(i).getProductId());
					ProductEntity p = new ProductEntity(c.get(i).getProductId(),c.get(i).getProductProblity(),c.get(i).getCouponId(),"./image/"+product.get(0).getProductImg(),product.get(0).getProductName(),coupons.get(0).getCouponDescription(),"./image/"+coupons.get(0).getCustomerImg());
					model.addObject("product"+i,p);
				}
				model.addObject("time", bigturn);
				// 清除异常处理信息
				session.setAttribute("tip", "0");
				System.out.println("账户存在！");
			}else{
				/*--------------登录用户不存在处理--------------------*/
				session.setAttribute("tip", "1");
				session.setAttribute("login", "0");
				session.setAttribute("phonenumber", null);
				session.setAttribute("time", "0");
				System.out.println("账户不存在");
			}
		}else{
			System.out.println("phonenumber is null");
		}
	
		return model;
	}

}
