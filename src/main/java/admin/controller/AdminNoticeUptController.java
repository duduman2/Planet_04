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
import dto.NoticeFile;

@WebServlet("/admin/mainnotice/update")
public class AdminNoticeUptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/mainnotice/update [GET] START");
		
		//전달파라미터 저장 객체 얻기
		Notice noticeno = adminService.getNoticeno(req);
		
		//상세보기 결과 조회
		Notice updateNotice = adminService.view(noticeno);
		
		//조회결과 MODEL값 전달
		req.setAttribute("updateNotice", updateNotice);
		
		//첨부파일 정보 조회
		NoticeFile noticeFile = adminService.viewFile(updateNotice);
		
		//첨부파일 정보를 MODEL값 전달
		req.setAttribute("noticeFile", noticeFile);
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/admin/noticeupdate.jsp").forward(req, resp);
		
		System.out.println("/admin/mainnotice/update [GET] END");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/mainnotice/update [POST] START");
		
		adminService.update(req);
		
		resp.sendRedirect("/admin/uptnotice/success");
		
		System.out.println("/admin/mainnotice/update [POST] END");
	}

}
