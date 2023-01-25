package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.Validation;

public class RegistrationServlet extends HttpServlet {

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// }
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

		UserBean userBean = new UserBean();
		if (Validation.isBlank(firstName)) {
			isError = true;
			errorMsg = errorMsg + "<br>Please Enter FirstName";
			request.setAttribute("firstNameError", "Please Enter FirstName");
		} else if (Validation.isAlpha(firstName) == false) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter Valid FirstName");

		} else {
			request.setAttribute("firstNameValue", firstName);
			userBean.setFirstName(firstName);
		}

		if (Validation.isBlank(email)) {
			isError = true;
			errorMsg = errorMsg + "<br>Please Enter Email";
			request.setAttribute("emailError", "Please Enter Email");
		} else {
			request.setAttribute("emailValue", email);
			userBean.setEmail(email);
		}

		if (password == null || password.trim().length() == 0) {
			isError = true;
			errorMsg += "<br>Please Enter Password";
			request.setAttribute("passwordError", "Please Enter Password");
		}else {
			userBean.setPassword(password);
		}

		if (isError == true) {
			// go back with error

			request.setAttribute("error", errorMsg);// key : value
			RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			rd.forward(request, response);
		} else {

			//
			UserDao userDao = new UserDao();

			userDao.addUser(userBean);

			// mail : welcome , link - verify
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);

		}

	}
}
