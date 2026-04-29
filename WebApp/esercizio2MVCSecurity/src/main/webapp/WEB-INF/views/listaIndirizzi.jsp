<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista indirizzi</title>
</head>
<body>
	<h1>Benvenuto, ${pageContext.request.userPrincipal.name}!</h1>
	<h2>Risultati Ricerca Indirizzi</h2>

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

	<c:if test="${elenco.size() == 0}">
		<p style="color: red;">Attenzione: nessun indirizzo trovato.</p>
	</c:if>

	<br>
	<a href="/indirizzi">Visualizza tutti</a>
	<br/>
	<a href="/goToRicerca">Torna alla ricerca</a>
	<br/>
	<a href="/goToInserisci">Inserisci un nuovo indirizzo</a>
	
	<form action="/logout" method="post" style="margin-top:20px;">
		<!--
		Questo è un input nascosto usato per la protezione CSRF (Cross Site Request Forgery).
		
		Spring Security genera automaticamente:
		- _csrf.parameterName → nome del parametro (di solito "_csrf")
		- _csrf.token → il valore del token di sicurezza
		
		Quando invii il form, questo token viene mandato al server.
		Il server controlla che sia valido prima di accettare la richiesta.
		Se manca o è errato → la richiesta viene bloccata.
		-->
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    	<input type="submit" value="Logout">
	</form>
</body>
</html>