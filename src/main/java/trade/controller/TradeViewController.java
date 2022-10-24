package trade.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import trade.service.face.ProductViewService;
import trade.service.impl.ProductViewServiceImpl;

@WebServlet("/tradeboard/tradeview")
public class TradeViewController extends HttpServlet {

	private ProductViewService productViewService  = new ProductViewServiceImpl();
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		Product product = new Product();
		
		product = productViewService.getProductNo(req, product);
		

		productViewService.view(product);
		
		req.setAttribute("view", product);
		
		req.getRequestDispatcher("/WEB-INF/views/trade/tradeview.jsp").forward(req, resp);
	}

}
