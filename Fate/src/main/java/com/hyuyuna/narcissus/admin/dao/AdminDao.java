package com.hyuyuna.narcissus.admin.dao;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.admin.vo.UserInfoVO;
import com.hyuyuna.narcissus.common.AbstractDao;

@Repository("adminDao")
public class AdminDao extends AbstractDao {
	
	// 아이디 중복체크
	public int idCheck(String id) {
		return (Integer)selectOne("adminDao.idCheck", id);
	}
	
	// 회원 가입
	public void joinUser(UserInfoVO vo) {
		insert("adminDao.joinUser" , vo);
	}
	
	// 회원 수정
	public void editUser(UserInfoVO vo) {
		update("adminDao.editUser", vo);
	}
	
	
}
