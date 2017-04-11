package biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import dao.UsersDAO;
import entity.Users;

public class ValiateTimes extends AbstractCommandController{
	
	private UsersDAO usersDAO;

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException exception)
			throws Exception {
		System.out.println(command.toString()+"--------------------");
		String phone = null;
		if(request.getParameter("phonenumber")!=null){
			phone = request.getParameter("phonenumber").trim();
		}else{
			System.out.println("获取参数失败!");
		};
		ModelAndView mav = new ModelAndView("");	
		System.out.println(phone);
		List result = usersDAO.findByPhoneNumber(phone);
		Users user = null;
		if(usersDAO!=null){
			user = (Users) result.get(0);
		}
		
		if(user != null && user.getTimes()>0){
			user.setTimes(user.getTimes()-1);
			usersDAO.attachDirty(user);
		}
		return mav;
	}

}