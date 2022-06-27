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
	
	// 고객 목록
	@Override
	public List<CustomerVO> selectCustomerList(CustomerVO vo) {
		return dao.selectCustomerList(vo);
	}
	
	// 고객 목록(그리드용)
	public List<Map<String, Object>> selectCustomerListJson(Map<String, Object> map) {
		return dao.selectCustomerListJson(map);
	}
	
	// 고객수
	@Override
	public int customerCnt(CustomerVO vo) {
		return dao.customerCnt(vo);
	}
	
	// 총 고객수
	@Override
	public int totalRecords() {
		return dao.totalRecords();
	}
	
	// 총 고객수(그리드용)
	public int totalRecordsJson(Map<String, Object> map) {
		return dao.totalRecordsJson(map);
	}
	
	// 고객 등록
	@Override
	public void insertCustomer(CustomerVO vo) {
		dao.insertCustomer(vo);
	}
	
	// 고객 등록
	@Override
	public void insertCustomerJson(Map<String, String> map) {
		dao.insertCustomerJson(map);
	}
	
	// 고객 삭제
	@Override
	public void deleteCustomer(int customerIdx) {
		dao.deleteCustomer(customerIdx);
	}
	
	// 고객 수정
	@Override
	public void updateCustomer(CustomerVO vo) {
		dao.updateCustomer(vo);
	}
	
	// 고객 수정
	@Override
	public void updateCustomerJson(Map<String, String> map) {
		dao.updateCustomerJson(map);
	}
	
	// 고객 상세
	@Override
	public CustomerVO selectCustomer(int customerIdx) {
		return dao.selectCustomer(customerIdx);
	}
	
	 
}
