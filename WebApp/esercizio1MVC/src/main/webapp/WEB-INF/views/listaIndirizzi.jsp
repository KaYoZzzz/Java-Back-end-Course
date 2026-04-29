<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista indirizzi</title>
</head>
<body>
	<h2>Risultati Ricerca Indirizzi</h2>

	<%-- Caso 1: La lista contiene elementi --%>
	<c:if test="${elenco.size() > 0}">
		<table border="1">
			<tr>
				<th>Città</th>
				<th>Via</th>
				<th>Civico</th>
			</tr>
			<c:forEach var="ind" items="${elenco}">
				<tr>
					<td>${ind.citta}</td>
					<td>${ind.via}</td>
					<td>${ind.civico}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<%-- Caso 2: La lista è vuota --%>
	<c:if test="${elenco.size() == 0}">
		<p style="color: red;">Attenzione: nessun indirizzo trovato.</p>
	</c:if>

	<br>
	<a href="/indirizzi">Visualizza tutti</a>
</body>
</html>