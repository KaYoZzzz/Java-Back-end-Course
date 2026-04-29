<%@page import="com.azienda.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<% List <Prodotto> prodotti =  (List<Prodotto>) request.getAttribute("risultatiRicerca");
			if(prodotti.size() == 0){
			%>
			<p>Nessun prodotto trovato</p>
			<%}
				else {
				%>
				<table border="1" width="200px">
					<tr>
						<th>Nome</th>
						<th>Prezzo</th>
					</tr>
					<% for(Prodotto p : prodotti) { %>
					<tr>
						<td><%= p.getNome() %></td>
						<td><%= p.getPrezzo() %></td>
					</tr>
					<% } 
				}%>
				</body>
			</html>