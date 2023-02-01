package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer userId = Integer.parseInt(request.getParameter("userId"));

		String firstName = request.getParameter("firstName");

		UserDao userDao = new UserDao();
		UserBean userBean = new UserBean();
		userBean.setUserId(userId);
		userBean.setFirstName(firstName);

		userDao.updateUser(userBean);
		
		response.sendRedirect("ListUserServlet");
		

	}

}
