package main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//---검색---
		req.setCharacterEncoding("UTF-8");
		
		//요청 정보에서 전달 파라미터 추출
		String type = req.getParameter("searchType");
		String keyword = req.getParameter("keywordInput");
		
		System.out.println( "검색 타입 : " + type ); //a(통합검색), t(제목), c(내용), n(작성자)
		System.out.println( "검색 키워드 : " + keyword );
		
		
		//keyword에 내용물을 입력하고 검색할 경우
		if( null!=keyword && !"".equals(keyword) ) {
			
			req.setAttribute("type", type);
			req.setAttribute("keyword", keyword);
			
			if( type.equals("a") ) {//통합검색
				
				//전체 게시글에서 keyword이 포함된 게시글 찾기
				List<BoardInfo> board = searchBoardService.all(keyword);
				System.out.println( board );
				
				//조회결과가 없을 경우
				if( board.isEmpty() ) {
					String msg = "에 대한 검색결과가 없습니다";
					System.out.println(keyword + msg);
					
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);
					
				} else {
					
					req.setAttribute("board", board);
					
					req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);
				}
				
				
			} else if( type.equals("t") ) {//제목검색
				
				//전체 게시글에서 제목에 keyword가 포함된 게시글 찾기
				List<BoardInfo> board = searchBoardService.title(keyword);
				System.out.println( board );
				
				//조회결과가 없을 경우
				String msg = "에 대한 검색결과가 없습니다";
				if( board.isEmpty() ) {
					System.out.println(keyword + msg);
					
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);

				} else {
					req.setAttribute("board", board);
					
					req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);
				}
				
			} else if( type.equals("c") ) {//내용검색
				
				//전체 게시글에서 내용에 keyword가 포함된 게시글 찾기
				List<BoardInfo> board = searchBoardService.content(keyword);
				System.out.println( board );
				
				//조회결과가 없을 경우
				String msg = "에 대한 검색결과가 없습니다";
				if( board.isEmpty() ) {
					System.out.println(keyword + msg);
					
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);

					
				} else {
					req.setAttribute("board", board);
					
					req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);
				}
				
			} else {//작성자 검색
				
				//전체 게시글에서 작성자가 keyword인 게시글 찾기
				List<BoardInfo> board = searchBoardService.writer(keyword);
				System.out.println( board );
				
				//조회결과가 없을 경우
				String msg = "에 대한 검색결과가 없습니다";
				if( board.isEmpty() ) {
					System.out.println(keyword + msg);
					
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);

				} else {
				
					req.setAttribute("board", board);
					
					req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);
				}
				
			}
			
		} else {
			
			//아무것도 입력하지 않고 검색 시
			req.getRequestDispatcher("/WEB-INF/views/search/insert.jsp").forward(req, resp);
		}
	}
}