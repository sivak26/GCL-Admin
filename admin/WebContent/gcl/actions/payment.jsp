<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Payment</title>
		
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
				
				<p>This customer is not paid. So please do the payment.</p>
				
				
				
				
			</div>
		</div>

	</body>
</html>