package com.hyuyuna.narcissus.dao;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.vo.MemberVO;

@Repository("fateDao")
public class FateDao extends AbstractDao {
	

	public MemberVO login(MemberVO vo) {
		return (MemberVO)selectOne("fateDao.login" , vo);
	}
	
	public void joinUser(MemberVO vo) {
		insert("fateDao.joinUser" , vo);
	}
	
}
