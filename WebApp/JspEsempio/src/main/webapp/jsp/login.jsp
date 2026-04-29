<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>login</title>
    </head>
    <body>
    <jsp:include page= "menu.jsp" />
        <% String error = (String) request.getAttribute("CHIAVE_CREDENZIALI_ERRATE");
            String message = error != null? error : "";
        %>
        <h2>Login</h2>
        <div style="color: red;">
            <%= message%>
        </div>
        <form action="<%= request.getContextPath() + "/login"%>" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>