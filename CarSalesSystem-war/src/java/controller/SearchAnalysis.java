/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import fascade.SalesmanFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@WebServlet(name = "SearchAnalysis", urlPatterns = {"/SearchAnalysis"})
public class SearchAnalysis extends HttpServlet {

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
            HttpSession s = request.getSession();
            String search = request.getParameter("search");
            String filter = request.getParameter("filter");
            List<Salesman> salesman = salesmanFacade.searchByName(search);
            List<Analysis> analysis = (List<Analysis>) s.getAttribute("result");
            List<Analysis> result = new ArrayList();
            
            
            if (!salesman.isEmpty()){
                for (int i = 0; i < analysis.size(); i++){
                    Salesman sales = analysis.get(i).getSales();
                    for (int j = 0; j < salesman.size(); j++){
                        Salesman sales2 = salesman.get(j);
                        if (sales.equals(sales2)){
                            result.add(analysis.get(i));
                            break;
                        }
                    }
                }
            } else {
                result = analysis;
            }
            
            switch (filter) {
                case "none":
                    request.setAttribute("analysisresult", result);
                    break;
                case "revenue":
                    {
                        int max = 0;
                        List<Analysis> sortList = new ArrayList();
                        for (int x = 0; x < result.size(); x++){
                            Analysis a = result.get(x);
                            int y = Integer.parseInt(a.getPrice());
                            if (y > max){
                                max = y;
                                sortList.add(0,result.get(x));
                            } else {
                                sortList.add(result.get(x));
                            }
                        }       request.setAttribute("analysisresult", sortList);
                        break;
                    }
                case "carsold":
                    {
                        int max = 0;
                        List<Analysis> sortList = new ArrayList();
                        for (int x = 0; x < result.size(); x++){
                            Analysis a = result.get(x);
                            int y = Integer.parseInt(a.getCarsold());
                            if (y > max){
                                max = y;
                                sortList.add(0,result.get(x));
                            } else {
                                sortList.add(result.get(x));
                            }
                        }       request.setAttribute("analysisresult", sortList);
                        break;
                    }
                case "rating":
                    {
                        double max = 0;
                        List<Analysis> sortList = new ArrayList();
                        for (int x = 0; x < result.size(); x++){
                            Analysis a = result.get(x);
                            double y = Double.parseDouble(a.getRating());
                            if (y > max){
                                max = y;
                                sortList.add(0,result.get(x));
                            } else {
                                sortList.add(result.get(x));
                            }
                        }       request.setAttribute("analysisresult", sortList);
                        break;
                    }
                default:
                    break;
            }
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
