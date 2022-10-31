package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원 등급 안내 - views만 완료
//			(디비는 아직-게시글과 댓글의 수를 이용하여 등급올리기)
@WebServlet("/grade/info")
public class GradeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/grade/info [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/gradeInfo2.jsp").forward(req, resp);
	}


}
