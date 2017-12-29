<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<p>${welcome}<p>
	<p><button id="registerButton">Rejestracja</button></p>
	<p><button id="logInButton">Zaloguj sie</button></p>
</body>
<script>
	document.getElementById("registerButton").onclick = function()
	{
		location.href = "/ISRSK/register";
	};
	
	document.getElementById("logInButton").onclick = function()
	{
		location.href = "/ISRSK/login";
	};
</script>
</html>