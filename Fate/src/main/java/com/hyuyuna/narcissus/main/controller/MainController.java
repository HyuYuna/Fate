package com.hyuyuna.narcissus.main.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyuyuna.narcissus.common.SessionManager;

@Controller
public class MainController {
	
	@Autowired
	private SessionManager sessionManager;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Value("#{directory['globals.filesDir']}")
	private String imagesDir;
	
	 public interface sessionDefine {
		 String loginMain = "HyuYuna";
	 } 
	
	@RequestMapping(value="/main.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String main() {
		
		return "redirect:customerList.do";
		
	}
	
	// 로그인
	@RequestMapping(value="/login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpServletRequest request) {
		
		String fail = request.getParameter("fail") == null ? "" : request.getParameter("fail");
		
		if(fail.equals("true")) {
			return "login";
		}
		
		AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
		if (trustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
			return "login";
		} else { 
			return "redirect:customerList.do";
		}
		
	}
	
	// 로그아웃
	/*@RequestMapping(value="/logout.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpServletResponse response, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:login.do"; 
	}*/
	
	// 쿠키 만료시간 설정
	private void expiredCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	} 
	
	
}
