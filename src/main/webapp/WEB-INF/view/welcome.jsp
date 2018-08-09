<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Welcome !!!</title>
</head>
<body>
	<div align="center">
		<h1>Spring Controller</h1>
		<a href="/index">Go to Index Page</a>
	</div>
	<div align="center">
		<h1>${title}</h1>
	</div>
	
	
	
	<H1>Admission Form</H1> 
	
	<form:form action="/submit" method="POST">
	<p>
	Student Name : <input type="text" name="studentName"/>
	</p>
	<p>
	Student Hobby : <input type="text" name="studentHobby"/>
	</p>
	
	<input type="submit" value ="Submit"/>
	
	</form:form>
	
</body>
</html>