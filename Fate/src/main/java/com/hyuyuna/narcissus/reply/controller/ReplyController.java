package com.hyuyuna.narcissus.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyuyuna.narcissus.common.SessionManager;
import com.hyuyuna.narcissus.reply.service.ReplyService;
import com.hyuyuna.narcissus.reply.vo.ReplyVO;

@Controller
public class ReplyController {
	
	@Resource(name="replyService")
	ReplyService service;
	
	@Autowired
	private SessionManager sessionManager;
	
	// 댓글 목록
	@RequestMapping(value="/getReplyList.do", method=RequestMethod.POST)
	@ResponseBody
	public List<ReplyVO> getReplyList(@RequestParam("serial") int serial) throws Exception {
		List<ReplyVO> replyList = service.getReplyList(serial);
		
		return replyList;
	} 
	
	// 댓글 저장
	@RequestMapping(value="/saveReply.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> saveReply(@RequestBody ReplyVO replyVO) throws Exception {
		Map<String, Object> result = new HashMap();
		
		try {
			service.saveReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	}
	
	// 댓글 수정
	@RequestMapping(value="/updateReply.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateReply(@RequestBody ReplyVO replyVO) throws Exception {
		Map<String, Object> result = new HashMap();
		try {
			service.updateReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	
	}
	
	// 댓글 삭제
	@RequestMapping(value="/deleteReply.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteReply(@RequestParam("num") int num) throws Exception {
		Map<String, Object> result = new HashMap();
		try {
			service.deleteReply(num);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	}
	
}