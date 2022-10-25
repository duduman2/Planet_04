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

// 마이페이지 메인
@WebServlet("/mypage/main")
public class MypageMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/main [GET] 시작");
	
		//세션 정보 객체
		HttpSession session = req.getSession();
		String u_nick = (String) session.getAttribute("u_nick");		
		
		// 조회해서 닉네임 꺼내기
		
		
		//테스트용
//		String userNick = "바나나";
		
		
		//전달 파라미터 객체 얻어오기
//		UserInfo param = new UserInfo();
//		param.setU_no(userNo);
		
		//UserInfo 정보 조회하기
//		UserInfo data = mypageService.showUserInfo(param);
//		System.out.println("UserInfo 정보 조회 data :  " + data);		
		
		//조회 결과를 MODEL값 전달
//		req.setAttribute("data", data);		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/main.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/main [Post]");

	
	}
}
