package com.hyuyuna.narcissus.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	// 사용자 등록
	@RequestMapping(value="/userJoin.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String join() {
		
		return "admin/join";
		
	}
	
}
