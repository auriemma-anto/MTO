<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O-Tirocini</title>

<link rel="stylesheet" href="css/view_schede.css" type="text/css" media="all">
</head>
<body>

<%@ include file="header.jsp"%>



<section class="container">

	<button class="accordion"></button>
		<div class="panel">
			non ancora
		</div>
	
	
	<table class="view_schede">
	
	<!--
		<form action="" method="post">
		
	 	
			<%--
				ArrayList<Tirocinio> tirocinio = (ArrayList<Tirocinio>) session.getAttribute("?");
				if (tirocinio != null) {
					for (Tirocinio t : tirocinio) {
			%>
			
		<tr> 
			<th>Azienda</th>
			<td><%=t.getAzienda()%></td> 
		</tr>
		
		<tr>
			<th>Data inizio</th>
			<td><%=t.getDataInizio()%></td>
		</tr>
		
		<tr>
			<th>Data fine</th>
			<td><%=t.getDataFine()%></td>
		</tr>
	
		<tr>
			<th>Sede</th>
			<td><%=t.getLuogo()%></td>
		</tr>
		
		<tr>
			<th>Tematica</th>
			<td><%=t.getTematica()%></td>
		</tr>
			
		<tr>
			<th>Descrizione</th>
			<td><%=t.getDescrizione()--%></td>
		</tr>
		
		
		</form>
	
	 -->
	
	
		<tr> 
			<th>Azienda</th>
			<td>CIao</td> 
		</tr>
		<tr>
			<th>Data inizio</th>
			<td>12/12/1254</td>
		</tr>
		<tr>
			<th>Data fine</th>
			<td>12/12/1254</td>
		</tr>
		<tr>	
			<th>Sede</th>
			<td>BHO</td>
		</tr>
		<tr>
			<th>Tematica</th>
			<td>Mangiare</td>
		</tr>
			
		<tr>
			<th>Descrizione</th>
			<td>Obiettivi: Realizzazione di una App per l'Osservatorio 
			Consumo di Suolo in Campania su multipiattaforma.
			MODALITa' DI SVOLGIMENTO DEL TIROCINIO (Necessità di svolgere il tirocinio in sedi
specifiche) : Frequenza giornaliera presso la sede di Napoli e/o presso il LabGIS
			
			</td>
		</tr>
		
	
	</table>



</section>

</body>
</html>