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


@WebServlet("/loginAction/con")
public class LoginActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
		private LoginService loginService = new  LoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/login/loginAction.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전달파라미터 로그인 정보 얻어오기
		UserInfo userinfo = loginService.getLoginUserInfo(req);
				
		//로그인 인증
		boolean isLogin = loginService.login(userinfo);
						
		//로그인 인증 성공
		if( isLogin ) {
							
		//로그인 사용자 정보 조회
		userinfo = loginService.info(userinfo);
							
		//세션정보 객체
		HttpSession session = req.getSession();
							
		session.setAttribute("login", isLogin);
		session.setAttribute("u_id", userinfo.getU_id());
		session.setAttribute("u_nick", userinfo.getU_nick());
							
		}
		
		//메인페이지로 리다이렉트
		resp.sendRedirect("/");
		
	}
	
	
	
}
