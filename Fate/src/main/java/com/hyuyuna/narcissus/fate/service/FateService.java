package com.hyuyuna.narcissus.fate.service;

import com.hyuyuna.narcissus.fate.vo.UserVO;

public interface FateService {
	
	// 로그인
	public UserVO login(UserVO vo);
	
	// 아이디 중복체크
	public int idCheck(String id);
	
	// 회원 가입
	public void joinUser(UserVO vo);
	
	// 회원 수정
	public void editUser(UserVO vo);
	
	
}
