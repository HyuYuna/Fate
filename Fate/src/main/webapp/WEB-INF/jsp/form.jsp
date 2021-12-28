<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="layout/header.jsp" />
<section>
<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>회원정보 입력하기</strong></font></div> 
	<br><br>

	<form action="save.do">
		<input type="hidden" name="mode" />
		<div class="mb-3">
			<label for="custname">제목</label>
			<input type=text class="form-control" name=custname size=10 placeholder="제목을 입력해 주세요">
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
		<br/>
		<div>
			<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
			<button type="button" class="btn btn-sm btn-primary" onClick="location.href='memberList.do'" id="btnList">목록</button>
			<button type="reset" class="btn btn-sm btn-primary" value="다시 입력">초기화</button>
		</div>
	</form>
</div>
</section>
<c:import url="layout/footer.jsp" />