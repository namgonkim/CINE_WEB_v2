<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<title>CINE LAB - ${title}</title>
<%@include file="../fragments/head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="../fragments/header.jsp"%>

	<!-- Page Header -->
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="breadcrumb">
						<li><a href="/">Home</a></li>
						<li><a href="#">Publications</a></li>
						<li>Publication</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h1>Admin Mode - Modify Publications</h1>
				</div>
			</div>
		</div>
	</div>

	<!-- content -->
	<section class="page-section">
		<div class="container ">
			<div class="row">
				<h2>Modify</h2>
				<form class="form" action="/admin/publications/modify/${publDto.idx }" method="post">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
					<input type="hidden" name="_method" value="put" />
					<input type="hidden" name="idx" value="${publDto.idx}"/>
					<div>
						<select class="select-box" id="pid" name="pid">
							<option value="220" <c:if test="${publDto.pid == 220}">selected</c:if>>Jouranal articles</option>
							<option value="221" <c:if test="${publDto.pid == 221}">selected</c:if>>Communications</option>
							<option value="222" <c:if test="${publDto.pid == 222}">selected</c:if>>Patents</option>
						</select>
					</div>
					<div>
						<label for="year">Year</label>
						<input type="text" id="year" name="year" value="${publDto.year }"/>
					</div>
					<div>
						<label for="content">Content</label>
						<textarea id="content" name="content" cols="100" rows="20">${publDto.content }</textarea>
					</div>
					<div>
						<button type="submit">Update</button>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- footer -->
	<%@include file="../fragments/footer.jsp"%>
</body>
</html>