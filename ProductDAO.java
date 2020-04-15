package com.cmr.amazon.dao;

import java.util.ArrayList;
import java.util.List;

import com.cmr.amazon.common.DBConFactory;
import com.cmr.amazon.common.JDBCTemplate;
import com.cmr.amazon.entity.Product;


public class ProductDAO extends AmazonDAO{

	@Override
	public Boolean save(Object obj) {
		Product prd = (Product) obj;	
		sql = "insert into product (catid, pname, price, quantity) values"
				+ "('"+prd.getCatid()+"','"+prd.getPname()+"','"+prd.getPrice()
				+"','"+prd.getQuantity()+"')";
		return super.save(obj);
	}

	@Override
	public Boolean update(Object obj) {
		Product prd = (Product) obj;	
		sql = "update product set catid='"+prd.getCatid()+"', pname='"+prd.getPname()+"', "
				+ "price='"+prd.getPrice()+"', quantity='"+prd.getQuantity()+"' where id="+prd.getId();
		return super.update(obj);
	}

	@Override
	public Boolean delete(Integer id) {
		sql = "delete from product where id=" + id;
		return super.delete(id);
	}

	@Override
	public Object get(Integer id) {
		sql ="select id, catid, pname, price, quantity from product where id=" + id;
		rs = JDBCTemplate.executeQuery(sql);
		Product prd = new Product();
		try {
			con = DBConFactory.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null && rs.next()) {
				prd.setId(rs.getInt("id"));
				prd.setCatid(rs.getInt("catid"));
				prd.setPname(rs.getString("pname"));
				prd.setPrice(rs.getInt("price"));
				prd.setQuantity(rs.getInt("quantity"));
			}
		}catch(Exception e) {System.out.println(e);}
		finally {
			try {stmt.close(); con.close();}catch(Exception e) {}
		}
		return prd;
	}

	@Override
	public List<Object> list() {
		sql = "select id, catid, pname, price, quantity from product";
		List<Object> prdList = new ArrayList<>();
		try {
			con = DBConFactory.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {			
					Product prd = new Product();
					prd.setId(rs.getInt("id"));
					prd.setCatid(rs.getInt("catid"));
					prd.setPname(rs.getString("pname"));
					prd.setPrice(rs.getInt("price"));
					prd.setQuantity(rs.getInt("quantity"));
					prdList.add(prd);
				}
			}
		}catch(Exception e) {System.out.println(e);}
		finally {
			try {stmt.close(); con.close();}catch(Exception e) {}
		}
		return prdList;
	}
	
	public List<Object> list(int catid) {
		sql = "select id, catid, pname, price, quantity from product where catid=" + catid;
		List<Object> prdList = new ArrayList<>();
		try {
			con = DBConFactory.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {			
					Product prd = new Product();
					prd.setId(rs.getInt("id"));
					prd.setCatid(rs.getInt("catid"));
					prd.setPname(rs.getString("pname"));
					prd.setPrice(rs.getInt("price"));
					prd.setQuantity(rs.getInt("quantity"));
					prdList.add(prd);
				}
			}
		}catch(Exception e) {System.out.println(e);}
		finally {
			try {stmt.close(); con.close();}catch(Exception e) {}
		}
		return prdList;
	}

	
}
