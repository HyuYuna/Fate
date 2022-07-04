package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import com.hyuyuna.narcissus.admin.vo.UserInfoVO;

public interface UserService {
	
	// 아이디 중복체크
	public int idCheck(String id);
	
	// 사용자 목록
	public List<UserInfoVO> selectUserList(UserInfoVO vo);
	
	// 사용자수
	public int userCnt(UserInfoVO vo);
	
	// 사용자 가입
	public void joinUser(UserInfoVO vo);
	
	// 사용자 수정
	public void updateUser(UserInfoVO vo);
	
	// 사용자 삭제
	public void deleteUser(String userId);
	
	// 사용자 상세
	public UserInfoVO selectUser(String userId);
	
	
}
