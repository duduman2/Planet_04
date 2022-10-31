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

// 마이페이지 메인 - 구현중
@WebServlet("/mypage/main")
public class MypageMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Service 객체 선언
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/main [GET] 시작");
	
// UserInfo 조회해서 닉네임/회원등급 꺼내기
		// 나중에 포인트값/ 내가쓴글ctn 추가하기!!!
	
		//세션 정보 객체
		HttpSession session = req.getSession();
//		String u_nick = (String) session.getAttribute("u_nick");		
//		String grade = (String) session.getAttribute("grade");	
		String u_no = (String) session.getAttribute("u_no");
		// 포인트값/ 내가쓴글ctn 추가하기!!!
		
//		Integer.parseInt(u_no);
//		int userNo = Integer.parseInt(u_no);
		int userNo = 21;
//		int userNo = 2; 
		
		//전달 파라미터 객체 얻어오기
		UserInfo param = new UserInfo();
		param.setU_no(userNo);
		
		
		//UserInfo 정보 조회 후 값 전달하기
		UserInfo data = mypageService.showUserInfo(param);
		System.out.println("UserInfo 조회 data :  " + data);

//		System.out.println("UserInfo 조회 u_nick :  " + data.getU_nick());
//		System.out.println("UserInfo 조회 grade :  " + data.getGrade());
//		System.out.println("UserInfo 조회 getU_point :  " + data.getU_point());

//		int boardcnt = mypageService.showStory(param);
//		System.out.println("UserInfo 조회 후 boardcnt : " + boardcnt);
		
		
		//조회 결과를 MODEL값 전달
		req.setAttribute("data", data);	
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/main.jsp").forward(req, resp);
	}

}
