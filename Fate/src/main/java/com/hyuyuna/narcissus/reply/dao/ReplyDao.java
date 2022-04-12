package com.hyuyuna.narcissus.reply.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.common.AbstractDao;
import com.hyuyuna.narcissus.reply.vo.ReplyVO;

@Repository("replyDao")
public class ReplyDao extends AbstractDao {
	
	// 댓글 목록
	@SuppressWarnings("unchecked")
	public List<ReplyVO> getReplyList(int productIdx) {
		return (List<ReplyVO>)selectList("replyDao.getReplyList",productIdx);
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
	public int deleteReply(int replyIdx) {
		return (Integer)selectOne("replyDao.deleteReply",replyIdx);
	}
	 
}
