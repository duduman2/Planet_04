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
import dto.AdminInfo;
import dto.UserInfo;

@WebServlet("/admin/deluser")
public class AdminMainDeluserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/deluser [GET] Start");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/deleteuser.jsp").forward(req, resp);
		
		System.out.println("/admin/deluser [GET] End");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/deluser [POST] Start");
		
		UserInfo userInfo = new UserInfo();
		userInfo = adminService.getUserInfo(req); // jsp로부터 가져온 요청정보 dto에 저장
		
		Boolean result = adminService.UserDelete(userInfo); // dto 정보로 관리자 제거
		
		if( result ) {
			
			HttpSession session = req.getSession();
			String adminId = (String) session.getAttribute("userid");
			adminService.sendUserDelete(adminId, userInfo);
			
			resp.sendRedirect("/admin/delsuc");
			
		} else {
			
			resp.sendRedirect("/admin/delfail");
			
		}
		
		System.out.println("/admin/deluser [POST] End");
		
	}

}
