<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>

<form action="ExecuteUpdateAbitanteServlet" method="post">
<% Abitante abitante = (Abitante)request.getAttribute("abitanteDaModificare");%>
		<h3>Crea un nuovo abitante</h3>
		<input type="hidden" name="id" value="<%=abitante.getIdAbitante()%>">
		<label>Nome</label><br>
		<input type="text" name="nome" value="<%=abitante.getNome()%>"><br>
		<label>Cognome</label><br>
		<input type="text" name="cognome" value="<%=abitante.getCognome()%>"><br>
		<label>Codice Fiscale</label><br>
		<input type="text" name="codicefiscale" value="<%=abitante.getCodiceFiscale()%>"><br>
		<label>Età</label><br>
		<input type="number" name="eta" value="<%=abitante.getEta()%>"><br>
		<label>Motto di Vita</label><br>
		<input type="text" name="mottodivita" value="<%=abitante.getMottoDiVita()%>"><br>
		<input type="submit" value="Crea">
</form>
<% if(request.getAttribute("messaggioErrore") != null){%>
	<p style="color: red;"><%=request.getAttribute("messaggioErrore") %></p>
	<%}; %>

</body>
</html>