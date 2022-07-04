package com.hyuyuna.narcissus.common.security.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecuredObjectDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
    // url 형식인 보호자원 - authority 맵핑정보를 조회하는 default 쿼리이다.
	public static final String DEF_AUTHORITY_AND_URL_QUERY = 
				"SELECT A.RESOURCE_PATTERN AS URL, B.AUTHORITY AS AUTHORITY"
					+ "FROM SECURED_RESOURCE A, SECURED_RESOURCE_AUTHORITY B"
					+ "WHERE A.RESOURCE_IDX = B.RESOURCE_IDX"
					+ "AND A.RESOURCE_TYPE = 'url' "
					+ "ORDER BY A.SORT_ORDER";
	
	
	// method 형식인 보호자원 - authority 맵핑정보를 조회하는 default 쿼리이다.
	public static final String DEF_AUTHORITY_AND_METHOD_QUERY = 
			"SELECT A.RESOURCE_PATTERN AS URL, B.AUTHORITY AS AUTHORITY"
				+ "FROM SECURED_RESOURCE A, SECURED_RESOURCE_AUTHORITY B"
				+ "WHERE A.RESOURCE_IDX = B.RESOURCE_IDX"
				+ "AND A.RESOURCE_TYPE = 'method' "
				+ "ORDER BY A.SORT_ORDER";
	
	
	// pointcut 형식인 보호자원 - authority 맵핑정보를 조회하는 default 쿼리이다.
	public static final String DEF_AUTHORITY_AND_POINTCUT_QUERY = 
			"SELECT A.RESOURCE_PATTERN AS URL, B.AUTHORITY AS AUTHORITY"
				+ "FROM SECURED_RESOURCE A, SECURED_RESOURCE_AUTHORITY B"
				+ "WHERE A.RESOURCE_IDX = B.RESOURCE_IDX"
				+ "AND A.RESOURCE_TYPE = 'pointcut' "
				+ "ORDER BY A.SORT_ORDER";

	
	// 매 request 마다 best matching url 보호자원 - authority 맵핑정보를 얻기위한 default 쿼리이다.
	public static final String DEF_REGEX_MATCHED_REQUEST_MAPPING_QUERY =
			"SELECT a.RESOURCE_PATTERN url, b.AUTHORITY authority"
				+ "FROM secured_resource a, secured_resource_authority b"
				+ "WHERE a.RESOURCE_IDX = b.RESOURCE_IDX"
				+ "AND a.RESOURCE_IDX = "
				+ " ( SELECT RESOURCE_IDX FROM "
				+ " 	( SELECT RESOURCE_IDX, ROW_NUMBER() OVER (ORDER BY sort_order) resource_order FROM SECURED_RESOURCE C "
				+ " 	  WHERE c.resource_pattern REGEXP('url') "
				+ "		  AND c.resource_type = 'url' "
				+ "		  ORDER BY c.sort_order )" 
				+ "  WHERE resource_order = 1 ) ";
	
	
	// AUTHORITY의 계층(hierarchy) 관계를 조회하는 쿼리이다.
	public static final String DEF_HIERARCHICAL_AUTHORITY_QUERY = 
			"SELECT A.child_authority child, a.parent_authority parent "
				+ "FROM AUTHORITY_HIERARCHY a LEFT JOIN AUTHORITY_HIERARCHY B on (a.chile_authority = b.parent_authority)";
	
	private String sqlAuthorityAndUrl;
	
	private String sqlAuthorityAndMethod;
	
	private String sqlAuthorityAndPointCut;
	
	private String sqlRegexMatchedRequestMapping;
	
	private String sqlHierarchicalAuthority;

	public SecuredObjectDao() {
		this.sqlAuthorityAndUrl = DEF_AUTHORITY_AND_URL_QUERY;
		this.sqlAuthorityAndMethod = DEF_AUTHORITY_AND_METHOD_QUERY;
		this.sqlAuthorityAndPointCut = DEF_AUTHORITY_AND_POINTCUT_QUERY;
		this.sqlRegexMatchedRequestMapping = DEF_REGEX_MATCHED_REQUEST_MAPPING_QUERY;
		this.sqlHierarchicalAuthority = DEF_HIERARCHICAL_AUTHORITY_QUERY;
	}
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate =
				new NamedParameterJdbcTemplate(dataSource);
	}

	public String getSqlAuthorityAndUrl() {
		return sqlAuthorityAndUrl;
	}

	public void setSqlAuthorityAndUrl(String sqlAuthorityAndUrl) {
		this.sqlAuthorityAndUrl = sqlAuthorityAndUrl;
	}

	public String getSqlAuthorityAndMethod() {
		return sqlAuthorityAndMethod;
	}

	public void setSqlAuthorityAndMethod(String sqlAuthorityAndMethod) {
		this.sqlAuthorityAndMethod = sqlAuthorityAndMethod;
	}

	public String getSqlAuthorityAndPointCut() {
		return sqlAuthorityAndPointCut;
	}

	public void setSqlAuthorityAndPointCut(String sqlAuthorityAndPointCut) {
		this.sqlAuthorityAndPointCut = sqlAuthorityAndPointCut;
	}

	public String getSqlRegexMatchedRequestMapping() {
		return sqlRegexMatchedRequestMapping;
	}

	public void setSqlRegexMatchedRequestMapping(String sqlRegexMatchedRequestMapping) {
		this.sqlRegexMatchedRequestMapping = sqlRegexMatchedRequestMapping;
	}

	public String getSqlHierarchicalAuthority() {
		return sqlHierarchicalAuthority;
	}

	public void setSqlHierarchicalAuthority(String sqlHierarchicalAuthority) {
		this.sqlHierarchicalAuthority = sqlHierarchicalAuthority;
	}
	
	public LinkedHashMap<Object, List<ConfigAttribute>> getAuthorityAndResources(String resourceType) throws Exception {
		
		LinkedHashMap<Object, List<ConfigAttribute>> resourcesMap = new LinkedHashMap<Object, List<ConfigAttribute>>();
		
		String sqlAuthorityAndResources;
		boolean isResourcesUrl = true;
		if ("method".equals(resourceType)) {
			sqlAuthorityAndResources = getSqlAuthorityAndMethod();
			isResourcesUrl = false;
		} else if ("pointcut".equals(resourceType)) {
			sqlAuthorityAndResources = getSqlAuthorityAndPointCut();
			isResourcesUrl = false;
		} else {
			sqlAuthorityAndResources = getSqlAuthorityAndUrl();
		}
		
		List<Map<String, Object>> resultList = this.namedParameterJdbcTemplate.queryForList(sqlAuthorityAndResources, new HashMap<String, String>());
	
		Iterator<Map<String, Object>> itr = resultList.iterator();
		Map<String, Object> tempMap;
		String preResource = null;
		String presentResourceStr;
		Object presentResource;
		
		while (itr.hasNext()) {
			tempMap = itr.next();
			
			presentResourceStr = (String) tempMap.get(resourceType);
			
			// url 인 경우 RequestKey형식의 key를 map에 담아야함
			presentResource = isResourcesUrl ? new AntPathRequestMatcher(presentResourceStr) : presentResourceStr;
			List<ConfigAttribute> configList = new LinkedList<ConfigAttribute>();
			
			// 이미 requestMap에 해당 Resource에 대한 authority가 하나 이상 맵핑되어 있었던 경우,
			// sort_order는 resource(Resource)에 대해 매겨지므로 같은 Resource에 대한 authority 맵핑은 연속으로 조회됨
			// 해당 맵핑 AUTHORITY LIST (securityConfig)의 데이터를 재활용하여 새롭게 데이터 구축
			if(preResource != null && presentResourceStr.equals(preResource)) {
				List<ConfigAttribute> preAuthList = resourcesMap.get(presentResource);
				Iterator<ConfigAttribute> preAuthItr = preAuthList.iterator();
				while (preAuthItr.hasNext()) {
					SecurityConfig tempConfig = (SecurityConfig) preAuthItr.next();
					configList.add(tempConfig);
				}
			}
			
			configList.add(new SecurityConfig((String) tempMap.get("authority")));
			
			// 만약 동일한 Resource 에 대해 한개 이상의  Authority 맵핑 추가인 경우
			// 이전 ResourceKey 에 현재 새로 계산된 Authority 맵핑 리스트로 덮어쓰게 됨
			resourcesMap.put(presentResource, configList);
			
			// 이전 resource 비교위해 저장
			preResource = presentResourceStr;
		}
		
		return resourcesMap;
	}
	
	public LinkedHashMap<Object, List<ConfigAttribute>> getAuthorityAndUrl() throws Exception {
		return getAuthorityAndResources("url");
	}
	
	public LinkedHashMap<Object, List<ConfigAttribute>> getAuthorityAndMethod() throws Exception {
		return getAuthorityAndResources("method");
	}
	
	public LinkedHashMap<Object, List<ConfigAttribute>> getAuthorityAndPointcut() throws Exception {
		return getAuthorityAndResources("pointcut");
	}
	
	public List<ConfigAttribute> getRegaxMatchedRequestMapping(String url) throws Exception {
			
		// best regex matching - best 매칭 된 url에 따른 Authority List 조회
		// DB 차원의 정규식 지원이 있는 경우 사용  (ex. hsqldb custom function, Oracle 10g regexp_like 등)
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("url",url);
		List<Map<String, Object>> resultList = this.namedParameterJdbcTemplate.queryForList(getSqlRegexMatchedRequestMapping(), paramMap);
		
		Iterator<Map<String, Object>> itr = resultList.iterator();
		Map<String, Object> tempMap;
		List<ConfigAttribute> configList = new LinkedList<ConfigAttribute>();
		
		// 같은 url에 대한 Authority 맵핑이므로 무조건 configList에 add함
		while (itr.hasNext()) {
			tempMap = itr.next();
			configList.add(new SecurityConfig((String)tempMap.get("authority")));
		}
		
		if (configList.size() > 0) {
			logger.debug("request url : {}, matched url : {}, mapping authority :{}", url, resultList.get(0).get("url"), configList);
		}
		
		return configList;
		
	}
	
	public String getHierarchicalAuthorities() throws Exception {
		
		List<Map<String, Object>> resultList = this.namedParameterJdbcTemplate.queryForList(getSqlHierarchicalAuthority(), new HashMap<String, Object>());
		
		Iterator<Map<String, Object>> itr = resultList.iterator();
		StringBuffer concatedAuthority = new StringBuffer();
		Map<String, Object> tempMap;
		while (itr.hasNext()) {
			tempMap = itr.next();
			concatedAuthority.append(tempMap.get("child"));
			concatedAuthority.append(">");
			concatedAuthority.append(tempMap.get("parent"));
			concatedAuthority.append("\n");
		}
		
		return concatedAuthority.toString();
	}
	
}
