package com.hyuyuna.narcissus.customer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.common.AbstractDao;
import com.hyuyuna.narcissus.customer.vo.CustomerVO;

@Repository("customerDao")
public class CustomerDao extends AbstractDao {

	// 전체 회원 목록
	@SuppressWarnings("unchecked")
	public List<CustomerVO> selectAllcustomer(CustomerVO vo) {
		return (List<CustomerVO>)selectList("customerDao.selectAllcustomer", vo);
	}
	
	// 전체 회원(그리드용)
	@SuppressWarnings("unchecked")
	public List<CustomerVO> selectAllCustomerJson(Map<String, Object> map) {
		return (List<CustomerVO>)selectList("customerDao.selectAllCustomerJson", map);
	}
	
	// 회원수
	public int customerCnt(CustomerVO vo) {
		return (Integer)selectOne("customerDao.customerCnt", vo);
	}
	
	// 총 회원수
	public int totalRecords() {
		return (Integer)selectOne("customerDao.totalRecords");
	}
	
	// 총 회원수(그리드용)
	public int totalRecordsJson(Map<String, Object> map) {
		return (Integer)selectOne("customerDao.totalRecordsJson", map);
	}

	// 회원 등록
	public void insertCustomer(CustomerVO vo) {
		insert("customerDao.insertCustomer" , vo);
	}
	
	// 회원 등록(그리드)
	public void insertCustomerJson(Map<String, String> map) {
		insert("customerDao.insertCustomerJson" , map);
	}

	// 회원 삭제
	public void deleteCustomer(int custno) {
		delete("customerDao.deleteCustomer", custno);
	}

	// 회원 수정
	public void updateCustomer(CustomerVO vo) {
		int k = (Integer)update("customerDao.updateCustomer", vo);
		System.out.println("으으윽"+ k);
	}
	
	// 회원 수정(그리드)
	public void updateCustomerJson(Map<String, String> map) {
		int k = (Integer)update("customerDao.updateCustomerJson", map);
		System.out.println("으으윽"+ k);
	}
	
	// 회원 상세
	public CustomerVO selectCustomer(int custno) {
		return (CustomerVO)selectOne("customerDao.selectCustomer", custno);
	}
	 
}
