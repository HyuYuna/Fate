<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script>
	
	let url = null;
	let htmls = null;
	let paramData = null;
	let headers = null;
	
	$(document).ready(function(){
		showReplyList();
	});
	
	$(document).on('click', '#btnList', function() {
		document.location.href = "productList.do"
	})
	
	$(document).on('click', '#btnReplySave', function(){
		let replyContent = $("#content").val();
		let replyRegister = $("#register").val();
		
		paramData = JSON.stringify({"content":replyContent, 
							"register":replyRegister, 
							"boardIdx": '${detail.productIdx}'
		});
		
		headers = {"Content-Type" : "application/json"
					, "X-HTTP-Method-Override" : "POST"};
		
		$.ajax({
			type : 'POST',
			url : "insertReply.do",
			headers : headers,
			data : paramData,
			dataType : 'text',
			success: function(result) {
				showReplyList();
				
				$("#content").val('');
				$("#register").val('');
			} , 
			error : function(error) {
				console.log("에러 : " + error);
			}
		});
	});
		
	
	
	function fn_detail(productIdx) {
		url = "productDtl.do";
		url = url + "?productIdx=" + productIdx;
		location.href = url;
	}
	
	function fn_delete(productIdx,filename) {
		url = "deleteProduct.do";
		url = url + "?productIdx=" + productIdx + "&fname=" + filename;
		location.href = url;
	}
	
	function fn_fileDelete(filename) {
		url ="deleteFile.do";
		url = url + "?filename=" + filename;
		location.href = url;
	}
	
	function fn_downloadFile(fileIdx) {
		//console.log(obj.parent());
	 	//let fileIdx = obj.parent().find("#fileIdx").val();
		url = "downloadFile.do";
		url = url + "?fileIdx=" + fileIdx;
		location.href = url;
	}
	
	function showReplyList() {
		url = "getReplyList.do";
		paramData = {"boardIdx" : "${detail.productIdx}"};
		$.ajax({
			type : 'POST',
			url : url,
			data: paramData,
			dataType: 'json',
			success: function(result) {
				htmls = "";
				if(result.length < 1) {
					htmls = "<br>등록된 댓글이 없습니다";
				} else {
					$(result).each(function(){
						htmls += '<div class="media text-muted pt-3" id="reply' + this.replyIdx + '">';
	                    htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
	                    htmls += '<title>Placeholder</title>';
	                    htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
	                    htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
	                    htmls += '</svg>';
	                    htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
	                    htmls += '<span class="d-block">';
	                    htmls += '<strong class="text-gray-dark">' + this.register + '</strong>';
	                    htmls += '<span style="padding-left: 7px; font-size: 9pt">';
	                    htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.replyIdx + ', \'' + this.register + '\', \'' + this.content + '\' )" style="padding-right:5px">수정</a>';
	                    htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.replyIdx + ')" >삭제</a>';
	                    htmls += '</span>';
	                    htmls += '</span>';
	                    htmls += this.content;
	                    htmls += '</p>';
	                    htmls += '</div>';
	                    
				});
					
				}
				$("#replyList").html(htmls);
			}
		});
		
	}
	
	function fn_editReply(replyIdx, register, content) {
		
		htmls = "";
		htmls += '<div class="media text-muted pt-3" id="reply' + replyIdx + '">';
		htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
		htmls += '<title>Placeholder</title>';
		htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
		htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
		htmls += '</svg>';
		htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
		htmls += '<span class="d-block">';
		htmls += '<strong class="text-gray-dark">' + register + '</strong>';
		htmls += '<span style="padding-left: 7px; font-size: 9pt">';
		htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' + replyIdx + ', \'' + register + '\')" style="padding-right:5px">저장</a>';
		htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소</a>';
		htmls += '</span>';
		htmls += '</span>';
		htmls += '<textarea name="editContent'+replyIdx+'" id="editContent'+replyIdx+'" class="form-control" rows="3">';
		htmls += content;
		htmls += '</textarea>';
		
		htmls += '</p>';
		htmls += '</div>';
		
		$('#reply' + replyIdx).replaceWith(htmls);
		$('#editContent').focus();

	}
	
	function fn_updateReply(replyIdx, register) {
		let replyEditContent = $("#editContent"+replyIdx).val();
		
		paramData = JSON.stringify({"content": replyEditContent, "replyIdx":replyIdx});
		headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override": "POST"};
		
		$.ajax({
			url : "updateReply.do" ,
			headers : headers ,
			data : paramData ,
			type : 'POST' ,
			dataType : 'text' ,
			success : function(result) {
				console.log(result);
				showReplyList();
			} ,
			error : function(error) {
				console.log("에러 : " + error);
			}
			
		});
		
	}
	
	function fn_deleteReply(replyIdx) {
		paramData = {"replyIdx": replyIdx};
		
		$.ajax({
			url : "deleteReply.do" ,
			data : paramData ,
			type : 'POST' ,
			dataType : 'text' ,
			success : function(result) {
				showReplyList();
			} , 
			error : function(error) {
				console.log("에러 : " + error);
			} 
		});
	}
	
	
</script>

<section>
<br><br>
<div class="container mt-50" role="main">
	<div align="center"><font size=5><strong>제품정보</strong></font></div>
	<br><br>
	
	<div class="bg-white rounded shadow-sm">
		<div class="name">
			<c:out value="${detail.productName}" />
		</div>
		<div class="info_box">
			<span class="idx"><c:out value="${detail.productIdx}" /></span>
			<span class="date"><c:out value="${detail.joindate}" /></span>
		</div>
		<div class="grade">주소 : <c:out value="${detail.address}" /> </div>	
		<div class="grade">
			<c:forEach var="file" items="${map}" varStatus="status">
				<input type="hidden" id="fileIdx" name="fileIdx${status.index}" value="${file.FILE_IDX}" />
				<a href="#" onclick="fn_downloadFile('${file.FILE_IDX}')" id="fileDown">${file.ORIGINAL_FILE_NAME}</a>
				(${file.FILE_SIZE}kb)
				<br/>
			</c:forEach>
		</div>
	</div>
	
	<div style="margin-top: 20px;">
		<button type="button" class="btn btn-sm btn-primary" onClick="fn_detail(${detail.productIdx})" id="btnUpdate">수정</button>
		<button type="button" class="btn btn-sm btn-primary" onClick="fn_delete('${detail.productIdx}','${detail.fname}')" id="btnDelete">삭제</button>
		<button type="button" class="btn btn-sm btn-primary"  id="btnList">목록</button>
	</div>
	
	<!-- Reply Form -->
	<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
		<form:form name="form" id="form" role="form" modelAttribute="replyVO" method="post">
			<form:hidden path="boardIdx" id="boardIdx" />
			<div class="row">
				<div class="col-sm-10">
					<form:textarea path="content" id="content" class="form-control" rows="3" placeholder="댓글을 입력해주세요" />
				</div>
				<div class="col-sm-2">
					<form:input path="register" class="form-control" id="register" placeholder="댓글 작성자" />
					<button type="button" class="btn btn-sm btn-primary" id="btnReplySave" style="width: 100%; margin-top: 10px"> 저 장 </button>
				</div>
			</div>
		</form:form>
	</div>
	
	<!-- Reply List -->
	<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
		<h6 class="border-bottom pb-2 mb-0">Reply list</h6>
		<div id="replyList"></div>
	</div> 

</div>
</section>