<%String baseUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	String loginUrl = baseUrl + "/jsp/login.jsp";
%>
<p> Menu </p>
<ul>
    <li><a href="<%=loginUrl%>">Login</a></li>
    <li><a href="privata.jsp">Pagina Privata</a></li>
</ul>