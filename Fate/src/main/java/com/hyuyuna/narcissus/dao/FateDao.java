package com.hyuyuna.narcissus.dao;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.vo.MemberVO;

@Repository("fateDao")
public class FateDao extends AbstractDao {
	
	// 로그인
	public MemberVO login(MemberVO vo) {
		return (MemberVO)selectOne("fateDao.login" , vo);
	}
	
	// 아이디 중복체크
	public int idCheck(String id) {
		return (Integer)selectOne("fateDao.idCheck", id);
	}
	
	// 회원 가입
	public void joinUser(MemberVO vo) {
		insert("fateDao.joinUser" , vo);
	}
	
	// 회원 수정
	public void editUser(MemberVO vo) {
		update("memberDao.editUser", vo);
	}
	
	
}
