package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import com.hyuyuna.narcissus.admin.vo.AuthorityVO;

public interface AuthorityService {
	
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
	
}
