<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Application</title>
</head>
<body>

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
	
	<br /> <br />
	
	<h2>Contact - Details</h2>
	
	<ul>
		<li>UserId : ${contact.getUserId()} </li>
		<li>Apt Name : ${contact.getAptName()} </li>
		<li>Street : ${contact.getStreet()} </li>
		<li>City : ${contact.getCity()} </li>
		<li>State : ${contact.getState()} </li>
		<li>Country : ${contact.getCountry()} </li>
		<li>Zip : ${contact.getZip()} </li>
		<li>TelePhone : ${contact.getTelephone()} </li>
		<li>Email : ${contact.getEmail()} </li>
	</ul>
	
	<br /> <br />
	
		<h2>Application - Details</h2>
	
	<ul>
		<li>Application ID : ${application.getApplicationId()} </li>
		<li>Product ID : ${application.getProductId()} </li>
		<li>Created Date : ${application.getCreatedDate()} </li>
		<li>Last Accessed : ${application.getLastAccessed()} </li>
		<li>ApplicationType : ${application.getApplicationType()} </li>
		<li>TakenForReview : ${application.getApplicationTakenForReview()} </li>
		<li>TakenTime : ${application.getApplicationTakenTime()} </li>
		<li>PhotoSentThrough : ${application.getPhotoSentThrough()} </li>
		<li>PhotoUploadStatus : ${application.getPhotoUploadStatus()} </li>
		<li>ApplicationStatus : ${application.getApplicationStatus()} </li>
		<li>Taken By : ${application.getApplicationTakenBy()} </li>
	</ul>
	
	<br /> <br />
	
		<h2>Applicant - Details</h2>
	
	<ul>
		<li>ApplicantID : ${applicant.getApplicantId()} </li>
		<li>FirstName : ${applicant.getFirstName()} </li>
		<li>LastName : ${applicant.getLastName()} </li>
		<li>MiddleName : ${applicant.getMiddleName()} </li>
		<li>Gender : ${applicant.getGender()} </li>
		<li>MaritalStatus : ${applicant.getMaritalStatus()} </li>
		<li>Education : ${applicant.getApplicantEducation()} </li>
		<li>NoOfChildren : ${applicant.getNoOfChildren()} </li>
		<li>DateOfBirth : ${applicant.getDateOfBirth()} </li>
		<li>CityOfBirth : ${applicant.getCityOfBirth()} </li>
		<li>CountryOfBirth : ${applicant.getCountryOfBirth()} </li>
		<li>NativeCountry : ${applicant.getNativeCountry()} </li>
		<li>PhotoId : ${applicant.getPhotoId()} </li>
	</ul>
	
</body>
</html>