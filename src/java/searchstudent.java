

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class searchstudent extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String srollno=request.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		student_info bean=student_db.getRecordByRollno(rollno);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Search Student</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href=\"accountantportal.html\" >Home</a>");
		out.println("<div class='container'>");
		
	
		out.println("<h1>Search Student</h1>");
		
		if(bean.getRollno()>0){
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><td>Rollno:</td><td>"+bean.getRollno()+"</td></tr>");
		out.print("<tr><td>Name:</td><td>"+bean.getName()+"</td></tr>");
		out.print("<tr><td>Email:</td><td>"+bean.getEmail()+"</td></tr>");
		out.print("<tr><td>Sex:</td><td>"+bean.getSex()+"</td></tr>");
		out.print("<tr><td>Course:</td><td>"+bean.getCourse()+"</td></tr>");
		out.print("<tr><td>Fee:</td><td>"+bean.getFee()+"</td></tr>");
		out.print("</table>");
		}else{
			out.println("<p>Sorry, No Record found for "+rollno+"</p>");
		}
		
		out.println("</div>");
	
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
