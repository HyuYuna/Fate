package com.hyuyuna.narcissus.customer.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.common.FileUtils;
import com.hyuyuna.narcissus.customer.dao.CustomerDao;
import com.hyuyuna.narcissus.customer.vo.CustomerVO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Resource(name="fileUtils")
	FileUtils fileutils;
	
	@Resource(name="customerDao")
	CustomerDao dao;
	
	// 전체 회원 목록
	@Override
	public List<CustomerVO> selectAllCustomer(CustomerVO vo) {
		return dao.selectAllcustomer(vo);
	}
	
	// 전체 회원(그리드용)
	public List<CustomerVO> selectAllCustomerJson(Map<String, Object> map) {
		return dao.selectAllCustomerJson(map);
	}
	
	// 회원수
	@Override
	public int customerCnt(CustomerVO vo) {
		return dao.customerCnt(vo);
	}
	
	// 총 회원수
	@Override
	public int totalRecords() {
		return dao.totalRecords();
	}
	
	// 총 회원수(그리드용)
	public int totalRecordsJson(Map<String, Object> map) {
		return dao.totalRecordsJson(map);
	}
	
	// 회원 등록
	@Override
	public void insertCustomer(CustomerVO vo) {
		dao.insertCustomer(vo);
	}
	
	// 회원 등록
	@Override
	public void insertCustomerJson(Map<String, String> map) {
		dao.insertCustomerJson(map);
	}
	
	// 회원 삭제
	@Override
	public void deleteCustomer(int custno) {
		dao.deleteCustomer(custno);
	}
	
	// 회원 수정
	@Override
	public void updateCustomer(CustomerVO vo) {
		dao.updateCustomer(vo);
	}
	
	// 회원 수정
	@Override
	public void updateCustomerJson(Map<String, String> map) {
		dao.updateCustomerJson(map);
	}
	
	// 회원 상세
	@Override
	public CustomerVO selectCustomer(int custno) {
		return dao.selectCustomer(custno);
	}
	
	 
}
