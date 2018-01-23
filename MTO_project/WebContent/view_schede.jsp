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
   
   <div class="but_el_tir">
	<form action="EliminaListaTirocinioServlet" method="post" name="eliminaTirocinio">
		<input type="hidden" name="codiceID" value="<%=codiceTirocinio%>">
  		<input type="submit" value="Elimina tirocinio" >
  	</form>
	</div>
	
   <tr><td>codice tirocinio :<%=codiceTirocinio%></td></tr>
   
   
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
			<td><%=t.getDescizione()%></td>
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