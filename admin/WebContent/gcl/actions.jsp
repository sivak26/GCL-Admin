<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Admin Actions</title>
		
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
			
			.select-links{
				padding: 30px 0px 150px 348px;
				font-size: 20px;
				text-align: justify;
				line-height: 3;
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
		</style>
		
		<script type="text/javascript">
			function selectedAction(action) {
				document.getElementById("nextAction").value = action;
			}
		</script>
	</head>
	<body>
		<div class="main-section">
			<div class="content-section">
				<h3>GCL Admin Actions</h3>
				
				<div class="info-section">
					<div class="name-section">${agent.getFirstName()}  ${agent.getLastName()} ,
						<a href="/admin" style="color: white;">Home</a> | 
						<a href="logout" style="color: white;">SignOut</a>
					</div>
				</div>
				
				<div class="select-links">
					<h2>Choose actions listed below</h2>
				
					<form id="requestAction" name="requestAction" action="customerAction" method="get">
						<input type="hidden" id="nextAction" name="nextAction" value="" />
						<input type="submit" id="getApplication" value="SHOW APPLICATION" onclick="selectedAction('showApplication')"/>
						<input type="submit" id="editApplication" value="EDIT APPLICATION" onclick="selectedAction('editApplication')"/>
						<input type="submit" id="paymentAction" value="PAYMENT ACTIONS" onclick="selectedAction('applicationAction')"/>
					</form>
				</div>
				
				<!-- <div class="select-links">
					<ul>
						<li><a href="gcl/actions/customerAction?nextAction=/actions/showApplication/">SHOW APPLICATION</a></li>
						<li><a href="gcl/actions/editApplication.jsp">EDIT APPLICATION</a></li>
						<li><a href="gcl/actions/reviewActions.jsp">REVIEW APPLICATION</a></li>
						<li><a href="gcl/actions/applicationActions.jsp">APPLICATION / PAYMENT</a></li>
						<li><a href="gcl/actions/photoUpload.jsp">PHOTO UPLOAD</a></li>
					</ul>
				</div> -->
			</div>
		</div>
	</body>
</html>