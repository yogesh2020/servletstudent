package com.decipher.dao;

import java.util.ArrayList;

import com.decipher.model.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class EmployeeDao {
	Connection connObj = new Connection();
    DBCollection collection = connObj.getCollection();
	public void add(String username, String address, int roll) {
        
        BasicDBObject document = new BasicDBObject();
    	document.put("Username", username);
    	document.put("Address", address);
    	document.put("Roll",roll);
    	collection.insert(document);
	       
	         }
	
	public void delete(int roll) {
        DBObject  query = new BasicDBObject("Roll", roll);
		collection.remove(query);
	}
	
	public void update(String username, String address, int roll) {        
		DBObject query = new BasicDBObject("Roll", roll);		
    	BasicDBObject document = new BasicDBObject();    	
    	document.put("Username", username);    	
    	document.put("Address",address);	    	
    	DBObject update = new BasicDBObject();
    	update.put("$set", document);	
    	collection.update(query, update);
	}
	
	public int findEmployeeCount(int roll) {	
		DBObject query = new BasicDBObject("Roll", roll);
		return collection.find(query).count();
	}
	
	public ArrayList<Employee> findAll() 
	{
		DBCursor cursor = collection.find();
		ArrayList<Employee> emplist = new ArrayList<Employee>();
						
		while (cursor.hasNext()) 
		    {
			DBObject empDBObject = cursor.next();	 
			  Employee employee = new Employee();			  
			  employee.setUsername(empDBObject.get("Username").toString());
			  employee.setAddress(empDBObject.get("Address").toString());
			  employee.setRollNumber(empDBObject.get("Roll").toString());
			  emplist.add(employee);
	        	}
		return emplist;
		
	}
	
	}
