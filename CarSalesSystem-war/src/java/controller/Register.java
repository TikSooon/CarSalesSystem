/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.CustomerFacade;
import fascade.SalesmanFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import model.Customer;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @EJB
    private SalesmanFacade salesmanFacade;

    @EJB
    private CustomerFacade customerFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String type = request.getParameter("type");
            String username = request.getParameter("username");
            try{
                if (type.equals("salesman")){
                    Salesman found = salesmanFacade.searchByUsername(username);
                    if(found!=null){
                        System.out.println(found.getId());
                        throw new IllegalArgumentException();
                    }
                }
                else {
                    Customer found = customerFacade.searchByUsername(username);
                    if(found!=null){
                        System.out.println(found.getId());
                        throw new IllegalArgumentException();
                    }
                }
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String contact = request.getParameter("contact");
                String pass = request.getParameter("password");
                boolean approve = false;
                
                if (!name.matches("^[\\p{L} .'-]+$")) {
                    throw new Exception();
                }                  
                if (!contact.matches("[0-9]+"))  {
                    throw new ArithmeticException();
                }
                if (contact.length()<10 || contact.length()>11){
                    throw new ArithmeticException();
                }
                if (pass.length() < 8 || pass.length() == 0){
                    throw new NumberFormatException();
               }
                
                if (type.equals("salesman")){
                    Salesman x = new Salesman(username,name,pass,email,contact,approve);
                    salesmanFacade.create(x);
                }
                else{
                    Customer y = new Customer(username,name,pass,email,contact,approve);
                    customerFacade.create(y);
                }
                
                request.getRequestDispatcher("login.jsp").include(request, response);
                out.println("<br>Dear "+name+", your registration is done!");
            }catch(Exception e){
                request.getRequestDispatcher("register.jsp").include(request, response);
                if(e instanceof NumberFormatException){
                    out.println("<br>Sorry "+username+", password should at least 8 letters!");
                } else if(e instanceof IllegalArgumentException){
                    out.println("<br>Sorry "+username+", your details has been registered!");
                } else if(e instanceof ArithmeticException){
                    out.println("<br>Sorry "+username+", please enter a valid contact number!");
                } else if (e instanceof Exception){
                    out.println("<br>Sorry "+username+", your name must be fully letters!");
                }
            }
        }
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
