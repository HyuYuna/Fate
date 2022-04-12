<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

	let url;

	function fn_view(productIdx) {
		url = "productView.do";
		url = url + "?productIdx=" + productIdx;
		location.href = url;
	}
	
	function fn_delete(productIdx,filename) {
		url = "deleteFile.do";
		url = url + "?productIdx=" + productIdx + "&fname=" + filename;
		location.href = url;
	}
</script>
<section>
	<br>
	<br>
	<div align="center">
		<font size=5><strong>제품 목록</strong></font>
		<br/><br/> ${cnt} 명 
	</div>
	<br>
	<div class="container mt-15">
		<div class="table-responsive">
			<table  class="table table-striped table-sm">
				<tr>
					<td>제품번호</td>
					<td>제품명</td>
					<td>연락처</td>
					<td>주소</td>
					<td>이미지</td>
				</tr>
				<c:forEach items="${list}" var="m">
					<tr>
						<td>${m.getProductIdx()}</td>
						<td><a href="#" onClick="fn_view(${m.getProductIdx()})">${m.getProductName()}</a></td>
						<td>${m.getTel()}</td>
						<td>${m.getAddress()}</td>
						<td><img src="getImage.do?fileNm=${m.getFname()}" width="50" height="50"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</section>