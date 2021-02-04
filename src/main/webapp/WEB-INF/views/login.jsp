<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="UTF-8" xmlns:sec="http://www.w3.org/1999/xhtml">

<head>
<title>CINE LAB - ${title}</title>
<%@include file="fragments/head.jsp"%>
</head>

<body>
	<%@include file="fragments/header.jsp"%>

	<!-- Page Header -->
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li>Login</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h1>Login</h1>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
		
			<div class="col-md-4 col-md-offset-4">
			<h2>관리자 접속</h2>
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Login</h3>
					</div>
					<div class="panel-body">
						<form id="login-form"class="form" method="post">
							<fieldset>
								<input type="hidden" id="token" data-token-name="${_csrf.headerName}" placeholder="Password" value="${_csrf.token}">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<div class="form-group">
									<input class="form-control" placeholder="email" id="username" name="username" type="text" autofocus="autofocus">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="password" id="password" name="password" type="password" value="">
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<button id="loginBtn" name="loginBtn" class="btn btn-success btn-block">Login</button>
							</fieldset>
						</form>
						<div class="text-center small mt-2" id="loginMsg" style="color: red"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 로그인 검사 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$("#loginBtn").on("click", function() {
				if ($("#username").val() == "") {
					alert("아이디를 입력해주세요.");
					$("#username").focus();
					return false;
				}
				if ($("#password").val() == "") {
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
				}
				
				$.ajax({
					type : "POST",
	                url: '/user/login',
	                dataType: "json",
	                data: {
	                		username	:	$("#username").val(),
	                		password	:	$("#password").val()
	                },
	                beforeSend	:	function(xhr) {
	                	//이거 안하면 403 error
						//데이터를 전송하기 전에 헤더에 csrf값을 설정한다
						var $token = $("#token");
						xhr.setRequestHeader($token.data("token-name"), $token.val());
	                },
	                error: function(response, status, data){
	                	console.log(response);
	                	alert("로그인 실패, 홈페이지 리로딩");
	                },
	                success: function(response, status, data) {
	                	if(response.code == "200"){
	                		alert("로그인 성공!");
	                		location.href=response.item.url;
	                	}
	                	else if(response.code == "999") {
	                		alert(response.message);
	                		$('#loginMsg').html('<span style="color: red;">비밀번호가 틀렸습니다.</span>');
	                    }
	                }
				})
				
			});
		})
	</script>
	

	<hr />
	<%@include file="fragments/footer.jsp"%>

</body>

</html>