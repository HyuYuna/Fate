package com.hyuyuna.narcissus.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.admin.vo.AuthorityVO;
import com.hyuyuna.narcissus.admin.vo.UserInfoVO;
import com.hyuyuna.narcissus.common.dao.AbstractDao;

@Repository("adminDao")
public class AdminDao extends AbstractDao {
	
	// 아이디 중복체크
	public int idCheck(String id) {
		return (Integer)selectOne("adminDao.idCheck", id);
	}
	
	// 사용자 목록
	@SuppressWarnings("unchecked")
	public List<UserInfoVO> selectUserList(UserInfoVO vo) {
		return (List<UserInfoVO>)selectList("adminDao.selectUserList", vo);
	}
	
	// 사용자수
	public int userCnt(UserInfoVO vo) {
		return (Integer)selectOne("adminDao.userCnt" , vo);
	}
	
	// 사용자 가입
	public void joinUser(UserInfoVO vo) {
		insert("adminDao.joinUser" , vo);
	}
	
	// manager 권한 생성
	public void inserUserAuthority(UserInfoVO vo) {
		insert("adminDao.inserUserAuthority" , vo);
	}
	
	// 사용자 수정
	public void updateUser(UserInfoVO vo) {
		update("adminDao.updateUser", vo);
	}
	
	// 사용자 삭제
	public void deleteUser(String userId) {
		update("adminDao.deleteUser", userId);
	}
	
	// 사용자 상세
	public UserInfoVO selectUser(String userId) {
		return (UserInfoVO)selectOne("adminDao.selectUser", userId);
	}
	
	// 권한 목록
	@SuppressWarnings("unchecked")
	public List<AuthorityVO> selectAuthorityList() {
		return (List<AuthorityVO>)selectList("adminDao.selectAuthorityList");
	}
	
	// 권한 상세
	public AuthorityVO selectAuthority(int idx) {
		return (AuthorityVO)selectOne("adminDao.selectAuthority", idx);
	}
	
	// 권한 변경(사용자)
	public void updateUserAuthority(UserInfoVO vo) {
		update("adminDao.updateUserAuthority", vo);
	}
	
	// 권한 등록
	public void insertAuthority(AuthorityVO vo) {
		insert("adminDao.insertAuthority", vo);
	}
		
	// 권한 수정
	public void updateAuthority(AuthorityVO vo) {
		update("adminDao.updateAuthority", vo);
	}
	
	// 권한 삭제
	public void deleteAuthority(int idx) {
		update("adminDao.deleteAuthority", idx);
	}
	
	// 리소스 목록
	@SuppressWarnings("unchecked")
	public List<AuthorityVO> selectResourceList() {
		return (List<AuthorityVO>)selectList("adminDao.selectResourceList");
	}
		
	// 리소스 상세
	public AuthorityVO selectResource(int idx) {
		return (AuthorityVO)selectOne("adminDao.selectResource", idx);
	}
	
	// 리소스 등록
	public void insertResource(AuthorityVO vo) {
		insert("adminDao.insertResource", vo);
	}
	
	// 리소스 권한 등록
	public void insertResourceAuthority(AuthorityVO vo) {
		insert("adminDao.insertResourceAuthority", vo);
	}
	
	// 리소스 수정
	public void updateResource(AuthorityVO vo) {
		update("adminDao.updateResource", vo);
	}
	
	// 리소스 권한 수정
	public void updateResourceAuthority(AuthorityVO vo) {
		update("adminDao.updateResourceAuthority", vo);
	}
	
	// 리소스 삭제
	public void deleteResource(int idx) {
		delete("adminDao.deleteResource", idx);
	}
	
	// 리소스 권한 삭제
	public void deleteResourceAuthority(int idx) {
		delete("adminDao.deleteResourceAuthority", idx);
	}
	
}
