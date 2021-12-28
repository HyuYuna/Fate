package com.hyuyuna.narcissus.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.common.MemberVO;
import com.hyuyuna.narcissus.dao.FateDao;

@Service("fateService")
public class FateServiceImpl implements FateService{
	
	@Resource(name="fateDao")
	FateDao dao;
	
	@Override
	public MemberVO login(MemberVO vo) {
		return dao.login(vo);
	}
	
	@Override
	public void joinUser(MemberVO vo) {
		dao.joinUser(vo);
	}
	 
}
