package com.hyuyuna.narcissus.customer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.common.AbstractDao;
import com.hyuyuna.narcissus.customer.vo.CustomerVO;

@Repository("customerDao")
public class CustomerDao extends AbstractDao {

	// 고객 목록
	@SuppressWarnings("unchecked")
	public List<CustomerVO> selectCustomerList(CustomerVO vo) {
		return (List<CustomerVO>)selectList("customerDao.selectCustomerList", vo);
	}
	
	// 고객 목록(그리드용)
	@SuppressWarnings("unchecked")
	public List<CustomerVO> selectCustomerListJson(Map<String, Object> map) {
		return (List<CustomerVO>)selectList("customerDao.selectCustomerListJson", map);
	}
	
	// 고객수
	public int customerCnt(CustomerVO vo) {
		return (Integer)selectOne("customerDao.customerCnt", vo);
	}
	
	// 총 고객수
	public int totalRecords() {
		return (Integer)selectOne("customerDao.totalRecords");
	}
	
	// 총 고객수(그리드용)
	public int totalRecordsJson(Map<String, Object> map) {
		return (Integer)selectOne("customerDao.totalRecordsJson", map);
	}

	// 고객 등록
	public void insertCustomer(CustomerVO vo) {
		insert("customerDao.insertCustomer" , vo);
	}
	
	// 고객 등록(그리드)
	public void insertCustomerJson(Map<String, String> map) {
		insert("customerDao.insertCustomerJson" , map);
	}

	// 고객 삭제
	public void deleteCustomer(int customerIdx) {
		delete("customerDao.deleteCustomer", customerIdx);
	}

	// 고객 수정
	public void updateCustomer(CustomerVO vo) {
		int k = (Integer)update("customerDao.updateCustomer", vo);
		System.out.println("으으윽"+ k);
	}
	
	// 고객 수정(그리드)
	public void updateCustomerJson(Map<String, String> map) {
		int k = (Integer)update("customerDao.updateCustomerJson", map);
		System.out.println("으으윽"+ k);
	}
	
	// 고객 상세
	public CustomerVO selectCustomer(int customerIdx) {
		return (CustomerVO)selectOne("customerDao.selectCustomer", customerIdx);
	}
	 
}
