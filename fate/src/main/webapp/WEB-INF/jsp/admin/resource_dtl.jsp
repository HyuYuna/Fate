<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<section>
<script>
	$(document).ready(function(){
		let mode = '<c:out value="${mode}" />';
		if (mode == 'edit'){
			$("input:hidden[name='resourceIdx']").val('<c:out value="${detail.resourceIdx}" />');
			$("input:hidden[name='mode']").val('<c:out value="${mode}" />');
			$("#resourceName").val('<c:out value="${detail.resourceName}"/>');
			$("#resourcePattern").val('<c:out value="${detail.resourcePattern}"/>');
			$("#sortOrder").val('<c:out value="${detail.sortOrder}"/>');
			$("#authority").val('<c:out value="${detail.authority}"/>');
		}
	});
	
	$(document).on('click', '#btnList', function() {
		document.location.href = "resourceList.do";
	})
	
	$(document).on('click', '#btnDelete', function() {
		document.form.action = "resourceDelete.do";
		document.form.submit();
	})
	
</script>
<div class="container mt-50" role="main">
	<div align="center">
		<c:if test="${mode ne 'edit' }">
			<font size=5><strong>리소스 등록</strong></font>
		</c:if>
		<c:if test="${mode eq 'edit' }">
			<font size=5><strong>리소스 수정하기</strong></font>
		</c:if>
	</div> 
	<br><br>
	<form name="form" id="form" action="resourceSave.do">
		<c:if test="${mode eq 'edit'}">
			<input type="hidden" name="resourceIdx" />
		</c:if>
		<input type="hidden" name="mode" />
		<div class="mb-3">
			<label for="authority">리소스 이름</label>
			<input name="resourceName" id="resourceName" class="form-control" placeholder="이름을 입력해 주세요" />
		</div>
		<div class="mb-3">
			<label for="authorityName">리소스 패턴</label>
			<input name="resourcePattern" id="resourcePattern" class="form-control" placeholder="패턴을 입력해 주세요" />
		</div>
		<div class="mb-3">
			<label for="authorityName">우선 순위</label>
			<input name="sortOrder" id="sortOrder" class="form-control" placeholder="우선순의를 입력해 주세요" />
		</div>
		<div class="mb-3">
			<label for="authority">권한</label>
			<select class="form-select" id="authority" name="authority" aria-label="권한선택" style="display:block;">
				<c:forEach var="auth" items="${authorityList }">
					<option value="${auth.authority }">${auth.authorityName}</option>
				</c:forEach>
			</select>
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