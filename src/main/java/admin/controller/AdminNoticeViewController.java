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

@WebServlet("/admin/mainnotice/view")
public class AdminNoticeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/mainnotice/view [GET] START");
		
		//전달파라미터 객체 얻어오기
		Notice notice = adminService.getNoticeno(req);
		
		String originname = adminService.getOriginname( notice );
		String storedname = adminService.getStoredname( notice );
		
		//게시글 상세보기 조회 결과 얻어오기
		Notice viewNotice = adminService.noticeView( notice );
		
		//조회결과를 MODEL값으로 전달
		req.setAttribute("originname", originname);
		req.setAttribute("storedname", storedname);
		req.setAttribute("viewNotice", viewNotice);
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/admin/noticeview.jsp").forward(req, resp);
		
		System.out.println("/admin/mainnotice/view [GET] END");
	}

}
