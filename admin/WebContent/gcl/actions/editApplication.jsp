<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Application</title>
		
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
		
		<script type="text/javascript">
		function enable(id) {
			//alert("Enable " + id);
			document.getElementById(id).style.display = "block";
		}
		
		</script>
		
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
				
				<div class="app-details">
					<div class="register-section">
						<h2>Registration - Details</h2>
						
						<form name="editRegistration" action="/admin/editRegistration" method="post">
						
							<input type="hidden" name="customerId" value="${customerId}" />
						
							<ul>
								<li>
									Email ID : 
										<input type="text" name="customerEmailId" id="customerEmailId" value="${registration.getEmail()}" style="display:none">
										<input type="button" id="email" value="Update Email" onclick="enable('customerEmailId')">
								</li>
								<li>
									First Name : 
										<input type="text" name="customerName" id="customerName" value="${registration.getFirstName()}" style="display:none">
										<input type="button" id="firstName" value="Enable Name" onclick="enable('customerName')">
								</li>
								<li>
									Password  : 
										<input type="text" name="customerPassword" id="customerPassword" value="${registration.getPassword()}" style="display:none">
										<input type="button" id="password" value="Enable Password" onclick="enable('customerPassword')">
								</li>
								<li>
									Phone Number : 
									<input type="text" name="customerPhone" id="customerPhone" value="${registration.getTelephone()}" style="display:none">
									<input type="button" id="phone" value="Enable Phone" onclick="enable('customerPhone')">
								</li>
								<li>
									Mobile Number : 
									<input type="text" name="customerMobile" id="customerMobile" value="${registration.getMobile()}" style="display:none">
									<input type="button" id="mobile" value="Enable Mobile" onclick="enable('customerMobile')">
								</li>
							</ul>
							
							<div class="application-section">
								<div class="top-action">
									<div class="delete-section">
											<input class="action-btn" type="submit" name="editRegistration" value="Update Registration" />
										<h2>Update Status = ${updateStatus}</h2>
									</div>
								</div>
							</div>
				
						</form>
					</div>
				</div>
				
			</div>
		</div>
	
	</body>
</html>