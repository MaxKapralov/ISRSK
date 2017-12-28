<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usun Sale</title>
</head>
<body>
<c:if test="${param.deleted == true}">
	<p>Usuneto sale</p>
</c:if>
<c:if test="${param.deleted == false}">
	<p>Nie znaleziono sali w bazie!</p>
</c:if>
	<p>Lista sal:</p>
	<c:forEach var="room" items="${listOfRooms}">
		<p onclick="delRoom(${room.id})"><c:out value="${room.location}" /></p>
	</c:forEach>
</body>
<script>
	function delRoom(id)
	{
		location.href("/ISRSK/admin/delRoomWithId?id=" + id);
	}
</script>
</html>
