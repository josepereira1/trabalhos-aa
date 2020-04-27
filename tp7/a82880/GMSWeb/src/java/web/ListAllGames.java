/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import pt.uminho.di.aa.GMS;
import pt.uminho.di.aa.Game;
import pt.uminho.di.aa.GamemanagementPersistentManager;

/**
 *
 * @author josepereira
 */
public class ListAllGames extends HttpServlet {

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
        
        Boolean logedIn = (Boolean) request.getSession().getAttribute("logedIn");
        if(logedIn == null || logedIn == false)request.getRequestDispatcher("/Login").forward(request, response);

        //  ControlPersistentSession é um classe minha onde verifico se já existe session
        PersistentSession persistentSession = ControlPersistentSession.getSession(request);
        
        String action = request.getParameter("actionListAllGames");
        
        if(action == null){
            GMS gms = GMS.getGMS();
        
            List<Game> games = new ArrayList();

            try {
                for(Game g : gms.listAllGames(persistentSession))games.add(g);
            } catch (PersistentException ex) {
                Logger.getLogger(ListAllGames.class.getName()).log(Level.SEVERE, null, ex);
            }


            request.setAttribute("games", games);

            request.getRequestDispatcher("/WEB-INF/ListAllGames.jsp").forward(request, response);
        }
        
        action = action.toLowerCase();
        
        if(action.equals("mygames"))request.getRequestDispatcher("/UserGames").forward(request, response);
        if(action.equals("addgame"))request.getRequestDispatcher("/AddGame").forward(request, response);
        if(action.equals("searchgame"))request.getRequestDispatcher("/SearchGame").forward(request, response);
        if(action.equals("logout")){
            request.getSession().setAttribute("logedIn", false);
            request.getSession().setAttribute("name", null);
            request.getRequestDispatcher("/Login").forward(request, response);
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
