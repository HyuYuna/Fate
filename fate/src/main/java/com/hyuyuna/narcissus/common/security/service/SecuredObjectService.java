package com.hyuyuna.narcissus.common.security.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

public interface SecuredObjectService {
	
	// authority에 대한 url의 매핑 정보를 가져온다
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getAuthorityAndUrl() throws Exception;
	
	// authority에 대한 메소드의 매핑 정보를 보여준다
	public LinkedHashMap<String, List<ConfigAttribute>> getAuthorityAndMethod() throws Exception;
	
	// authority에 대한 Aop pointcut 매핑 정보를 보여준다
	public LinkedHashMap<String, List<ConfigAttribute>> getAuthorityAndPointcut() throws Exception;
	
	// Best 매핑 정보를 얻어온다
	public List<ConfigAttribute> getMatchedRequestMapping(String url) throws Exception;
	
	// authoirty의 계층 정보를 가져온다
	public String getHierarchicalAuthorities() throws Exception;
	

}
