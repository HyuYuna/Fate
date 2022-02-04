package com.hyuyuna.narcissus.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hyuyuna.narcissus.vo.FileVO;
import com.hyuyuna.narcissus.vo.MemberVO;
import com.hyuyuna.narcissus.vo.MoneyVO;

public interface MemberService {
	
	public void insertMember(MemberVO vo);
	
	public List<MemberVO> selectAllMember(MemberVO vo);
	
	public List<Map<String, Object>> selectAllMemberJson();
	
	public int memberCnt(MemberVO vo);
	
	public void deleteMember(int custno);
	
	public void updateMember(MemberVO vo);
	
	public void editUser(MemberVO vo);
	
	public MemberVO selectMember(int custno);
	
	public MemberVO selectFileMember(int custno) throws Exception;
	
	public List<Map<String, Object>> selectFileList(int custno);
	
	public FileVO selectFileInfo(int num);
	
	public List<MoneyVO> moneylist();
	
	public void insertFileMember(Map<String, Object> map, HttpServletRequest request) throws Exception ;
	
	public void updateFileMember(Map<String, Object> map, HttpServletRequest request) throws Exception ;
	
	public void deleteFileMember(int custno);

}
