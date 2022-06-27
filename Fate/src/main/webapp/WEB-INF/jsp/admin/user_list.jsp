<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

	let url;

 	$(document).ready(function(){
 		const searchType = "${vo.searchType}";
 		if(searchType != "" || searchType == null){
 			$('select[name=searchType]').val('${vo.searchType}').prop("selected",true);
 		}
 	});
 	
 	$(document).on('click','#btnReg', function() {
 		document.location.href = "userJoin.do"
 	});

	function fn_detail(userId) {
		url = "userDtl.do";
		url = url + "?userId=" + userId;
		location.href = url;
	}
	
	function fn_prev(page, range, rangeSize, searchType, keyword) {
	    var page = ((range - 2) * rangeSize) + 1;
	    var range = range - 1;
		
	    url = "${pageContext.request.contextPath}/userList.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&searchType=" + searchType;
	 	url = url + "&keyword=" + keyword; 
		
		location.href = url;
	}
	
	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		url = "${pageContext.request.contextPath}/userList.do";
	 	url = url + "?page=" + page;
	 	url = url + "&range=" + range;
	 	url = url + "&searchType=" + searchType;
	 	url = url + "&keyword=" + keyword; 
	 	
	 	location.href = url;
	}
	
	function fn_next(page, range, rangeSize, searchType, keyword) {
		var page = parseInt(range * rangeSize) + 1;
		var range = parseInt(range) + 1;
		
		url = "${pageContext.request.contextPath}/userList.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&searchType=" + searchType;
	 	url = url + "&keyword=" + keyword; 
		
		location.href = url;
	}
	
</script>
<section>
	<br>
	<br>
	<div align="center">
	<font size=5><strong>사용자 목록</strong></font>
		<div class="container">
			<button type="button" id="btnReg" class="btn btn-sm btn-primary" style="float:right;">등록</button>
		</div>
		<div class="container mt-50">
			<div class="table-responsive">
			<table  class="table table-striped table-sm">
				<tr>
					<td>번호</td>
					<td>회원ID</td>
					<td>회원이름</td>
					<td>권한</td>
				</tr>
				<c:forEach items="${list}" var="m">
					<tr>
						<td>${m.getRnum()}</td>
						<td><a href="#" onClick="fn_detail('${m.getUserId()}')">${m.getUserId()}</a></td>
						<td>${m.getUserName()}</td>
						<td>${m.getAuthorityName()}</td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
		
		<form action="userList.do" style="margin-bottom:5px;">
			<select name="searchType">
				<option value="userId">아이디</option>
				<option value="userName">이름</option>
			</select>
			<input type="text" name="keyword" value="${vo.keyword}">
			<button type="submit" class="btn btn-primary">검색하기</button>
		</form>
		
		<div id ="paginationBox" style="display:inline-block;">
			<ul class="pagination">
				<c:if test="${vo.prev}">
					<li class="page-item">
						<a class="page-link" href="#" onclick="fn_prev('${vo.page}','${vo.range}','${vo.rangeSize}', '${vo.searchType}', '${vo.keyword}')">Previous</a>
					</li>
				</c:if>
				
				<c:forEach begin="${vo.startPage}" end="${vo.endPage}" var="idx">
					<li class="page-item <c:out value="${vo.page == idx ? 'active' : '' } " /> ">
						<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${vo.range}', '${vo.rangeSize}', '${vo.searchType}', '${vo.keyword}')"> ${idx} </a>
					</li>
				</c:forEach>
				
				<c:if test="${vo.next}">
					<li class="page-item">
						<a class="page-link" href="#" onClick="fn_next('${vo.page}', '${vo.range}', '${vo.rangeSize}', '${vo.searchType}', '${vo.keyword}')">Next</a>
					</li>
				</c:if>
			</ul>
		</div>

	</div>
</section>