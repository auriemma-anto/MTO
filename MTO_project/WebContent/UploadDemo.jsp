<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload to Database Demo</title>
</head>
<body>
	<center>
		<h1>File Upload to Database Demo</h1>
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

			<span id="lblError" style="color: red;"></span>

			<table border="0">
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" size="50" /></td>
				</tr>
				<tr>
					<td>ID Tirocinio:</td>
					<td><input type="text" name="tirocinio" size="50" /></td>
				</tr>
				<tr>
					<td>Documento:</td>
					<td><input type="file" id="fileUpload" name="documento"
						size="50" accept="application/pdf" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" id="btnUpload"
						value="Upload"></td>
				</tr>
			</table>
		</form>

	</center>
</body>
</html>