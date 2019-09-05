package com.decipher.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Connection {

	public DBCollection getCollection()
	{
			MongoClient conn = null;
			DBCollection col = null;
		try {
		 // connecting database
     
			conn = new MongoClient();
			 @SuppressWarnings("deprecation")
			DB db = conn.getDB("EMPLOYEE");	  
			  col = db.getCollection("employee");

		     }
		
		catch(Exception e)
		{
			e.printStackTrace();
	   }
		
		return col;
	}
}
	
	
