<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Application Actions</title>
		
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
			
				<h3>Application / Payment Actions</h3>
				
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
							<form name="upgradeApplication" action="/admin/upgradeApplication" method="post">
								<input type="hidden" name="customerId" value="${customerId}" />
								<input class="action-btn" type="submit" name="upgradePayment" value="Upgrade Application" />
							</form>
							
							<h2>Upgrade Status = ${upgradeStatus}</h2>
						</div>
					
						<div class="skip-section">
							<form name="downgradeApplication" action="/admin/downgradeApplication" method="post">
								<input type="hidden" name="customerId" value="${customerId}" />
								<input class="action-btn" type="submit" name="downgradeApplication" value="Downgrade Application" />
							</form>
							
							<h2>Downgrade Status = ${downgradeStatus}</h2>
						</div>
						
						<div class="skip-section">
							<form name="refundPayment" action="/admin/refundPayment" method="post">
								<input type="hidden" name="customerId" value="${customerId}" />
								<input class="action-btn" type="submit" name="refundPayment" value="Refund Payment" />
							</form>
							
							<h2>Refund Status = ${refundStatus}</h2>
						</div>
					</div>
				
					<div class="app-details">
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

						<div class="payment-section">
							<h2>Payment - Details</h2>
							
							<ul>
								<li>Payment ID : ${payment.getPaymentId()} </li>
								<li>Product ID : ${payment.getProductId()} </li>
								<li>Payment Date : ${payment.getPaymentDate()} </li>
								<li>Payment Method : ${payment.getPaymentMethod()} </li>
								<li>CardName : ${payment.getCardName()} </li>
								<li>Approval Code : ${payment.getApprovalCode()} </li>
								<li>User ID : ${payment.getOid()} </li>
								<li>Amount : ${payment.getAmount()} </li>
								<li>Billing Address1 : ${payment.getBillingAddress1()} </li>
								<li>Billing Country : ${payment.getBillingCountry()} </li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	</body>
</html>