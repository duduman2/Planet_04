package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminLoginService;
import admin.service.impl.AdminLoginServiceImpl;
import dto.BoardInfo;

@WebServlet("/admin/mainboard/delete")
public class AdminMainDelBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/mainnotice [GET] START");
		
		BoardInfo boardInfo = new BoardInfo();
		
		boardInfo.setBoardNo( Integer.parseInt(req.getParameter("boardno")) );
		
		adminService.deleteBoard(boardInfo);
		
		doPost(req, resp);
		
		System.out.println("/admin/mainnotice [GET] END");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/mainnotice [POST] START");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/deleteboard.jsp").forward(req, resp);
		
		System.out.println("/admin/mainnotice [POST] END");
	}

}
