package com.hyuyuna.narcissus.customer.service;

import java.util.List;
import java.util.Map;

import com.hyuyuna.narcissus.customer.vo.CustomerVO;


public interface CustomerService {
	
	// 전체 고객 목록
	public List<CustomerVO> selectAllCustomer(CustomerVO vo);
	
	// 전체 고객(그리드용)
	public List<CustomerVO> selectAllCustomerJson(Map<String, Object> map);
	
	// 고객수
	public int customerCnt(CustomerVO vo);
	
	// 총 고객수
	public int totalRecords();
	
	// 총 고객수(그리드용)
	public int totalRecordsJson(Map<String, Object> map);
	
	// 고객 등록
	public void insertCustomer(CustomerVO vo);
	
	// 고객 등록(그리드)
	public void insertCustomerJson(Map<String, String> map);
	
	// 고객 삭제
	public void deleteCustomer(int customerIdx);
	
	// 고객 수정
	public void updateCustomer(CustomerVO vo);
	
	// 고객 수정(그리드)
	public void updateCustomerJson(Map<String, String> map);
	
	// 고객 상세
	public CustomerVO selectCustomer(int customerIdx);
	
}
