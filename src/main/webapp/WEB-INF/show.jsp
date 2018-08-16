<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Song Lookify</title>
	<link rel="stylesheet" type="text/css" href="main.css">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h1><c:out value="${song.name}"/></h1>
	<p>Artist: <c:out value="${song.artist}"/></p>
	<p>Rating (1-10): <c:out value="${song.rating}"/></p>
	<a href="/songs/delete/${song.id}">DELETE</a> 
</body>
</html>