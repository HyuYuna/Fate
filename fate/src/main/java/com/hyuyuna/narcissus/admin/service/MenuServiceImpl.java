package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.admin.dao.MenuDao;
import com.hyuyuna.narcissus.admin.vo.MenuVO;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Resource(name="menuDao")
	MenuDao dao;

	@Override
	public List<MenuVO> selectMenuList() {
		return dao.selectMenuList();
	}

	@Override
	public void insertMenu(MenuVO vo) {
		dao.insertMenu(vo);
	}

	@Override
	public void updateMenu(MenuVO vo) {
		dao.updateMenu(vo);
	}

	@Override
	public void deleteMenu(int idx) {
		dao.deleteMenu(idx);
	}

	@Override
	public MenuVO selectMenu(int idx) {
		return dao.selectMenu(idx);
	}
	

}
