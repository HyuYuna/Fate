<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script>
	
	let url;
	
	$(document).on('click', '#btnList', function() {
		document.location.href = "memberFileList.do"
	})
	
	
	function fn_detail(custno) {
		url = "memberFileDtl.do";
		url = url + "?custno=" + custno;
		location.href = url;
	}
	
	function fn_delete(custno,filename) {
		url = "deleteFileMember.do";
		url = url + "?custno=" + custno + "&fname=" + filename;
		location.href = url;
	}
	
	function fn_fileDelete(filename) {
		url ="deleteFile.do";
		url = url + "?filename=" + filename;
		location.href = url;
	}
	
	function fn_downloadFile(num) {
		//console.log(obj.parent());
	 	//let num = obj.parent().find("#fileNum").val();
		url = "downloadFile.do";
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
			<c:forEach var="file" items="${map}" varStatus="status">
				<input type="hidden" id="fileNum" name="fileNum${status.index}" value="${file.NUM}" />
				<a href="#" onclick="fn_downloadFile('${file.NUM}')" id="fileDown">${file.ORIGINAL_FILE_NAME}</a>
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