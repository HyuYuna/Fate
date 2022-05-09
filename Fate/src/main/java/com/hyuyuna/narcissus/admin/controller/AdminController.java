package com.hyuyuna.narcissus.admin.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyuyuna.narcissus.admin.service.AdminService;
import com.hyuyuna.narcissus.admin.vo.UserInfoVO;

@Controller
public class AdminController {
	
	@Resource(name="adminService")
	private AdminService service;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	// 사용자 등록화면
	@RequestMapping(value="/userJoin.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String join() {
		
		return "admin/join.main";
		
	}
	
	// 회원 가입
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(UserInfoVO vo) throws Exception {
		
		try {
			String bcrypt = passwordEncoder.encode(vo.getPassword());
			vo.setPassword(bcrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		service.joinUser(vo);
		
		return "redirect:customerList.do";
	}
	
	// 회원 수정
	@RequestMapping(value="/editUser.do")
	public String editUser(UserInfoVO vo, Model model) throws Exception {

		try {
			String bcrypt = passwordEncoder.encode(vo.getPassword());
			vo.setPassword(bcrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		service.editUser(vo);
		
		return "redirect:customerList.do";
	}
	
	// 아이디 중복체크
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		
		int check = service.idCheck(id);
		
		return check;
	}
	
}
