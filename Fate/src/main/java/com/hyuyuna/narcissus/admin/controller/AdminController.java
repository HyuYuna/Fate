package com.hyuyuna.narcissus.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	
	// 사용자 목록화면
	@RequestMapping(value="/userList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String userList(UserInfoVO vo, Model model, HttpServletRequest request,
			@RequestParam(required=false, defaultValue="1") int range) throws Exception {
		
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int listCnt = service.userCnt(vo);
		
		vo.setPage(page);
		vo.setRange(range);
		vo.setListCnt(listCnt);
		vo.pageInfo(page, range, listCnt);
		
		List<UserInfoVO> list = service.selectUserList(vo);
		
		model.addAttribute("vo", vo);
		model.addAttribute("cnt", listCnt);
		model.addAttribute("list", list);
		
		return "admin/user_list.main";
		
	}
	
	// 사용자 목록화면
	@RequestMapping(value="/userDtl.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String userDtl(@RequestParam String userId, Model model) throws Exception {
		
		UserInfoVO detail = service.selectUser(userId);
		
		List<Map<String, Object>> authorityList = service.selectAuthorityList();
		
		model.addAttribute("detail", detail);
		model.addAttribute("authorityList", authorityList);
		
		return "admin/user_dtl.main";
		
	}
	
	// 사용자 가입
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
	
	// 사용자 수정
	@RequestMapping(value="/updateUser.do")
	public String updateUser(UserInfoVO vo, Model model) throws Exception {

		try {
			String bcrypt = passwordEncoder.encode(vo.getPassword());
			vo.setPassword(bcrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		service.updateUser(vo);
		
		return "redirect:userList.do";
	}
	
	// 사용자 삭제
	@RequestMapping(value="/deleteUser.do")
	public String deleteUser(
			@RequestParam("userId") String userId, Model model) throws Exception {
		
		service.deleteUser(userId);
		
		return "redirect:userList.do";
	}
	
	// 아이디 중복체크
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		
		int check = service.idCheck(id);
		
		return check;
	}
	
}
