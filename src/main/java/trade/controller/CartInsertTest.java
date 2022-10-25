package trade.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cart/listtest")
public class CartInsertTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("cartlist-get");
		
		System.out.println("productno - "+req.getParameter("productNo"));
		System.out.println("productname - "+req.getParameter("productName"));
		System.out.println("productprice - "+req.getParameter("productPrice"));
		System.out.println("productquan - "+req.getParameter("productQuan"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post");
		
		System.out.println(req.getParameter("productNo"));
	}
}
