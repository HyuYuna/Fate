package com.hyuyuna.narcissus.main.service;

import com.hyuyuna.narcissus.main.vo.UserVO;

public interface MainService {
	
	// 로그인
	public UserVO login(UserVO vo);
	
	// 아이디 중복체크
	public int idCheck(String id);
	
	// 회원 가입
	public void joinUser(UserVO vo);
	
	// 회원 수정
	public void editUser(UserVO vo);
	
	
}
