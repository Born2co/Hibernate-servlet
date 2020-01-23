

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

@WebServlet("/insertserv")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read input data
		int empno=Integer.parseInt(request.getParameter("empno"));
		String name=request.getParameter("ename");
		int sal=Integer.parseInt(request.getParameter("sal"));
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		//set MIME type
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Employee e=new Employee();
		e.setEmployeeNumber(empno);
		e.setEmployeeName(name);
		e.setEmployeeSalary(sal);
		e.setDeptNumber(deptno);
		//read dao object
		EmployeeDAO dao=EmployeeDAOFactory.getInstance();
		//call save Employee() method
		boolean flag=dao.saveEmployeeDAO(e);
		if(flag)
		{
			out.println("<h1>Employee saved</h1>");
		}
			else {
				out.println("<h1>Employee not saved</h1>");
			//out.println("<a href= "./index.html">Home</a>");
			}
			out.close();
			}
	
	}
