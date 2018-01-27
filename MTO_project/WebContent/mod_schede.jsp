<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	 <%@ page import="java.util.*, it.unisa.MTO.common.*, it.unisa.MTO.businessLogic.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O.-Modifica schede</title>

<link rel="stylesheet" href="css/mod_schede.css" type="text/css"
	media="all">
</head>
<body>



	<div class="contenitore">


	

		<form action="ModificaTirocinioServlet" method="post">
		
		
	<%

	int codiceTirocinio = Integer.parseInt(request.getParameter("codiceTirocinio"));
	System.out.println("Hidden field Value :"+codiceTirocinio);
	
	Facade facade = new Facade();
	Tirocinio tir = new Tirocinio();
	tir = facade.getTirocinio(codiceTirocinio);
	
	//String codice_id = (String) session.getAttribute("codice_id"); 
	
	String azienda = tir.getAzienda();
	String dataInizio = tir.getDataInizio();
	String dataFine = tir.getDataFine();
	String luogo = tir.getLuogo();
	String tematica = tir.getTematica();
	String descrizione = tir.getDescrizione();
	
	System.out.println("descr :"+descrizione);
	
	System.out.println("dataInizio :"+dataInizio);
	
%>
		<input type="hidden" name="codiceTirocinio" value="<%=codiceTirocinio%>">
		
			<div class="row">
				<div class="col-title">
					<label for="azienda">Azienda</label>
				</div>
				<div class="col-insert">
					<input type="text" class="ins_azienda" name="azienda" id="azienda"
						value="<%=azienda %>">
				</div>
			</div>


			<div class="row">
				<div class="col-title">
					<label for="dataInizio">Data inizio</label>
				</div>
				<div class="col-insert">
					<input type="date" class="dataInizio" name="dataInizio"
						id="dataInizio" value="<%=dataInizio %>">
				</div>
			</div>

			<div class="row">
				<div class="col-title">
					<label for="dataFine">Data Fine</label>
				</div>
				<div class="col-insert">
					<input type="date" class="dataFine" name="dataFine" id="dataFine"
						value="<%=dataFine %>">
				</div>
			</div>

			<div class="row">
				<div class="col-title">
					<label for="luogo">Sede</label>
				</div>
				<div class="col-insert">
					<input type="text" class="luogo" placeholder="Sede" name="luogo"
						id="luogo" value="<%=luogo %>">
				</div>
			</div>

			<div class="row">
				<div class="col-title">
					<label for="tematica">Tematica</label>
				</div>
				<div class="col-insert">
					<input type="text" class="tematica" placeholder="Tematica"
						name="tematica" id="tematica" value="<%=tematica %>">
				</div>
			</div>

			<div class="row">
				<div class="col-title">
					<label for="descrizione">Descrizione</label>
				</div>
				<div class="col-insert" id="area_descrizione">
					<input type="text"  id="descrizione" name="descrizione"
						value="<%=descrizione %>">
				</div>
			</div>

			<div class="row">
				<input type="submit" value="Modifica">
			</div>

		</form>
	</div>




</body>
</html>