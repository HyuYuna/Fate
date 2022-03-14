package com.hyuyuna.narcissus.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hyuyuna.narcissus.vo.FileVO;
import com.hyuyuna.narcissus.vo.MemberVO;

public interface MemberService {
	
	public List<MemberVO> selectAllMember(MemberVO vo);
	
	public List<Map<String, Object>> selectAllMemberJson();
	
	public int memberCnt(MemberVO vo);
	
	public void insertMember(MemberVO vo);
	
	public void deleteMember(int custno);
	
	public void updateMember(MemberVO vo);
	
	public void editUser(MemberVO vo);
	
	public MemberVO selectMember(int custno);
	
}
