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

/**
 *
 * @author josepereira
 */
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("loginAction");
        
        //  o action == null acontece na primeira vez que acede à página
        if(action == null)request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        
        else{
            action = action.toLowerCase();
            
            if(action.equals("register"))request.getRequestDispatcher("/RegisterUser").forward(request, response);
            

            if(action.equals("login")){
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                GMS gms = GMS.getGMS();
                boolean res = false;
                try {
                    res = gms.login(name, password);
                } catch (PersistentException ex) {
                    request.setAttribute("error", "PersistentException");
                    request.getRequestDispatcher("/InternalError").forward(request, response);
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    request.setAttribute("error", "NoSuchAlgorithmException");
                    request.getRequestDispatcher("/InternalError").forward(request, response);
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(res){
                    //  request.setAttribute("res", res); //  não preciso de enviar o res em caso de sucesso, foi apenas para teste
                    request.getSession().setAttribute("logedIn", true);
                    //  guardar na session o name do user, será útil para a listagem dos jogos do mesmo
                    request.getSession().setAttribute("name", name);
                    request.getRequestDispatcher("/ListAllGames").forward(request, response);
                }
                else {
                    request.setAttribute("res", res);
                    request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("error", "Internal error!");
                request.getRequestDispatcher("/InternalError.jsp").forward(request, response);
            }
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
