<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="com.hyuyuna.narcissus.fate.vo.UserVO" %>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	Object principal = auth.getPrincipal();
	String name = "";
	if(principal != null && principal instanceof UserVO) {
		name = ((UserVO)principal).getUserName();
	}
	
 %>
<!DOCTYPE html>
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>쇼핑몰</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.bundle.min.js"></script>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
  </head>
  
<header>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <a class="navbar-brand" href="main.do">Fate</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="main.do">Home</a>
          </li>
          <sec:authorize access="hasRole('ADMIN')">
          	<li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-expanded="false">관리자</a>
	          <div class="dropdown-menu" aria-labelledby="dropdown01">
	            <a class="dropdown-item" href="userJoin.do">사용자 등록</a>
	          </div>
	        </li>
          </sec:authorize>
          <sec:authorize access="hasAnyRole('ADMIN','MANAGER')">
            <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-expanded="false">등록</a>
	          <div class="dropdown-menu" aria-labelledby="dropdown02">
	            <a class="dropdown-item" href="customerForm.do">고객 등록</a>
	            <a class="dropdown-item" href="productForm.do">제품 등록</a>
	          </div>
	        </li>
          </sec:authorize>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown" aria-expanded="false">조회/수정</a>
	        <div class="dropdown-menu" aria-labelledby="dropdown03">
	          	<a class="dropdown-item" href="customerList.do">고객 목록 조회/수정</a>
	          <a class="dropdown-item" href="productList.do">제품 목록 조회/수정</a>
	        </div>
	      </li>
          <sec:authorize access="hasRole('ADMIN')">
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-expanded="false">그리드</a>
	            <div class="dropdown-menu" aria-labelledby="dropdown04">
         	      <a class="dropdown-item" href="customerGrid.do">그리드</a>
	 	        </div>
	        </li>
          </sec:authorize>
      	</ul>
      	<sec:authorize access="isAuthenticated()">
	     	<span style="color:#fff; margin-right:5px"><%=name%></span>
	      	<li class="nav-item" style="display:initial;">
	          <a class="nav-link" href="logout.do" >로그아웃</a>
	        </li>
        </sec:authorize>
      	<sec:authorize access="isAnonymous()">
	      	<li class="nav-item" style="display:initial;">
	          <a class="nav-link" href="login.do" >로그인</a>
	        </li>
        </sec:authorize>
    </div>
  </nav>
</header>
