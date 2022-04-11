package com.hyuyuna.narcissus.fate.dao;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.common.AbstractDao;
import com.hyuyuna.narcissus.fate.vo.UserVO;

@Repository("fateDao")
public class FateDao extends AbstractDao {
	
	// 로그인
	public UserVO login(UserVO vo) {
		return (UserVO)selectOne("fateDao.login" , vo);
	}
	
	// 아이디 중복체크
	public int idCheck(String id) {
		return (Integer)selectOne("fateDao.idCheck", id);
	}
	
	// 회원 가입
	public void joinUser(UserVO vo) {
		insert("fateDao.joinUser" , vo);
	}
	
	// 회원 수정
	public void editUser(UserVO vo) {
		update("memberDao.editUser", vo);
	}
	
	
}
