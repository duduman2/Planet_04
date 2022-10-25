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

//로그인한 회원 본인의 정보 확인하기
@WebServlet("/user/info")
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/info [GET]");
	
		//세션 정보 객체
		HttpSession session = req.getSession();
		String u_no = (String) session.getAttribute("u_no");

		//테스트용으로 1을 설정했고
		//	-> 나중에 int userNo = Integer.parseInt(u_no); 로 바꾸기
//		int userNo = Integer.parseInt(u_no);
//		int userNo = 1; 
		int userNo = 2; 
		
		//전달 파라미터 객체 얻어오기
		UserInfo param = new UserInfo();
		param.setU_no(userNo);
		
		//UserInfo 정보 조회하기
		UserInfo data = mypageService.showUserInfo(param);
		System.out.println("UserInfo 정보 조회 data :  " + data);
		
		//조회 결과를 MODEL값 전달
		req.setAttribute("data", data);
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/mypage/userInfo.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/info [POST]");
		// [POST] 없어도 될듯?????
	}
}
