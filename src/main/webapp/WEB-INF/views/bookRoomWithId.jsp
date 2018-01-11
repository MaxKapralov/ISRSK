<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Sala ${room.location}</title>
</head>
<body>
	<p>Sala ${room.location}</p>
	<p><input id="day" type="date"></p>
	<p id ="response"></p>
</body>
<script>
	$(document).ready(function()
	{
		$('#day').change(function()
		{
			var date = $('#day').val();
			
			$.ajax({
				url: "http://localhost:8080/ISRSK/admin/checkDate?date=" + date,
				dataType: "text",
				success: function(data){
					$('#response').text(data);
				},
				type: "GET"
			});
		});
	});
	
</script>
</html>