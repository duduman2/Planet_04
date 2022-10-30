package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import admin.service.face.AdminLoginService;
import admin.service.impl.AdminLoginServiceImpl;
import dto.AdminInfo;

@WebServlet("/adminlogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/adminlogin [GET] Start");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminLogin.jsp").forward(req, resp);
		
//		resp.sendRedirect("/WEB-INF/views/admin/adminLogin.jsp"); // 이걸로는 왜 접속이 안되냐
		// WEB-INF 내의 파일은 브라우저에서 직접 접근이 안된다. Controller로만 접근 가능.
		//resp.sendRedirect("/admin/login"); 이건 됨
		
		System.out.println("/adminlogin [GET] End");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/adminlogin [POST] Start");
		
		AdminInfo adminInfo = new AdminInfo();
		
		adminInfo = adminService.getAdminInfo(req); // jsp로부터 가져온 요청정보 dto에 저장
		
		Boolean result = adminService.AdminLogin(adminInfo); // dto 정보로 로그인 여부 비교
		
		if( result ) {
			
			HttpSession session = req.getSession(); // 세션 저장
			
			session.setAttribute("login", result);
			session.setAttribute("userid", adminInfo.getAdminId());
			
			adminService.sendAdminLogin( adminInfo.getAdminId() );
			
			resp.sendRedirect("/admin/mainnotice"); // 이건 GET으로 보내고
//			req.getRequestDispatcher("/admin/main_config").forward(req, resp); // 이건 POST로 보내네
			
		} else {
			
			resp.sendRedirect("/admin/loginfail");
			
		}
		
		System.out.println("/adminlogin [POST] End");
		
	}

}
