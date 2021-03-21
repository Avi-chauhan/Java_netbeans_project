

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class duefee extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Student</title>");
		 out.println("<meta name='viewport' content=\"width=device-width, initial-scale=1.0\">");
               out.println( "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
  out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
  out.println("<script src=\"https://code.iconify.design/1/1.0.7/iconify.min.js\"></script>");

		out.println("</head>");
		out.println("<body>");
                out.println("<center>");
		out.println("<br>");
                 out.print("<a class='btn btn-primary btn-lg' href=\"accountantportal.html\" >");
               out.print("<span class=\"iconify\" data-icon=\"clarity:home-solid\" data-inline=\"false\"></span> Home</a>");
               	out.println("<br>");
                
		out.print("<h1>Student(s) having Due Fees</h1>");
	        out.println("</center>");
                out.println("<br>");
		List<student_info> list=student_db.getDues();
		out.println("<table class=\"table table-striped\">");
		out.print("<tr><th>Rollno</th><th>Name</th><th>Email</th><th>Sex</th><th>Course</th><th>Fee</th><th>Paid</th><th>Due</th><th>Address</th><th>Contact</th><th>Edit</th><th>Delete</th>");
		for(student_info bean:list){
			out.print("<tr><td>"+bean.getRollno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getSex()+"</td><td>"+bean.getCourse()+"</td><td>"+bean.getFee()+"</td><td>"+bean.getPaid()+"</td><td>"+bean.getDue()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a class=\"btn btn-info\" href='editstudent1?rollno="+bean.getRollno()+"'><span class=\"iconify\" data-icon=\"fa-solid:edit\" data-inline=\"false\"></span>Edit</a></td><td><a class=\"btn btn-danger\" href='deletestudent?rollno="+bean.getRollno()+"'><span class=\"iconify\" data-icon=\"ic:baseline-delete\" data-inline=\"false\"></span>Delete</a></td></tr>");
		}
		out.println("</table>");
		
	
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
