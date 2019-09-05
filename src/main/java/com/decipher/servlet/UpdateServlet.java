package com.decipher.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.decipher.dao.Connection;
import com.decipher.service.EmployeeService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService = new EmployeeService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
        
		if(request.getParameter("button").equals("update")) 
		{        	
		    int roll = Integer.parseInt(request.getParameter("roll"));  
			int count = employeeService.checkExistence(roll); 
			if(count==0){
				 response.sendRedirect("noresult.jsp");
			} else {
				HttpSession session = request.getSession();				
				session.setAttribute("roll",roll);				
				response.sendRedirect("updateform.jsp");
			}
		}
			else {
			
				HttpSession session = request.getSession();
				int roll = Integer.parseInt(session.getAttribute("roll").toString());
				employeeService.update(request.getParameter("username"),request.getParameter("address"),roll);
				response.sendRedirect("updated.jsp");
												
			}			
        		}
                  }
