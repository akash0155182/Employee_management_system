package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.EmployeeService;

@WebServlet("/delete")
public class DeleteDetails extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		
		EmployeeService service= new EmployeeService();
		if(service.Delete(id1)!=0)
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("WelcomeEmp.html");
			dispatcher.forward(req, resp);
		}
		else {
			PrintWriter print=resp.getWriter();
			print.print("<h1> data is not deleted</h1>");
		}
	}
}
