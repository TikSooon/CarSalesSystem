/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.CustomerFacade;
import fascade.SalesmanFacade;
import fascade.StaffFacade;
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
import model.Staff;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private StaffFacade staffFacade;

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private SalesmanFacade salesmanFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");;
            String type = request.getParameter("type");
            request.setAttribute("type",type);
            long id = 0;
            try{
                switch (type) {
                    case "staff":
                        {
                            Staff found = staffFacade.searchByUsername(username);
                            if(found == null){
                                throw new Exception();
                            }       
                            String password = request.getParameter("password");
                            if(!(password.equals(found.getPassword()))){
                                throw new Exception();
                            }       
                            id = found.getStaffid();
                            break;
                        }
                    case "salesman":
                        {
                            Salesman sales = salesmanFacade.searchByUsername(username);
                            if(sales == null){
                                throw new Exception();
                            }      
                            boolean approved = sales.isApproved();
                            if (approved == false){
                                throw new IllegalArgumentException();
                            }      
                            String password = request.getParameter("password");
                            if(!(password.equals(sales.getPassword()))){
                                throw new Exception();
                            }       
                            id = sales.getId();
                            break;
                        }
                    case "customer":
                        {
                            Customer cust = customerFacade.searchByUsername(username);
                            if(cust == null){
                                throw new Exception();
                            }       
                            boolean approved = cust.isApproved();
                            if (approved == false){
                                throw new IllegalArgumentException();
                            }      
                            String password = request.getParameter("password");
                            if(!(password.equals(cust.getPassword()))){
                                throw new Exception();
                            }       
                            id = cust.getId();
                             
                            break;
                        }
                }
                    
                HttpSession s = request.getSession();
                s.setAttribute("username", username);
                s.setAttribute("id", id);
                s.setAttribute("type", type);
                
                request.getRequestDispatcher("Home").include(request, response);
                
                out.println("<br><br>Hello "+username+", welcome to Car Sales System!");
            }catch(Exception e){
                request.getRequestDispatcher("login.jsp").include(request, response);
                if(e instanceof IllegalArgumentException){
                    out.println("<br><br><br>Sorry "+username+", your account has not been approved!");
                } else {
                    out.println("<br><br><br>Check again your username and / or password!");
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
