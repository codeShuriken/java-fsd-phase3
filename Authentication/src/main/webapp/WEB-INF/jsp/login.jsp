<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<h1>Login Form</h1>

	<form action="login" method="post">
		<label for="name">User Name:</label><br> 
		<input type="text" required id="userName" name="userName"><br><br> 
		<label for="password">Password:</label>
		<br> 
		<input type="password" required id="password" name="password"><br> 
		<br>
		<input type="submit" value="Login" >
	</form>
	
	<br><br>
	<a href="/">Go Back To Home</a> 
	
</body>
</html>