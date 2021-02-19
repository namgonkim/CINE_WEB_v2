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
						<li><a href="#">News</a></li>
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
						<a href="/admin/news/new" class="btn btn-default" class="btn btn-default btn-sm">New</a>
					</sec:authorize>
				</div>
			</div>
		</div>
	</div>

	<!-- 4 Column Portfolio Filter -->

	<div class="container">
		<h2 class="title-section">
			<span class="title-regular">${category }</span>
		</h2>
		<hr class="title-underline" />
		<c:if test="${NewsIsEmpty == true }">
			<div class="row">
				<h4>Have no News!</h4>
				<p>뉴스가 존재하지 않습니다.</p>
			</div>
		</c:if>
		<c:if test="${NewsIsEmpty != true }">
			<c:forEach items="${newsList }" var="news">
				<div class="row">
					<div class="post-block post-author clearfix">
						<div class="author-details">
							<c:if test="${news.imgfileSrc == '' }">
								<img src="http://placehold.it/300x300?text=NoImage" class="img-thumbnail pull-left" style="width: 600px; height: auto;">
							</c:if>
							<c:if test="${news.imgfileSrc != '' }">
								<img src="${news.imgfileSrc }" class="img-thumbnail pull-left" style="width: 600px; height: auto;">
							</c:if>
							<p>
								<strong class="name"><a style="font-size: 2em;">${news.title }</a></strong>
							</p>
							<br>
							<p style="font-size: 1.2em;">${new.content }</p>
						</div>
					</div>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="/admin/news/modify/${news.idx }" class="btn btn-default btn-sm">Modify</a>
						<form action="/admin/news/delete/${news.idx }" method="post" class="d-inline">
							<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
							<input type="hidden" name="_method" value="delete" />
							<a href="javascript:void(0)" onclick="confirm('Do you want Delete ${news.title} ?')?this.parentElement.submit():null;" class="btn btn-default btn-sm">Delete</a>
						</form>
					</sec:authorize>
				</div>
				<br>
			</c:forEach>
		</c:if>
	</div>


	<%@include file="fragments/footer.jsp"%>
</body>
</html>