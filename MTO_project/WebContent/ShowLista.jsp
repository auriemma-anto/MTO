<%@page import="it.unisa.MTO.common.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%
	Collection<?> documents = (Collection<?>) request.getAttribute("documenti");
	if (documents == null) {
		response.sendRedirect("./listaRichieste");
	}
	
	Utente loggedUser = new Utente();
	loggedUser.setUsername((String) request.getSession().getAttribute("loggedUser"));
	
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Domande di Tirocinio - MTO.unisa.it</title>
<link type="text/css" rel="stylesheet" href="css/header.css">
<link type="text/css" rel="stylesheet" href="css/domandaTirocinio.css">
</head>
<body>
	<%@ include file="html/_header.html"%>
	<%@ include file="html/_navbar.html"%>
	<h1>RICHIESTE:</h1>
	<div class="container">
		<h2>Lista Richieste:</h2>

		<table class="docTable">
			<tr>
				<th>Username utente:</th>
				<th>Firma:</th>
				<th>Download:</th>
			</tr>

			<%
				if (documents != null && documents.size() > 0) {
					Iterator<?> it = documents.iterator();
					while (it.hasNext()) {
						DocumentoRichiesta docR = (DocumentoRichiesta) it.next();
			%>

			<tr>
				<td style="text-align: center;"><%=docR.getStudente().getUsername()%></td>
				<td style="text-align: center;"><a class="button"
					href="./firmaRichiesta?username=<%=loggedUser.getUsername()%>&firma=true&documento=<%=docR.getCodiceID()%>">Accetta</a>
					<br> <br> <a class="button"
					href="./firmaRichiesta?username=<%=loggedUser.getUsername()%>&firma=false&documento=<%=docR.getCodiceID()%>">Rifiuta</a></td>
				<td style="text-align: center;"><a
					href="./downloadServlet?username=<%=docR.getStudente().getUsername()%>&tirocinio=<%=docR.getTirocinio().getCodiceID()%>"
					class="button">Scarica Qui</a></td>
			</tr>


			<%
				}
				}
			%>
		</table>


	</div>
</body>
</html>