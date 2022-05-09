package com.hyuyuna.narcissus.main.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.main.dao.MainDao;
import com.hyuyuna.narcissus.main.vo.UserVO;

@Service("mainService")
public class MainServiceImpl implements MainService{
	
	@Resource(name="mainDao")
	MainDao dao;
	
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
