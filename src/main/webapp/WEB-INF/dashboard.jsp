<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard Page Lookify</title>
	<link rel="stylesheet" type="text/css" href="main.css">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
</head>
<body>
	<div class="main">
		<div class="header">
		<a href="/songs/new">Add New</a> 
		<a href="/search/topTen">Top Songs</a>
		<div class="fdiv">
			<form action="/search" method="POST">
			 
			        <label>Artist</label>
			        
			        <input type="text" name="artist"/>
			
			    <input class="button" type="submit" value="Search Artist"/>
			</form>  
			</div>
			<div class="table">
			<table>
		    	<thead>
		        	<tr>
		            	<th>Name</th>
		            	<th>Rating</th>
		            	<th>action</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${songs}" var="song">
			        <tr>
			            <td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
			            <td><c:out value="${song.rating}"/></td>
			            <td><a href="/songs/delete/${song.id}">DELETE</a> </td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
		</div>
	</div>
</body>
</html>