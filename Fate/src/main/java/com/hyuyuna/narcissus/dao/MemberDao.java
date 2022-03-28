package com.hyuyuna.narcissus.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.vo.FileVO;
import com.hyuyuna.narcissus.vo.MemberVO;

@Repository("memberDao")
public class MemberDao extends AbstractDao {

	// 전체 회원 목록
	@SuppressWarnings("unchecked")
	public List<MemberVO> selectAllmember(MemberVO vo) {
		return (List<MemberVO>)selectList("memberDao.selectAllmember", vo);
	}
	
	// 전체 회원(그리드용)
	@SuppressWarnings("unchecked")
	public List<MemberVO> selectAllMemberJson(Map<String, Object> map) {
		return (List<MemberVO>)selectList("memberDao.selectAllMemberJson", map);
	}
	
	// 회원수
	public int memberCnt(MemberVO vo) {
		return (Integer)selectOne("memberDao.memberCnt", vo);
	}
	
	// 총 페이지
	public int totalPage(int rows) {
		return (Integer)selectOne("memberDao.totalPage", rows);
	}
	
	// 총 회원수
	public int totalRecords() {
		return (Integer)selectOne("memberDao.totalRecords");
	}

	// 회원 등록
	public void insertMember(MemberVO vo) {
		insert("memberDao.insertMember" , vo);
	}
	
	// 회원 삭제
	public void deleteMember(int custno) {
		delete("memberDao.deleteMember", custno);
	}

	// 회원 수정
	public void updateMember(MemberVO vo) {
		int k = (Integer)update("memberDao.updateMember", vo);
		System.out.println("으으윽"+ k);
	}
	
	// 회원 상세
	public MemberVO selectMember(int custno) {
		return (MemberVO)selectOne("memberDao.selectMember", custno);
	}
	 
}
