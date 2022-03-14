package com.hyuyuna.narcissus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyuyuna.narcissus.common.SessionManager;
import com.hyuyuna.narcissus.service.ReplyService;
import com.hyuyuna.narcissus.vo.ReplyVO;

@Controller
public class ReplyController {
	
	@Resource(name="replyService")
	ReplyService service;
	
	@Autowired
	private SessionManager sessionManager;
	
	
	@RequestMapping(value="/getReplyList.do", method=RequestMethod.POST)
	@ResponseBody
	public List<ReplyVO> getReplyList(@RequestParam("serial") int serial) throws Exception {
		List<ReplyVO> replyList = service.getReplyList(serial);
		
		return replyList;
	} 
	
	
	@RequestMapping(value="/saveReply.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> saveReply(@RequestParam ReplyVO replyVO) throws Exception {
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
	
	
	@RequestMapping(value="/updateReply.do", method=RequestMethod.POST)
	public Map<String,Object> updateReply(@RequestParam ReplyVO replyVO) throws Exception {
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
	
}