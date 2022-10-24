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

@WebServlet("/admin/srhuser")
public class AdminMainSrhuserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/srhuser [GET] Start");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/searchuser.jsp").forward(req, resp);
		
		System.out.println("/admin/srhuser [GET] End");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/srhuser [POST] Start");
		
		UserInfo userInfo = new UserInfo();
		userInfo = adminService.getUserInfo(req); // jsp로부터 가져온 요청정보 dto에 저장
		
		userInfo = adminService.UserSearch(userInfo);
		
		if(userInfo.getU_pw() != null) {
			
			req.setAttribute("userInfo", userInfo);
			
			req.getRequestDispatcher("/WEB-INF/views/admin/updateuser.jsp").forward(req, resp);
			
		} else {
			
			resp.sendRedirect("/admin/delfail");
			
		}
		
		System.out.println("/admin/srhuser [POST] End");
		
	}

}
