<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>

 <%
 String id = session.getAttribute("id").toString();
 String pw = session.getAttribute("pw").toString();
 String avg = session.getAttribute("avg").toString();
 int[] marks = (int[])session.getAttribute("marks");
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<center>
<h1>Your current average mark is <%out.print(avg);%></h1><br><br>
	<table style="border : 1px solid black">
		<tr>
		<th>Mark 1</th>
		<th>Mark 2</th>
		<th>Mark 3</th>
		</tr>
		<tr>
		<th><%out.print(marks[0]);%></th>
		<th><%out.print(marks[1]);%></th>
		<th><%out.print(marks[2]);%></th>
		</tr>
	</table>
	<br><br>
	<form method="get" action="Editmarks">
	Edit your Marks:<br><br>
			<label for="mark1">Mark 1: </label> 
				<input id="mark1" type="text" name="mark1" value=""> <br/><br/>
			<label for="mark2">Mark 2: </label> 
				<input id="mark2" type="text" name="mark2" value=""> <br/><br/>
			<label for="mark3">Mark 3: </label> 
				<input id="mark3" type="text" name="mark3" value="">
			<br><br>
		<input type="submit" value="Edit">
	</form>
	<br><br>
	<form method="post" action = "Logout">
	<input type="submit" value="Sign Out">
	</form>
	</center>
</body>
</html>