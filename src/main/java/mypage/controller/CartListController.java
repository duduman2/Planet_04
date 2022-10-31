package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Cart;
import dto.Product;
import dto.UserInfo;
import mypage.dao.face.UserCartDao;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

// 장바구니 목록 조회 - 구현중
@WebServlet("/cart/list")
public class CartListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cart/list [GET]");
		
// UserInfo 조회해서 cart/product 변수들 꺼내기
		
		//세션 정보 객체
		HttpSession session = req.getSession();
		String u_no = (String) session.getAttribute("u_no");

		//테스트용으로 1을 설정했고
		//	-> 나중에 int userNo = Integer.parseInt(u_no); 로 바꾸기
//		int userNo = Integer.parseInt(u_no);
		int userNo = 21; 
//		int userNo = 2; 
		
		//전달 파라미터 얻어오기
		UserInfo param = new UserInfo();
		param.setU_no(userNo);


		//장바구니 전체 목록을 조회하기 - MypageService 이용함
//		List<Cart> cartlist = mypageService.checkCart(); // 내 DB 전체 장바구니 보여짐...
//		List<Cart> cartlist = mypageService.checkCart(param);
		List<Product> productlist = mypageService.checkCarts(param);
		
		System.out.println( "cart/list/ userNo :" + userNo);
		
		//[test] 조회결과 확인 코드
//		System.out.println("<<--- 장바구니 목록 조회 --->>");
//		for(Cart c : cartlist) System.out.println( c );
		for(Product p : productlist) System.out.println( p );
		
		
		//조회된 결과를 view에 전달하기 
		// -> httpservletrequest 이용해서 -> cartlist로 jsp에 list 객체 전달하기
//		req.setAttribute("cartlist", cartlist);
		req.setAttribute("productlist", productlist);

		req.getRequestDispatcher("/WEB-INF/views/mypage/cartList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cart/list [POST]");
		
//		req.setCharacterEncoding("utf-8");

		
//		Product product = UserCartDao.getParam(req);

		
	}
}
