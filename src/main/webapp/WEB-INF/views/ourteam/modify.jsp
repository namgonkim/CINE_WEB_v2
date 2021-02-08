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
						<li>${category }</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h1>${category }</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="page-section">
		<div class="container ">
			<div class="row">
				<form action="/admin/ourteam/modify/${teamDto.idx}" method="post" enctype="multipart/form-data">
					<div class="col-md-12">
						<h2 class="title-section">
							<span class="title-regular">UPDATE</span><br />TEAMS
						</h2>
						<hr class="title-underline" />
					</div>
					<div class="col-md-8 col-md-push-4">
						<div class="row">
							<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
							<input type="hidden" name="_method" value="put" />
							<input type="hidden" name="idx" value="${teamDto.idx}" />
							<div class="col-md-10">
								<div class="pull-right">
									<select class="select-box" id="pid" name="pid">
										<option value="0" <c:if test="${teamDto.pid == 0}">selected</c:if>>Ph.D Course</option>
										<option value="1" <c:if test="${teamDto.pid == 1}">selected</c:if>>M.S Course</option>
										<option value="2" <c:if test="${teamDto.pid == 2}">selected</c:if>>Intern</option>
										<option value="3" <c:if test="${teamDto.pid == 3}">selected</c:if>>Alumni</option>
									</select>
								</div>
							</div>
							<div class="col-md-10 ">

								<div class="col-xs-10">
									<h5>경력 사항</h5>
									<textarea id="career" name="career" cols="100" rows="6">${teamDto.career}</textarea>
								</div>
								<div class="col-md-10 col-xs-offset-2">
									<p></p>
								</div>
							</div>
							<div class="col-md-10 ">
								<div class="col-xs-10">
									<h5>대외 활동</h5>
								</div>
								<div class="col-md-10 col-xs-offset-2">
									<p></p>
								</div>
							</div>
							<div class="col-md-10 ">
								<div class="col-xs-10">
									<h5>연구 분야</h5>
									<textarea id="research" name="research" cols="100" rows="6">${teamDto.research}</textarea>
								</div>
								<div class="col-md-10 col-xs-offset-2">
									<p></p>
								</div>
							</div>
							<div class="col-md-10 ">
								<div class="col-xs-10">
									<h5>수상</h5>
								</div>
								<div class="col-md-10 col-xs-offset-2">
									<p></p>
								</div>
								
							</div>
							<div class="col-md-10">
								<div class="pull-right">
									<button type="submit" class="btn btn-default">Update</button>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-md-pull-8 ">
						<div class="row">
							<!-- 560 431 -->
							<!-- image upload -->
							<div class="col-md-10">
								<label for="inputFile" class=""><strong>이미지</strong></label>
								<div class="">
									<div class="custom-file" id="inputFile">
										<input name="imgfile" type="file" class="custom-file-input" id="imgfile" accept="image/png, image/jpeg, image/jpg" onchange="InputImage(event);">
										<label class="custom-file-label" for="imgfile">파일을 선택해 주세요.</label>
										<div id="image_container">
											<c:if test="${teamDto.imgfileSrc != null}">
												<img class="img-responsive" src="/images/${teamDto.imgfileSrc }" width="560px" height="431px" />
											</c:if>
											
										</div>
										<div id="image_delete">
											<button type="button" class="btn btn-dark btn-sm" onclick="Image_delete();">삭제하기</button>
											<script>
												function Image_delete() {
													var imgdata = document.querySelector("div#image_container");
													for(var i=0;i<imgdata.childNodes.length;i++){
														imgdata.removeChild(imgdata.childNodes[i]);
													}
												}
											</script>
										</div>
										<br>
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
					                			
					                			var img = document.createElement("img");
					                			img.setAttribute("class", "img-responsive");
					                			img.setAttribute("src", event.target.result);
					                			img.setAttribute("width", "560px");
					                			img.setAttribute("height", "431px");
					                			
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
							<div class="col-md-10">
								<label for="name">Name</label>
								<input type="text" id="name" name="name" value="${teamDto.name}">
							</div>
							<div class="col-md-10">
								<label for="email"><span>Email</span></label>
								<input type="text" id="email" name="email" value="${teamDto.email}">
							</div>
						</div>
					</div>

				</form>
			</div>
		</div>
	</section>
	<!-- footer -->
	<%@include file="../fragments/footer.jsp"%>
</body>
</html>