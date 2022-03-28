package com.hyuyuna.narcissus.service;

import java.util.List;
import java.util.Map;

import com.hyuyuna.narcissus.vo.MemberVO;

public interface MemberService {
	
	// 전체 회원 목록
	public List<MemberVO> selectAllMember(MemberVO vo);
	
	// 전체 회원(그리드용)
	public List<MemberVO> selectAllMemberJson(Map<String, Object> map);
	
	// 회원수
	public int memberCnt(MemberVO vo);
	
	// 총 페이지
	public int totalPage(int rows);
	
	// 총 회원수
	public int totalRecords();
	
	// 회원 등록
	public void insertMember(MemberVO vo);
	
	// 회원 삭제
	public void deleteMember(int custno);
	
	// 회원 수정
	public void updateMember(MemberVO vo);
	
	// 회원 상세
	public MemberVO selectMember(int custno);
	
}
