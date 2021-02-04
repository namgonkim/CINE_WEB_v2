<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
						<li>Contact</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h1>Contact</h1>
				</div>
			</div>
		</div>
	</div>

	<!-- Map -->
	<section class="page-section-no-padding">
		<div class="container-fluid ">
			<div class="row ">
				<div class="col-md-12 padding-0 map-page-header">
					<div id="map" class="img-responsive map-style"></div>
				</div>
			</div>
		</div>
	</section>

	<!-- CONTAKT US-->
	<section class="page-section">
		<div class="container">
			<div class="row ">

				<div class="col-md-8">
					<h2 class="title-section">CONTACT US</h2>
					<hr class="title-underline " />
					<p>Maecenas luctus nisi in sem fermentum blat. In nec elit solliudin, elementum, dictum pur quam volutpat suscipit antena.</p>
					<div class="form-group">
						<input type="text" class="form-control" id="usr" placeholder="NAME">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="email" placeholder="EMAIL">
					</div>
					<div class="form-group">
						<textarea class="form-control" rows="5" id="message" placeholder="MESSAGE"></textarea>
					</div>
					<button type="button" class="btn btn-default">
						SEND <i class="fa fa-envelope"></i>
					</button>
				</div>
			</div>
		</div>
	</section>
	<!-- footer -->
	<%@include file="fragments/footer.jsp"%>
</body>
</html>