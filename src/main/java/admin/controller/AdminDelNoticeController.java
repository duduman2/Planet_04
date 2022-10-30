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
import dto.Notice;
import dto.NoticeFile;

@WebServlet("/admin/mainnotice/delete")
public class AdminDelNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/mainnotice/delete [GET] Start");
		
		Notice notice = adminService.getNoticeno(req);
		
		HttpSession session = req.getSession();
		String adminId = (String) session.getAttribute("userid");
		adminService.sendNoticeDelete(adminId, notice);
		
		adminService.deleteNotice(notice);
		
		adminService.deleteNoticeFile(notice, req);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/deletenotice.jsp").forward(req, resp);
		
		System.out.println("/admin/mainnotice/delete [GET] End");
		
	}

}
