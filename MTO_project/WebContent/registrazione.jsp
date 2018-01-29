<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O.-Registrazione Studente</title>
<!--Ultima versione di jQuery (minified) -->
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<!-- Ultima versione di jquery.validate (minfied) -->
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<!-- Ultima versione di bootstrap (minified) -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/additional-methods.js"></script>
<!-- codice jQuery -->
<script type="text/javascript" src="app.js"></script>
<!-- Custom styles -->
<link rel="stylesheet" href="css/registrazione.css" type="text/css"
	media="all">

</head>
<body>

	<div class="containerReg">

		<!-- action="RegistrazioneServlet" method="post" -->
		<form action="RegistrazioneServlet" method="post" name="modulo"
			id="form" onsubmit="return invio()">
			<!--   onsubmit="return invio()"-->



			<div class="row">
				<div class="col-25">
					<label for="username">Username</label>
				</div>
				<div class="col-75">
					<input type="text" id="username" name="username"
						placeholder="Username">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="password">Password</label>
				</div>
				<div class="col-75">
					<input type="password" id="password" name="password"
						placeholder="Password">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="conferma">Conferma password</label>
				</div>
				<div class="col-75">
					<input type="password" id="conferma" name="conferma"
						placeholder="Conferma password">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="EMAIL">E-mail</label>
				</div>
				<div class="col-75">
					<input type="text" class="EMAIL" id="EMAIL" name="EMAIL"
						placeholder="E-mail"> <b class="em_sud">@studenti.unisa.it</b>
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
					<input type="text" id="cognome" name="cognome"
						placeholder="Cognome">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="dataNascita">Data di nascita</label>
				</div>
				<div class="col-75">
					<input type="date" id="dataNascita" name="dataNascita"
						placeholder="dd-mm-aaaa">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="anno">Anno di immatricolazione</label>
				</div>
				<div class="col-75">
					<input type="text" id="annoI1" name="annoI1" placeholder="2018">
					<b class="slash">/</b> <input type="text" id="annoI2" name="annoI2"
						placeholder="19">
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
					<input type="text" id="universita" name="universita"
						placeholder="UNISA" value="UNISA">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="dipartimento">Dipartimento</label>
				</div>
				<div class="col-75">
					<input type="text" id="dipartimento" name="dipartimento"
						placeholder="Informatica">
				</div>
			</div>

			<div class="condizioni">
				<span>Accetti i termini del servizio?</span> <input type="checkbox"
					id="accetto" name="accetto">
			</div>

			<div class="row">
				<input type="submit" value="Invia" class="submit" onClick="invio()">
			</div>



		</form>
	</div>


</body>


<script>

$(document).ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $("#form").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            username : { 
            	required : true,
            	minlength : 5,
            	maxlength : 15,
            	nowhitespace : true
            	},
            password : {
                required : true,
                minlength : 4,
                maxlength : 25,
                nowhitespace : true
            }, 
            conferma : { 
            	required : true,
            	minlength : 4,
                maxlength : 25,
            	equalTo: "#password",
            	nowhitespace : true
            	},
            EMAIL : { 
            	required : true,
            	minlenght : 4,
            	maxlenght : 30, 
            	nowhitespace : true
            	 },
            nome : { 
            	required : true,
            	minlenght : 2,
            	maxlength : 25,
            	lettersonly : true,
            	},
            cognome : { 
            	required : true,
            	minlenght : 2,
            	maxlength : 25,
            	lettersonly : true,
            	},
            dataNascita : { 
            	required : true 
            	},
            annoI1 : {
            	required : true,
            	digits: true, 
            	minlength : 4,
            	maxlength : 5
            	},
            annoI2 : {
            	required : true,
            	digits: true, 
            	minlength : 2,
            	maxlength : 3
            	
            	},
            cfu : {
            	required : true,
            	digits:true,
            	minlength : 3,
            	maxlength : 3
            	},
            universita : { 
            	required : true,
            	minlenght : 5,
            	maxlength : 50,
            	lettersonly : true,
            	},
            dipartimento : { 
            	required : true,
            	minlenght : 5,
            	maxlength : 45,
            	lettersonly : true,
            	},
            accetto : { 
            	required : true 
            	}
        },
        // Personalizzimao i mesasggi di errore
        messages: {
        	username : {
        		required :" * Inserisci la username!",
        		minlength: " * L'username  deve essere di minimo 5 caratteri!",
        		maxlength :" * L'username  contiene troppi caratteri!",
        		nowhitespace : "* Formato errato!"
        	},
        	password: {
                required: " * Inserisci una password! ",
                minlength: " * La password deve essere lunga minimo 4 caratteri!",
                maxlength :" * Password troppo lunga!",
                nowhitespace : "* Formato errato!"
           		},
        	conferma: {
           		required: " * Inserisci una password! ",
                minlength: " * La password deve essere lunga minimo 4 caratteri!",
                maxlength :" * Password troppo lunga!",
           		equalTo : " * La password non corrisponde!",
           		nowhitespace : "* Formato errato!"
        	},
        	EMAIL: {
        		minlength: " * L'email deve essere lunga minimo 4 caratteri!",
                maxlength :" * Email troppo lunga!",
            	required:" * Inserisci l'username universitario! (la passwod sarà: username@studenti.unisa.it)",
            	nowhitespace : "* Formato errato!"
            	},
            nome : {
                required: " * Inserisci il nome!",
                minlength: " * Il nome deve essere lungo minimo 4 caratteri!",
                maxlength : " * Il numero massimo di caratteri è 25!",
                lettersonly : "* Inserire solo lettere!"
            },
            cognome : {
                required:" * Inserisci il cognome!",
                minlength: " * Il cognome deve essere lungo minimo 4 caratteri!",
            	maxlength : " * Il numero massimo di caratteri è 25!",
            	lettersonly : "* Inserire solo lettere!"
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
            	required: " * Inserisci i cfu!",
            	digits: " * Inserire cifre!",
            	minlenght : " * Il numero di cifre è 3",
            	maxlength : " * Il numero di cifre è 3 !"
            },
            universita : {
            	required:" * Inserisci l'universita",
            	minlenght:" * Il numero minimo di caratteri è 4 !",
            	maxlength : " * Il numero massimo di caratteri è 50 !",
            	lettersonly : "* Inserire solo lettere!"
            },            	
            dipartimento : {
            	required:" * Inserisci il dipartimento",
            	minlenght:" * Il numero minimo di caratteri è 4 !",
            	maxlength :" * Il numero massimo di caratteri è 45 !",
            	lettersonly : "* Inserire solo lettere!"
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
		url : '/MTO_project/src/it.unisa.MTO.presentazione.account/RegistrazioneServlet',
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
		}
		//error : function() {
		//	alert("Si è verificato un errore!!");
		//}
	});
	return false;
	
}


</script>

</html>
