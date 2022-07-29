package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.admin.dao.AuthorityDao;
import com.hyuyuna.narcissus.admin.dao.UserDao;
import com.hyuyuna.narcissus.admin.vo.UserInfoVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDao")
	UserDao dao;
	
	@Resource(name="authorityDao")
	AuthorityDao authorityDao;
	
	// 아이디 중복체크
	@Override
	public int idCheck(String id) {
		return dao.idCheck(id);
	}
	
	// 사용자 목록
	public List<UserInfoVO> selectUserList(UserInfoVO vo) {
		return dao.selectUserList(vo);
	}
	
	// 사용자수
	public int userCnt(UserInfoVO vo) {
		return dao.userCnt(vo);
	}
	
	// 사용자 가입
	@Override
	public void joinUser(UserInfoVO vo) {
		dao.joinUser(vo);
		
		// manager 권한 주기
		vo.setAuthority("USER");
		dao.inserUserAuthority(vo);
	}
	
	// 사용자 수정
	@Override
	public void updateUser(UserInfoVO vo) {
		dao.updateUser(vo);
		
		// 권한 변경(사용자)
		dao.updateUserAuthority(vo);
	}
	
	// 사용자 삭제
	@Override
	public void deleteUser(String userId) {
		dao.deleteUser(userId);
		
	}
	
	//사용자 상세
	@Override
	public UserInfoVO selectUser(String userId) {
		return dao.selectUser(userId);
	}
	
}
