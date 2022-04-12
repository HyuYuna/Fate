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
			url : "/fate/customerListJson.do",
			styleUI : 'Bootstrap',
			datatype : "json",
			contentType: "application/json; charset=UTF-8",
			mtype: 'POST',
			jsonReader: {
		         total : "total" ,
		         records : "records" ,
		         page : "page" ,
	        	 repeatitems : true
		    },
			height : 250,
			colNames : [ '번호', '이름', '주소', '등급', '도시' ],
			colModel : [ 
				{name : 'customerIdx', align : 'right', key:true},
				{name : 'customerName', align : 'right', editable:true, edittype:"text"},
				{name : 'address', align : 'right', editable:true, edittype:"text"},
				{name : 'grade', align : 'right', editable:true, edittype:"text"},
				{name : 'city', align : 'right',hidden:true, editrules: {edithidden: true}}
			],	
			rowNum:10,
			rowList:[10,20,30],
			pager:'#pager',
			viewrecords : true,
			multiselect : true,
			showpage : true,
		    caption:"고객 관리" ,
		    sortorder : "asc",
		    sortname : "customer_idx",	
		    sortable : true,
		    emptyRecords : "데이터가 없습니다",
		    editurl : "/fate/editCustomerGrid.do"
		});
		jQuery("#list").jqGrid(
			'navGrid',
			'#pager',
			{closeAfterEdit: true, reloadAfterSubmit: true},
            {closeAfterAdd: true, reloadAfterSubmit: true},
            {reloadAfterSubmit: true}
		);
	});


</script>

<body>
	<div style="margin:8px;">
		<table id="list"></table>
		<div id="pager"></div>
	</div>
</body>
