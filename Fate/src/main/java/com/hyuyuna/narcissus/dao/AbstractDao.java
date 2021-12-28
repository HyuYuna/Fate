package com.hyuyuna.narcissus.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {
	
	protected Log log = LogFactory.getLog(AbstractDao.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public Object insert(String queryId, Object params) {
		return sqlSession.insert(queryId, params);
	}

	public Object update(String queryId, Object params) {
		return sqlSession.update(queryId, params);
	}

	public Object delete(String queryId, Object params) {
		return sqlSession.delete(queryId, params);
	}

	public Object selectOne(String queryId) {
		return sqlSession.selectOne(queryId);
	}

	public Object selectOne(String queryId, Object params) {
		return sqlSession.selectOne(queryId, params);
	}

	@SuppressWarnings("rawtypes")
	public List selectList(String queryId) {
		return sqlSession.selectList(queryId);
	}

	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params) {
		return sqlSession.selectList(queryId, params);
	}

}
