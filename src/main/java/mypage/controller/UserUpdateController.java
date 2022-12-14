package mypage.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import mypage.dao.face.UserInfoDao;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

//로그인한 회원 본인의 정보 수정하기 - views만 완료
//	- 오라클DB - 아이디, 비번만 디비 수정 가능,,,,나머지는 부적합한 열 인덱스+?
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
		int userNo = 21; 
//		int userNo = 2; 
		
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
		int userNo = 21; 
//		int userNo = 2; 		
		
		//전달 파라미터 보내기
		UserInfo param = new UserInfo();

		param.setU_no(userNo);			// 아이디, 비번만 디비 수정 가능,,,,
		param.setU_id(req.getParameter("userid")); 
		param.setU_pw(req.getParameter("userpw"));
//		param.setU_name( req.getParameter("name")); //4 오류  부적합한 열 인덱스
//		param.setU_birth( req.getParameter("birth")); //아쒸 왜 오류?
//		param.setU_gender( req.getParameter("gender")); //오류  부적합한 열 인덱스
//		param.setU_phone( req.getParameter("phone")); //오류 부적합한 열 인덱스
//		param.setU_email( req.getParameter("email"));//8 부적합한 열 인덱스
//		param.setU_address( req.getParameter("add1")); //부적합한 열 인덱스
//		param.setU_nick( req.getParameter("usernick")); //부적합한 열 인덱스
//		param.setU_join_date( req.getParameter("joindate")); //아쒸 왜 오류?
//		param.setU_trade_user( req.getParameter("tradeuser")); //12 //부적합한 열 인덱스
//		param.setB_business_number( req.getParameter("userbsno")); // 부적합한 열 인덱스
//		param.setGrade( req.getParameter("grade"));
//		param.setReportcode( req.getParameter("reportcode"));
//		param.setWishno( req.getParameter("wish_no"));  //16
//		param.setU_point( req.getParameter("userpoint")); //아쒸 왜 오류?
		//17		
		
		System.out.println("회원 정보 수정한 param : " + param);
//		System.out.println("회원 정보 수정한 userbsno : " + param.getB_business_number());
		
		//회원 정보 수정한거 DB에 보내기 
		int result = mypageService.updateUserInfo(param);
		System.out.println("회원 정보 수정한거 DB에 보내기:" + result );
		
		//조회 결과를 MODEL값 전달
//		req.setAttribute("data", data);
		
		resp.sendRedirect("/user/info");
//		resp.sendRedirect("/user/updateResult");
//		req.getRequestDispatcher("/WEB-INF/views/mypage/userInfoModifyResult.jsp").forward(req, resp);
	}
}

