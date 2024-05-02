<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- CSS -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administradores</title>
<!--  HOJA ESTILO -->
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link href="<c:url value='/css/style.css' />" rel="stylesheet">
<!--  HOJA ESTILO -->
</head>
<body>
	<div class="login-wrap">
		<div class="login-html">
			<h2 style=" text-align:center">ZONA DE ADMINISTRADORES</h2>
		<div class="hr"></div>
			<h5 style=" text-align:center">
				<a href="${pageContext.request.contextPath}/">Volver a Inicio</a>
			</h5>
		</div>
	</div>
</body>
</html>