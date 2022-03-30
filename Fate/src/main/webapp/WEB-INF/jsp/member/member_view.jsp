<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<script>
	$(document).on('click', '#btnList', function() {
		document.location.href = "memberList.do"
	})
	
	let url;
	
	function fn_detail(custno) {
		url = "memberDtl.do";
		url = url + "?custno=" + custno + "&mode=edit";
		location.href = url;
	}
	
	function fn_delete(custno) {
		url = "memberDelete.do";
		url = url + "?custno=" + custno;
		location.href = url;
	}
</script>
<section>
<br><br>
<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>회원정보</strong></font></div>
	<br><br>
	
	<div class="bg-white rounded shadow-sm">
		<div class="member_name">
			<c:out value="${detail.custname}" />
		</div>
		<div class="member_info_box">
			<span class="member_num"><c:out value="${detail.custno}" /></span>
			<span class="member_date"><c:out value="${detail.joindate}" /></span>
		</div>
		<div class="grade">고객등급 : <c:out value="${detail.grade}" /> </div>
	</div>
	
	<div style="margin-top: 20px;">
		<button type="button" class="btn btn-sm btn-primary" onClick="fn_detail(${detail.custno})" id="btnUpdate">수정</button>
		<button type="button" class="btn btn-sm btn-primary" onClick="fn_delete(${detail.custno})" id="btnDelete">삭제</button>
		<button type="button" class="btn btn-sm btn-primary"  id="btnList">목록</button>
	</div>
</div>
</section>