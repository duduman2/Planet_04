package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Cart;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

// 장바구니 목록 조회 - 구현 완료
@WebServlet("/carList/controller")
public class CartListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/carList/controller [GET]");
		
//		req.setCharacterEncoding("utf-8");
		
		//장바구니 전체 목록을 조회하기 - MypageService 이용함
		List<Cart> cartlist = mypageService.checkCart();
		
		
		//[test] 조회결과 확인 코드
		System.out.println("<<--- 장바구니 목록 조회 --->>");
		for(Cart c : cartlist) System.out.println( c );
		
		
		//조회된 결과를 view에 전달하기 
		// -> httpservletrequest 이용해서 -> cartlist로 jsp에 list 객체 전달하기
		req.setAttribute("cartlist", cartlist);

		req.getRequestDispatcher("/WEB-INF/views/mypage/cartList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/carList/controller [POST]");
		
		 // doPost 이거 필요없는거 같은데?????
	}
}
