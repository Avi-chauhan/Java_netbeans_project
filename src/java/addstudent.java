
import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String course=request.getParameter("course");
		int fee=Integer.parseInt(request.getParameter("fee"));
		int paid=Integer.parseInt(request.getParameter("paid"));
		int due=Integer.parseInt(request.getParameter("due"));
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		student_info bean=new student_info(name, email, sex, course, fee, paid, due, address, contact);
		int status=student_db.save(bean);
		
		out.println("Student is added successfully!");
		
		request.getRequestDispatcher("addstudent.html").include(request, response);
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
