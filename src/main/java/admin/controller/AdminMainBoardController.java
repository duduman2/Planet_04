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
import dto.BoardInfo;
import dto.UserInfo;

@WebServlet("/admin/mainboard")
public class AdminMainBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/mainboard [GET] Start");
		
		BoardInfo boardInfo = new BoardInfo();
		
		boardInfo = adminService.getBoardInfo(req); // jsp로부터 가져온 요청정보 dto에 저장
		
		System.out.println(boardInfo);
		
		// 전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = adminService.getPaging(req, boardInfo);
					
		// 사용자리스트 페이징 목록 조회
		List<BoardInfo> boardList = adminService.getList(paging, boardInfo);
		
		req.setAttribute("title", boardInfo.getBoardTitle());
		
		req.setAttribute("paging", paging);
					
		req.setAttribute("boardList", boardList);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminMainBoard.jsp").forward(req, resp);
		
		System.out.println("/admin/mainboard [GET] End");
		
	}

}
