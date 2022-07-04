package com.hyuyuna.narcissus.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyuyuna.narcissus.admin.service.MenuService;
import com.hyuyuna.narcissus.admin.vo.MenuVO;

@Controller
public class MenuController {
	
	@Resource(name="menuService")
	private MenuService menuService;
	
	// 메뉴 목록화면
	@RequestMapping(value="/admin/menuList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String menuList(Model model) throws Exception {
				
		model.addAttribute("menuVO", new MenuVO());
		
		return "admin/menu_list.main";
	}
	
	// 메뉴 목록 불러오기
	@RequestMapping(value="/admin/getMenuList.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMenuList() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result.put("menuList", menuService.selectMenuList());
			result.put("status", "OK");
		} catch (Exception e) {
			result.put("status", "False");
		}
		
		return result;
	}
	
	// 메뉴 저장
	@RequestMapping(value="/admin/insertMenu.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertMenu(MenuVO vo) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			menuService.insertMenu(vo);
			result.put("status", "ok");
		} catch (Exception e) {
			result.put("status", "False");
		}

		return result;
	}
	
	// 메뉴 수정
	@RequestMapping(value="/admin/updateMenu.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateMenu(MenuVO vo) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			menuService.updateMenu(vo);
			result.put("status", "ok");
		} catch (Exception e) {
			result.put("status", "False");
		}
		
		return result;
	}
	
	// 메뉴 삭제
	@RequestMapping(value="/admin/deleteMenu.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteMenu(@RequestParam("menuIdx") int menuIdx) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			menuService.deleteMenu(menuIdx);
			result.put("status", "ok");
		} catch (Exception e) {
			result.put("status", "False");
		}
		
		return result;
	}
	
}
