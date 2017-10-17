package com.synisys.training.filters;

import javax.servlet.*;
import java.io.IOException;

public class LoginFilter
		implements Filter {

	public static final String USERNAME_FIELD_NAME = "username_input";
	public static final String PASSWORD_FIELD_NAME = "password_input";
	public static final String USERNAME = "user";
	public static final String PASSWORD = "12345";

	@Override public void init(FilterConfig filterConfig)
			throws ServletException {

	}

	@Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain)
			throws IOException, ServletException {
		if (servletRequest.getParameter(USERNAME_FIELD_NAME).equals(USERNAME) && servletRequest.getParameter(
				PASSWORD_FIELD_NAME).equals(PASSWORD)) {
			filterChain.doFilter(servletRequest, servletResponse);
		}
		else {
			servletResponse.getWriter().print("Authentication Failed!");
		}
	}

	@Override public void destroy() {

	}
}
