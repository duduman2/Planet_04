package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.face.LoginDao;
import login.dao.impl.LoginDaoImpl;


@WebServlet("/emailCheck/con")
public class emailCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String u_email = req.getParameter("u_email");
		// join.jsp에서 받아온 key값이 userId이고
		// value값은 유저가 실제로 적은 값, String userId에는 value값이 들어간다.
		PrintWriter out = resp.getWriter();
				
		LoginDao loginDao = new LoginDaoImpl();
				
		int emailCHcek = loginDao.emailCheck(u_email);

		// 성공여부 확인 : 개발자용
		if (emailCHcek == 0) {
			System.out.println("이미 존재하는 이메일입니다.");
		} else if (emailCHcek == 1) {
			System.out.println("사용 가능한 이메일입니다.");
		}
				
		out.write(emailCHcek + ""); // --> ajax 결과값인 result가 됨
				// --> String으로 값을 내보낼 수 있도록 + "" 를 해준다
		
		
	}

	
	
}
