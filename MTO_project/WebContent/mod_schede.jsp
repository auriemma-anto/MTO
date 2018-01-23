<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O.-Modifica schede</title>

<link rel="stylesheet" href="css/mod_schede.css" type="text/css" media="all">
</head>
<body>



<div class="contenitore">

  <form action="" method="post">
  
    <div class="row">
      <div class="col-title">
        <label for="azienda">Azienda</label>
      </div>
      <div class="col-insert">
        <input type="text" class="ins_azienda" placeholder="azienda" name="azienda" id="azienda">
      </div>
    </div>
    
     
    <div class="row">
      <div class="col-title">
        <label for="data_inizio">Data inizio</label>
      </div>
      <div class="col-insert">
        <input type="date" class="data_inizio" name="data_inizio" id="data_inizio">
      </daiv>
    </div>
    
     <div class="row">
      <div class="col-title">
        <label for="data_fine">Data Fine</label>
      </div>
      <div class="col-insert">
        <input type="date" class="data_fine" name="data_fine" id="data_fine">
      </div>
    </div>
    
      <div class="row">
      <div class="col-title">
        <label for="luogo">Sede</label>
      </div>
      <div class="col-insert">
        <input type="text" class="luogo" placeholder="Sede" name="luogo" id="luogo">
      </div>
    </div>
    
        <div class="row">
      <div class="col-title">
        <label for="tematica">Tematica</label>
      </div>
      <div class="col-insert">
        <input type="text" class="tematica" placeholder="Tematica" name="tematica" id="tematica">
      </div>
    </div>
    
    <div class="row">
      <div class="col-title">
        <label for="descrizione">Descrizione</label>
      </div>
      <div class="col-insert" id="area_descrizione">
        <textarea id="descrizione" name="descrizione" placeholder="Scrivere la descrizione del tirocinio.."></textarea>
      </div>
    </div>
    <div class="row">
      <input type="submit" value="Modifica">
    </div>
  </form>
</div>




</body>
</html>