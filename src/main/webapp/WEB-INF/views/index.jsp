<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zxx" >

<head>
	<title>CINE LAB - ${title}</title>
	<%@include file="fragments/head.jsp"%>
</head>

<body>

	<%@include file="fragments/header.jsp"%>
	
	<!-- Hero Header -->
	<header class="hero-header" style="background-image: url(img/head_image.jpg);">
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in" style="color: black; background-color: rgba( 255, 255, 255, 0.5 );">
					KwangWoon University<br> AI / Machine learning / Healthcare / Wearable Device Laboratory
				</div>
				<div class="intro-heading" style="color: black; background-color: rgba( 255, 255, 255, 0.5 ); ">Computational Intelligence and Networking Laboratory</div>
				
			</div>
		</div>
	</header>

	<!-- BLOG/LATEST NEWS-->
	<section class="page-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="title-section">
						<span class="title-regular">LATEST</span><br />NEWS
					</h2>
					<hr class="title-underline" />
				</div>
			</div>
			<div class="row blog-listing">
				<div class="col-md-4">
					<article>
						<img class="img-thumbnail" src="img/news1.png" alt="" />
						<h2>Article 1</h2>
						<hr class="title-underline">
						<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet...</p>
						<div class="post-meta">
							<span><i class="fa fa-calendar"></i> Aug 17, 2016 - 6:53</span> <span><i class="fa fa-user"></i> By <a href="#">John Doe</a> </span> <span><i class="fa fa-tag"></i> <a href="#">Duis</a>, <a href="#">News</a> </span> <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>
						</div>
						<a href="blog-single-post.html" class="btn btn-xs btn-primary">Read more...</a>
					</article>
				</div>
				<div class="col-md-4">
					<article>
						<img class="img-thumbnail" src="img/news2.png" alt="" />
						<h2>Article 2</h2>
						<hr class="title-underline">
						<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet...</p>
						<div class="post-meta">
							<span><i class="fa fa-calendar"></i> Aug 17, 2016 - 6:53</span> <span><i class="fa fa-user"></i> By <a href="#">John Doe</a> </span> <span><i class="fa fa-tag"></i> <a href="#">Duis</a>, <a href="#">News</a> </span> <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>
						</div>
						<a href="blog-single-post.html" class="btn btn-xs btn-primary">Read more...</a>
					</article>
				</div>
				<div class="col-md-4">
					<article>
						<img class="img-thumbnail" src="img/news3.png" alt="" />
						<h2>Article 3</h2>
						<hr class="title-underline">
						<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet...</p>
						<div class="post-meta">
							<span><i class="fa fa-calendar"></i> Aug 17, 2016 - 6:53</span> <span><i class="fa fa-user"></i> By <a href="#">John Doe</a> </span> <span><i class="fa fa-tag"></i> <a href="#">Duis</a>, <a href="#">News</a> </span> <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>
						</div>
						<a href="blog-single-post.html" class="btn btn-xs btn-primary">Read more...</a>
					</article>
				</div>
			</div>
		</div>
	</section>


	<!-- ALTERNATIVE SECTION -->
	<!-- insert "sec-alternative" class into section tag -->

	<section class="page-section sec-alternative" style="background-image: url(img/odd_background.png)">
		<div class="container">

			<div class="row">
				<div class="col-md-4">
					<h2 class="title-section">
						<span class="title-regular">OUR</span><br />RESEARCH
					</h2>
					<hr class="title-underline" />
				</div>
				<div class="col-md-4 ">
					<div class="col-xs-2 box-icon">
						<div class="fa fa-desktop"></div>
					</div>
					<div class="col-xs-10">
						<h4>AI</h4>
						<h5>Artificial Intelligence</h5>
					</div>
					<div class="col-md-12">
						<p>intelligence demonstrated by machines, unlike the natural intelligence displayed by humans and animals.</p>
					</div>
				</div>
				<div class="col-md-4 ">
					<div class="col-xs-2 box-icon">
						<div class="fa fa-clipboard"></div>
					</div>
					<div class="col-xs-10">
						<h4>NLP</h4>
						<h5>Natural Language Processing</h5>
					</div>
					<div class="col-md-12">
						<p>a subfield of linguistics, computer science, information engineering, and artificial intelligence concerned.</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<div class="col-xs-2 box-icon">
						<div class="fa fa-camera"></div>
					</div>
					<div class="col-xs-10">
						<h4>AI</h4>
						<h5>Artificial Intelligence</h5>
					</div>
					<div class="col-md-12">
						<p>intelligence demonstrated by machines, unlike the natural intelligence displayed by humans and animals.</p>
					</div>
				</div>
				<div class="col-md-4 ">
					<div class="col-xs-2 box-icon">
						<div class="fa fa-pencil"></div>
					</div>
					<div class="col-xs-10">
						<h4>NLP</h4>
						<h5>Natural Language Processing</h5>
					</div>
					<div class="col-xs-12">
						<p>a subfield of linguistics, computer science, information engineering, and artificial intelligence concerned.</p>
					</div>
				</div>
				<div class="col-md-4 ">
					<div class="col-xs-2 box-icon">
						<div class="fa fa-bullseye"></div>
					</div>
					<div class="col-xs-10">
						<h4>AI</h4>
						<h5>Artificial Intelligence</h5>
					</div>
					<div class="col-md-12">
						<p>intelligence demonstrated by machines, unlike the natural intelligence displayed by humans and animals.</p>
					</div>
				</div>
			</div>

		</div>
	</section>

	<%@include file="fragments/footer.jsp"%>

</body>
</html>