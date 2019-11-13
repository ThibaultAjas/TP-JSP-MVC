/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yay.jsp.mvc;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import yay.jsp.mvc.resources.DAO;
import yay.jsp.mvc.resources.DataSourceFactory;
import yay.jsp.mvc.resources.RateEntity;
import yay.jsp.mvc.resources.Rates;

/**
 *
 * @author Dalfrak
 */
@WebServlet(name = "MyServiette", urlPatterns = {"/"})
public class MyServiette extends HttpServlet {

    public static final String ATT_FORM = "addRate";
    public static final String ATT_RATE = "rate";
    public static final String ATT_CODE = "code";
    public static final String ATT_TAUX = "taux";
    public static final String VIEW = "WEB-INF/rates.jsp";

    private DAO myDAO;
    private Rates ratesList;

    @Override
    public void init() {
        myDAO = new DAO(DataSourceFactory.getDataSource());
        ratesList = myDAO.getRates();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration<String> params = request.getParameterNames();

        while (params.hasMoreElements())
            if (params.nextElement().equals("action"))
                switch (request.getParameterValues("action")[0]) {
                    case "ADD":
                        ratesList = myDAO.addRate(new RateEntity(request.getParameter(ATT_CODE), Float.parseFloat(request.getParameter(ATT_TAUX).replace(',', '.'))));
                        break;
                    case "DELETE":
                        ratesList = myDAO.deleteRate(new RateEntity(request.getParameter(ATT_CODE), Float.parseFloat(request.getParameter(ATT_TAUX).replace(',', '.'))));
                        break;
                    case "UPDATE":
                        ratesList = myDAO.updateRate(new RateEntity(request.getParameter(ATT_CODE), Float.parseFloat(request.getParameter(ATT_TAUX).replace(',', '.'))));
                        break;
                    default:
                        break;
                }

        request.setAttribute("rates", ratesList);
        request.getRequestDispatcher(VIEW).forward(request, response);
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
