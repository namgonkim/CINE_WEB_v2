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
						<li><a href="#">Researches</a></li>
						<li>Research</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h1>Admin Mode - Modify Research</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="page-section">
		<div class="container ">
			<div class="row">
				<h2>Modify</h2>
				<form class="form" action="/admin/research/modify/${rechDto.idx }" method="post" enctype="multipart/form-data">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
					<input type="hidden" name="_method" value="put" />
					<input type="hidden" name="idx" value="${rechDto.idx}"/>
					<div class="col-md-10">
						<div>
							<select class="select-box" id="pid" name="pid">
								<option value="110" <c:if test="${rechDto.pid == 110}">selected</c:if>>Research Area</option>
								<option value="111" <c:if test="${rechDto.pid == 111}">selected</c:if>>Research Project</option>
								<option value="112" <c:if test="${rechDto.pid == 112}">selected</c:if>>Industry-academai Project</option>
							</select>
						</div>
						<!--
						<input type="file" name="imgFile" id="imgFile" accept="image/*" />
						 
						<img id="image_section" src="#" alt="" width="300" />
						<div id="img">
							<script> 
			                  function readURL(input){
			                    if(input.files && input.files[0]){
			                      var reader = new FileReader();
			                      reader.onload = function(e){
			                        $('#image_section').attr('src', e.target.result);
			                      }
			                      reader.readAsDataURL(input.files[0]);
			                    }
			                  }
			                  $("#imgFile").change(function(){
			                    readURL(this);
			                  });
			                  </script>
						</div>
						 -->
					</div>
					<div>
						<label for="title">Title</label>
						<input type="text" id="title" name="title" value="${rechDto.title }">
					</div>
					<div>
						<label for="content">Content</label>
						<textarea id="content" name="content" cols="100" rows="20">${rechDto.content }</textarea>
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