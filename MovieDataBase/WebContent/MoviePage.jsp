<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<h1>
	
		<button id='rate'>Rate</button>
		
	</h1>
	<img src="${movie.photo}" alt="This Movie don`t have a Poster!"
		width="600" height="600">

	<table id='movie'>
		<thead>
			<tr>
				<td><h1>${movie.name}</h1></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><h3>Actors:</h3></td>
				<td>${movie.actors }</td>
			</tr>
			<tr>
				<td><h3>Director/s:</h3></td>
				<td>${movie.director}</td>
			</tr>
			<tr>
				<td><h3>Type:</h3></td>
				<td>${movie.type }</td>
			</tr>
			<tr>
				<td><h3>Genre:</h3></td>
				<td>${movie.genre }</td>
			</tr>
			<tr>
				<td><h3>Runtime:</h3></td>
				<td>${movie.runTime }</td>
			</tr>
			<tr>
				<td><h3>Country:</h3></td>
				<td>${movie.country}</td>
			</tr>
			<tr>
				<td><h3>Year:</h3></td>
				<td>${movie.yearOfCreation }</td>
			</tr>
			<tr>
				<td><h3>Plot:</h3></td>
				<td>${movie.plot }</td>
			</tr>
		</tbody>
	</table>
	<script src="js/RateScript.js"></script>
</body>
</html>