<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*, it.unisa.MTO.common.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O-Tirocini</title>

<link rel="stylesheet" href="css/view_schede.css" type="text/css" media="all">

</head>
<body>

<%@ include file="header.jsp"%>


<section class="aggiunta">
	<buttom class="butt_ADD"><a href="aggiungiTirocinio.jsp">Aggiunti Tirocinio</a></buttom>

	</section>


<section class="container">
	
	
	
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
   		
  
		
   
   <div class="but_el_tir">
	<form action="EliminaListaTirocinioServlet" method="post" name="ADD_Tirocinio" class="delet">
		<input type="hidden" name="codiceTirocinio" value="<%=codiceTirocinio%>">
  		<input type="submit"class="delet"  value="Elimina tirocinio" >
  	</form>
	</div>
	
	<div class="modifica">
	  <form name="modif" action="mod_schede.jsp" class="modify">
		<input type="hidden" name="codiceTirocinio" value="<%=codiceTirocinio%>">
		<input type="submit" name="Submit" class="modify" value="Modifica tirocinio">
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