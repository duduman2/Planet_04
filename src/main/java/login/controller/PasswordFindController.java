package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserInfo;
import login.service.face.LoginService;
import login.service.impl.LoginServiceImpl;


@WebServlet("/password/find")
public class PasswordFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/login/pwFind.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
				
//		UserInfo userinfo = loginService.getFindPwUserInfo(req);
		
		UserInfo userinfo = loginService.getFindUserInfo(req);
		
		System.out.println(userinfo);
				
				
		UserInfo u_pw = loginService.findPw(userinfo);
				
		System.out.println(u_pw);


		req.setAttribute("u_pw", u_pw);
				
		req.getRequestDispatcher("/WEB-INF/views/login/pwFindAction.jsp").forward(req, resp);
	
	}

	
	
	
	
}
