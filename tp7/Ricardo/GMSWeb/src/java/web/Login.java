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
        
        // method = GET, simplesmente apresenta a página de login
        if (action == null) request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
        // para não haver problemas caso tenha introduzido a "action" com maiúsculas sem querer
        action = action.toLowerCase(); 
        
        // clicou no botão "Register" por isso encaminha para o Controller responsável
        if (action.equals("register")) request.getRequestDispatcher("/Register").forward(request, response);        
        
        // clicou no botão "Login"
        else if (action.equals("login")) login(request, response);
        
        // internal error (não é suposto entrar aqui)
        else request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
            
        boolean loggedIn = false;
        
        int warningType = -1; // para saber que aviso informo ao cliente
        // 0 - não introduziu todos os campos
        // 1 - credenciais inválidas (username introduzido não existe)
        // 2 - credenciais inválidas (password errada)
        
        if (username != null && username.isEmpty() == false && password != null && password.isEmpty() == false) {
            IGMS gms = GMS.getGMS();
            try {
                // obtém a password encriptada
                String hashedPassword = Checksum.getFileChecksum(password.getBytes(), MessageDigest.getInstance("SHA-256"));
                // verifica se as credenciais são válidas
                loggedIn = gms.autenticateUser(username, hashedPassword, Login.getPersistentSession(request));
                if (loggedIn == false) warningType = 2; // 2 - credenciais inválidas (password errada)
            } catch (PersistentException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            } catch (UserNotExistsException e) {
                warningType = 1; // credenciais inválidas (username introduzido não existe)
                loggedIn = false; 
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            }
        } 
        
        else warningType = 0; // não introduziu todos os campos
        
        // guarda o estado de login na sessão do cliente   
        request.getSession().setAttribute("loggedIn", loggedIn);    

        // caso as credenciais introduzidas estejam corretas redireciona para a página "My Games"
        if (loggedIn) {
            // guarda o username na sessão do cliente   
            request.getSession().setAttribute("username", username);
            request.getRequestDispatcher("/MyGames").forward(request, response);
        }        
        // caso as credenciais sejam inválidas redireciona para a mesma página informando o cliente de insucesso
        else {
            request.setAttribute("warningType", warningType);   
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
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
