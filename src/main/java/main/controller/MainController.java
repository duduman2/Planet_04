package main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardInfo;
import dto.Product;
import main.service.face.SearchBoardService;
import main.service.impl.SearchBoardServiceImpl;
import trade.service.face.ProductViewService;
import trade.service.impl.ProductViewServiceImpl;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private SearchBoardService searchBoardService = new SearchBoardServiceImpl();
	private ProductViewService productViewService  = new ProductViewServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/ [GET]");
		
		//게시글 전체 조회
		List<BoardInfo> boardList = searchBoardService.getList();
		req.setAttribute("boardlist", boardList);
		
		//상품 전체 조회
//		Product product = new Product();
//		product = productViewService.getProductNo(req, product);
		List<Product> productList = searchBoardService.getProductList();
		for(Product p : productList)	System.out.println(p);
//		productViewService.view(product);	
		req.setAttribute("view", productList);
		
		req.getRequestDispatcher("/WEB-INF/views/main/main.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/ [POST]");
		
		
	}
	
}
