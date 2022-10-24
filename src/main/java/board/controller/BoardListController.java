package board.controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.impl.BoardDaoImpl;
import dto.BoardInfo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private BoardDaoImpl boardService = new BoardDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/webapp/list [GET]");
		
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/webapp/bbs.jsp").forward(req, resp);
		
	}
	
}

























































