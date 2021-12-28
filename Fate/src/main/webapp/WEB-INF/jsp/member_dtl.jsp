<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<c:import url="layout/header.jsp" />
<section>
<script>
	$(document).ready(function(){
		var mode = '<c:out value="${mode}" />';
		if (mode == 'edit'){
			$("input:hidden[name='custno']").val(<c:out value="${detail.custno}" />);
			$("input:hidden[name='mode']").val('<c:out value="${mode}" />');
			$("#custname").val('<c:out value="${detail.custname}"/>');
			$("#phone").val('<c:out value="${detail.phone}"/>');
			$("#address").val('<c:out value="${detail.address}"/>');
			$("#joindate").val('<c:out value="${detail.joindate}"/>');
			$("#grade").val('<c:out value="${detail.grade}"/>');
			$("#city").val('<c:out value="${detail.city}"/>');
		}
	});
</script>
<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>회원정보 수정하기</strong></font></div> <br>
	<br><br>
	<form:form name="form" id="form" role="form" modelAttribute="memberVO" action="save.do">
		<form:hidden path="custno" />
		<input type="hidden" name="mode" />
		<div class="mb-3">
			<label for="custname">제목</label>
			<form:input path="custname" id="custname" class="form-control" placeholder="제목을 입력해 주세요" />

		</div>
		<div class="mb-3">
			<label for="phone">회원전화</label>
			<form:input path="phone" class="form-control" placeholder="번호을 입력해 주세요" />
		</div>
		<div class="mb-3">
			<label for="address">회원주소</label>
			<form:input path="address" id="address" class="form-control" placeholder="주소를 입력해 주세요" />
		</div>
		<div class="mb-3">
			<label for="joindate">가입일자</label>
			<form:input path="joindate" id="joindate" class="form-control" placeholder="날짜를 입력해 주세요" />
		</div>
		<div class="mb-3">
			<label for="grade">고객등급<br>[A:VIP,B:일반,C:직원]</label>
			<form:input path="grade" id="grade" class="form-control" placeholder="등급을 입력해 주세요" />
		</div>
		<div class="mb-3">
			<label for="city">도시코드</label>
			<form:input path="city" id="city" class="form-control" placeholder="코드를 입력해 주세요" />
		</div>
		<br/>
		<div>
			<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
			<button type="button" class="btn btn-sm btn-primary" onClick="location.href='memberList.do'" id="btnList">목록</button>
			<button type="reset" class="btn btn-sm btn-primary" value="다시 입력">초기화</button>
		</div>
	</form:form>
	</div>
</section>
<c:import url="layout/footer.jsp" />