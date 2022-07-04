package com.hyuyuna.narcissus.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.admin.vo.MenuVO;
import com.hyuyuna.narcissus.common.dao.AbstractDao;

@Repository("menuDao")
public class MenuDao extends AbstractDao {
	
	// 메뉴 목록
	@SuppressWarnings("unchecked")
	public List<MenuVO> selectMenuList() {
		return (List<MenuVO>)selectList("menuDao.selectMenuList");
	}
	
	// 메뉴 입력
	public void insertMenu(MenuVO vo) {
		insert("menuDao.insertMenu", vo);
	}

	// 메뉴 수정
	public void updateMenu(MenuVO vo) {
		update("menuDao.updateMenu", vo);
	}

	// 메뉴 삭제
	public void deleteMenu(int idx) {
		delete("menuDao.deleteMenu", idx);
	}

	// 메뉴 상세
	public MenuVO selectMenu(int idx) {
		return (MenuVO)selectOne("menuDao.selectMenu", idx);
	}
	
}
