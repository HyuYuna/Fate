package com.hyuyuna.narcissus.service;

import com.hyuyuna.narcissus.vo.MemberVO;

public interface FateService {
	
	// 로그인
	public MemberVO login(MemberVO vo);
	
	// 아이디 중복체크
	public int idCheck(String id);
	
	// 회원 가입
	public void joinUser(MemberVO vo);
	
	// 회원 수정
	public void editUser(MemberVO vo);
	
	
}
