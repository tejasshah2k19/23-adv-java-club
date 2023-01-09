package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet-api.jar 
//implements Servlet 
//extends HttpServlet 

//lib 
//1) local server 
//2) internet : download 

public class SignupServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside SignupServlet....");

		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String hobby[] = request.getParameterValues("hobby");

		System.out.println("firstName => " + firstName);
		System.out.println("email => " + email);
		System.out.println("password => " + password);

		String errorMsg = "";
		boolean isError = false;
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			errorMsg = errorMsg + "<br>Please Enter FirstName";
		}
		if (email == null || email.trim().length() == 0) {
			isError = true;
			errorMsg = errorMsg + "<br>Please Enter Email";
		}
		//
		//
		//

		// response
		response.setContentType("text/html"); // MIME
		PrintWriter out = response.getWriter(); // server --> client

		out.print("<html>");
		out.print("<body>");

		if (isError == true) {
			out.print(errorMsg);
		} else {
			out.print("<br>FirstName => " + firstName);
			out.print("<br>Email => " + email);
			out.print("<br>Password => " + password);
			out.print("<br>Gender => " + gender);
			out.print("<br>Country => " + country);

			out.print("<br>Hobby => ");
			for (String s : hobby) {
				out.print(s + ",");

			}

		}

		out.print("<body>");

		out.print("</body>");
		out.print("</html>");

	}
}

//
//class AThread extends Thread {
//	public void run() {
//	}
//}
//
//class BThread implements Runnable {
//	public void run() {
//
//	}
//}