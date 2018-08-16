<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Song Lookify</title>
	<link rel="stylesheet" type="text/css" href="main.css">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
</head>
<body>
	<form:form action="/dashboard" method="post" modelAttribute="song">
	    <p>
	        <form:label path="name">Title</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="artist">Artist</form:label>
	        <form:errors path="artist"/>
	        <form:input path="artist"/>
	    </p>
	    <p>
	        <form:label path="rating">Rating (1-10)</form:label>
	        <form:errors path="rating"/>
	        <form:input type="number" path="rating"/>
	    </p>
	    
	    <input class="button" type="submit" value="Add Song"/>
	</form:form>  
</body>
</html>