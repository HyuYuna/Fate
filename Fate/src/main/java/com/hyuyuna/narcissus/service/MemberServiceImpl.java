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
	
	// 전체 회원 목록
	@Override
	public List<MemberVO> selectAllMember(MemberVO vo) {
		return dao.selectAllmember(vo);
	}
	
	// 전체 회원(그리드용)
	public List<MemberVO> selectAllMemberJson(Map<String, Object> map) {
		return dao.selectAllMemberJson(map);
	}
	
	// 회원수
	@Override
	public int memberCnt(MemberVO vo) {
		return dao.memberCnt(vo);
	}
	
	// 총 페이지
	@Override
	public int totalPage(int rows) {
		return dao.totalPage(rows);
	}
	
	// 총 회원수
	@Override
	public int totalRecords() {
		return dao.totalRecords();
	}
	
	// 회원 등록
	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	// 회원 삭제
	@Override
	public void deleteMember(int custno) {
		dao.deleteMember(custno);
	}
	
	// 회원 수정
	@Override
	public void updateMember(MemberVO vo) {
		dao.updateMember(vo);
	}
	
	// 회원 상세
	@Override
	public MemberVO selectMember(int custno) {
		return dao.selectMember(custno);
	}
	
	 
}
