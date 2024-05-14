/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.PaymentFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Payment;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "RetrievePayment", urlPatterns = {"/RetrievePayment"})
public class RetrievePayment extends HttpServlet {

    @EJB
    private PaymentFacade paymentFacade;

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
            HttpSession s = request.getSession();
            long id = Long.parseLong(request.getParameter("id"));
            String status = (String)s.getAttribute("type");
            Payment found = paymentFacade.find(id);
            request.setAttribute("paymentdata", found);
            if (status.equals("salesman")){
                if (found.getCar().getStatus().equals("Booked")){
                    request.getRequestDispatcher("collectpayment.jsp").include(request, response);
                } else {
                    String message = "Only booked cars can make payments!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("SalesmanSearchCar").include(request, response);
                }
            } else {
                if (found.getFeedback().isEmpty()){
                    request.getRequestDispatcher("feedback.jsp").include(request, response);
                } else {
                    String message = "Feedback to this payment has been submitted!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("CustomerPayment").include(request, response);
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
