<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ricerca</title>
	</head>
	<body>
		<h1>Benvenuto, ${pageContext.request.userPrincipal.name}!</h1>
		<form:form action="/ricercaIndirizzi" method="post" modelAttribute="parametriRicerca">
            citta: <form:input path="citta" />
            via: <form:input path="via" />
            <input type="submit" value="ricerca" />
        </form:form>
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