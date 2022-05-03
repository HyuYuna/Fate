<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.2.min.js"></script>
<style>
html {
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: linear-gradient(#141e30, #243b55);
}

.login-box {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 400px;
	padding: 40px;
	transform: translate(-50%, -50%);
	background: rgba(0, 0, 0, .5);
	box-sizing: border-box;
	box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
	border-radius: 10px;
}

.login-box h2 {
	margin: 0 0 30px;
	padding: 0;
	color: #fff;
	text-align: center;
}

.login-box .user-box {
	position: relative;
}

.login-box .user-box input {
	width: 100%;
	padding: 10px 0;
	font-size: 16px;
	color: #fff;
	margin-bottom: 30px;
	border: none;
	border-bottom: 1px solid #fff;
	outline: none;
	background: transparent;
}

.login-box .user-box label {
	position: absolute;
	top: 0;
	left: 0;
	padding: 10px 0;
	font-size: 16px;
	color: #fff;
	pointer-events: none;
	transition: .5s;
}

.login-box .user-box input:focus ~ label, .login-box .user-box input:valid 
	~ label {
	top: -20px;
	left: 0;
	color: #03e9f4;
	font-size: 12px;
}

.login-box form button {
	background: transparent;
	border-color: transparent;
	position: relative;
	display: inline-block;
	padding: 10px 20px;
	color: #03e9f4;
	font-size: 16px;
	text-decoration: none;
	text-transform: uppercase;
	overflow: hidden;
	transition: .5s;
	margin-top: 40px;
	letter-spacing: 4px
}

.login-box button:hover {
	background: #03e9f4;
	color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 5px #03e9f4, 0 0 25px #03e9f4, 0 0 50px #03e9f4, 0 0
		100px #03e9f4;
}

.login-box button span {
	position: absolute;
	display: block;
}

.login-box button span:nth-child(1) {
	top: 0;
	left: -100%;
	width: 100%;
	height: 2px;
	background: linear-gradient(90deg, transparent, #03e9f4);
	animation: btn-anim1 1s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%,100% {
    left: 100%;
  }
}

.login-box button span:nth-child(2) {
	top: -100%;
	right: 0;
	width: 2px;
	height: 100%;
	background: linear-gradient(180deg, transparent, #03e9f4);
	animation: btn-anim2 1s linear infinite;
	animation-delay: .25s
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%,100% {
    top: 100%;
  }
}

.login-box button span:nth-child(3) {
	bottom: 0;
	right: -100%;
	width: 100%;
	height: 2px;
	background: linear-gradient(270deg, transparent, #03e9f4);
	animation: btn-anim3 1s linear infinite;
	animation-delay: .5s
}

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%,100% {
    right: 100%;
  }
}

.login-box button span:nth-child(4) {
	bottom: -100%;
	left: 0;
	width: 2px;
	height: 100%;
	background: linear-gradient(360deg, transparent, #03e9f4);
	animation: btn-anim4 1s linear infinite;
	animation-delay: .75s
}

@keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%,100% {
    bottom: 100%;
  }
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		
		$("#loginBtn").click(function(){
			if($("#loginId").val() == ""){
				alert("로그인 아이디를 입력해주세요");
				$("#loginId").focus();
			} else if($("#loginPwd").val() == "") {
				alert("로그인 비밀번호를 입력해주세요");
				$("#loginPwd").focus();
			} else {
				$("#loginForm").attr("action", "<c:url value="/j_spring_security_check" />")
				$("#loginForm").submit();
			}
		})
		
	});
</script>

</head>

<body>
	<div class="login-box">
		<h2>Login</h2>
		<form name="login" id="loginForm" method="post" action="${pageContext.request.contextPath}/j_spring_security_check">
			<div class="user-box">
				<input type="text" id="loginId" name="id" value="${id}"> <label>UserId</label>
			</div>
			<div class="user-box">
				<input type="password" id="loginPwd" name="pwd" value="${pwd}"> <label>Password</label>
			</div>
			<button type="button" id="loginBtn">
				<span></span> <span></span> <span></span> <span></span> Submit
			</button>
		
			<c:if test="${not empty securityexceptionmsg}">
				<div>
					<font color="red">
						<p>${securityexceptionmsg}</p>
					</font>
				</div>
			</c:if>
			
			<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
		</form>
	</div>

</body>
</html>