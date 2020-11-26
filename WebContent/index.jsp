<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet”
	type=”text/css” />
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
</head>
<body>
	<center>
		<h1>Welcome to Student Registration System</h1>
	</center>

	<center>
		<form method="get" action="Login">
			<label for="id">Student ID: </label> 
			<input id="id" type="text" name="id" value=""> <br/><br/>
			<label for="pw">Password: </label>
			<input id="pw" type="password" name="pw" value=""> <br/><br/>
			<br/> 
			<input type="submit" value="Login">
		</form>
		<br><br>
		
		<form method="get" action="Register">
			<label for="id">Student ID: </label> 
				<input id="id" type="text" name="id" value=""> <br/><br/>
			<label for="name">Name:</label> 
				<input id="name" type="text" name="name" value="">
				<br/><br/>
			<label for="id">Department: </label> 
				<input id="depart" type="text" name="depart" value=""> <br/><br/>
			<label for="pw">Password:</label> 
				<input id="pw" type="password" name="pw" value="">
				<br/><br/>
				<input type="hidden" name="mark1" value=0>
			<input type="submit" value="Signup">
			</form>
	</center>

</body>
</body>
</html>