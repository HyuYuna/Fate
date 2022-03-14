<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

	let file_count = 1;
	
	$(document).on('click', '#btnList', function(e) {
		document.location.href="productList.do"
	})
	
	function fn_addFile() {
		const str = "<p><input type='file' name='uploadFile_"+(file_count++)+"'><a href='#this' class='btn btn-sm btn-primary' name='delete'>삭제</a></p>";
		$("#fileDiv").append(str);
		$("a[name='delete']").on("click", function(e) {
			fn_deleteFile($(this));
		});
	}
	
	function fn_deleteFile(obj){
		obj.parent().remove();
	}

</script>
<section>
<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>제품 정보 입력하기</strong></font></div>
	<br><br>
	
	<form action="productInsert.do" method="POST" enctype="multipart/form-data">
		<div class="mb-3">
			<label for="pdname">제품명</label>
			<input type=text class="form-control" name=pdname size=10 placeholder="이름을 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="tel">연락처</label>
			<input type=text class="form-control" name=tel size=20 placeholder="번호을 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="address">판매주소</label>
			<input type=text class="form-control" name=address size=40 placeholder="주소를 입력해 주세요">
		</div>
		<div class="mb-3">
			<label for="joindate">등록일자</label>
			<input type=text class="form-control" name=joindate size=10 placeholder="날짜를 입력해 주세요">
		</div>
		<div id="fileDiv" class="mb-3">
			<label for="uploadFile">첨부파일</label> <br/>
			<p>
				<input type="file" name="uploadFile_0" id="uploadFile" >
				<a href="#this" class="btn btn-sm btn-primary" id="delete" name="delete">삭제</a>
 			</p>
		</div>
		<br/>
		<div>
			<button type="button" class="btn btn-sm btn-primary" id="addFile" onclick="fn_addFile();">파일추가</button>
			<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
		</div>
	</form>
</div>
</section>