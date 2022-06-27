package com.hyuyuna.narcissus.admin.controller;

import java.util.List;

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
import com.hyuyuna.narcissus.admin.vo.AuthorityVO;
import com.hyuyuna.narcissus.admin.vo.UserInfoVO;

@Controller
public class AdminController {
	
	@Resource(name="adminService")
	private AdminService service;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	// 사용자 목록화면
	@RequestMapping(value="/admin/userList.do", method= {RequestMethod.GET, RequestMethod.POST})
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
	
	// 사용자 등록화면
	@RequestMapping(value="/admin/userJoin.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String join() {
		
		return "admin/join.main";
		
	}
	
	// 사용자 상세화면
	@RequestMapping(value="/admin/userDtl.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String userDtl(@RequestParam String userId, Model model) throws Exception {
		
		UserInfoVO detail = service.selectUser(userId);
		model.addAttribute("detail", detail);
		
		List<AuthorityVO> authorityList = service.selectAuthorityList();
		model.addAttribute("authorityList", authorityList);
		
		return "admin/user_dtl.main";
		
	}
	
	// 사용자 가입
	@RequestMapping(value="/admin/join.do", method=RequestMethod.POST)
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
	@RequestMapping(value="/admin/updateUser.do")
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
	@RequestMapping(value="/admin/deleteUser.do")
	public String deleteUser(
			@RequestParam("userId") String userId, Model model) throws Exception {
		
		service.deleteUser(userId);
		
		return "redirect:userList.do";
	}
	
	// 아이디 중복체크
	@RequestMapping(value="/admin/idCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		
		int check = service.idCheck(id);
		
		return check;
	}
	
	// 권한 목록화면
	@RequestMapping(value="/admin/authorityList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String authorityList(Model model) throws Exception {
		
		List<AuthorityVO> list = service.selectAuthorityList();
		
		model.addAttribute("list", list);
		
		return "admin/authority_list.main";
		
	}
	
	// 권한 등록화면
	@RequestMapping(value="/admin/authorityReg.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String authorityReg(Model model) throws Exception {
		
		return "admin/authority_dtl.main";
		
	}
	
	// 권한 등록 및 수정
	@RequestMapping(value="/admin/authoritySave.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String authoritySave(AuthorityVO vo,
			@RequestParam("mode") String mode, Model model) throws Exception {
		
		if (mode.equals("edit")) {
			service.updateAuthority(vo);
		} else {
			service.insertAuthority(vo);
		}
		
		return "redirect:authorityList.do";
		
	}
	
	// 권한 상세화면
	@RequestMapping(value="/admin/authorityDtl.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String authorityDtl(Model model,
			@RequestParam("authorityIdx") int idx ,
		    @RequestParam("mode") String mode) throws Exception {
		
		AuthorityVO detail = service.selectAuthority(idx);
		
		model.addAttribute("detail", detail);
		model.addAttribute("mode", mode);
		
		return "admin/authority_dtl.main";
		
	}
	
	// 권한 삭제
	@RequestMapping(value="/admin/authorityDelete.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String authorityDelete(Model model, AuthorityVO vo,
			@RequestParam("authorityIdx") int idx) throws Exception {
				
		service.deleteAuthority(vo.getAuthorityIdx());
		
		return "redirect:authorityList.do";
	}
	
	// 리소스 목록화면
	@RequestMapping(value="/admin/resourceList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String resourceList(Model model) throws Exception {
				
		List<AuthorityVO> list = service.selectResourceList();
		
		model.addAttribute("list", list);
		
		return "admin/resource_list.main";
	}
	
	// 리소스 등록화면
	@RequestMapping(value="/admin/resourceReg.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String resourceReg(Model model) throws Exception {
		
		List<AuthorityVO> authorityList = service.selectAuthorityList();
		
		model.addAttribute("authorityList", authorityList);
		
		return "admin/resource_dtl.main";
		
	}
	
	// 리소스 상세화면
	@RequestMapping(value="/admin/resourceDtl.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String resourceDtl(Model model,
			@RequestParam("resourceIdx") int idx ,
		    @RequestParam("mode") String mode) throws Exception {
		
		AuthorityVO detail = service.selectResource(idx);
		List<AuthorityVO> authorityList = service.selectAuthorityList();
		
		model.addAttribute("detail", detail);
		model.addAttribute("authorityList", authorityList);
		model.addAttribute("mode", mode);
		
		return "admin/resource_dtl.main";
		
	}
		
	// 리소스 등록 및 수정
	@RequestMapping(value="/admin/resourceSave.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String resourceSave(AuthorityVO vo,
			@RequestParam("mode") String mode, Model model) throws Exception {
		
		if (mode.equals("edit")) {
			service.updateResource(vo);
		} else {
			service.insertResource(vo);
		}
		
		return "redirect:resourceList.do";
		
	}
	

	// 리소스 삭제
	@RequestMapping(value="/admin/resourceDelete.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String resourceDelete(Model model, @RequestParam("resourceIdx") int idx) throws Exception {
				
		service.deleteResource(idx);
		
		return "redirect:resourceList.do";
	}
	
	
}
