<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="Header.jsp"></jsp:include>
		<h1>${ sessionScope.movie.name }</h1>
		<c:forEach items="${sessionScope.comments}" var="comments">

			<table border="1">

				<tr>
					<td>${comments.description}</td>
				</tr>

			</table>
			<hr>
		</c:forEach>

		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>