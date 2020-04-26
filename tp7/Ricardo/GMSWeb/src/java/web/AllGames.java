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
        
        // por questões de segurança caso não tenha feito Login encaminhar para o Login
        Boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");
        if (loggedIn == null || loggedIn == false) request.getRequestDispatcher("/Login").forward(request, response);
        
        String action = request.getParameter("allGamesAction");   
        
        // method = GET, simplesmente apresenta a página "All Games"
        if (action == null) displayAllGames(request, response);
        
        // para não haver problemas caso tenha introduzido a "action" com maiúsculas sem querer
        action = action.toLowerCase();
        
        // clicou no botão "My Games" por isso encaminha para o Controller responsável
        if (action.equals("usergames")) request.getRequestDispatcher("/MyGames").forward(request, response);
        
        // clicou no botão "Add Game" por isso encaminha para o Controller responsável
        else if (action.equals("addgame")) request.getRequestDispatcher("/AddGame").forward(request, response);
        
        // clicou no botão "Show Game" por isso encaminha para o Controller responsável
        else if (action.equals("showgame")) request.getRequestDispatcher("/ShowGame").forward(request, response);
        
        // internal error (não é suposto entrar aqui)
        else request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
    }
    
    private void displayAllGames(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IGMS gms = GMS.getGMS();
        try {
            Collection<Game> games = gms.getAllGames(Login.getPersistentSession(request));
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
