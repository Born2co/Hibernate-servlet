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

@WebServlet("/selectserv")
public class SelectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  empno=Integer.parseInt(request.getParameter("empno"));

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		EmployeeDAO dao=EmployeeDAOFactory.getInstance();
		Employee e=dao.findEmployee(empno);
		if(e!=null){
			out.println("<h1>");
			out.println(e.getDeptNumber()+" "+e.getEmployeeName()+" "+e.getEmployeeNumber()+" "+e.getEmployeeSalary());
			out.println("</h1>");
			
		}else{
			out.println("<h1>sorry..! Employee not found please inpuut proper employee number</h1>");
		}out.close();
	
		
		


	}

}
