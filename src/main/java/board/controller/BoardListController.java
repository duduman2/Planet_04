package board.controller;

import java.io.IOException;



import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardInfo;
import common.Paging;
import board.service.face.BoardService;
import board.service.impl.BoardServiceImpl;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
		private BoardService boardService = new BoardServiceImpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("/board/list [GET]");
			
			
			//전달파라미터에서 현재 페이징 객체 계산하기
			Paging paging = boardService.getPaging(req);
			System.out.println("[TEST] " + paging);
			
			//페이징 객체를 MDOEL값 전달
			req.setAttribute("paging", paging);
			
			
			
			//게시글 전체 조회
//			List<BoardInfo> boardList = boardService.getList();
			
			//게시글 페이징 목록 조회
			List<BoardInfo> boardList = boardService.getList( paging );
			
			//[TEST] 조회결과 확인
//			for(Board b : boardList)	System.out.println(b);
			
			//조회결과를 MODEL값 전달
			req.setAttribute("boardList", boardList);
			
			
			
			//View 지정 및 응답
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
//			req.getRequestDispatcher("/WEB-INF/views/board/bbs.jsp").forward(req, resp); //이게됨
//			req.getRequestDispatcher("/WEB-INF/views/board/index.jsp").forward(req, resp);
			
			//redirect
//			resp.sendRedirect("/board/bbs.jsp");
			
		}
		
	}
























































