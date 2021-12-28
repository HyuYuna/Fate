<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="layout/header.jsp" />
<script>
	$(document).on('clock', '#btnList', function(e) {
		document.location.href="memberFileList.do"
	})

	function fileCheck1() {
		if(document.getElementById("uploadFile").value !="") {
			var fileSize = document.getElementById("uploadFile").files[0].size;
			var maxSize = 2 * 1024 * 1024;
			
			if (fileSize > maxSize) {
				alert("첨부파일 사이즈는 " + fileSize + " 2MB 이내로 등록 가능합니다"); 
				return false;
			}
		}
		
		var thumext = document.getElementById("uploadFile").value;
		ths = thumext.indexOf(".");
		console.log(ths);
		thumext = thumext.slice(thumext.indexOf(".") + 1).toLowerCase();
		console.log(thumext);
		if(thumext != "jpg") {
			alert("이미지 파일 jpg만 등록 가능합니다");
			return false;
		}
	}
</script>
<section>
<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>(이미지)회원정보 입력하기</strong></font></div>
	<br><br>
	
	<form action="fileInsert.do" method="POST" enctype="multipart/form-data" onSubmit="return fileCheck1()">
		<div class="mb-3">
			<label for="custname">회원성명</label>
			<input type=text class="form-control" name=custname size=10 placeholder="이름을 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="phone">회원전화</label>
			<input type=text class="form-control" name=phone size=20 placeholder="번호을 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="address">회원주소</label>
			<input type=text class="form-control" name=address size=40 placeholder="주소를 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="joindate">가입일자</label>
			<input type=text class="form-control" name=joindate size=10 placeholder="날짜를 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="grade">고객등급<br>[A:VIP,B:일반,C:직원]</label>
			<input type=text class="form-control" name=grade size=10 placeholder="등급을 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="city">도시코드</label>
			<input type=text class="form-control" name=city size=10 placeholder="코드를 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="uploadFile">사진첨부</label> <br/>
			<input type="file" name="uploadFile" id="uploadFile" size="10">
		</div>
		<br/>
		<div>
			<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
		</div>
	</form>
</div>
</section>
<c:import url="layout/footer.jsp" />