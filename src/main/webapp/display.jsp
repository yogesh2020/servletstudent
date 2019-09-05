<!DOCTYPE html>
<%@page import="com.decipher.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>
</head>
<body align="center">
    </head>
    <body>

<table>
  <tr>    
    <th>Roll No</th>
    <th>Username</th>
    <th>Address</th>
  </tr>
  
   <% 
  ArrayList<Employee> emplist =(ArrayList<Employee>) session.getAttribute("employeeList");
	for(Employee empp: emplist) {
		  %>
		  <tr>
			  <td> <%=empp.getRollNumber()%></td>
			  <td> <%=empp.getUsername()%></td>
			  <td><%=empp.getAddress()%> </td>
		  </tr>		  
		  <%
		  }
%>	
  
  
</table>
<br>
<button onclick="location='./index.jsp'">HomePage</button>
</body>
</html>