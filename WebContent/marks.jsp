<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>

 <%
 int[] marks = new int[6];
 int avg = 0;
 if(session.getAttribute("id") == null){
	 response.sendRedirect("index.jsp");
 }
 else{
 String id = session.getAttribute("id").toString();
 String pw = session.getAttribute("pw").toString();
 marks = (int[])session.getAttribute("marks");
 int total = 0;
 
 for (int i = 0; i < marks.length; i++){
	 total = total + marks[i];
 }
 
 avg = total/ marks.length;
 }
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
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;}
		.tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  		overflow:hidden;padding:10px 5px;word-break:normal;}
		.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  		font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
		.tg .tg-4j5e{border-color:#131212;text-align:left;vertical-align:top}
	</style>
	
	<table class="tg">
		<thead>
		<tr>
			<th class="tg-4j5e" colspan="2">1st Year</th>
			<th class="tg-4j5e" colspan="2">2nd Year</th>
			<th class="tg-4j5e" colspan="2">3rd Year</th>
		</tr>
		</thead>
		<tbody>
		<tr>
		<td class="tg-4j5e">SSE4354 Mark </td>
		<td class="tg-4j5e">SSE3151 Mark </td>
		<td class="tg-4j5e">SIM4207 Mark</td>
		<td class="tg-4j5e">SSE1054 Mark</td>
		<td class="tg-4j5e">SIM4301 Mark</td>
		<td class="tg-4j5e">SSK1234 Mark</td>
		</tr>
		</tbody>
		<tr>
		<td class="tg-4j5e"><%out.print(marks[0]);%></td>
		<td class="tg-4j5e"><%out.print(marks[1]);%></td>
		<td class="tg-4j5e"><%out.print(marks[2]);%></td>
		<td class="tg-4j5e"><%out.print(marks[3]);%></td>
		<td class="tg-4j5e"><%out.print(marks[4]);%></td>
		<td class="tg-4j5e"><%out.print(marks[5]);%></td>
		</tr>
	</table>
	<br><br>
	
	<form method="get" action="Editmarks">
		Edit your Marks:
		<br><br>
			<label for="year">Select Year: </label> 
				<select name="year" id="year">
					<option value ="1styear">1st Year</option>
					<option value ="2ndyear">2nd Year</option>
					<option value ="3rdyear">3rd Year</option>
				</select>
			<br/><br/>
			<label for="mark1">Mark 1: </label> 
				<input id="mark1" type="text" name="mark1" value=""> 
			<br/><br/>
			<label for="mark2">Mark 2: </label> 
				<input id="mark2" type="text" name="mark2" value="">
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