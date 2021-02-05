<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="UTF-8" xmlns:sec="http://www.w3.org/1999/xhtml">

<head>
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta name="_csrf" content="${_csrf.token}" />
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
						<form id="login-form" class="form">
							
								<div class="form-group">
									<input class="form-control" placeholder="email" id="username" name="username" type="text" autofocus="autofocus">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="password" id="password" name="password" type="password" value="">
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<button id="loginBtn" name="loginBtn" class="btn btn-success btn-block">Login</button>
							
						</form>
						
					</div>
					<div class="panel-footer">
						<div class="text-center small mt-4" id="loginMsg" style="color: red"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 로그인 검사 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$("#loginBtn").on("click", function(e) {
			e.preventDefault();
				if ($("#username").val() == "") {
					$('#loginMsg').html('<span style="color: red;">아이디를 입력해 주세요.</span>');
					$("#username").focus();
					return false;
				}
				if ($("#password").val() == "") {
					$('#loginMsg').html('<span style="color: red;">비밀번호를 입력해 주세요.</span>');
					$("#password").focus();
					return false;
				}
				
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");

				$.ajax({
					type : "POST",
	                url: '/loginProcess',
	                dataType: "json",
	                data: {
	                		username	:	$("#username").val(),
	                		password	:	$("#password").val(),
	                },
	                beforeSend: function(xhr){
						xhr.setRequestHeader(header, token);	// 헤드의 csrf meta태그를 읽어 CSRF 토큰 함께 전송
					},
	                error: function(response){
	                	console.log(response);
	                	alert("로그인 실패, 홈페이지 리로딩");
	                },
	                success: function(response) {
	                	if(response.code == "200"){
	                		alert("로그인 성공!");
	                		location.href=response.item.url;
	                	}
	                	else if(response.code == "999") {
	                		$('#loginMsg').html('<span style="color: red;">아이디 혹은 비밀번호가 틀렸습니다.</span>');
	                		
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