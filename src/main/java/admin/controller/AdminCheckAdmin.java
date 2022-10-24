package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import admin.service.face.AdminLoginService;
import admin.service.impl.AdminLoginServiceImpl;
import dto.AdminInfo;

@WebServlet("/admin/checkadmin")
public class AdminCheckAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginService adminService = new AdminLoginServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/admin/checkadmin [POST] Start");
		
		AdminInfo adminInfo = new AdminInfo();
		
		adminInfo.setAdminId( req.getParameter("n1") );
		
		if(adminInfo.getAdminId() == "") {
			req.getRequestDispatcher("/WEB-INF/views/admin/nullresult.jsp").forward(req, resp);
			
			return;
		}
		
		Boolean result = adminService.AdminCheck(adminInfo);
		
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/checkresult.jsp").forward(req, resp);
		
//		resp.getWriter().println("{\"result\":"+ result+"}");
//		req.getRequestDispatcher("/WEB-INF/views/admin/createadmin.jsp").forward(req, resp);
		
		System.out.println("/admin/checkadmin [POST] End");
		
	}

}
