package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminLoginService;
import admin.service.impl.AdminLoginServiceImpl;
import dto.Notice;

@WebServlet("/admin/mainnotice")
public class AdminMainNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/mainnotice [GET] START");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminMainNotice.jsp").forward(req, resp);
		
		System.out.println("/admin/mainnotice [GET] END");
	}

}
