<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>
	$(document).on('click', '#btnList', function(e) {
		e.preventDefault();
		
		document.location.href= "memberList.do";
	})
	
</script>
<c:import url="layout/header.jsp" />
<section>
<br><br>
<div class="container" role="main">
	<div align="center"><font size=5> 회원정보 입력하기 </font></div> 
	<br><br><br>

	<form action="insert.do">
		<div class="mb-3">
			<label for="custname">제목</label>
			<input type=text name=custname size=10>
		</div>
		<div class="mb-3">
			<label for="phone">회원전화</label>
			<input type=text name=phone size=20>
		</div>
		<div class="mb-3">
			<label for="address">회원주소</label>
			<input type=text name=address size=40>
		</div>
		<div class="mb-3">
			<label for="joindate">가입일자</label>
			<input type=text name=joindate size=10>
		</div>
		<div class="mb-3">
			<label for="grade">고객등급<br>[A:VIP,B:일반,C:직원]</label>
			<input type=text name=grade size=10>
		</div>
		<div class="mb-3">
			<label for="city">도시코드</label>
			<input type=text name=city size=10>
		</div>
	</form>
	<div>
		<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
		<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
	</div>
</div>
</section>
<c:import url="layout/footer.jsp" />