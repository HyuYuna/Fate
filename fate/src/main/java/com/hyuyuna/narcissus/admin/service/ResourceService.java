package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import com.hyuyuna.narcissus.admin.vo.AuthorityVO;

public interface ResourceService {
	
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
