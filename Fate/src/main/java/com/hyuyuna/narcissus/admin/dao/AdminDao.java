package com.hyuyuna.narcissus.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.admin.vo.UserInfoVO;
import com.hyuyuna.narcissus.common.AbstractDao;

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
	public List<Map<String, Object>> selectAuthorityList() {
		return (List<Map<String, Object>>)selectList("adminDao.selectAuthorityList");
	}
	
	// 권한 변경
	public void updateAuthority(UserInfoVO vo) {
		update("adminDao.updateAuthority", vo);
	}
}
