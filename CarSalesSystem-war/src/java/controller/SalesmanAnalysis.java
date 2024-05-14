/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.PaymentFacade;
import fascade.SalesmanFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Analysis;
import model.Payment;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "SalesmanAnalysis", urlPatterns = {"/SalesmanAnalysis"})
public class SalesmanAnalysis extends HttpServlet {

    @EJB
    private PaymentFacade paymentFacade;

    @EJB
    private SalesmanFacade salesmanFacade;
    private static final DecimalFormat df = new DecimalFormat("0.0");

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            List<Payment> payment = paymentFacade.findAll();
            List<Analysis> analysis = new ArrayList<>();
            for (int i = 0; i < payment.size(); i++){
                int price = 0;
                int car = 0;
                if (analysis.isEmpty() == true){
                    Salesman pay = payment.get(i).getSalesman();
                    price = Integer.parseInt(payment.get(i).getCar().getPrice());
                    car += 1;
                    int rating = Integer.parseInt(payment.get(i).getRating());
                    Analysis a = new Analysis(pay,String.valueOf(price),String.valueOf(car),String.valueOf(rating));
                    analysis.add(a);
                }
                else {
                    boolean x = false;
                    Salesman pay = payment.get(i).getSalesman();
                    for (int j = 0; j < analysis.size(); j++){
                        Salesman sales = analysis.get(j).getSales();

                        if (sales.equals(pay)){
                            Analysis b = analysis.get(j);
                            price = Integer.parseInt(b.getPrice()) + Integer.parseInt(payment.get(i).getCar().getPrice());
                            car = Integer.parseInt(b.getCarsold());
                            car += 1;
                            int rating = Integer.parseInt(b.getRating()) + Integer.parseInt(payment.get(i).getRating());
                            b.setRating(String.valueOf(rating));
                            b.setCarsold(String.valueOf(car));
                            b.setPrice(String.valueOf(price));
                            x = true;
                        }
                    }
                    if (x == false){
                        price = Integer.parseInt(payment.get(i).getCar().getPrice());
                        car += 1;
                        int rating = Integer.parseInt(payment.get(i).getRating());
                        Analysis a = new Analysis(pay,String.valueOf(price),String.valueOf(car),String.valueOf(rating));
                        analysis.add(a);
                    }
                }
            }   
            
            for (int count = 0; count < analysis.size(); count++){
                Analysis t = analysis.get(count);
                double rating = Integer.parseInt(t.getRating());
                double cars = Integer.parseInt(t.getCarsold());
                double avg = rating / cars;
                t.setRating(String.valueOf(df.format(avg)));
            }
            request.setAttribute("analysisresult", analysis);
            HttpSession s = request.getSession();
            s.setAttribute("result", analysis);
            request.getRequestDispatcher("salesmananalysis.jsp").include(request, response);
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
