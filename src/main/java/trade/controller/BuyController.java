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
		System.out.println("결제전 확인!!!!!!!!!!!");
		Product product = new Product();
		
		//받아와서 확인
		product.setProductNo(Integer.parseInt(req.getParameter("productNo")));
		product.setProuserId(req.getParameter("productUser"));
		product.setProductPrice(Integer.parseInt(req.getParameter("productPrice")));
		int proquan = Integer.parseInt(req.getParameter("productQuan"));
		System.out.println("판매정보 : " + product + "수량 : " + proquan);
		
		//판매자 확인
		String sellUserId = req.getParameter("productUser");
		System.out.println("판매자 id : " + sellUserId);
		
		//구매자 아이디 받기
		HttpSession session = req.getSession();
		System.out.println("session 로그인 id확인 : " + session.getAttribute("loginid"));
		String loginId = (String) session.getAttribute("loginid");
		
		//아이디로 내 포인트 확인
		int mypoint = buyService.myPoint(loginId);
		
		req.setAttribute("mypoint", mypoint);
		req.setAttribute("buyinfo",product);
		req.setAttribute("proquan",proquan);
		req.getRequestDispatcher("/WEB-INF/views/trade/buy.jsp").forward(req, resp);
	}
}
