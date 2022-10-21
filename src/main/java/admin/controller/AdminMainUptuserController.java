package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		req.getRequestDispatcher("/WEB-INF/views/admin/searchuser.jsp").forward(req, resp);
		
		System.out.println("/admin/uptuser [GET] End");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/uptuser [POST] Start");
		
		/*
		UserInfo userInfo = new UserInfo();
		userInfo = adminService.getUserInfo(req); // jsp로부터 가져온 요청정보 dto에 저장
		
		Boolean result = adminService.UserDelete(userInfo); // dto 정보로 관리자 제거
		
		if( result ) {
			
			resp.sendRedirect("/admin/delsuc");
			
		} else {
			
			resp.sendRedirect("/admin/delfail");
			
		}
		*/
		
		System.out.println("/admin/uptuser [POST] End");
		
	}
	
}
