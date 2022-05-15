package com.hyuyuna.narcissus.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.admin.dao.AdminDao;
import com.hyuyuna.narcissus.admin.vo.UserInfoVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Resource(name="adminDao")
	AdminDao dao;
	
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
		
		// 권한 변경
		dao.updateAuthority(vo);
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
	
	// 권한 목록
	public List<Map<String, Object>> selectAuthorityList() {
		return dao.selectAuthorityList();
	}
	
	 
}
