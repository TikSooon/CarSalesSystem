/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.CarFacade;
import fascade.CustomerFacade;
import fascade.PaymentFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.Customer;
import model.Payment;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "CollectPayment", urlPatterns = {"/CollectPayment"})
public class CollectPayment extends HttpServlet {

    @EJB
    private PaymentFacade paymentFacade;

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private CarFacade carFacade;

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
            long carid = Long.parseLong(request.getParameter("id"));
            Car car = carFacade.find(carid);
           
            String pattern = "dd-MM-yyyy hh:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            String comments = request.getParameter("comment");
            Customer cust = car.getBookedcustomer();
            Salesman salesman = car.getSalesman();
            String rating = "0";
            String feedback = "";
            Payment pay = new Payment(cust,salesman,car,date,comments,feedback,rating);
            paymentFacade.create(pay);
            car.setStatus("Paid");
            carFacade.edit(car);
            String message = "Payment has been collected!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("SalesmanPayment").include(request, response);

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
