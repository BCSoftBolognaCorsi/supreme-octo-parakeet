package net.bcsoft.corsi.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {
	 private List<String> excludedUrls = new ArrayList<>();

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String path = ((HttpServletRequest) request).getServletPath();
		
		System.out.println("doFilter:IN");
		// pass the request along the filter chain
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email != null && !"".equals(email) && email.equals("bcsoft@gmail.com") && password != null && !"".equals(password) && password.equals("password")) {
			httpRequest.getSession(true);
			httpRequest.getSession().setAttribute("auth", true);
		
		}
		
		Optional<HttpSession> session = Optional.ofNullable(httpRequest.getSession(false));
		
		System.out.println("doFilter:OUT");
		if (session.isPresent() && Optional.ofNullable(session.get().getAttribute("auth")).isPresent())
			chain.doFilter(request, response);
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		String excludedUrl = fConfig.getInitParameter("excudedUrl");
		if(excludedUrl != null)
			excludedUrls = Arrays.asList(excludedUrl.split(","));
		
	}

}
