<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M.T.O.-Login</title>
 
 <!--Ultima versione di jQuery (minified) -->
  <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
 
  <!-- Ultima versione di jquery.validate (minfied) -->
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
 

<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
</head>
<body>
	<%@ include file="header.jsp"%>
	
<!-- Form container -->
  <div class="container">
 
    <!-- form da validare -->
    <form action="LoginServlet" method="post" id="form">
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
         <input type="submit" value="Login" class="type_submit" id="submitLogin"class="submit">
      </div>
    </form>
 
  </div>
</body>



</html>