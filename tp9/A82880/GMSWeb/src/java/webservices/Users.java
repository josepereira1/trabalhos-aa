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
import pt.uminho.di.aa.User;
import pt.uminho.di.aa.UserNotExistsException;

/**
 *
 * @author josepereira
 */
@WebService(serviceName = "Users")
public class Users {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "userDetails")
    public User userDetails(@WebParam(name = "name") String name, @WebParam(name = "password") String password) throws PersistentException, UserNotExistsException{
        return GMS.getGMS().getUserDetails(name);   
    }
}
