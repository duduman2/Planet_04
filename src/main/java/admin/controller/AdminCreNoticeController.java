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

@WebServlet("/admin/crenotice")
public class AdminCreNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/crenotice [GET] START");
		
		HttpSession session = req.getSession();
		
		Object admin_id = session.getAttribute("userid");
		
		req.setAttribute("admin_id", admin_id);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/createnotice.jsp").forward(req, resp);
		
		System.out.println("/admin/crenotice [GET] END");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/crenotice [POST] START");
		
		//작성글 삽입
		adminService.write(req);
		
		//목록으로 리다이렉트
		resp.sendRedirect("/admin/cresuc");
		
		System.out.println("/admin/crenotice [POST] END");
	}

}
