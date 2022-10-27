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


@WebServlet("/user/update")
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/update [GET]");

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
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/userInfoModify.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/update [POST]");
		
		//전달 파라미터의 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");

		//세션 정보 객체
		HttpSession session = req.getSession();
		String u_no = (String) session.getAttribute("u_no");
		
//		int userNo = Integer.parseInt(u_no);
//		int userNo = 1; 
		int userNo = 2; 		
		
		//전달 파라미터 보내기
		UserInfo param = new UserInfo();
		
		param.setU_no(userNo);
		param.setU_name( req.getParameter("name"));
		
		
		
		resp.sendRedirect("/user/info");
	}
}
