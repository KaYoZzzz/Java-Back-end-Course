<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Prima jsp</title>
    </head>
    <p>Prima dello Scriptlet</p>

    <body>
        <% String nome="mario" ; System.out.println(nome);
            LocalDate oggi = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataFormattata = oggi.format(formatter);
            System.out.println("La data formattata è: " + dataFormattata);
        %>
    </body>
    <p>Dopo dello Scriptlet</p>
    <% int x=11; if(x<9){ %>
    <p>x è minore di 9</p>
    <% } else { %>
    <p>x è maggiore di 9</p>
    <% } %>
    <div>
        <%= "Il valore di x è: " + x %>
    </div>
    <div>
        <p>Il valore della variabile è  <%= x %></p>
        <%= "La data formattata è: " + dataFormattata %>

    </div>
</html>