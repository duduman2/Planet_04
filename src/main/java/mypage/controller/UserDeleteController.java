package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;


@WebServlet("/user/delete")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/delete [GET]");

		//세션 정보 객체
		HttpSession session = req.getSession();
		String u_no = (String) session.getAttribute("u_no");

		//테스트용으로 1을 설정했고
		//	-> 나중에 int userNo = Integer.parseInt(u_no); 로 바꾸기
		int userNo = Integer.parseInt(u_no);
//		int userNo = 1; 
//		int userNo = 2; 
		
		//전달 파라미터 객체 보내기
		UserInfo param = new UserInfo();
		param.setU_no(userNo);
		
		//로그인한 UserInfo 본인 회원 정보 삭제하기
		int data = mypageService.deleteUser(userNo);
		System.out.println("본인 회원 정보 삭제 data :  " + data);
		
		//조회 결과를 MODEL값 전달
		req.setAttribute("data", data);		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/userInfoDelete.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/delete [POST]");

		resp.sendRedirect("/main"); //홈페이지 메인으로 
	
	}
}
