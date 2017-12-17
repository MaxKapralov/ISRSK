<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MainPage</title>
</head>
<body>
<h1>Welcome <strong>${user}</strong></h1>
<button id="logout">Wyloguj sie</button>

	<div id="buttonSet">
		<button id="addRoom">Dodaj Sale</button>
		<button id="delRoom">Usun Sale</button>
		<button id="myConfirm">Moje Potwierdzenia</button>
		<button id="bookRoom">Zarezerwuj Sale</button>
		<button id="addNewUser">Zaloz Nowe Konto</button>
		<button id="userList">Lista Uzytkownikow</button>
	</div>
</body>
<script type="text/javascript">
	document.getElementById("addRoom").onclick = function()
	{
		location.href = "/Rezerwacja/addRoom";
	};
	
	document.getElementById("logout").onclick = function()
	{
		location.href = "/Rezerwacja/logout";
	};
	
	document.getElementById("delRoom").onclick = function()
	{
		location.href = "/Rezerwacja/delRoom";
	};
	
	document.getElementById("myConfirm").onclick = function()
	{
		location.href = "/Rezerwacja/myConfirm";
	};
	
	document.getElementById("bookRoom").onclick = function()
	{
		location.href = "/Rezerwacja/bookRoom";
	};
	
	document.getElementById("addNewUser").onclick = function()
	{
		location.href = "/Rezerwacja/addNewUser";
	};
	
	document.getElementById("userList").onclick = function()
	{
		location.href = "/Rezerwacja/userList";
	};
</script>
</html>