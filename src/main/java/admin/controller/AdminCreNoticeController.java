package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/crenotice")
public class AdminCreNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/crenotice [GET] START");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/createnotice.jsp").forward(req, resp);
		
		System.out.println("/admin/crenotice [GET] END");
	}

}
