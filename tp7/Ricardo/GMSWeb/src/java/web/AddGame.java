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
        
        String action = request.getParameter("addGameAction");   
        
        // method = GET, simplesmente apresenta a página "Add Game"
        if (action == null) refreshPage(request, response, null);
        
        // para não haver problemas caso tenha introduzido a "action" com maiúsculas sem querer
        action = action.toLowerCase();
        
        // clicou no botão "Add Game" por isso encaminha para o Controller responsável
        if (action.equals("addgame")) registerGame(request, response);
        
        // clicou no botão "My Games" por isso encaminha para o Controller responsável
        else if (action.equals("usergames")) request.getRequestDispatcher("/MyGames").forward(request, response);
        
        // clicou no botão "All Games" por isso encaminha para o Controller responsável
        else if (action.equals("allgames")) request.getRequestDispatcher("/AllGames").forward(request, response);
        
        // clicou no botão "Show Game" por isso encaminha para o Controller responsável
        else if (action.equals("showgame")) request.getRequestDispatcher("/ShowGame").forward(request, response);
        
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
        
        int warningType = -1; // para saber que aviso informo ao cliente
        // 0 - não introduziu todos os campos
        // 1 - year não tem formato de um integer
        // 2 - price não tem formato de um double
        // 3 - jogo introduzido já existe
        
        String name = request.getParameter("name");
        String yearStr = request.getParameter("year");
        String priceStr = request.getParameter("price");
        String description = request.getParameter("description");
        String platformname = request.getParameter("platformname");
        
        if (name != null && name.isEmpty() == false && description != null && description.isEmpty() == false) {
            
            int year = -1;
            try {
                year = Integer.parseInt(request.getParameter("year"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                warningType = 1;
                refreshPage(request, response, warningType);
            }
            
            double price = -1d;
            try {
                price = Double.parseDouble(request.getParameter("price"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                warningType = 2;
                refreshPage(request, response, warningType);
            }
            
            Game game = new Game();
            game.setName(name);
            game.setPrice(price);
            game.setYear(year);
            game.setDescription(name);
            
            IGMS gms = GMS.getGMS();
            try {
                // adicona a plataforma ao jogo
                Platform platform = gms.getPlatform(platformname, Login.getPersistentSession(request));
                game.platforms.add(platform);
                // adiciona o User ao jogo
                String username = (String) request.getSession().getAttribute("username");
                User user = gms.getUser(username, Login.getPersistentSession(request));
                game.users.add(user);
                // regista o jogo
                gms.registerGame(game, Login.getPersistentSession(request));
                request.setAttribute("gameName", game.getName());
                // encaminha para o Controller My Games
                request.getRequestDispatcher("/MyGames").forward(request, response);
            } catch (PersistentException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            } catch (GameAlreadyExistsException e) {
                e.printStackTrace();
                warningType = 3; // jogo introduzido já existe
                refreshPage(request, response, warningType);
            } catch (PlatformNotExistsException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            } catch (UserNotExistsException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            }
        } 
        
        else warningType = 0; // não introduziu todos os campos
        
        refreshPage(request,response, warningType);
    }
    
    private void refreshPage(HttpServletRequest request, HttpServletResponse response, Integer warningType) throws ServletException, IOException {     
        Collection<Platform> platforms = null;
        try {
            platforms = GMS.getGMS().getAllPlatforms(Login.getPersistentSession(request)); 
        } catch (PersistentException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
        } 
        request.setAttribute("platforms", platforms);  
        request.setAttribute("warningType", warningType);      
        request.getRequestDispatcher("/WEB-INF/addGame.jsp").forward(request, response);
    }

}
