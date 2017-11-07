<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header </title>
<script src='https://code.jquery.com/jquery-3.2.1.min.js'></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="wrap">
		<div id="regbar">
			<div id="navthing">
				<h2>
					<a href="#" id="loginform">Login</a> | <a href="#"
						id="registredform">Register</a> | <a href="./Logout" id="logoutform">Logout</a>
					
				</h2>
				<div class="login">
					<div class="arrow-up"></div>
					<div class="formholder">
						<div class="randompad">

							<fieldset>
								<form action="./Login" method="post">
									<label>Email</label> <input type="email" name="email"
										value="example@example.com" /> <label>Password</label> <input
										type="password" name="password" /> <input type="submit"
										value="Login" />
								</form>
							</fieldset>
						</div>
					</div>
				</div>
				<div class="register">
					<div class="arrow-up"></div>
					<div class="formholder">
						<div class="randompad">

							<fieldset>
								<form action="./Register" method="post">
									<label>Name</label> <input type="text" name="name"
										value="please write your name" /> <label>Email</label> <input
										type="email" name="email" value="example@example.com" /> <label>Password</label>
									<input type="password" name="password" /> <input type="submit"
										value="Register me" />
								</form>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>
	

</body>
</html>