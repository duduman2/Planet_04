package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

// 장바구니 삭제하기 - 
@WebServlet("/cart/delete")
public class CartDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cartDelete/controller [GET]");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cartDelete/controller [POST]");

	
	}
}
