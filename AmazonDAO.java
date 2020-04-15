package com.cmr.amazon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.cmr.amazon.common.JDBCTemplate;

public abstract class AmazonDAO implements DAO{

	protected String sql = null;
	protected ResultSet rs = null;
	protected Connection con =null;
	protected Statement stmt = null;
	
	@Override
	public Boolean save(Object obj) {
		return JDBCTemplate.executeUpdate(sql);
	}

	@Override
	public Boolean update(Object obj) {
		return JDBCTemplate.executeUpdate(sql);		
	}

	@Override
	public Boolean delete(Integer id) {
		return JDBCTemplate.executeUpdate(sql);		
	}
}
