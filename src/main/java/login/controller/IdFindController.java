package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import login.service.face.LoginService;
import login.service.impl.LoginServiceImpl;



@WebServlet("/id/find")
public class IdFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/login/idFind.jsp").forward(req, resp);
				
	}

			
			
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		UserInfo userinfo = loginService.getFindUserInfo(req);
		
		System.out.println(userinfo);
		
		
		UserInfo u_id = loginService.findId(userinfo);
		
		System.out.println(u_id);


		req.setAttribute("u_id", u_id);
		
		req.getRequestDispatcher("/WEB-INF/views/login/idFindAction.jsp").forward(req, resp);
		

				
		
	}
	
	

	
	
	
}
