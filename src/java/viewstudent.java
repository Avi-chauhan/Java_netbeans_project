

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class viewstudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Student</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		
                out.println("<a href=\"accountantportal.html\" >Home</a>");
		out.println("<div class='container'>");
		
		out.print("<h1>View Students</h1>");
	
		List<student_info> list=student_db.getAllRecords();
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Rollno</th><th>Name</th><th>Email</th><th>Sex</th><th>Course</th><th>Fee</th><th>paid</th><th>due</th><th>address</th><th>contact</th><th>Edit</th><th>Delete</th>");
		for(student_info bean:list){
			out.print("<tr><td>"+bean.getRollno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getSex()+"</td><td>"+bean.getCourse()+"</td><td>"+bean.getFee()+"</td><td>"+bean.getPaid()+"</td><td>"+bean.getDue()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a href='editstudentform?rollno="+bean.getRollno()+"'>Edit</a></td><td><a href='deletestudent?rollno="+bean.getRollno()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
	
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
