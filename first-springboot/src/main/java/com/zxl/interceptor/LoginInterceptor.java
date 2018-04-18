package com.zxl.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zxl.model.User;
import com.zxl.service.UserService;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserService userService;

	private static final String[] IGNORE_URI = { "/index", "/login" };

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws IOException {
		boolean flag = false;
		String url = request.getRequestURL().toString();
		for (String s : IGNORE_URI) {
			if (url.contains(s)) {
				 flag = true;
	             break;
			}
		}
		
		if(!flag) {
			String username = null;
			String password = null;
			HttpSession session = request.getSession();
			if (null != session.getAttribute("username")) {
				username = session.getAttribute("username").toString();
			}
			if (null != session.getAttribute("pwd")) {
				password = session.getAttribute("pwd").toString();
			}
			if (StringUtils.isBlank(username)
					|| StringUtils.isBlank(password)) {
				response.sendRedirect("/login");
				return false;
			} else {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				if (null == userService.checkUser(user)) {
					response.sendRedirect("/login");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
}
