<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
</head>
<body>

	<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
	%>


	<%
		while (rs.next()) {
			// nextRecord - 1record 2record   false 
			out.print(rs.getInt("userId")+"&nbsp;&nbsp;"+rs.getString("firstName") +"<br>");
		}
	%>

</body>
</html>