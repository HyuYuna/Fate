package com.hyuyuna.narcissus.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.dao.ReplyDao;
import com.hyuyuna.narcissus.vo.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{
	
	@Resource(name="replyDao")
	ReplyDao dao;
	
	// 댓글 목록
	public List<ReplyVO> getReplyList(int serial) {
		return dao.getReplyList(serial);
	}
	
	// 댓글 저장
	public int saveReply(ReplyVO vo) {
		return dao.saveReply(vo);
	}
	
	// 댓글 수정
	public int updateReply(ReplyVO vo) {
		return dao.updateReply(vo);
	}
	
	// 댓글 삭제
	public int deleteReply(int num) {
		return dao.deleteReply(num);
	}
	 
}
