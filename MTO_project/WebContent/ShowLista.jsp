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
<link type="text/css" rel="stylesheet" href="css/common.css">
</head>
<body>


	<script>
			function showDiv(id) {
				var s = "richiesta"+id;
				var table = document.getElementById(s);
				if(table.getAttribute("hidden") !== "hidden"){
					table.setAttribute("hidden", "hidden");
				}
				else{
					table.removeAttribute("hidden");
				}
			}
		</script>


	<%@ include file="html/_header.html"%>
	<%@ include file="html/_navbar.html"%>
	<h2>Elenco richieste di tirocinio:</h2>
	<div class="container">

		<%
			if (documents != null && documents.size() > 0) {
				int i = 0;
				Iterator<?> it = documents.iterator();
				while (it.hasNext()) {
					i++;
					DocumentoRichiesta docR = (DocumentoRichiesta) it.next();
		%>
		<div>
			<div class="divShowHidden">
				<p style="float: left;">
					Richiesta n°<%=i%>: &emsp; &emsp; &emsp; <input
						class="btnShowHidden" type="button" value="Visualizza/Nascondi"
						onClick="showDiv(<%=docR.getCodiceID()%>)">
				</p>
			</div>

			<table id="richiesta<%=docR.getCodiceID()%>" class="docTable"
				hidden="hidden">
				<tr>
					<th>Informazioni studente:</th>
					<th>Scarica domanda:</th>
				</tr>
				<tr>
					<td style="text-align: center;">Nome: <%=docR.getStudente().getNome()%><br>
						Cognome: <%=docR.getStudente().getCognome()%><br> Università:
						<%=docR.getStudente().getUniversita()%><br> Email: <%=docR.getStudente().getEmail()%><br>
						CFU: <%=docR.getStudente().getCfu()%><br></td>
					<td style="text-align: center;"><a
						href="./downloadServlet?username=<%=docR.getStudente().getUsername()%>&tirocinio=<%=docR.getTirocinio().getCodiceID()%>"
						class="button">Scarica Qui</a></td>

				</tr>
				<tr>
					<th colspan="2">Firma:</th>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><a class="button"
						href="./firmaRichiesta?username=<%=loggedUser.getUsername()%>&firma=true&documento=<%=docR.getCodiceID()%>">Accetta</a>
						&emsp; &emsp; <a class="button"
						href="./firmaRichiesta?username=<%=loggedUser.getUsername()%>&firma=false&documento=<%=docR.getCodiceID()%>">Rifiuta</a></td>
				</tr>
			</table>
		</div>
		<%
			}
			} else {
		%>

		<table class="docTable">
			<tr>
				<td colspan="2">Nessuna richiesta da visualizzare</td>
			</tr>
		</table>

		<%
			}
		%>
	</div>
</body>
</html>