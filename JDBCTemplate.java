package com.cmr.amazon.common;

import java.sql.*;
public class JDBCTemplate {
	
	public static boolean executeUpdate(String sql) {//call insert,update, delete
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConFactory.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}catch(Exception e) {System.out.println(e); return false;}
		finally {
			try {
				stmt.close(); con.close();
			}catch(Exception e) {System.out.println(e);}
		}
		return true;
	}
	public static ResultSet executeQuery(String sql) {//call select
		Connection con = null;
		Statement stmt = null;
		ResultSet rs1, rs2 = null;
		try {
			con = DBConFactory.getConnection();
			stmt = con.createStatement();
			rs1 = stmt.executeQuery(sql);
			rs2 = rs1;
		}catch(Exception e) {System.out.println(e);}
		finally {
			try {
				stmt.close(); con.close();
			}catch(Exception e) {System.out.println(e);}
		}
		return rs2;
	}
}
