<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Errore</title>
    </head>
    <body>
    <jsp:include page= "menu.jsp" />
        <%
            String error = (String) request.getAttribute("CHIAVE_ERRORE");
            String message = error != null? error : "";
        %>
        <h1>Errore : <%= message%></h1>
    </body>
</html>