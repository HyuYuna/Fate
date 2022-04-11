package com.hyuyuna.narcissus.fate.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.fate.dao.FateDao;
import com.hyuyuna.narcissus.fate.vo.UserVO;

@Service("fateService")
public class FateServiceImpl implements FateService{
	
	@Resource(name="fateDao")
	FateDao dao;
	
	// 로그인
	@Override
	public UserVO login(UserVO vo) {
		return dao.login(vo);
	}
	
	// 아이디 중복체크
	@Override
	public int idCheck(String id) {
		return dao.idCheck(id);
	}
	
	// 회원 가입
	@Override
	public void joinUser(UserVO vo) {
		dao.joinUser(vo);
	}
	
	// 회원 수정
	@Override
	public void editUser(UserVO vo) {
		dao.editUser(vo);
	}
	
	 
}
