<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Registration Success !!!!</h3>${userForm.getLastName()}
<h3>Login Success !!!!</h3>${loginForm.getEmail()}

<br /> 
<a href="logout">SignOut</a>
<br />

<a href="gcl/actions/reviewActions.jsp">REVIEW APPLICATION</a><br />
<a href="gcl/actions/applicationActions.jsp">APPLICATION / PAYMENT</a><br />
<a href="gcl/actions/editApplication.jsp">EDIT APPLICATION</a><br />
<a href="gcl/actions/showApplication.jsp">SHOW APPLICATION</a><br />
<a href="gcl/actions/photoUpload.jsp">PHOTO UPLOAD</a><br />


</body>
</html>