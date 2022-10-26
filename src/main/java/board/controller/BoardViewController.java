package board.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.face.BoardService;
import board.service.impl.BoardServiceImpl;
import dto.BoardInfo;



@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/view [GET]");
		
		System.out.println("BoardViewController doGet() - boardno : " + req.getParameter("boardno"));
		
		//전달파라미터 객체 얻어오기
		BoardInfo boardno = boardService.getBoardno(req);
		System.out.println("BoardViewController doGet() - boardno객체 : " + boardno);
		
		//게시글 상세보기 조회 결과 얻어오기
		BoardInfo viewBoard = boardService.view( boardno );
		System.out.println("BoardViewController doGet() - viewBoard : " + viewBoard);
	
		//조회결과를 MODEL값으로 전달
		req.setAttribute("viewBoard", viewBoard);
		
		
		//작성자 닉네임 전달
//		req.setAttribute("writerNick", boardService.getWriteNick(viewBoard));

		
		//첨부파일 정보 조회
//		BoardFile boardFile = boardService.viewFile(viewBoard);
		
		//첨부파일 정보를 MODEL값 전달
//		req.setAttribute("boardFile", boardFile);

		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(req, resp);
		
	}
	
}


