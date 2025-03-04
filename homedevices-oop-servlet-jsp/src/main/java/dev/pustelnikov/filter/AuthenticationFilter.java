package dev.pustelnikov.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpServletRequest.getSession();
		String user = (String) httpSession.getAttribute("username");
		String uri = httpServletRequest.getRequestURI();
		if (user != null || uri.contains("/login") || uri.contains("/css")) {
			chain.doFilter(request, response);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
