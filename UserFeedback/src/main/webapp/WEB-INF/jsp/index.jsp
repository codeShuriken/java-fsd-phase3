<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>	
	<title>Test Post Request</title>
	<script type="module" src="C:\Users\gowth\OneDrive\Desktop\post-test\script.js"> </script>
</head>

<body>
	<h2>Test Feedback</h2>
	<form action="/testPOSTForm">
		<label for="userName"> User Name:</label>
		<input type="text" required id="userName" name="userName"><br><br>
		
		<label for="rating">Rating(0-10):</label>
		<input type="number" required id="rating" name="rating"><br><br>
		
		<label for="comment">Comment:</label>
		<input type="text" required id="comment" name="comment"><br><br>
		
		<input type="submit" value="Submit" onclick="doPOST()">
	</form>
</body>

</html>