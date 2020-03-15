<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registration</title>
		
		<style>
			body {background-color: green;}
			
			.main-section{
				max-width: 1000px;
				width: 100%;
				padding-left: 175px;
			}
			
			.content-section{
				background-color: greenyellow;
			}
			
			h3{
				text-align: -moz-center;
				padding-top: 25px;
				font-size: 30px;
			}
			
			#labels{
				padding: 0px 315px;
				text-align: -moz-right;
				line-height: 3;
			}
			
			label{
				margin-bottom: 5px;
				display: inline-block;
			}
			
			select{
				padding: 0px 43px;
				font-size: 15px;
			}
			
			#registration-btn {
				padding: 30px 400px;
			}
			
			.btn{
				background-color: chartreuse;
				font-weight: bold;
				padding: 10px 70px;
				font-size: 20px;
			}
		</style>
		
	</head>
	<body>
		<div class="main-section">
			<div class="content-section">
				<h3>Registration Form</h3>
				
				<div id="registration-form">
					<form id="registrationForm" action="registration" method="post">
						<div id="labels">
							<label>First Name:</label>
								<input type="text" name="firstName" required="required">
							<label>Last Name:</label>
								<input type="text" name="lastName" required="required">
							<label>Email:</label>
								<input type="text" name="email" required="required">
							<label>Password:</label>
								<input type="password" name="password" required="required">
							<label>Role:</label>
								<select name="role">
									<option value="">Select The Role</option>
									<option value="1">Customer Support</option>
									<option value="2">Reviewer</option>
								</select>
						</div>
						<div id="registration-btn">
							<input class="btn" type="submit" value="REGISTER" name="submit"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>