package com.hyuyuna.narcissus.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.admin.vo.AuthorityVO;
import com.hyuyuna.narcissus.admin.vo.UserInfoVO;
import com.hyuyuna.narcissus.common.dao.AbstractDao;

@Repository("authorityDao")
public class AuthorityDao extends AbstractDao {
	
	// 권한 목록
	@SuppressWarnings("unchecked")
	public List<AuthorityVO> selectAuthorityList() {
		return (List<AuthorityVO>)selectList("authorityDao.selectAuthorityList");
	}
	
	// 권한 상세
	public AuthorityVO selectAuthority(int idx) {
		return (AuthorityVO)selectOne("authorityDao.selectAuthority", idx);
	}
	
	// 권한 등록
	public void insertAuthority(AuthorityVO vo) {
		insert("authorityDao.insertAuthority", vo);
	}
		
	// 권한 수정
	public void updateAuthority(AuthorityVO vo) {
		update("authorityDao.updateAuthority", vo);
	}
	
	// 권한 삭제
	public void deleteAuthority(int idx) {
		update("authorityDao.deleteAuthority", idx);
	}
	
}
