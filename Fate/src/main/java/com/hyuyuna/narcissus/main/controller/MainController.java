package com.hyuyuna.narcissus.main.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyuyuna.narcissus.common.SessionManager;
import com.hyuyuna.narcissus.main.service.MainService;
import com.hyuyuna.narcissus.main.vo.UserVO;

@Controller
public class MainController {
	
	@Resource(name="mainService")
	private MainService service;
	
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
	public String login() {
		
		return "login";
		
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
	
	// 로그인
	@RequestMapping(value="/actionLogin.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(UserVO vo, ModelMap model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		try {
			String decrypt = passwordEncoder.encode(vo.getPassword());
			vo.setCheckPwd(decrypt);
			UserVO user = service.login(vo);
			if (user == null) {
				model.addAttribute("message","로그인에 실패하였습니다");
				return "redirect:login.do";
			} else {
				/*
				 * Cookie idCookie = new Cookie("userId", String.valueOf(user.getId()));
				 * response.addCookie(idCookie);
				 */
				/*sessionManager.createSession(user, response);*/
				HttpSession session = request.getSession();
				session.setAttribute("login", user);
				session.setMaxInactiveInterval(3000);
				
				return "redirect:main.do";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "로그인에 실패하였습니다");
			return "redirect:login.do";
		}
		
	}
	
	
}
