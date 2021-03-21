

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
                request.getRequestDispatcher("searchstudent.html").include(request, response);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
                out.println("<center>");
		if(bean.getRollno()>0){ 
                 out.println("<br>");   
		out.println("<table class='table table-bordered table-striped' style=\"width:auto\">");
		out.print("<tr><td>Rollno :</td><td>"+bean.getRollno()+"</td></tr>");
		out.print("<tr><td>Name :</td><td>"+bean.getName()+"</td></tr>");
		out.print("<tr><td>Email :</td><td>"+bean.getEmail()+"</td></tr>");
		out.print("<tr><td>Sex :</td><td>"+bean.getSex()+"</td></tr>");
		out.print("<tr><td>Course :</td><td>"+bean.getCourse()+"</td></tr>");
		out.print("<tr><td>Fee :</td><td>"+bean.getFee()+"</td></tr>");
                out.print("<tr><td>Paid :</td><td>"+bean.getPaid()+"</td></tr>");
                out.print("<tr><td>Due :</td><td>"+bean.getDue()+"</td></tr>");
		out.print("</table>");
		}
                else{
                    out.println("<br>");
                    out.println("<div class=\"alert alert-danger alert-dismissible\">");
                 out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
                 out.println("<strong>Roll no :"+rollno+"</strong> is Not found!!");
                 out.println("</div>");
		}
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
