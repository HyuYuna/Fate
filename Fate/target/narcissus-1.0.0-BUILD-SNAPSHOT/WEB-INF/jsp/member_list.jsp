<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="layout/header.jsp" />
<section>
	<br>
	<br>
	<div align="center">
	<font size=5><strong>회원 목록</strong></font>
		<div class="container mt-50">
			<div class="table-responsive">
			<table  class="table table-striped table-sm">
				<tr>
					<td>회원번호</td>
					<td>회원성명</td>
					<td>전화번호</td>
					<td>주소</td>
					<td>가입일자</td>
					<td>고객등급</td>
					<td>거주지역</td>
				</tr>
				<c:forEach items="${list}" var="m">
					<tr>
						<td><a href="delete.do?custno=${m.getCustno()}">${m.getCustno()}</td>
						<td><a href="edit.do?custno=${m.getCustno()}">${m.getCustname()}</td>
						<td>${m.getPhone()}</td>
						<td>${m.getAddress()}</td>
						<td>${m.getJoindate()}</td>
						<td>${m.getGrade()}</td>
						<td>${m.getCity()}</td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
		
		<form action="memberlist.do" style="margin-bottom:5px;">
			<select name="ch1">
				<option value="custno">번호</option>
				<option value="name">이름</option>
			</select>
			<input type="text" name="ch2">
			<button type="submit" class="btn btn-primary">검색하기</button>
		</form>

	</div>
</section>
<c:import url="layout/footer.jsp" />