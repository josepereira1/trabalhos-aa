/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.orm.PersistentException;
import pt.uminho.di.aa.GMS;
import pt.uminho.di.aa.Game;
import pt.uminho.di.aa.GameNotExistsException;
import pt.uminho.di.aa.InvalidParametersException;

/**
 *
 * @author josepereira
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet/*"})
public class MyServlet extends HttpServlet {

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
        response.setContentType("application/json"); // indicar que o conteúdo é json
        
        String[] url = request.getRequestURI().toString().split("/");
        String target = url[url.length-1];
        String method = request.getMethod();
        
        String data = "";   //  data/content do method POST
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> postContent = null;
       
        if(method.equals("POST") && target.equals("game")){           
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = request.getReader().readLine())!=null)sb.append(line);
            data = sb.toString();   //  body do método POST
            
            //  Convert json to Map
            postContent = mapper.readValue(data, Map.class);
            String gameName = (String) postContent.get("name");
            Game game = null;
            try {
                game = GMS.getGMS().searchGame(gameName);
            } catch (PersistentException ex) {
                Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (GameNotExistsException ex) {
                
                Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidParametersException ex) {
                Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(game != null){
                data = mapper.writeValueAsString(game);
            }else data = "";
            response.getWriter().print(data); // escrever diretamente o json em vez de encaminhar para a página
            
        }
        if((method.equals("GET") || method.equals("POST")) && target.equals("games")){
            Game[] games = null;
            try {
                games = GMS.getGMS().listAllGames();
            } catch (PersistentException ex) {
                Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(games != null){
                data = mapper.writeValueAsString(games);
            }else data = "";
            response.getWriter().print(data); // escrever diretamente o json em vez de encaminhar para a página
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
