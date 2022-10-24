package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import login.dao.face.LoginDao;
import login.dao.impl.LoginDaoImpl;
import login.service.impl.LoginServiceImpl;



@WebServlet("/id/find")
public class IdFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDaoImpl loginDaoImpl = new LoginDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/login/idFind.jsp").forward(req, resp);
				
	}

			
			
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		String u_id = req.getParameter("u_id");
		String u_name = req.getParameter("u_name");
		String u_email = req.getParameter("u_email");
		
		System.out.println("u_id : " + u_id);
		
		//세션 객체
		HttpSession session = req.getSession();
		
		//세션 정보 저장하기
		session.setAttribute("loginid", u_id);
		
		req.getRequestDispatcher("/WEB-INF/views/login/idFindAction.jsp").forward(req, resp);
		

				
		
	}
	
	

	
	
	
}
