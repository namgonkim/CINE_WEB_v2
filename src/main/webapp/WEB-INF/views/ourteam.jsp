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
						<li><a href="/">Home</a></li>
						<li><a href="#">People</a></li>
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
						<a href="/admin/ourteam/new" class="btn btn-default" class="btn btn-default btn-sm">New</a>
					</sec:authorize>
				</div>
			</div>
		</div>
	</div>

	<!-- About -->
	<section class="page-section">
		<div class="container ">
			<div class="row">
				<div class="col-md-12">
					<h2 class="title-section">
						<span class="title-regular">ABOUT</span><br />TEAMS
					</h2>
					<hr class="title-underline" />
				</div>
				<c:if test="${TeamIsEmpty == true}">
					<p>
						Recruiting new team members.<br> 새로운 팀원을 모집합니다.
					</p>
				</c:if>
				<!-- 객체 -->
				<c:if test="${TeamIsEmpty == false }">
					<c:forEach items="${teamlist }" var="team">
						<div class="col-md-8 col-md-push-4">
							<div class="row">
								<div class="col-md-10 ">
									<div class="col-xs-10">
										<h5>경력 사항</h5>
									</div>
									<div class="col-md-10 col-xs-offset-2">
										<p>${team.career }</p>
									</div>
								</div>
								<div class="col-md-10 ">
									<div class="col-xs-10">
										<h5>대외 활동</h5>
									</div>
									<div class="col-md-10 col-xs-offset-2">
										<p>example</p>
									</div>
								</div>
								<div class="col-md-10 ">
									<div class="col-xs-10">
										<h5>연구 분야</h5>
									</div>
									<div class="col-md-10 col-xs-offset-2">
										<p>${team.research }</p>
									</div>
								</div>
								<div class="col-md-10 ">
									<div class="col-xs-10">
										<h5>수상</h5>
									</div>
									<div class="col-md-10 col-xs-offset-2">
										<p>example</p>
									</div>
								</div>

							</div>
						</div>
						<div class="col-md-4 col-md-pull-8 ">
							<div class="row">
								<div class="col-md-10">
									<c:if test='${team.imgfileSrc == ""}'>
										<img class="img-responsive" src="http://placehold.it/560x431?text=NoImage" alt="" />
									</c:if>
									<c:if test='${team.imgfileSrc != ""}'>
									<img class="img-responsive" src="/images/${team.imgfileSrc }" alt="" width="560px" height="431px"/>
									</c:if>
								</div>
								<div class="col-md-10">
									<br />
									<h3>${team.name }</h3>
								</div>
								<div class="col-md-10">
									<h6>
										<a href="mailto:${team.email }"> ${team.email } </a>
										<br />
									</h6>
								</div>
							</div>
						</div>

						<!-- 정보 수정 혹은 삭제 -->
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<div class="col-md-8"></div>
							<div class="col-md-1">
								<a href="/admin/ourteam/modify/${team.idx}" class="btn btn-primary btn-sm" class="btn btn-default btn-sm">Modify</a>
							</div>
							<div class="col-md-1">
								<form action="/admin/ourteam/delete/${team.idx}" method="post" class="d-inline">
									<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
									<input type="hidden" name="_method" value="delete" />
									<a href="javascript:void(0)" class="btn btn-primary btn-sm" onclick="confirm('Do you want Delete ${team.name } ?')?this.parentElement.submit():null;" class="btn btn-default btn-sm">Delete</a>
								</form>
							</div>
						</sec:authorize>

						<!-- divider -->
						<div class="col-md-8 col-md-push-2">
							<br /><hr /><br />
						</div>

					</c:forEach>
				</c:if>
				<!-- 박사 객체 끝-->

			</div>
		</div>
	</section>

	<%@include file="fragments/footer.jsp"%>
</body>
</html>