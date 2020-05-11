/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import business.GMS;
import business.User;
import business.UserDontExistException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
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
@WebServlet(name = "UserDetailss", urlPatterns = {"/UserDetailss/*"})
public class UserDetailss extends HttpServlet {

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
        String[] url = request.getRequestURI().split("/");
        String method = request.getMethod();
        String target = url[url.length-1];
        System.out.println(method);
        System.out.println(target);
        
        String data = "";
        ObjectMapper mapper = new ObjectMapper();
        
        if(method.equals("POST")) {
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = request.getReader().readLine())!=null) {
                sb.append(line);
            }
            data = sb.toString();
            Map<String,Object> JSON = mapper.readValue(data, Map.class);
            try {
                if(GMS.getGMS().login((String)JSON.get("username"),(String)JSON.get("password"))) {
                    User u = GMS.getGMS().getUserByName((String)JSON.get("username"));
                    response.setContentType("application/json");
                    response.getWriter().print(new ObjectMapper().writeValueAsString(u));
                }
                else 
                    response.getWriter().print("Invalid Credentials");
            } catch (PersistentException e) {
                e.printStackTrace();
                response.getWriter().print("An internal error occured");
            } catch (UserDontExistException e) {
                e.printStackTrace();
                response.getWriter().print("User " + (String)JSON.get("username") + " dont exist");
            }
        } else {
            response.getWriter().print("Method not allowed");
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
