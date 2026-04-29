<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste</title>
</head>
<body>

<c:if test="${chiaveLista.size()>0 }">
	<table border = "1" width ="150px">
	<tr>
		<th>nome</th>
		<th>cognome</th>
	</tr> 
		<c:forEach var="persona" items="${chiaveLista}">
			<tr>
			<td>${persona.nome}</td>
			<td>${persona.cognome}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${chiaveLista.size()==0 }">
<h2>nulla</h2>
</c:if>
</body>
</html>