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
import dto.AdminRecode;

@WebServlet("/admin/management")
public class AdminManageMentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/management [GET] Start");
		
		AdminRecode adminRecode = new AdminRecode();
		
		adminRecode = adminService.getAdminInfo2(req);
		
		// 전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = adminService.getPaging(req, adminRecode);
		
		// 관리자리스트 페이징 목록 조회
		List<AdminRecode> adminList = adminService.getList(paging, adminRecode);
		
		req.setAttribute("userid", adminRecode.getAdminid());
		
		req.setAttribute("paging", paging);
					
		req.setAttribute("adminList", adminList);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminManagement.jsp").forward(req, resp);
		
		System.out.println("/admin/management [GET] End");
		
	}

}
