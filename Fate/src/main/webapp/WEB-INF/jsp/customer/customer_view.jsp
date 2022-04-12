<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<script>
	$(document).on('click', '#btnList', function() {
		document.location.href = "customerList.do"
	})
	
	let url;
	
	function fn_detail(customerIdx) {
		url = "customerDtl.do";
		url = url + "?customerIdx=" + customerIdx + "&mode=edit";
		location.href = url;
	}
	
	function fn_delete(customerIdx) {
		url = "customerDelete.do";
		url = url + "?customerIdx=" + customerIdx;
		location.href = url;
	}
</script>
<section>
<br><br>
<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>고객정보</strong></font></div>
	<br><br>
	
	<div class="bg-white rounded shadow-sm">
		<div class="name">
			<c:out value="${detail.customerName}" />
		</div>
		<div class="info_box">
			<span class="idx"><c:out value="${detail.customerIdx}" /></span>
			<span class="date"><c:out value="${detail.joindate}" /></span>
		</div>
		<div class="grade">고객등급 : <c:out value="${detail.grade}" /> </div>
	</div>
	
	<div style="margin-top: 20px;">
		<button type="button" class="btn btn-sm btn-primary" onClick="fn_detail(${detail.customerIdx})" id="btnUpdate">수정</button>
		<button type="button" class="btn btn-sm btn-primary" onClick="fn_delete(${detail.customerIdx})" id="btnDelete">삭제</button>
		<button type="button" class="btn btn-sm btn-primary"  id="btnList">목록</button>
	</div>
</div>
</section>