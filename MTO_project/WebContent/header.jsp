<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">

</head>
<header>

<div class="logo"><a href="Home.jsp"><img src="immagini\LOGO.png" alt="Logo"
		class="logo"> </a></div>

<%
      String username = (String) session.getAttribute("username");
     if (username != null) {
    %>
	
   <ul>
		<li>
			<div class="down">
				
				<button onclick="myFunct()" class="btn">
				</button>
				
				<div id="mydown" class="down-cont">
				<a href="#" class="welcome">Welcome : <%=username%> </a>
					
					<form action="LogoutServlet" method="post" class="Login">
						<a href="#"><input type="submit" class="logout" value="Logout" onclick="myFunction()"></a>
					</form>
				</div>
				
			</div>
		</li>
	</ul>

	<%	} else { %>
	<div class="login"><a href="login.jsp"><img class="im_login" src="immagini/user.png"
			alt="utente" /></a></div>
	<%
  }
 %>

</header>

<nav>
   
      <ul>
  <li><a href="#home">Home</a></li>
	<%
		String tipo = (String) session.getAttribute("tipo");
		if (username != null && tipo.equals("responsabileAzienda")) {
    %>
			<li class="list_tir">
				<form action="ListaTirociniServlet" method="post">
					<input type="submit" class="list_tir" value="Tirocini" >
				</form>
			</li>
			
	<%	} else if(username != null && tipo.equals("studente")) { %>

			<li class="list_tir">
				<form action="RicercaTirocinioServlet" method="post">
					<input type="submit" class="list_tir" value="Tirocini" >
				</form>
			</li>
  
	<%	} %>
  
  <li><a href="#news">BHO</a></li>
 
    <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Dropdown</a>
    <div class="dropdown-content">
      <a href="#">Link 1</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
  </li>
</ul>
    
  </nav>
<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunct() {
    document.getElementById("mydown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.btn')) {

    var dropdowns = document.getElementsByClassName("down-cont");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>


<script src="http://code.jquery.com/jquery-1.6.4.min.js"
	type="text/javascript"> </script>
</html>