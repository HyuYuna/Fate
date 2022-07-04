package com.hyuyuna.narcissus.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyuyuna.narcissus.admin.service.AuthorityService;
import com.hyuyuna.narcissus.admin.vo.AuthorityVO;

@Controller
public class AuthorityController {
	
	@Resource(name="authorityService")
	private AuthorityService authorityService;
	
	// 권한 목록화면
	@RequestMapping(value="/admin/authorityList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String authorityList(Model model) throws Exception {
		
		List<AuthorityVO> list = authorityService.selectAuthorityList();
		
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
			authorityService.updateAuthority(vo);
		} else {
			authorityService.insertAuthority(vo);
		}
		
		return "redirect:authorityList.do";
		
	}
	
	// 권한 상세화면
	@RequestMapping(value="/admin/authorityDtl.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String authorityDtl(Model model,
			@RequestParam("authorityIdx") int idx ,
		    @RequestParam("mode") String mode) throws Exception {
		
		AuthorityVO detail = authorityService.selectAuthority(idx);
		
		model.addAttribute("detail", detail);
		model.addAttribute("mode", mode);
		
		return "admin/authority_dtl.main";
		
	}
	
	// 권한 삭제
	@RequestMapping(value="/admin/authorityDelete.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String authorityDelete(Model model, AuthorityVO vo,
			@RequestParam("authorityIdx") int idx) throws Exception {
				
		authorityService.deleteAuthority(vo.getAuthorityIdx());
		
		return "redirect:authorityList.do";
	}
	
	
}
