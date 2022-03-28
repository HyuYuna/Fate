<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/grid/ui.jqgrid.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/grid/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/grid/minified/jquery.jqGrid.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		jQuery("#list").jqGrid({
			url : "/fate/memberListJson.do",
			styleUI : 'Bootstrap' ,
			datatype : "json",
			mtype: 'POST',
			jsonReader: {
		         total : "total" ,
		         records : "records" ,
		         page : "page" ,
	        	 repeatitems : false
		    },
			height : 250,
			colNames : [ '번호', '이름', '주소', '등급', '도시' ],
			colModel : [ 
				{name : 'custno', align : 'right'}, 
				{name : 'custname', align : 'right'}, 
				{name : 'address', align : 'right'}, 
				{name : 'grade', align : 'right'}, 
				{name : 'city', align : 'right',hidden:true, editrules: {edithidden: true}}
			],	
			rowNum:10,
			rowList:[10,20,30],
			pager:'#pager',
			viewrecords : true,
			multiselect : true,
			showpage : true,
		    caption:"회원 관리" ,
		    sortorder : "asc",
		    sortname : "custno"
		});
		jQuery("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false});
	});
	

</script>

<body>
	<div style="margin:8px;">
		<table id="list"></table>
		<div id="pager"></div>
	</div>
</body>
