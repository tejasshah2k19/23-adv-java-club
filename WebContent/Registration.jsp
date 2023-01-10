<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<%
		String errorMsg = (String) request.getAttribute("error");
	%>

	<%=errorMsg%><br>
	<br>
	<form method="post" action="RegistrationServlet">


		FirstName : <input type="text" name="firstName"><br>
		Email : <input type="text" name="email" /><BR> Password : <input
			type="password" name="password" /><BR> Gender : Male <input
			type="radio" name="gender" value="male"> Female <input
			type="radio" name="gender" value="female"><br> Hobby :
		Whatsapp <input type="checkbox" name="hobby" value="whatsapp">
		FaceBook <input type="checkbox" name="hobby" value="facebook">
		Insta <input type="checkbox" name="hobby" value="insta"> <br>

		Country : <select name="country">
			<option value="-1">Select Country</option>
			<option value="india">India</option>
			<option value="japan">Japan</option>
			<option value="usa">USA</option>
			<option value="uk">UK</option>
		</select>


		<button type="submit">Signup</button>

	</form>

	<a href="Login.html">Login</a>

</body>
</html>