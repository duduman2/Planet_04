package trade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

			//파일 전체 목록 조회하기
			List<Uploadfile> list = fileService.list();

			//[TEST] 조회 결과 확인
//			for(Uploadfile file : list) System.out.println(file);

			//조회결과를 모델값으로 전달하기
			req.setAttribute("list",list);

			//View지정 및 포워드
			req.getRequestDispatcher("/WEB-INF/views/trade/tradeboard.jsp").forward(req, resp);
		}
}
