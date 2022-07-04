<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
	$(function(){
		fn_showList();
	});
	
	function fn_showList() {
		var paramData = {};

		$.ajax({
			type : "POST" ,
			url : "/admin/getMenuList.do" ,
			dataType : "json" ,
			data : paramData ,
			success : function(result) {
				console.log(result);
				
				if(result.status == "OK") {
					if (result.menuList.length > 0) {
						var list = result.menuList;
						var htmls = "";
						result.menuList.forEach(function(e) {
							htmls += '<tr>';
							htmls += '<td>';
							htmls += '<a href="javascript:void(0)" onClick="fn_menuInfo(' + e.menuIdx + ',\'' + e.menuPattern +'\',\'' + e.menuName + '\', ' + e.sortOrder + ')" >';
							htmls += e.menuPattern;
							htmls += '</a>';
							htmls += '</td>';
							htmls += '<td>' + e.menuName + '</td>';
							htmls += '<td>' + e.sortOrder + '</td>';
							htmls += '</tr>';
						});
					}
				} else {
					console.log("조회 실패");
				}
				
				$("#menuList").html(htmls);
			}
				
		});
	}
	
	$(document).on('click', '#btnSave', function(e) {
		e.preventDefault();
		
		var url = "/admin/insertMenu.do";
		
		if($("#menuIdx").val() != 0) {
			var url = "/admin/updateMenu.do";
		}
		
		var paramData = {
				"menuIdx" : $("#menuIdx").val() ,
				"menuName" : $("#menuName").val() ,
				"menuPattern" : $("#menuPattern").val() ,
				"sortOrder" : $("#sortOrder").val()
		};
		
		$.ajax({
			url : url,
			type : "POST",
			dataType : "json",
			data : paramData,
			success : function(result) {
				fn_showList();
				$("#btnInit").trigger('click');
			}
		});

	});
	
	
	$(document).on('click', '#btnInit', function(e) {
		$("#menuIdx").val('0');
		$("#menuName").val('');
		$("#menuPattern").val('');
		$("#sortOrder").val('');
	})
	
	$(document).on('click', '#btnDelete', function(e) {
		e.preventDefault();
		
		if($("#menuIdx").val() == "") {
			alert("삭제할 코드를 선택해 주세요");
			return;
		}
		
		var url = "/admin/deleteMenu.do";
		
		var paramData = {
				"menuIdx" : $("#menuIdx").val()
		};
		
		$.ajax({
			url : url ,
			type : "POST" ,
			dataType : "json" ,
			data : paramData ,
			success : function(result) {
				fn_showList();
				
				$("#btnInit").trigger('click');
			}
			
		});
	});
	
	function fn_menuInfo(menuIdx, menuPattern, menuName, sortOrder) {
		$("#menuIdx").val(menuIdx);
		$("#menuPattern").val(menuPattern);
		$("#menuName").val(menuName);
		$("#sortOrder").val(sortOrder);
	}
	
</script>

<style>
	tr,td {
		text-align:center;
	}
</style>

<section>
	<br>
	<br>
	<div class="container">
	
		<h4 class="mb-3">Menu Info</h4>
		<div>
			<form:form name="form" id="form" role="form" modelAttribute="menuVO" method="post" action="${pageContext.request.contextPath}/menu/saveMenu">
				<form:hidden path="menuIdx" id="menuIdx"/>
				
				<div class="row">
					<div class="col-md-4 mb-3">
						<label for="code">메뉴 url</label>
						<form:input path="menuPattern" id="menuPattern" class="form-control"  placeholder="" value="" required="" />
						<div class="invalid-feedback">
							Valid Code is required.
						</div>
					</div>
					<div class="col-md-5 mb-3">
						<label for="codename">메뉴 이름</label>
						<form:input path="menuName" class="form-control" id="menuName" placeholder="" value="" required="" />
						<div class="invalid-feedback">
							Valid Code name is required.
						</div>
					</div>
					<div class="col-md-3 mb-3">
						<label for="sort_num">정렬 순서</label>
						<form:input path="sortOrder" class="form-control" id="sortOrder" placeholder="" required="" />
					</div>
				</div>
				
			</form:form>
		</div>
		<!-- Menu form {e} -->
		
		<div>
			<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnInit">초기화</button>
		</div>
		
		<h4 class="mb-3" style="padding-top:15px">Menu List</h4>
		
		<!-- List{s} -->
		<div class="table-responsive">
			<table class="table table-striped table-sm">
				<colgroup>
					<col style="width:15%;" />
					<col style="width:15%;" />
					<col style="width:10%;" />
				</colgroup>
				<thead>
					<tr>
						<th>패턴</th>
						<th>이름</th>
						<th>우선순위</th>
					</tr>
				</thead>
				<tbody id="menuList">
				</tbody>
			</table>
		</div>
		<!-- List{e} -->
		
		
	</div>
</section>