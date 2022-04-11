package com.hyuyuna.narcissus.customer.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hyuyuna.narcissus.common.PageVO;

public class CustomerVO extends PageVO{
	
	private int customerIdx;
	private String customerName;
	private String phone;
    private String address;
	private String joindate;
	private String grade;
	private String city;
	private String content;
	
	private String searchType;
	private String keyword;
	
	private String fname;
	
	private int page;
    private int records;
    private int total;
    
    private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	
	
    
	public int getCustomerIdx() {
		return customerIdx;
	}
	public void setCustomerIdx(int customerIdx) {
		this.customerIdx = customerIdx;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Map<String, Object>> getRows() {
		return rows;
	}
	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}
	
	
}