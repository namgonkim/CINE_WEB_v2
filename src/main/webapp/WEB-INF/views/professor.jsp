<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<li>Professor</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h1>Professor</h1>
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
						<span class="title-regular">ABOUT</span><br />PROFESSOR
					</h2>
					<hr class="title-underline" />
				</div>
				<div class="col-md-8 col-md-push-4">
					<div class="row">
						<div class="col-md-10 ">
							<div class="col-xs-10">
								<h5>경력 사항</h5>
							</div>
							<div class="col-md-10 col-xs-offset-2">
								<p>
									1985년 9월 ~ 1987년 8월 University of Michigan, Ann Arbor(학사) <br /> 1987년 9월 ~ 1989년 6월 시라큐스대학교 전산학 석사 <br /> 1990년 1월 ~ 1993년 12월 시라큐스대학교 전산학 박사 <br /> 1994년 3월 ~ 1996년 2월 (주) 삼성전자 멀티미디어연구소 선임 연구원 <br /> 1996년 3월 ~ 현재 광운대학교 컴퓨터공학과 교수 <br />
								</p>
							</div>
						</div>
						<div class="col-md-10 ">
							<div class="col-xs-10">
								<h5>대외 활동</h5>
							</div>
							<div class="col-md-10 col-xs-offset-2">
								<p>
									한국통신학회(KICS) 상임이사(2014~현재)<br /> ICT Express 저널 Associate Editor(2014~현재)<br /> International Conference on Information Networking, 공동위원장(2014)<br /> 한국정보과학회 정보통신소사이어티 회장(2013)<br /> 한국ITS학회 상임이사(2012~현재)<br /> 한국ITS학회 논문지편집장(2012~2013)<br /> 한국통신학회 정보통신지 편집장(2012)<br /> KRNet 컨퍼런스 및 전시회 프로그램위원장(2011~2012)<br /> 지식경제부 국가기술로드맵 작성위원(2012)<br /> 한국미래인터넷표준포럼 운영이사(2010~2011)<br /> 한국정보과학회 논문지 편집위원(2005~2006)<br /> 한국정보처리학회 논문지 편집위원(2001)<br />
								</p>
							</div>
						</div>
						<div class="col-md-10 ">
							<div class="col-xs-10">
								<h5>연구 분야</h5>
							</div>
							<div class="col-md-10 col-xs-offset-2">
								<p>
									인공지능, 생체영감 네트워킹, 머신러닝, IoT<br /> 유무선네트워킹, Software Defined Networking, 차량간통신<br />
								</p>
							</div>
						</div>
						<div class="col-md-10 ">
							<div class="col-xs-10">
								<h5>수상</h5>
							</div>
							<div class="col-md-10 col-xs-offset-2">
								<p>
									우수 논문상 수상, 지능형 교통 시스템 학회 학술 대회(2005, 2010)<br />
								</p>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-4 col-md-pull-8 ">
					<div class="row">
						<div class="col-md-10">
							<img class="img-responsive" src="http://placehold.it/365x376" alt="" />
						</div>
						<div class="col-md-10">
							<br />
							<h3>Lee H J</h3>
						</div>
						<div class="col-md-10">
							<h6>
								<a href="mailto:hlee@kw.ac.kr">hlee@kw.ac.kr</a>
								<br />
							</h6>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>

	<%@include file="fragments/footer.jsp"%>
</body>
</html>