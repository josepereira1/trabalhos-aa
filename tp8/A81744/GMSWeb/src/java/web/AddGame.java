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
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.orm.PersistentException;
import org.orm.PersistentSession;

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
        
        String action = request.getParameter("action");   
        
        // internal error (não é suposto entrar aqui)
        if (action == null) request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
        
        // para não haver problemas caso tenha introduzido a "action" com maiúsculas sem querer
        action = action.toLowerCase();
        
        // clicou no botão "Add Game" por isso adiciona o jogo ao user
        if (action.equals("addgame")) registerGame(request, response);
        
        // internal error (não é suposto entrar aqui)
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addGame.jsp").forward(request, response);
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
        
        int warningType = -1; // para saber que aviso informo ao cliente
        // 0 - não introduziu todos os campos
        // 1 - jogo introduzido não existe
        
        String gameNname = request.getParameter("gamename");
  
        if (gameNname != null && gameNname.isEmpty() == false) {
            
            IGMS gms = GMS.getGMS();
            try {
                Game game = gms.getGame(gameNname);
                String username = (String) request.getSession().getAttribute("username");
                // adicona o jogo ao user
                gms.addGameToUser(username, game);
                // encaminha para o Controller My Games
                request.getRequestDispatcher("/MyGames").forward(request, response);
            } catch (PersistentException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            } catch (UserNotExistsException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            } catch (GameNotExistsException e) {
                e.printStackTrace();
                warningType = 1; // jogo introduzido não existe
                refreshPage(request, response, warningType);
            }
        } 
        
        else warningType = 0; // não introduziu todos os campos
        
        refreshPage(request,response, warningType);
    }
    
    private void refreshPage(HttpServletRequest request, HttpServletResponse response, Integer warningType) throws ServletException, IOException {     
        Collection<Platform> platforms = null;
        try {
            platforms = GMS.getGMS().getAllPlatforms(); 
        } catch (PersistentException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
        } 
        request.setAttribute("platforms", platforms);  
        request.setAttribute("warningType", warningType);      
        request.getRequestDispatcher("/WEB-INF/addGame.jsp").forward(request, response);
    }

}
