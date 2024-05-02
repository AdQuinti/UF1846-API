<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
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
	<!--  codigo  -->
		<h3 style="text-align:center">PÁGINA LOGIN</h3>

				<form:form action="${pageContext.request.contextPath}/autenticacionUsuario" method="POST">
					<!--  codigo  -->
						<c:if test="${param.error != null}">
							<strong class="formatoError">usuario o contraseña incorrecta, inténtelo otra vez</strong>
						</c:if>
						<c:if test="${param.logout != null}">
							<strong class="formatologut">Has cerrado sesión logut</strong>
						</c:if>
					<!--  FIN codigo  -->
					<div class="login-form">
						<div class="group">
							<label for="pass" class="label">Usuario:</label>
							<input type="text" name="username" id="user" class="input"/>
						</div>
						<div class="group">
							<label for="pass" class="label">Contraseña:</label>
							<input type="password" name="password" id="user" class="input"/>
						</div>
						<div class="group">
			<!--  boton  --><input class="button" type="submit" value="Login"/> 
						</div>
				<div class="hr"></div>
					</div>
				</form:form>
			<!--  FIN codigo  -->

		</div>
	</div>
</body>
</html>