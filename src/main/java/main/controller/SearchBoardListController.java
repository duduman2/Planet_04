package main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardInfo;
import main.service.face.SearchBoardService;
import main.service.impl.SearchBoardServiceImpl;

@WebServlet("/search")
public class SearchBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서비스 객체
	private SearchBoardService searchBoardService = new SearchBoardServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/search [POST]");
		
		req.setCharacterEncoding("UTF-8");
		
		BoardInfo boardtitle = searchBoardService.getBoardTitle(req);
		
		String type = req.getParameter("searchType");
		String keyword = req.getParameter("keywordInput");
		
		System.out.println(type); //a(통합검색), t(제목), c(내용), n(작성자)
		System.out.println(keyword);
		
		//아무것도 입력하지 않고 검색 시
		if( null!=keyword && "".equals(keyword) ) {
			req.getRequestDispatcher("/WEB-INF/views/search/insert.jsp").forward(req, resp);
		}
		
		//게시글 전체 조회
//		List<Board> boardList = boardService.getList();
		
		
		req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);
		
		
	}
	
}