package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value = { "/admin/mainconfig", "/admin/mainboard", "/admin/mainuser", "/admin/addadmin", "/admin/deladmin" })
public class AdminSessionFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		// Object형태인 session을 String을 거쳐 Boolean으로 변환
		Boolean sessionStatus = Boolean.valueOf( String.valueOf( session.getAttribute("login") ) );
		
		if( sessionStatus ) {
			
			// 요청 정보를 서블릿(다음 필터)으로 전달한다 -> 필터 체인
			chain.doFilter(request, response);
			
		} else {
			
			req.getRequestDispatcher("/WEB-INF/views/admin/adminMainFail.jsp").forward(req, resp);
			
		}
		
	}

}
