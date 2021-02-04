<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navigation -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a href="#" onclick="return movehome()">
				<img class="logo" src="/img/logo.png" alt="Logo">
			</a>
		</div>
		<nav class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown active"><a href="#" onclick="return movehome()">Home</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
						People<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#" onclick="return moveprofessor()">Professor</a></li>
						<li><a href="#" onclick="return movephdcourse()">Ph.D Course</a></li>
						<li><a href="#" onclick="return movemscourse()">M.S Course</a></li>
						<li><a href="#" onclick="return moveintern()">Intern</a></li>
						<li><a href="#" onclick="return movealumni()">Alumni</a></li>

					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
						Research<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#" onclick="return moveArea()">Research Area</a></li>
						<li><a href="#" onclick="return moveProject()">Research Project</a></li>
						<li><a href="#" onclick="return moveIndustry()">Industry-academia Project</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
						Publications<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#" onclick="return moveJournal()">Journal Articles</a></li>
						<li><a href="#" onclick="return moveComm()">Communications</a></li>
						<li><a href="#" onclick="return movePatents()">Patents</a></li>
					</ul></li>
				<!--<li><a href="#" onclick="return movelecture()">Publications</a></li>-->
				<li><a href="#" onclick="return movelecture()">Lecture</a></li>
				<li><a href="#" onclick="return movenews()">News</a></li>

				<li><a href="#" onclick="return movecontact()">Contact</a></li>
				<script type="text/javascript">
                      function movecontact(){location.href="/contact";}
                      function movehome(){location.href="/";}
                      function moveprofessor(){location.href="/professor";}
                      function movephdcourse(){location.href="/ourteam?pid=0";}
                      function movemscourse(){location.href="/ourteam?pid=1";}
                      function moveintern(){location.href="/ourteam?pid=2";}
                      function movealumni(){location.href="/ourteam?pid=3";}
                      function movenews(){location.href="/news";}
                      function movelecture(){location.href="/lecture";}
                      function moveJournal(){location.href="/publications?pid=220";}
                      function moveComm(){location.href="/publications?pid=221";}
                      function movePatents(){location.href="/publications?pid=222";}
                      function moveArea(){location.href="/research?pid=110";}
                      function moveProject(){location.href="/research?pid=111";}
                      function moveIndustry(){location.href="/research?pid=112";}
                  </script>
			</ul>
		</nav>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</div>