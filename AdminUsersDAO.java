package com.cmr.amazon.dao;

import com.cmr.amazon.common.DBConFactory;
import com.cmr.amazon.entity.AdminUsers;

public class AdminUsersDAO extends AmazonDAO{

	public AdminUsers checkLogin(AdminUsers au) {
		sql = "select id, name from adminusers where "
				+ "username='"+au.getUsername()+"' and password='"+au.getPassword()+"'";
		try {
			con = DBConFactory.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) { //we get only one row or no row
				au.setId(rs.getInt(1));
				au.setName(rs.getString(2));
			}
			else {
				au.setId(0);
				au.setName("invaliduser");
			}
		}catch(Exception e) {System.out.println(e); au.setId(0);au.setName("invaliduser");}
		finally {try{stmt.close(); con.close();}catch(Exception e) {System.out.println(e);}}
		return au;
	}
}
