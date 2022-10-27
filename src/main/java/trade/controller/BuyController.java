package trade.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Product;
import trade.service.face.BuyService;
import trade.service.impl.BuyServiceImpl;

@WebServlet("/buybuy")
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스객체
	private BuyService buyService = new BuyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Product product = new Product();
		
		product.setProductNo(Integer.parseInt(req.getParameter("productNo")));
		product.setProuserId(req.getParameter("productUser"));
		product.setProductPrice(Integer.parseInt(req.getParameter("productPrice")));
		int proquan = Integer.parseInt(req.getParameter("productQuan"));
		
		System.out.println("판매정보 : " + product + "수량 : " + proquan);
		
		String sellUserId = req.getParameter("productUser");
		System.out.println("판매자 id : " + sellUserId);
		
		HttpSession session = req.getSession();
		
		System.out.println("로그인 session id확인 : " + session.getAttribute("loginid"));
		String loginId = (String) session.getAttribute("loginid");
		
		int point = product.getProductPrice() * proquan; 
		buyService.pointSend(loginId, sellUserId, point);
		
		int callpoint = buyService.myPoint(loginId);
		
		
		req.setAttribute("buyinfo",product);
		req.setAttribute("proquan",proquan);
		req.getRequestDispatcher("/WEB-INF/views/trade/buy.jsp").forward(req, resp);
	}
}
