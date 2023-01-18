package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Validation;

@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		boolean isError = false;

		if (Validation.isBlank(email)) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		}

		RequestDispatcher rd = null;
		if (isError) {
			rd = request.getRequestDispatcher("ForgetPassword.jsp");

		} else {
			// will send mail - otp
			rd = request.getRequestDispatcher("Login.html");

		}

		rd.forward(request, response);

	}
}
