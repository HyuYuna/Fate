package com.hyuyuna.narcissus.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyuyuna.narcissus.common.SHA256;
import com.hyuyuna.narcissus.common.SessionManager;
import com.hyuyuna.narcissus.service.MemberService;
import com.hyuyuna.narcissus.vo.MemberVO;
import com.hyuyuna.narcissus.vo.ReplyVO;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	MemberService service;
	
	@Autowired
	private SessionManager sessionManager;
	
	
	@RequestMapping(value="/form.do")
	public String form(Model model) throws Exception {
		return "member/member_dtl.main";
	}
	
	@RequestMapping(value="/example.do")
	public String example(Model model, HttpServletRequest request) throws Exception {
		
		MemberVO member = (MemberVO)sessionManager.getSession(request);
		
		return "example.main";
	}
	
	@RequestMapping(value="/grid.do")
	public String grid(Model model) throws Exception {
		return "grid.main";
	}
	
	@RequestMapping(value="/save.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String insert(MemberVO vo,
				@RequestParam("mode") String mode) throws Exception {

		if(mode.equals("edit")) {
			service.updateMember(vo);
		} else {
			service.insertMember(vo);
		}
		
		return "redirect:memberList.do";
	}
	
	@RequestMapping(value="/memberList.do")
	public String list(MemberVO vo, Model model, HttpServletRequest request,
			@RequestParam(required= false, defaultValue = "1") int range) throws Exception{
		
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page")); 
		int listCnt = service.memberCnt(vo);
		
		vo.setPage(page);
		vo.setRange(range);
		vo.setListCnt(listCnt);
		vo.pageInfo(page, range, listCnt);
		
		List<MemberVO> list = service.selectAllMember(vo);
		
		model.addAttribute("vo", vo);
		model.addAttribute("cnt", listCnt);
		model.addAttribute("list", list);
		
		return "member/member_list.main";
	}
	
	/*@RequestMapping(value="/memberListJson.do")
	public ModelAndView memberListJson(HttpSession session,
					@ModelAttribute("MemberVO") MemberVO vo){
		
		ModelAndView mnv = new ModelAndView("jsonView");
		
		List<MemberVO> memberList = service.selectAllMember(vo);
		//int cnt = service.memberCnt(vo);
		
		mnv.addObject("list",memberList);
		
		return mnv;
	} */

	@RequestMapping(value="/memberListJson.do", method=RequestMethod.POST)
	@ResponseBody
	public MemberVO memberListJson(
						@RequestParam(value="page", required=false) String page,
						@RequestParam(value="rows", required=false) String rows,
						@RequestParam(value="sidx", required=false) String sidx,
						@RequestParam(value="sord", required=false) String sord) {
		
		List<Map<String,Object>> memberList = service.selectAllMemberJson();
		MemberVO obj = new MemberVO();
		obj.setRows(memberList);

		return obj;
	} 
	
	@RequestMapping(value="/delete.do")
	public String delete(MemberVO vo) throws Exception {
		service.deleteMember(vo.getCustno());
		return "redirect:memberList.do";
	}
	
	
	@RequestMapping(value="/memberView.do")
	public String memberView(MemberVO vo, Model model) throws Exception {
		
		MemberVO detail = service.selectMember(vo.getCustno());
		
		model.addAttribute("detail", detail);

		return "member/member_view.main";
	}
	
	@RequestMapping(value="/memberDtl.do")
	public String detail(MemberVO vo, Model model, @RequestParam("mode") String mode) throws Exception {

		MemberVO detail = service.selectMember(vo.getCustno());
		
		model.addAttribute("detail", detail);
		model.addAttribute("memberVO", new MemberVO());
		model.addAttribute("mode",mode);

		return "member/member_dtl.main";
	}
	
	@RequestMapping(value="/editUser.do")
	public String editUser(MemberVO vo, Model model) throws Exception {

		try {
			String shapass = SHA256.getSHA256(vo.getPwd());
			vo.setPwd1(shapass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		service.editUser(vo);
		
		return "redirect:memberList.do";
	}
	

}
