<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ForgetPassword</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>



	<div class="container-fluid">
		<Br> <br>

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">

				<h2>ForgetPassword</h2>

				<form method="post" action="ForgetPasswordServlet">




					<div class="form-group">
						<label>Email</label> <input type="text" name="email"
							class="form-control" placeholder="Enter Email"> <span
							style="color: red;">  ${emailError} </span>
					</div>

					<br>



					<button type="submit" class="btn btn-primary">Help Me!!</button>


				</form>
				<a href="Login.html">Login</a>

			</div>
		</div>
	</div>

</body>
</html>