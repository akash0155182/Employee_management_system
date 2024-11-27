package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Details;
import com.Service.EmployeeService;

@WebServlet("/save")
public class SaveEmployeeDetails extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String email=req.getParameter("email");
		String salary=req.getParameter("salary");
		
		int ids=Integer.parseInt(id);
		int ages=Integer.parseInt(age);
		double sal=Double.parseDouble(salary);
		
	    Details d= new Details(ids,name,ages,email,sal);
	    EmployeeService employee=new EmployeeService();
	    int rowUpdate=employee.addEmployee(d);
	    System.out.println(rowUpdate);
	    
	    if(rowUpdate!=0)
	    {
	    	RequestDispatcher request=req.getRequestDispatcher("WelcomeEmp.html");
	    	request.forward(req, resp);
	    }
	    else {
	    	PrintWriter print=resp.getWriter();
	    	print.print("<h1>data is note saved</h1>");
	   
	    }
		
	}
}
