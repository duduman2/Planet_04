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
import dto.AdminInfo;
import dto.Notice;

@WebServlet("/admin/mainnotice")
public class AdminMainNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/mainnotice [GET] START");
		
		Notice notice = new Notice();
		
		notice = adminService.getNoticeInfo(req);
		
		Paging paging = adminService.getPaging1(req, notice);
		
		List<Notice> noticeList = adminService.getList1(paging, notice);
		
		req.setAttribute("result", true);
		req.setAttribute("title", notice.getTitle());
		
		req.setAttribute("paging", paging);
		req.setAttribute("noticeList", noticeList);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminMainNotice.jsp").forward(req, resp);
		
		System.out.println("/admin/mainnotice [GET] END");
	}

}
