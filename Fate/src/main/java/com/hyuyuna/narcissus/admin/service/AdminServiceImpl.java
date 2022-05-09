package com.hyuyuna.narcissus.admin.service;

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
	
	// 회원 가입
	@Override
	public void joinUser(UserInfoVO vo) {
		dao.joinUser(vo);
	}
	
	// 회원 수정
	@Override
	public void editUser(UserInfoVO vo) {
		dao.editUser(vo);
	}
	
	 
}
