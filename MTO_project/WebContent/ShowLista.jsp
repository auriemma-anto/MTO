<%@page import="it.unisa.MTO.common.DocumentoRichiesta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%
	Collection<?> documents = (Collection<?>) request.getAttribute("documenti");
	if (documents == null) {
		response.sendRedirect("./listaRichieste");
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Lista Documenti Richieste</title>
</head>
<body>

<h1>RICHIESTE:</h1>
	<div>
		<h2>Lista Richieste:</h2>

		<table style="width: 88%;">
			<tr>
				<th>Codice Documento:</th>
				<th>Nome Documento:</th>
				<th>Username utente:</th>
				<th>ID tirocinio:</th>
			</tr>

			<%
			
			if (documents != null && documents.size()>0) {
				Iterator<?> it = documents.iterator();
				while(it.hasNext()){
					DocumentoRichiesta docR = (DocumentoRichiesta) it.next();
						
			%>

			<tr>
				<td style="text-align: center;"><%=docR.getCodiceID()%></td>
				<td style="text-align: center;"><%=docR.getNome()%></td>
				<td style="text-align: center;"><%=docR.getStudente().getUsername()%></td>
				<td style="text-align: center;"><%=docR.getTirocinio().getCodiceID()%></td>
			</tr>


			<%
				}
			}
			%>
		</table>


	</div>
</body>
</html>