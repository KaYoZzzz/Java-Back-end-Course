<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Ricerca</title>
    </head>
    <body>
    <% String errore = (String) request.getAttribute("chiaveErrore");
    	String message = errore !=null? errore:"";
    %>
    	<p><%= message %> </p>
        <form action="<%= request.getContextPath() + "/ricerca"%>" method="get">
            <label for="nomeProdotto">Nome</label>
            <input type="text" id="nomeProdotto" name="nomeProdotto" required><br>
            <label for="Prezzo">Prezzo</label>
            <input type="number" id="prezzo" name="prezzo" required><br>
            <br>
            <input type="submit" value="Cerca">
        </form>
    </body>
</html>