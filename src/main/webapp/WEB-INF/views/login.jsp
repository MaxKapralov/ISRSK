<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start page</title>
</head>
<body>
<h1>Internetowy System Rezerwacji Sal Konferencyjnych</h1>
	<form action="/ISRSK/login" method="post">
		<c:if test="${param.error != null}">
        	<p>Invalid username or password.</p>
		</c:if>
        <c:if test="${param.logout != null}">
            <p>You have been logged out successfully.</p>
        </c:if>
		<input type="text" name="login" placeholder="Login" required/>
		<br>
		<input type="password" name="password" placeholder="Haslo" required/>
		<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
		<br>
		<input type="submit" value="Log in"/>
	</form>
</body>
</html>
