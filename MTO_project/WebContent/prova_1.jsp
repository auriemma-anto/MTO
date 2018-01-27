<!DOCTYPE HTML>
<html>
<head>
  <title>Esempio di validazione con JQuery</title>
  <!--Ultima versione di jQuery (minified) -->
  <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
  <!-- Ultima versione di jquery.validate (minfied) -->
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
  <!-- Ultima versione di bootstrap (minified) -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <!-- codice jQuery -->
  <script type="text/javascript" src="app.js"></script>
  <!-- Custom styles -->
  <style>
    #form label.error {
        color: red;
        font-weight: bold;
    }
     
    .main {
        width: 600px;
        margin: 0 auto;
    }
  </style>
</head>
<body>
  <!-- Form container -->
  <div class="main">
    <h1>Registrazione</h1>
 
    <!-- form da validare -->
    <form action="#" id="form">
      <div class="form-group">
        <label for="login">Login</label>
        <input type="text" name="login" class="form-control">
      </div>
 
      <div class="form-group">
        <label for="email">Email</label>
        <input type="text" name="email" class="form-control">
      </div>
 
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="password" class="form-control">
      </div>
       
      <div class="form-group">
        <input type="submit" value="Registrati" class="submit" class="form-control">
      </div>
    </form>
 
  </div>
</body>
</html>


<script>
$().ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $("#form").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            // login - nome del campo di input da validare
            login : {
              // Definiamo il campo login come obbligatorio
              required : true
            },
            email : {
                required : true,
                // Definiamo il campo email come un campo di tipo email
                email : true
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
            login: "Inserisci la login",
            password: {
                required: "Inserisci una password password",
                minlength: "La password deve essere lunga minimo 5 caratteri",
                maxlength: "La password deve essere lunga al massimo 8 caratteri"
            },
            email: "Inserisci la tua email"
        },
        // Settiamo il submit handler per la form
        submitHandler: function(form) {
            form.submit();
        }
    });
});



</script>