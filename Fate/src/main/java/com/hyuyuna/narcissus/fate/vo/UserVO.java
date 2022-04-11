package com.hyuyuna.narcissus.fate.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hyuyuna.narcissus.common.PageVO;

public class UserVO extends PageVO{
	
	private String userId;
	private String checkPwd;
	private String password;
	private String encPassword;
	private String userName;
	private String role;
	
	private int page;
    private int records;
    private int total;
    
    private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCheckPwd() {
		return checkPwd;
	}

	public void setCheckPwd(String checkPwd) {
		this.checkPwd = checkPwd;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncPassword() {
		return encPassword;
	}

	public void setEncPassword(String encPassword) {
		this.encPassword = encPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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