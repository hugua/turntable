package biz;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import dao.PrizeDAO;
import entity.Prize;

public class insertPrizeController extends AbstractCommandController {
	private PrizeDAO prizedao;
	public PrizeDAO getPrizedao() {
		return prizedao;
	}
	public void setPrizedao(PrizeDAO prizedao) {
		this.prizedao = prizedao;
	}
	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		String productID = arg0.getParameter("productid");
		String couponID = arg0.getParameter("couponid");
		String phoneNumber = (String) arg0.getSession().getAttribute("phonenumber");

		if(phoneNumber == null){
			System.out.println("ÓÃ»§Î´µÇÂ¼³é½±£¡");
		}else{
			int productid = Integer.parseInt(productID);
			int conponid = Integer.parseInt(couponID);
			Date date = new Date();
			Prize p = new Prize(phoneNumber,conponid,productid,date);
			System.out.println("³é½±¼ÍÂ¼   phonenumber="+phoneNumber+"  couponID="+conponid+" productID="+productid+"  date=" + date );
			prizedao.save(p);
		}
		
		return null;
	}

}
