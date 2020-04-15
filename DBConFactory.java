package com.cmr.amazon.common;

import java.sql.*;
public class DBConFactory {

	private static String url=null;
	private static String username =null;
	private static String password = null;
	
	static {
		try {
				Class.forName("com.mysql.jdbc.Driver");
				username = "root";
				password = "root";
				url = "jdbc:mysql://localhost:3306/amazon";
				
			}catch(Exception e) {System.out.println(e);}
	}
	public static Connection getConnection() {
		Connection con = null;
		try {
			
			con = DriverManager.getConnection(url, username, password);
			
		}catch(Exception e) {System.out.println(e);}
		
		return con;
	}
}
