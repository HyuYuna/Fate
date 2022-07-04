package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import com.hyuyuna.narcissus.admin.vo.MenuVO;

public interface MenuService {
	
	// 메뉴 목록
	public List<MenuVO> selectMenuList();
	
	// 메뉴 등록
	public void insertMenu(MenuVO vo);
	
	// 메뉴 수정
	public void updateMenu(MenuVO vo);
	
	// 메뉴 삭제
	public void deleteMenu(int idx);
	
	// 메뉴 상세
	public MenuVO selectMenu(int idx);
	
	
}
