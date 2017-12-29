<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista uzutkownikow</title>
</head>
<body>
	<p>Lista uzytkownikow:</p>
	<table>
		<tr>
			<td>Imie</td>
			<td>Nazwisko</td>
			<td>Adres email</td>
			<td>Rola</td>
		</tr>		
		<c:forEach var="user" items="${listOfUsers}">
			<tr>
				<td><c:out value="${user.name}"/></td>
				<td><c:out value="${user.surname}"/></td>
				<td><c:out value="${user.email}"/></td>
				<td><c:out value="${user.role}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
