package com.hyuyuna.narcissus.customer.controller;


import java.util.HashMap;
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

import com.hyuyuna.narcissus.common.SessionManager;
import com.hyuyuna.narcissus.common.security.ReloadableFilterInvocationSecurityMetadataSource;
import com.hyuyuna.narcissus.customer.service.CustomerService;
import com.hyuyuna.narcissus.customer.vo.CustomerVO;
import com.hyuyuna.narcissus.reply.vo.ReplyVO;

@Controller
public class CustomerController {
	
	@Resource(name="customerService")
	CustomerService service;
	
	@Resource(name="reloadableFilterInvocationSecurityMetadataSource")
	ReloadableFilterInvocationSecurityMetadataSource reloadFilter;
	
	@Autowired
	private SessionManager sessionManager;
	
	
	// 고객 등록 화면
	@RequestMapping(value="/customerReg.do")
	public String customerReg(Model model) throws Exception {
		reloadFilter.reload();
		return "customer/customer_dtl.main";
	}
	
	// 고객 저장 및 수정
	@RequestMapping(value="/customerSave.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String customerSave(CustomerVO vo,
				@RequestParam("mode") String mode) throws Exception {

		if(mode.equals("edit")) {
			service.updateCustomer(vo);
		} else {
			service.insertCustomer(vo);
		}
		
		return "redirect:customerList.do";
	}
	
	// 고객 목록
	@RequestMapping(value="/customerList.do")
	public String customerList(CustomerVO vo, Model model, HttpServletRequest request,
			@RequestParam(required= false, defaultValue = "1") int range) throws Exception{
		
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page")); 
		int listCnt = service.customerCnt(vo);
		
		vo.setPage(page);
		vo.setRange(range);
		vo.setListCnt(listCnt);
		vo.pageInfo(page, range, listCnt);
		
		List<CustomerVO> list = service.selectCustomerList(vo);
		
		model.addAttribute("vo", vo);
		model.addAttribute("cnt", listCnt);
		model.addAttribute("list", list);
		
		return "customer/customer_list.main";
	}
	
	// 고객 삭제
	@RequestMapping(value="/customerDelete.do")
	public String customerDelete(CustomerVO vo) throws Exception {
		service.deleteCustomer(vo.getCustomerIdx());
		return "redirect:customerList.do";
	}
	
	// 고객 정보화면
	@RequestMapping(value="/customerView.do")
	public String customerView(CustomerVO vo, Model model) throws Exception {
		
		CustomerVO detail = service.selectCustomer(vo.getCustomerIdx());
		
		model.addAttribute("detail", detail);
		model.addAttribute("replyVO", new ReplyVO());

		return "customer/customer_view.main";
	}
	
	// 고객 상세
	@RequestMapping(value="/customerDtl.do")
	public String customerDtl(CustomerVO vo, Model model, @RequestParam("mode") String mode) throws Exception {

		CustomerVO detail = service.selectCustomer(vo.getCustomerIdx());
		
		model.addAttribute("detail", detail);
		model.addAttribute("customerVO", new CustomerVO());
		model.addAttribute("mode",mode);

		return "customer/customer_dtl.main";
	}
	
	// 그리드 화면
	@RequestMapping(value="/customerGrid.do")
	public String customerGrid(Model model) throws Exception {
		return "customer/customer_grid.main";
	}
	
	/* @RequestMapping(value="/customerListJson.do")
	public ModelAndView customerListJson(HttpSession session,
					@ModelAttribute("CustomerVO") CustomerVO vo){
		
		ModelAndView mnv = new ModelAndView("jsonView");
		
		List<CustomerVO> customerList = service.selectAllCustomer(vo);
		//int cnt = service.customerCnt(vo);
		
		mnv.addObject("list",customerList);
		
		return mnv;
	} */

	/* @RequestMapping(value="/customerListJson.do", method=RequestMethod.POST)
	@ResponseBody
	public CustomerVO customerListJson(
						@RequestParam(value="page", required=false) String page,
						@RequestParam(value="rows", required=false) String rows,
						@RequestParam(value="sidx", required=false) String sidx,
						@RequestParam(value="sord", required=false) String sord) {
		
		List<Map<String,Object>> customerList = service.selectAllCustomerJson();
		CustomerVO obj = new CustomerVO();
		obj.setRows(customerList);

		return obj;
	} */
	
    // 고객 목록(그리드용)
	@RequestMapping(value="/customerListJson.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> customerListJson(
						@RequestParam(value="page", required=false) int page,
						@RequestParam(value="rows", required=false) int rows,
						@RequestParam(value="sidx", required=false) String sidx,
						@RequestParam(value="sord", required=false) String sord,
						@RequestParam(value="searchField", required=false) String searchField,
						@RequestParam(value="searchString", required=false) String searchString,
						@RequestParam(value="searchOper", required=false) String searchOper) {
		
		int startCount = (page-1) * rows + 1;
		int endCount = page * rows;
		int total;
		int records;
							
		List<Map<String, Object>> customerList = null;
		
		HashMap<String, Object> order = new HashMap<String, Object>();
		order.put("SORD", sord);
		order.put("SIDX", sidx);
		order.put("startCount", startCount);
		order.put("endCount", endCount);
		order.put("searchField", searchField);
		order.put("searchString", searchString);
		
		customerList = service.selectCustomerListJson(order);
		
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		if (searchField != null) {
			records = service.totalRecordsJson(order);
		} else {
			records = service.totalRecords();
		}
		
		HashMap<String, Object> pages = new HashMap<String,Object>();
		pages.put("rows", rows);
		pages.put("records", records);
		
		total = (int)(Math.ceil(records/rows) + 1);
		
		resMap.put("page", page);
		resMap.put("total", total);
		resMap.put("records", records);
		resMap.put("rows", customerList);
		
		return resMap;
	} 
	
	// 고객 수정(그리드용)
	@RequestMapping(value="/editCustomerGrid.do", method=RequestMethod.POST)
	@ResponseBody
	public String editCustomerGrid(
				@RequestParam("oper") String oper,
				@RequestParam Map<String, String> map) {
		
		if(oper.equals("add")) {
			service.insertCustomerJson(map);
		} else if(oper.equals("edit")) {
			service.updateCustomerJson(map);
		} else if(oper.equals("del")) {
			int customerIdx = Integer.parseInt(map.get("id"));
			service.deleteCustomer(customerIdx);
		}
		
		return "jsonView";
	}
	

}
