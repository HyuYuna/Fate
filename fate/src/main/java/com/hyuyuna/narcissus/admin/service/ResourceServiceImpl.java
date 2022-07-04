package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.admin.dao.ResourceDao;
import com.hyuyuna.narcissus.admin.vo.AuthorityVO;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService{
	
	@Resource(name="resourceDao")
	ResourceDao dao;
	
	// 리소스 목록
	public List<AuthorityVO> selectResourceList() {
		return dao.selectResourceList();
	}
	
	// 리소스 상세
	@Override
	public AuthorityVO selectResource(int idx) {
		return dao.selectResource(idx);
	}
	
	// 리소스 등록
	@Override
	public void insertResource(AuthorityVO vo) {
		dao.insertResource(vo);
		
		// 리소스 권한 등록
		dao.insertResourceAuthority(vo);
	}
		
	// 리소스 수정
	@Override
	public void updateResource(AuthorityVO vo) {
		dao.updateResource(vo);
		
		// 리소스 권한 수정
		dao.updateResourceAuthority(vo);
	}
	
	// 리소스 삭제
	@Override
	public void deleteResource(int idx) {
		dao.deleteResource(idx);
		
		// 리소스 권한 삭제
		dao.deleteResourceAuthority(idx);
	}
	
}
