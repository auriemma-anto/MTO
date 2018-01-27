<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/header.css">
<link type="text/css" rel="stylesheet" href="css/domandaTirocinio.css">
<link type="text/css" rel="stylesheet" href="css/common.css">
<title>File Upload to Database Demo</title>
</head>
<body>

	<%@ include file="header.jsp"%>

	<h2>Carica qui la tua proposta di tirocinio</h2>
	<div class="container">
		<form method="post" action="uploadServlet"
			enctype="multipart/form-data" name="upload">

			<script type="text/javascript"
				src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
			<script type="text/javascript">
				$("body")
						.on(
								"click",
								"#btnUpload",
								function() {
									var allowedFiles = [ ".pdf" ];
									var fileUpload = $("#fileUpload");
									var lblError = $("#lblError");
									var regex = new RegExp(
											"([a-zA-Z0-9\s_\\.\-:])+("
													+ allowedFiles.join('|')
													+ ")$");
									if (!regex.test(fileUpload.val()
											.toLowerCase())) {
										lblError
												.html("Formato file non valido! Il documento deve essere in formato <b>.pdf</b>");
										return false;
									}
									lblError.html('');
									return true;
								});
			</script>
			<center>
				<br>
				<br>
				<table border="0">
					<tr>
						<td>Documento:</td>
						<td><input type="file" id="fileUpload" name="documento"
							size="50" accept="application/pdf" /></td>
						<td><input type="hidden" name="codiceTirocinio"
							value="<%=request.getParameter("codiceTirocinio")%>"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" id="btnUpload"
							value="Upload"></td>
					</tr>
				</table>
				<span id="lblError" style="color: red;"></span>
			</center>
		</form>
	</div>
</body>
</html>