/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import aa.Checksum;
import aa.GMS;
import aa.GMSPersistentManager;
import aa.IGMS;
import aa.User;
import aa.UserAlreadyExistsException;
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
import javax.servlet.http.HttpSession;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author Ricardo Petronilho
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

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
        
        String action = request.getParameter("action");      
        
        // internal error (não é suposto entrar aqui)
        if (action == null) request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
        
        // para não haver problemas caso tenha introduzido a "action" com maiúsculas sem querer
        action = action.toLowerCase(); 
        
        // clicou no botão "Register"
        if (action.equals("register")) register(request, response);
        
        // internal error (não é suposto entrar aqui)
        else request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
    }
    
    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        int warningType = -1; // para saber que aviso informo ao cliente
        // 0 - não introduziu todos os campos
        // 1 - username introduzido já está em uso
        
        if (username != null && username.isEmpty() == false && email != null && email.isEmpty() == false && password != null && password.isEmpty() == false) {
            
            User user = new User();
            user.setName(username);
            user.setEmail(email);
            // obtém a password encriptada
            try {
                String hashedPassword = Checksum.getFileChecksum(password.getBytes(), MessageDigest.getInstance("SHA-256"));
                user.setPassword(hashedPassword);       
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            }
            IGMS gms = GMS.getGMS();
            try {
                gms.registerUser(user);
                // se chegar a esta linha é porque teve sucesso (caso contrário entrava na exceção)
                // guarda o estado de login e username na sessão do cliente   
                request.getSession().setAttribute("loggedIn", true);  
                request.getSession().setAttribute("username", username);
                // Post/Redirect/Get pattern por isso tenho de usar o response.sendRedirect()
                response.sendRedirect(request.getContextPath() + "/MyGames");
            } catch (PersistentException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            } catch (UserAlreadyExistsException e) {
                e.printStackTrace();
                warningType = 1; // username já em uso
                refreshPage(request, response, warningType);
            }
        }
        
        else warningType = 0; // não introduziu todos os campos
        
        // se chegar a esta linha é porque NÃO teve sucesso (caso contrário tinha sido redirecionado antes para a página "My Games")
        refreshPage(request, response, warningType);
    }
    
    private void refreshPage(HttpServletRequest request, HttpServletResponse response, int warningType) throws ServletException, IOException {
        request.setAttribute("warningType", warningType);      
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
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
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
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
