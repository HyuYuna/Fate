<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="layout/header.jsp" />
<section>
<script>
	$(document).on('click', '#delete', function(e) {
		fn_deleteFile($(this));
	})
	
	$(document).ready(function(){
		$("input:hidden[name='custno']").val('<c:out value="${detail.custno}" />');
		$("input:hidden[name='mode']").val('<c:out value="${mode}" />');
		$("#custname").val('<c:out value="${detail.custname}"/>');
		$("#phone").val('<c:out value="${detail.phone}"/>');
		$("#address").val('<c:out value="${detail.address}"/>');
		$("#joindate").val('<c:out value="${detail.joindate}"/>');
		$("#grade").val('<c:out value="${detail.grade}"/>');
		$("#city").val('<c:out value="${detail.city}"/>');
	});
	
	var file_count = "${fn:length(map)+1}";
	
	function fn_addFile() {
		var str = "<p><input type='file' id='uploadFile_"+(file_count)+"' name='uploadFile_"+(file_count)+"'><a href='#this' class='btn btn-sm btn-primary' id='delete' name='delete_"+(file_count)+"'>삭제</a></p>";
		$("#fileDiv").append(str);
		$("#delete_"+(file_count++)).on("click", function(e) {
			fn_deleteFile($(this));
		});
		console.log(file_count);
	}
	
	function fn_deleteFile(obj) {
		obj.parent().remove();
	}
	
	
</script>
<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>회원정보 수정하기</strong></font></div> <br>
	<br><br>
	<form action="fileUpdate.do" method="POST" id="form" enctype="multipart/form-data">
		<input type="hidden" name="custno" />
		<input type="hidden" name="mode" />
		<div class="mb-3">
			<label for="custname">회원성명</label>
			<input type=text class="form-control" name=custname id=custname size=10 placeholder="이름을 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="phone">회원전화</label>
			<input type=text class="form-control" name=phone id=phone size=20 placeholder="번호을 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="address">회원주소</label>
			<input type=text class="form-control" name=address id=address size=40 placeholder="주소를 입력해 주세요">
		</div>
			<div class="mb-3">
			<label for="joindate">가입일자</label>
			<input type=text class="form-control" name=joindate id=joindate size=10 placeholder="날짜를 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="grade">고객등급<br>[A:VIP,B:일반,C:직원]</label>
			<input type=text class="form-control" name=grade id=grade size=10 placeholder="등급을 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="city">도시코드</label>
			<input type=text class="form-control" name=city id=city size=10 placeholder="코드를 입력해 주세요">
		</div>
		<div id="fileDiv" class="mb-3">
			<label for="uploadFile">첨부파일</label> <br/>
			<c:forEach var="row" items="${map}" varStatus="var">
				<p>
					<input type="hidden" name="num_${var.index}" id="num" value="${row.NUM}" >
					<a href="#this" id="name_${var.index}" name="name_${var.index}">${row.ORIGINAL_FILE_NAME}</a>
					<input name="uploadfile_${var.index}" type="file" id="uploadFile_${var.index}" >
					(${row.FILE_SIZE}kb)
					<button type="button" class="btn btn-sm btn-primary" id="delete" name="delete_${var.index}">삭제</button>
				</p>
			</c:forEach>
		</div>
		<br/>
		<div>
			<button type="button" class="btn btn-sm btn-primary" id="addFile" onclick="fn_addFile();">파일추가</button>
			<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
			<button type="button" class="btn btn-sm btn-primary" onClick="location.href='memberList.do'" id="btnList">목록</button>
			<button type="reset" class="btn btn-sm btn-primary" value="다시 입력">초기화</button>
		</div>
	</form>
	</div>
</section>
<c:import url="layout/footer.jsp" />