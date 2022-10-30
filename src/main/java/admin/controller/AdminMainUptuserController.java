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
import dto.UserInfo;

@WebServlet("/admin/uptuser")
public class AdminMainUptuserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/uptuser [GET] Start");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setU_id( req.getParameter("userid") );
		
		userInfo = adminService.UserSearch(userInfo);
		
		req.setAttribute("userInfo", userInfo);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/updateuser.jsp").forward(req, resp);
		
		System.out.println("/admin/uptuser [GET] End");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/uptuser [POST] Start");
		
		UserInfo userInfo = new UserInfo();
		
		userInfo = adminService.UserSearch2(req);
		
		System.out.println(userInfo);
		
		Boolean result = adminService.UserUpdate(userInfo); // dto 정보로 관리자 생성
		
		if( result ) {
			
			HttpSession session = req.getSession();
			String adminId = (String) session.getAttribute("userid");
			adminService.sendUserUpdate(adminId, userInfo);
			
			resp.sendRedirect("/admin/cresuc");
			
		} else {
			
			resp.sendRedirect("/admin/crefail");
			
		}
		
		System.out.println("/admin/uptuser [POST] End");
	}
	
}
