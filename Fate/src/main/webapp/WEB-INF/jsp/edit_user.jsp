<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="layout/header.jsp" />
<section>
<br><br>
<div align="center"><font size=5> 회원 수정하기 </font></div> <br>
<div align="center">
<br><br>
<form action="editUser.do">
	<table border=1 width=600>
		<tr>
			<td  align=center>id </td>
			<td> <input  type=text  name=id size=10></td>
		</tr>
		<tr>
			<td  align=center>pwd </td>
			<td><input  type=pwd  name=pwd  }></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="login" />
			</td>
		</tr>
	</table>
</form>
</div>
</section>
<c:import url="layout/footer.jsp" />