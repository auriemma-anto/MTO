<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="java.util.*, it.unisa.MTO.common.*, it.unisa.MTO.businessLogic.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O.- Modifica schede</title>


<!--Ultima versione di jQuery (minified) -->
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<!-- Ultima versione di jquery.validate (minfied) -->
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>


<link rel="stylesheet" href="css/mod_schede.css" type="text/css"
	media="all">
</head>
<body>



	<div class="contenitore">




		<form action="ModificaTirocinioServlet" method="post" name="form_mod" id="form_mod">


			<%

	int codiceTirocinio = Integer.parseInt(request.getParameter("codiceTirocinio"));
	System.out.println("Hidden field Value :"+codiceTirocinio);
	
	Facade facade = new Facade();
	Tirocinio tir = new Tirocinio();
	tir = facade.getTirocinio(codiceTirocinio);
	
	//String codice_id = (String) session.getAttribute("codice_id"); 
	
	String azienda = tir.getAzienda();
	String rif_TA = tir.getRif_TA();
	String rif_TE = tir.getRif_TE();
	String dataInizio = tir.getDataInizio();
	String dataFine = tir.getDataFine();
	String luogo = tir.getLuogo();
	String tematica = tir.getTematica();
	String descrizione = tir.getDescrizione();
	
	System.out.println("descr :"+descrizione);
	
	System.out.println("dataInizio :"+dataInizio);
	
%>
			<input type="hidden" name="codiceTirocinio"
				value="<%=codiceTirocinio%>">



			<div class="row">
				<div class="col-title">
					<label for="rif_TA">Tutor Accademico</label>
				</div>
				<div class="col-insert">
					<input type="text" class="rif_TA" name="rif_TA" id="rif_TA"
						value="<%=rif_TA %>">
				</div>
			</div>

			<div class="row">
				<div class="col-title">
					<label for="rif_TE">Tutor Esterno</label>
				</div>
				<div class="col-insert">
					<input type="text" class="rif_TE" name="rif_TE" id="rif_TE"
						value="<%=rif_TE %>">
				</div>
			</div>


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
					<input type="text" id="descrizione" name="descrizione"
						value="<%=descrizione %>">
				</div>
			</div>

			<div class="row">
				<input type="submit" value="Modifica">
			</div>

		</form>
	</div>




</body>

<script>

$().ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $("#form_mod").validate({
        // Definiamo le nostre regole di validazione
        rules : {
        	rif_TA : { 
            	required : true,
            	minlength : 5,
            	maxlength : 15
            	},
            rif_TE : { 
               	required : true,
               	minlength : 5,
               	maxlength : 15
            },
            azienda  : { 
               	required : true,
               	maxlength : 20
            },
            dataInizio : { required : true }, 
            dataFine : { required : true }, 
            luogo : { 
            	required : true,
            	maxlength : 25
            	},
            tematica : { 
            	required : true,
            	maxlength : 50
            	},
            	descrizione : { 
               	required : true,
               	maxlength : 150
            }
            	
           
        },
        // Personalizzimao i mesasggi di errore
        messages: {
        	
         	rif_TA : { 
         		required :" * Inserire l'username del tutor accademico!",
        		minlength: " * L'username  deve essere di minimo 5 caratteri!",
        		maxlength :" * L'username  contiene troppi caratteri!"
            	},
            rif_TE : { 
            	required :" * Inserire l'username del tutor esterno!",
        		minlength: " * L'username  deve essere di minimo 5 caratteri!",
        		maxlength :" * L'username  contiene troppi caratteri!"
            },
            azienda  : { 
               	required :" * Inserire l'azienda!",
               	maxlength : 20
            },
            dataInizio : { required :" * Inserire la data di inizio del tirocinio!" }, 
            dataFine : { required :" * Inserire la data di fine del tirocinio!" }, 
            luogo : { 
            	required :" * Inserire la sede dove si svolgerà il tirocinio!",
            	maxlength : " * Hai inserito troppi caratteri!"
            	},
            tematica : { 
            	required :" * Inserire la tematica del tirocinio!",
            	maxlength : " * Hai inserito troppi caratteri!"
            	},
            descrizione : { 
               	required :" * Inserire una breve descrizione del tirocinio!",
               	maxlength : " * Hai inserito troppi caratteri!"
            }
        	
     
        },
        // Settiamo il submit handler per la form
        /*submitHandler: function(form) {
            form.submit();
        }*/
    });
});

</script>
</html>