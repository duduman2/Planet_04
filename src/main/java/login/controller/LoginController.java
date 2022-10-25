package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import login.dao.face.LoginDao;
import login.dao.impl.LoginDaoImpl;
import login.service.face.LoginService;
import login.service.impl.LoginServiceImpl;


@WebServlet("/login/con")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
//	private LoginService loginService = new  LoginServiceImpl();
	private LoginDao loginDao = new LoginDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/login/con [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		//전달 파라미터 얻기
		String u_id = req.getParameter("u_id");
		String u_pw = req.getParameter("u_pw");
				
		System.out.println("LoginController doPost() - u_id : " + u_id);
		System.out.println("LoginController doPost() - u_pw : " + u_pw);
		
		LoginService loginService = new LoginServiceImpl();
		UserInfo userinfo = loginService.selectOneMember(u_id, u_pw);
		
		if( userinfo != null ) {
			System.out.println("LoginController doPost() - 로그인 성공");
			
			//세션 객체
			HttpSession session = req.getSession(true);
			
			//세션 정보 저장하기
			session.setAttribute("login", true);		//로그인 상태
			session.setAttribute("loginid", u_id);	//로그인한 아이디
			
			req.getRequestDispatcher("/WEB-INF/views/login/loginSuccess.jsp").forward(req, resp);
			
			
		} else {
			System.out.println("LoginController doPost() - 로그인 실패");
			
			req.getRequestDispatcher("/WEB-INF/views/login/loginFail.jsp").forward(req, resp);
			
		}
		
		
		
	}



}
