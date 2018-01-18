<!DOCTYPE HTML>
<html>
<head>
  <title>Esempio di validazione con JQuery</title>
  <!--Ultima versione di jQuery (minified) -->
  <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
  <!-- Ultima versione di jquery.validate (minfied) -->
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>

<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
</head>

<body>
  <!-- Form container -->
  <div class="container">
 
    <!-- form da validare -->
    <form action="#" id="form">
       <div class="row">
      <div class="col-25">
        <label for="username">Username</label>
      </div>
      <div class="col-input">
       <input type="text" id="username" name="username" placeholder="Your username..">
      </div>
    </div>
 
     
      <div class="row">
      <div class="col-25">
        <label for="password">Password</label>
      </div>
      <div class="col-input">
        <input type="password" id="password" name="password" placeholder="Your last password..">
      </div>
    </div>
       
         <div class="row">
        <input type="submit" value="Registrati" class="submit" >
      </div>
    </form>
 
  </div>
</body>
<script type="text/javascript">
$().ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $("#form").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            // login - nome del campo di input da validare
            username : {
              // Definiamo il campo login come obbligatorio
              required : true
            },
            
            password : {
                required : true,
                // Settiamo la lunghezza minima e massima per il campo password
                minlength : 5,
                maxlength : 8
            }
        },
        // Personalizzimao i mesasggi di errore
        messages: {
        	username: "Inserisci la username",
            password: {
                required: "Inserisci una password password",
                minlength: "La password deve essere lunga minimo 5 caratteri",
                maxlength: "La password deve essere lunga al massimo 8 caratteri"
            },
        },
        // Settiamo il submit handler per la form
        submitHandler: function(form) {
            form.submit();
        }
    });
});
</script>
</html>