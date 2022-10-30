package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원 탈퇴 정상 페이지 - views만 완료(디비는 아직)
@WebServlet("/userdelete/result")
public class UserDeleteResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/userdelete/result [GET]");
		
		//userinfo 디비 지우기
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/userDeleteResult.jsp").forward(req, resp);
	}
}
