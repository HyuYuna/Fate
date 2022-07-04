<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<section>
<script>
	$(document).ready(function(){
		let mode = '<c:out value="${mode}" />';
		if (mode == 'edit'){
			$("input:hidden[name='authorityIdx']").val('<c:out value="${detail.authorityIdx}" />');
			$("input:hidden[name='mode']").val('<c:out value="${mode}" />');
			$("#authorityName").val('<c:out value="${detail.authorityName}"/>');
			$("#authority").val('<c:out value="${detail.authority}"/>');
		}
	});
	
	$(document).on('click', '#btnList', function() {
		document.location.href = "authorityList.do";
	})
	
	$(document).on('click', '#btnDelete', function() {
		document.form.action = "authorityDelete.do";
		document.form.submit();
	})
	
</script>
<div class="container mt-50" role="main">
	<div align="center">
		<c:if test="${mode ne 'edit' }">
			<font size=5><strong>권한 등록</strong></font>
		</c:if>
		<c:if test="${mode eq 'edit' }">
			<font size=5><strong>권한 수정하기</strong></font>
		</c:if>
	</div> 
	<br><br>
	<form name="form" id="form" action="authoritySave.do">
		<c:if test="${mode eq 'edit'}">
			<input type="hidden" name="authorityIdx" />
		</c:if>
		<input type="hidden" name="mode" />
		<div class="mb-3">
			<label for="authority">권한코드</label>
			<input name="authority" id="authority" class="form-control" placeholder="번호을 입력해 주세요" />
		</div>
		<div class="mb-3">
			<label for="authorityName">권한이름</label>
			<input name="authorityName" id="authorityName" class="form-control" placeholder="제목을 입력해 주세요" />
		</div>
		<br/>
		<div>
			<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
			<button type="button" id="btnList" class="btn btn-sm btn-primary">목록</button>
			<button type="reset" class="btn btn-sm btn-primary" value="다시 입력">초기화</button>
			<c:if test="${mode eq 'edit'}">
				<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
			</c:if>
		</div>
	</form>
</div>
</section>