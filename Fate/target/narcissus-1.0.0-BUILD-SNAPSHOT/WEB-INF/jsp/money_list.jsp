<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="layout/header.jsp" />
<section>
	<br>
	<br> <br>
	<div align="center">
		<font size=5><b> 회원 매출 조회</b></font>
		<div class="container mt-50">
			<div class="table-responsive">
			<table  class="table table-striped table-sm">
				<tr align=center>
					<td>회원번호</td>
					<td>회원성명</td>
					<td>고객등급</td>
					<td>매출</td>
				</tr>
				<c:forEach items="${moneylist }" var="m">
					<tr align=center>
						<td>${m.custno}</td>
						<td>${m.custname}</td>
						<td>
							<c:if test="${m.getGrade() == 'A' }"> VIP </c:if>
							<c:if test="${m.getGrade() == 'B' }"> 일반 </c:if>
							<c:if test="${m.getGrade() == 'C' }"> 직원 </c:if>
						</td>
						<td>
							<fmt:formatNumber value="${m.price }" pattern="#,###" />
						</td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
	</div>
</section>
<c:import url="layout/footer.jsp" />