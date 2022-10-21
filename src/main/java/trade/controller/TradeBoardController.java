package trade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardInfo;
import dto.Product;
import dto.Uploadfile;
import trade.service.face.FileService;
import trade.service.impl.FileServiceImpl;

@WebServlet("/tradeboard")
public class TradeBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
		private FileService fileService = new FileServiceImpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			Product product = new Product();
			List<Product> boardList = fileService.boardList(product);
			
//			for(Product i : boardList) {
//				System.out.println(i);
//			}

			//조회결과를 모델값으로 전달하기
			req.setAttribute("boardList",boardList);

			//View지정 및 포워드
			req.getRequestDispatcher("/WEB-INF/views/trade/tradeboard.jsp").forward(req, resp);
		}
}
