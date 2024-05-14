/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.CustomerFacade;
import fascade.SalesmanFacade;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "ResetPassword", urlPatterns = {"/ResetPassword"})
public class ResetPassword extends HttpServlet {

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private SalesmanFacade salesmanFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
            HttpSession s = request.getSession();
            long id = (long) s.getAttribute("id");
            String type = (String) s.getAttribute("type");
            String password = request.getParameter("password");
            
            if(password.length() < 8){
                throw new IllegalArgumentException();
            }
            
            String conpassword = request.getParameter("conpassword");
            String message = "<br><br><br>Password has been reset!";
            
            if (type.equals("salesman")){
                Salesman found = salesmanFacade.find(id);
                if (password.equals(conpassword)){
                    found.setPassword(password);
                    salesmanFacade.edit(found);
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("Home").include(request, response);
                    
                } else {
                    throw new Exception();
                }
            } else if (type.equals("customer")){
                Customer found = customerFacade.find(id);
                
                if (password.equals(conpassword)){
                    found.setPassword(password);
                    customerFacade.edit(found);
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("Home").include(request, response);
                    
                } else {
                    throw new Exception();
                }}
            } catch (Exception ex) {
                request.getRequestDispatcher("resetpassword.jsp").include(request, response);
                if(ex instanceof IllegalArgumentException){
                    out.println("<br><br><br>Password must be at least 8 letters!");
                } else { 
                out.println("<br><br><br>Password must be same!");
                }
        }}}

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
