<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<c:import url="layout/header.jsp" />
<script>
	$(document).on('click', '#btnList', function() {
		document.location.href = "memberList.do"
	})
	
	$(document).on('click', 'a[name="filename"]', function() {
		fn_downloadFile($(this));
	})
	
	function fn_detail(custno) {
		let url = "memberFileDtl.do";
		url = url + "?custno=" + custno + "&mode=edit";
		location.href = url;
	}
	
	function fn_delete(custno,filename) {
		let url = "deleteFileMember.do";
		url = url + "?custno=" + custno + "&fname=" + filename;
		location.href = url;
	}
	
	function fn_fileDelete(filename) {
		let url ="deleteFile.do";
		url = url + "?filename=" + filename;
		location.href = url;
	}
	
	function fn_downloadFile(num) {
		let url = "downloadFile.do";
		url = url + "?num=" + num;
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
		<div class="grade">
			<c:forEach var="file" items="${map}">
				<input type="hidden" id="fileNum" value="${file.NUM}" />
				<a href="javascript:void(0);" onclick="fn_downloadFile(${file.NUM})">${file.ORIGINAL_FILE_NAME}</a>
				(${file.FILE_SIZE}kb)
				<br/>
			</c:forEach>
		</div>
	</div>
	
	<div style="margin-top: 20px;">
		<button type="button" class="btn btn-sm btn-primary" onClick="fn_detail(${detail.custno})" id="btnUpdate">수정</button>
		<button type="button" class="btn btn-sm btn-primary" onClick="fn_delete('${detail.custno}','${detail.fname}')" id="btnDelete">삭제</button>
		<button type="button" class="btn btn-sm btn-primary"  id="btnList">목록</button>
	</div>
</div>
</section>
<c:import url="layout/footer.jsp" />