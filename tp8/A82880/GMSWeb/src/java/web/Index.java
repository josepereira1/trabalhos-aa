/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import pt.uminho.di.aa.Game;
import pt.uminho.di.aa.GamemanagementPersistentManager;

/**
 *
 * @author josepereira
 */
public class Index extends HttpServlet {

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
        
        /*
        Object obj = "hello";
        request.setAttribute("obj", obj);
        */
            
        //request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            
        //  -------------------------------------------------------------------
            
        /*    
        Game g = new Game();
        g.setName("GTA V");
        g.setDescription("Description of the game here!");
        g.setPrice(22);
        g.setYear(2012);
            
        request.setAttribute("game", g);
        */
            
            
        //  -------------------------------------------------------------------
            
            
        /*
        String userAgent = request.getHeader("user-agent");
        request.setAttribute("userAgent", userAgent);
        */
            
            
        //  -------------------------------------------------------------------
            
        /*
        boolean sessionCreated = false;
            
        HttpSession session = request.getSession();
        PersistentSession persistentSession = (PersistentSession) session.getAttribute("session");
        */
            
        /*
        if(persistentSession == null){
            sessionCreated = true;  //  
            try{
                persistentSession = GamemanagementPersistentManager.instance().getSession();
            } catch (PersistentException e){
                e.printStackTrace();
            }
                
            session.setAttribute("session", persistentSession);
        }
            
        //  para verificar se está a reutilizar sessions
        request.setAttribute("sessionCreated", sessionCreated);
        
        */
            
        //request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
