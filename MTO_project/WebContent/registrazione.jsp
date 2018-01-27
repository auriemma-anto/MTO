<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O.-Registrazione Studente</title>


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
  <form action="RegistrazioneServlet" method="post"  name="modulo" id="form" onsubmit="return invio()"> <!--   onsubmit="return invio()"-->
 
  
           
    <div class="row">
      <div class="col-25">
        <label for="username">Username</label>
      </div>
      <div class="col-75">
        <input type="text" id="username" name="username" placeholder="Username">
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="password">Password</label>
      </div>
      <div class="col-75">
        <input type="password" id="password" name="password" placeholder="Password" >
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="conferma">Conferma password</label>
      </div>
      <div class="col-75">
        <input type="password" id="conferma" name="conferma" placeholder="Conferma password" >
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="EMAIL">E-mail</label>
      </div>
      <div class="col-75">
        <input type="text" class="EMAIL" id="EMAIL" name="EMAIL" placeholder="E-mail" >
        <b class="em_sud">@studenti.unisa.it</b>
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
        <label for="anno">Anno di immatricolazione</label>
      </div>
      <div class="col-75">
        <input type="text" id="annoI1" name="annoI1" placeholder="2018">
        <b class="slash">/</b>
        <input type="text" id="annoI2" name="annoI2" placeholder="19">
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
        <label for="universita">Università</label>
      </div>
      <div class="col-75">
        <input type="text" id="universita" name="universita" placeholder="UNISA" value="UNISA">
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
      <input type="submit" value="Invia" class="submit"  onClick="Modulo()" > 
    </div>
   
    
    
  </form>
</div>


</body>


<script>

$().ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $("#form").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            username : { 
            	required : true,
            	minlength : 5,
            	maxlength : 15
            	},
            password : {
                required : true,
                minlength : 8,
                maxlength : 25
            }, 
            conferma : { 
            	required : true,
            	equalTo: "#password"
            	},
            EMAIL : { required : true },
            nome : { 
            	required : true,
            	maxlength : 25
            	},
            cognome : { 
            	required : true,
            	maxlength : 25
            	},
            dataNascita : { required : true },
            annoI1 : {
            	required : true,
            	digits:true, 
            	minlength : 4,
            	maxlength : 5
            	},
            annoI2 : {
            	required : true,
            	digits:true, 
            	minlength : 2,
            	maxlength : 3
            	
            	},
            cfu : {
            	required : true,
            	digits:true,
            	maxlength : 3
            	},
            universita : { 
            	required : true,
            	maxlength : 50
            	},
            dipartimento : { 
            	required : true,
            	maxlength : 45
            	},
            accetto : { required : true }
        },
        // Personalizzimao i mesasggi di errore
        messages: {
        	username : {
        		required :" * Inserire la username!",
        		minlength: " * L'username  deve essere di minimo 5 caratteri!",
        		maxlength :" * L'username  contiene troppi caratteri!"
        	},
        	password: {
                required: " * Inserire una password! ",
                minlength: " * La password deve essere lunga minimo 8 caratteri!",
                maxlength :" * Password troppo lunga!"
           		},
        	conferma : " * La password non corrisponde!",
        	EMAIL: {
            	required:" * Inserire l'username universitario! (la passwod sarà: username@studenti.unisa.it)"
            	},
            nome : {
                required: " * Inserire il nome!",
                maxlength : " * Il numero massimo di caratteri è 25!"
            },
            cognome : {
                required:" * Inserire il cognome!",
            	maxlength : " * Il numero massimo di caratteri è 25!"
            },	
            dataNascita : " * Inserisci la data di nascita!",
            annoI1 : {
            	required:" * Inserire!",
            	digits: " * Inserire cifre!",
            	minlength: " * I caratteri devono essere 4!",
            	maxlength : " * I caratteri devono essere 4!"
           		
        	},
        	annoI2 : {
        		required:"  * Inserire!",
        		digits: " * Inserire cifre!",
        		minlength: " * I caratteri devono essere 2!",
        		maxlength : " * I caratteri devono essere 2!"
        		
        	},
            cfu : {
            	required: " * Inserire i cfu!",
            	digits: " * Inserire cifre!",
            	maxlength : " * Il numero massimo di caratteri è 3 !"
            },
            universita : {
            	required:" * Inserire l'universita",
            	maxlength : " * Il numero massimo di caratteri è 50 !"
            },            	
            dipartimento : {
            	required:" * Inserire il dipartimento",
            	maxlength :" * Il numero massimo di caratteri è 45 !"
            },		
            accetto : " * Accetta le condizioni!"
        },
        // Settiamo il submit handler per la form
        /*submitHandler: function(form) {
            form.submit();
        }*/
    });
});

</script>

<script type="text/javascript">

function invio() {
	$.ajax({
		url : '/MTO_project/RegistrazioneServlet',
		dataType : 'json',
		type : 'POST',
		data : {
			
			username :  $('#username').val(),
			password :  $('#password').val(),
			conferma :  $('#conferma').val(),
			EMAIL :  $('#EMAIL').val(),
			nome :  $('#nome').val(),
			cognome :  $('#cognome').val(),
			dataNascita :  $('#dataNascita').val(),
			annoI1 :  $('#annoI1').val(),
			annoI2 :  $('#annoI2').val(),
			cfu :  $('#cfu').val(),
			universita :  $('#dipartimento').val(),
			dipartimento :  $('#dipartimento').val()
			
		},
		success : function(result) {
			if (parseInt(result['result'])) {
				alert("Registrazione effettuate con successo!");
				 window.location.replace(encodeURIComponent("login.jsp"));
			} else {
				alert("Si è verificato il seguente errore: "+ result['description']);
			}
		},
		//error : function() {
		//	alert("Si è verificato un errore!!");
		//}
	});
	return false;
	
}


</script> 

</html>