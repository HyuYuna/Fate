package com.hyuyuna.narcissus.service;

import java.util.List;

import com.hyuyuna.narcissus.vo.ReplyVO;

public interface ReplyService {
	
	// 댓글 목록
	public List<ReplyVO> getReplyList(int serial);
	
	// 댓글 저장
	public int saveReply(ReplyVO vo);
	
	// 댓글 수정
	public int updateReply(ReplyVO vo);
	
	// 댓글 삭제
	public int deleteReply(int num);
	
	
}
