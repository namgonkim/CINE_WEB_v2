<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="zxx">

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
						<li><a href="#">Research</a></li>
						<li>${category}</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<h1>${category }</h1>
				</div>
				<div class="col-md-2">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="/admin/research/new" class="btn btn-default" class="btn btn-default btn-sm">New</a>
					</sec:authorize>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${ResearchIsEmpty == true }">
		<section class="page-section">
			<div class="container">
				<div class="row">
					<div class="col-md-auto">
						<h4 class="title-section">
							<span class="title-regular">Have Not Researches</span>
						</h4>
						<br> <br> <br>
						<h6>연구 자료를 등록해주세요!</h6>
					</div>
				</div>
			</div>
		</section>
	</c:if>

	<c:if test="${ResearchIsEmpty != true }">
		<c:forEach items="${rechList }" var="research">

			<!-- Left Spotlight-->
			<section class="page-section ">
				<div class="container">
					<div class="row">
						<div class="col-md-5  spotlight-container">
							<h2 class="title-section">
								<span class="title-regular">${research.title }</span>
							</h2>
							<br> <br> <br>
							<p>${research.content }</p>
						</div>
						<div class="col-md-6 col-md-push-1 padding-0">
							<c:if test="${research.imgfileSrc == null}">
								<img class=" img-responsive" src="http://placehold.it/200x200?text=No Image" alt="" />
							</c:if>
							<c:if test="${research.imgfileSrc != null}">
								<img class=" img-responsive" src="/images/${research.imgfileSrc }" alt="" />
							</c:if>
						</div>
					</div>
				</div>
				<br />
				<!-- 정보 수정 혹은 삭제 -->
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<div class="col-md-8"></div>
					<div class="col-md-1">
						<a href="/admin/research/modify/${research.idx}" class="btn btn-primary btn-sm" class="btn btn-default btn-sm">Modify</a>
					</div>
					<div class="col-md-1">
						<form action="/admin/research/delete/${research.idx}" method="post" class="d-inline">
							<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
							<input type="hidden" name="_method" value="delete" />
							<a href="javascript:void(0)" class="btn btn-primary btn-sm" onclick="confirm('Do you want Delete ${research.title } ?')?this.parentElement.submit():null;" class="btn btn-default btn-sm">Delete</a>
						</form>
					</div>
				</sec:authorize>
				
			</section>
		</c:forEach>
	</c:if>



	<!-- footer -->
	<%@include file="fragments/footer.jsp"%>
</body>
</html>