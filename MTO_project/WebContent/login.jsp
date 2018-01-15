<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O.-Login</title>

<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<div class="container">
  <form action="LoginServlet" method="post">
    <div class="row">
      <div class="col-25">
        <label for="uname">Userame</label>
      </div>
      <div class="col-input">
        <input type="text" id="uname" name="username" placeholder="Your username..">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="pax">Password</label>
      </div>
      <div class="col-input">
        <input type="password" id="pax" name="password" placeholder="Your last password..">
      </div>
    </div>
    
    
    <div class="row">
      <input type="submit" value="Submit">
    </div>
  </form>
</div>
	
</body>

<script src="http://code.jquery.com/jquery-1.6.4.min.js"
	type="text/javascript"> </script>

<script type="text/javascript">
                
  // Get the modal

	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}

	$(function() {
		$('#submitLogin').click(function() {

			var username = $('#username').val();
			var password = $('#password').val();

			var amministratore = "Admin";
			if ($("#amministratore").is(":not(:checked)")) {
				amministratore = "Client";
			}

			$.ajax({
				url : '/FreedomAirport/Login',
				type : 'POST',
				data : {
					uname : username,
					pass : password,
					amministratore : amministratore
				},
				success : function(result) {
					if (parseInt(result)) {
						location.reload();
					} else {
						alert("Username o Password Errati!");
					}
				},
				error : function() {
					alert("Username o Password Errati!");
				}
			});
			return false;
		});

	});
</script>
</html>