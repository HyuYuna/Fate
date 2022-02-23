<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="layout/header.jsp" />
<script>
	function fn_view(custno) {
		var url = "memberView.do";
		url = url + "?custno=" + custno;
		location.href = url;
	}
	
	function fn_prev(page, range, rangeSize) {
	    var page = ((range - 2) * rangeSize) + 1;
	    var range = range - 1;
		
	    var url = "${pageContext.request.contextPath}/memberList.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
	function fn_pageination(page, range, rangeSize, searchType, keyword) {
		var url = "${pageContext.request.contextPath}/memberList.do";
	 	url = url + "?page=" + page;
	 	url = url + "&range=" + range;
	 	
	 	location.href = url;
	}
	
	function fn_next(page, range, rangeSize) {
		var page = parseInt(range * rangeSize) + 1;
		var range = parseInt(range) + 1;
		
		var url = "${pageContext.request.contextPath}/memberList.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
</script>
<section>
	<br>
	<br>
	<div align="center">
	<font size=5><strong>회원 목록</strong></font>
		<div class="container mt-50">
			<div class="table-responsive">
			<table  class="table table-striped table-sm">
				<tr>
					<td>회원번호</td>
					<td>회원성명</td>
					<td>전화번호</td>
					<td>주소</td>
					<td>가입일자</td>
					<td>고객등급</td>
					<td>거주지역</td>
				</tr>
				<c:forEach items="${list}" var="m">
					<tr>
						<td>${m.getCustno()}</td>
						<td><a href="#" onClick="fn_view(${m.getCustno()})">${m.getCustname()}</a></td>
						<td>${m.getPhone()}</td>
						<td>${m.getAddress()}</td>
						<td>${m.getJoindate()}</td>
						<td>${m.getGrade()}</td>
						<td>${m.getCity()}</td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
		
		<form action="memberList.do" style="margin-bottom:5px;">
			<select name="ch1">
				<option value="custno">번호</option>
				<option value="name">이름</option>
			</select>
			<input type="text" name="ch2">
			<button type="submit" class="btn btn-primary">검색하기</button>
		</form>
		
		<div id ="paginationBox" style="display:inline-block;">
			<ul class="pagination">
				<c:if test="${vo.prev}">
					<li class="page-item">
						<a class="page-link" href="#" onclick="fn_prev('${vo.page}','${vo.range}','${vo.rangeSize}')">Previous</a>
					</li>
				</c:if>
				
				<c:forEach begin="${vo.startPage}" end="${vo.endPage}" var="idx">
					<a class="page-link" href="#" onclick="fn_pageination(${idx},'${vo.range}','${vo.rangeSize}')">${idx}</a>
				</c:forEach>
				
				<c:if test="${vo.next}">
					<li class="page-item">
						<a class="page-link" href="#" onClick="fn_next('${vo.page}', '${vo.range}', '${vo.rangeSize}')">Next</a>
					</li>
				</c:if>
			</ul>
		</div>

	</div>
</section>
<c:import url="layout/footer.jsp" />