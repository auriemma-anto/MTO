<%@page import="it.unisa.MTO.common.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%
	Collection<?> documents = (Collection<?>) request.getAttribute("documenti");
	if (documents == null) {
		response.sendRedirect("./visualizzaStato");
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stato domande - MTO.unisa.it</title>
<link type="text/css" rel="stylesheet" href="css/header.css">
<link type="text/css" rel="stylesheet" href="css/domandaTirocinio.css">
</head>
<body>

	<%@ include file="html/_header.html"%>
	<%@ include file="html/_navbar.html"%>

	<h2>Visualizza lo stato della tua domanda</h2>
	<div class="container">
		<table class="docTable">
			<tr>
				<th>Codice Documento:</th>
				<th>Nome Documento:</th>
				<th>ID tirocinio:</th>
				<th>Stato:</th>
				<th>Download:</th>
			</tr>

			<%
				if (documents != null && documents.size() > 0) {
					Iterator<?> it = documents.iterator();
					while (it.hasNext()) {
						DocumentoRichiesta docR = (DocumentoRichiesta) it.next();
			%>

			<tr>
				<td style="text-align: center;"><%=docR.getCodiceID()%></td>
				<td style="text-align: center;"><%=docR.getNome()%></td>
				<td style="text-align: center;"><%=docR.getTirocinio().getCodiceID()%></td>
				<td style="text-align: center;">
					<%
						ArrayList<Firma> firma = docR.getFirma();
								if (firma.size() < 4) {
					%>
					<div>
						<img style="float: right;" src="img/orange-circle.png"
							alt="In elaborazione" height="10" width="10">
						<p>In elaborazione</p>
					</div> <%
 	}
 			for (int i = 0; i < firma.size(); i++) {
 				if (firma.get(i).getValore() == false) {
 %>
					<div>
						<img style="float: right;" src="img/red-circle.png"
							alt="Rifiutata" height="10" width="10">
						<p>Rifiutata</p>
					</div> <%
 	} else {
 %>
					<div>
						<img style="float: right;" src="img/green-circle.png"
							alt="In elaborazione" height="10" width="10">
						<p>Accettata</p>
					</div> <%
 	}
 			}
 %>
				</td>
				<td><a
					href="./downloadServlet?username=<%=docR.getStudente().getUsername()%>&tirocinio=<%=docR.getTirocinio().getCodiceID()%>"
					class="button">Scarica Qui</a></td>

				<%
					}
					} else {
				%>

				<td><h2>Nessuna domanda da visualizzare</h2></td>
			</tr>
			<%
				}
			%>

		</table>
	</div>
</body>
</html>