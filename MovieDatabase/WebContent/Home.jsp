<%@page import="com.movieDB.models.Movie"%>
<%@page import="com.movieDB.models.DAO.MovieDatabaseDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src='https://code.jquery.com/jquery-3.2.1.min.js'></script>
</head>
<body>
	<div id="wrap">
		<h1>
			<input id='movie' type="text" list='movies_list'
				placeholder="Enter movie name:" />

		</h1>
		<jsp:include page="Header.jsp"></jsp:include>

		<datalist id="movies_list"> </datalist>
		<table id='movies'>
			<thead>
			
			</thead>
			<tbody>

			</tbody>
		</table>

		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
	<script src="js/myscript.js"></script>
</body>
</html>