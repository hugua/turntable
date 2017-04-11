package biz;

import javax.crypto.Mac;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import dao.ProductsDAO;
import entity.Products;


public class ConductDetailController extends AbstractCommandController{
    private ProductsDAO productDao;
   
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException exception)
			throws Exception {
		int productId = Integer.parseInt(request.getParameter("productid"));
		int couponid = Integer.parseInt(request.getParameter("couponid"));
		ModelAndView mav = new ModelAndView("detail-page");
		Products product = (Products)productDao.findByProductId(productId).get(0);
		product.setProductImg("./image/"+product.getProductImg());
		mav.addObject("product",product);
		mav.addObject("couponid",couponid);
		return mav;
	}
	
	
	public ProductsDAO getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductsDAO productDao) {
		this.productDao = productDao;
	}

}