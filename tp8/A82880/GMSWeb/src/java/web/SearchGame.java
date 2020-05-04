/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import pt.uminho.di.aa.GMS;
import pt.uminho.di.aa.Game;
import pt.uminho.di.aa.GameNotExistsException;
import pt.uminho.di.aa.InvalidParametersException;

/**
 *
 * @author josepereira
 */
public class SearchGame extends HttpServlet {

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
        
        String action = request.getParameter("searchGameAction");
        
        if(action == null)request.getRequestDispatcher("/WEB-INF/SearchGame.jsp").forward(request, response);
        
        action = action.toLowerCase();
        
        if(action.equals("searchgame")){
            String name = request.getParameter("name");
            GMS gms = GMS.getGMS();
            try {
                Game game = gms.searchGame(name);
                request.setAttribute("game", game);
                request.getRequestDispatcher("WEB-INF/SearchGame.jsp").forward(request, response);
            } catch (PersistentException ex) {
                Logger.getLogger(SearchGame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (GameNotExistsException ex) {
                request.setAttribute("message", "Game does not exist!");
                request.getRequestDispatcher("/WEB-INF/SearchGame.jsp").forward(request, response);
                Logger.getLogger(SearchGame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidParametersException ex) {
                request.setAttribute("message", "Invalid parameters!");
                request.getRequestDispatcher("/WEB-INF/SearchGame.jsp").forward(request, response);
                Logger.getLogger(SearchGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(action.equals("listallgames"))request.getRequestDispatcher("/ListAllGames").forward(request, response);
        if(action.equals("mygames"))request.getRequestDispatcher("/UserGames").forward(request, response);
        if(action.equals("addgame"))request.getRequestDispatcher("/AddGame").forward(request, response);
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
