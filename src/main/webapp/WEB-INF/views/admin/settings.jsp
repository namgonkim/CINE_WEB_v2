<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<title>CINE LAB - ${title}</title>
<%@include file="../fragments/head.jsp"%>
</head>

<body>
	<%@include file="../fragments/header.jsp"%>

	<!-- content -->
	<section class="page-section">
		<div class="container ">
			<div class="row">
				<h2>Modify</h2>
				<form class="form" action="/admin/settings" method="post">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					<input type="hidden" name="_method" value="put" />
					<input type="hidden" name="id" value="" />
					<div>
						<label for="email">Email</label>
						<input type="email" id="email" name="email"
						value='<sec:authentication property="principal.username"/>'>
					</div>
					<div>
						<label for="password">Password</label>
						<input type="password" id="password" name="password">
					</div>
					<div>
						<button type="submit">Update</button>
					</div>
				</form>
			</div>
		</div>
	</section>


</body>
</html>