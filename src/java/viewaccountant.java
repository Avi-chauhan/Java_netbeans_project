/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Admin
 */
public class viewaccountant extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Accountant</title>");
		 out.println("<meta name='viewport' content=\"width=device-width, initial-scale=1.0\">");
               out.println( "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
  out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
  out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
  out.println("<script src=\"https://code.iconify.design/1/1.0.7/iconify.min.js\"></script>");
 		
                out.println("</head>");
		out.println("<body><br><br>");
//		request.getRequestDispatcher("adminportal.html").include(request, response);
		out.print("<center>");
		out.print("<h1>View Accountant(s)</h1>");
                out.print("<br>");
                out.print("<a class='btn btn-primary' href='adminportal.html' >");
               out.print("<span class=\"iconify\" data-icon=\"clarity:home-solid\" data-inline=\"false\"></span> Home</a>");
	        
               out.println("</center>");
		List<acc_info> list=acc_db.getAllRecords();
                out.print("<br>");
                out.print("<div class=\"table table-striped\">");
		out.println("<table class=\"table\">");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Address</th><th>Contact</th><th>Edit</th><th>Delete</th>");
		for(acc_info bean:list){
			out.print("<tr class=\"success\"><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a class=\"btn btn-info\" href='editaccform?id="+bean.getId()+"'><span class=\"iconify\" data-icon=\"fa-solid:edit\" data-inline=\"false\"></span> Edit</a></td><td><a class=\"btn btn-danger\" href='deleteaccountant?id="+bean.getId()+"'><span class=\"iconify\" data-icon=\"ic:baseline-delete\" data-inline=\"false\"></span> Delete</a></td></tr>");
		}
		out.println("</table>");
	        out.print("</div>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
