/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class editaccform extends HttpServlet {

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
        String sid=request.getParameter("id");
	int id=Integer.parseInt(sid);
	acc_info bean=acc_db.getRecordById(id);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           out.println("<!DOCTYPE html>");
           out.println("<html>");
           out.println("<head>");
           out.println("<title>Edit accountant Form</title>"); 
           out.println("<meta name='viewport' content=\"width=device-width, initial-scale=1.0\">");
           out.println( "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
           out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
           out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
           out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
           out.println("<script src='https://code.iconify.design/1/1.0.7/iconify.min.js'></script>");

 out.println("</head>");
            out.println("<body>");
            out.println("<br>");
            out.println("<center>");
            
//            request.getRequestDispatcher("adminportal.html").include(request, response);
		
		
		out.print("<h1>Edit Accountant Form</h1>");
		out.print("<form action='editacc' method='post'> ");
		out.print("<div class=\"form-group\">");
                
                out.println("<div class=\"col-sm-3\">");
		out.print("<label for=\"inputFirstname\">id: </label><input type='text' class=\"form-control\" name='id' value='"+bean.getId()+"'/>");
                out.println("</div>");
		
                out.println("<div class=\"col-sm-3\">");
		out.print("<label for=\"inputFirstname\">Name: </label><input type='text' class=\"form-control\" name='name' value='"+bean.getName()+"'/>");
                out.println("</div>");
                
                out.println("<div class=\"col-sm-3\">");
		out.print("<label for=\"b\">Email: </label><input id=\"b\" type='email' class=\"form-control\" name='email' value='"+bean.getEmail()+"'/>");
		out.println("</div>");
                
                out.println("<div class=\"col-sm-3\">");
                out.print("<label for=\"inputFirstname\">Password: </label><input id=\"inputFirstname\" class=\"form-control\" type='text' name='password' value='"+bean.getPassword()+"'/>");
		out.println("</div>");
                
                out.println("<div class=\"col-sm-3\">");
                out.print("<label for=\"d\">Address: </label><textarea name='address' class=\"form-control\" style='width:350px;height:100px;'>"+bean.getAddress()+"</textarea>");
		out.println("</div>");
                
                
                out.println("<div class=\"col-sm-3\">");
                out.print("<label for=\"c\">Contact: </label><input type='text' class=\"form-control\" name='contact' value='"+bean.getContact()+"'/>");
		out.println("</div>");
                out.print("</div>");
                out.println("<br>");
                out.println("<button class=\"btn btn-success\" type=\"submit\">\n" +
"            <span class=\"iconify\" data-icon=\"bx:bxs-edit-alt\" data-inline=\"false\">\n" +
"            </span>\n" +
"            Update Accountant\n" +
"        </button> ");
		
		out.print("</form>");
		out.println("</center>");
            out.println("</body>");
            out.println("</html>");
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
