package trade.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import trade.service.face.FileService;
import trade.service.impl.FileServiceImpl;
import trade.util.Paging;

@WebServlet("/tradelist")
public class TradeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[post]tradelist - " + req.getParameter("cate"));
		
		String cl = req.getParameter("cate");
		System.out.println("분류 : " + cl);
		Paging paging = fileService.getPaging(req,cl);
		
		
		req.setAttribute("paging", paging);
		Product product = new Product();
		
		List<Product> boardList = fileService.boardList(product, cl, paging);
		
		
		//조회결과를 모델값으로 전달하기
		req.setAttribute("boardList",boardList);
		req.getRequestDispatcher("/WEB-INF/views/trade/tradelist.jsp").forward(req, resp);
	}
}
