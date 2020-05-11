/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.orm.PersistentException;
import pt.uminho.di.aa.GMS;
import pt.uminho.di.aa.Game;
import pt.uminho.di.aa.GameNotExistsException;
import pt.uminho.di.aa.InvalidParametersException;
import pt.uminho.di.aa.User;
import pt.uminho.di.aa.UserNotExistsException;

/**
 *
 * @author josepereira
 */
@WebService(serviceName = "Games")
public class Games {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "listGames")
    public Game[] listGames() throws PersistentException{
        return GMS.getGMS().listAllGames();
    }
    
    @WebMethod(operationName = "searchGame")
    public Game searchGame(@WebParam(name = "name") String name) throws PersistentException, GameNotExistsException, InvalidParametersException{
        return GMS.getGMS().searchGame(name);
    }
    
    /*@WebMethod(operationName = "userDetails")
    public User userDetails(@WebParam(name = "name") String name, @WebParam(name = "password") String password){
        try {
            if(GMS.getGMS().login(name, password)){
                return GMS.getGMS().getUserDetails(name);
            }else return null;
        } catch (PersistentException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (UserNotExistsException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }*/
}
