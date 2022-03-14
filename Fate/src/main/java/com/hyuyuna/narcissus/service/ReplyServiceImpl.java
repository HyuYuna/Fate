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
	
	public List<ReplyVO> getReplyList(int serial) {
		return dao.getReplyList(serial);
	}
	
	public int saveReply(ReplyVO vo) {
		return dao.saveReply(vo);
	}
	
	public int updateReply(ReplyVO vo) {
		return dao.updateReply(vo);
	}
	
	public int deleteReply(int num) {
		return dao.deleteReply(num);
	}
	 
}
