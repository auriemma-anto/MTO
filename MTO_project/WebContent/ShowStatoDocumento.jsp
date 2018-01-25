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
<link type="text/css" rel="stylesheet" href="css/common.css">
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
								boolean rejected = false;
								Iterator<?> i = firma.iterator();
								while (i.hasNext()) {
									Firma f = (Firma) i.next();
									if (f.getValore() == false) {
										rejected = true;
					%>

					<p>
						<img alt="Rifiutata" src="img/red-circle.png" width="10px"
							height="10px"> Rifiutata
					</p> <%
 	}

 			}
 			if (firma.size() == 4 && rejected == false) {
 %>
					<p>
						<img alt="Accettata" src="img/green-circle.png" width="10px"
							height="10px"> Accettata
					</p> <%
 	} else if (firma.size() < 4 && rejected == false) {
 %>
					<p>
						<img alt="In Elaborazione" src="img/orange-circle.png"
							width="10px" height="10px"> In elaborazione
					</p> <%
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
				<%
					}
				%>
			</tr>
		</table>
	</div>
</body>
</html>