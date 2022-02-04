package com.hyuyuna.narcissus.vo;

import org.springframework.web.multipart.MultipartFile;

public class MoneyVO {
	 private int custno; 
	 private int salenol; 
	 private int pcost; 
	 private int amount; 
	 private int price; 
	 private String custname; 
	 private String grade; 
	 private String pcode; 
	 private String sdate;
	 
	private String phone;
    private String address;
	private String joindate;
	private String city;
	private String flag;
	
	private String ch1;
	private String ch2;
	
	private String fname;
	private MultipartFile uploadFile;
	 
	private MemberVO memberVO;
	
	
	 
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCh1() {
		return ch1;
	}
	public void setCh1(String ch1) {
		this.ch1 = ch1;
	}
	public String getCh2() {
		return ch2;
	}
	public void setCh2(String ch2) {
		this.ch2 = ch2;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public int getSalenol() {
		return salenol;
	}
	public void setSalenol(int salenol) {
		this.salenol = salenol;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate.substring(0, 10);
	}
	@Override
	public String toString() {
		return "MoneyVO [custno=" + custno + ", salenol=" + salenol + ", pcost=" + pcost + ", amount=" + amount
				+ ", price=" + price + ", pcode=" + pcode + ", sdate=" + sdate + "]";
	}
	 
	 
}