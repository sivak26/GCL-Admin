<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign-In</title>
		
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
			
			#login-btn {
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
				<h3>Login Form</h3>
				
				<div id="login-form">
					<form id="loginForm" action="login" method="post">
						<div id="labels">
							<label>Email:</label> 		<input type="text" name="email" required="required">
							<label>Password:</label> 	<input type="password" name="password" required="required">
						</div>
						<div id="login-btn">
							<input class="btn" type="submit" value="LOGIN" name="submit"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>