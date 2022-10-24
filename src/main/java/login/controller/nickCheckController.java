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


@WebServlet("/nickCheck/con")
public class nickCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDaoImpl loginDaoImpl = new LoginDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String u_nick = req.getParameter("u_nick");
		// join.jsp에서 받아온 key값이 userId이고
		// value값은 유저가 실제로 적은 값, String userId에는 value값이 들어간다.
		PrintWriter out = resp.getWriter();
				
		LoginDao loginDao = new LoginDaoImpl();
				
		int nickCHcek = loginDao.idCheck(u_nick);

		// 성공여부 확인 : 개발자용
		if (nickCHcek == 0) {
			System.out.println("이미 존재하는 아이디입니다.");
		} else if (nickCHcek == 1) {
			System.out.println("사용 가능한 아이디입니다.");
		}
				
		out.write(nickCHcek + ""); // --> ajax 결과값인 result가 됨
				// --> String으로 값을 내보낼 수 있도록 + "" 를 해준다
		
		
	}
	
	

}
