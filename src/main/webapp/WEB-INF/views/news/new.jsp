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
						<li><a href="#">News</a></li>
						<li>New</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h1>Admin Mode - New News</h1>
				</div>
			</div>
		</div>
	</div>

	<!-- content -->
	<section class="page-section">
		<div class="container">
			<h2 class="title-section">
				<span class="title-regular">New</span>
			</h2>
			<hr class="title-underline" />
			<div class="row">

				<form action="/admin/news/new" class="form" method="post" enctype="multipart/form-data">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					<!-- image upload -->
					<div class="col-md-10">
						<label for="inputFile" class=""><strong>이미지</strong></label>
						<div class="">
							<div class="custom-file" id="inputFile">
								<input name="imgfile" type="file" class="custom-file-input" id="imgfile" accept="image/png, image/jpeg, image/jpg" onchange="InputImage(event);">
								<label class="custom-file-label" for="imgfile">파일을 선택해 주세요.</label>
								<div id="image_container"></div>
							</div>
							<script>
										// 커스텀 이미지 업로드
					                	$(".custom-file-input").on("change", function() {
					                		var fileName = $(this).val().split("\\").pop();
					                		$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
					                	});
					                	
					                	// 이미지 업로드 미리보기
					                	function InputImage(event) {
					                		if(event.target.files && event.target.files[0]) {
					                			var reader = new FileReader();
					                		}
					                		// 미리 볼 수 있도록 해당 위치에 이미지 어트리뷰트 추가
					                		reader.onload = function(event) {
					                			// class="img-thumbnail pull-left" style="width: 600px; height: auto;"
					                			var img = document.createElement("img");
					                			img.setAttribute("class", "img-thumbnail pull-left");
					                			img.setAttribute("src", event.target.result);
					                			img.setAttribute("width", "600px");
					                			img.setAttribute("height", "auto");
					                			
					                			var imgdata = document.querySelector("div#image_container");
					                			var imgdataNode = imgdata.childNodes;
					                			if(imgdataNode.length != 0) imgdataNode[0].remove();
					                			imgdata.appendChild(img);
					                			console.log(imgdata.childNodes[0]);
					                		};
					                		// 이미지 read
					                		reader.readAsDataURL(event.target.files[0]);
					                	}
					                </script>
						</div>

					</div>
					<!-- image upload end -->
					<div>
						<label for="title">Title</label>
						<input type="text" id="title" name="title" value="">
					</div>
					<div>
						<label for="content">Content</label>
						<textarea id="content" name="content" cols="100" rows="20"></textarea>
					</div>
					<div>
						<button type="submit">Submit</button>
					</div>

				</form>
			</div>
		</div>
	</section>


	<!-- footer -->
	<%@include file="../fragments/footer.jsp"%>
</body>
</html>