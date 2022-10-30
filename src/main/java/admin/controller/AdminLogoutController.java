package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.service.face.AdminLoginService;
import admin.service.impl.AdminLoginServiceImpl;

@WebServlet("/adminlogout")
public class AdminLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/adminlogin [GET] Start");

		// 세션 객체 생성
		HttpSession session = req.getSession();
		
		String adminId = (String) session.getAttribute("userid");
		
		adminService.sendAdminLogout( adminId );
		
		// 세션 객체 삭제
		// -> 세션 정보를 포함한 모든 것이 삭제된다
		session.invalidate();
		
		// 세션 확인 페이지로 리다이렉트
		req.getRequestDispatcher("/WEB-INF/views/admin/adminMainFail.jsp").forward(req, resp);
		
		System.out.println("/adminlogin [GET] End");
	}
	
}
