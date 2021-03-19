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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        
         try (PrintWriter out = response.getWriter()) {
           
            
            String role=request.getParameter("Person");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
                        
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Redirected after Login</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if("Accountant".equals(role))
            {                  
		if("acc@gmail.com".equals(email) && "123".equals(password)){
			HttpSession session=request.getSession();
			session.setAttribute("accountant","true");
                        out.println("<p>Accountant Login Successful.....</p>");
			request.getRequestDispatcher("accountantportal.html").forward(request, response);
		}else{
			
			out.println("<p>Sorry, username or password error!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
                
                
            }
            else if("Admin".equals(role))
            {
                
		if(email.equals("admin@gmail.com")&&password.equals("123456")){
			HttpSession session=request.getSession();
			session.setAttribute("admin","true");
                        out.println("<p>Admin Login Successful.....</p>");
			request.getRequestDispatcher("adminportal.html").forward(request, response);
		}else{
			out.println("<p>Sorry, username or password error!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}

            }

            out.println("</body>");
            out.println("</html>");             
        }
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
