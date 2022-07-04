package com.hyuyuna.narcissus.admin.vo;

public class AuthorityVO {
	
	private int authorityIdx;
	private int resourceIdx;
	private int rnum;
	private int sortOrder;
	private String authority;
	private String authorityName;
	private String resourceName;
	private String resourcePattern;
	private String resourceType;
	
	public int getAuthorityIdx() {
		return authorityIdx;
	}
	public void setAuthorityIdx(int authorityIdx) {
		this.authorityIdx = authorityIdx;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public int getResourceIdx() {
		return resourceIdx;
	}
	public void setResourceIdx(int resourceIdx) {
		this.resourceIdx = resourceIdx;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourcePattern() {
		return resourcePattern;
	}
	public void setResourcePattern(String resourcePattern) {
		this.resourcePattern = resourcePattern;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
}
