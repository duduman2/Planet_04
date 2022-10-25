package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminLoginService;
import admin.service.impl.AdminLoginServiceImpl;
import common.Paging;
import dto.Notice;

@WebServlet("/admin/mainnotice2")
public class AdminMainNoticeController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/mainnotice2 [GET] START");
		
		Notice notice = new Notice();
		
		notice = adminService.getNoticeInfo(req);
		
		Paging paging = adminService.getPaging2(req, notice);
		
		List<Notice> noticeList = adminService.getList2(paging, notice);
		
		req.setAttribute("result", false);
		req.setAttribute("admin_id", notice.getAdmin_id());
		
		req.setAttribute("paging", paging);
		req.setAttribute("noticeList", noticeList);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminMainNotice.jsp").forward(req, resp);
		
		System.out.println("/admin/mainnotice2 [GET] END");
	}

}
