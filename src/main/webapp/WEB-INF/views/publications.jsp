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
						<li><a href="#">Publications</a></li>
						<li>${category }</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10">
					<h1>${category }</h1>
				</div>
				<div class="col-md-2">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="/admin/publications/new" class="btn btn-default" class="btn btn-default btn-sm">New</a>
					</sec:authorize>
				</div>
			</div>
		</div>
	</div>


	<!-- Right Sidebar Container  -->
	<section class="page-section padding-30">
		<div class="container">
			<div class="row">
				<!-- Content -->
				<div class="col-md-9">
					<div class="blog-listing">
						<div class="col-md-6">
							<h2 class="title-section">
								<span class="title-regular">${category }</span>
							</h2>
							<hr class="title-underline" />
						</div>
						<c:if test="${PublicationsIsEmpty == true }">
							<div class="col-md-6"></div>
							<br />
							<h5>Have Not ${category }</h5>
							
						</c:if>
						<c:if test="${PublicationsIsEmpty != true }">
							<c:forEach items="${publList }" var="publications">
								<div class="col-md-6">
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<a href="/admin/publications/modify/${publications.idx} " class="btn btn-default btn-sm">Modify</a>
										<form action="/admin/publications/delete/${publications.idx}" method="post" class="d-inline">
											<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
											<input type="hidden" name="_method" value="delete" />
											<a href="javascript:void(0)" onclick="confirm('Do you want Delete ${publications.idx} ?')?this.parentElement.submit():null;" class="btn btn-default btn-sm">Delete</a>
										</form>
									</sec:authorize>
								</div>
								<article>
									<br />
									<h3>${publications.year }</h3>
									<blockquote style="white-space: pre-wrap">${publications.content }</blockquote>
								</article>
							</c:forEach>
						</c:if>


					</div>
				</div>


			</div>
		</div>
	</section>
	<!-- footer -->
	<%@include file="fragments/footer.jsp"%>
</body>
</html>