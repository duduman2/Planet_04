package login.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserInfo;
import login.service.face.LoginService;
import login.service.impl.LoginServiceImpl;


@WebServlet("/join/con")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginService loginService = new LoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/login/join.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//회원가입 전달파라미터 추출하기
		UserInfo userinfo = loginService.getJoinUserInfo(req);
				
		//회원가입 처리
		loginService.join(userinfo);
				
		//메인으로 리다이렉트
		resp.sendRedirect("/main");
				
	}
   
	
	
}
