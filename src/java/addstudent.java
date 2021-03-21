
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.StudentDao;*/

import java.sql.*;

public class addstudent extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
                out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Added</title>");
                out.println("<meta name='viewport' content=\"width=device-width, initial-scale=1.0\">");
               out.println( "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
 out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
 out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
		out.println("</head>");
		out.println("<body>");
                
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String sex=request.getParameter("Sex");
		String course=request.getParameter("course");
		int fee=Integer.parseInt(request.getParameter("fee"));
		int paid=Integer.parseInt(request.getParameter("paid"));
		int due=fee-paid;
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		student_info bean=new student_info(name, email, sex, course, fee, paid, due, address, contact);
		int status=student_db.save(bean);
		if(status==0)
                {
                 out.println("<div class=\"alert alert-danger alert-dismissible\">");
                 out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
                 out.println("<strong>Error while adding Student !!</strong>");
                 out.println("</div>");
                }
                else
                {
                 out.println("<div class=\"alert alert-success alert-dismissible\">");
                 out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
                 out.println("<strong>Student added successfully !</strong>");
                 out.println("</div>");
                }
		
		request.getRequestDispatcher("addstudent.html").include(request, response);
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
