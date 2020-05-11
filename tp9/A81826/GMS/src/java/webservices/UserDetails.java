/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import business.GMS;
import business.Game;
import business.GameDontExistException;
import business.User;
import business.UserDontExistException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.orm.PersistentException;

/**
 *
 * @author joaomarques
 */
@WebService(serviceName = "UserDetails")
public class UserDetails {

    private Map<String,User> users = new HashMap<>();
    /**
     * This is a sample web service operation
     * @param name
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String name) {
        return "Hello " + name + " !";
    }
    
    /*@WebMethod(operationName = "games")
    public Game[] games() {
        GMS gms = GMS.getGMS();
        try {
            Collection<Game> games = gms.allGames();
            return games.toArray(new Game[games.size()]);
        } catch (PersistentException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @WebMethod(operationName = "search")
    public Game search(@WebParam(name = "name") String name) {
        GMS gms = GMS.getGMS();
        try {
            Game game = gms.getGameByName(name);
            return game;
        } catch (PersistentException e) {
            e.printStackTrace();
            return null;
        } catch (GameDontExistException e) {
            e.printStackTrace();
            return null;
        }
    }*/
    
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) throws PersistentException, UserDontExistException {
        if(GMS.getGMS().login(username, password)) {
            this.users.put(username+password, GMS.getGMS().getUserByName(username));
            return username+password;
        }
        return null;
    }
    
    @WebMethod(operationName = "searchuser")
    public User searchuser(@WebParam(name = "token") String token) {
        return this.users.get(token);
    }
}
