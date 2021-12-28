<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hyuyuna.narcissus.board.*" %>
<%@ page import="com.hyuyuna.narcissus.user.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
로그인 성공!! &nbsp; 
<a href="logout.do">[로그아웃]</a>
<br/><br/>


<br/>
<div align="center">
	<table border="1" width="700">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${boardList }" var="board">
			<tr>
				<td><a href="getBoard.do?seq=${board.seq}">${board.seq}</a></td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td>${board.regDate}</td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
	</table>
	
	<form action="getBoardList.do">
		<select name="ch1">
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="ch2">
		<input type="submit" value="검색하기">
	</form>
</div>
</body>
</html>