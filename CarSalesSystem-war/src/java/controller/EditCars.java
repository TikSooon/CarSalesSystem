/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.CarFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "EditCars", urlPatterns = {"/EditCars"})
public class EditCars extends HttpServlet {

    @EJB
    private CarFacade carFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            long id = Long.parseLong(request.getParameter("id"));
            try{
                Car found = carFacade.find(id);
                String brand = request.getParameter("brand");
                String model = request.getParameter("model");     
                String caryear = request.getParameter("caryear");
                String price = request.getParameter("price");

                if (!brand.matches("^[\\p{L} .'-]+$")) {
                    throw new Exception();
                }                  
                if (!price.matches("[0-9]+") && caryear.matches("[0-9]+"))  {
                    throw new NumberFormatException();
                } else if (Integer.parseInt(caryear) > 2023){
                    throw new NumberFormatException();
                }
                
                found.setBrand(brand);
                found.setModel(model);
                found.setCaryear(caryear);
                found.setPrice(price);

                carFacade.edit(found);
                
                String message = "Car details amended!";
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
                request.getRequestDispatcher("RetrieveCar?id="+String.valueOf(id)).include(request, response);     
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
