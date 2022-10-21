package main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/search [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/search/insert.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/search [POST]");
		
		req.setCharacterEncoding("UTF-8");
		
		String type = req.getParameter("searchType");
		String keyword = req.getParameter("keywordInput");
		
		System.out.println(type); //a(통합검색), t(제목), c(내용), n(작성자)
		System.out.println(keyword);
		
		req.getRequestDispatcher("/WEB-INF/views/search/list.jsp").forward(req, resp);
		
		
	}
	
}