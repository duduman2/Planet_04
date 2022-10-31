package trade.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trade.service.face.ProductViewService;
import trade.service.impl.ProductViewServiceImpl;

@WebServlet("/tradedelete")
public class TradeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductViewService productViewService  = new ProductViewServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(Integer.parseInt(req.getParameter("productNo")));
		productViewService.delete(Integer.parseInt(req.getParameter("productNo")));
		req.getRequestDispatcher("/WEB-INF/views/trade/delete.jsp").forward(req, resp);
	}
}
