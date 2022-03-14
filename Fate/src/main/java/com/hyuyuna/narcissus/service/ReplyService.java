package com.hyuyuna.narcissus.service;

import java.util.List;

import com.hyuyuna.narcissus.vo.ReplyVO;

public interface ReplyService {
	
	public List<ReplyVO> getReplyList(int serial);
	
	public int saveReply(ReplyVO vo);
	
	public int updateReply(ReplyVO vo);
	
	public int deleteReply(int num);
	
	
}
