<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save User</title>
</head>
<body>
	<div id="wrapper">
		<h2>User Manager</h2>
	</div>
	<div id="container">
		<h3>Save User</h3>
		<form:form action="saveUser" modelAttribute="user" method="POST">
			<form:hidden path="id" />	
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;"></div>
		<p><a href="/">Back to Home</a> | <a href="/updateUser">Back to Update User</a></p>
	</div>
</body>
</html>