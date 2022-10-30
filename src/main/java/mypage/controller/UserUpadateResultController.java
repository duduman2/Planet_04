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

//필요없는 파일!!!!
//로그인한 회원 본인의 정보 확인하기 - views만 완료(디비는 아직)
@WebServlet(name = "UserUpdateResultController", urlPatterns = { "/user/updateResult" })
public class UserUpadateResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/updateResult [GET]");
		
		//세션 정보 객체
		HttpSession session = req.getSession();
		String u_no = (String) session.getAttribute("u_no");
		
//		int userNo = Integer.parseInt(u_no);
		int userNo = 31;
//		int userNo = 2; 
		
		//전달 파라미터 객체 얻어오기
		UserInfo param = new UserInfo();
		param.setU_no(userNo);
		
		
		System.out.println("userInfoModifyResult - userNo : " + userNo);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/userInfoModifyResult.jsp").forward(req, resp);
	}

}
