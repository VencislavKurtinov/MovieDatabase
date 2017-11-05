<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>

<style>
h3 {
	margin: 20% 0 0 30%;
}
</style>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<h3 style="color: Red;">Something went wrong, please try later!</h3>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>