package com.hyuyuna.narcissus.reply.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.reply.dao.ReplyDao;
import com.hyuyuna.narcissus.reply.vo.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{
	
	@Resource(name="replyDao")
	ReplyDao dao;
	
	// 댓글 목록
	public List<ReplyVO> selectReplyList(int boardIdx) {
		return dao.selectReplyList(boardIdx);
	}
	
	// 댓글 저장
	public int insertReply(ReplyVO vo) {
		return dao.insertReply(vo);
	}
	
	// 댓글 수정
	public int updateReply(ReplyVO vo) {
		return dao.updateReply(vo);
	}
	
	// 댓글 삭제
	public int deleteReply(int replyIdx) {
		return dao.deleteReply(replyIdx);
	}
	 
}
