<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ricerca</title>
	</head>
	<body>
		<!-- come un request.getAttribute -->
		<form:form action ="/ricercaIndirizzi" method="post" modelAttribute="parametriRicerca">
            citta: <form:input path="citta" />
            via: <form:input path="via" />
            <!-- come un request.setAttribute -->
            <input type="submit" value="ricerca" />

        </form:form>
        <a href= "/goToInserisci">Inserisci un nuovo indirizzo</a>
</body>
</html>