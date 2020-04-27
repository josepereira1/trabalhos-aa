/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import pt.uminho.di.aa.GamemanagementPersistentManager;

/**
 *
 * @author josepereira
 */
public class ControlPersistentSession {
    //  verifica se já existe session para este user, caso exista retorna, caso contrário, cria.
    public static PersistentSession getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        PersistentSession persistentSession = (PersistentSession) session.getAttribute("session");
        
        if(persistentSession == null){
            try{
                persistentSession = GamemanagementPersistentManager.instance().getSession();
            } catch (PersistentException e){
                e.printStackTrace();
            }
                
            session.setAttribute("session", persistentSession);
        }
        return persistentSession;
    }
}
