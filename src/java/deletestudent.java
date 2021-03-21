
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class deletestudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String srollno=request.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		student_db.delete(rollno);
		response.sendRedirect("viewstudent");
	}
}
