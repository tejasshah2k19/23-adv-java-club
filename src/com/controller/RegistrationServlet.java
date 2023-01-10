package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		if (isError == true) {
			// go back with error
			
			request.setAttribute("error", errorMsg);//key : value 
			RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			rd.forward(request, response);
		} else {
			// good to go ahead
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
	
		}

	}
}
