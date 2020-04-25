/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import aa.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@WebServlet(name = "AddGame", urlPatterns = {"/AddGame"})
public class AddGame extends HttpServlet {

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
        
        String action = request.getParameter("addGameAction");   
        
        // method = GET
        if (action == null) request.getRequestDispatcher("/WEB-INF/addGame.jsp").forward(request, response);
        
        // para não haver problemas caso tenha introduzido a "action" com maiúsculas sem querer
        action = action.toLowerCase();
        
        // clicou no botão "Add Game"
        if (action.equals("addgame")) registerGame(request, response);
        
        // clicou no botão "My Games"
        else if (action.equals("usergames")) request.getRequestDispatcher("/UserGames").forward(request, response);
        
        // clicou no botão "All Games"
        else if (action.equals("allgames")) request.getRequestDispatcher("/AllGames").forward(request, response);
        
        // internal error
        else request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
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

    private void registerGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        
        if (name != null && name.isEmpty() == false && description != null && description.isEmpty() == false) {
            
            Game game = new Game();
            game.setName(name);
            game.setPrice(price);
            game.setYear(year);
            game.setDescription(name);
            IGMS gms = GMS.getGMS();
            try {
                gms.registerGame(game, Login.getPersistentSession(request));
                request.setAttribute("gameName", game.getName());
                request.getRequestDispatcher("/ShowGame").forward(request, response);
            } catch (PersistentException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            } catch (GameAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        
        request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
    }

}
