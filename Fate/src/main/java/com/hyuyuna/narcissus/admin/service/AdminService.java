package com.hyuyuna.narcissus.admin.service;

import com.hyuyuna.narcissus.admin.vo.UserInfoVO;

public interface AdminService {
	
	// 아이디 중복체크
	public int idCheck(String id);
	
	// 회원 가입
	public void joinUser(UserInfoVO vo);
	
	// 회원 수정
	public void editUser(UserInfoVO vo);
	
	
}
