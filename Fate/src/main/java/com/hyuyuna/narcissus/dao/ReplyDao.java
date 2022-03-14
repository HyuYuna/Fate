package com.hyuyuna.narcissus.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.vo.ReplyVO;

@Repository("replyDao")
public class ReplyDao extends AbstractDao {
	
	@SuppressWarnings("unchecked")
	public List<ReplyVO> getReplyList(int serial) {
		return (List<ReplyVO>)selectList("replyDao.getReplyList",serial);
	}
	
	public int saveReply(ReplyVO vo) {
		return (Integer)selectOne("replyDao.saveReply",vo);
	}
	
	public int updateReply(ReplyVO vo) {
		return (Integer)selectOne("replyDao.updateReply",vo);
	}
	
	public int deleteReply(int num) {
		return (Integer)selectOne("replyDao.deleteReply",num);
	}
	 
}
