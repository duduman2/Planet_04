package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminUptSucController
 */
@WebServlet("/admin/uptnotice/success")
public class AdminUptSucController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("/admin/uptnotice/success [GET] START");
			
			req.getRequestDispatcher("/WEB-INF/views/admin/uptnoticesuc.jsp").forward(req, resp);
		
			System.out.println("/admin/uptnotice/success [GET] End");
		}

}
