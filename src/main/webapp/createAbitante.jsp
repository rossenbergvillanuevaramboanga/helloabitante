<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crea un nuovo abitante</title>
</head>
<body>

<form action="ExecuteCreaAbitanteServlet" method="post">
		<h3>Crea un nuovo abitante</h3>
		<label>Nome</label><br>
		<input type="text" name="nome"><br>
		<label>Cognome</label><br>
		<input type="text" name="cognome"><br>
		<label>Codice Fiscale</label><br>
		<input type="text" name="codicefiscale"><br>
		<label>Età</label><br>
		<input type="number" name="eta"><br>
		<label>Motto di Vita</label><br>
		<input type="text" name="mottodivita"><br>
		
		<input type="submit" value="Crea">
</form>
	<% if(request.getAttribute("messaggioErrore") != null){%>
	<p style="color: red;"><%=request.getAttribute("messaggioErrore") %></p>
	<%}; %>
		
	<a href="searchForm.jsp" >Torna alla Ricerca</a>
	
</body>
</html>