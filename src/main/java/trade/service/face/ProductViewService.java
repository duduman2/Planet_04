package trade.service.face;

import javax.servlet.http.HttpServletRequest;

import dto.Product;

public interface ProductViewService {

	Product getProductNo(HttpServletRequest req, Product product);

	Product view(Product product);

}
