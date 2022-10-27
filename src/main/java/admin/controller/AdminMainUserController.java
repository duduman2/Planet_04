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
import dto.UserInfo;

@WebServlet("/admin/mainuser")
public class AdminMainUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/mainuser [GET] Start");
		
		UserInfo userInfo = new UserInfo();
		
		userInfo = adminService.getUserInfo(req); // jsp로부터 가져온 요청정보 dto에 저장
		
		// 전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = adminService.getPaging(req, userInfo);
					
		// 사용자리스트 페이징 목록 조회
		List<UserInfo> userList = adminService.getList(paging, userInfo);
		
		req.setAttribute("userid", userInfo.getU_id());
		
		req.setAttribute("paging", paging);
					
		req.setAttribute("userList", userList);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminMainUser.jsp").forward(req, resp);
		
		System.out.println("/admin/mainuser [GET] End");
		
	}

}
