/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.GameDontExistException;
import business.User;
import business.UserAlreadyExistsException;
import business.UserDontExistException;
import java.util.Collection;
import javax.ejb.Local;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author joaomarques
 */
@Local
public interface UserBeanLocal {
    Collection<User> getAllUsers() throws PersistentException;
    User getUserByName(String name) throws PersistentException, UserDontExistException;
    void addGameToUser(String game, String user) throws GameDontExistException, PersistentException, UserDontExistException;
    void registerUser(User user) throws UserAlreadyExistsException, PersistentException;
}
