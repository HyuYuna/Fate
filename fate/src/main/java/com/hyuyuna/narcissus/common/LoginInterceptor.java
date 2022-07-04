package com.hyuyuna.narcissus.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("login");
		
		String requestUrl = request.getRequestURL().toString();
		
		if(requestUrl.contains("/main.do")) {
			return true;
		} else if(requestUrl.contains("/login.do")) {
			return true;
		}
		
		if (obj == null) {
			response.sendRedirect("/main.do");
			return false;
		}
		return super.preHandle(request,response,handler);
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
		
	}
	
}
