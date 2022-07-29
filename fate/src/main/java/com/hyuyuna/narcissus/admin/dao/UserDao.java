package com.hyuyuna.narcissus.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.admin.vo.UserInfoVO;
import com.hyuyuna.narcissus.common.dao.AbstractDao;

@Repository("userDao")
public class UserDao extends AbstractDao {
	
	// 아이디 중복체크
	public int idCheck(String id) {
		return (Integer)selectOne("userDao.idCheck", id);
	}
	
	// 사용자 목록
	@SuppressWarnings("unchecked")
	public List<UserInfoVO> selectUserList(UserInfoVO vo) {
		return (List<UserInfoVO>)selectList("userDao.selectUserList", vo);
	}
	
	// 사용자수
	public int userCnt(UserInfoVO vo) {
		return (Integer)selectOne("userDao.userCnt" , vo);
	}
	
	// 사용자 가입
	public void joinUser(UserInfoVO vo) {
		insert("userDao.joinUser" , vo);
	}
	
	// manager 권한 생성
	public void inserUserAuthority(UserInfoVO vo) {
		insert("userDao.inserUserAuthority" , vo);
	}
	
	// 사용자 수정
	public void updateUser(UserInfoVO vo) {
		update("userDao.updateUser", vo);
	}
	
	// 권한 변경(사용자)
	public void updateUserAuthority(UserInfoVO vo) {
		update("userDao.updateUserAuthority", vo);
	}
	
	// 사용자 삭제
	public void deleteUser(String userId) {
		update("userDao.deleteUser", userId);
	}
	
	// 사용자 상세
	public UserInfoVO selectUser(String userId) {
		return (UserInfoVO)selectOne("userDao.selectUser", userId);
	}
	
}
