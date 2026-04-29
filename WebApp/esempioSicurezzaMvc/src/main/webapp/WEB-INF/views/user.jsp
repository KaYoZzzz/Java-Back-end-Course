<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user</title>
	</head>
	<body>
		BENVENUTO USER
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div>DIV SOLO PER GLI ADMIN</div>
		</sec:authorize>
		
		<form action="/logout" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="submit" value="Logout">
		</form>
		
	</body>
</html>