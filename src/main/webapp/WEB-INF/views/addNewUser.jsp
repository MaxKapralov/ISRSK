<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodaj uzytkownika</title>
</head>
<body>
	<c:if test="${param.success==true}">
		<p>Dodano uzytkownika</p>
	</c:if>
	<form:form action="addNewUser" method="post" modelAttribute="newUserForm">
        <table>
            <tr>
                <td>Imie:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Nazwisko:</td>
                <td><form:input path="surname"/></td>
            </tr>
            <tr>
                <td>Login:</td>
                <td><form:input path="login"/></td>
            </tr>
            <tr>
                <td>Haslo:</td>
                <td><form:password path="password"/></td>
            </tr>
            <tr>
                <td>Powtorz haslo:</td>
                <td><form:password path="passAgain"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input type="email" path="email"/></td>
            </tr>
            <tr>
                <td>Data urodzenia(MM-dd-yyyy):</td>
                <td><form:input path="birthday"/></td>
            </tr>
            <tr>
            	<td>Rola:</td>
            	<td>
            	<form:select path="role">
            		<form:option value="ROLE_USER" label="Uzytkownik"/>
            		<form:option value="ROLE_ADMIN" label="Administrator"/>
            	</form:select>
            	</td>
            </tr>
            <tr><td><input type="submit" value="Dodadj"/></td></tr>
        </table>
    </form:form>
</body>
</html>