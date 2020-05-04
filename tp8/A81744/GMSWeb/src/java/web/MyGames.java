package web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aa.GMS;
import aa.Game;
import aa.IGMS;
import aa.UserNotExistsException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/MyGames"})
public class MyGames extends HttpServlet {
    
    private void displayUserGames(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        IGMS gms = GMS.getGMS();
        try {
            Collection<Game> games = gms.getUserGames(username);
            request.setAttribute("games", games);
            request.getRequestDispatcher("/WEB-INF/myGames.jsp").forward(request, response);
        } catch (PersistentException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
        } catch (UserNotExistsException e) {
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
        displayUserGames(request, response);
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
