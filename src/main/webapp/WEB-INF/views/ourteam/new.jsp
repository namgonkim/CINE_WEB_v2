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
					<h1>Admin Mode - New People</h1>
				</div>
			</div>
		</div>
	</div>

	<form action="/admin/ourteam/new" class="form" method="post" enctype="multipart/form-data">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
		<section class="page-section">
			<div class="container ">
				<div class="row">
					<h2>New</h2>

					<!-- 박사 객체 -->
					<div class="col-md-8 col-md-push-4">
						<div class="row">
							<div class="col-md-10">
								<div class="col-xs-10">
									<h5>People</h5>
								</div>
								<select class="select-box" id="pid" name="pid">
									<option value="default">-----------------</option>
									<option value="0">Ph.D Course</option>
									<option value="1">M.S Course</option>
									<option value="2">Intern</option>
									<option value="3">Alumni</option>
								</select>
							</div>
							<div class="col-md-10 ">
								<div class="col-xs-10">
									<h5>Career</h5>
								</div>
								<textarea id="career" name="career" cols="100" rows="6"></textarea>
							</div>
							<div class="col-md-10 ">
								<div class="col-xs-10">
									<h5>Research</h5>
								</div>
								<textarea id="research" name="research" cols="100" rows="6"></textarea>
							</div>
							<div class="col-md-10 ">
								<div style="float: right">
									<button type="submit" class="btn btn-success">Submit</button>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-md-pull-8 ">
						<div class="row">

							<div class="col-md-10">
								<br /> <label for="name"><strong>이름</strong></label>
								<input type="text" id="name" name="name" value="" placeholder="Name">
								<br />
							</div>
							<div class="col-md-10">
								<label for="email"><strong>이메일</strong></label>
								<input type="text" id="email" name="email" value="" placeholder="Email">
							</div>

							<!-- image upload -->
							<div class="col-md-10">
								<label for="inputFile" class=""><strong>이미지</strong></label>
								<div class="">
									<div class="custom-file" id="inputFile">
										<input name="imgfile" type="file" class="custom-file-input" id="imgfile" accept="image/png, image/jpeg, image/jpg">
										<label class="custom-file-label" for="imgfile">파일을 선택해 주세요.</label>
									</div>
									<script>
					                	$(".custom-file-input").on("change", function() {
					                		var fileName = $(this).val().split("\\").pop();
					                		$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
					                	});
					                </script>
								</div>

							</div>
							<!-- image upload end -->

						</div>
						<!-- 박사 객체 끝-->

					</div>
				</div>
			</div>
		</section>
	</form>

	<!-- footer -->
	<%@include file="../fragments/footer.jsp"%>
</body>
</html>