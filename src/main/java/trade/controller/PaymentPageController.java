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
import trade.service.face.PaymentService;
import trade.service.impl.BuyServiceImpl;
import trade.service.impl.PaymentServiceImpl;

@WebServlet("/paypay")
public class PaymentPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PaymentService paymentService = new PaymentServiceImpl();
	private BuyService buyService = new BuyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/trade/buysuccess.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("구매완료페이지!!!");
		Product product = new Product();
		System.out.println(req.getParameter("productNo"));
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
		
		int point = product.getProductPrice() * proquan; //차감될 포인트 
		System.out.println("차감될 포인트 : " + point);
		int mypointBefore = buyService.myPoint(loginId); //차감전 포인트
		System.out.println("차감전 포인트 : " + point);
		paymentService.pointSend(loginId, sellUserId, point);
		int mypointAfter = buyService.myPoint(loginId);	//차감후 포인트
		System.out.println("차감후 포인트 : " + point);
		
		
		req.setAttribute("buyinfo",product);
		req.setAttribute("mypointBefore",mypointBefore);
		req.setAttribute("mypointAfter",mypointAfter);
		
	}
}
