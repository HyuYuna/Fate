<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>회원 정보 입력하기</strong></font></div>
	<br><br>
	<form action="join.do" method="post" onsubmit="join();">
		<div class="mb-3">
			<label for="userId">아이디</label>
			<input type=text class="form-control" id="userId" name="userId" size=10 placeholder="아이디을 입력해 주세요">
			<button type="button" onClick="javascript:idCheck();">중복확인</button>
		</div>
		<div class="mb-3">
			<label for="password">비밀번호</label>
			<input type=text class="form-control" name="password" size=10 placeholder="비밀번호 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="userName">회원명</label>
			<input type=text class="form-control" name="userName" size=10 placeholder="회원명을 입력해 주세요">
		</div>
		<div>
			<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
		</div>
	</form>
</div>
</section>

<script>
	let idChk = "N";
	let url;

	function join() {
		
		if(idChk != "Y") {
			alert("ID 중복확인을 해주세요");
			return false;
		}
		
		return true;
		
	}
	
	function idCheck() {
		
		let userId = $("#userId").val();
		
		if(userId == null || userId == '') {
			alert("아이디를 입력해주세요");
			return false;
		} 
		
		$.ajax({
			type : 'POST' ,
			url : "idCheck.do" ,
			data : {"id" : userId } ,
			dataType : 'text' ,
			success : function(result) {
				if(result == 0) {
					alert("사용할 수 있는 아이디입니다");
					idChk = "Y";
					$("#signId").attr("readonly", true);
				} else {
					alert("중복된 아이디입니다");
				}
			} , 
			error : function(error) {
				console.log("에러 : " + error);				
			}
		});
		
	}
	
</script>