<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<title>CINE LAB - Error</title>
<%@include file="../fragments/head.jsp"%>
</head>

<body>
	<%@include file="../fragments/header.jsp"%>
	<h1>${status} error page</h1>
	<div>
		status : <span>${status}</span>
	</div>
	<div>
		path : <span>${path}</span>
	</div>
	<div>
		error : <span>${error}</span>
	</div>
	<div>
		timestamp : <span>${timestamp}</span>
	</div>
	<div>
		message : <span>${message}</span>
	</div>
	<div>
		exception : <span>${exception}</span>
	</div>
	<div>
		trace : <span>${trace}</span>
	</div>
	<%@include file="../fragments/footer.jsp"%>

</body>

</html>