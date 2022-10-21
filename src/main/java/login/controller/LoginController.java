package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import login.service.face.LoginService;
import login.service.impl.LoginServiceImpl;


@WebServlet("/login/con")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private LoginService loginService = new  LoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/login/con [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		//전달파라미터 로그인 정보 얻어오기
		UserInfo userinfo = loginService.getLoginUserInfo(req);
		
		int result = loginService.login(userinfo.getU_id(), userinfo.getU_pw());

        req.setAttribute("result", result);
	
	
		req.getRequestDispatcher("/WEB-INF/views/login/loginAction.jsp").forward(req, resp);
		
	}

}
