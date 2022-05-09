package com.hyuyuna.narcissus.main.dao;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.common.AbstractDao;
import com.hyuyuna.narcissus.main.vo.UserVO;

@Repository("mainDao")
public class MainDao extends AbstractDao {
	
	// 로그인
	public UserVO login(UserVO vo) {
		return (UserVO)selectOne("mainDao.login" , vo);
	}
	
	// 아이디 중복체크
	public int idCheck(String id) {
		return (Integer)selectOne("mainDao.idCheck", id);
	}
	
	// 회원 가입
	public void joinUser(UserVO vo) {
		insert("mainDao.joinUser" , vo);
	}
	
	// 회원 수정
	public void editUser(UserVO vo) {
		update("mainDao.editUser", vo);
	}
	
	
}
