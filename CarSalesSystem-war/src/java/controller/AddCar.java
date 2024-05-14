/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.CarFacade;
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
import model.Car;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "AddCar", urlPatterns = {"/AddCar"})
public class AddCar extends HttpServlet {

    @EJB
    private CarFacade carFacade;

    @EJB
    private SalesmanFacade salesmanFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             try{
                String brand = request.getParameter("brand");
                String model = request.getParameter("model");
                String caryear = request.getParameter("caryear");
                String price = request.getParameter("price");
                String status = "Available";
                
                if (!brand.matches("^[\\p{L} .'-]+$")) {
                    throw new Exception();
                }                  
                if (!price.matches("[0-9]+") && !caryear.matches("(19[789]\\d|20[01]\\d)"))  {
                    throw new NumberFormatException();
                } else if (Integer.parseInt(caryear) > 2023){
                    throw new NumberFormatException();
                }
//                
//                if(price < 0){
//                    throw new ArithmeticException();
//                }
//                
//                if(caryear<=1950 || caryear>=2023){
//                    throw new ArithmeticException();
//                }
                
                
                long salesman = Long.parseLong(request.getParameter("salesman"));
                Salesman y = salesmanFacade.find(salesman);
                
                Car z = new Car(brand,model,caryear,price,status,y);
                carFacade.create(z);
                
                String message = "Car successfully added!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("ManageCars").include(request, response);
                
            }catch(Exception e){
                if(e instanceof NumberFormatException){
                    String message = "Please enter a valid manufacturing year or price!";
                    request.setAttribute("message", message);
                } else if (e instanceof Exception){
                    String message = "Please enter brand with no numbers!";
                    request.setAttribute("message", message);
                }
                request.getRequestDispatcher("RetrieveSalesmanName").include(request, response);
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
