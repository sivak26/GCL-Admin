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
		
		<%--
		String requestedAction = request.getParameter("action");
		System.out.println("Action ---------------------- " + requestedAction);
		--%>
		
	</head>
	<body onload="selectedAction();">
	<p>${nextAction}</p>
		<div class="main-section">
			<div class="content-section">
			
				<h3>Application Details</h3>
				
				<div class="info-section">
					<div class="name-section">
						<a href="/admin" style="color: white;">Home</a> |  
						<a href="logout" style="color: white;">SignOut</a>
					</div>
				</div>
				
				<div class="application-section">
						
					<div class="getAccount">
						<h2>Enter AccountID / EmailId to continue requested action</h2>
					
						<form id="requestedAction" name="requestedAction" action="${nextAction}" method="post">
							<label>Account ID :</label> <input type="text" name="accountId" value="" />
							<label>Email ID :</label> <input type="text" name="emailId" value="" />
							<input class="action-btn" type="submit" name="actions" id="actions" value="Continue"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>