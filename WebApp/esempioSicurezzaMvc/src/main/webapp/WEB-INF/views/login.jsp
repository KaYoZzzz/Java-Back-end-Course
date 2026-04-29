<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> LOGIN </title>
	</head>
	<body>
	
		<p> ${errorMessage} </p>
	
		<form action="loginPage" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				Username <input type="text" name="un">
				<br>
				Password <input type="password" name="pwd">
				<br>
				<input type="submit" value="login">
				
		</form>
	</body>
</html>