/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import business.Checksum;
import business.GMS;
import business.User;
import business.UserAlreadyExistsException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>POST</code> and <code>GET</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GMS gms = GMS.getGMS();
        String action = (String) request.getParameter("actionregister");
        Object logged = request.getSession().getAttribute("logged");
        //Se já estiver logado redireciona para os seus jogos
        if(logged != null || (boolean)logged) {
            request.getRequestDispatcher("/MyGames").forward(request, response);
        //Entra aqui se tentou fazer o registo
        } else if(action != null) {
            register(request,response,gms);
        //Entra aqui nos restantes casos
        } else {
            request.getSession().setAttribute("logged",false);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
    
    private void register(HttpServletRequest request, HttpServletResponse response, GMS gms) throws ServletException, IOException {
        User user = new User();
        try {
            user.setEmail(request.getParameter("email"));
            user.setName(request.getParameter("name"));
            user.setPassword(Checksum.getFileChecksum(request.getParameter("password").getBytes(),MessageDigest.getInstance("sha-256")));
            gms.registerUser(user);
            request.getSession().setAttribute("name",user.getName());
            request.getSession().setAttribute("logged",true);
            request.getRequestDispatcher("/MyGames").forward(request,response);
        } catch(NoSuchAlgorithmException | PersistentException e) {
            e.printStackTrace();
            request.setAttribute("error", "An error ocured");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
        } catch(UserAlreadyExistsException e) {
            e.printStackTrace();
            request.setAttribute("error", "User already registered");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
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
