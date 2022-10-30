package trade.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Payment;
import trade.service.face.OrderService;
import trade.service.impl.OrderServiceImpl;

@WebServlet("/paysuccess")
public class PaymentSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Payment payment = new Payment();
		
		payment.setPayNo(Integer.parseInt(req.getParameter("merchant_uid")));
		int mypoint = Integer.parseInt(req.getParameter("mypoint"));
		payment.setPayPrice(Integer.parseInt(req.getParameter("amount")));
		HttpSession session = req.getSession();
		payment.setBuyerId((String) session.getAttribute("loginid"));
		orderService.insertPoint(payment);
		
		System.out.println("paysuccess con - " +payment);
		System.out.println("payseccess mypoint - " +mypoint);
	}
}
