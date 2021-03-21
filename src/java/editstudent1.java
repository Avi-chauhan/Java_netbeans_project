

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class editstudent1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String srollno=request.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		student_info bean=student_db.getRecordByRollno(rollno);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
                
		out.println("<title>Edit Student Form</title>");
		out.println("<meta name='viewport' content=\"width=device-width, initial-scale=1.0\">");
                out.println( "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
                out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
                out.println("<script src='https://code.iconify.design/1/1.0.7/iconify.min.js'></script>");

		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		
		
		out.print("<h1>Edit Student Form</h1>");
		out.print("<form action='editdb' method='post'>");
                out.print("<div class=\"form-group\">");
                
                out.print("<div class=\"table table-striped\">");
		out.println("<table class=\"table\" style='width:auto'>");
                out.print("<input type='hidden' name='rollno' value='"+bean.getRollno()+"'/>");
                out.print("<tr><td>Name:</td><td><div class=\"col-sm-10\"><input type='text' class=\"form-control\" name='name' value='"+bean.getName()+"'/></div></td></tr>");
		out.print("<tr><td>Email:</td><td><div class=\"col-sm-10\"><input type='email' class=\"form-control\" name='email' value='"+bean.getEmail()+"'/></div></td></tr>");
		out.print("<tr><td>Sex:</td><td><div class=\"col-sm-10\"><input type='text' class=\"form-control\" name='sex' value='"+bean.getSex()+"'/></div></td></tr>");
		out.print("<tr><td>Course:</td><td><div class=\"col-sm-10\"><input type='text' class=\"form-control\" name='course' value='"+bean.getCourse()+"'/></div></td></tr>");
		out.print("<tr><td>Fee:</td><td><div class=\"col-sm-10\"><input type='number' class=\"form-control\" name='fee' value='"+bean.getFee()+"'/></div></td></tr>");
		out.print("<tr><td>Paid:</td><td><div class=\"col-sm-10\"><input type='number' class=\"form-control\" name='paid'  value='"+bean.getPaid()+"'/></div></td></tr>");
		out.print("<tr><td>Address:</td><td><div class=\"col-sm-10\"><textarea name='address' class=\"form-control\" style='width:300px;height:100px;'>"+bean.getAddress()+"</textarea></div></td></tr>");
		out.print("<tr><td>Contact No:</td><td><div class=\"col-sm-10\"><input type='text' class=\"form-control\" name='contact' value='"+bean.getContact()+"'/></div></td></tr>");
		out.print("<tr><td colspan='2' align='center'><button class=\"btn btn-success btn-lg\" type=\"submit\">\n" +
"            <span class=\"iconify\" data-icon=\"el:edit\" data-inline=\"false\">\n" +
"            </span>\n" +
"            Update\n" +
"           </button> </td></tr>");
		out.print("</table>");
                out.print("</div>");
		out.print("</form>");
		out.println("</table>");
		
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
				
		out.close();
	}

}
