<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<form method="post" name="modulo">
    <tr>
        <td colspan="2" align="center"><b>Registrazione al servizio<br>Tutti i campi sono obbligatori</b></td>
    </tr>
    <tr><td><b>Nome</b></td><td><input type="text" name="nome"></td></tr>
    <tr><td><b>Cognome</b></td><td><input type="text" name="cognome"></td></tr>
     <div class="row">
      <div class="col-25">
        <label for="username">Username</label>
      </div>
      <div class="col-75">
        <input type="text" id="username" name="username" placeholder="Username" required>
      </div>
    </div>
    <tr><td><b>Password</b></td><td><input type="password" name="password"></td></tr>
    <tr><td><b>Conferma password</b></td><td><input type="password" name="conferma"></td></tr>
    <tr><td><b>Data di nascita (es: 12/04/1978)</b></td><td><input type="text" name="nascita"></td></tr>
    <tr><td><b>Sesso</b></td><td>
      <input type="radio" name="sesso" value="M" checked>M
      <input type="radio" name="sesso" value="F">F
    </td>
    </tr>
    <tr><td><b>Citt�</b></td><td>
      <select name="citta">
        <option>- Seleziona la tua citt� -</option>
        <option value="Roma">Roma</option>
        <option value="Milano">Milano</option>
        <option value="Napoli">Napoli</option>
        <option value="Firenze">Firenze</option>
        <option value="Bologna">Bologna</option>
      </select>
    </td>
    </tr>
    <tr><td><b>Indirizzo</b></td><td><input type="text" name="indirizzo"></td></tr>
    <tr><td><b>Telefono (senza spazi n� simboli)</b></td><td><input type="text" name="telefono"></td></tr>
    <tr><td><b>Email</b></td><td><input type="text" name="email"></td></tr>
    <tr><td><b>Homepage</b></td><td><input type="text" name="homepage" value="http://"></td></tr>
    <tr><td colspan="2"><b>Firma</b></td></tr><tr>
        <td colspan="2" align="center">
        <textarea name="firma" rows="5" cols="32">Inserisci qui il tuo slogan!</textarea>
        </td>
    </tr>
    <tr><td colspan="2" align="right"><input type="button" value="Invia" onClick="Modulo()"></td></tr>
</form>
</table>

</body>


<script>

function Modulo() {
    // Variabili associate ai campi del modulo
    var nome = document.modulo.nome.value;
    var cognome = document.modulo.cognome.value;
    var username = document.modulo.username.value;
    var password = document.modulo.password.value;
    var conferma = document.modulo.conferma.value;
    var nascita = document.modulo.nascita.value;
    var citta = document.modulo.citta.options[document.modulo.citta.selectedIndex].value;
    var indirizzo = document.modulo.indirizzo.value;
    var telefono = document.modulo.telefono.value;
    var email = document.modulo.email.value;
    var homepage = document.modulo.homepage.value;
    var firma = document.modulo.firma.value;
 
    // Espressione regolare dell'email
    var email_reg_exp = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
      
    //Effettua il controllo sul campo NOME
    if ((username == "") || (username == "undefined")) {
        alert("Il campo user � obbligatorio.");
        document.modulo.username.focus();
        return false;
    }
    //Effettua il controllo sul campo COGNOME
    else if ((cognome == "") || (cognome == "undefined")) {
        alert("Il campo Cognome � obbligatorio.");
        document.modulo.cognome.focus();
        return false;
    }
    //Effettua il controllo sul campo NICKNAME
    else if ((nickname == "") || (nickname == "undefined")) {
        alert("Il campo Nickname � obbligatorio.");
        document.modulo.nickname.focus();
        return false;
    }
    //Effettua il controllo sul campo PASSWORD
    else if ((password == "") || (password == "undefined")) {
        alert("Il campo Password � obbligatorio.");
        document.modulo.password.focus();
        return false;
    }
    //Effettua il controllo sul campo CONFERMA PASSWORD
    else if ((conferma == "") || (conferma == "undefined")) {
        alert("Il campo Conferma password � obbligatorio.");
        document.modulo.conferma.focus();
        return false;
    }
    //Verifica l'uguaglianza tra i campi PASSWORD e CONFERMA PASSWORD
    else if (password != conferma) {
        alert("La password confermata � diversa da quella scelta, controllare.");
        document.modulo.conferma.value = "";
        document.modulo.conferma.focus();
        return false;
    }
    //Effettua il controllo sul campo DATA DI NASCITA
    else if (document.modulo.nascita.value.substring(2,3) != "/" ||
             document.modulo.nascita.value.substring(5,6) != "/" ||
             isNaN(document.modulo.nascita.value.substring(0,2)) ||
             isNaN(document.modulo.nascita.value.substring(3,5)) ||
             isNaN(document.modulo.nascita.value.substring(6,10))) {
         
        alert("Inserire nascita in formato gg/mm/aaaa");
        document.modulo.nascita.value = "";
        document.modulo.nascita.focus();
        return false;
    }
    else if (document.modulo.nascita.value.substring(0,2) > 31) {
        alert("Impossibile utilizzare un valore superiore a 31 per i giorni");
        document.modulo.nascita.select();
        return false;
    }
    else if (document.modulo.nascita.value.substring(3,5) > 12) {
        alert("Impossibile utilizzare un valore superiore a 12 per i mesi");
        document.modulo.nascita.value = "";
        document.modulo.nascita.focus();
        return false;
    }
    else if (document.modulo.nascita.value.substring(6,10) < 1900) {
        alert("Impossibile utilizzare un valore inferiore a 1900 per l'anno");
        document.modulo.nascita.value = "";
        document.modulo.nascita.focus();
        return false;
    }
    //Effettua il controllo sul campo CITTA'
    else if ((citta == "") || (citta == "undefined")) {
        alert("Il campo Citt� � obbligatorio.");
        document.modulo.citta.focus();
        return false;
    }
    //Effettua il controllo sul campo INDIRIZZO
    else if ((indirizzo == "") || (indirizzo == "undefined")) {
        alert("Il campo Indirizzo � obbligatorio.");
        document.modulo.indirizzo.focus();
        return false;
    }
    //Effettua il controllo sul campo TELEFONO
    else if ((isNaN(telefono)) || (telefono == "") || (telefono == "undefined")) {
        alert("Il campo Telefono � numerico ed obbligatorio.");
        document.modulo.telefono.value = "";
        document.modulo.telefono.focus();
        return false;
    }
    else if (!email_reg_exp.test(email) || (email == "") || (email == "undefined")) {
        alert("Inserire un indirizzo email corretto.");
        document.modulo.email.select();
        return false;
    }
    //Effettua il controllo sul campo HOMEPAGE
    else if ((homepage == "") || (homepage == "undefined") || (homepage.indexOf("http://") == (-1))) {
        alert("Il campo Homepage non pu� essere privo di http://");
        document.modulo.homepage.value = "http://";
        document.modulo.homepage.select();
        return false;
    }
    //Effettua il controllo sul campo FIRMA
    else if ((firma == "") || (firma == "undefined") || (firma.indexOf("Inserisci qui il tuo slogan!") != (-1))) {
        alert("Il campo Firma � obbligatorio e non si pu� inserire la scritta predefinita.");
        document.modulo.firma.focus();
        return false;
    }
    //INVIA IL MODULO
    else {
        document.modulo.action = "RegistrazioneServlet.java";
        document.modulo.submit();
    }
}

</script>
</html>