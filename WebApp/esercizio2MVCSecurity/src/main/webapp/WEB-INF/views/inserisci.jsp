<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Inserisci nuovo indirizzo</title>
    </head>
    <body>
    	<h1>Benvenuto, ${pageContext.request.userPrincipal.name}!</h1>
        <form:form action="/inserisciIndirizzo" method="post" modelAttribute="nuovoIndirizzo">
            citta: <form:input path="citta" />
            via: <form:input path="via" />
            civico: <form:input path="civico" />
            <input type="submit" value="inserisci" />
        </form:form>
        <a href="/goToRicerca">Effettua una ricerca</a>
    </body>
</html>