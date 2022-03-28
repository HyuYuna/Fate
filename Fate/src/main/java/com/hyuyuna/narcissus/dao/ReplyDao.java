package com.hyuyuna.narcissus.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.vo.ReplyVO;

@Repository("replyDao")
public class ReplyDao extends AbstractDao {
	
	// 댓글 목록
	@SuppressWarnings("unchecked")
	public List<ReplyVO> getReplyList(int serial) {
		return (List<ReplyVO>)selectList("replyDao.getReplyList",serial);
	}
	
	// 댓글 저장
	public int saveReply(ReplyVO vo) {
		return (Integer)selectOne("replyDao.saveReply",vo);
	}
	
	// 댓글 수정
	public int updateReply(ReplyVO vo) {
		return (Integer)selectOne("replyDao.updateReply",vo);
	}
	
	// 댓글 삭제
	public int deleteReply(int num) {
		return (Integer)selectOne("replyDao.deleteReply",num);
	}
	 
}
