package com.hyuyuna.narcissus.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.admin.dao.AdminDao;
import com.hyuyuna.narcissus.admin.vo.AuthorityVO;
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
