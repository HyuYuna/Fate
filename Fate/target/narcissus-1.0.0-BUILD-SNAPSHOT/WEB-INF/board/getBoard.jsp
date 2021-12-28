<%@page import="java.sql.Date"%>
<%@ page import="com.hyuyuna.narcissus.user.UserDaoImpl" %>
<%@ page import="com.hyuyuna.narcissus.user.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hyuyuna.narcissus.board.*" %>
<%
	/*BoardVO board = (BoardVO)session.getAttribute("board");
	int seq = board.getSeq();
	int seq2 = seq;
	String title = board.getTitle();
	String writer = board.getWriter();
	String content = board.getContent();
	Date regdate = board.getRegDate();
	int cnt = board.getCnt(); */
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<div align="center">
		<br>
		<br>
		<h2>회원상세보기</h2>
		<hr>
		<form action="updateBoard.do">
			<input type="hidden" name="seq2" value="${board.seq }" />
			<table border=1 width=500>
				<tr>
					<td>번호</td>
					<td><input type="text" value="${board.seq }" name="seq"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" value="${board.title }" name="title"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" value="${board.writer}" name="writer"></td>
				</tr>
				<tr>
					<td>글내용</td>
					<td><input type="text" value="${board.content}" name="content"></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="text" value="${board.regDate}" name="regDate"></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td><input type="text" value="${board.cnt}" name="cnt"></td>
				</tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="수정하기">
						<input type="hidden" name="mainSeq" value="${board.seq}" />
					</td>
				</tr>
			</table>
		</form>
		<br/>
		<a href="insertForm.do">글등록</a>&emsp;
		<a href="deleteBoard.do?seq=${board.seq}">글삭제</a>&emsp;
		<a href="getBoardList.do">글목록</a>&emsp;
	</div>
</body>
</html>