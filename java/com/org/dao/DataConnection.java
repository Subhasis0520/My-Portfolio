package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.User;

public class DataConnection {
	private static final String dburl ="jdbc:mysql://localhost:3306/january3";
	private static final String dbusername ="root";
	private static final String dbPassword ="Subhasis@123";
	
	public static int saveData(User user) {
		int row =0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbusername, dbPassword);
			
			String query = "insert into user(name,email,phone,subject,password) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getMail());
			ps.setLong(3, user.getPhone());
			ps.setString(4, user.getSubject());
			ps.setString(5, user.getPassword());
			row = ps.executeUpdate();
			
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return row;
	}
	
	
	public static boolean getDetails(String mail, String password) {
		boolean flag = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbusername, dbPassword);
			String query = "SELECT * FROM user WHERE email=? && password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			 
			return rs.next();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		
		
	}
}
