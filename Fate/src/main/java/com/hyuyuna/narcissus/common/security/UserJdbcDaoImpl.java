package com.hyuyuna.narcissus.common.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.hyuyuna.narcissus.main.vo.UserVO;

public class UserJdbcDaoImpl extends JdbcDaoImpl {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<UserDetails> users = loadUsersByUsername(username);
		
		if (users.size() == 0) {
			logger.debug("query returned no results for user '" + username + "'");
			
			UsernameNotFoundException ue = new UsernameNotFoundException(
							messages.getMessage("JdbcDaoImpl.notFound", new Object[] {username},
							"User {0} not found")
			);
			
			throw ue;
		}
		
		UserVO user = (UserVO)users.get(0);
		
		Set<GrantedAuthority> dbAuthSet = new HashSet<GrantedAuthority>();
		
		if (getEnableAuthorities()) {
			dbAuthSet.addAll(loadUserAuthorities(user.getUsername()));
		}
		
		if (getEnableGroups()) {
			dbAuthSet.addAll(loadGroupAuthorities(user.getUserName()));
		}
		
		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthSet);
		user.setAuthorities(dbAuths);
		
		if (dbAuths.size() == 0) {
			logger.debug("user '" + username + "' has no authorites and will be treated as 'not found'");
			
			UsernameNotFoundException ue = new UsernameNotFoundException(
					messages.getMessage("JdbcDaoImpl.noAuthority", new Object[] {username},
					"User {0} has no GrantedAuthority")
			);
			
			throw ue;
		}
		
		return user;
	}
	
	
	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		
			return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] {username}, new RowMapper<UserDetails>() {
		public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			String userId = rs.getString(1);
			String password = rs.getString(2);
			String userName = rs.getString(3);
			return new UserVO(userId, password, userName, AuthorityUtils.NO_AUTHORITIES);
		}
				
		}); 
	}
	
	
	protected List<GrantedAuthority> loadUserAuthorities(String username) {
			
			return getJdbcTemplate().query(getAuthoritiesByUsernameQuery(), new String[] {username}, new RowMapper<GrantedAuthority>() {
		public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
			String roleName = getRolePrefix() + rs.getString(1);
			
			return new SimpleGrantedAuthority(roleName);
		}
		
		});
	}
	
	protected List<GrantedAuthority> loadGroupAuthorities(String username) {
		
		return super.loadGroupAuthorities(username);
	}

	
}
