<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wypozycz Sale</title>
</head>
<body>

	<p>Lista sal:</p>
	<table>
		<tr>
			<td>Numer Sali</td>
			<td>Potwierdzenie</td>
			<td></td>
		</tr>		
		<c:forEach var="room" items="${list}">
			<tr>
				<td><c:out value="${room.location}"/></td>
				<td>${room.permission}</td>
				<td><button onclick="bookRoom(${room.id})">Wypozycz</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
<script>
	function bookRoom(id)
	{
		location.href = "/ISRSK/admin/bookRoomWithId?id=" + id;
	}
</script>
</html>