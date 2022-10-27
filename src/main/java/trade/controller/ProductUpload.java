package trade.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import trade.service.face.FileService;
import trade.service.impl.FileServiceImpl;

@WebServlet("/trade/productupload")
public class ProductUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스객체
	private FileService fileservice = new FileServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/views/trade/fileupload.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//파일 업로드 형식 검증
		if( !ServletFileUpload.isMultipartContent(req) ) {
			System.out.println("[ERROR] Multipart 형식이 아님");
			
			//요청처리 중단 시키기
			return;
		}
		
		System.out.println("multipart 인코딩 요청");

		//COS 파일 업로드 처리
		fileservice.cosFileupload(req);

		
		//목록 페이지로 리다이렉트
		resp.sendRedirect("/trade");
	}
}
