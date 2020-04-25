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
import javax.servlet.http.HttpSession;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author Ricardo Petronilho
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        
        String action = request.getParameter("loginAction");      
        
        // method = GET
        if (action == null) request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
        // para não haver problemas caso tenha introduzido a "action" com maiúsculas sem querer
        action = action.toLowerCase(); 
        
        // clicou no botão Register
        if (action.equals("register")) request.getRequestDispatcher("/Register").forward(request, response);        
        
        // clicou no botão Login
        else if (action.equals("login")) login(request, response);
        
        // internal error
        else request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
            
        boolean loggedIn = false;
        
        // verifica se as credenciais foram introduzidas ( != null ) e se não são vaizas ( isEmpty() != false ) 
        if (username != null && username.isEmpty() == false && password != null && password.isEmpty() == false) {
            IGMS gms = GMS.getGMS();
            try {                  
                // verifica se as credenciais são válidas
                String hashedPassword = Checksum.getFileChecksum(password.getBytes(), MessageDigest.getInstance("SHA-256"));
                loggedIn = gms.autenticateUser(username, hashedPassword, Login.getPersistentSession(request));
            } catch (PersistentException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            } catch (UserNotExistsException e) {
                // caso entre aqui não é necessário fazer nada pois a variável "loggedIn" continua a false
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            }
        }
        
        // guarda o estado de login na sessão do cliente   
        request.getSession().setAttribute("loggedIn", loggedIn);    

        // caso as credenciais introduzidas estejam corretas redireciona para a página "My Games"
        if (loggedIn) {
            // guarda o username na sessão do cliente   
            request.getSession().setAttribute("username", username);
            request.getRequestDispatcher("/UserGames").forward(request, response);
        }
        // caso as credenciais sejam inválidas redireciona para a mesma página informando de insucesso
        else request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    public static PersistentSession getPersistentSession(HttpServletRequest request) throws PersistentException {
        HttpSession httpSession = request.getSession(); // sessão do cliente       
        PersistentSession persistentSession = (PersistentSession) httpSession.getAttribute("ps");       
        if (persistentSession == null) { // caso não exista cria uma nova               
            persistentSession = GMSPersistentManager.instance().getSession();
            httpSession.setAttribute("ps", persistentSession);              
        }
        return persistentSession;
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
