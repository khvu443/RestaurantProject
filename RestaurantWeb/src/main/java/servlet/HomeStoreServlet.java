/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.RestaurantDAO;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.*;

import model.Product;

@WebServlet(name = "HomeStoreServlet", urlPatterns = {"/HomeStoreServlet"})
public class HomeStoreServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Product> listP = null;

        int page = Integer.parseInt(request.getParameter("page"));
        String sort = request.getParameter("sort");

        System.out.println("page current: " + page);
        System.out.println("sort: " + sort);

        RestaurantDAO dao = new RestaurantDAO();
        List<Product> allP = dao.getAllProduct();

        List<Product> newP = dao.getNewProduct();
        List<String> arr = new ArrayList<>();

        request.setAttribute("page", page);
                int sizePage = allP.size() / 5;
        if (allP.size() % 5 != 0) {
            sizePage++;
        }
        request.setAttribute("sizeProduct", sizePage);
        
        request.setAttribute("sortPage", sort);
        request.setAttribute("newP", newP);

        List<Product> oldP = dao.getAllProduct();
        List<String> arrP = new ArrayList<>();
        for (int i = 0; i < oldP.size(); i++) {
            for (int j = 0; j < newP.size(); j++) {
                if (oldP.get(i).getPID().equals(newP.get(j).getPID())) {
                    arrP.add(oldP.get(i).getPID());
                }
            }
        }

        // remove product sale, only not sale
        for (int i = 0; i < oldP.size(); i++) {
            for (int j = 0; j < arrP.size(); j++) {
                if (oldP.get(i).getPID().equals(arrP.get(j))) {
                    oldP.remove(i);
                }
            }
        }
        
        request.setAttribute("oldP", oldP);

        switch (sort) {

            case "all":
                for (int i = 0; i <= (allP.size() / 5); ++i) {
                    if (((page - 1) == i)) {
                        listP = dao.getProductPage(i * 5);
                    }
                }
                request.setAttribute("allSort", "selected");
                break;

            case "new":
                for (int i = 0; i <= (allP.size() / 5); ++i) {
                    if (((page - 1) == i)) {
                        listP = dao.sortProductByDate(i * 5);
                    }
                }
                request.setAttribute("newSort", "selected");
                break;

            case "low":
                for (int i = 0; i <= (allP.size() / 5); ++i) {
                    if (((page - 1) == i)) {
                        listP = dao.sortProductAscByPrice(i * 5);
                    }
                }
                request.setAttribute("lowSort", "selected");
                break;

            case "high":
                for (int i = 0; i <= (allP.size() / 5); ++i) {
                    if (((page - 1) == i)) {
                        listP = dao.sortProductDescByPrice(i * 5);
                    }
                }
                request.setAttribute("highSort", "selected");
                break;

            case "rate":
                for (int i = 0; i <= (allP.size() / 5); ++i) {
                    if (((page - 1) == i)) {
                        listP = dao.sortProductDescByRate(i * 5);
                    }
                }
                request.setAttribute("rateSort", "selected");
                break;
        }

        HttpSession session = request.getSession();
        session.setAttribute("listP", listP);
        request.getRequestDispatcher("store.jsp").include(request, response);

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
