package com.satya.hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.satya.hibernate.dao.EmployeeDAO;
import com.satya.hibernate.dao.EmployeeDAOFactory;
import com.satya.hibernate.model.Employee;

@WebServlet("/deleteserv")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int  empno=Integer.parseInt(request.getParameter("empno"));

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Employee e=new Employee();
		e.setEmployeeNumber(empno);
		
		EmployeeDAO dao=EmployeeDAOFactory.getInstance();
		//int k=dao.updateEmployeeDAO(e);
		int k=dao.deleteEmployeeDAO(empno);
		
		
		if(k>0)
		{
			out.println("<h1>Employee is deleted</h1>");
		}
			else {
				out.println("<h1>Employee not deleted</h1>");
			//	out.println("<a href= "./index.html">Home</a>");
			}
			out.close();
			
	
		
		

	}

}
