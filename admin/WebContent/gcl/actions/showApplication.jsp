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

	<form name="getApplication" action="/admin/showApplication" method="post">
		Account ID : <input type="text" name="accountId" value="" />
		<input type="submit" name="getApplication" value="Show Details" />
	</form>

	<h2>Registration - Details</h2>
	
	<ul>
		<li>User ID : ${registration.getUserId()} </li>
		<li>Email ID : ${registration.getEmail()} </li>
		<li>Full Name : ${registration.getFirstName()} </li>
		<li>Password  : ${registration.getPassword()}</li>
		<li>Registration Date : ${registration.getSignUpDate()}</li>
		<li>lastAccessed Date : ${registration.getLastAccess()}</li>
		<li>Phone Number : ${registration.getTelephone()}</li>
		<li>Mobile Number : ${registration.getMobile()}</li>
		<li>Birth Country : ${registration.getBirthCountry()}</li>
		<li>Spouse Country : ${registration.getSpouseCountry()}</li>
		<li>Residence Country : ${registration.getResidenceCountry()}</li>
	</ul>
	
	<h2>Contact - Details</h2>
	
	<ul>
		<li>City : ${contact.getCity()} </li>
	</ul>

	<form name="deleteApplication" action="/admin/deleteApplication" method="post">
		<input type="hidden" name="registrationId" value="${registration.getUserId()}" />
		<input type="submit" name="deleteApplication" value="Delete Application" />
	</form>
	
	<h2>Delete Status is ${deleteStatus}</h2>
	
	<form name="skipSubmission" action="/admin/skipSubmission" method="post">
		<input type="hidden" name="registrationId" value="${registration.getUserId()}" />
		<input type="submit" name="skipSubmission" value="Skip Submission" />
	</form>
	
	<h2>${skipStatus}</h2>
	
</body>
</html>