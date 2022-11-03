<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@page import="it.helloabitante.service.MyServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		
				<th>Nome</th>
				<th>Cognome</th>
				<th>Azione</th>
			</tr>
		</thead>
		<%List<Abitante> abitanti = (List<Abitante>) MyServiceFactory.getAbitanteServiceInstance().elencaTutti();
		for(Abitante abitanteItem : abitanti){
		 %>
		
				<tr>
					<td><%=abitanteItem.getNome() %></td>
					<td><%=abitanteItem.getCognome() %></td>
					<td>
						<a href="ExecuteShowAbitanteServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Dettaglio</a>
						<a href="PrepareDeleteAbitanteServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Elimina</a>
						<a href="PrepareUpdateAbitanteServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Modifica</a>
					</td>
					
				</tr>
			<%} %>
	
	</table>
	<a href="searchForm.jsp" >Torna alla Ricerca</a>

</body>
</html>