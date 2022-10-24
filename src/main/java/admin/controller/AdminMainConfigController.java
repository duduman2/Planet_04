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
		
		System.out.println("/admin/mainconfig [GET] Start");
		
		AdminInfo adminInfo = new AdminInfo();
		
		adminInfo = adminService.getAdminInfo(req); // jsp로부터 가져온 요청정보 dto에 저장
		
		// 전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = adminService.getPaging(req, adminInfo);
					
		// 관리자리스트 페이징 목록 조회
		List<AdminInfo> adminList = adminService.getList(paging, adminInfo);
		
		req.setAttribute("userid", adminInfo.getAdminId());
		
		req.setAttribute("paging", paging);
					
		req.setAttribute("adminList", adminList);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminMainConfig.jsp").forward(req, resp);
		
		System.out.println("/admin/mainconfig [GET] End");
		
	}
	
}
