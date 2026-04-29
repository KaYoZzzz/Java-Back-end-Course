<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login - Gestione Indirizzi</title>
	<style>
		body { font-family: Arial, sans-serif; background-color: #f4f4f9; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
		.login-container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); width: 300px; text-align: center; }
		.login-container h2 { color: #333; margin-bottom: 20px; }
		.input-group { margin-bottom: 15px; text-align: left; }
		.input-group label { display: block; margin-bottom: 5px; color: #666; }
		.input-group input { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
		.btn-submit { background-color: #007bff; color: white; border: none; padding: 10px; width: 100%; border-radius: 4px; cursor: pointer; font-size: 16px; }
		.btn-submit:hover { background-color: #0056b3; }
		.error { color: #d9534f; margin-bottom: 15px; font-weight: bold; }
		.success { color: #5cb85c; margin-bottom: 15px; font-weight: bold; }
	</style>
</head>
<body>
	<div class="login-container">
		<h2>Accedi</h2>
		
		<c:if test="${not empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
		<c:if test="${not empty successMessage}">
			<div class="success">${successMessage}</div>
		</c:if>
		
		<form action="/loginPage" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div class="input-group">
				<label for="un">Username</label>
				<input type="text" id="un" name="un" required>
			</div>
			<div class="input-group">
				<label for="pwd">Password</label>
				<input type="password" id="pwd" name="pwd" required>
			</div>
			<input type="submit" value="Login" class="btn-submit">
		</form>
	</div>
</body>
</html>