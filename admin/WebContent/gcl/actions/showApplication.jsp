<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Application View</title>
		
		<style>
			body {background-color: green;}
			
			h3{
				text-align: -moz-center;
				padding-top: 25px;
				font-size: 30px;
			}
			
			.main-section{
				max-width: 1000px;
				width: 100%;
				padding-left: 175px;
			}
			
			.content-section{
				background-color: greenyellow;
			}
			
			.info-section{
				position: absolute;
				height: 25px;
				background-color: green;
				padding: 5px 412px;
			}
			
			.name-section{
				color: white;
				font-size: 20px;
				font-weight: bold;
				padding-left: 35px;
			}
			
			.btn{
				background-color: chartreuse;
				font-weight: bold;
				padding: 10px 70px;
				font-size: 20px;
			}
			
			.action-btn{
				background-color: chartreuse;
				font-weight: bold;
				padding: 5px 50px;
				font-size: 16px;
			}
			
			.application-section{
				padding: 70px 20px;
			}
			
			.app-details{
				line-height: 2;
			}
		</style>
	</head>
	<body>
		<div class="main-section">
			<div class="content-section">
			
				<h3>Application Details</h3>
				
				<div class="info-section">
					<div class="name-section">
						<a href="/admin" style="color: white;">Home</a> |  
						<a href="logout" style="color: white;">SignOut</a>
					</div>
				</div>
				
				
				<div class="common-information" style="display:none">
					<p>This customer's application was expired. Kindly inform the customer to upgrade the payment for upcoming DV-Lotteries.</p>
					<p>We will not submit this customer for upcoming DV-Lottery, Because the application is in Submission Skip list.</p>
					<p>This application was deleted.</p>
					<p>One of the child age is more than 18 years. As per the Govt rules, above 18 age should apply greencard separatly. So inform user and remove the child.</p>
				</div>
				
				
				<div class="application-section">
					<div class="top-action">
						<div class="delete-section">
							<form name="deleteApplication" action="/admin/deleteApplication" method="post">
								<input type="hidden" name="customerId" value="${customerId}" />
								<input class="action-btn" type="submit" name="deleteApplication" value="Delete Application" />
							</form>
							
							<h2>Delete Status = ${deleteStatus}</h2>
						</div>
					
						<div class="skip-section">
							<form name="skipFromSubmission" action="/admin/skipFromSubmission" method="post">
								<input type="hidden" name="customerId" value="${customerId}" />
								<input class="action-btn" type="submit" name="skipFromSubmission" value="Skip Submission" />
							</form>
							
							<h2>Skip Status = ${skipStatus}</h2>
						</div>
						
						<div class="skip-section">
							<form name="addToSubmission" action="/admin/addToSubmission" method="post">
								<input type="hidden" name="customerId" value="${customerId}" />
								<input class="action-btn" type="submit" name="addToSubmission" value="Add To Submission" />
							</form>
							
							<h2>Skip Status = ${addSubmissionStatus}</h2>
						</div>
					</div>
						
					<!-- <div class="getAccount">
						<h2>Enter AccountID to show application</h2>
					
						<form name="getApplication" action="/admin/showApplication" method="post">
							<label>Account ID :</label> <input type="text" name="accountId" value="" />
							<input class="action-btn" type="submit" name="getApplication" value="Show Details" />
						</form>
					</div> -->
				
					<div class="app-details">
						<div class="register-section">
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
						</div>
						
						<div class="cus-content-section">
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
						</div>

						<div class="cus-application-section">
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
						</div>

						<div class="applicant-section">
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
						</div>

						<!-- <div class="photo-section">
						    <h2>Photographs - Details</h2>
							
							<ul>
								<li>PhotographType : ${photographs.getPhotographType()} </li>
								<li>Resolution : ${photographs.getResolution()} </li>
								<li>PhotographStatus : ${photographs.getPhotographStatus()} </li>
								<li>UploadedDate : ${photographs.getUploadedDate()} </li>
								<li>BackgroundStatus : ${photographs.getBackgroundRejectedFlaggedStatus()} </li>
								<li>BlurStatus : ${photographs.getBlurRejectedFlaggedStatus()} </li>
								<li>FaceDetectStatus : ${photographs.getFaceRejectedFlaggedStatus()} </li>
								<li>FaceProcessorStatus : ${photographs.getFaceProcessorErrorFlaggedStatus()} </li>
							</ul>
						</div> -->
					</div>
				</div>
			</div>
		</div>
	</body>
</html>