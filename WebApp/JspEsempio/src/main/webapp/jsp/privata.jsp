<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Privata</title>
    </head>
    <body>
    <jsp:include page= "menu.jsp" />
        <h1>Pagina Privata</h1>
        <p>Benvenuto <%=request.getAttribute("chiaveUsername")%> Solo gli utenti autenticati possono vedere questo contenuto.</p>
    </body>
</html>