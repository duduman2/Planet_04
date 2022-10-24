package trade.service.impl;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dto.Product;
import trade.dao.face.ProductDao;
import trade.dao.impl.ProductDaoImpl;
import trade.service.face.ProductViewService;

public class ProductViewServiceImpl implements ProductViewService {

	private ProductDao productDao = new ProductDaoImpl();
	@Override
	public Product getProductNo(HttpServletRequest req, Product product) {
		String param = req.getParameter("productno");
		if(null != param && !"".equals(param)) {
			product.setProductNo(Integer.parseInt(param));
		}
		
		System.out.println("boardno : " + product.getProductNo());
		return product;
	}

	@Override
	public Product view(Product product) {
//		productDao.updateHit(product);
		Product view = productDao.selectBoardByProductno(JDBCTemplate.getConnection(),product);
		return view;
	}

}
