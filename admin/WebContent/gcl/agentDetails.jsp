<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agent Details</title>
	</head>
	<body>
		<h2>Agent Details!!!</h2>
		
		First Name     : ${loginForm.getFirstName()} <br />
		Last Name      : ${loginForm.getLastName()} <br />
		Email Id       : ${loginForm.getEmail()} <br />
		Role           : ${loginForm.getRole()} <br />
		Account Status : ${loginForm.getAccountStatus()} <br />
		
		<a href="logout">signout</a><br/>
	</body>
</html>