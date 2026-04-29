<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Ricerca</title>
    </head>
    <body>											<!-- come un request.getAttribute -->
        <form:form action ="/ricerca" method="post" modelAttribute="chiaveForm">
            nome: <form:input path="nome" />
            cognome: <form:input path="cognome" />
            <!-- come un request.setAttribute -->
            <input type="submit" value="ricerca" />

        </form:form>

    </body>
</html>