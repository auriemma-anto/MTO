<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, it.unisa.MTO.common.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O.-Lista Tirocinio</title>

<!--Ultima versione di jQuery (minified) -->
  <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
  <!-- Ultima versione di jquery.validate (minfied) -->
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
  

<link rel="stylesheet" href="css/ric_tirocinio.css" type="text/css" media="all">

</head>

<body>

<%@ include file="header.jsp"%>


	<div class="div_lista">
			<label class="titolo_lista"> Lista Tirocini </label>
		</div>
<form action="ProgettoFormativoServlet" method="post" name="form_dowload">
	<div>
		<input type="submit" name="Dowload" value="Scarica Progetto formativo">
	</div>
</form>
	
<form action="RicercaTirocinioServlet" method="post" name="form_Params">	
	<div class="div_Params">
		<select name="paramType">
			<option value="nomeAzienda">Nome azienda</option>
			<option value="luogo">Luogo</option>
			<option value="data">Data</option>
		</select>
		<input type="text" name="paramText">
		<input type="submit" name="ricerca" value="ricerca">
	</div>
</form>

<section class="container_ricerca">
	
	
	
	<!-- <form action="VisualizzaListaTirocini" method="post"> -->
			<%
				ArrayList<Tirocinio> tirocinio = (ArrayList<Tirocinio>) session.getAttribute("tirocinio");
			    
				if (tirocinio != null) {
					
					for (Tirocinio t : tirocinio) {
			%>
			
		<% 	
     	   int codiceTirocinio = t.getCodiceID(); 
		 %>
   
   
   
   <table class="view_schede">
   
   	<div class="tiro">
   		<label class="titoloT">TIROCINIO</label>
   
		<div class="but_caricaRichiesta">
			<form action="CaricaServlet (DA CAMBIARE)" method="post" name="ADD_Tirocinio" class="carica">
				<input type="hidden" name="codiceTirocinio" value="<%=codiceTirocinio%>">
		  		<input type="submit"class="carica"  value="Carica Richiesta" >
		  	</form>
		</div>
	
 	</div> <!-- END DIV TIRO -->
	 	
	 	
  <!--   <tr><td>codice tirocinio :<%=codiceTirocinio%></td></tr>  -->
   
   
		<tr class="riga"> 
			<th class="tipo">Azienda</th>
			<td class="dato" ><%=t.getAzienda()%></td> 
		</tr>
		
		<tr class="riga">
			<th class="tipo">Data inizio</th>
			<td class="dato"><%=t.getDataInizio()%></td>
		</tr>
		
		<tr class="riga">
			<th class="tipo">Data fine</th>
			<td class="dato"><%=t.getDataFine()%></td>
		</tr>
	
		<tr class="riga">
			<th class="tipo">Sede</th>
			<td class="dato"><%=t.getLuogo()%></td>
		</tr>
		
		<tr class="riga">
			<th class="tipo">Tematica</th>
			<td class="dato"><%=t.getTematica()%></td>
		</tr>
			
		<tr class="riga">
			<th class="tipo">Descrizione</th>
			<td class="dato"><%=t.getDescrizione()%></td>
		</tr>
		
		<!-- 		</form>  -->
	
			<%
				}
				}
			%>
	
	</table>



</section>


</body>
</html>