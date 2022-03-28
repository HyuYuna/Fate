package com.hyuyuna.narcissus.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.dao.FateDao;
import com.hyuyuna.narcissus.vo.MemberVO;

@Service("fateService")
public class FateServiceImpl implements FateService{
	
	@Resource(name="fateDao")
	FateDao dao;
	
	// 로그인
	@Override
	public MemberVO login(MemberVO vo) {
		return dao.login(vo);
	}
	
	// 아이디 중복체크
	@Override
	public int idCheck(String id) {
		return dao.idCheck(id);
	}
	
	// 회원 가입
	@Override
	public void joinUser(MemberVO vo) {
		dao.joinUser(vo);
	}
	
	// 회원 수정
	@Override
	public void editUser(MemberVO vo) {
		dao.editUser(vo);
	}
	
	 
}
