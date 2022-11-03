<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
<style type="text/css">
	table, th, td {
	  border: 1px solid black;
	}
	
	th, td {
	  padding: 10px;
	}
	.center {
		margin-left: auto;
		margin-right: auto;
	}
	
	.margin-top-10px {
	    margin-top: 10px;
	}
</style>
</head>
<body>
<div align="center">
<h1> SEI SICURO DI VOLER ELIMINARE ?</h1>
<form action="ExecuteEliminaAbitanteServlet" method="post">
<table class="center">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Codice Fiscale</th>
				<th>Eta</th>
				<th>Motto Di Vita</th>
			</tr>
		</thead>
		<% Abitante abitanteItem = (Abitante)request.getAttribute("abitanteDaEliminare");%>	
				<tr>
					<td><%=abitanteItem.getIdAbitante()%></td>
					<td><%=abitanteItem.getNome() %></td>
					<td><%=abitanteItem.getCognome() %></td>
					<td><%=abitanteItem.getCodiceFiscale()%></td>
					<td><%=abitanteItem.getEta() %></td>
					<td><%=abitanteItem.getMottoDiVita() %></td>
				</tr>
	</table><br>
<input type="submit" value="conferma">
<input type="hidden" name="idDaInviareComeParametro" value="<%=abitanteItem.getIdAbitante() %>">

</form>
</div>
</body>
</html>