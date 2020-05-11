/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
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
import pt.uminho.di.aa.GamemanagementPersistentManager;
import pt.uminho.di.aa.InvalidParametersException;
import pt.uminho.di.aa.User;
import pt.uminho.di.aa.UserExistsException;

/**
 *
 * @author josepereira
 */
public class RegisterUser extends HttpServlet {

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
        
        
        String action = request.getParameter("registerAction");
        
        if(action == null)request.getRequestDispatcher("/WEB-INF/RegisterUser.jsp").forward(request, response);
        
        action = action.toLowerCase();
        
        if(action.equals("register")){
            String name = (String) request.getParameter("name");
            String email = (String) request.getParameter("email");
            String password = (String) request.getParameter("password");

            GMS gms = GMS.getGMS();
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            try {
                gms.registerUser(user);
            } catch (PersistentException ex) {
                Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UserExistsException ex) {
                request.setAttribute("message", "Name already exists, choose another one!");
                request.getRequestDispatcher("/WEB-INF/RegisterUser.jsp").forward(request, response);
                Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidParametersException ex) {
                request.setAttribute("message", "Invalid parameters!");
                request.getRequestDispatcher("/WEB-INF/RegisterUser.jsp").forward(request, response);
                Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("/ListAllGames").forward(request, response);
        }
        
        if(action.equals("login"))request.getRequestDispatcher("/Login").forward(request, response);
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
