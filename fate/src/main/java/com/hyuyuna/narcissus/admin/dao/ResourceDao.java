package com.hyuyuna.narcissus.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.admin.vo.AuthorityVO;
import com.hyuyuna.narcissus.common.dao.AbstractDao;

@Repository("resourceDao")
public class ResourceDao extends AbstractDao {
	
	// 리소스 목록
	@SuppressWarnings("unchecked")
	public List<AuthorityVO> selectResourceList() {
		return (List<AuthorityVO>)selectList("resourceDao.selectResourceList");
	}
		
	// 리소스 상세
	public AuthorityVO selectResource(int idx) {
		return (AuthorityVO)selectOne("resourceDao.selectResource", idx);
	}
	
	// 리소스 등록
	public void insertResource(AuthorityVO vo) {
		insert("resourceDao.insertResource", vo);
	}
	
	// 리소스 권한 등록
	public void insertResourceAuthority(AuthorityVO vo) {
		insert("resourceDao.insertResourceAuthority", vo);
	}
	
	// 리소스 수정
	public void updateResource(AuthorityVO vo) {
		update("resourceDao.updateResource", vo);
	}
	
	// 리소스 권한 수정
	public void updateResourceAuthority(AuthorityVO vo) {
		update("resourceDao.updateResourceAuthority", vo);
	}
	
	// 리소스 삭제
	public void deleteResource(int idx) {
		delete("resourceDao.deleteResource", idx);
	}
	
	// 리소스 권한 삭제
	public void deleteResourceAuthority(int idx) {
		delete("resourceDao.deleteResourceAuthority", idx);
	}
	
}
