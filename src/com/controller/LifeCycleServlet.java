package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {

	public void init() throws ServletException {
		System.out.println("LifeCycleServlet::init()");
		//db 
		//aws 
		//amazon
		//NSE BSE 
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LifeCycleServlet::service()");
	}

	public void destroy() {
		System.out.println("LifeCycleServlet::destroy()");
		//close 
	}

}
