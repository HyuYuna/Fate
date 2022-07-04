package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.admin.dao.AuthorityDao;
import com.hyuyuna.narcissus.admin.vo.AuthorityVO;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService{
	
	@Resource(name="authorityDao")
	AuthorityDao dao;
	
	// 권한 목록
	public List<AuthorityVO> selectAuthorityList() {
		return dao.selectAuthorityList();
	}
	
	//권한 상세
	@Override
	public AuthorityVO selectAuthority(int idx) {
		return dao.selectAuthority(idx);
	}
	
	// 권한 등록
	@Override
	public void insertAuthority(AuthorityVO vo) {
		dao.insertAuthority(vo);
	}
		
	// 권한 수정
	@Override
	public void updateAuthority(AuthorityVO vo) {
		dao.updateAuthority(vo);
	}
	
	// 권한 삭제
	@Override
	public void deleteAuthority(int idx) {
		dao.deleteAuthority(idx);
	}

}
