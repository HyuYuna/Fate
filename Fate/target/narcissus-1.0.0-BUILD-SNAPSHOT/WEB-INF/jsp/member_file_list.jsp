<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="layout/header.jsp" />
<section>
	<br>
	<br>
	<div align="center">
		<font size=5><strong>이미지 회원 목록</strong></font>
		<br/><br/> ${cnt} 명 
	</div>
	<br>
	<div class="container mt-15">
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
					<td>이미지</td>
				</tr>
				<c:forEach items="${list}" var="m">
					<tr>
						<td><a href="deleteFile.do?custno=${m.getCustno()}&filename=${m.getFname()} ">${m.getCustno()}</td>
						<td>${m.getCustname()}</td>
						<td>${m.getPhone()}</td>
						<td>${m.getAddress()}</td>
						<td>${m.getJoindate()}</td>
						<td>
							<c:if test="${m.getGrade() == 'A' }"> VIP </c:if>
							<c:if test="${m.getGrade() == 'B' }"> 일반 </c:if>
							<c:if test="${m.getGrade() == 'C' }"> 직원 </c:if>
						</td>
						<td>${m.getCity()}</td>
						<td><img src="./upfile/${m.getFname()}" width="50" height="50"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</section>
<c:import url="layout/footer.jsp" />