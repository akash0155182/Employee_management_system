package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Details;
import com.Service.EmployeeService;

@WebServlet("/display")
public class DisplayDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeService service = new EmployeeService();
        List<Details> d = service.display();
        resp.setContentType("text/html");

        PrintWriter print = resp.getWriter();
        print.println("<html>");
        print.println("<head>");
        print.println("<title>Employee Details</title>");
        print.println("<style>");
        print.println("body { font-family: Arial, sans-serif; background-color: #f9f9f9; margin: 0; padding: 20px; }");
        print.println("h1 { text-align: center; color: #333; }");
        print.println("table { border-collapse: collapse; width: 90%; margin: 20px auto; }");
        print.println("th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }");
        print.println("th { background-color: #4CAF50; color: white; }");
        print.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        print.println("tr:hover { background-color: #ddd; }");
        print.println("button { padding: 5px 10px; font-size: 14px; margin: 2px; cursor: pointer; border: none; border-radius: 5px; }");
        print.println(".update-btn { background-color: #007BFF; color: white; }");
        print.println(".delete-btn { background-color: #DC3545; color: white; }");
        print.println(".update-btn:hover { background-color: #0056b3; }");
        print.println(".delete-btn:hover { background-color: #c82333; }");
        print.println("</style>");
        print.println("</head>");
        print.println("<body>");
        print.println("<h1>Employee Details</h1>");
        print.println("<table>");
        print.println("<tr>");
        print.println("<th>ID</th>");
        print.println("<th>Name</th>");
        print.println("<th>Age</th>");
        print.println("<th>Email</th>");
        print.println("<th>Salary</th>");
        print.println("<th>Actions</th>");
        print.println("</tr>");

        for (Details detail : d) {
            print.println("<tr>");
            print.println("<td>" + detail.getId() + "</td>");
            print.println("<td>" + detail.getName() + "</td>");
            print.println("<td>" + detail.getAge() + "</td>");
            print.println("<td>" + detail.getEmail() + "</td>");
            print.println("<td>" + detail.getSalary() + "</td>");
            print.println("<td>");
            print.println("<form action='UpdateEmp.html' method='post' style='display: inline;'>");
            print.println("<input type='hidden' name='id' value='" + detail.getId() + "'>");
            print.println("<button type='submit' class='update-btn'>Update</button>");
            print.println("</form>");
            print.println("<form action='DeleteEmp.html' method='post' style='display: inline;'>");
            print.println("<input type='hidden' name='id' value='" + detail.getId() + "'>");
            print.println("<button type='submit' class='delete-btn'>Delete</button>");
            print.println("</form>");
            print.println("</td>");
            print.println("</tr>");
        }

        print.println("</table>");
        print.println("</body>");
        print.println("</html>");
    }
}
