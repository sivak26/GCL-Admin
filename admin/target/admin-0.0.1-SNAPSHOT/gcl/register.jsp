<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Registration Form</h3><br/>
	
	<form id="registrationForm" action="registration" method="post">
		
		First Name: <input type="text" name="firstName" required="required"><br>
		Last Name: 	<input type="text" name="lastName" required="required"><br>
		Email: 		<input type="text" name="email" required="required"><br>
		Password: 	<input type="password" name="password" required="required"><br>
		Role:		<select name="role">
						<option value="1">Customer Support</option>
						<option value="2">Reviewer</option>
					</select>
		<input type="submit" value="REGISTER" name="submit"/>
	</form>

</body>
</html>