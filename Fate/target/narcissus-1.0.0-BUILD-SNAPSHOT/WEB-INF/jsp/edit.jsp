<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" />
<section>
<br><br>
<div align="center"><font size=5> 회원정보 수정하기 </font></div> <br>
<div align="center">
<br><br>
<form action="update.do">
	<table border=1 width=600>
		<input type="hidden" name=custno  value=${detail.getCustno() } />
		<tr>
			<td  align=center>회원성명 </td>
			<td> <input  type=text  name=custname  value= ${detail.getCustname() } size=10></td>
		</tr>
		<tr>
			<td  align=center>회원전화 </td>
			<td><input  type=text  name=phone size=20 value= ${detail.getPhone() }></td>
		</tr>
		<tr>
			<td  align=center>회원주소 </td>
			<td><input  type=text  name=address size=40 value= "${detail.getAddress() }"></td>
		</tr>
		<tr>
			<td  align=center>고객등급<br>[A:VIP,B:일반,C:직원] </td>
			<td><input  type=text  name=grade size=10 value= ${detail.getGrade() }></td>
		</tr>
		<tr>
			<td  align=center>도시코드 </td>
			<td><input  type=text  name=city size=10 value= ${detail.getCity() }> </td>
		</tr>
		<tr>
			<td colspan=2  align=center>
				<input  type=submit  value="수정"> &emsp;
				<input  type=reset   value="다시입력">
			</td>
		</tr>
	</table>
</form>
</div>
</section>
<c:import url="footer.jsp" />