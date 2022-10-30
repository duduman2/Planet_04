package trade.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Payment;
import trade.service.face.BuyService;
import trade.service.face.OrderService;
import trade.service.impl.BuyServiceImpl;
import trade.service.impl.OrderServiceImpl;

@WebServlet("/charging")
public class ChargingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BuyService buyService = new BuyServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[get]충전페이지");
		
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginid");
		int myPoint = buyService.myPoint(loginId);
		
		Payment payment = new Payment();
		payment = orderService.saveOrder(loginId);
//		payment.setPayPrice(Integer.parseInt(req.getParameter("sendPrice")));
		System.out.println("chargingcon - "+payment);
		
		System.out.println("[get]mypoint : " + myPoint);
		req.setAttribute("myPoint",myPoint);
		req.setAttribute("payment",payment);
		
		req.getRequestDispatcher("/WEB-INF/views/trade/charging.jsp").forward(req, resp);
	}
}
