package com.hyuyuna.narcissus.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.common.FileUtils;
import com.hyuyuna.narcissus.dao.MemberDao;
import com.hyuyuna.narcissus.vo.FileVO;
import com.hyuyuna.narcissus.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="fileUtils")
	FileUtils fileutils;
	
	@Resource(name="memberDao")
	MemberDao dao;
	

	@Override
	public List<MemberVO> selectAllMember(MemberVO vo) {
		return dao.selectAllmember(vo);
	}
	
	public List<Map<String, Object>> selectAllMemberJson() {
		return dao.selectAllMemberJson();
	}
	
	@Override
	public int memberCnt(MemberVO vo) {
		return dao.memberCnt(vo);
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	@Override
	public void deleteMember(int custno) {
		dao.deleteMember(custno);
	}
	
	@Override
	public void updateMember(MemberVO vo) {
		dao.updateMember(vo);
	}
	
	public void editUser(MemberVO vo) {
		dao.editUser(vo);
	}
	
	@Override
	public MemberVO selectMember(int custno) {
		return dao.selectMember(custno);
	}
	
	 
}
