package com.cmr.amazon.dao;

import java.util.List;
import com.cmr.amazon.entity.Category;

public class JDBCTest {
	public static void main(String[] args) {
		List<Object> catList = new CategoryDAO().list();
		
		System.out.println("Cat Id  |  Cat Name");
		System.out.println("-------------------");
		for(Object obj : catList) {
			Category category = (Category) obj;
			System.out.println(category.getId() + "   |    " + category.getCatname());
		}
		System.out.println("-------------------");
	}
}
