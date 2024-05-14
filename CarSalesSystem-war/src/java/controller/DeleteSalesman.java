/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.CarFacade;
import fascade.SalesmanFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import model.Customer;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "DeleteSalesman", urlPatterns = {"/DeleteSalesman"})
public class DeleteSalesman extends HttpServlet {

    @EJB
    private CarFacade carFacade;

    @EJB
    private SalesmanFacade salesmanFacade;

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
            Salesman found = salesmanFacade.find(id);
            List<Car> car = carFacade.findAll();
            boolean x = true;
            for (int i = 0; i < car.size(); i++ ){
                Salesman sales = car.get(i).getSalesman();
                if (sales.equals(found)){
                    x = false;
                    break;
                }
            }
            String message = "";
            if (x == true){
                salesmanFacade.remove(found);
                message = "Salesman has been deleted!";
            } else{
                message = "Salesman cannot be deleted because there are cars assigned under salesman name!";
            }
            
            request.setAttribute("message", message);
            request.getRequestDispatcher("ManageSalesman").include(request, response);
            
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
