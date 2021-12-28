<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<form action="insertBoard.do" method=GET>
	 <table border=1 width=500>
		 <tr>
		 	<td>제목</td> <td><input type="text" name="title"></td>
		 </tr>
		 <tr>
		 	<td>작성자</td> <td><input type="text" name="writer"></td>
		 </tr>
		 <tr>
		 	<td>글내용</td> <td><textarea rows="5" cols="40" name="content"></textarea>  </tr>
		 <tr>
		 	<td colspan=2 align="center"><input type="submit" value="글등록">&emsp;<input type="reset" value="다시쓰기"></td>
		 </tr>
	 </table>
</form>
</html>
