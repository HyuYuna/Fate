<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	$(document).on('click','#btnReg', function() {
		document.location.href = "resourceReg.do";
	});
	
	function fn_view(resourceIdx) {
		url = "resourceDtl.do";
		url = url + "?resourceIdx=" + resourceIdx + "&mode=edit";
		location.href = url;
	}
	
</script>

<style>
	tr,td {
		text-align:center;
	}
</style>

<section>
	<br>
	<br>
	<div align="center">
	<font size=5><strong>리소스 목록</strong></font>
		<div class="container">
			<button type="button" id="btnReg" class="btn btn-sm btn-primary" style="float:right;">등록</button>
		</div>
		<div class="container mt-50">
			<div class="table-responsive">
			<table  class="table table-striped table-sm">
				<thead>
					<tr>
						<th>리소스 이름</th>
						<th>리소스 패턴</th>
						<th>권한</th>
						<th>우선순위</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="m">
						<tr>
							<td><a href="#" id="btnDtl" onClick="fn_view(${m.getResourceIdx()})">${m.getResourceName()}</a></td>
							<td>${m.getResourcePattern()}</td>
							<td>${m.getAuthority()}</td>
							<td>${m.getSortOrder()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
	</div>
</section>