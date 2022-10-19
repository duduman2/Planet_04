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

@WebServlet("/admin/addadmin")
public class AdminMainAddadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/addadmin [GET] Start");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/createadmin.jsp").forward(req, resp);
		
		System.out.println("/admin/addadmin [GET] End");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/addadmin [POST] Start");
		
		AdminInfo adminInfo = new AdminInfo();
		adminInfo = adminService.getAdminInfo(req); // jsp로부터 가져온 요청정보 dto에 저장
		
		Boolean result = adminService.AdminCreate(adminInfo); // dto 정보로 관리자 생성
		
		if( result ) {
			
			resp.sendRedirect("/admin/cresuc");
			
		} else {
			
			resp.sendRedirect("/admin/crefail");
			
		}
		
		System.out.println("/admin/addadmin [POST] End");
		
	}

}
