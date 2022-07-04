package com.hyuyuna.narcissus.common.security.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.hyuyuna.narcissus.common.security.dao.SecuredObjectDao;

public class SecuredObjectServiceImpl implements SecuredObjectService {
	
	private SecuredObjectDao securedObjectDao;

	public SecuredObjectDao getSecuredObjectDao() {
		return securedObjectDao;
	}

	public void setSecuredObjectDao(SecuredObjectDao securedObjectDao) {
		this.securedObjectDao = securedObjectDao;
	}

	@Override
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getAuthorityAndUrl() throws Exception {

		LinkedHashMap<RequestMatcher, List<ConfigAttribute>> ret = new LinkedHashMap<RequestMatcher, List<ConfigAttribute>>();
		LinkedHashMap<Object, List<ConfigAttribute>> data = securedObjectDao.getAuthorityAndUrl();
		Set<Object> keys = data.keySet();
		for (Object key : keys) {
			ret.put((AntPathRequestMatcher)key, data.get(key));
		}
		return ret;
	}

	@Override
	public LinkedHashMap<String, List<ConfigAttribute>> getAuthorityAndMethod() throws Exception {
		
		LinkedHashMap<String, List<ConfigAttribute>> ret = new LinkedHashMap<String, List<ConfigAttribute>>();
		LinkedHashMap<Object, List<ConfigAttribute>> data = securedObjectDao.getAuthorityAndMethod();
		Set<Object> keys = data.keySet();
		for(Object key : keys) {
			ret.put((String)key, data.get(key));
		}
		return ret;
	}

	@Override
	public LinkedHashMap<String, List<ConfigAttribute>> getAuthorityAndPointcut() throws Exception {
		
		LinkedHashMap<String, List<ConfigAttribute>> ret = new LinkedHashMap<String, List<ConfigAttribute>>();
		LinkedHashMap<Object, List<ConfigAttribute>> data = securedObjectDao.getAuthorityAndPointcut();
		Set<Object> keys = data.keySet();
		for(Object key : keys) {
			ret.put((String)key, data.get(key));
		}
		return ret;
	}

	@Override
	public List<ConfigAttribute> getMatchedRequestMapping(String url) throws Exception {
		
		return securedObjectDao.getRegaxMatchedRequestMapping(url);
	}

	@Override
	public String getHierarchicalAuthorities() throws Exception {
		
		return securedObjectDao.getHierarchicalAuthorities();
	}

	
}