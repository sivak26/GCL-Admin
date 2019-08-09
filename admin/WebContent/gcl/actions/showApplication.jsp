<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Application</title>
</head>
<body>

	<h2>Enter AccountID to show application</h2>

	<form name="getApplication" action="/admin/showApplication" method="get">
		Account ID : <input type="text" name="accountId" value="" />
		<input type="submit" name="getApplication" value="Show Details" />
	</form>

	<h2>Application - Details</h2>
	
	<ul>
		<li>User ID : ${customer.getUserId()} </li>
		<li>Email ID : ${customer.getEmail()} </li>
		<li>Full Name : ${customer.getFirstName()} </li>
		<li>Password  : ${customer.getPassword()}</li>
		<li>Registration Date : ${customer.getSignUpDate()}</li>
		<li>lastAccessed Date : ${customer.getLastAccess()}</li>
		<li>Phone Number : ${customer.getTelephone()}</li>
		<li>Mobile Number : ${customer.getMobile()}</li>
		<li>Birth Country : ${customer.getBirthCountry()}</li>
		<li>Spouse Country : ${customer.getSpouseCountry()}</li>
		<li>Residence Country : ${customer.getResidenceCountry()}</li>
	</ul>

</body>
</html>