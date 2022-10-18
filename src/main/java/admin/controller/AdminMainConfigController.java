package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.service.face.AdminLoginService;
import admin.service.impl.AdminLoginServiceImpl;
import common.Paging;
import dto.AdminInfo;

@WebServlet("/admin/mainconfig")
public class AdminMainConfigController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/main [GET] Start");
		
		HttpSession session = req.getSession();
		
		// Object형태인 session을 String을 거쳐 Boolean으로 변환
		Boolean sessionStatus = Boolean.valueOf( String.valueOf( session.getAttribute("login") ) );
		
		if( sessionStatus ) {
			
			// 전달파라미터에서 현재 페이징 객체 계산하기
			Paging paging = adminService.getPaging(req);
			
			req.setAttribute("paging", paging);
			
			List<AdminInfo> adminList = adminService.getList( paging );
			
			req.setAttribute("adminList", adminList);
			
			req.getRequestDispatcher("/WEB-INF/views/admin/adminMainConfig.jsp").forward(req, resp);
			
		} else {
			
			req.getRequestDispatcher("/WEB-INF/views/admin/adminMainFail.jsp").forward(req, resp);
			
		}
		
		System.out.println("/admin/main [GET] End");
		
	}
	
}
