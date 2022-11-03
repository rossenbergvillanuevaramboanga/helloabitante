<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dettaglio</title>
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
		<% Abitante abitanteItem = (Abitante)request.getAttribute("abitanteDaInviareAPaginaDettalio");%>
		
				<tr>
					<td><%=abitanteItem.getIdAbitante()%></td>
					<td><%=abitanteItem.getNome() %></td>
					<td><%=abitanteItem.getCognome() %></td>
					<td><%=abitanteItem.getCodiceFiscale()%></td>
					<td><%=abitanteItem.getEta() %></td>
					<td><%=abitanteItem.getMottoDiVita() %></td>
				</tr>
	
	</table>
	<a href="searchForm.jsp" >Torna alla Ricerca</a>
	<a href="allAbitante.jsp" >Mostra tutti gli utenti</a>

</body>
</html>