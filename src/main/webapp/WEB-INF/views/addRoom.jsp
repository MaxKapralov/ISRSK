<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodaj Sale</title>
</head>
<body>
	<c:if test="${param.error != null}">
		<p>Nie udalo sie dodac sali!</p>
	</c:if>
	<c:if test="${param.success != null}">
		<p>Dodano sale</p>
	</c:if>
	<form:form action="addNewRoom" method="post" modelAttribute="newRoom">
		<table>
            <tr>
                <td>Lokalizacja:</td>
                <td><form:input path="location"/></td>
                <td><form:errors path="location"/></td>
            </tr>
            <tr>
                <td>Potwierdzenie:</td>
                <td><form:select path="permission">
                	<form:option value="true" label="Tak"/>
                	<form:option value="false" label="Nie"/>
                </form:select></td>
                <td><form:errors path="permission"/></td>
            </tr>
            <tr><td><input type="submit" value="Dodaj"/></td></tr>
		</table>
	</form:form>
</body>
</html>