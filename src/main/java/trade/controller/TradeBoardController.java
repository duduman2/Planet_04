package trade.controller;

import java.io.IOException;
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

@WebServlet("/trade")
public class TradeBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체

	private FileService fileService = new FileServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cl = req.getParameter("cate");
		if(cl==null) cl="all";
		System.out.println("분류 : " + cl);
		
		Paging paging = fileService.getPaging(req,cl);
		System.out.println("[TEST] " + paging);
//		System.out.println(paging.getTotalCount()%paging.getListCount());
		req.setAttribute("paging", paging);
		Product product = new Product();
		
		List<Product> boardList = fileService.boardList(product, cl, paging);
		
		req.setAttribute("boardList",boardList);
		req.getRequestDispatcher("/WEB-INF/views/trade/trade.jsp").forward(req, resp);
	}
}
