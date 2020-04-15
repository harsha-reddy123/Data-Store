package com.cmr.amazon.dao;

import java.util.List;

public interface DAO {
	public default Boolean save(Object obj) {return false;} // insert a new record
	public default Boolean update(Object obj) {return false;} //update existing record
	public default Boolean delete(Integer id) {return false;} //delete unwanted record
	public default Object get(Integer id) {return null;} //return a record for pk ID
	public default List<Object> list(){return null;} //return all records from a table
}
