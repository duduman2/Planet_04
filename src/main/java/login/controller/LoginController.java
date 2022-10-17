package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login/con")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/login/con [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("login/con [POST]");
		
		//전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
				
		//전달 파라미터 얻기
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
				
		System.out.println("LoginController doPost() - userid : " + userid);
		System.out.println("LoginController doPost() - userpw : " + userpw);
				
		//-------------------------------------------------
				
				
		//로그인 인증 - 제대로된 ID&PASS 인지 검사
		if( "planet".equals(userid) && "planet123".equals(userpw) ) {
				System.out.println("LoginController doPost() - 로그인 성공");
					
				//세션 객체
				HttpSession session = req.getSession();
						
				//세션 정보 저장하기
				session.setAttribute("login", true);		//로그인 상태
				session.setAttribute("loginid", userid);	//로그인한 아이디
						
				req.getRequestDispatcher("/WEB-INF/views/login/loginSuccess.jsp").forward(req, resp);
					
					
			} else {
				System.out.println("LoginController doPost() - 로그인 실패");
					
				req.getRequestDispatcher("/WEB-INF/views/login/loginFail.jsp").forward(req, resp);
					
				}		
		
	}

	
	
}
