package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// open db
			Connection con = DbConnection.getConnection(); // connection open
			// Statement
			// PreaparedStatement
			PreparedStatement pstmt = con.prepareStatement("select * from users");
			// cursor

			ResultSet rs = pstmt.executeQuery();// select
			request.setAttribute("rs", rs);
			//rs r1 r2 s
			
			RequestDispatcher rd = request.getRequestDispatcher("ListUsers.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
