<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<%
		String errorMsg = (String) request.getAttribute("error");
		String firstNameError = (String) request.getAttribute("firstNameError");
		String emailError = (String) request.getAttribute("emailError");
		String passwordError = (String) request.getAttribute("passwordError");

		String firstNameValue = (String) request.getAttribute("firstNameValue");
		String emailValue = (String) request.getAttribute("emailValue");
	%>

	<div class="container-fluid">
		<Br> <br>

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">

				<h2>Signup</h2>

				<form method="post" action="RegistrationServlet">


					<div class="form-group">
						<label>FirstName</label> <input type="text" name="firstName"
							class="form-control" placeholder="Enter FirstName"
							value="<%=firstNameValue == null ? "" : firstNameValue%>">
						<span style="color: red;"><%=firstNameError == null ? "" : firstNameError%></span>
					</div>


					<div class="form-group">
						<label>Email</label> <input type="text" name="email"
							class="form-control"
							value="<%=emailValue == null ? "" : emailValue%>"
							placeholder="Enter Email"> <span style="color: red;"><%=emailError == null ? "" : emailError%></span>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							class="form-control" placeholder="Enter Strong Password">
						<span style="color: red;"><%=passwordError == null ? "" : passwordError%></span>
					</div>


					<div class="form-group">

						Gender : Male <input type="radio" name="gender" value="male">
						Female <input type="radio" name="gender" value="female">

					</div>

					<div class="form-group">

						Hobby : Whatsapp <input type="checkbox" name="hobby"
							value="whatsapp"> FaceBook <input type="checkbox"
							name="hobby" value="facebook"> Insta <input
							type="checkbox" name="hobby" value="insta">
					</div>

					<div class="form-group ">

						Country : <select name="country" class="form-control">
							<option value="-1">Select Country</option>
							<option value="india">India</option>
							<option value="japan">Japan</option>
							<option value="usa">USA</option>
							<option value="uk">UK</option>
						</select>
					</div>
					<br>

					<button type="submit" class="btn btn-primary">Signup</button>


				</form>
				<a href="Login.html">Login</a>

			</div>
		</div>
	</div>

</body>
</html>