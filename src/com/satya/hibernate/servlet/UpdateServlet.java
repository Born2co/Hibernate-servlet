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

@WebServlet("/updateserv")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  empno=Integer.parseInt(request.getParameter("empno"));

		//String name=request.getParameter("ename");
		
		int sal=Integer.parseInt(request.getParameter("sal"));
		
		//int deptno=Integer.parseInt(request.getParameter("deptno"));
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		/*
		Employee e=new Employee();
		e.setEmployeeNumber(empno);
		//e.setEmployeeName(name);
		e.setEmployeeSalary(sal);
		//e.setDeptNumber(deptno);
		
		*/
		EmployeeDAO dao=EmployeeDAOFactory.getInstance();
		int k=dao.updateEmployee(empno,sal);
		if(k>0)
		{
			out.println("<h1>details Updated successfully</h1>");
		}
			else {
				out.println("<h1>sorry ..! try again</h1>");
			//	out.println("<a href= "./index.html">Home</a>");
			}
			out.close();

}
}