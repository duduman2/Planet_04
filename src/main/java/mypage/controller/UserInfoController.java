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

//회원 정보 확인하기
@WebServlet("/userInfo/controller")
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/userInfo/controller [GET]");
	
		//세션 정보 객체
		HttpSession session = req.getSession();
		int u_no = (int) session.getAttribute("u_no");

		//테스트용으로 1을 설정함. 
		//	-> 나중에 int userNo = Integer.parseInt(u_no); 로 바꾸기
		int userNo = 1; 
		
		//전달 파라미터
		UserInfo param = new UserInfo();
		param.setU_no(userNo);
		
		//UserInfo 정보 조회하기
//		UserInfo data = mypageService.getClass();
		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/userInfo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/userInfo/controller [POST]");
	
	}
}
