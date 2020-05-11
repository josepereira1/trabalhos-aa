/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.orm.PersistentException;
import pt.uminho.di.aa.GMS;
import pt.uminho.di.aa.User;
import pt.uminho.di.aa.UserNotExistsException;

/**
 *
 * @author josepereira
 */
@WebService(serviceName = "UsersWithTokens")
public class UsersWithTokens {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "name") String name, @WebParam(name = "password") String password) throws PersistentException, NoSuchAlgorithmException{
        String token = null;
        if(GMS.getGMS().login(name, password)){
            token = Base64.getEncoder().encodeToString((name + ":" + password).getBytes());
            GMS.getGMS().addToken(token);    
        }   
        return token;
    }
    
    @WebMethod(operationName = "userDetails")
    public User userDetails(@WebParam(name = "token") String token, @WebParam(name = "name") String name) throws PersistentException, UserNotExistsException{
        if(GMS.getGMS().containsToken(token)){
            return GMS.getGMS().getUserDetails(name);
        }else return null;
    }
}
