<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- tags para la configuración de roles de usuario -->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inicio</title>
<!--  HOJA ESTILO https://bootsnipp.com/snippets/0ekvA-->
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link href="<c:url value='/css/style.css' />" rel="stylesheet">
<!--  HOJA ESTILO -->
</head>
<body>
	<div class="login-wrap">
		<div class="login-html">
				<h1>Hola,</h1>
				<h3>VamoBien :)</h3>
			<div class="hr"></div>
			<h4 for="pass" class="label">Usuario: 
				<strong><security:authentication property="principal.username"/></strong></h4>
			<h4 for="pass" class="label">Rol: 
			<strong><security:authentication property="principal.authorities"/></strong></h4>
			<!-- link para administradores -->
			<security:authorize access="hasRole('administrador')">
				<h5>
					<a href="${pageContext.request.contextPath}/administradores">Zona de Administradores</a>
				</h5>
			</security:authorize>
			
			
			<!-- link para profesores -->
			<security:authorize access="hasRole('profesor')">
			<h5>
			<a href="${pageContext.request.contextPath}/profesores">Zona de Profesores</a>
			</h5>
			</security:authorize>
			
			<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout">
			</form:form>
		</div>
	</div>
</body>
</html>