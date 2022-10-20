package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 전달파라미터의 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 요청 정보를 서블릿(다음 필터)으로 전달한다 -> 필터 체인
		chain.doFilter(request, response);
		
	}

}
