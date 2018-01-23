<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O.-Aggiungi Tirocinio</title>
</head>
<body>

<%@ include file="header.jsp"%>


<div class="container">
  <form action="AggiungiTirocinioServlet" method="post">
   
   <%
      String username1 = (String) session.getAttribute("username");
    %>
    <div class="row">
      <div class="col-name">
        <label for="azienda">Azienda</label>
      </div>
      <div class="col-input">
        <input type="text" id="azienda" name="azienda" placeholder="Inserire il nome dell'azienda.">
      </div>
    </div>
    
     <div class="row">
      <div class="col-name">
        <label for="data_inizio">Data inizio</label>
      </div>
      <div class="col-input">
        <input type="date" id="data_inizio" name="data_inizio" >
      </div>
    </div>
    
      <div class="row">
      <div class="col-name">
        <label for="data_fine">Data fine</label>
      </div>
      <div class="col-input">
        <input type="date" id="data_fine" name="data_fine" >
      </div>
    </div>
    
     <div class="row">
      <div class="col-name">
        <label for="luogo">Sede</label>
      </div>
      <div class="col-input">
        <input type="text" id="luogo" name="luogo" placeholder="Inserire la sede dove si svolgera' il tirocinio.">
      </div>
    </div>
    
    <div class="row">
      <div class="col-name">
        <label for="tematica">Tematica</label>
      </div>
      <div class="col-input">
        <input type="text" id="tematica" name="tematica" placeholder="Inserire la tematica del tirocinio.">
      </div>
    </div>
    
    <div class="row">
      <div class="col-name">
        <label for="descrizione">Descrizione</label>
      </div>
      <div class="col-input">
        <textarea id="descrizione" name="descrizione" placeholder="Inserire una descrizione del tirocinio. [Max 150 caratteri.]" ></textarea>
      </div>
    </div>
    <div class="row">
      <input type="submit" value="Submit">
    </div>
  </form>
</div>


</body>
</html>