package com.hyuyuna.narcissus.service;

import com.hyuyuna.narcissus.vo.MemberVO;

public interface FateService {
	
	public MemberVO login(MemberVO vo);
	
	public void joinUser(MemberVO vo);
	
}
