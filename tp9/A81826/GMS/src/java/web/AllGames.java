/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import business.GMS;
import business.Game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.orm.PersistentException;

/**
 *
 * @author joaomarques
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
        GMS gms = GMS.getGMS();
        String logout = (String) request.getParameter("logout");
        Object logged = request.getSession().getAttribute("logged");
        //Entra aqui se não estiver logado e redireciona para o login
        if(logged == null || !(boolean)logged) {
            request.getSession().setAttribute("logged",false);
            request.getRequestDispatcher("/Login").forward(request, response);
        //Entra aqui se quis fazer logout
        } else if(logout != null) {
            request.getSession().setAttribute("logged", false);
            request.getSession().setAttribute("name", null);
            request.getRequestDispatcher("/Index").forward(request, response);
        //Entra aqui nos restantes casos
        } else {
            Collection<Game> games = new ArrayList<>();
            try {
                games = gms.allGames();
            } catch (PersistentException e) {
                request.setAttribute("error","An error occured");
                e.printStackTrace();
            }
            request.setAttribute("games",games);
            request.getRequestDispatcher("/WEB-INF/allgames.jsp").forward(request,response);
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
