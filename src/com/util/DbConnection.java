package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {

		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/advjava23_1";
		String userName = "root";
		String password = "root";
		// type 1 2 3 "4"
		try {
			Class.forName(driverName); // load

			Connection con = DriverManager.getConnection(url, userName, password);
			if (con == null) {
				System.out.println("DbNotConnected.....");
			} else {
				System.out.println("DbConnected......");
			}
			return con;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;//
	}

}
