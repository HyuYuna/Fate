package com.hyuyuna.narcissus.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyuyuna.narcissus.admin.service.AuthorityService;
import com.hyuyuna.narcissus.admin.service.ResourceService;
import com.hyuyuna.narcissus.admin.vo.AuthorityVO;

@Controller
public class ResourceController {
	
	@Resource(name="authorityService")
	private AuthorityService authorityService;
	
	@Resource(name="resourceService")
	private ResourceService resourceService;
	
	// 리소스 목록화면
	@RequestMapping(value="/admin/resourceList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String resourceList(Model model) throws Exception {
				
		List<AuthorityVO> list = resourceService.selectResourceList();
		
		model.addAttribute("list", list);
		
		return "admin/resource_list.main";
	}
	
	// 리소스 등록화면
	@RequestMapping(value="/admin/resourceReg.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String resourceReg(Model model) throws Exception {
		
		List<AuthorityVO> authorityList = authorityService.selectAuthorityList();
		
		model.addAttribute("authorityList", authorityList);
		
		return "admin/resource_dtl.main";
		
	}
	
	// 리소스 상세화면
	@RequestMapping(value="/admin/resourceDtl.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String resourceDtl(Model model,
			@RequestParam("resourceIdx") int idx ,
		    @RequestParam("mode") String mode) throws Exception {
		
		AuthorityVO detail = resourceService.selectResource(idx);
		List<AuthorityVO> authorityList = authorityService.selectAuthorityList();
		
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
			resourceService.updateResource(vo);
		} else {
			resourceService.insertResource(vo);
		}
		
		return "redirect:resourceList.do";
		
	}
	

	// 리소스 삭제
	@RequestMapping(value="/admin/resourceDelete.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String resourceDelete(Model model, @RequestParam("resourceIdx") int idx) throws Exception {
				
		resourceService.deleteResource(idx);
		
		return "redirect:resourceList.do";
	}
	
	
}
