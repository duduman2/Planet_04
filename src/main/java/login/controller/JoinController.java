package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import login.dao.face.LoginDao;
import login.dao.impl.LoginDaoImpl;
import login.service.face.LoginService;
import login.service.impl.LoginServiceImpl;



@WebServlet("/join/con")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginService loginService = new LoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/login/join.jsp").forward(req, resp);
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		String u_id = req.getParameter("u_id");
		// join.jsp에서 받아온 key값이 userId이고
		// value값은 유저가 실제로 적은 값, String userId에는 value값이 들어간다.
		PrintWriter out = resp.getWriter();
				
		LoginDao loginDao = new LoginDaoImpl();
				
		int idCHcek = loginDao.idCheck(u_id);

		// 성공여부 확인 : 개발자용
		if (idCHcek == 0) {
			System.out.println("이미 존재하는 아이디입니다.");
		} else if (idCHcek == 1) {
			System.out.println("사용 가능한 아이디입니다.");
		}
				
		out.write(idCHcek + ""); // --> ajax 결과값인 result가 됨
				// --> String으로 값을 내보낼 수 있도록 + "" 를 해준다
		
		

		
	
		//회원가입 전달파라미터 추출하기
		UserInfo userinfo = loginService.getJoinUserInfo(req);
				
		//회원가입 처리
		loginService.join(userinfo);
				
		//메인으로 리다이렉트
		resp.sendRedirect("/main");
				
	}
	
}
	
	

