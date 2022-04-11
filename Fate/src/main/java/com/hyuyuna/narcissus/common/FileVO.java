package com.hyuyuna.narcissus.common;

public class FileVO {
	
	private int num;
	private int custno;
	private String originalFileName;
	private String storedFileName;
	private String fileSize;
	private String delGb;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getDelGb() {
		return delGb;
	}
	public void setDelGb(String delGb) {
		this.delGb = delGb;
	}
	
}