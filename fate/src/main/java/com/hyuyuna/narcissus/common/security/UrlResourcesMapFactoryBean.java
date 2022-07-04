package com.hyuyuna.narcissus.common.security;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.hyuyuna.narcissus.common.security.service.SecuredObjectService;

public class UrlResourcesMapFactoryBean implements 
				FactoryBean<LinkedHashMap<RequestMatcher, List<ConfigAttribute>>> {
	
	private SecuredObjectService securedObjectService;
	
	private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> requestMap;
	
	public void setSecuredObjectService(SecuredObjectService securedObjectService) {
		this.securedObjectService = securedObjectService;
	}
	
	public void init() throws Exception {
		requestMap = securedObjectService.getAuthorityAndUrl();
	}

	@Override
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getObject() throws Exception {
		
		if(requestMap == null) {
			requestMap = securedObjectService.getAuthorityAndUrl();
		}
		return requestMap;
	}

	@Override
	public Class<?> getObjectType() {

		return LinkedHashMap.class;
	}

	@Override
	public boolean isSingleton() {

		return true;
	}

}
