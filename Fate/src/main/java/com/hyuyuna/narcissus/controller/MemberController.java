package com.hyuyuna.narcissus.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	// 회원 등록 화면
	@RequestMapping(value="/memberForm.do")
	public String memberForm(Model model) throws Exception {
		return "member/member_dtl.main";
	}
	
	// 회원 저장 및 수정
	@RequestMapping(value="/memberSave.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String memberSave(MemberVO vo,
				@RequestParam("mode") String mode) throws Exception {

		if(mode.equals("edit")) {
			service.updateMember(vo);
		} else {
			service.insertMember(vo);
		}
		
		return "redirect:memberList.do";
	}
	
	// 회원 목록
	@RequestMapping(value="/memberList.do")
	public String memberList(MemberVO vo, Model model, HttpServletRequest request,
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
	
	// 회원 삭제
	@RequestMapping(value="/memberDelete.do")
	public String memberDelete(MemberVO vo) throws Exception {
		service.deleteMember(vo.getCustno());
		return "redirect:memberList.do";
	}
	
	// 회원 정보화면
	@RequestMapping(value="/memberView.do")
	public String memberView(MemberVO vo, Model model) throws Exception {
		
		MemberVO detail = service.selectMember(vo.getCustno());
		
		model.addAttribute("detail", detail);

		return "member/member_view.main";
	}
	
	// 회원 상세
	@RequestMapping(value="/memberDtl.do")
	public String memberDtl(MemberVO vo, Model model, @RequestParam("mode") String mode) throws Exception {

		MemberVO detail = service.selectMember(vo.getCustno());
		
		model.addAttribute("detail", detail);
		model.addAttribute("memberVO", new MemberVO());
		model.addAttribute("mode",mode);

		return "member/member_dtl.main";
	}
	
	// 그리드 화면
	@RequestMapping(value="/memberGrid.do")
	public String memberGrid(Model model) throws Exception {
		return "member/member_grid.main";
	}
	
	/* @RequestMapping(value="/memberListJson.do")
	public ModelAndView memberListJson(HttpSession session,
					@ModelAttribute("MemberVO") MemberVO vo){
		
		ModelAndView mnv = new ModelAndView("jsonView");
		
		List<MemberVO> memberList = service.selectAllMember(vo);
		//int cnt = service.memberCnt(vo);
		
		mnv.addObject("list",memberList);
		
		return mnv;
	} */

	/* @RequestMapping(value="/memberListJson.do", method=RequestMethod.POST)
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
	} */
	
    // 회원 목록(그리드용)
	@RequestMapping(value="/memberListJson.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> memberListJson(
						@RequestParam(value="page", required=false) int page,
						@RequestParam(value="rows", required=false) int rows,
						@RequestParam(value="sidx", required=false) String sidx,
						@RequestParam(value="sord", required=false) String sord) {
		
		int startCount = (page-1) * rows + 1;
		int endCount = page * rows;
		int total;
		int records;
							
		List<MemberVO> memberList = null;
		
		HashMap<String, Object> order = new HashMap<String, Object>();
		order.put("SORD", sord);
		order.put("SIDX", sidx);
		order.put("startCount", startCount);
		order.put("endCount", endCount);
		
		memberList = service.selectAllMemberJson(order);
		
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		total = service.totalPage(rows);
		records = service.totalRecords();
		
		resMap.put("page", page);
		resMap.put("total", total);
		resMap.put("records", records);
		resMap.put("rows", memberList);
		
		return resMap;
	} 
	
	// 회원 수정(그리드용)
	@RequestMapping(value="/editMemberGrid.do", method=RequestMethod.POST)
	public String editMemberGrid(HttpServletRequest request, 
				@RequestParam("oper") String oper,
				@RequestBody MemberVO vo) {
		if(oper.equals("add")) {
			service.insertMember(vo);
		} else if(oper.equals("edit")) {
			service.updateMember(vo);
		} else if(oper.equals("del")) {
			service.deleteMember(vo.getCustno());
		}
		
		return "jsonView";
	}
	

}
