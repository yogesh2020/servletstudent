package com.decipher.service;

import java.util.ArrayList;

import com.decipher.dao.EmployeeDao;
import com.decipher.model.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDao();   //private
	
	public int add(String username, String address, int roll)
	{
		int count = employeeDao.findEmployeeCount(roll);
		if(count == 0) {
			employeeDao.add(username, address, roll);
		}
		return count;
	}	
	
	public int delete(int roll)
	{
		int count = employeeDao.findEmployeeCount(roll);
		if(count == 1) {
			employeeDao.delete(roll);
		}
		return count;
	}	
	
	public void update(String username, String address, int roll)
	{
		employeeDao.update(username,address,roll);
	}
	
	public int checkExistence(int roll)
	{
		return employeeDao.findEmployeeCount(roll);
	}
	
	public ArrayList<Employee> display()
	{
		
		return employeeDao.findAll();
	}
				
}
