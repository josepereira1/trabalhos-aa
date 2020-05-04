/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import aa.GMS;
import aa.Game;
import aa.IGMS;
import aa.UserNotExistsException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.orm.PersistentException;

/**
 *
 * @author Ricardo Petronilho
 */
@WebServlet(name = "AllGames", urlPatterns = {"/AllGames"})
public class AllGames extends HttpServlet {
    
    private void displayAllGames(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IGMS gms = GMS.getGMS();
        try {
            Collection<Game> games = gms.getAllGames();
            request.setAttribute("games", games);
            request.getRequestDispatcher("/WEB-INF/allGames.jsp").forward(request, response);
        } catch (PersistentException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        displayAllGames(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
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
