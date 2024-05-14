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
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "EditUsers", urlPatterns = {"/EditUsers"})
public class EditUsers extends HttpServlet {

    @EJB
    private SalesmanFacade salesmanFacade;

    @EJB
    private CustomerFacade customerFacade;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            long id = Long.parseLong(request.getParameter("id"));
            String type = request.getParameter("type");
            
            try{
                if (type.equals("salesman")){
                    Salesman found = salesmanFacade.find(id);
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    String contact = request.getParameter("contact");
                    
                    if (!name.matches("^[\\p{L} .'-]+$")) {
                        throw new Exception();
                    }                  
                    if (!contact.matches("[0-9]+"))  {
                        throw new NumberFormatException();
                    }
                    if (contact.length()<10 || contact.length()>11){
                        throw new NumberFormatException();
                    }
                    found.setName(name);
                    found.setEmail(email);
                    found.setContact(contact);
                    found.setApproved(true);
                    
                    salesmanFacade.edit(found);
                    
                    String message = "Salesman details amended!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("ManageSalesman").include(request, response);
                }
                else if (type.equals("customer")){
                    Customer found = customerFacade.find(id);
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    String contact = request.getParameter("contact");
                    
                    if (!name.matches("^[\\p{L} .'-]+$")) {
                        throw new Exception();
                    }                  
                    if (!contact.matches("[0-9]+"))  {
                        throw new NumberFormatException();
                    }
                    if (contact.length()<10 || contact.length()>11){
                        throw new NumberFormatException();
                    }
                    
                    found.setName(name);
                    found.setEmail(email);
                    found.setContact(contact);
                    found.setApproved(true);
                    
                    customerFacade.edit(found);
                    String message = "Customer details amended!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("ManageCustomer").include(request, response);
                }

                
            }catch(Exception e){
                if(e instanceof NumberFormatException){
                    String message = "Please enter a valid contact! (ex: 0123456789)";
                    request.setAttribute("message", message);
                } else if (e instanceof Exception){
                    String message = "Please enter a name with no numbers!";
                    request.setAttribute("message", message);
                }
                
                if (type.equals("salesman")){
                    request.getRequestDispatcher("RetrieveSalesman?id="+String.valueOf(id)).include(request, response);
                }  else if (type.equals("customer")){
                    request.getRequestDispatcher("RetrieveCustomer?id="+String.valueOf(id)).include(request, response);
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
