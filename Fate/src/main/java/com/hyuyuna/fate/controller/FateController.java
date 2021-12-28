package com.hyuyuna.fate.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyuyuna.narcissus.common.FileVO;
import com.hyuyuna.narcissus.common.MemberVO;
import com.hyuyuna.narcissus.service.FateService;

@Controller
public class FateController {
	
	@Resource(name="fateService")
	private FateService service;
	
	@Autowired
	private SessionManager sessionManager;
	
	 public interface sessionDefine {
		 String loginFate = "HyuYuna";
	 } 
	
	@RequestMapping(value="/main.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String Main() {
		
		return "login";
		
	}
	
	@RequestMapping(value="/logout.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpServletResponse response, HttpServletRequest request) {
		/*expiredCookie(response, "memberId");
		try {
			sessionManager.expire(request);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:memberList.do"; 
	}
	
	private void expiredCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	} 
	
	@RequestMapping(value="/login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(MemberVO vo, ModelMap model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		try {
			String decrypt = SHA256.encrypt(vo.getPwd());
			vo.setCheckPwd(decrypt);
			MemberVO member = service.login(vo);
			if (member == null) {
				model.addAttribute("message","로그인에 실패하였습니다");
				return "redirect:main.do";
			} else {
				/*
				 * Cookie idCookie = new Cookie("memberId", String.valueOf(member.getId()));
				 * response.addCookie(idCookie);
				 */
				/*sessionManager.createSession(member, response);*/
				HttpSession session = request.getSession();
				session.setAttribute("login", member);
				session.setMaxInactiveInterval(3000);
				
				return "redirect:memberList.do";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "로그인에 실패하였습니다");
			return "redirect:main.do";
		}
		
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(MemberVO vo) throws Exception {
		
		try {
			String shaPass = SHA256.getSHA256(vo.getPwd());
			vo.setPwd1(shaPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		service.joinUser(vo);
		
		return "redirect:memberList.do";
	}
	
}
