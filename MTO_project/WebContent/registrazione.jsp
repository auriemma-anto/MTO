<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione</title>
<!--Ultima versione di jQuery (minified) -->
  <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
 
  <!-- Ultima versione di jquery.validate (minfied) -->
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>

<link rel="stylesheet" href="css/registrazione.css" type="text/css" media="all">

</head>
<body>

<%@ include file="header.jsp"%>

<div class="containerReg">

<!-- action="RegistrazioneServlet" method="post" -->
  <form action="RegistrazioneServlet" method="post"  name="modulo" id="form" onsubmit="return invio()">
  
    <div class="row">
      <div class="col-25">
        <label for="username">Username</label>
      </div>
      <div class="col-75">
        <input type="text" id="username" name="username" placeholder="Username" required>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="password">Password</label>
      </div>
      <div class="col-75">
        <input type="password" id="password" name="password" placeholder="Password" required>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="conferma">Conferma password</label>
      </div>
      <div class="col-75">
        <input type="password" id="conferma" name="conferma" placeholder="Conferma password" required>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="email">E-mail</label>
      </div>
      <div class="col-75">
        <input type="text" id="email" name="email" placeholder="E-mail" required>
      </div>
    </div>
     
    <div class="row">
      <div class="col-25">
        <label for="tipo">Tipologia di utente</label>
      </div>
      <div class="col-75">
        <select id="tipo" name="tipo">
          <option value=""> </option>
          <option value="studente">Studente</option>
          <option value="responsabileAzienda">Responsabile azienda</option>
          <option value="tutorEsterno">Tutor esterno</option>
          <option value="tutorAccademico">Tutor accademico</option>
        </select>
      </div>
    </div>
    
       
    <div class="row">
      <div class="col-25">
        <label for="nome">Nome</label>
      </div>
      <div class="col-75">
        <input type="text" id="nome" name="nome" placeholder="Nome">
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="cognome">Cognome</label>
      </div>
      <div class="col-75">
        <input type="text" id="cognome" name="cognome" placeholder="Cognome">
      </div>
    </div>
    
     <div class="row">
      <div class="col-25">
        <label for="dataNascita">Data di nascita</label>
      </div>
      <div class="col-75">
        <input type="date" id="dataNascita" name="dataNascita" placeholder="dd-mm-aaaa">
      </div>
    </div>
    
      <div class="row">
      <div class="col-25">
        <label for="annoImmatricolazione">Anno di immatricolazione</label>
      </div>
      <div class="col-75">
        <input type="text" id="annoImmatricolazione" name="annoImmatricolazione" placeholder="2015/16">
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="cfu">CFU</label>
      </div>
      <div class="col-75">
        <input type="text" id="cfu" name="cfu" placeholder="115">
      </div>
    </div>
   

     <div class="row">
      <div class="col-25">
        <label for="universita">Universit�</label>
      </div>
      <div class="col-75">
        <input type="text" id="universita" name="universita" placeholder="UNISA">
      </div>
    </div>

	<div class="row">
      <div class="col-25">
        <label for="dipartimento">Dipartimento</label>
      </div>
      <div class="col-75">
        <input type="text" id="dipartimento" name="dipartimento" placeholder="Informatica">
      </div>
    </div>
    
    <div class="condizioni">
        <span>Accetti i termini del servizio?</span>
    	<input type="checkbox" id="accetto" name="accetto">
	</div>

    <div class="row">
      <input type="submit" value="Invia" class="submit" onClick="Modulo()">
    </div>
   
    
  </form>
</div>

</body>

<!-- 
<script type="text/javascript">
function Modulo() {
	
	var username = document.modulo.username.value;
	var password = document.modulo.password.value;
	var conferma = document.modulo.conferma.value;
	var email = document.modulo.email.value;
	var tipo = document.modulo.tipo.options[document.modulo.tipo.selectedIndex].value; 
	var nome = document.modulo.nome.value;
	var cognome = document.modulo.cognome.value;
	var dataNascita = document.modulo.dataNascita.value;
	var annoImmatricolazione = document.modulo.annoImmatricolazione.value;
	var cfu = document.modulo.cfu.value;
	var universita = document.modulo.universita.value;
	var dipartimento = document.modulo.dipartimento.value;
	var azienda = document.modulo.azienda.value;


	//controllo della password
	if (password != conferma) {
		   alert("La password confermata � diversa da quella scelta, controllare.");
		   document.modulo.conferma.value = "";
		   document.modulo.conferma.focus();
		   return false;
		}
	
	 //INVIA IL MODULO
    else {
        document.modulo.action = "RegistrazioneServlet";
        document.modulo.submit();
    }

}


</script>
 -->

<script type="text/javascript">

function invio() {
	$.ajax({
		url : 'MTO_project/registrazione',
		dataType : 'json',
		type : 'POST',
		data : {
			
			username :  $('#username').val(),
			password :  $('#password').val(),
			conferma :  $('#conferma').val(),
			email :  $('#email').val(),
			tipo :  $('#tipo').val(),
			nome :  $('#nome').val(),
			cognome :  $('#cognome').val(),
			dataNascita :  $('#dataNascita').val(),
			annoImmatricolazione :  $('#annoImmatricolazione').val(),
			cfu :  $('#cfu').val(),
			universita :  $('#dipartimento').val(),
			dipartimento :  $('#dipartimento').val()
			
		},
		success : function(result) {
			if (parseInt(result['result'])) {
				 window.location.replace(encodeURIComponent("login.jsp"));
			} else {
				alert("Si � verificato il seguente errore: "+ result['description']);
			}
		},
		//error : function() {
			//alert("Si � verificato un errore!!");
		}
	});
	return false;
	
}


</script> 


<script type="text/javascript">

//funzione per mostrare i essaggi di errore
$().ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $("#form").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            
            username : { required: true, },
    		password : { required: true },
    		conferma:{
                required: true,
                equalTo: "#password"
            },
    		email: {
                required: true,
                email: true
            },
    		tipo : { required: true }, 
    		nome : { required: true },
    		cognome : { required: true },
    		dataNascita : { required: true },
    		annoImmatricolazione : { required: true },
    		cfu : { required: true, digits:true },
    		universita : { required: true },
    		dipartimento : { required: true },
    		accetto : { required: true }
            },
            
            
        // Personalizzimao i mesasggi di errore
         messages:
        {
        	username : " * Inserire l'username.",
     		password : " * Inserire la password.",
            conferma: " * Le password non corrispondono!",
            email: {
            	required:" * Inserisci un indirizzo email valido!",
            	email: " * L'email deve essere nel formato name@email.com"
            	},
            tipo : " * Scegli la tipologia di utente.", 
    		nome : " * Inserisci il tuo nome.",
    		cognome : " * Inserisci il tuo cognome.",
    		dataNascita : " * Inserisci la data di nascita.",
    		annoImmatricolazione : " * Inserisci l'anno di immatricolazione.",
    		cfu : { 
    			required:" * Inserisci i CFU.",
    			digits: " * Inserire cifre."
    			},
    		universita : " * Inserisci il nome dell'universit� a cui sei regolarmente iscritto.",
    		dipartimento : " * Inserisci il dipartimento.",
    		azienda : " * Inserisci l'azienda presso cui lavori.",
            accetto: " * Non hai accettato i termini del servizio!"
        },
        // Settiamo il submit handler per la form
      
	submitHandler : function(form) {
		alert('I dati sono stati inseriti correttamente');
		form.submit();
	},
	invalidHandler : function() {
		alert('I dati inseriti non sono corretti, ricontrollali....');
	}
 });
});
</script>

</html>