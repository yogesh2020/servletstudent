package com.decipher.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.decipher.dao.Connection;
import com.decipher.service.EmployeeService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;


/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService = new EmployeeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {

        super();
//		System.out.println("Continous");

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	System.out.println("this is Get method");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		String username= request.getParameter("username");  
        String address = request.getParameter("address");  
        int roll = Integer.parseInt(request.getParameter("roll"));  
		int count = employeeService.add(username, address, roll);
		if(count>0){
			 response.sendRedirect("idexists.jsp");
		} else {
			 response.sendRedirect("datainsert.jsp");
		}
	}

}
