<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
    <form:form action="register" method="post" modelAttribute="userForm">
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
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td>Data urodzenia(dd.mm.yyyy):</td>
                <td><form:input path="birthday"/></td>
            </tr>
            <tr><td><input type="submit" value="Rejestracja"/></td></tr>
        </table>
    </form:form>
    </body>
</html>
