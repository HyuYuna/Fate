package com.hyuyuna.narcissus.common;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class SessionManager {
	
	 public static final String SESSION_COOKIE_NAME = "Fate";
	 private Map<String,Object> sessionStore = new ConcurrentHashMap<>();
	 
	 // 세션 생성
	 public void createSession(Object value, HttpServletResponse response) {
		 
		 String sessionId = UUID.randomUUID().toString();
		 sessionStore.put(sessionId, value);
		 
		 Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
		 response.addCookie(cookie);
	 }
	 
	 // 세션 가져오기
	 public Object getSession(HttpServletRequest request) throws UnsupportedEncodingException {
 		 Cookie cookie = findCookie(request, SESSION_COOKIE_NAME);
		 if (cookie == null) {
			 return null;
		 }
		 return sessionStore.get(cookie.getValue());
	 }
	 
	// 세션 만료
	public void expire(HttpServletRequest request) throws UnsupportedEncodingException {
		 Cookie cookie = findCookie(request, SESSION_COOKIE_NAME);
		 if (cookie != null) {
			 sessionStore.remove(cookie.getValue());
		 }
	 }
	 
	// 세선 찾기
	 public Cookie findCookie(HttpServletRequest request, String cookieName) throws UnsupportedEncodingException {
		 if (request.getCookies() == null) {
			 return null;
		 }
		 Cookie[] cookie = request.getCookies(); 
		 for(int i=0; i<cookie.length; i++) {
		 	if(cookie[i].getName().equals(cookieName)){
		 		System.out.println(cookie[i]);
		 		return cookie[i];
		 	}
		 }
		 return null;
	 }
	 
 }
