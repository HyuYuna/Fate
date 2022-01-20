package com.hyuyuna.narcissus.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.common.FileUtils;
import com.hyuyuna.narcissus.common.FileVO;
import com.hyuyuna.narcissus.common.MemberVO;
import com.hyuyuna.narcissus.common.MoneyVO;
import com.hyuyuna.narcissus.dao.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="fileUtils")
	FileUtils fileutils;
	
	@Resource(name="memberDao")
	MemberDao dao;
	

	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}

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
	
	@Override
	public MemberVO selectFileMember(int custno) throws Exception {
		return dao.selectFileMember(custno);
	}
	
	@Override
	public List<Map<String ,Object>> selectFileList(int custno) {
		return dao.selectFileList(custno);
	}
	
	@Override
	public FileVO selectFileInfo(int num) {
		return dao.selectFileInfo(num);
	}
	
	@Override
	public List<MoneyVO> moneylist() {
		return dao.moneylist();
	}
	
	@Override
	public void insertFileMember(Map<String ,Object> map, HttpServletRequest request) throws Exception {
		dao.insertFileMember(map);
		
		// 파일 등록
		List<Map<String,Object>> list = fileutils.parseInsertFileInfo(map,request);
		for(int i=0; i<list.size(); i++) {
			dao.insertFile(list.get(i));
		}
	}

	@Override
	public void updateFileMember(Map<String,Object> map, HttpServletRequest request) throws Exception {
		dao.updateFileMember(map);
		
		// 삭제 구분값 넣기
		dao.deleteFileGbY(map);
		List<Map<String,Object>> list = fileutils.parseInsertFileInfo(map, request);
		Map<String, Object> fileMap = null;
		for (int i=0, size=list.size(); i<size; i++) {
			fileMap = list.get(i);
			if (fileMap.get("IS_NEW").equals("Y")){
				dao.insertFile(fileMap);
			} else {
				dao.deleteFileGbN(fileMap);
			}
		}
	}
	
	@Override
	public void deleteFileMember(int custno) {
		dao.deleteFileMember(custno);
		
		//파일 삭제
		dao.deleteFile(custno);
	}
	 
}
