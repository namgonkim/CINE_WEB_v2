<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<title>CINE LAB - ${title}</title>
<%@include file="fragments/head.jsp"%>
</head>

<body>
	<%@include file="fragments/header.jsp"%>

	<!-- admin page container -->
	<section class="page-section">
		<div class="container">
			<div class="row ">

				<div class="col-md-8">
					<h2 class="title-section">Admin Page</h2>
					<hr class="title-underline " />
					
					<a href="/admin/settings" class="btn btn-default">Setting</a>
				</div>
			</div>
		</div>
	</section>

</body>
</html>