package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import com.hyuyuna.narcissus.admin.vo.AuthorityVO;
import com.hyuyuna.narcissus.admin.vo.UserInfoVO;

public interface AdminService {
	
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
	
	// 권한 목록
	public List<AuthorityVO> selectAuthorityList();
	
	// 권한 상세
	public AuthorityVO selectAuthority(int idx);
	
	// 권한 등록
	public void insertAuthority(AuthorityVO vo);
	
	// 권한 수정
	public void updateAuthority(AuthorityVO vo);
	
	// 권한 삭제
	public void deleteAuthority(int idx);
	
	// 리소스 목록
	public List<AuthorityVO> selectResourceList();
		
	// 리소스 상세
	public AuthorityVO selectResource(int idx);
	
	// 리소스 등록
	public void insertResource(AuthorityVO vo);
	
	// 리소스 수정
	public void updateResource(AuthorityVO vo);
	
	// 리소스 삭제
	public void deleteResource(int idx);
	
}
