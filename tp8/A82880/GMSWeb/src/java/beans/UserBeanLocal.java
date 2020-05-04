/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.security.NoSuchAlgorithmException;
import javax.ejb.Local;
import org.orm.PersistentException;
import pt.uminho.di.aa.InvalidParametersException;
import pt.uminho.di.aa.User;
import pt.uminho.di.aa.UserExistsException;

/**
 *
 * @author josepereira
 */
@Local
public interface UserBeanLocal {
    String sayHello(String name);
    boolean login(String name, String password) throws PersistentException, NoSuchAlgorithmException;
    void registerUser(User user) throws PersistentException, UserExistsException, NoSuchAlgorithmException, InvalidParametersException;
}
