package com.hyuyuna.narcissus.reply.vo;

public class ReplyVO {
	
	private int replyIdx;
	private int boardIdx;
	private int productIdx;
	private String content;
	private String register;
	private String register_dt;
	private String update_dt;
	
	
	public int getReplyIdx() {
		return replyIdx;
	}
	
	public void setReplyIdx(int replyIdx) {
		this.replyIdx = replyIdx;
	}
	
	public int getBoardIdx() {
		return boardIdx;
	}
	
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	
	public String getContent() {
		
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getRegister() {
		return register;
	}
	
	public void setRegister(String register) {
		this.register = register;
	}
	
	public String getRegister_dt() {
		return register_dt;
	}
	
	public void setRegister_dt(String register_dt) {
		this.register_dt = register_dt;
	}
	
	public String getUpdate_dt() {
		return update_dt;
	}
	
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	
	
}
