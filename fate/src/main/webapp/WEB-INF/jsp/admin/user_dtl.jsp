<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>

<script>
	let url;
	
	$(document).ready(function() {
		$("#authority").val('${detail.authority}').prop("selected", true);
	})
	
	$(document).on('click', '#btnList', function() {
		document.location.href = "userList.do";
	})

	$(document).on('click', '#btnUpdate', function() {
		
		if(document.frm.password.value.length < 1) {
			alert("비밀번호를 입력해주세요");
			return false;
		} else if(document.frm.userName.value.length < 1) {
			alert("회원명을 입력해주세요");
			return false;
		}
		
		document.frm.action = "updateUser.do";
		document.frm.submit();
	})
	
	$(document).on('click', '#btnDelete', function() {
		
		document.frm.action = "deleteUser.do";
		document.frm.submit();
	})
		
</script>

<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>사용자 정보 수정하기 </strong></font></div>
	<br><br>
	<form name="frm" method="post">
		<input type=hidden name="userId" value="${detail.userId}" >
		<div class="mb-3">
			<label for="userId">아이디 &emsp;</label>
			<font size=5><strong>${detail.userId}</strong></font> 
		</div>
		<div class="mb-3">
			<label for="password">비밀번호</label>
			<input type=text class="form-control" name="password" size=10 placeholder="비밀번호 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="userName">회원명</label>
			<input type=text class="form-control" name="userName" value="${detail.userName}" size=10 placeholder="회원명을 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="authority">권한</label>
			<select class="form-select" id="authority" name="authority" aria-label="권한선택" style="display:block;">
				<c:forEach var="auth" items="${authorityList}">
					<option value="${auth.authority}">${auth.authorityName}</option>
				</c:forEach>
			</select>
		</div>
		<br/>
		<div>
			<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
		</div>
	</form>
</div>

</section>