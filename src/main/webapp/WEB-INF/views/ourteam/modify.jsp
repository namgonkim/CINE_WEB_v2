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
	<%@include file="../fragments/header.jsp"%>
	<!-- Page Header -->
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="breadcrumb">
						<li><a href="/">Home</a></li>
						<li><a href="#">People</a></li>
						<li>OurTeam</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h1>Admin Mode - Modify People</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="page-section">
		<div class="container ">
			<div class="row">
				<h2>Modify</h2>
				<form action="/admin/ourteam/modify/${teamDto.idx}" method="post" enctype="multipart/form-data">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
					<input type="hidden" name="_method" value="put" />
					<input type="hidden" name="idx" value="${teamDto.idx}"/>
					
					<select class="select-box" id="pid" name="pid">
						<option value="0" <c:if test="${teamDto.pid == 0}">selected</c:if>>Ph.D Course</option>
						<option value="1" <c:if test="${teamDto.pid == 1}">selected</c:if>>M.S Course</option>
						<option value="2" <c:if test="${teamDto.pid == 2}">selected</c:if>>Intern</option>
						<option value="3" <c:if test="${teamDto.pid == 3}">selected</c:if>>Alumni</option>
					</select>
					
					<div>
						<label for="name">Name</label>
						<input type="text" id="name" name="name" value="${teamDto.name}">
					</div>
					<div>
						<label for="email">Email</label>
						<input type="text" id="email" name="email" value="${teamDto.email}">
					</div>
					<div>
						<label for="career">Career</label>
						<textarea id="career" name="career" cols="100" rows="6">${teamDto.career}</textarea>
					</div>
					<div>
						<label for="research">Research</label>
						<textarea id="research" name="research" cols="100" rows="6">${teamDto.research}</textarea>
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