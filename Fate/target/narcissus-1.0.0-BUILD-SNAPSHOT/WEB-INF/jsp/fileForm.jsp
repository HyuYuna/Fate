<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="layout/header.jsp" />
<script>
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
<br><br>
<div align="center"><font size=5> 회원정보 입력하기 </font></div> <br>
<div align="center">
<br><br>
<form action="fileInsert.do" method="POST" enctype="multipart/form-data" onSubmit="return fileCheck1()">
	<table border=1 width=600>
		<tr>
			<td align=center>회원성명</td>
			<td><input type=text name=custname size=10></td>
		</tr>
		<tr>
			<td align=center>회원전화</td>
			<td><input type=text name=phone size=20></td>
		</tr>
		<tr>
			<td align=center>회원주소</td>
			<td><input type=text name=address size=40></td>
		</tr>
		<tr>
			<td align=center>가입일자</td>
			<td><input type=text name=joindate size=10></td>
		</tr>
		<tr>
			<td align=center>고객등급<br>[A:VIP,B:일반,C:직원]</td>
			<td><input type=text name=grade size=10></td>
		</tr>
		<tr>
			<td align=center>도시코드</td>
			<td><input type=text name=city size=10></td>
		</tr>
		<tr>
			<td align="center">사진첨부</td>
			<td><input type="file" name="uploadFile" id="uploadFile" size="10"></td>
		</tr>
		<tr>
			<td colspan=2  align=center>
				<input type=submit value="등록"> &emsp; 
				<input type=button value="조회">
			</td>
		</tr>
	</table>
</form>
</div>
</section>
<c:import url="layout/footer.jsp" />