package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	// 25
	public void addUser(UserBean userBean) {
		try {
			// good to go ahead
			// database --- store
			// 1) open db connection
			Connection con = DbConnection.getConnection();
			// 2) query
			// Statement , PreparedStatement

			PreparedStatement pstmt = con
					.prepareStatement("insert into users (firstName,email,password) values (?,?,?)");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());

			int i = pstmt.executeUpdate(); // state change -> insert / update / delete
			if (i == 1) {
				System.out.println("User added into db..");
			} else {
				System.out.println("fail to add user in db");
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public ArrayList<UserBean> getAllUsers() {
		try {
			// open db
			Connection con = DbConnection.getConnection(); // connection open
			// Statement
			// PreaparedStatement
			PreparedStatement pstmt = con.prepareStatement("select * from users");
			// cursor

			ResultSet rs = pstmt.executeQuery();// select

			// id fn e p--> UserBean 4
			// ArrayList
			ArrayList<UserBean> users = new ArrayList<UserBean>();
			while (rs.next()) {
				UserBean userBean = new UserBean();
				userBean.setUserId(rs.getInt("userId"));
				userBean.setFirstName(rs.getString("firstName"));
				userBean.setEmail(rs.getString("email"));
				userBean.setPassword(rs.getString("password"));
				users.add(userBean);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public UserBean getUserByUserId(Integer userId) {

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where userId = ?");
			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();// db record

			if (rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("userId"));
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void updateUser(UserBean userBean) {

		try {
			// good to go ahead
			// database --- store
			// 1) open db connection
			Connection con = DbConnection.getConnection();
			// 2) query
			// Statement , PreparedStatement

			PreparedStatement pstmt = con.prepareStatement("update   users set firstName = ? where userId = ? ");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setInt(2, userBean.getUserId());

			int i = pstmt.executeUpdate(); // state change -> insert / update / delete
			if (i == 1) {
				System.out.println("User updated into db..");
			} else {
				System.out.println("fail to modify user in db");
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
}
